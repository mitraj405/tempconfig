package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class AsyncTimeout extends Timeout {
    private static final long IDLE_TIMEOUT_MILLIS;
    private static final long IDLE_TIMEOUT_NANOS;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    static AsyncTimeout head;
    private boolean inQueue;
    private AsyncTimeout next;
    private long timeoutAt;

    public class a implements Sink {

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ Sink f5621a;

        public a(Sink sink) {
            this.f5621a = sink;
        }

        public final void close() throws IOException {
            AsyncTimeout asyncTimeout = AsyncTimeout.this;
            asyncTimeout.enter();
            try {
                this.f5621a.close();
                asyncTimeout.exit(true);
            } catch (IOException e) {
                throw asyncTimeout.exit(e);
            } catch (Throwable th) {
                asyncTimeout.exit(false);
                throw th;
            }
        }

        public final void flush() throws IOException {
            AsyncTimeout asyncTimeout = AsyncTimeout.this;
            asyncTimeout.enter();
            try {
                this.f5621a.flush();
                asyncTimeout.exit(true);
            } catch (IOException e) {
                throw asyncTimeout.exit(e);
            } catch (Throwable th) {
                asyncTimeout.exit(false);
                throw th;
            }
        }

        public final Timeout timeout() {
            return AsyncTimeout.this;
        }

        public final String toString() {
            return "AsyncTimeout.sink(" + this.f5621a + ")";
        }

        public final void write(Buffer buffer, long j) throws IOException {
            C0663RB.a(buffer.f5623a, 0, j);
            while (true) {
                long j2 = 0;
                if (j > 0) {
                    Ov ov = buffer.f5624a;
                    while (true) {
                        if (j2 >= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                            break;
                        }
                        j2 += (long) (ov.b - ov.a);
                        if (j2 >= j) {
                            j2 = j;
                            break;
                        }
                        ov = ov.f3743a;
                    }
                    AsyncTimeout asyncTimeout = AsyncTimeout.this;
                    asyncTimeout.enter();
                    try {
                        this.f5621a.write(buffer, j2);
                        j -= j2;
                        asyncTimeout.exit(true);
                    } catch (IOException e) {
                        throw asyncTimeout.exit(e);
                    } catch (Throwable th) {
                        asyncTimeout.exit(false);
                        throw th;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public class b implements Source {

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ Source f5622a;

        public b(Source source) {
            this.f5622a = source;
        }

        public final void close() throws IOException {
            AsyncTimeout asyncTimeout = AsyncTimeout.this;
            asyncTimeout.enter();
            try {
                this.f5622a.close();
                asyncTimeout.exit(true);
            } catch (IOException e) {
                throw asyncTimeout.exit(e);
            } catch (Throwable th) {
                asyncTimeout.exit(false);
                throw th;
            }
        }

        public final long read(Buffer buffer, long j) throws IOException {
            AsyncTimeout asyncTimeout = AsyncTimeout.this;
            asyncTimeout.enter();
            try {
                long read = this.f5622a.read(buffer, j);
                asyncTimeout.exit(true);
                return read;
            } catch (IOException e) {
                throw asyncTimeout.exit(e);
            } catch (Throwable th) {
                asyncTimeout.exit(false);
                throw th;
            }
        }

        public final Timeout timeout() {
            return AsyncTimeout.this;
        }

        public final String toString() {
            return "AsyncTimeout.source(" + this.f5622a + ")";
        }
    }

    public static final class c extends Thread {
        public c() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r1.timedOut();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r3 = this;
            L_0x0000:
                java.lang.Class<okio.AsyncTimeout> r0 = okio.AsyncTimeout.class
                monitor-enter(r0)     // Catch:{ InterruptedException -> 0x0000 }
                okio.AsyncTimeout r1 = okio.AsyncTimeout.awaitTimeout()     // Catch:{ all -> 0x0019 }
                if (r1 != 0) goto L_0x000b
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                goto L_0x0000
            L_0x000b:
                okio.AsyncTimeout r2 = okio.AsyncTimeout.head     // Catch:{ all -> 0x0019 }
                if (r1 != r2) goto L_0x0014
                r1 = 0
                okio.AsyncTimeout.head = r1     // Catch:{ all -> 0x0019 }
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                return
            L_0x0014:
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                r1.timedOut()     // Catch:{ InterruptedException -> 0x0000 }
                goto L_0x0000
            L_0x0019:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                throw r1     // Catch:{ InterruptedException -> 0x0000 }
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.AsyncTimeout.c.run():void");
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public static AsyncTimeout awaitTimeout() throws InterruptedException {
        AsyncTimeout asyncTimeout = head.next;
        Class<AsyncTimeout> cls = AsyncTimeout.class;
        if (asyncTimeout == null) {
            long nanoTime = System.nanoTime();
            cls.wait(IDLE_TIMEOUT_MILLIS);
            if (head.next != null || System.nanoTime() - nanoTime < IDLE_TIMEOUT_NANOS) {
                return null;
            }
            return head;
        }
        long remainingNanos = asyncTimeout.remainingNanos(System.nanoTime());
        if (remainingNanos > 0) {
            long j = remainingNanos / 1000000;
            cls.wait(j, (int) (remainingNanos - (1000000 * j)));
            return null;
        }
        head.next = asyncTimeout.next;
        asyncTimeout.next = null;
        return asyncTimeout;
    }

    private static synchronized boolean cancelScheduledTimeout(AsyncTimeout asyncTimeout) {
        synchronized (AsyncTimeout.class) {
            AsyncTimeout asyncTimeout2 = head;
            while (asyncTimeout2 != null) {
                AsyncTimeout asyncTimeout3 = asyncTimeout2.next;
                if (asyncTimeout3 == asyncTimeout) {
                    asyncTimeout2.next = asyncTimeout.next;
                    asyncTimeout.next = null;
                    return false;
                }
                asyncTimeout2 = asyncTimeout3;
            }
            return true;
        }
    }

    private long remainingNanos(long j) {
        return this.timeoutAt - j;
    }

    private static synchronized void scheduleTimeout(AsyncTimeout asyncTimeout, long j, boolean z) {
        synchronized (AsyncTimeout.class) {
            if (head == null) {
                head = new AsyncTimeout();
                new c().start();
            }
            long nanoTime = System.nanoTime();
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i != 0 && z) {
                asyncTimeout.timeoutAt = Math.min(j, asyncTimeout.deadlineNanoTime() - nanoTime) + nanoTime;
            } else if (i != 0) {
                asyncTimeout.timeoutAt = j + nanoTime;
            } else if (z) {
                asyncTimeout.timeoutAt = asyncTimeout.deadlineNanoTime();
            } else {
                throw new AssertionError();
            }
            long remainingNanos = asyncTimeout.remainingNanos(nanoTime);
            AsyncTimeout asyncTimeout2 = head;
            while (true) {
                AsyncTimeout asyncTimeout3 = asyncTimeout2.next;
                if (asyncTimeout3 == null) {
                    break;
                } else if (remainingNanos < asyncTimeout3.remainingNanos(nanoTime)) {
                    break;
                } else {
                    asyncTimeout2 = asyncTimeout2.next;
                }
            }
            asyncTimeout.next = asyncTimeout2.next;
            asyncTimeout2.next = asyncTimeout;
            if (asyncTimeout2 == head) {
                AsyncTimeout.class.notify();
            }
        }
    }

    public final void enter() {
        if (!this.inQueue) {
            long timeoutNanos = timeoutNanos();
            boolean hasDeadline = hasDeadline();
            if (timeoutNanos != 0 || hasDeadline) {
                this.inQueue = true;
                scheduleTimeout(this, timeoutNanos, hasDeadline);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    public final boolean exit() {
        if (!this.inQueue) {
            return false;
        }
        this.inQueue = false;
        return cancelScheduledTimeout(this);
    }

    public IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final Sink sink(Sink sink) {
        return new a(sink);
    }

    public final Source source(Source source) {
        return new b(source);
    }

    public final void exit(boolean z) throws IOException {
        if (exit() && z) {
            throw newTimeoutException((IOException) null);
        }
    }

    public final IOException exit(IOException iOException) throws IOException {
        if (!exit()) {
            return iOException;
        }
        return newTimeoutException(iOException);
    }

    public void timedOut() {
    }
}
