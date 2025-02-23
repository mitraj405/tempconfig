package defpackage;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: o  reason: default package and case insensitive filesystem */
/* compiled from: AbstractFuture */
public abstract class C0283o<V> implements ListenableFuture<V> {
    public static final Logger a;

    /* renamed from: a  reason: collision with other field name */
    public static final a f3122a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f3123a = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    public static final Object b = new Object();

    /* renamed from: a  reason: collision with other field name */
    public volatile Object f3124a;

    /* renamed from: a  reason: collision with other field name */
    public volatile d f3125a;

    /* renamed from: a  reason: collision with other field name */
    public volatile h f3126a;

    /* renamed from: o$a */
    /* compiled from: AbstractFuture */
    public static abstract class a {
        public abstract boolean a(C0283o<?> oVar, d dVar, d dVar2);

        public abstract boolean b(C0283o<?> oVar, Object obj, Object obj2);

        public abstract boolean c(C0283o<?> oVar, h hVar, h hVar2);

        public abstract void d(h hVar, h hVar2);

        public abstract void e(h hVar, Thread thread);
    }

    /* renamed from: o$b */
    /* compiled from: AbstractFuture */
    public static final class b {
        public static final b a;
        public static final b b;

        /* renamed from: a  reason: collision with other field name */
        public final Throwable f3127a;

        /* renamed from: a  reason: collision with other field name */
        public final boolean f3128a;

        static {
            if (C0283o.f3123a) {
                b = null;
                a = null;
                return;
            }
            b = new b(false, (Throwable) null);
            a = new b(true, (Throwable) null);
        }

        public b(boolean z, Throwable th) {
            this.f3128a = z;
            this.f3127a = th;
        }
    }

    /* renamed from: o$c */
    /* compiled from: AbstractFuture */
    public static final class c {
        public static final c a = new c(new a());

        /* renamed from: a  reason: collision with other field name */
        public final Throwable f3129a;

        /* renamed from: o$c$a */
        /* compiled from: AbstractFuture */
        public class a extends Throwable {
            public a() {
                super("Failure occurred while trying to finish a future.");
            }

            public final synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        public c(Throwable th) {
            boolean z = C0283o.f3123a;
            th.getClass();
            this.f3129a = th;
        }
    }

    /* renamed from: o$d */
    /* compiled from: AbstractFuture */
    public static final class d {
        public static final d b = new d((Runnable) null, (Executor) null);
        public final Runnable a;

        /* renamed from: a  reason: collision with other field name */
        public final Executor f3130a;

        /* renamed from: a  reason: collision with other field name */
        public d f3131a;

        public d(Runnable runnable, Executor executor) {
            this.a = runnable;
            this.f3130a = executor;
        }
    }

    /* renamed from: o$e */
    /* compiled from: AbstractFuture */
    public static final class e extends a {
        public final AtomicReferenceFieldUpdater<h, Thread> a;
        public final AtomicReferenceFieldUpdater<h, h> b;
        public final AtomicReferenceFieldUpdater<C0283o, h> c;
        public final AtomicReferenceFieldUpdater<C0283o, d> d;
        public final AtomicReferenceFieldUpdater<C0283o, Object> e;

        public e(AtomicReferenceFieldUpdater<h, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<h, h> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<C0283o, h> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<C0283o, d> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<C0283o, Object> atomicReferenceFieldUpdater5) {
            this.a = atomicReferenceFieldUpdater;
            this.b = atomicReferenceFieldUpdater2;
            this.c = atomicReferenceFieldUpdater3;
            this.d = atomicReferenceFieldUpdater4;
            this.e = atomicReferenceFieldUpdater5;
        }

