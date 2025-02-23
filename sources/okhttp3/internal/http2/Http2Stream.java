package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class Http2Stream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    long bytesLeftInWriteWindow;
    final Http2Connection connection;
    ErrorCode errorCode;
    IOException errorException;
    private boolean hasResponseHeaders;
    private final Deque<Headers> headersQueue;
    final int id;
    final StreamTimeout readTimeout;
    final FramingSink sink;
    private final FramingSource source;
    long unacknowledgedBytesRead = 0;
    final StreamTimeout writeTimeout;

    public final class FramingSink implements Sink {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final long EMIT_BUFFER_SIZE = 16384;
        boolean closed;
        boolean finished;
        private final Buffer sendBuffer = new Buffer();
        /* access modifiers changed from: private */
        public Headers trailers;

        public FramingSink() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            r1.writeTimeout.exitAndThrowIfTimedOut();
            r11.this$0.checkOutNotClosed();
            r9 = java.lang.Math.min(r11.this$0.bytesLeftInWriteWindow, r11.sendBuffer.f5623a);
            r1 = r11.this$0;
            r1.bytesLeftInWriteWindow -= r9;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void emitFrame(boolean r12) throws java.io.IOException {
            /*
                r11 = this;
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                monitor-enter(r0)
                okhttp3.internal.http2.Http2Stream r1 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x007b }
                okhttp3.internal.http2.Http2Stream$StreamTimeout r1 = r1.writeTimeout     // Catch:{ all -> 0x007b }
                r1.enter()     // Catch:{ all -> 0x007b }
            L_0x000a:
                okhttp3.internal.http2.Http2Stream r1 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x0072 }
                long r2 = r1.bytesLeftInWriteWindow     // Catch:{ all -> 0x0072 }
                r4 = 0
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 > 0) goto L_0x0024
                boolean r2 = r11.finished     // Catch:{ all -> 0x0072 }
                if (r2 != 0) goto L_0x0024
                boolean r2 = r11.closed     // Catch:{ all -> 0x0072 }
                if (r2 != 0) goto L_0x0024
                okhttp3.internal.http2.ErrorCode r2 = r1.errorCode     // Catch:{ all -> 0x0072 }
                if (r2 != 0) goto L_0x0024
                r1.waitForIo()     // Catch:{ all -> 0x0072 }
                goto L_0x000a
            L_0x0024:
                okhttp3.internal.http2.Http2Stream$StreamTimeout r1 = r1.writeTimeout     // Catch:{ all -> 0x007b }
                r1.exitAndThrowIfTimedOut()     // Catch:{ all -> 0x007b }
                okhttp3.internal.http2.Http2Stream r1 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x007b }
                r1.checkOutNotClosed()     // Catch:{ all -> 0x007b }
                okhttp3.internal.http2.Http2Stream r1 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x007b }
                long r1 = r1.bytesLeftInWriteWindow     // Catch:{ all -> 0x007b }
                okio.Buffer r3 = r11.sendBuffer     // Catch:{ all -> 0x007b }
                long r3 = r3.f5623a     // Catch:{ all -> 0x007b }
                long r9 = java.lang.Math.min(r1, r3)     // Catch:{ all -> 0x007b }
                okhttp3.internal.http2.Http2Stream r1 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x007b }
                long r2 = r1.bytesLeftInWriteWindow     // Catch:{ all -> 0x007b }
                long r2 = r2 - r9
                r1.bytesLeftInWriteWindow = r2     // Catch:{ all -> 0x007b }
                monitor-exit(r0)     // Catch:{ all -> 0x007b }
                okhttp3.internal.http2.Http2Stream$StreamTimeout r0 = r1.writeTimeout
                r0.enter()
                if (r12 == 0) goto L_0x0055
                okio.Buffer r12 = r11.sendBuffer     // Catch:{ all -> 0x0053 }
                long r0 = r12.f5623a     // Catch:{ all -> 0x0053 }
                int r12 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r12 != 0) goto L_0x0055
                r12 = 1
                goto L_0x0056
            L_0x0053:
                r12 = move-exception
                goto L_0x006a
            L_0x0055:
                r12 = 0
            L_0x0056:
                r7 = r12
                okhttp3.internal.http2.Http2Stream r12 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x0053 }
                okhttp3.internal.http2.Http2Connection r5 = r12.connection     // Catch:{ all -> 0x0053 }
                int r6 = r12.id     // Catch:{ all -> 0x0053 }
                okio.Buffer r8 = r11.sendBuffer     // Catch:{ all -> 0x0053 }
                r5.writeData(r6, r7, r8, r9)     // Catch:{ all -> 0x0053 }
                okhttp3.internal.http2.Http2Stream r12 = okhttp3.internal.http2.Http2Stream.this
                okhttp3.internal.http2.Http2Stream$StreamTimeout r12 = r12.writeTimeout
                r12.exitAndThrowIfTimedOut()
                return
            L_0x006a:
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                okhttp3.internal.http2.Http2Stream$StreamTimeout r0 = r0.writeTimeout
                r0.exitAndThrowIfTimedOut()
                throw r12
            L_0x0072:
                r12 = move-exception
                okhttp3.internal.http2.Http2Stream r1 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x007b }
                okhttp3.internal.http2.Http2Stream$StreamTimeout r1 = r1.writeTimeout     // Catch:{ all -> 0x007b }
                r1.exitAndThrowIfTimedOut()     // Catch:{ all -> 0x007b }
                throw r12     // Catch:{ all -> 0x007b }
            L_0x007b:
                r12 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x007b }
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.FramingSink.emitFrame(boolean):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
            if (r13.sendBuffer.f5623a <= 0) goto L_0x0020;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
            r1 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
            r1 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
            if (r13.trailers == null) goto L_0x0027;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
            r4 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0027, code lost:
            r4 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0028, code lost:
            if (r4 == false) goto L_0x0046;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0030, code lost:
            if (r13.sendBuffer.f5623a <= 0) goto L_0x0036;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0032, code lost:
            emitFrame(false);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0036, code lost:
            r0 = r13.this$0;
            r0.connection.writeHeaders(r0.id, true, okhttp3.internal.Util.toHeaderBlock(r13.trailers));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0046, code lost:
            if (r1 == false) goto L_0x0054;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x004e, code lost:
            if (r13.sendBuffer.f5623a <= 0) goto L_0x005f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0050, code lost:
            emitFrame(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0054, code lost:
            r0.connection.writeData(r0.id, true, (okio.Buffer) null, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x005f, code lost:
            r1 = r13.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0061, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            r13.closed = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0064, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0065, code lost:
            r13.this$0.connection.flush();
            r13.this$0.cancelStreamIfNecessary();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0071, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x000a, code lost:
            r0 = r13.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0011, code lost:
            if (r0.sink.finished != false) goto L_0x005f;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() throws java.io.IOException {
            /*
                r13 = this;
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                monitor-enter(r0)
                boolean r1 = r13.closed     // Catch:{ all -> 0x0075 }
                if (r1 == 0) goto L_0x0009
                monitor-exit(r0)     // Catch:{ all -> 0x0075 }
                return
            L_0x0009:
                monitor-exit(r0)     // Catch:{ all -> 0x0075 }
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                okhttp3.internal.http2.Http2Stream$FramingSink r1 = r0.sink
                boolean r1 = r1.finished
                r2 = 1
                if (r1 != 0) goto L_0x005f
                okio.Buffer r1 = r13.sendBuffer
                long r3 = r1.f5623a
                r5 = 0
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                r3 = 0
                if (r1 <= 0) goto L_0x0020
                r1 = r2
                goto L_0x0021
            L_0x0020:
                r1 = r3
            L_0x0021:
                okhttp3.Headers r4 = r13.trailers
                if (r4 == 0) goto L_0x0027
                r4 = r2
                goto L_0x0028
            L_0x0027:
                r4 = r3
            L_0x0028:
                if (r4 == 0) goto L_0x0046
            L_0x002a:
                okio.Buffer r0 = r13.sendBuffer
                long r0 = r0.f5623a
                int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
                if (r0 <= 0) goto L_0x0036
                r13.emitFrame(r3)
                goto L_0x002a
            L_0x0036:
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                okhttp3.internal.http2.Http2Connection r1 = r0.connection
                int r0 = r0.id
                okhttp3.Headers r3 = r13.trailers
                java.util.List r3 = okhttp3.internal.Util.toHeaderBlock(r3)
                r1.writeHeaders(r0, r2, r3)
                goto L_0x005f
            L_0x0046:
                if (r1 == 0) goto L_0x0054
            L_0x0048:
                okio.Buffer r0 = r13.sendBuffer
                long r0 = r0.f5623a
                int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
                if (r0 <= 0) goto L_0x005f
                r13.emitFrame(r2)
                goto L_0x0048
            L_0x0054:
                okhttp3.internal.http2.Http2Connection r7 = r0.connection
                int r8 = r0.id
                r9 = 1
                r10 = 0
                r11 = 0
                r7.writeData(r8, r9, r10, r11)
            L_0x005f:
                okhttp3.internal.http2.Http2Stream r1 = okhttp3.internal.http2.Http2Stream.this
                monitor-enter(r1)
                r13.closed = r2     // Catch:{ all -> 0x0072 }
                monitor-exit(r1)     // Catch:{ all -> 0x0072 }
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                okhttp3.internal.http2.Http2Connection r0 = r0.connection
                r0.flush()
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                r0.cancelStreamIfNecessary()
                return
            L_0x0072:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0072 }
                throw r0
            L_0x0075:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0075 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.FramingSink.close():void");
        }

        public void flush() throws IOException {
            synchronized (Http2Stream.this) {
                Http2Stream.this.checkOutNotClosed();
            }
            while (this.sendBuffer.f5623a > 0) {
                emitFrame(false);
                Http2Stream.this.connection.flush();
            }
        }

        public Timeout timeout() {
            return Http2Stream.this.writeTimeout;
        }

        public void write(Buffer buffer, long j) throws IOException {
            this.sendBuffer.write(buffer, j);
            while (this.sendBuffer.f5623a >= 16384) {
                emitFrame(false);
            }
        }
    }

    public final class FramingSource implements Source {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        boolean closed;
        boolean finished;
        private final long maxByteCount;
        /* access modifiers changed from: private */
        public final Buffer readBuffer = new Buffer();
        /* access modifiers changed from: private */
        public final Buffer receiveBuffer = new Buffer();
        /* access modifiers changed from: private */
        public Headers trailers;

        public FramingSource(long j) {
            this.maxByteCount = j;
        }

        private void updateConnectionFlowControl(long j) {
            Http2Stream.this.connection.updateConnectionFlowControl(j);
        }

        public void close() throws IOException {
            long j;
            synchronized (Http2Stream.this) {
                this.closed = true;
                Buffer buffer = this.readBuffer;
                j = buffer.f5623a;
                buffer.a();
                Http2Stream.this.notifyAll();
            }
            if (j > 0) {
                updateConnectionFlowControl(j);
            }
            Http2Stream.this.cancelStreamIfNecessary();
        }

        public long read(Buffer buffer, long j) throws IOException {
            Throwable th;
            long read;
            if (j >= 0) {
                while (true) {
                    synchronized (Http2Stream.this) {
                        Http2Stream.this.readTimeout.enter();
                        try {
                            Http2Stream http2Stream = Http2Stream.this;
                            if (http2Stream.errorCode != null) {
                                th = http2Stream.errorException;
                                if (th == null) {
                                    th = new StreamResetException(Http2Stream.this.errorCode);
                                }
                            } else {
                                th = null;
                            }
                            if (!this.closed) {
                                Buffer buffer2 = this.readBuffer;
                                long j2 = buffer2.f5623a;
                                if (j2 > 0) {
                                    read = buffer2.read(buffer, Math.min(j, j2));
                                    Http2Stream http2Stream2 = Http2Stream.this;
                                    long j3 = http2Stream2.unacknowledgedBytesRead + read;
                                    http2Stream2.unacknowledgedBytesRead = j3;
                                    if (th == null && j3 >= ((long) (http2Stream2.connection.okHttpSettings.getInitialWindowSize() / 2))) {
                                        Http2Stream http2Stream3 = Http2Stream.this;
                                        http2Stream3.connection.writeWindowUpdateLater(http2Stream3.id, http2Stream3.unacknowledgedBytesRead);
                                        Http2Stream.this.unacknowledgedBytesRead = 0;
                                    }
                                } else if (this.finished || th != null) {
                                    read = -1;
                                } else {
                                    Http2Stream.this.waitForIo();
                                }
                            } else {
                                throw new IOException("stream closed");
                            }
                        } finally {
                            Http2Stream.this.readTimeout.exitAndThrowIfTimedOut();
                        }
                    }
                }
                Http2Stream.this.readTimeout.exitAndThrowIfTimedOut();
                if (read != -1) {
                    updateConnectionFlowControl(read);
                    return read;
                } else if (th == null) {
                    return -1;
                } else {
                    throw th;
                }
            } else {
                throw new IllegalArgumentException(C0709Uj.h("byteCount < 0: ", j));
            }
        }

        public void receive(BufferedSource bufferedSource, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            long j2;
            while (j > 0) {
                synchronized (Http2Stream.this) {
                    z = this.finished;
                    z2 = true;
                    if (this.readBuffer.f5623a + j > this.maxByteCount) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                }
                if (z3) {
                    bufferedSource.d0(j);
                    Http2Stream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    bufferedSource.d0(j);
                    return;
                } else {
                    long read = bufferedSource.read(this.receiveBuffer, j);
                    if (read != -1) {
                        j -= read;
                        synchronized (Http2Stream.this) {
                            if (this.closed) {
                                Buffer buffer = this.receiveBuffer;
                                j2 = buffer.f5623a;
                                buffer.a();
                            } else {
                                Buffer buffer2 = this.readBuffer;
                                if (buffer2.f5623a != 0) {
                                    z2 = false;
                                }
                                buffer2.T(this.receiveBuffer);
                                if (z2) {
                                    Http2Stream.this.notifyAll();
                                }
                                j2 = 0;
                            }
                        }
                        if (j2 > 0) {
                            updateConnectionFlowControl(j2);
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
        }

        public Timeout timeout() {
            return Http2Stream.this.readTimeout;
        }
    }

    public class StreamTimeout extends AsyncTimeout {
        public StreamTimeout() {
        }

        public void exitAndThrowIfTimedOut() throws IOException {
            if (exit()) {
                throw newTimeoutException((IOException) null);
            }
        }

        public IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        public void timedOut() {
            Http2Stream.this.closeLater(ErrorCode.CANCEL);
            Http2Stream.this.connection.sendDegradedPingLater();
        }
    }

    public Http2Stream(int i, Http2Connection http2Connection, boolean z, boolean z2, Headers headers) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.headersQueue = arrayDeque;
        this.readTimeout = new StreamTimeout();
        this.writeTimeout = new StreamTimeout();
        if (http2Connection != null) {
            this.id = i;
            this.connection = http2Connection;
            this.bytesLeftInWriteWindow = (long) http2Connection.peerSettings.getInitialWindowSize();
            FramingSource framingSource = new FramingSource((long) http2Connection.okHttpSettings.getInitialWindowSize());
            this.source = framingSource;
            FramingSink framingSink = new FramingSink();
            this.sink = framingSink;
            framingSource.finished = z2;
            framingSink.finished = z;
            if (headers != null) {
                arrayDeque.add(headers);
            }
            if (isLocallyInitiated() && headers != null) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            } else if (!isLocallyInitiated() && headers == null) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
        } else {
            throw new NullPointerException("connection == null");
        }
    }

    private boolean closeInternal(ErrorCode errorCode2, IOException iOException) {
        synchronized (this) {
            if (this.errorCode != null) {
                return false;
            }
            if (this.source.finished && this.sink.finished) {
                return false;
            }
            this.errorCode = errorCode2;
            this.errorException = iOException;
            notifyAll();
            this.connection.removeStream(this.id);
            return true;
        }
    }

    public void addBytesToWriteWindow(long j) {
        this.bytesLeftInWriteWindow += j;
        if (j > 0) {
            notifyAll();
        }
    }

    public void cancelStreamIfNecessary() throws IOException {
        boolean z;
        boolean isOpen;
        synchronized (this) {
            FramingSource framingSource = this.source;
            if (!framingSource.finished && framingSource.closed) {
                FramingSink framingSink = this.sink;
                if (framingSink.finished || framingSink.closed) {
                    z = true;
                    isOpen = isOpen();
                }
            }
            z = false;
            isOpen = isOpen();
        }
        if (z) {
            close(ErrorCode.CANCEL, (IOException) null);
        } else if (!isOpen) {
            this.connection.removeStream(this.id);
        }
    }

    public void checkOutNotClosed() throws IOException {
        FramingSink framingSink = this.sink;
        if (framingSink.closed) {
            throw new IOException("stream closed");
        } else if (framingSink.finished) {
            throw new IOException("stream finished");
        } else if (this.errorCode != null) {
            Throwable th = this.errorException;
            if (th == null) {
                th = new StreamResetException(this.errorCode);
            }
            throw th;
        }
    }

    public void close(ErrorCode errorCode2, IOException iOException) throws IOException {
        if (closeInternal(errorCode2, iOException)) {
            this.connection.writeSynReset(this.id, errorCode2);
        }
    }

    public void closeLater(ErrorCode errorCode2) {
        if (closeInternal(errorCode2, (IOException) null)) {
            this.connection.writeSynResetLater(this.id, errorCode2);
        }
    }

    public void enqueueTrailers(Headers headers) {
        synchronized (this) {
            if (this.sink.finished) {
                throw new IllegalStateException("already finished");
            } else if (headers.size() != 0) {
                Headers unused = this.sink.trailers = headers;
            } else {
                throw new IllegalArgumentException("trailers.size() == 0");
            }
        }
    }

    public Http2Connection getConnection() {
        return this.connection;
    }

    public synchronized ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public int getId() {
        return this.id;
    }

    public Sink getSink() {
        synchronized (this) {
            if (!this.hasResponseHeaders) {
                if (!isLocallyInitiated()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            }
        }
        return this.sink;
    }

    public Source getSource() {
        return this.source;
    }

    public boolean isLocallyInitiated() {
        boolean z;
        if ((this.id & 1) == 1) {
            z = true;
        } else {
            z = false;
        }
        if (this.connection.client == z) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0023, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean isOpen() {
        /*
            r3 = this;
            monitor-enter(r3)
            okhttp3.internal.http2.ErrorCode r0 = r3.errorCode     // Catch:{ all -> 0x0025 }
            r1 = 0
            if (r0 == 0) goto L_0x0008
            monitor-exit(r3)
            return r1
        L_0x0008:
            okhttp3.internal.http2.Http2Stream$FramingSource r0 = r3.source     // Catch:{ all -> 0x0025 }
            boolean r2 = r0.finished     // Catch:{ all -> 0x0025 }
            if (r2 != 0) goto L_0x0012
            boolean r0 = r0.closed     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x0022
        L_0x0012:
            okhttp3.internal.http2.Http2Stream$FramingSink r0 = r3.sink     // Catch:{ all -> 0x0025 }
            boolean r2 = r0.finished     // Catch:{ all -> 0x0025 }
            if (r2 != 0) goto L_0x001c
            boolean r0 = r0.closed     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x0022
        L_0x001c:
            boolean r0 = r3.hasResponseHeaders     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x0022
            monitor-exit(r3)
            return r1
        L_0x0022:
            monitor-exit(r3)
            r0 = 1
            return r0
        L_0x0025:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.isOpen():boolean");
    }

    public Timeout readTimeout() {
        return this.readTimeout;
    }

    public void receiveData(BufferedSource bufferedSource, int i) throws IOException {
        this.source.receive(bufferedSource, (long) i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void receiveHeaders(okhttp3.Headers r3, boolean r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.hasResponseHeaders     // Catch:{ all -> 0x002e }
            r1 = 1
            if (r0 == 0) goto L_0x000f
            if (r4 != 0) goto L_0x0009
            goto L_0x000f
        L_0x0009:
            okhttp3.internal.http2.Http2Stream$FramingSource r0 = r2.source     // Catch:{ all -> 0x002e }
            okhttp3.Headers unused = r0.trailers = r3     // Catch:{ all -> 0x002e }
            goto L_0x0016
        L_0x000f:
            r2.hasResponseHeaders = r1     // Catch:{ all -> 0x002e }
            java.util.Deque<okhttp3.Headers> r0 = r2.headersQueue     // Catch:{ all -> 0x002e }
            r0.add(r3)     // Catch:{ all -> 0x002e }
        L_0x0016:
            if (r4 == 0) goto L_0x001c
            okhttp3.internal.http2.Http2Stream$FramingSource r3 = r2.source     // Catch:{ all -> 0x002e }
            r3.finished = r1     // Catch:{ all -> 0x002e }
        L_0x001c:
            boolean r3 = r2.isOpen()     // Catch:{ all -> 0x002e }
            r2.notifyAll()     // Catch:{ all -> 0x002e }
            monitor-exit(r2)     // Catch:{ all -> 0x002e }
            if (r3 != 0) goto L_0x002d
            okhttp3.internal.http2.Http2Connection r3 = r2.connection
            int r4 = r2.id
            r3.removeStream(r4)
        L_0x002d:
            return
        L_0x002e:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x002e }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.receiveHeaders(okhttp3.Headers, boolean):void");
    }

    public synchronized void receiveRstStream(ErrorCode errorCode2) {
        if (this.errorCode == null) {
            this.errorCode = errorCode2;
            notifyAll();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003b, code lost:
        r2.readTimeout.exitAndThrowIfTimedOut();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0040, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized okhttp3.Headers takeHeaders() throws java.io.IOException {
        /*
            r2 = this;
            monitor-enter(r2)
            okhttp3.internal.http2.Http2Stream$StreamTimeout r0 = r2.readTimeout     // Catch:{ all -> 0x0041 }
            r0.enter()     // Catch:{ all -> 0x0041 }
        L_0x0006:
            java.util.Deque<okhttp3.Headers> r0 = r2.headersQueue     // Catch:{ all -> 0x003a }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x0016
            okhttp3.internal.http2.ErrorCode r0 = r2.errorCode     // Catch:{ all -> 0x003a }
            if (r0 != 0) goto L_0x0016
            r2.waitForIo()     // Catch:{ all -> 0x003a }
            goto L_0x0006
        L_0x0016:
            okhttp3.internal.http2.Http2Stream$StreamTimeout r0 = r2.readTimeout     // Catch:{ all -> 0x0041 }
            r0.exitAndThrowIfTimedOut()     // Catch:{ all -> 0x0041 }
            java.util.Deque<okhttp3.Headers> r0 = r2.headersQueue     // Catch:{ all -> 0x0041 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0041 }
            if (r0 != 0) goto L_0x002d
            java.util.Deque<okhttp3.Headers> r0 = r2.headersQueue     // Catch:{ all -> 0x0041 }
            java.lang.Object r0 = r0.removeFirst()     // Catch:{ all -> 0x0041 }
            okhttp3.Headers r0 = (okhttp3.Headers) r0     // Catch:{ all -> 0x0041 }
            monitor-exit(r2)
            return r0
        L_0x002d:
            java.io.IOException r0 = r2.errorException     // Catch:{ all -> 0x0041 }
            if (r0 == 0) goto L_0x0032
            goto L_0x0039
        L_0x0032:
            okhttp3.internal.http2.StreamResetException r0 = new okhttp3.internal.http2.StreamResetException     // Catch:{ all -> 0x0041 }
            okhttp3.internal.http2.ErrorCode r1 = r2.errorCode     // Catch:{ all -> 0x0041 }
            r0.<init>(r1)     // Catch:{ all -> 0x0041 }
        L_0x0039:
            throw r0     // Catch:{ all -> 0x0041 }
        L_0x003a:
            r0 = move-exception
            okhttp3.internal.http2.Http2Stream$StreamTimeout r1 = r2.readTimeout     // Catch:{ all -> 0x0041 }
            r1.exitAndThrowIfTimedOut()     // Catch:{ all -> 0x0041 }
            throw r0     // Catch:{ all -> 0x0041 }
        L_0x0041:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.takeHeaders():okhttp3.Headers");
    }

    public synchronized Headers trailers() throws IOException {
        Headers headers;
        if (this.errorCode != null) {
            Throwable th = this.errorException;
            if (th == null) {
                th = new StreamResetException(this.errorCode);
            }
            throw th;
        }
        FramingSource framingSource = this.source;
        if (!framingSource.finished || !framingSource.receiveBuffer.h0() || !this.source.readBuffer.h0()) {
            throw new IllegalStateException("too early; can't read the trailers yet");
        } else if (this.source.trailers != null) {
            headers = this.source.trailers;
        } else {
            headers = Util.EMPTY_HEADERS;
        }
        return headers;
    }

    public void waitForIo() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public void writeHeaders(List<Header> list, boolean z, boolean z2) throws IOException {
        if (list != null) {
            synchronized (this) {
                this.hasResponseHeaders = true;
                if (z) {
                    this.sink.finished = true;
                }
            }
            if (!z2) {
                synchronized (this.connection) {
                    if (this.connection.bytesLeftInWriteWindow == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                }
            }
            this.connection.writeHeaders(this.id, z, list);
            if (z2) {
                this.connection.flush();
                return;
            }
            return;
        }
        throw new NullPointerException("headers == null");
    }

    public Timeout writeTimeout() {
        return this.writeTimeout;
    }
}
