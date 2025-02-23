package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;

/* renamed from: Xv  reason: default package */
/* compiled from: Semaphore.kt */
public class Xv {
    public static final AtomicIntegerFieldUpdater a;

    /* renamed from: a  reason: collision with other field name */
    public static final AtomicLongFieldUpdater f3837a;

    /* renamed from: a  reason: collision with other field name */
    public static final AtomicReferenceFieldUpdater f3838a;
    public static final AtomicLongFieldUpdater b;

    /* renamed from: b  reason: collision with other field name */
    public static final AtomicReferenceFieldUpdater f3839b;
    private volatile int _availablePermits;

    /* renamed from: a  reason: collision with other field name */
    public final int f3840a = 1;

    /* renamed from: a  reason: collision with other field name */
    public final Vv f3841a;
    private volatile long deqIdx;
    private volatile long enqIdx;
    private volatile Object head;
    private volatile Object tail;

    static {
        Class<Xv> cls = Xv.class;
        Class<Object> cls2 = Object.class;
        f3838a = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "head");
        f3837a = AtomicLongFieldUpdater.newUpdater(cls, "deqIdx");
        f3839b = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "tail");
        b = AtomicLongFieldUpdater.newUpdater(cls, "enqIdx");
        a = AtomicIntegerFieldUpdater.newUpdater(cls, "_availablePermits");
    }

    public Xv(int i) {
        boolean z;
        if (i < 0 || i > 1) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            Zv zv = new Zv(0, (Zv) null, 2);
            this.head = zv;
            this.tail = zv;
            this._availablePermits = 1 - i;
            this.f3841a = new Vv(this);
            return;
        }
        throw new IllegalArgumentException("The number of acquired permits should be in 0..1".toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0070, code lost:
        r7 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00c9 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0004 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(defpackage.C1180im.a r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
        L_0x0004:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = a
            int r2 = r2.getAndDecrement(r0)
            int r3 = r0.f3840a
            if (r2 > r3) goto L_0x0004
            Vv r3 = r0.f3841a
            if (r2 <= 0) goto L_0x0019
            kotlin.Unit r2 = kotlin.Unit.a
            r1.x(r2, r3)
            goto L_0x00c9
        L_0x0019:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = f3839b
            java.lang.Object r4 = r2.get(r0)
            Zv r4 = (defpackage.Zv) r4
            java.util.concurrent.atomic.AtomicLongFieldUpdater r5 = b
            long r5 = r5.getAndIncrement(r0)
            Uv r7 = defpackage.Uv.a
            int r8 = defpackage.Yv.b
            long r8 = (long) r8
            long r8 = r5 / r8
        L_0x002e:
            java.lang.Object r10 = defpackage.r1.q(r4, r8, r7)
            boolean r11 = defpackage.C1354qp.Z(r10)
            if (r11 != 0) goto L_0x0085
            Pv r11 = defpackage.C1354qp.T(r10)
        L_0x003c:
            java.lang.Object r14 = r2.get(r0)
            Pv r14 = (defpackage.Pv) r14
            long r12 = r14.f3758a
            r15 = r7
            r16 = r8
            long r7 = r11.f3758a
            int r7 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r7 < 0) goto L_0x004e
            goto L_0x0070
        L_0x004e:
            boolean r7 = r11.i()
            if (r7 != 0) goto L_0x0056
            r7 = 0
            goto L_0x0071
        L_0x0056:
            boolean r7 = r2.compareAndSet(r0, r14, r11)
            if (r7 == 0) goto L_0x005e
            r7 = 1
            goto L_0x0065
        L_0x005e:
            java.lang.Object r7 = r2.get(r0)
            if (r7 == r14) goto L_0x0056
            r7 = 0
        L_0x0065:
            if (r7 == 0) goto L_0x0078
            boolean r7 = r14.e()
            if (r7 == 0) goto L_0x0070
            r14.d()
        L_0x0070:
            r7 = 1
        L_0x0071:
            if (r7 == 0) goto L_0x0074
            goto L_0x0085
        L_0x0074:
            r7 = r15
            r8 = r16
            goto L_0x002e
        L_0x0078:
            boolean r7 = r11.e()
            if (r7 == 0) goto L_0x0081
            r11.d()
        L_0x0081:
            r7 = r15
            r8 = r16
            goto L_0x003c
        L_0x0085:
            Pv r2 = defpackage.C1354qp.T(r10)
            Zv r2 = (defpackage.Zv) r2
            int r4 = defpackage.Yv.b
            long r7 = (long) r4
            long r5 = r5 % r7
            int r4 = (int) r5
            java.util.concurrent.atomic.AtomicReferenceArray r5 = r2.a
        L_0x0092:
            r6 = 0
            boolean r6 = r5.compareAndSet(r4, r6, r1)
            if (r6 == 0) goto L_0x009b
            r5 = 1
            goto L_0x00a2
        L_0x009b:
            java.lang.Object r6 = r5.get(r4)
            if (r6 == 0) goto L_0x0092
            r5 = 0
        L_0x00a2:
            if (r5 == 0) goto L_0x00a8
            r1.b(r2, r4)
            goto L_0x00c4
        L_0x00a8:
            zD r6 = defpackage.Yv.f3876a
            zD r7 = defpackage.Yv.f3877b
            java.util.concurrent.atomic.AtomicReferenceArray r8 = r2.a
        L_0x00ae:
            boolean r2 = r8.compareAndSet(r4, r6, r7)
            if (r2 == 0) goto L_0x00b6
            r2 = 1
            goto L_0x00bd
        L_0x00b6:
            java.lang.Object r2 = r8.get(r4)
            if (r2 == r6) goto L_0x00ae
            r2 = 0
        L_0x00bd:
            if (r2 == 0) goto L_0x00c6
            kotlin.Unit r2 = kotlin.Unit.a
            r1.x(r2, r3)
        L_0x00c4:
            r12 = 1
            goto L_0x00c7
        L_0x00c6:
            r12 = 0
        L_0x00c7:
            if (r12 == 0) goto L_0x0004
        L_0x00c9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Xv.d(im$a):void");
    }

    public final void e() {
        int i;
        Object q;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = a;
            int andIncrement = atomicIntegerFieldUpdater.getAndIncrement(this);
            int i2 = this.f3840a;
            if (andIncrement >= i2) {
                do {
                    i = atomicIntegerFieldUpdater.get(this);
                    if (i <= i2 || atomicIntegerFieldUpdater.compareAndSet(this, i, i2)) {
                    }
                    i = atomicIntegerFieldUpdater.get(this);
                    break;
                } while (atomicIntegerFieldUpdater.compareAndSet(this, i, i2));
                throw new IllegalStateException(("The number of released permits cannot be greater than " + i2).toString());
            } else if (andIncrement < 0) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3838a;
                Zv zv = (Zv) atomicReferenceFieldUpdater.get(this);
                long andIncrement2 = f3837a.getAndIncrement(this);
                long j = andIncrement2 / ((long) Yv.b);
                Wv wv = Wv.a;
                do {
                    q = r1.q(zv, j, wv);
                    if (C1354qp.Z(q)) {
                        break;
                    }
                    Pv T = C1354qp.T(q);
                    while (true) {
                        Pv pv = (Pv) atomicReferenceFieldUpdater.get(this);
                        if (pv.f3758a >= T.f3758a) {
                            break;
                        } else if (!T.i()) {
                            z4 = false;
                            continue;
                            break;
                        } else {
                            while (true) {
                                if (!atomicReferenceFieldUpdater.compareAndSet(this, pv, T)) {
                                    if (atomicReferenceFieldUpdater.get(this) != pv) {
                                        z5 = false;
                                        break;
                                    }
                                } else {
                                    z5 = true;
                                    break;
                                }
                            }
                            if (z5) {
                                if (pv.e()) {
                                    pv.d();
                                }
                            } else if (T.e()) {
                                T.d();
                            }
                        }
                    }
                    z4 = true;
                    continue;
                } while (!z4);
                Zv zv2 = (Zv) C1354qp.T(q);
                zv2.a();
                if (zv2.f3758a <= j) {
                    int i3 = (int) (andIncrement2 % ((long) Yv.b));
                    C0422zD zDVar = Yv.f3876a;
                    AtomicReferenceArray atomicReferenceArray = zv2.a;
                    Object andSet = atomicReferenceArray.getAndSet(i3, zDVar);
                    if (andSet == null) {
                        int i4 = Yv.a;
                        int i5 = 0;
                        while (true) {
                            if (i5 >= i4) {
                                C0422zD zDVar2 = Yv.f3876a;
                                C0422zD zDVar3 = Yv.c;
                                while (true) {
                                    if (!atomicReferenceArray.compareAndSet(i3, zDVar2, zDVar3)) {
                                        if (atomicReferenceArray.get(i3) != zDVar2) {
                                            z2 = true;
                                            z3 = false;
                                            break;
                                        }
                                    } else {
                                        z2 = true;
                                        z3 = true;
                                        break;
                                    }
                                }
                                z = z3 ^ z2;
                                continue;
                            } else if (atomicReferenceArray.get(i3) == Yv.f3877b) {
                                z = true;
                                continue;
                                break;
                            } else {
                                i5++;
                            }
                        }
                    } else if (andSet != Yv.d) {
                        if (andSet instanceof CancellableContinuation) {
                            CancellableContinuation cancellableContinuation = (CancellableContinuation) andSet;
                            C0422zD g = cancellableContinuation.g(Unit.a, this.f3841a);
                            if (g != null) {
                                cancellableContinuation.k(g);
                                z = true;
                                continue;
                            }
                        } else if (andSet instanceof Tv) {
                            z = ((Tv) andSet).a(this, Unit.a);
                            continue;
                        } else {
                            throw new IllegalStateException(("unexpected: " + andSet).toString());
                        }
                    }
                }
                z = false;
                continue;
            } else {
                return;
            }
        } while (!z);
    }
}
