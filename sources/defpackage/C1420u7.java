package defpackage;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Unit;
import kotlin.random.Random;

/* renamed from: u7  reason: default package and case insensitive filesystem */
/* compiled from: CoroutineScheduler.kt */
public final class C1420u7 implements Executor, Closeable {
    public static final AtomicIntegerFieldUpdater a;

    /* renamed from: a  reason: collision with other field name */
    public static final AtomicLongFieldUpdater f6972a;

    /* renamed from: a  reason: collision with other field name */
    public static final C0422zD f6973a = new C0422zD("NOT_IN_STACK", 2);
    public static final AtomicLongFieldUpdater b;
    private volatile int _isTerminated;

    /* renamed from: a  reason: collision with other field name */
    public final long f6974a;

    /* renamed from: a  reason: collision with other field name */
    public final At<a> f6975a;

    /* renamed from: a  reason: collision with other field name */
    public final C1385se f6976a;

    /* renamed from: b  reason: collision with other field name */
    public final C1385se f6977b;
    public final int c;

    /* renamed from: c  reason: collision with other field name */
    public final String f6978c;
    private volatile long controlState;
    public final int d;
    private volatile long parkedWorkersStack;

    /* renamed from: u7$a */
    /* compiled from: CoroutineScheduler.kt */
    public final class a extends Thread {
        public static final AtomicIntegerFieldUpdater a = AtomicIntegerFieldUpdater.newUpdater(a.class, "workerCtl");

        /* renamed from: a  reason: collision with other field name */
        public long f6979a;

        /* renamed from: a  reason: collision with other field name */
        public final C0571Ks<C1433uz> f6980a;

        /* renamed from: a  reason: collision with other field name */
        public final C1108fE f6981a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f6983a;
        public long b;
        public int c;
        public int d;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        private volatile int workerCtl;

        public a() {
            throw null;
        }