        public final boolean a(C0283o<?> oVar, d dVar, d dVar2) {
            AtomicReferenceFieldUpdater<C0283o, d> atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.d;
                if (atomicReferenceFieldUpdater.compareAndSet(oVar, dVar, dVar2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(oVar) == dVar);
            return false;
        }

        public final boolean b(C0283o<?> oVar, Object obj, Object obj2) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.e;
                if (atomicReferenceFieldUpdater.compareAndSet(oVar, obj, obj2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(oVar) == obj);
            return false;
        }

        public final boolean c(C0283o<?> oVar, h hVar, h hVar2) {
            AtomicReferenceFieldUpdater<C0283o, h> atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.c;
                if (atomicReferenceFieldUpdater.compareAndSet(oVar, hVar, hVar2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(oVar) == hVar);
            return false;
        }

        public final void d(h hVar, h hVar2) {
            this.b.lazySet(hVar, hVar2);
        }

        public final void e(h hVar, Thread thread) {
            this.a.lazySet(hVar, thread);
        }
    }

    /* renamed from: o$f */
    /* compiled from: AbstractFuture */
    public static final class f<V> implements Runnable {
        public final ListenableFuture<? extends V> a;

        /* renamed from: a  reason: collision with other field name */
        public final C0283o<V> f3132a;

        public f(C0283o<V> oVar, ListenableFuture<? extends V> listenableFuture) {
            this.f3132a = oVar;
            this.a = listenableFuture;
        }

        public final void run() {
            if (this.f3132a.f3124a == this) {
                if (C0283o.f3122a.b(this.f3132a, this, C0283o.e(this.a))) {
                    C0283o.b(this.f3132a);
                }
            }
        }
    }

    /* renamed from: o$g */
    /* compiled from: AbstractFuture */
    public static final class g extends a {
        public final boolean a(C0283o<?> oVar, d dVar, d dVar2) {
            synchronized (oVar) {
                if (oVar.f3125a != dVar) {
                    return false;
                }
                oVar.f3125a = dVar2;
                return true;
            }
        }

        public final boolean b(C0283o<?> oVar, Object obj, Object obj2) {
            synchronized (oVar) {
                if (oVar.f3124a != obj) {
                    return false;
                }
                oVar.f3124a = obj2;
                return true;
            }
        }

        public final boolean c(C0283o<?> oVar, h hVar, h hVar2) {
            synchronized (oVar) {
                if (oVar.f3126a != hVar) {
                    return false;
                }
                oVar.f3126a = hVar2;
                return true;
            }
        }

        public final void d(h hVar, h hVar2) {
            hVar.f3133a = hVar2;
        }

        public final void e(h hVar, Thread thread) {
            hVar.a = thread;
        }
    }

    /* renamed from: o$h */
    /* compiled from: AbstractFuture */
    public static final class h {
        public static final h b = new h(0);
        public volatile Thread a;

        /* renamed from: a  reason: collision with other field name */
        public volatile h f3133a;

        public h(int i) {
        }

        public h() {
            C0283o.f3122a.e(this, Thread.currentThread());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: o$e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: o$g} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: o$e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: o$e} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.Class<o$h> r0 = defpackage.C0283o.h.class
            java.lang.String r1 = "guava.concurrent.generate_cancellation_cause"
            java.lang.String r2 = "false"
            java.lang.String r1 = java.lang.System.getProperty(r1, r2)
            boolean r1 = java.lang.Boolean.parseBoolean(r1)
            f3123a = r1
            java.lang.Class<o> r1 = defpackage.C0283o.class
            java.lang.String r2 = r1.getName()
            java.util.logging.Logger r2 = java.util.logging.Logger.getLogger(r2)
            a = r2
            o$e r2 = new o$e     // Catch:{ all -> 0x0048 }
            java.lang.Class<java.lang.Thread> r3 = java.lang.Thread.class
            java.lang.String r4 = "a"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r3, r4)     // Catch:{ all -> 0x0048 }
            java.lang.String r3 = "a"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r0, r3)     // Catch:{ all -> 0x0048 }
            java.lang.String r3 = "a"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r0, r3)     // Catch:{ all -> 0x0048 }
            java.lang.Class<o$d> r0 = defpackage.C0283o.d.class
            java.lang.String r3 = "a"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r0, r3)     // Catch:{ all -> 0x0048 }
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            java.lang.String r3 = "a"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r8 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r0, r3)     // Catch:{ all -> 0x0048 }
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0048 }
            r0 = 0
            goto L_0x004e
        L_0x0048:
            r0 = move-exception
            o$g r2 = new o$g
            r2.<init>()
        L_0x004e:
            f3122a = r2
            if (r0 == 0) goto L_0x005b
            java.util.logging.Logger r1 = a
            java.util.logging.Level r2 = java.util.logging.Level.SEVERE
            java.lang.String r3 = "SafeAtomicHelper is broken!"
            r1.log(r2, r3, r0)
        L_0x005b:
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0283o.<clinit>():void");
    }

    public static void b(C0283o<?> oVar) {
        C0283o<V> oVar2;
        d dVar;
        d dVar2;
        d dVar3 = null;
        C0283o<?> oVar3 = oVar;
        while (true) {
            h hVar = oVar3.f3126a;
            if (f3122a.c(oVar3, hVar, h.b)) {
                while (hVar != null) {
                    Thread thread = hVar.a;
                    if (thread != null) {
                        hVar.a = null;
                        LockSupport.unpark(thread);
                    }
                    hVar = hVar.f3133a;
                }
                do {
                    dVar = oVar3.f3125a;
                } while (!f3122a.a(oVar3, dVar, d.b));
                while (true) {
                    dVar2 = dVar3;
                    dVar3 = dVar;
                    if (dVar3 == null) {
                        break;
                    }
                    dVar = dVar3.f3131a;
                    dVar3.f3131a = dVar2;
                }
                while (dVar2 != null) {
                    dVar3 = dVar2.f3131a;
                    Runnable runnable = dVar2.a;
                    if (runnable instanceof f) {
                        f fVar = (f) runnable;
                        C0283o<V> oVar4 = fVar.f3132a;
                        if (oVar4.f3124a == fVar) {
                            if (f3122a.b(oVar4, fVar, e(fVar.a))) {
                                oVar2 = oVar4;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        c(runnable, dVar2.f3130a);
                    }
                    dVar2 = dVar3;
                }
                return;
            }
            oVar2 = oVar3;
            oVar3 = oVar2;
        }
    }

    public static void c(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Level level = Level.SEVERE;
            a.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, e2);
        }
    }

    public static Object d(Object obj) throws ExecutionException {
        if (obj instanceof b) {
            Throwable th = ((b) obj).f3127a;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        } else if (obj instanceof c) {
            throw new ExecutionException(((c) obj).f3129a);
        } else if (obj == b) {
            return null;
        } else {
            return obj;
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object e(com.google.common.util.concurrent.ListenableFuture<?> r5) {
        /*
            boolean r0 = r5 instanceof defpackage.C0283o
            r1 = 0
            if (r0 == 0) goto L_0x0023
            o r5 = (defpackage.C0283o) r5
            java.lang.Object r5 = r5.f3124a
            boolean r0 = r5 instanceof defpackage.C0283o.b
            if (r0 == 0) goto L_0x0022
            r0 = r5
            o$b r0 = (defpackage.C0283o.b) r0
            boolean r2 = r0.f3128a
            if (r2 == 0) goto L_0x0022
            java.lang.Throwable r5 = r0.f3127a
            if (r5 == 0) goto L_0x0020
            o$b r5 = new o$b
            java.lang.Throwable r0 = r0.f3127a
            r5.<init>(r1, r0)
            goto L_0x0022
        L_0x0020:
            o$b r5 = defpackage.C0283o.b.b
        L_0x0022:
            return r5
        L_0x0023:
            boolean r0 = r5.isCancelled()
            boolean r2 = f3123a
            r3 = 1
            r2 = r2 ^ r3
            r2 = r2 & r0
            if (r2 == 0) goto L_0x0031
            o$b r5 = defpackage.C0283o.b.b
            return r5
        L_0x0031:
            r2 = r1
        L_0x0032:
            java.lang.Object r3 = r5.get()     // Catch:{ InterruptedException -> 0x0087, all -> 0x004b }
            if (r2 == 0) goto L_0x003f
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ ExecutionException -> 0x0048, CancellationException -> 0x0046, all -> 0x0044 }
            r2.interrupt()     // Catch:{ ExecutionException -> 0x0048, CancellationException -> 0x0046, all -> 0x0044 }
        L_0x003f:
            if (r3 != 0) goto L_0x004a
            java.lang.Object r3 = b     // Catch:{ ExecutionException -> 0x0048, CancellationException -> 0x0046, all -> 0x0044 }
            goto L_0x004a
        L_0x0044:
            r5 = move-exception
            goto L_0x0056
        L_0x0046:
            r2 = move-exception
            goto L_0x005c
        L_0x0048:
            r5 = move-exception
            goto L_0x007d
        L_0x004a:
            return r3
        L_0x004b:
            r3 = move-exception
            if (r2 == 0) goto L_0x0055
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ ExecutionException -> 0x0048, CancellationException -> 0x0046, all -> 0x0044 }
            r2.interrupt()     // Catch:{ ExecutionException -> 0x0048, CancellationException -> 0x0046, all -> 0x0044 }
        L_0x0055:
            throw r3     // Catch:{ ExecutionException -> 0x0048, CancellationException -> 0x0046, all -> 0x0044 }
        L_0x0056:
            o$c r0 = new o$c
            r0.<init>(r5)
            return r0
        L_0x005c:
            if (r0 != 0) goto L_0x0077
            o$c r0 = new o$c
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "get() threw CancellationException, despite reporting isCancelled() == false: "
            r3.<init>(r4)
            r3.append(r5)
            java.lang.String r5 = r3.toString()
            r1.<init>(r5, r2)
            r0.<init>(r1)
            return r0
        L_0x0077:
            o$b r5 = new o$b
            r5.<init>(r1, r2)
            return r5
        L_0x007d:
            o$c r0 = new o$c
            java.lang.Throwable r5 = r5.getCause()
            r0.<init>(r5)
            return r0
        L_0x0087:
            r2 = r3
            goto L_0x0032
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0283o.e(com.google.common.util.concurrent.ListenableFuture):java.lang.Object");
    }

    public final void a(StringBuilder sb) {
        Object obj;
        String str;
        boolean z = false;
        while (true) {
            try {
                obj = get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (ExecutionException e2) {
                sb.append("FAILURE, cause=[");
                sb.append(e2.getCause());
                sb.append("]");
                return;
            } catch (CancellationException unused2) {
                sb.append("CANCELLED");
                return;
            } catch (RuntimeException e3) {
                sb.append("UNKNOWN, cause=[");
                sb.append(e3.getClass());
                sb.append(" thrown from get()]");
                return;
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
        sb.append("SUCCESS, result=[");
        if (obj == this) {
            str = "this future";
        } else {
            str = String.valueOf(obj);
        }
        sb.append(str);
        sb.append("]");
    }

    public final void addListener(Runnable runnable, Executor executor) {
        runnable.getClass();
        executor.getClass();
        d dVar = this.f3125a;
        d dVar2 = d.b;
        if (dVar != dVar2) {
            d dVar3 = new d(runnable, executor);
            do {
                dVar3.f3131a = dVar;
                if (!f3122a.a(this, dVar, dVar3)) {
                    dVar = this.f3125a;
                } else {
                    return;
                }
            } while (dVar != dVar2);
        }
        c(runnable, executor);
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [java.util.concurrent.Future, com.google.common.util.concurrent.ListenableFuture<? extends V>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f3124a
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0008
            r3 = r1
            goto L_0x0009
        L_0x0008:
            r3 = r2
        L_0x0009:
            boolean r4 = r0 instanceof defpackage.C0283o.f
            r3 = r3 | r4
            if (r3 == 0) goto L_0x005c
            boolean r3 = f3123a
            if (r3 == 0) goto L_0x001f
            o$b r3 = new o$b
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r3.<init>(r8, r4)
            goto L_0x0026
        L_0x001f:
            if (r8 == 0) goto L_0x0024
            o$b r3 = defpackage.C0283o.b.a
            goto L_0x0026
        L_0x0024:
            o$b r3 = defpackage.C0283o.b.b
        L_0x0026:
            r4 = r7
            r5 = r2
        L_0x0028:
            o$a r6 = f3122a
            boolean r6 = r6.b(r4, r0, r3)
            if (r6 == 0) goto L_0x0054
            b(r4)
            boolean r4 = r0 instanceof defpackage.C0283o.f
            if (r4 == 0) goto L_0x005d
            o$f r0 = (defpackage.C0283o.f) r0
            com.google.common.util.concurrent.ListenableFuture<? extends V> r0 = r0.a
            boolean r4 = r0 instanceof defpackage.C0283o
            if (r4 == 0) goto L_0x0050
            r4 = r0
            o r4 = (defpackage.C0283o) r4
            java.lang.Object r0 = r4.f3124a
            if (r0 != 0) goto L_0x0048
            r5 = r1
            goto L_0x0049
        L_0x0048:
            r5 = r2
        L_0x0049:
            boolean r6 = r0 instanceof defpackage.C0283o.f
            r5 = r5 | r6
            if (r5 == 0) goto L_0x005d
            r5 = r1
            goto L_0x0028
        L_0x0050:
            r0.cancel(r8)
            goto L_0x005d
        L_0x0054:
            java.lang.Object r0 = r4.f3124a
            boolean r6 = r0 instanceof defpackage.C0283o.f
            if (r6 != 0) goto L_0x0028
            r1 = r5
            goto L_0x005d
        L_0x005c:
            r1 = r2
        L_0x005d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0283o.cancel(boolean):boolean");
    }

    public final String f() {
        String str;
        Object obj = this.f3124a;
        if (obj instanceof f) {
            StringBuilder sb = new StringBuilder("setFuture=[");
            ListenableFuture<? extends V> listenableFuture = ((f) obj).a;
            if (listenableFuture == this) {
                str = "this future";
            } else {
                str = String.valueOf(listenableFuture);
            }
            return C0709Uj.j(sb, str, "]");
        } else if (!(this instanceof ScheduledFuture)) {
            return null;
        } else {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        }
    }

    public final void g(h hVar) {
        hVar.a = null;
        while (true) {
            h hVar2 = this.f3126a;
            if (hVar2 != h.b) {
                h hVar3 = null;
                while (hVar2 != null) {
                    h hVar4 = hVar2.f3133a;
                    if (hVar2.a != null) {
                        hVar3 = hVar2;
                    } else if (hVar3 != null) {
                        hVar3.f3133a = hVar4;
                        if (hVar3.a == null) {
                        }
                    } else if (!f3122a.c(this, hVar2, hVar4)) {
                    }
                    hVar2 = hVar4;
                }
                return;
            }
            return;
        }
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
            java.lang.Object r6 = r0.f3124a
            r7 = 1
            if (r6 == 0) goto L_0x0017
            r8 = r7
            goto L_0x0018
        L_0x0017:
            r8 = 0
        L_0x0018:
            boolean r9 = r6 instanceof defpackage.C0283o.f
            r9 = r9 ^ r7
            r8 = r8 & r9
            if (r8 == 0) goto L_0x0023
            java.lang.Object r1 = d(r6)
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
            o$h r6 = r0.f3126a
            o$h r8 = defpackage.C0283o.h.b
            if (r6 == r8) goto L_0x0086
            o$h r9 = new o$h
            r9.<init>()
        L_0x0041:
            o$a r14 = f3122a
            r14.d(r9, r6)
            boolean r6 = r14.c(r0, r6, r9)
            if (r6 == 0) goto L_0x0082
        L_0x004c:
            java.util.concurrent.locks.LockSupport.parkNanos(r0, r4)
            boolean r4 = java.lang.Thread.interrupted()
            if (r4 != 0) goto L_0x0079
            java.lang.Object r4 = r0.f3124a
            if (r4 == 0) goto L_0x005b
            r5 = r7
            goto L_0x005c
        L_0x005b:
            r5 = 0
        L_0x005c:
            boolean r6 = r4 instanceof defpackage.C0283o.f
            r6 = r6 ^ r7
            r5 = r5 & r6
            if (r5 == 0) goto L_0x0067
            java.lang.Object r1 = d(r4)
            return r1
        L_0x0067:
            long r4 = java.lang.System.nanoTime()
            long r4 = r10 - r4
            int r6 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r6 >= 0) goto L_0x004c
            r0.g(r9)
            r14 = r0
            r15 = r14
            r5 = r4
            r4 = r3
            goto L_0x00b3
        L_0x0079:
            r0.g(r9)
            java.lang.InterruptedException r1 = new java.lang.InterruptedException
            r1.<init>()
            throw r1
        L_0x0082:
            o$h r6 = r0.f3126a
            if (r6 != r8) goto L_0x0041
        L_0x0086:
            java.lang.Object r1 = r0.f3124a
            java.lang.Object r1 = d(r1)
            return r1
        L_0x008d:
            r14 = r0
            r15 = r14
            r5 = r4
            r4 = r3
        L_0x0091:
            int r8 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r8 <= 0) goto L_0x00bc
            java.lang.Object r5 = r15.f3124a
            if (r5 == 0) goto L_0x009b
            r6 = r7
            goto L_0x009c
        L_0x009b:
            r6 = 0
        L_0x009c:
            boolean r8 = r5 instanceof defpackage.C0283o.f
            r8 = r8 ^ r7
            r6 = r6 & r8
            if (r6 == 0) goto L_0x00a7
            java.lang.Object r1 = d(r5)
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
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0283o.get(long, java.util.concurrent.TimeUnit):java.lang.Object");
    }

    public final boolean isCancelled() {
        return this.f3124a instanceof b;
    }

    public final boolean isDone() {
        boolean z;
        Object obj = this.f3124a;
        if (obj != null) {
            z = true;
        } else {
            z = false;
        }
        return (!(obj instanceof f)) & z;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            try {
                str = f();
            } catch (RuntimeException e2) {
                str = "Exception thrown from implementation: " + e2.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(str);
                sb.append("]");
            } else if (isDone()) {
                a(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public final V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f3124a;
            if ((obj2 != null) && (!(obj2 instanceof f))) {
                return d(obj2);
            }
            h hVar = this.f3126a;
            h hVar2 = h.b;
            if (hVar != hVar2) {
                h hVar3 = new h();
                do {
                    a aVar = f3122a;
                    aVar.d(hVar3, hVar);
                    if (aVar.c(this, hVar, hVar3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f3124a;
                            } else {
                                g(hVar3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof f))));
                        return d(obj);
                    }
                    hVar = this.f3126a;
                } while (hVar != hVar2);
            }
            return d(this.f3124a);
        }
        throw new InterruptedException();
    }
}
