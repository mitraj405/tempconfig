package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;

/* compiled from: EventLoop.common.kt */
public abstract class h extends i implements C0481D8 {
    public static final AtomicIntegerFieldUpdater a;

    /* renamed from: a  reason: collision with other field name */
    public static final AtomicReferenceFieldUpdater f5564a;
    public static final AtomicReferenceFieldUpdater b;
    private volatile Object _delayed;
    private volatile int _isCompleted = 0;
    private volatile Object _queue;

    /* compiled from: EventLoop.common.kt */
    public static abstract class a implements Runnable, Comparable<a>, C1276n9, Uz {
        private volatile Object _heap;
        public long a;
        public int c;

        public final int compareTo(Object obj) {
            int i = ((this.a - ((a) obj).a) > 0 ? 1 : ((this.a - ((a) obj).a) == 0 ? 0 : -1));
            if (i > 0) {
                return 1;
            }
            if (i < 0) {
                return -1;
            }
            return 0;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: Tz} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void h() {
            /*
                r5 = this;
                monitor-enter(r5)
                java.lang.Object r0 = r5._heap     // Catch:{ all -> 0x0031 }
                zD r1 = defpackage.r1.f     // Catch:{ all -> 0x0031 }
                if (r0 != r1) goto L_0x0009
                monitor-exit(r5)
                return
            L_0x0009:
                boolean r2 = r0 instanceof kotlinx.coroutines.h.b     // Catch:{ all -> 0x0031 }
                r3 = 0
                if (r2 == 0) goto L_0x0011
                kotlinx.coroutines.h$b r0 = (kotlinx.coroutines.h.b) r0     // Catch:{ all -> 0x0031 }
                goto L_0x0012
            L_0x0011:
                r0 = r3
            L_0x0012:
                if (r0 == 0) goto L_0x002b
                monitor-enter(r0)     // Catch:{ all -> 0x0031 }
                java.lang.Object r2 = r5._heap     // Catch:{ all -> 0x0028 }
                boolean r4 = r2 instanceof defpackage.C0700Tz     // Catch:{ all -> 0x0028 }
                if (r4 == 0) goto L_0x001e
                r3 = r2
                Tz r3 = (defpackage.C0700Tz) r3     // Catch:{ all -> 0x0028 }
            L_0x001e:
                if (r3 != 0) goto L_0x0021
                goto L_0x0026
            L_0x0021:
                int r2 = r5.c     // Catch:{ all -> 0x0028 }
                r0.c(r2)     // Catch:{ all -> 0x0028 }
            L_0x0026:
                monitor-exit(r0)     // Catch:{ all -> 0x0031 }
                goto L_0x002b
            L_0x0028:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0031 }
                throw r1     // Catch:{ all -> 0x0031 }
            L_0x002b:
                r5._heap = r1     // Catch:{ all -> 0x0031 }
                kotlin.Unit r0 = kotlin.Unit.a     // Catch:{ all -> 0x0031 }
                monitor-exit(r5)
                return
            L_0x0031:
                r0 = move-exception
                monitor-exit(r5)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.h.a.h():void");
        }

        public final void i(b bVar) {
            boolean z;
            if (this._heap != r1.f) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this._heap = bVar;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        public final void j(int i) {
            this.c = i;
        }

        public final int l(long j, b bVar, e eVar) {
            T t;
            synchronized (this) {
                if (this._heap == r1.f) {
                    return 2;
                }
                synchronized (bVar) {
                    try {
                        T[] tArr = bVar.f3799a;
                        if (tArr != null) {
                            t = tArr[0];
                        } else {
                            t = null;
                        }
                        a aVar = (a) t;
                        if (h.N(eVar)) {
                            return 1;
                        }
                        if (aVar == null) {
                            bVar.a = j;
                        } else {
                            long j2 = aVar.a;
                            if (j2 - j < 0) {
                                j = j2;
                            }
                            if (j - bVar.a > 0) {
                                bVar.a = j;
                            }
                        }
                        long j3 = this.a;
                        long j4 = bVar.a;
                        if (j3 - j4 < 0) {
                            this.a = j4;
                        }
                        bVar.a(this);
                        return 0;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        public final String toString() {
            return "Delayed[nanos=" + this.a + ']';
        }
    }

    /* compiled from: EventLoop.common.kt */
    public static final class b extends C0700Tz<a> {
        public long a;

        public b(long j) {
            this.a = j;
        }
    }

    static {
        Class<h> cls = h.class;
        Class<Object> cls2 = Object.class;
        f5564a = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_queue");
        b = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_delayed");
        a = AtomicIntegerFieldUpdater.newUpdater(cls, "_isCompleted");
    }

    public static final boolean N(e eVar) {
        eVar.getClass();
        if (a.get(eVar) != 0) {
            return true;
        }
        return false;
    }

    public final void h(CoroutineContext coroutineContext, Runnable runnable) {
        o0(runnable);
    }

    public void o0(Runnable runnable) {
        if (p0(runnable)) {
            Thread w = w();
            if (Thread.currentThread() != w) {
                LockSupport.unpark(w);
                return;
            }
            return;
        }
        e.a.o0(runnable);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0042 A[LOOP:2: B:23:0x0042->B:26:0x004d, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean p0(java.lang.Runnable r7) {
        /*
            r6 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f5564a
            java.lang.Object r1 = r0.get(r6)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = a
            int r2 = r2.get(r6)
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0012
            r2 = r3
            goto L_0x0013
        L_0x0012:
            r2 = r4
        L_0x0013:
            if (r2 == 0) goto L_0x0016
            return r4
        L_0x0016:
            if (r1 != 0) goto L_0x002a
        L_0x0018:
            r1 = 0
            boolean r1 = r0.compareAndSet(r6, r1, r7)
            if (r1 == 0) goto L_0x0021
            r4 = r3
            goto L_0x0027
        L_0x0021:
            java.lang.Object r1 = r0.get(r6)
            if (r1 == 0) goto L_0x0018
        L_0x0027:
            if (r4 == 0) goto L_0x0000
            return r3
        L_0x002a:
            boolean r2 = r1 instanceof defpackage.C1350qi
            if (r2 == 0) goto L_0x0051
            r2 = r1
            qi r2 = (defpackage.C1350qi) r2
            int r5 = r2.a(r7)
            if (r5 == 0) goto L_0x0050
            if (r5 == r3) goto L_0x003e
            r0 = 2
            if (r5 == r0) goto L_0x003d
            goto L_0x0000
        L_0x003d:
            return r4
        L_0x003e:
            qi r2 = r2.c()
        L_0x0042:
            boolean r3 = r0.compareAndSet(r6, r1, r2)
            if (r3 == 0) goto L_0x0049
            goto L_0x0000
        L_0x0049:
            java.lang.Object r3 = r0.get(r6)
            if (r3 == r1) goto L_0x0042
            goto L_0x0000
        L_0x0050:
            return r3
        L_0x0051:
            zD r2 = defpackage.r1.g
            if (r1 != r2) goto L_0x0056
            return r4
        L_0x0056:
            qi r2 = new qi
            r5 = 8
            r2.<init>(r5, r3)
            r5 = r1
            java.lang.Runnable r5 = (java.lang.Runnable) r5
            r2.a(r5)
            r2.a(r7)
        L_0x0066:
            boolean r5 = r0.compareAndSet(r6, r1, r2)
            if (r5 == 0) goto L_0x006e
            r4 = r3
            goto L_0x0074
        L_0x006e:
            java.lang.Object r5 = r0.get(r6)
            if (r5 == r1) goto L_0x0066
        L_0x0074:
            if (r4 == 0) goto L_0x0000
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.h.p0(java.lang.Runnable):boolean");
    }

    public final boolean q0() {
        boolean z;
        boolean z2;
        C0534I1<g<?>> i1 = this.f3880a;
        if (i1 != null) {
            z = i1.isEmpty();
        } else {
            z = true;
        }
        if (!z) {
            return false;
        }
        b bVar = (b) b.get(this);
        if (bVar != null) {
            if (bVar.b() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                return false;
            }
        }
        Object obj = f5564a.get(this);
        if (obj == null) {
            return true;
        }
        if (obj instanceof C1350qi) {
            long j = C1350qi.a.get((C1350qi) obj);
            if (((int) ((1073741823 & j) >> 0)) == ((int) ((j & 1152921503533105152L) >> 30))) {
                return true;
            }
        } else if (obj == r1.g) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0021 A[LOOP:0: B:10:0x0021->B:13:0x002c, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void r0(long r7, kotlinx.coroutines.h.a r9) {
        /*
            r6 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = a
            int r0 = r0.get(r6)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x000c
            r0 = r1
            goto L_0x000d
        L_0x000c:
            r0 = r2
        L_0x000d:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = b
            r4 = 0
            if (r0 == 0) goto L_0x0014
            r0 = r1
            goto L_0x003e
        L_0x0014:
            java.lang.Object r0 = r3.get(r6)
            kotlinx.coroutines.h$b r0 = (kotlinx.coroutines.h.b) r0
            if (r0 != 0) goto L_0x0037
            kotlinx.coroutines.h$b r5 = new kotlinx.coroutines.h$b
            r5.<init>(r7)
        L_0x0021:
            boolean r0 = r3.compareAndSet(r6, r4, r5)
            if (r0 == 0) goto L_0x0028
            goto L_0x002e
        L_0x0028:
            java.lang.Object r0 = r3.get(r6)
            if (r0 == 0) goto L_0x0021
        L_0x002e:
            java.lang.Object r0 = r3.get(r6)
            defpackage.C1177ig.c(r0)
            kotlinx.coroutines.h$b r0 = (kotlinx.coroutines.h.b) r0
        L_0x0037:
            r5 = r6
            kotlinx.coroutines.e r5 = (kotlinx.coroutines.e) r5
            int r0 = r9.l(r7, r0, r5)
        L_0x003e:
            if (r0 == 0) goto L_0x0056
            if (r0 == r1) goto L_0x0052
            r7 = 2
            if (r0 != r7) goto L_0x0046
            goto L_0x007f
        L_0x0046:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "unexpected result"
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x0052:
            r6.y(r7, r9)
            goto L_0x007f
        L_0x0056:
            java.lang.Object r7 = r3.get(r6)
            kotlinx.coroutines.h$b r7 = (kotlinx.coroutines.h.b) r7
            if (r7 == 0) goto L_0x006c
            monitor-enter(r7)
            T[] r8 = r7.f3799a     // Catch:{ all -> 0x0069 }
            if (r8 == 0) goto L_0x0065
            r4 = r8[r2]     // Catch:{ all -> 0x0069 }
        L_0x0065:
            monitor-exit(r7)
            kotlinx.coroutines.h$a r4 = (kotlinx.coroutines.h.a) r4
            goto L_0x006c
        L_0x0069:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        L_0x006c:
            if (r4 != r9) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r1 = r2
        L_0x0070:
            if (r1 == 0) goto L_0x007f
            java.lang.Thread r7 = r6.w()
            java.lang.Thread r8 = java.lang.Thread.currentThread()
            if (r8 == r7) goto L_0x007f
            java.util.concurrent.locks.LockSupport.unpark(r7)
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.h.r0(long, kotlinx.coroutines.h$a):void");
    }

    public void shutdown() {
        Uz uz;
        boolean z;
        boolean z2;
        ThreadLocal<C0765Za> threadLocal = C0686Sz.a;
        C0686Sz.a.set((Object) null);
        a.set(this, 1);
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5564a;
            Object obj = atomicReferenceFieldUpdater.get(this);
            C0422zD zDVar = r1.g;
            if (obj == null) {
                while (true) {
                    if (!atomicReferenceFieldUpdater.compareAndSet(this, (Object) null, zDVar)) {
                        if (atomicReferenceFieldUpdater.get(this) != null) {
                            z2 = false;
                            break;
                        }
                    } else {
                        z2 = true;
                        break;
                    }
                }
                if (z2) {
                    break;
                }
            } else if (obj instanceof C1350qi) {
                ((C1350qi) obj).b();
                break;
            } else if (obj == zDVar) {
                break;
            } else {
                C1350qi qiVar = new C1350qi(8, true);
                qiVar.a((Runnable) obj);
                while (true) {
                    if (!atomicReferenceFieldUpdater.compareAndSet(this, obj, qiVar)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                            z = false;
                            break;
                        }
                    } else {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    break;
                }
            }
        }
        do {
        } while (u() <= 0);
        long nanoTime = System.nanoTime();
        while (true) {
            b bVar = (b) b.get(this);
            if (bVar != null) {
                synchronized (bVar) {
                    if (bVar.b() > 0) {
                        uz = bVar.c(0);
                    } else {
                        uz = null;
                    }
                }
                a aVar = (a) uz;
                if (aVar != null) {
                    y(nanoTime, aVar);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x008a, code lost:
        r8 = null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0078 A[LOOP:2: B:45:0x0078->B:48:0x0083, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long u() {
        /*
            r12 = this;
            boolean r0 = r12.v()
            r1 = 0
            if (r0 == 0) goto L_0x0009
            return r1
        L_0x0009:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = b
            java.lang.Object r0 = r0.get(r12)
            kotlinx.coroutines.h$b r0 = (kotlinx.coroutines.h.b) r0
            r3 = 0
            r4 = 1
            r5 = 0
            if (r0 == 0) goto L_0x0059
            int r6 = r0.b()
            if (r6 != 0) goto L_0x001e
            r6 = r4
            goto L_0x001f
        L_0x001e:
            r6 = r5
        L_0x001f:
            if (r6 != 0) goto L_0x0059
            long r6 = java.lang.System.nanoTime()
        L_0x0025:
            monitor-enter(r0)
            T[] r8 = r0.f3799a     // Catch:{ all -> 0x0056 }
            if (r8 == 0) goto L_0x002d
            r8 = r8[r5]     // Catch:{ all -> 0x0056 }
            goto L_0x002e
        L_0x002d:
            r8 = r3
        L_0x002e:
            if (r8 != 0) goto L_0x0033
            monitor-exit(r0)
            r8 = r3
            goto L_0x0051
        L_0x0033:
            kotlinx.coroutines.h$a r8 = (kotlinx.coroutines.h.a) r8     // Catch:{ all -> 0x0056 }
            long r9 = r8.a     // Catch:{ all -> 0x0056 }
            long r9 = r6 - r9
            int r9 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r9 < 0) goto L_0x003f
            r9 = r4
            goto L_0x0040
        L_0x003f:
            r9 = r5
        L_0x0040:
            if (r9 == 0) goto L_0x0047
            boolean r8 = r12.p0(r8)     // Catch:{ all -> 0x0056 }
            goto L_0x0048
        L_0x0047:
            r8 = r5
        L_0x0048:
            if (r8 == 0) goto L_0x004f
            Uz r8 = r0.c(r5)     // Catch:{ all -> 0x0056 }
            goto L_0x0050
        L_0x004f:
            r8 = r3
        L_0x0050:
            monitor-exit(r0)
        L_0x0051:
            kotlinx.coroutines.h$a r8 = (kotlinx.coroutines.h.a) r8
            if (r8 != 0) goto L_0x0025
            goto L_0x0059
        L_0x0056:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L_0x0059:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f5564a
            java.lang.Object r6 = r0.get(r12)
            if (r6 != 0) goto L_0x0062
            goto L_0x008a
        L_0x0062:
            boolean r7 = r6 instanceof defpackage.C1350qi
            if (r7 == 0) goto L_0x0086
            r7 = r6
            qi r7 = (defpackage.C1350qi) r7
            java.lang.Object r8 = r7.d()
            zD r9 = defpackage.C1350qi.f6901a
            if (r8 == r9) goto L_0x0074
            java.lang.Runnable r8 = (java.lang.Runnable) r8
            goto L_0x00a0
        L_0x0074:
            qi r7 = r7.c()
        L_0x0078:
            boolean r8 = r0.compareAndSet(r12, r6, r7)
            if (r8 == 0) goto L_0x007f
            goto L_0x0059
        L_0x007f:
            java.lang.Object r8 = r0.get(r12)
            if (r8 == r6) goto L_0x0078
            goto L_0x0059
        L_0x0086:
            zD r7 = defpackage.r1.g
            if (r6 != r7) goto L_0x008c
        L_0x008a:
            r8 = r3
            goto L_0x00a0
        L_0x008c:
            boolean r7 = r0.compareAndSet(r12, r6, r3)
            if (r7 == 0) goto L_0x0094
            r0 = r4
            goto L_0x009b
        L_0x0094:
            java.lang.Object r7 = r0.get(r12)
            if (r7 == r6) goto L_0x008c
            r0 = r5
        L_0x009b:
            if (r0 == 0) goto L_0x0059
            r8 = r6
            java.lang.Runnable r8 = (java.lang.Runnable) r8
        L_0x00a0:
            if (r8 == 0) goto L_0x00a6
            r8.run()
            return r1
        L_0x00a6:
            I1<kotlinx.coroutines.g<?>> r0 = r12.f3880a
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r0 != 0) goto L_0x00b0
            goto L_0x00b6
        L_0x00b0:
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x00b8
        L_0x00b6:
            r8 = r6
            goto L_0x00b9
        L_0x00b8:
            r8 = r1
        L_0x00b9:
            int r0 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x00be
            goto L_0x0117
        L_0x00be:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f5564a
            java.lang.Object r0 = r0.get(r12)
            if (r0 == 0) goto L_0x00ee
            boolean r8 = r0 instanceof defpackage.C1350qi
            if (r8 == 0) goto L_0x00e9
            qi r0 = (defpackage.C1350qi) r0
            java.util.concurrent.atomic.AtomicLongFieldUpdater r8 = defpackage.C1350qi.a
            long r8 = r8.get(r0)
            r10 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r10 = r10 & r8
            long r10 = r10 >> r5
            int r0 = (int) r10
            r10 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r8 = r8 & r10
            r10 = 30
            long r8 = r8 >> r10
            int r8 = (int) r8
            if (r0 != r8) goto L_0x00e5
            goto L_0x00e6
        L_0x00e5:
            r4 = r5
        L_0x00e6:
            if (r4 != 0) goto L_0x00ee
            goto L_0x0117
        L_0x00e9:
            zD r3 = defpackage.r1.g
            if (r0 != r3) goto L_0x0117
            goto L_0x0116
        L_0x00ee:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = b
            java.lang.Object r0 = r0.get(r12)
            kotlinx.coroutines.h$b r0 = (kotlinx.coroutines.h.b) r0
            if (r0 == 0) goto L_0x0116
            monitor-enter(r0)
            T[] r4 = r0.f3799a     // Catch:{ all -> 0x0113 }
            if (r4 == 0) goto L_0x00ff
            r3 = r4[r5]     // Catch:{ all -> 0x0113 }
        L_0x00ff:
            monitor-exit(r0)
            kotlinx.coroutines.h$a r3 = (kotlinx.coroutines.h.a) r3
            if (r3 != 0) goto L_0x0105
            goto L_0x0116
        L_0x0105:
            long r3 = r3.a
            long r5 = java.lang.System.nanoTime()
            long r3 = r3 - r5
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0111
            goto L_0x0117
        L_0x0111:
            r1 = r3
            goto L_0x0117
        L_0x0113:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L_0x0116:
            r1 = r6
        L_0x0117:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.h.u():long");
    }
}