        public a(int i) {
            setDaemon(true);
            this.f6981a = new C1108fE();
            this.f6980a = new C0571Ks<>();
            this.c = 4;
            this.nextParkedWorker = C1420u7.f6973a;
            this.d = Random.a.b();
            f(i);
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x007d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final defpackage.C1433uz a(boolean r11) {
            /*
                r10 = this;
                int r0 = r10.c
                r1 = 1
                r2 = 0
                if (r0 != r1) goto L_0x0007
                goto L_0x0032
            L_0x0007:
                u7 r0 = defpackage.C1420u7.this
                java.util.concurrent.atomic.AtomicLongFieldUpdater r9 = defpackage.C1420u7.b
            L_0x000b:
                long r5 = r9.get(r0)
                r3 = 9223367638808264704(0x7ffffc0000000000, double:NaN)
                long r3 = r3 & r5
                r7 = 42
                long r3 = r3 >> r7
                int r3 = (int) r3
                if (r3 != 0) goto L_0x001d
                r0 = r2
                goto L_0x002e
            L_0x001d:
                r3 = 4398046511104(0x40000000000, double:2.1729236899484E-311)
                long r7 = r5 - r3
                java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = defpackage.C1420u7.b
                r4 = r0
                boolean r3 = r3.compareAndSet(r4, r5, r7)
                if (r3 == 0) goto L_0x000b
                r0 = r1
            L_0x002e:
                if (r0 == 0) goto L_0x0034
                r10.c = r1
            L_0x0032:
                r0 = r1
                goto L_0x0035
            L_0x0034:
                r0 = r2
            L_0x0035:
                u7 r3 = defpackage.C1420u7.this
                r4 = 0
                fE r5 = r10.f6981a
                if (r0 == 0) goto L_0x007d
                if (r11 == 0) goto L_0x0070
                int r11 = r3.c
                int r11 = r11 * 2
                int r11 = r10.d(r11)
                if (r11 != 0) goto L_0x0049
                goto L_0x004a
            L_0x0049:
                r1 = r2
            L_0x004a:
                if (r1 == 0) goto L_0x0053
                uz r11 = r10.e()
                if (r11 == 0) goto L_0x0053
                goto L_0x007c
            L_0x0053:
                r5.getClass()
                java.util.concurrent.atomic.AtomicReferenceFieldUpdater r11 = defpackage.C1108fE.f5461a
                java.lang.Object r11 = r11.getAndSet(r5, r4)
                uz r11 = (defpackage.C1433uz) r11
                if (r11 != 0) goto L_0x0064
                uz r11 = r5.b()
            L_0x0064:
                if (r11 == 0) goto L_0x0067
                goto L_0x007c
            L_0x0067:
                if (r1 != 0) goto L_0x0077
                uz r11 = r10.e()
                if (r11 == 0) goto L_0x0077
                goto L_0x007c
            L_0x0070:
                uz r11 = r10.e()
                if (r11 == 0) goto L_0x0077
                goto L_0x007c
            L_0x0077:
                r11 = 3
                uz r11 = r10.i(r11)
            L_0x007c:
                return r11
            L_0x007d:
                r5.getClass()
            L_0x0080:
                java.util.concurrent.atomic.AtomicReferenceFieldUpdater r11 = defpackage.C1108fE.f5461a
                java.lang.Object r0 = r11.get(r5)
                uz r0 = (defpackage.C1433uz) r0
                if (r0 != 0) goto L_0x008b
                goto L_0x00ab
            L_0x008b:
                vz r6 = r0.f6993a
                int r6 = r6.b()
                if (r6 != r1) goto L_0x0095
                r6 = r1
                goto L_0x0096
            L_0x0095:
                r6 = r2
            L_0x0096:
                if (r6 != r1) goto L_0x00ab
            L_0x0098:
                boolean r6 = r11.compareAndSet(r5, r0, r4)
                if (r6 == 0) goto L_0x00a0
                r11 = r1
                goto L_0x00a7
            L_0x00a0:
                java.lang.Object r6 = r11.get(r5)
                if (r6 == r0) goto L_0x0098
                r11 = r2
            L_0x00a7:
                if (r11 == 0) goto L_0x0080
                r4 = r0
                goto L_0x00cb
            L_0x00ab:
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater r11 = defpackage.C1108fE.b
                int r11 = r11.get(r5)
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = defpackage.C1108fE.a
                int r0 = r0.get(r5)
            L_0x00b7:
                if (r11 == r0) goto L_0x00cb
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = defpackage.C1108fE.c
                int r2 = r2.get(r5)
                if (r2 != 0) goto L_0x00c2
                goto L_0x00cb
            L_0x00c2:
                int r0 = r0 + -1
                uz r2 = r5.c(r0, r1)
                if (r2 == 0) goto L_0x00b7
                r4 = r2
            L_0x00cb:
                if (r4 != 0) goto L_0x00dc
                se r11 = r3.f6977b
                java.lang.Object r11 = r11.d()
                r4 = r11
                uz r4 = (defpackage.C1433uz) r4
                if (r4 != 0) goto L_0x00dc
                uz r4 = r10.i(r1)
            L_0x00dc:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.C1420u7.a.a(boolean):uz");
        }

        public final int b() {
            return this.indexInArray;
        }

        public final Object c() {
            return this.nextParkedWorker;
        }

        public final int d(int i) {
            int i2 = this.d;
            int i3 = i2 ^ (i2 << 13);
            int i4 = i3 ^ (i3 >> 17);
            int i5 = i4 ^ (i4 << 5);
            this.d = i5;
            int i6 = i - 1;
            if ((i6 & i) == 0) {
                return i5 & i6;
            }
            return (i5 & Integer.MAX_VALUE) % i;
        }

        public final C1433uz e() {
            int d2 = d(2);
            C1420u7 u7Var = C1420u7.this;
            if (d2 == 0) {
                C1433uz uzVar = (C1433uz) u7Var.f6976a.d();
                if (uzVar != null) {
                    return uzVar;
                }
                return (C1433uz) u7Var.f6977b.d();
            }
            C1433uz uzVar2 = (C1433uz) u7Var.f6977b.d();
            if (uzVar2 != null) {
                return uzVar2;
            }
            return (C1433uz) u7Var.f6976a.d();
        }

        public final void f(int i) {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append(C1420u7.this.f6978c);
            sb.append("-worker-");
            if (i == 0) {
                str = "TERMINATED";
            } else {
                str = String.valueOf(i);
            }
            sb.append(str);
            setName(sb.toString());
            this.indexInArray = i;
        }

        public final void g(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean h(int i) {
            int i2 = this.c;
            boolean z = true;
            if (i2 != 1) {
                z = false;
            }
            if (z) {
                C1420u7.b.addAndGet(C1420u7.this, 4398046511104L);
            }
            if (i2 != i) {
                this.c = i;
            }
            return z;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0090, code lost:
            r7 = -2;
            r18 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0094, code lost:
            r5 = -1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final defpackage.C1433uz i(int r21) {
            /*
                r20 = this;
                r0 = r20
                r1 = r21
                java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = defpackage.C1420u7.b
                u7 r3 = defpackage.C1420u7.this
                long r4 = r2.get(r3)
                r6 = 2097151(0x1fffff, double:1.0361303E-317)
                long r4 = r4 & r6
                int r2 = (int) r4
                r4 = 2
                r5 = 0
                if (r2 >= r4) goto L_0x0016
                return r5
            L_0x0016:
                int r6 = r0.d(r2)
                r10 = 0
                r11 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            L_0x0020:
                if (r10 >= r2) goto L_0x00f0
                r15 = 1
                int r6 = r6 + r15
                if (r6 <= r2) goto L_0x0027
                r6 = r15
            L_0x0027:
                At<u7$a> r4 = r3.f6975a
                java.lang.Object r4 = r4.b(r6)
                u7$a r4 = (defpackage.C1420u7.a) r4
                if (r4 == 0) goto L_0x00e6
                if (r4 == r0) goto L_0x00e6
                r9 = 3
                fE r4 = r4.f6981a
                if (r1 != r9) goto L_0x003d
                uz r9 = r4.b()
                goto L_0x0069
            L_0x003d:
                r4.getClass()
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater r9 = defpackage.C1108fE.b
                int r9 = r9.get(r4)
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater r7 = defpackage.C1108fE.a
                int r7 = r7.get(r4)
                if (r1 != r15) goto L_0x0050
                r8 = r15
                goto L_0x0051
            L_0x0050:
                r8 = 0
            L_0x0051:
                if (r9 == r7) goto L_0x0068
                if (r8 == 0) goto L_0x005e
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater r13 = defpackage.C1108fE.c
                int r13 = r13.get(r4)
                if (r13 != 0) goto L_0x005e
                goto L_0x0068
            L_0x005e:
                int r13 = r9 + 1
                uz r9 = r4.c(r9, r8)
                if (r9 != 0) goto L_0x0069
                r9 = r13
                goto L_0x0051
            L_0x0068:
                r9 = r5
            L_0x0069:
                Ks<uz> r13 = r0.f6980a
                if (r9 == 0) goto L_0x0072
                r13.a = r9
                r18 = r6
                goto L_0x00c2
            L_0x0072:
                java.util.concurrent.atomic.AtomicReferenceFieldUpdater r9 = defpackage.C1108fE.f5461a
                java.lang.Object r14 = r9.get(r4)
                uz r14 = (defpackage.C1433uz) r14
                if (r14 != 0) goto L_0x007d
                goto L_0x0090
            L_0x007d:
                vz r7 = r14.f6993a
                int r7 = r7.b()
                if (r7 != r15) goto L_0x0087
                r7 = r15
                goto L_0x0088
            L_0x0087:
                r7 = 0
            L_0x0088:
                if (r7 == 0) goto L_0x008c
                r7 = r15
                goto L_0x008d
            L_0x008c:
                r7 = 2
            L_0x008d:
                r7 = r7 & r1
                if (r7 != 0) goto L_0x0097
            L_0x0090:
                r7 = -2
                r18 = r6
            L_0x0094:
                r5 = -1
                goto L_0x00c6
            L_0x0097:
                sm r7 = defpackage.C1524zz.f7121a
                r7.getClass()
                long r7 = java.lang.System.nanoTime()
                r18 = r6
                long r5 = r14.a
                long r7 = r7 - r5
                long r5 = defpackage.C1524zz.f7119a
                int r19 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r19 >= 0) goto L_0x00ae
                long r7 = r5 - r7
                goto L_0x0094
            L_0x00ae:
                r5 = 0
                boolean r6 = r9.compareAndSet(r4, r14, r5)
                if (r6 == 0) goto L_0x00b7
                r5 = r15
                goto L_0x00be
            L_0x00b7:
                java.lang.Object r5 = r9.get(r4)
                if (r5 == r14) goto L_0x00e3
                r5 = 0
            L_0x00be:
                if (r5 == 0) goto L_0x00dd
                r13.a = r14
            L_0x00c2:
                r5 = -1
                r7 = -1
            L_0x00c6:
                int r4 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r4 != 0) goto L_0x00d2
                T r1 = r13.a
                uz r1 = (defpackage.C1433uz) r1
                r2 = 0
                r13.a = r2
                return r1
            L_0x00d2:
                r16 = 0
                int r4 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1))
                if (r4 <= 0) goto L_0x00e8
                long r11 = java.lang.Math.min(r11, r7)
                goto L_0x00e8
            L_0x00dd:
                r16 = 0
                r6 = r18
                r5 = 0
                goto L_0x0072
            L_0x00e3:
                r16 = 0
                goto L_0x00ae
            L_0x00e6:
                r18 = r6
            L_0x00e8:
                int r10 = r10 + 1
                r6 = r18
                r4 = 2
                r5 = 0
                goto L_0x0020
            L_0x00f0:
                r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r16 = 0
                int r1 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
                if (r1 == 0) goto L_0x00fc
                goto L_0x00fe
            L_0x00fc:
                r11 = r16
            L_0x00fe:
                r0.b = r11
                r1 = 0
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.C1420u7.a.i(int):uz");
        }

        public final void run() {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            AtomicLongFieldUpdater atomicLongFieldUpdater;
            long j;
            int i;
            loop0:
            while (true) {
                boolean z6 = false;
                while (true) {
                    C1420u7 u7Var = C1420u7.this;
                    u7Var.getClass();
                    if (C1420u7.a.get(u7Var) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    int i2 = 5;
                    if (!z && this.c != 5) {
                        C1433uz a2 = a(this.f6983a);
                        if (a2 == null) {
                            this.f6983a = false;
                            if (this.b != 0) {
                                if (z6) {
                                    h(3);
                                    Thread.interrupted();
                                    LockSupport.parkNanos(this.b);
                                    this.b = 0;
                                    break;
                                }
                                z6 = true;
                            } else {
                                Object obj = this.nextParkedWorker;
                                C0422zD zDVar = C1420u7.f6973a;
                                if (obj != zDVar) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if (z2) {
                                    a.set(this, -1);
                                    while (true) {
                                        if (this.nextParkedWorker != C1420u7.f6973a) {
                                            z3 = true;
                                        } else {
                                            z3 = false;
                                        }
                                        if (!z3) {
                                            continue;
                                            break;
                                        }
                                        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = a;
                                        if (atomicIntegerFieldUpdater.get(this) != -1) {
                                            continue;
                                            break;
                                        }
                                        C1420u7 u7Var2 = C1420u7.this;
                                        u7Var2.getClass();
                                        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater2 = C1420u7.a;
                                        if (atomicIntegerFieldUpdater2.get(u7Var2) != 0) {
                                            z4 = true;
                                        } else {
                                            z4 = false;
                                        }
                                        if (z4 || this.c == i2) {
                                            break;
                                        }
                                        h(3);
                                        Thread.interrupted();
                                        if (this.f6979a == 0) {
                                            this.f6979a = System.nanoTime() + C1420u7.this.f6974a;
                                        }
                                        LockSupport.parkNanos(C1420u7.this.f6974a);
                                        if (System.nanoTime() - this.f6979a >= 0) {
                                            this.f6979a = 0;
                                            C1420u7 u7Var3 = C1420u7.this;
                                            synchronized (u7Var3.f6975a) {
                                                if (atomicIntegerFieldUpdater2.get(u7Var3) != 0) {
                                                    z5 = true;
                                                } else {
                                                    z5 = false;
                                                }
                                                if (!z5) {
                                                    AtomicLongFieldUpdater atomicLongFieldUpdater2 = C1420u7.b;
                                                    if (((int) (atomicLongFieldUpdater2.get(u7Var3) & 2097151)) > u7Var3.c) {
                                                        if (atomicIntegerFieldUpdater.compareAndSet(this, -1, 1)) {
                                                            int i3 = this.indexInArray;
                                                            f(0);
                                                            u7Var3.c(this, i3, 0);
                                                            int andDecrement = (int) (atomicLongFieldUpdater2.getAndDecrement(u7Var3) & 2097151);
                                                            if (andDecrement != i3) {
                                                                a b2 = u7Var3.f6975a.b(andDecrement);
                                                                C1177ig.c(b2);
                                                                a aVar = b2;
                                                                u7Var3.f6975a.c(i3, aVar);
                                                                aVar.f(i3);
                                                                u7Var3.c(aVar, andDecrement, i3);
                                                            }
                                                            u7Var3.f6975a.c(andDecrement, (a) null);
                                                            Unit unit = Unit.a;
                                                            this.c = 5;
                                                            i2 = 5;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        i2 = 5;
                                    }
                                } else {
                                    C1420u7 u7Var4 = C1420u7.this;
                                    u7Var4.getClass();
                                    if (this.nextParkedWorker == zDVar) {
                                        do {
                                            atomicLongFieldUpdater = C1420u7.f6972a;
                                            j = atomicLongFieldUpdater.get(u7Var4);
                                            i = this.indexInArray;
                                            this.nextParkedWorker = u7Var4.f6975a.b((int) (j & 2097151));
                                        } while (!atomicLongFieldUpdater.compareAndSet(u7Var4, j, ((j + PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) & -2097152) | ((long) i)));
                                    }
                                }
                            }
                        } else {
                            this.b = 0;
                            int b3 = a2.f6993a.b();
                            this.f6979a = 0;
                            if (this.c == 3) {
                                this.c = 2;
                            }
                            C1420u7 u7Var5 = C1420u7.this;
                            if (b3 != 0 && h(2) && !u7Var5.h() && !u7Var5.e(C1420u7.b.get(u7Var5))) {
                                u7Var5.h();
                            }
                            u7Var5.getClass();
                            try {
                                a2.run();
                            } catch (Throwable th) {
                                Throwable th2 = th;
                                Thread currentThread = Thread.currentThread();
                                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th2);
                            }
                            if (b3 != 0) {
                                C1420u7.b.addAndGet(u7Var5, -2097152);
                                if (this.c != 5) {
                                    this.c = 4;
                                }
                            }
                        }
                    } else {
                        h(5);
                    }
                }
            }
            h(5);
            return;
        }
    }

    static {
        Class<C1420u7> cls = C1420u7.class;
        f6972a = AtomicLongFieldUpdater.newUpdater(cls, "parkedWorkersStack");
        b = AtomicLongFieldUpdater.newUpdater(cls, "controlState");
        a = AtomicIntegerFieldUpdater.newUpdater(cls, "_isTerminated");
    }

    public C1420u7(int i, int i2, String str, long j) {
        boolean z;
        boolean z2;
        boolean z3;
        this.c = i;
        this.d = i2;
        this.f6974a = j;
        this.f6978c = str;
        boolean z4 = true;
        if (i >= 1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (i2 >= i) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (i2 <= 2097150) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    if (j <= 0 ? false : z4) {
                        this.f6976a = new C1385se();
                        this.f6977b = new C1385se();
                        this.f6975a = new At<>((i + 1) * 2);
                        this.controlState = ((long) i) << 42;
                        this._isTerminated = 0;
                        return;
                    }
                    throw new IllegalArgumentException(("Idle worker keep alive time " + j + " must be positive").toString());
                }
                throw new IllegalArgumentException(C1058d.y("Max pool size ", i2, " should not exceed maximal supported number of threads 2097150").toString());
            }
            throw new IllegalArgumentException(lf.i("Max pool size ", i2, " should be greater than or equals to core pool size ", i).toString());
        }
        throw new IllegalArgumentException(C1058d.y("Core pool size ", i, " should be at least 1").toString());
    }

    public final int a() {
        boolean z;
        boolean z2;
        synchronized (this.f6975a) {
            boolean z3 = false;
            if (a.get(this) != 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return -1;
            }
            AtomicLongFieldUpdater atomicLongFieldUpdater = b;
            long j = atomicLongFieldUpdater.get(this);
            int i = (int) (j & 2097151);
            int i2 = i - ((int) ((j & 4398044413952L) >> 21));
            if (i2 < 0) {
                i2 = 0;
            }
            if (i2 >= this.c) {
                return 0;
            }
            if (i >= this.d) {
                return 0;
            }
            int i3 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
            if (i3 <= 0 || this.f6975a.b(i3) != null) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                a aVar = new a(i3);
                this.f6975a.c(i3, aVar);
                if (i3 == ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    z3 = true;
                }
                if (z3) {
                    int i4 = i2 + 1;
                    aVar.start();
                    return i4;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public final void b(Runnable runnable, C1448vz vzVar, boolean z) {
        C1433uz uzVar;
        boolean z2;
        long j;
        a aVar;
        boolean z3;
        boolean z4;
        C1524zz.f7121a.getClass();
        long nanoTime = System.nanoTime();
        if (runnable instanceof C1433uz) {
            uzVar = (C1433uz) runnable;
            uzVar.a = nanoTime;
            uzVar.f6993a = vzVar;
        } else {
            uzVar = new C1468wz(runnable, nanoTime, vzVar);
        }
        boolean z5 = false;
        if (uzVar.f6993a.b() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = b;
        if (z2) {
            j = atomicLongFieldUpdater.addAndGet(this, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
        } else {
            j = 0;
        }
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof a) {
            aVar = (a) currentThread;
        } else {
            aVar = null;
        }
        if (aVar == null || !C1177ig.a(C1420u7.this, this)) {
            aVar = null;
        }
        if (!(aVar == null || aVar.c == 5 || (uzVar.f6993a.b() == 0 && aVar.c == 2))) {
            aVar.f6983a = true;
            C1108fE fEVar = aVar.f6981a;
            if (z) {
                uzVar = fEVar.a(uzVar);
            } else {
                fEVar.getClass();
                C1433uz uzVar2 = (C1433uz) C1108fE.f5461a.getAndSet(fEVar, uzVar);
                if (uzVar2 == null) {
                    uzVar = null;
                } else {
                    uzVar = fEVar.a(uzVar2);
                }
            }
        }
        if (uzVar != null) {
            if (uzVar.f6993a.b() == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                z4 = this.f6977b.a(uzVar);
            } else {
                z4 = this.f6976a.a(uzVar);
            }
            if (!z4) {
                throw new RejectedExecutionException(C0709Uj.j(new StringBuilder(), this.f6978c, " was terminated"));
            }
        }
        if (z && aVar != null) {
            z5 = true;
        }
        if (z2) {
            if (!z5 && !h() && !e(j)) {
                h();
            }
        } else if (!z5 && !h() && !e(atomicLongFieldUpdater.get(this))) {
            h();
        }
    }

    public final void c(a aVar, int i, int i2) {
        while (true) {
            long j = f6972a.get(this);
            int i3 = (int) (2097151 & j);
            long j2 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j) & -2097152;
            if (i3 == i) {
                if (i2 == 0) {
                    Object c2 = aVar.c();
                    while (true) {
                        if (c2 == f6973a) {
                            i3 = -1;
                            break;
                        } else if (c2 == null) {
                            i3 = 0;
                            break;
                        } else {
                            a aVar2 = (a) c2;
                            int b2 = aVar2.b();
                            if (b2 != 0) {
                                i3 = b2;
                                break;
                            }
                            c2 = aVar2.c();
                        }
                    }
                } else {
                    i3 = i2;
                }
            }
            if (i3 >= 0) {
                if (f6972a.compareAndSet(this, j, ((long) i3) | j2)) {
                    return;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008a, code lost:
        if (r1 == null) goto L_0x008c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void close() {
        /*
            r9 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = a
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r9, r1, r2)
            if (r0 != 0) goto L_0x000c
            goto L_0x00b2
        L_0x000c:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            boolean r3 = r0 instanceof defpackage.C1420u7.a
            r4 = 0
            if (r3 == 0) goto L_0x0018
            u7$a r0 = (defpackage.C1420u7.a) r0
            goto L_0x0019
        L_0x0018:
            r0 = r4
        L_0x0019:
            if (r0 == 0) goto L_0x0024
            u7 r3 = defpackage.C1420u7.this
            boolean r3 = defpackage.C1177ig.a(r3, r9)
            if (r3 == 0) goto L_0x0024
            goto L_0x0025
        L_0x0024:
            r0 = r4
        L_0x0025:
            At<u7$a> r3 = r9.f6975a
            monitor-enter(r3)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r5 = b     // Catch:{ all -> 0x00c6 }
            long r5 = r5.get(r9)     // Catch:{ all -> 0x00c6 }
            r7 = 2097151(0x1fffff, double:1.0361303E-317)
            long r5 = r5 & r7
            int r5 = (int) r5
            monitor-exit(r3)
            if (r2 > r5) goto L_0x007a
            r3 = r2
        L_0x0037:
            At<u7$a> r6 = r9.f6975a
            java.lang.Object r6 = r6.b(r3)
            defpackage.C1177ig.c(r6)
            u7$a r6 = (defpackage.C1420u7.a) r6
            if (r6 == r0) goto L_0x0075
        L_0x0044:
            boolean r7 = r6.isAlive()
            if (r7 == 0) goto L_0x0053
            java.util.concurrent.locks.LockSupport.unpark(r6)
            r7 = 10000(0x2710, double:4.9407E-320)
            r6.join(r7)
            goto L_0x0044
        L_0x0053:
            fE r6 = r6.f6981a
            se r7 = r9.f6977b
            r6.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r8 = defpackage.C1108fE.f5461a
            java.lang.Object r8 = r8.getAndSet(r6, r4)
            uz r8 = (defpackage.C1433uz) r8
            if (r8 == 0) goto L_0x0067
            r7.a(r8)
        L_0x0067:
            uz r8 = r6.b()
            if (r8 != 0) goto L_0x006f
            r8 = r1
            goto L_0x0073
        L_0x006f:
            r7.a(r8)
            r8 = r2
        L_0x0073:
            if (r8 != 0) goto L_0x0067
        L_0x0075:
            if (r3 == r5) goto L_0x007a
            int r3 = r3 + 1
            goto L_0x0037
        L_0x007a:
            se r1 = r9.f6977b
            r1.b()
            se r1 = r9.f6976a
            r1.b()
        L_0x0084:
            if (r0 == 0) goto L_0x008c
            uz r1 = r0.a(r2)
            if (r1 != 0) goto L_0x00b3
        L_0x008c:
            se r1 = r9.f6976a
            java.lang.Object r1 = r1.d()
            uz r1 = (defpackage.C1433uz) r1
            if (r1 != 0) goto L_0x00b3
            se r1 = r9.f6977b
            java.lang.Object r1 = r1.d()
            uz r1 = (defpackage.C1433uz) r1
            if (r1 != 0) goto L_0x00b3
            if (r0 == 0) goto L_0x00a6
            r1 = 5
            r0.h(r1)
        L_0x00a6:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = f6972a
            r1 = 0
            r0.set(r9, r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = b
            r0.set(r9, r1)
        L_0x00b2:
            return
        L_0x00b3:
            r1.run()     // Catch:{ all -> 0x00b7 }
            goto L_0x0084
        L_0x00b7:
            r1 = move-exception
            java.lang.Thread r3 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x00c4 }
            java.lang.Thread$UncaughtExceptionHandler r4 = r3.getUncaughtExceptionHandler()     // Catch:{ all -> 0x00c4 }
            r4.uncaughtException(r3, r1)     // Catch:{ all -> 0x00c4 }
            goto L_0x0084
        L_0x00c4:
            r0 = move-exception
            throw r0
        L_0x00c6:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1420u7.close():void");
    }

    public final boolean e(long j) {
        int i = ((int) (2097151 & j)) - ((int) ((j & 4398044413952L) >> 21));
        if (i < 0) {
            i = 0;
        }
        int i2 = this.c;
        if (i < i2) {
            int a2 = a();
            if (a2 == 1 && i2 > 1) {
                a();
            }
            if (a2 > 0) {
                return true;
            }
        }
        return false;
    }

    public final void execute(Runnable runnable) {
        b(runnable, C1524zz.f7122a, false);
    }

    public final boolean h() {
        C0422zD zDVar;
        int i;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f6972a;
            long j = atomicLongFieldUpdater.get(this);
            a b2 = this.f6975a.b((int) (2097151 & j));
            if (b2 == null) {
                b2 = null;
            } else {
                long j2 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j) & -2097152;
                Object c2 = b2.c();
                while (true) {
                    zDVar = f6973a;
                    if (c2 == zDVar) {
                        i = -1;
                        break;
                    } else if (c2 == null) {
                        i = 0;
                        break;
                    } else {
                        a aVar = (a) c2;
                        i = aVar.b();
                        if (i != 0) {
                            break;
                        }
                        c2 = aVar.c();
                    }
                }
                if (i >= 0) {
                    if (atomicLongFieldUpdater.compareAndSet(this, j, j2 | ((long) i))) {
                        b2.g(zDVar);
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            if (b2 == null) {
                return false;
            }
            if (a.a.compareAndSet(b2, -1, 0)) {
                LockSupport.unpark(b2);
                return true;
            }
        }
    }

    public final String toString() {
        int i;
        ArrayList arrayList = new ArrayList();
        At<a> at = this.f6975a;
        int a2 = at.a();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 1; i7 < a2; i7++) {
            a b2 = at.b(i7);
            if (b2 != null) {
                C1108fE fEVar = b2.f6981a;
                fEVar.getClass();
                if (C1108fE.f5461a.get(fEVar) != null) {
                    i = (C1108fE.a.get(fEVar) - C1108fE.b.get(fEVar)) + 1;
                } else {
                    i = C1108fE.a.get(fEVar) - C1108fE.b.get(fEVar);
                }
                int V = xx.V(b2.c);
                if (V == 0) {
                    i2++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i);
                    sb.append('c');
                    arrayList.add(sb.toString());
                } else if (V == 1) {
                    i3++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (V == 2) {
                    i4++;
                } else if (V == 3) {
                    i5++;
                    if (i > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(i);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else if (V == 4) {
                    i6++;
                }
            }
        }
        long j = b.get(this);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.f6978c);
        sb4.append('@');
        sb4.append(C1149h8.a(this));
        sb4.append("[Pool Size {core = ");
        int i8 = this.c;
        sb4.append(i8);
        sb4.append(", max = ");
        sb4.append(this.d);
        sb4.append("}, Worker States {CPU = ");
        sb4.append(i2);
        sb4.append(", blocking = ");
        sb4.append(i3);
        sb4.append(", parked = ");
        sb4.append(i4);
        sb4.append(", dormant = ");
        sb4.append(i5);
        sb4.append(", terminated = ");
        sb4.append(i6);
        sb4.append("}, running workers queues = ");
        sb4.append(arrayList);
        sb4.append(", global CPU queue size = ");
        sb4.append(this.f6976a.c());
        sb4.append(", global blocking queue size = ");
        sb4.append(this.f6977b.c());
        sb4.append(", Control State {created workers= ");
        sb4.append((int) (2097151 & j));
        sb4.append(", blocking tasks = ");
        sb4.append((int) ((4398044413952L & j) >> 21));
        sb4.append(", CPUs acquired = ");
        sb4.append(i8 - ((int) ((j & 9223367638808264704L) >> 42)));
        sb4.append("}]");
        return sb4.toString();
    }
}
