package androidx.concurrent.futures;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractResolvableFuture<V> implements ListenableFuture<V> {
    static final AtomicHelper ATOMIC_HELPER;
    static final boolean GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    private static final Object NULL = new Object();
    private static final long SPIN_THRESHOLD_NANOS = 1000;
    private static final Logger log;
    volatile Listener listeners;
    volatile Object value;
    volatile Waiter waiters;

    public static abstract class AtomicHelper {
        public abstract boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, Listener listener, Listener listener2);

        public abstract boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2);

        public abstract boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, Waiter waiter, Waiter waiter2);

        public abstract void d(Waiter waiter, Waiter waiter2);

        public abstract void e(Waiter waiter, Thread thread);
    }

    public static final class Listener {
        public static final Listener b = new Listener((Runnable) null, (Executor) null);
        public Listener a;

        /* renamed from: a  reason: collision with other field name */
        public final Runnable f1331a;

        /* renamed from: a  reason: collision with other field name */
        public final Executor f1332a;

        public Listener(Runnable runnable, Executor executor) {
            this.f1331a = runnable;
            this.f1332a = executor;
        }
    }

    public static final class Waiter {
        public static final Waiter b = new Waiter(0);
        public volatile Waiter a;

        /* renamed from: a  reason: collision with other field name */
        public volatile Thread f1333a;

        public Waiter(int i) {
        }

        public Waiter() {
            AbstractResolvableFuture.ATOMIC_HELPER.e(this, Thread.currentThread());
        }
    }

    public static final class a {
        public static final a a;
        public static final a b;

        /* renamed from: a  reason: collision with other field name */
        public final Throwable f1334a;

        /* renamed from: a  reason: collision with other field name */
        public final boolean f1335a;

        static {
            if (AbstractResolvableFuture.GENERATE_CANCELLATION_CAUSES) {
                b = null;
                a = null;
                return;
            }
            b = new a(false, (Throwable) null);
            a = new a(true, (Throwable) null);
        }

        public a(boolean z, Throwable th) {
            this.f1335a = z;
            this.f1334a = th;
        }
    }

    public static final class b {
        public static final b a = new b(new a());

        /* renamed from: a  reason: collision with other field name */
        public final Throwable f1336a;

        public class a extends Throwable {
            public a() {
                super("Failure occurred while trying to finish a future.");
            }

            public final synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        public b(Throwable th) {
            this.f1336a = (Throwable) AbstractResolvableFuture.checkNotNull(th);
        }
    }

    public static final class c extends AtomicHelper {
        public final AtomicReferenceFieldUpdater<Waiter, Thread> a;
        public final AtomicReferenceFieldUpdater<Waiter, Waiter> b;
        public final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Waiter> c;
        public final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Listener> d;
        public final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> e;

        public c(AtomicReferenceFieldUpdater<Waiter, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<Waiter, Waiter> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Waiter> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Listener> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> atomicReferenceFieldUpdater5) {
            this.a = atomicReferenceFieldUpdater;
            this.b = atomicReferenceFieldUpdater2;
            this.c = atomicReferenceFieldUpdater3;
            this.d = atomicReferenceFieldUpdater4;
            this.e = atomicReferenceFieldUpdater5;
        }

        public final boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, Listener listener, Listener listener2) {
            AtomicReferenceFieldUpdater<AbstractResolvableFuture, Listener> atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.d;
                if (atomicReferenceFieldUpdater.compareAndSet(abstractResolvableFuture, listener, listener2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(abstractResolvableFuture) == listener);
            return false;
        }

        public final boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.e;
                if (atomicReferenceFieldUpdater.compareAndSet(abstractResolvableFuture, obj, obj2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(abstractResolvableFuture) == obj);
            return false;
        }

        public final boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, Waiter waiter, Waiter waiter2) {
            AtomicReferenceFieldUpdater<AbstractResolvableFuture, Waiter> atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.c;
                if (atomicReferenceFieldUpdater.compareAndSet(abstractResolvableFuture, waiter, waiter2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(abstractResolvableFuture) == waiter);
            return false;
        }

        public final void d(Waiter waiter, Waiter waiter2) {
            this.b.lazySet(waiter, waiter2);
        }

        public final void e(Waiter waiter, Thread thread) {
            this.a.lazySet(waiter, thread);
        }
    }

    public static final class d<V> implements Runnable {
        public final AbstractResolvableFuture<V> a;

        /* renamed from: a  reason: collision with other field name */
        public final ListenableFuture<? extends V> f1337a;

        public d(AbstractResolvableFuture<V> abstractResolvableFuture, ListenableFuture<? extends V> listenableFuture) {
            this.a = abstractResolvableFuture;
            this.f1337a = listenableFuture;
        }

        public final void run() {
            if (this.a.value == this) {
                if (AbstractResolvableFuture.ATOMIC_HELPER.b(this.a, this, AbstractResolvableFuture.getFutureValue(this.f1337a))) {
                    AbstractResolvableFuture.complete(this.a);
                }
            }
        }
    }

    public static final class e extends AtomicHelper {
        public final boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, Listener listener, Listener listener2) {
            synchronized (abstractResolvableFuture) {
                if (abstractResolvableFuture.listeners != listener) {
                    return false;
                }
                abstractResolvableFuture.listeners = listener2;
                return true;
            }
        }

        public final boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2) {
            synchronized (abstractResolvableFuture) {
                if (abstractResolvableFuture.value != obj) {
                    return false;
                }
                abstractResolvableFuture.value = obj2;
                return true;
            }
        }

        public final boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, Waiter waiter, Waiter waiter2) {
            synchronized (abstractResolvableFuture) {
                if (abstractResolvableFuture.waiters != waiter) {
                    return false;
                }
                abstractResolvableFuture.waiters = waiter2;
                return true;
            }
        }

        public final void d(Waiter waiter, Waiter waiter2) {
            waiter.a = waiter2;
        }

        public final void e(Waiter waiter, Thread thread) {
            waiter.f1333a = thread;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: androidx.concurrent.futures.AbstractResolvableFuture$c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: androidx.concurrent.futures.AbstractResolvableFuture$e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: androidx.concurrent.futures.AbstractResolvableFuture$c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: androidx.concurrent.futures.AbstractResolvableFuture$c} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.Class<androidx.concurrent.futures.AbstractResolvableFuture$Waiter> r0 = androidx.concurrent.futures.AbstractResolvableFuture.Waiter.class
            java.lang.String r1 = "guava.concurrent.generate_cancellation_cause"
            java.lang.String r2 = "false"
            java.lang.String r1 = java.lang.System.getProperty(r1, r2)
            boolean r1 = java.lang.Boolean.parseBoolean(r1)
            GENERATE_CANCELLATION_CAUSES = r1
            java.lang.Class<androidx.concurrent.futures.AbstractResolvableFuture> r1 = androidx.concurrent.futures.AbstractResolvableFuture.class
            java.lang.String r2 = r1.getName()
            java.util.logging.Logger r2 = java.util.logging.Logger.getLogger(r2)
            log = r2
            androidx.concurrent.futures.AbstractResolvableFuture$c r2 = new androidx.concurrent.futures.AbstractResolvableFuture$c     // Catch:{ all -> 0x0048 }
            java.lang.Class<java.lang.Thread> r3 = java.lang.Thread.class
            java.lang.String r4 = "a"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r3, r4)     // Catch:{ all -> 0x0048 }
            java.lang.String r3 = "a"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r0, r3)     // Catch:{ all -> 0x0048 }
            java.lang.String r3 = "waiters"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r0, r3)     // Catch:{ all -> 0x0048 }
            java.lang.Class<androidx.concurrent.futures.AbstractResolvableFuture$Listener> r0 = androidx.concurrent.futures.AbstractResolvableFuture.Listener.class
            java.lang.String r3 = "listeners"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r0, r3)     // Catch:{ all -> 0x0048 }
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            java.lang.String r3 = "value"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r8 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r0, r3)     // Catch:{ all -> 0x0048 }
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0048 }
            r0 = 0
            goto L_0x004e
        L_0x0048:
            r0 = move-exception
            androidx.concurrent.futures.AbstractResolvableFuture$e r2 = new androidx.concurrent.futures.AbstractResolvableFuture$e
            r2.<init>()
        L_0x004e:
            ATOMIC_HELPER = r2
            if (r0 == 0) goto L_0x005b
            java.util.logging.Logger r1 = log
            java.util.logging.Level r2 = java.util.logging.Level.SEVERE
            java.lang.String r3 = "SafeAtomicHelper is broken!"
            r1.log(r2, r3, r0)
        L_0x005b:
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            NULL = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.concurrent.futures.AbstractResolvableFuture.<clinit>():void");
    }

    private void addDoneString(StringBuilder sb) {
        try {
            Object uninterruptibly = getUninterruptibly(this);
            sb.append("SUCCESS, result=[");
            sb.append(userObjectToString(uninterruptibly));
            sb.append("]");
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e3) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e3.getClass());
            sb.append(" thrown from get()]");
        }
    }

    private static CancellationException cancellationExceptionWithCause(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    static <T> T checkNotNull(T t) {
        t.getClass();
        return t;
    }

    private Listener clearListeners(Listener listener) {
        Listener listener2;
        do {
            listener2 = this.listeners;
        } while (!ATOMIC_HELPER.a(this, listener2, Listener.b));
        Listener listener3 = listener2;
        Listener listener4 = listener;
        Listener listener5 = listener3;
        while (listener5 != null) {
            Listener listener6 = listener5.a;
            listener5.a = listener4;
            listener4 = listener5;
            listener5 = listener6;
        }
        return listener4;
    }

    public static void complete(AbstractResolvableFuture<?> abstractResolvableFuture) {
        Listener listener = null;
        AbstractResolvableFuture<V> abstractResolvableFuture2 = abstractResolvableFuture;
        while (true) {
            abstractResolvableFuture2.releaseWaiters();
            abstractResolvableFuture2.afterDone();
            Listener clearListeners = abstractResolvableFuture2.clearListeners(listener);
            while (true) {
                if (clearListeners != null) {
                    listener = clearListeners.a;
                    Runnable runnable = clearListeners.f1331a;
                    if (runnable instanceof d) {
                        d dVar = (d) runnable;
                        AbstractResolvableFuture<V> abstractResolvableFuture3 = dVar.a;
                        if (abstractResolvableFuture3.value == dVar) {
                            if (ATOMIC_HELPER.b(abstractResolvableFuture3, dVar, getFutureValue(dVar.f1337a))) {
                                abstractResolvableFuture2 = abstractResolvableFuture3;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        executeListener(runnable, clearListeners.f1332a);
                    }
                    clearListeners = listener;
                } else {
                    return;
                }
            }
        }
    }

    private static void executeListener(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = log;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, e2);
        }
    }

    private V getDoneValue(Object obj) throws ExecutionException {
        if (obj instanceof a) {
            throw cancellationExceptionWithCause("Task was cancelled.", ((a) obj).f1334a);
        } else if (obj instanceof b) {
            throw new ExecutionException(((b) obj).f1336a);
        } else if (obj == NULL) {
            return null;
        } else {
            return obj;
        }
    }

    static Object getFutureValue(ListenableFuture<?> listenableFuture) {
        if (listenableFuture instanceof AbstractResolvableFuture) {
            Object obj = ((AbstractResolvableFuture) listenableFuture).value;
            if (!(obj instanceof a)) {
                return obj;
            }
            a aVar = (a) obj;
            if (!aVar.f1335a) {
                return obj;
            }
            if (aVar.f1334a != null) {
                return new a(false, aVar.f1334a);
            }
            return a.b;
        }
        boolean isCancelled = listenableFuture.isCancelled();
        if ((!GENERATE_CANCELLATION_CAUSES) && isCancelled) {
            return a.b;
        }
        try {
            Object uninterruptibly = getUninterruptibly(listenableFuture);
            if (uninterruptibly == null) {
                return NULL;
            }
            return uninterruptibly;
        } catch (ExecutionException e2) {
            return new b(e2.getCause());
        } catch (CancellationException e3) {
            if (isCancelled) {
                return new a(false, e3);
            }
            return new b(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + listenableFuture, e3));
        } catch (Throwable th) {
            return new b(th);
        }
    }

    static <V> V getUninterruptibly(Future<V> future) throws ExecutionException {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    private void releaseWaiters() {
        Waiter waiter;
        do {
            waiter = this.waiters;
        } while (!ATOMIC_HELPER.c(this, waiter, Waiter.b));
        while (waiter != null) {
            Thread thread = waiter.f1333a;
            if (thread != null) {
                waiter.f1333a = null;
                LockSupport.unpark(thread);
            }
            waiter = waiter.a;
        }
    }

    private void removeWaiter(Waiter waiter) {
        waiter.f1333a = null;
        while (true) {
            Waiter waiter2 = this.waiters;
            if (waiter2 != Waiter.b) {
                Waiter waiter3 = null;
                while (waiter2 != null) {
                    Waiter waiter4 = waiter2.a;
                    if (waiter2.f1333a != null) {
                        waiter3 = waiter2;
                    } else if (waiter3 != null) {
                        waiter3.a = waiter4;
                        if (waiter3.f1333a == null) {
                        }
                    } else if (!ATOMIC_HELPER.c(this, waiter2, waiter4)) {
                    }
                    waiter2 = waiter4;
                }
                return;
            }
            return;
        }
    }

    private String userObjectToString(Object obj) {
        if (obj == this) {
            return "this future";
        }
        return String.valueOf(obj);
    }

    public final void addListener(Runnable runnable, Executor executor) {
        checkNotNull(runnable);
        checkNotNull(executor);
        Listener listener = this.listeners;
        Listener listener2 = Listener.b;
        if (listener != listener2) {
            Listener listener3 = new Listener(runnable, executor);
            do {
                listener3.a = listener;
                if (!ATOMIC_HELPER.a(this, listener, listener3)) {
                    listener = this.listeners;
                } else {
                    return;
                }
            } while (listener != listener2);
        }
        executeListener(runnable, executor);
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [java.util.concurrent.Future, com.google.common.util.concurrent.ListenableFuture<? extends V>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.value
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0008
            r3 = r1
            goto L_0x0009
        L_0x0008:
            r3 = r2
        L_0x0009:
            boolean r4 = r0 instanceof androidx.concurrent.futures.AbstractResolvableFuture.d
            r3 = r3 | r4
            if (r3 == 0) goto L_0x0061
            boolean r3 = GENERATE_CANCELLATION_CAUSES
            if (r3 == 0) goto L_0x001f
            androidx.concurrent.futures.AbstractResolvableFuture$a r3 = new androidx.concurrent.futures.AbstractResolvableFuture$a
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r3.<init>(r8, r4)
            goto L_0x0026
        L_0x001f:
            if (r8 == 0) goto L_0x0024
            androidx.concurrent.futures.AbstractResolvableFuture$a r3 = androidx.concurrent.futures.AbstractResolvableFuture.a.a
            goto L_0x0026
        L_0x0024:
            androidx.concurrent.futures.AbstractResolvableFuture$a r3 = androidx.concurrent.futures.AbstractResolvableFuture.a.b
        L_0x0026:
            r4 = r7
            r5 = r2
        L_0x0028:
            androidx.concurrent.futures.AbstractResolvableFuture$AtomicHelper r6 = ATOMIC_HELPER
            boolean r6 = r6.b(r4, r0, r3)
            if (r6 == 0) goto L_0x0059
            if (r8 == 0) goto L_0x0035
            r4.interruptTask()
        L_0x0035:
            complete(r4)
            boolean r4 = r0 instanceof androidx.concurrent.futures.AbstractResolvableFuture.d
            if (r4 == 0) goto L_0x0062
            androidx.concurrent.futures.AbstractResolvableFuture$d r0 = (androidx.concurrent.futures.AbstractResolvableFuture.d) r0
            com.google.common.util.concurrent.ListenableFuture<? extends V> r0 = r0.f1337a
            boolean r4 = r0 instanceof androidx.concurrent.futures.AbstractResolvableFuture
            if (r4 == 0) goto L_0x0055
            r4 = r0
            androidx.concurrent.futures.AbstractResolvableFuture r4 = (androidx.concurrent.futures.AbstractResolvableFuture) r4
            java.lang.Object r0 = r4.value
            if (r0 != 0) goto L_0x004d
            r5 = r1
            goto L_0x004e
        L_0x004d:
            r5 = r2
        L_0x004e:
            boolean r6 = r0 instanceof androidx.concurrent.futures.AbstractResolvableFuture.d
            r5 = r5 | r6
            if (r5 == 0) goto L_0x0062
            r5 = r1
            goto L_0x0028
        L_0x0055:
            r0.cancel(r8)
            goto L_0x0062
        L_0x0059:
            java.lang.Object r0 = r4.value
            boolean r6 = r0 instanceof androidx.concurrent.futures.AbstractResolvableFuture.d
            if (r6 != 0) goto L_0x0028
            r1 = r5
            goto L_0x0062
        L_0x0061:
            r1 = r2
        L_0x0062:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.concurrent.futures.AbstractResolvableFuture.cancel(boolean):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00bc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V get(long r18, java.util.concurrent.TimeUnit r20) throws java.lang.InterruptedException, java.util.concurrent.TimeoutException, java.util.concurrent.ExecutionException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r3 = r20
            long r4 = r3.toNanos(r1)
            boolean r6 = java.lang.Thread.interrupted()
            if (r6 != 0) goto L_0x016b
            java.lang.Object r6 = r0.value
            r7 = 1
            if (r6 == 0) goto L_0x0017
            r8 = r7
            goto L_0x0018
        L_0x0017:
            r8 = 0
        L_0x0018:
            boolean r9 = r6 instanceof androidx.concurrent.futures.AbstractResolvableFuture.d
            r9 = r9 ^ r7
            r8 = r8 & r9
            if (r8 == 0) goto L_0x0023
            java.lang.Object r1 = r0.getDoneValue(r6)
            return r1
        L_0x0023:
            r8 = 0
            int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r6 <= 0) goto L_0x002f
            long r10 = java.lang.System.nanoTime()
            long r10 = r10 + r4
            goto L_0x0030
        L_0x002f:
            r10 = r8
        L_0x0030:
            r12 = 1000(0x3e8, double:4.94E-321)
            int r6 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r6 < 0) goto L_0x008d
            androidx.concurrent.futures.AbstractResolvableFuture$Waiter r6 = r0.waiters
            androidx.concurrent.futures.AbstractResolvableFuture$Waiter r8 = androidx.concurrent.futures.AbstractResolvableFuture.Waiter.b
            if (r6 == r8) goto L_0x0086
            androidx.concurrent.futures.AbstractResolvableFuture$Waiter r9 = new androidx.concurrent.futures.AbstractResolvableFuture$Waiter
            r9.<init>()
        L_0x0041:
            androidx.concurrent.futures.AbstractResolvableFuture$AtomicHelper r14 = ATOMIC_HELPER
            r14.d(r9, r6)
            boolean r6 = r14.c(r0, r6, r9)
            if (r6 == 0) goto L_0x0082
        L_0x004c:
            java.util.concurrent.locks.LockSupport.parkNanos(r0, r4)
            boolean r4 = java.lang.Thread.interrupted()
            if (r4 != 0) goto L_0x0079
            java.lang.Object r4 = r0.value
            if (r4 == 0) goto L_0x005b
            r5 = r7
            goto L_0x005c
        L_0x005b:
            r5 = 0
        L_0x005c:
            boolean r6 = r4 instanceof androidx.concurrent.futures.AbstractResolvableFuture.d
            r6 = r6 ^ r7
            r5 = r5 & r6
            if (r5 == 0) goto L_0x0067
            java.lang.Object r1 = r0.getDoneValue(r4)
            return r1
        L_0x0067:
            long r4 = java.lang.System.nanoTime()
            long r4 = r10 - r4
            int r6 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r6 >= 0) goto L_0x004c
            r0.removeWaiter(r9)
            r14 = r0
            r15 = r14
            r5 = r4
            r4 = r3
            goto L_0x00b3
        L_0x0079:
            r0.removeWaiter(r9)
            java.lang.InterruptedException r1 = new java.lang.InterruptedException
            r1.<init>()
            throw r1
        L_0x0082:
            androidx.concurrent.futures.AbstractResolvableFuture$Waiter r6 = r0.waiters
            if (r6 != r8) goto L_0x0041
        L_0x0086:
            java.lang.Object r1 = r0.value
            java.lang.Object r1 = r0.getDoneValue(r1)
            return r1
        L_0x008d:
            r14 = r0
            r15 = r14
            r5 = r4
            r4 = r3
        L_0x0091:
            int r8 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r8 <= 0) goto L_0x00bc
            java.lang.Object r5 = r15.value
            if (r5 == 0) goto L_0x009b
            r6 = r7
            goto L_0x009c
        L_0x009b:
            r6 = 0
        L_0x009c:
            boolean r8 = r5 instanceof androidx.concurrent.futures.AbstractResolvableFuture.d
            r8 = r8 ^ r7
            r6 = r6 & r8
            if (r6 == 0) goto L_0x00a7
            java.lang.Object r1 = r15.getDoneValue(r5)
            return r1
        L_0x00a7:
            boolean r5 = java.lang.Thread.interrupted()
            if (r5 != 0) goto L_0x00b6
            long r5 = java.lang.System.nanoTime()
            long r5 = r10 - r5
        L_0x00b3:
            r8 = 0
            goto L_0x0091
        L_0x00b6:
            java.lang.InterruptedException r1 = new java.lang.InterruptedException
            r1.<init>()
            throw r1
        L_0x00bc:
            java.lang.String r8 = r14.toString()
            java.lang.String r9 = r3.toString()
            java.util.Locale r10 = java.util.Locale.ROOT
            java.lang.String r9 = r9.toLowerCase(r10)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r15 = "Waited "
            r11.<init>(r15)
            r11.append(r1)
            java.lang.String r1 = " "
            r11.append(r1)
            java.lang.String r2 = r3.toString()
            java.lang.String r2 = r2.toLowerCase(r10)
            r11.append(r2)
            java.lang.String r2 = r11.toString()
            long r10 = r5 + r12
            r15 = 0
            int r3 = (r10 > r15 ? 1 : (r10 == r15 ? 0 : -1))
            if (r3 >= 0) goto L_0x014d
            java.lang.String r3 = " (plus "
            java.lang.String r2 = defpackage.C1058d.z(r2, r3)
            long r5 = -r5
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r10 = r4.convert(r5, r3)
            long r3 = r4.toNanos(r10)
            long r5 = r5 - r3
            r3 = 0
            int r3 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x010e
            int r4 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r4 <= 0) goto L_0x010d
            goto L_0x010e
        L_0x010d:
            r7 = 0
        L_0x010e:
            if (r3 <= 0) goto L_0x0131
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            r3.append(r10)
            r3.append(r1)
            r3.append(r9)
            java.lang.String r2 = r3.toString()
            if (r7 == 0) goto L_0x012d
            java.lang.String r3 = ","
            java.lang.String r2 = defpackage.C1058d.z(r2, r3)
        L_0x012d:
            java.lang.String r2 = defpackage.C1058d.z(r2, r1)
        L_0x0131:
            if (r7 == 0) goto L_0x0147
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            r1.append(r5)
            java.lang.String r2 = " nanoseconds "
            r1.append(r2)
            java.lang.String r2 = r1.toString()
        L_0x0147:
            java.lang.String r1 = "delay)"
            java.lang.String r2 = defpackage.C1058d.z(r2, r1)
        L_0x014d:
            boolean r1 = r14.isDone()
            if (r1 == 0) goto L_0x015f
            java.util.concurrent.TimeoutException r1 = new java.util.concurrent.TimeoutException
            java.lang.String r3 = " but future completed as timeout expired"
            java.lang.String r2 = defpackage.C1058d.z(r2, r3)
            r1.<init>(r2)
            throw r1
        L_0x015f:
            java.util.concurrent.TimeoutException r1 = new java.util.concurrent.TimeoutException
            java.lang.String r3 = " for "
            java.lang.String r2 = defpackage.xx.D(r2, r3, r8)
            r1.<init>(r2)
            throw r1
        L_0x016b:
            java.lang.InterruptedException r1 = new java.lang.InterruptedException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.concurrent.futures.AbstractResolvableFuture.get(long, java.util.concurrent.TimeUnit):java.lang.Object");
    }

    public final boolean isCancelled() {
        return this.value instanceof a;
    }

    public final boolean isDone() {
        boolean z;
        Object obj = this.value;
        if (obj != null) {
            z = true;
        } else {
            z = false;
        }
        return (!(obj instanceof d)) & z;
    }

    /* access modifiers changed from: package-private */
    public final void maybePropagateCancellationTo(Future<?> future) {
        boolean z;
        if (future != null) {
            z = true;
        } else {
            z = false;
        }
        if (z && isCancelled()) {
            future.cancel(wasInterrupted());
        }
    }

    public String pendingToString() {
        Object obj = this.value;
        if (obj instanceof d) {
            return C0709Uj.j(new StringBuilder("setFuture=["), userObjectToString(((d) obj).f1337a), "]");
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public boolean set(V v) {
        if (v == null) {
            v = NULL;
        }
        if (!ATOMIC_HELPER.b(this, (Object) null, v)) {
            return false;
        }
        complete(this);
        return true;
    }

    public boolean setException(Throwable th) {
        if (!ATOMIC_HELPER.b(this, (Object) null, new b((Throwable) checkNotNull(th)))) {
            return false;
        }
        complete(this);
        return true;
    }

    public boolean setFuture(ListenableFuture<? extends V> listenableFuture) {
        d dVar;
        b bVar;
        checkNotNull(listenableFuture);
        Object obj = this.value;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (!ATOMIC_HELPER.b(this, (Object) null, getFutureValue(listenableFuture))) {
                    return false;
                }
                complete(this);
                return true;
            }
            dVar = new d(this, listenableFuture);
            if (ATOMIC_HELPER.b(this, (Object) null, dVar)) {
                try {
                    listenableFuture.addListener(dVar, g9.a);
                } catch (Throwable unused) {
                    bVar = b.a;
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof a) {
            listenableFuture.cancel(((a) obj).f1335a);
        }
        return false;
        ATOMIC_HELPER.b(this, dVar, bVar);
        return true;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            addDoneString(sb);
        } else {
            try {
                str = pendingToString();
            } catch (RuntimeException e2) {
                str = "Exception thrown from implementation: " + e2.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(str);
                sb.append("]");
            } else if (isDone()) {
                addDoneString(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public final boolean wasInterrupted() {
        Object obj = this.value;
        if (!(obj instanceof a) || !((a) obj).f1335a) {
            return false;
        }
        return true;
    }

    public void afterDone() {
    }

    public void interruptTask() {
    }

    public final V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) && (!(obj2 instanceof d))) {
                return getDoneValue(obj2);
            }
            Waiter waiter = this.waiters;
            Waiter waiter2 = Waiter.b;
            if (waiter != waiter2) {
                Waiter waiter3 = new Waiter();
                do {
                    AtomicHelper atomicHelper = ATOMIC_HELPER;
                    atomicHelper.d(waiter3, waiter);
                    if (atomicHelper.c(this, waiter, waiter3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.value;
                            } else {
                                removeWaiter(waiter3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof d))));
                        return getDoneValue(obj);
                    }
                    waiter = this.waiters;
                } while (waiter != waiter2);
            }
            return getDoneValue(this.value);
        }
        throw new InterruptedException();
    }
}
