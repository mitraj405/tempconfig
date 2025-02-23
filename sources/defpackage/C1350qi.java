package defpackage;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: qi  reason: default package and case insensitive filesystem */
/* compiled from: LockFreeTaskQueue.kt */
public final class C1350qi<E> {
    public static final AtomicLongFieldUpdater a;

    /* renamed from: a  reason: collision with other field name */
    public static final AtomicReferenceFieldUpdater f6900a;

    /* renamed from: a  reason: collision with other field name */
    public static final C0422zD f6901a = new C0422zD("REMOVE_FROZEN", 2);
    private volatile Object _next;
    private volatile long _state;

    /* renamed from: a  reason: collision with other field name */
    public final int f6902a;

    /* renamed from: a  reason: collision with other field name */
    public final AtomicReferenceArray f6903a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f6904a;
    public final int b;

    /* renamed from: qi$a */
    /* compiled from: LockFreeTaskQueue.kt */
    public static final class a {
        public final int a;

        public a(int i) {
            this.a = i;
        }
    }

    static {
        Class<C1350qi> cls = C1350qi.class;
        f6900a = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_next");
        a = AtomicLongFieldUpdater.newUpdater(cls, "_state");
    }

    public C1350qi(int i, boolean z) {
        boolean z2;
        this.f6902a = i;
        this.f6904a = z;
        int i2 = i - 1;
        this.b = i2;
        this.f6903a = new AtomicReferenceArray(i);
        boolean z3 = false;
        if (i2 <= 1073741823) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if (!((i & i2) == 0 ? true : z3)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final int a(E e) {
        E e2 = e;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = a;
            long j = atomicLongFieldUpdater.get(this);
            if ((3458764513820540928L & j) == 0) {
                int i = (int) ((1073741823 & j) >> 0);
                int i2 = (int) ((1152921503533105152L & j) >> 30);
                int i3 = this.b;
                if (((i2 + 2) & i3) == (i & i3)) {
                    return 1;
                }
                boolean z = this.f6904a;
                AtomicReferenceArray atomicReferenceArray = this.f6903a;
                if (z || atomicReferenceArray.get(i2 & i3) == null) {
                    if (a.compareAndSet(this, j, (-1152921503533105153L & j) | (((long) ((i2 + 1) & 1073741823)) << 30))) {
                        atomicReferenceArray.set(i2 & i3, e2);
                        C1350qi qiVar = this;
                        while ((atomicLongFieldUpdater.get(qiVar) & 1152921504606846976L) != 0) {
                            qiVar = qiVar.c();
                            AtomicReferenceArray atomicReferenceArray2 = qiVar.f6903a;
                            int i4 = qiVar.b & i2;
                            Object obj = atomicReferenceArray2.get(i4);
                            if (!(obj instanceof a) || ((a) obj).a != i2) {
                                qiVar = null;
                                continue;
                            } else {
                                atomicReferenceArray2.set(i4, e2);
                                continue;
                            }
                            if (qiVar == null) {
                                break;
                            }
                        }
                        return 0;
                    }
                } else {
                    int i5 = this.f6902a;
                    if (i5 < 1024 || ((i2 - i) & 1073741823) > (i5 >> 1)) {
                        return 1;
                    }
                }
            } else if ((j & 2305843009213693952L) != 0) {
                return 2;
            } else {
                return 1;
            }
        }
        return 1;
    }

    public final boolean b() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j;
        do {
            atomicLongFieldUpdater = a;
            j = atomicLongFieldUpdater.get(this);
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, 2305843009213693952L | j));
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x006c A[LOOP:3: B:16:0x006c->B:19:0x0078, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final defpackage.C1350qi<E> c() {
        /*
            r10 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r6 = a
            long r2 = r6.get(r10)
            r0 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r4 = r2 & r0
            r7 = 0
            int r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x0011
            goto L_0x001d
        L_0x0011:
            long r7 = r2 | r0
            r0 = r6
            r1 = r10
            r4 = r7
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L_0x0000
            r2 = r7
        L_0x001d:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f6900a
            java.lang.Object r1 = r0.get(r10)
            qi r1 = (defpackage.C1350qi) r1
            if (r1 == 0) goto L_0x0028
            return r1
        L_0x0028:
            qi r1 = new qi
            int r4 = r10.f6902a
            int r4 = r4 * 2
            boolean r5 = r10.f6904a
            r1.<init>(r4, r5)
            r4 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r4 = r4 & r2
            r7 = 0
            long r4 = r4 >> r7
            int r4 = (int) r4
            r7 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r7 = r7 & r2
            r5 = 30
            long r7 = r7 >> r5
            int r5 = (int) r7
        L_0x0044:
            int r7 = r10.b
            r8 = r4 & r7
            r7 = r7 & r5
            if (r8 == r7) goto L_0x0063
            java.util.concurrent.atomic.AtomicReferenceArray r7 = r10.f6903a
            java.lang.Object r7 = r7.get(r8)
            if (r7 != 0) goto L_0x0058
            qi$a r7 = new qi$a
            r7.<init>(r4)
        L_0x0058:
            java.util.concurrent.atomic.AtomicReferenceArray r8 = r1.f6903a
            int r9 = r1.b
            r9 = r9 & r4
            r8.set(r9, r7)
            int r4 = r4 + 1
            goto L_0x0044
        L_0x0063:
            r4 = -1152921504606846977(0xefffffffffffffff, double:-3.1050361846014175E231)
            long r4 = r4 & r2
            r6.set(r1, r4)
        L_0x006c:
            r4 = 0
            boolean r4 = r0.compareAndSet(r10, r4, r1)
            if (r4 == 0) goto L_0x0074
            goto L_0x001d
        L_0x0074:
            java.lang.Object r4 = r0.get(r10)
            if (r4 == 0) goto L_0x006c
            goto L_0x001d
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1350qi.c():qi");
    }

    public final Object d() {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = a;
            long j = atomicLongFieldUpdater.get(this);
            if ((j & 1152921504606846976L) != 0) {
                return f6901a;
            }
            int i = (int) ((j & 1073741823) >> 0);
            int i2 = this.b;
            int i3 = i & i2;
            if ((((int) ((1152921503533105152L & j) >> 30)) & i2) == i3) {
                return null;
            }
            AtomicReferenceArray atomicReferenceArray = this.f6903a;
            Object obj = atomicReferenceArray.get(i3);
            boolean z = this.f6904a;
            if (obj == null) {
                if (z) {
                    return null;
                }
            } else if (obj instanceof a) {
                return null;
            } else {
                long j2 = ((long) ((i + 1) & 1073741823)) << 0;
                AtomicReferenceArray atomicReferenceArray2 = atomicReferenceArray;
                Object obj2 = obj;
                if (atomicLongFieldUpdater.compareAndSet(this, j, (j & -1073741824) | j2)) {
                    atomicReferenceArray2.set(i3, (Object) null);
                    return obj2;
                } else if (z) {
                    C1350qi qiVar = this;
                    while (true) {
                        AtomicLongFieldUpdater atomicLongFieldUpdater2 = a;
                        long j3 = atomicLongFieldUpdater2.get(qiVar);
                        int i4 = (int) ((j3 & 1073741823) >> 0);
                        if ((j3 & 1152921504606846976L) != 0) {
                            qiVar = qiVar.c();
                        } else {
                            if (atomicLongFieldUpdater2.compareAndSet(qiVar, j3, (j3 & -1073741824) | j2)) {
                                qiVar.f6903a.set(qiVar.b & i4, (Object) null);
                                qiVar = null;
                            } else {
                                continue;
                            }
                        }
                        if (qiVar == null) {
                            return obj2;
                        }
                    }
                }
            }
        }
    }
}
