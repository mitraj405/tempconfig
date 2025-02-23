package org.spongycastle.math.ec;

import java.math.BigInteger;
import java.util.Hashtable;
import org.spongycastle.math.ec.ECFieldElement;

public abstract class ECPoint {
    public static final ECFieldElement[] b = new ECFieldElement[0];
    public Hashtable a;

    /* renamed from: a  reason: collision with other field name */
    public final ECCurve f6620a;

    /* renamed from: a  reason: collision with other field name */
    public final ECFieldElement f6621a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6622a;

    /* renamed from: a  reason: collision with other field name */
    public final ECFieldElement[] f6623a;

    /* renamed from: b  reason: collision with other field name */
    public final ECFieldElement f6624b;

    public static abstract class AbstractF2m extends ECPoint {
        public AbstractF2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
        }

        public final boolean r() {
            ECFieldElement eCFieldElement;
            ECFieldElement eCFieldElement2;
            ECCurve eCCurve = this.f6620a;
            ECFieldElement eCFieldElement3 = eCCurve.f6610a;
            ECFieldElement eCFieldElement4 = eCCurve.f6614b;
            int i = eCCurve.a;
            ECFieldElement[] eCFieldElementArr = this.f6623a;
            ECFieldElement eCFieldElement5 = this.f6624b;
            ECFieldElement eCFieldElement6 = this.f6621a;
            if (i == 6) {
                ECFieldElement eCFieldElement7 = eCFieldElementArr[0];
                boolean h = eCFieldElement7.h();
                if (eCFieldElement6.i()) {
                    ECFieldElement o = eCFieldElement5.o();
                    if (!h) {
                        eCFieldElement4 = eCFieldElement4.j(eCFieldElement7.o());
                    }
                    return o.equals(eCFieldElement4);
                }
                ECFieldElement o2 = eCFieldElement6.o();
                if (h) {
                    eCFieldElement2 = xx.N(eCFieldElement5, eCFieldElement5, eCFieldElement3);
                    eCFieldElement = o2.o().a(eCFieldElement4);
                } else {
                    ECFieldElement o3 = eCFieldElement7.o();
                    ECFieldElement o4 = o3.o();
                    eCFieldElement2 = eCFieldElement5.a(eCFieldElement7).l(eCFieldElement5, eCFieldElement3, o3);
                    eCFieldElement = o2.p(eCFieldElement4, o4);
                }
                return eCFieldElement2.j(o2).equals(eCFieldElement);
            }
            ECFieldElement j = eCFieldElement5.a(eCFieldElement6).j(eCFieldElement5);
            if (i != 0) {
                if (i == 1) {
                    ECFieldElement eCFieldElement8 = eCFieldElementArr[0];
                    if (!eCFieldElement8.h()) {
                        ECFieldElement j2 = eCFieldElement8.j(eCFieldElement8.o());
                        j = j.j(eCFieldElement8);
                        eCFieldElement3 = eCFieldElement3.j(eCFieldElement8);
                        eCFieldElement4 = eCFieldElement4.j(j2);
                    }
                } else {
                    throw new IllegalStateException("unsupported coordinate system");
                }
            }
            return j.equals(eCFieldElement6.a(eCFieldElement3).j(eCFieldElement6.o()).a(eCFieldElement4));
        }

        public final ECPoint s(ECFieldElement eCFieldElement) {
            if (k()) {
                return this;
            }
            int g = g();
            ECFieldElement[] eCFieldElementArr = this.f6623a;
            ECCurve eCCurve = this.f6620a;
            ECFieldElement eCFieldElement2 = this.f6624b;
            ECFieldElement eCFieldElement3 = this.f6621a;
            if (g == 5) {
                return eCCurve.f(eCFieldElement3, eCFieldElement2.a(eCFieldElement3).d(eCFieldElement).a(eCFieldElement3.j(eCFieldElement)), eCFieldElementArr, this.f6622a);
            } else if (g != 6) {
                return ECPoint.super.s(eCFieldElement);
            } else {
                ECFieldElement eCFieldElement4 = eCFieldElementArr[0];
                ECFieldElement j = eCFieldElement3.j(eCFieldElement.o());
                return eCCurve.f(j, eCFieldElement2.a(eCFieldElement3).a(j), new ECFieldElement[]{eCFieldElement4.j(eCFieldElement)}, this.f6622a);
            }
        }

        public final ECPoint t(ECFieldElement eCFieldElement) {
            if (k()) {
                return this;
            }
            int g = g();
            if (g != 5 && g != 6) {
                return ECPoint.super.t(eCFieldElement);
            }
            ECFieldElement eCFieldElement2 = this.f6624b;
            ECFieldElement eCFieldElement3 = this.f6621a;
            return this.f6620a.f(eCFieldElement3, eCFieldElement2.a(eCFieldElement3).j(eCFieldElement).a(eCFieldElement3), this.f6623a, this.f6622a);
        }

        public final ECPoint u(ECPoint eCPoint) {
            if (eCPoint.k()) {
                return this;
            }
            return a(eCPoint.n());
        }

        public final AbstractF2m z(int i) {
            if (k()) {
                return this;
            }
            ECCurve eCCurve = this.f6620a;
            int i2 = eCCurve.a;
            ECFieldElement eCFieldElement = this.f6624b;
            ECFieldElement eCFieldElement2 = this.f6621a;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 5) {
                        if (i2 != 6) {
                            throw new IllegalStateException("unsupported coordinate system");
                        }
                    }
                }
                ECFieldElement eCFieldElement3 = this.f6623a[0];
                return (AbstractF2m) eCCurve.f(eCFieldElement2.q(i), eCFieldElement.q(i), new ECFieldElement[]{eCFieldElement3.q(i)}, this.f6622a);
            }
            return (AbstractF2m) eCCurve.e(eCFieldElement2.q(i), eCFieldElement.q(i), this.f6622a);
        }

        public AbstractF2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
            super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        }
    }

    public static abstract class AbstractFp extends ECPoint {
        public AbstractFp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
        }

        public final boolean f() {
            return e().s();
        }

        public final boolean r() {
            ECCurve eCCurve = this.f6620a;
            ECFieldElement eCFieldElement = eCCurve.f6610a;
            ECFieldElement eCFieldElement2 = eCCurve.f6614b;
            ECFieldElement o = this.f6624b.o();
            int g = g();
            if (g != 0) {
                ECFieldElement[] eCFieldElementArr = this.f6623a;
                if (g == 1) {
                    ECFieldElement eCFieldElement3 = eCFieldElementArr[0];
                    if (!eCFieldElement3.h()) {
                        ECFieldElement o2 = eCFieldElement3.o();
                        ECFieldElement j = eCFieldElement3.j(o2);
                        o = o.j(eCFieldElement3);
                        eCFieldElement = eCFieldElement.j(o2);
                        eCFieldElement2 = eCFieldElement2.j(j);
                    }
                } else if (g == 2 || g == 3 || g == 4) {
                    ECFieldElement eCFieldElement4 = eCFieldElementArr[0];
                    if (!eCFieldElement4.h()) {
                        ECFieldElement o3 = eCFieldElement4.o();
                        ECFieldElement o4 = o3.o();
                        ECFieldElement j2 = o3.j(o4);
                        eCFieldElement = eCFieldElement.j(o4);
                        eCFieldElement2 = eCFieldElement2.j(j2);
                    }
                } else {
                    throw new IllegalStateException("unsupported coordinate system");
                }
            }
            ECFieldElement eCFieldElement5 = this.f6621a;
            return o.equals(eCFieldElement5.o().a(eCFieldElement).j(eCFieldElement5).a(eCFieldElement2));
        }

        public final ECPoint u(ECPoint eCPoint) {
            if (eCPoint.k()) {
                return this;
            }
            return a(eCPoint.n());
        }

        public AbstractFp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
            super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        }
    }

    public ECPoint(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        this.a = null;
        this.f6620a = eCCurve;
        this.f6621a = eCFieldElement;
        this.f6624b = eCFieldElement2;
        this.f6623a = eCFieldElementArr;
    }

    public abstract ECPoint a(ECPoint eCPoint);

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
        if (r2.f6623a[0].h() != false) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r2 = this;
            int r0 = r2.g()
            if (r0 == 0) goto L_0x001a
            r1 = 5
            if (r0 == r1) goto L_0x001a
            boolean r0 = r2.k()
            if (r0 != 0) goto L_0x001a
            org.spongycastle.math.ec.ECFieldElement[] r0 = r2.f6623a
            r1 = 0
            r0 = r0[r1]
            boolean r0 = r0.h()
            if (r0 == 0) goto L_0x001b
        L_0x001a:
            r1 = 1
        L_0x001b:
            if (r1 == 0) goto L_0x001e
            return
        L_0x001e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "point not in normal form"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.math.ec.ECPoint.b():void");
    }

    public abstract ECPoint c();

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean d(org.spongycastle.math.ec.ECPoint r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 != 0) goto L_0x0004
            return r0
        L_0x0004:
            org.spongycastle.math.ec.ECCurve r1 = r9.f6620a
            r2 = 1
            org.spongycastle.math.ec.ECCurve r3 = r8.f6620a
            if (r3 != 0) goto L_0x000d
            r4 = r2
            goto L_0x000e
        L_0x000d:
            r4 = r0
        L_0x000e:
            if (r1 != 0) goto L_0x0012
            r5 = r2
            goto L_0x0013
        L_0x0012:
            r5 = r0
        L_0x0013:
            boolean r6 = r8.k()
            boolean r7 = r9.k()
            if (r6 != 0) goto L_0x0068
            if (r7 == 0) goto L_0x0020
            goto L_0x0068
        L_0x0020:
            if (r4 == 0) goto L_0x0025
            if (r5 == 0) goto L_0x0025
            goto L_0x002b
        L_0x0025:
            if (r4 == 0) goto L_0x002d
            org.spongycastle.math.ec.ECPoint r9 = r9.o()
        L_0x002b:
            r1 = r8
            goto L_0x004e
        L_0x002d:
            if (r5 == 0) goto L_0x0034
            org.spongycastle.math.ec.ECPoint r1 = r8.o()
            goto L_0x004e
        L_0x0034:
            boolean r1 = r3.i(r1)
            if (r1 != 0) goto L_0x003b
            return r0
        L_0x003b:
            r1 = 2
            org.spongycastle.math.ec.ECPoint[] r4 = new org.spongycastle.math.ec.ECPoint[r1]
            r4[r0] = r8
            org.spongycastle.math.ec.ECPoint r9 = r3.n(r9)
            r4[r2] = r9
            r9 = 0
            r3.p(r4, r0, r1, r9)
            r1 = r4[r0]
            r9 = r4[r2]
        L_0x004e:
            org.spongycastle.math.ec.ECFieldElement r3 = r1.f6621a
            org.spongycastle.math.ec.ECFieldElement r4 = r9.f6621a
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0067
            org.spongycastle.math.ec.ECFieldElement r1 = r1.i()
            org.spongycastle.math.ec.ECFieldElement r9 = r9.i()
            boolean r9 = r1.equals(r9)
            if (r9 == 0) goto L_0x0067
            r0 = r2
        L_0x0067:
            return r0
        L_0x0068:
            if (r6 == 0) goto L_0x0077
            if (r7 == 0) goto L_0x0077
            if (r4 != 0) goto L_0x0076
            if (r5 != 0) goto L_0x0076
            boolean r9 = r3.i(r1)
            if (r9 == 0) goto L_0x0077
        L_0x0076:
            r0 = r2
        L_0x0077:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.math.ec.ECPoint.d(org.spongycastle.math.ec.ECPoint):boolean");
    }

    public final ECFieldElement e() {
        b();
        return i();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ECPoint)) {
            return false;
        }
        return d((ECPoint) obj);
    }

    public abstract boolean f();

    public final int g() {
        ECCurve eCCurve = this.f6620a;
        if (eCCurve == null) {
            return 0;
        }
        return eCCurve.a;
    }

    public final byte[] h(boolean z) {
        int i;
        if (k()) {
            return new byte[1];
        }
        ECPoint o = o();
        byte[] e = o.f6621a.e();
        if (z) {
            byte[] bArr = new byte[(e.length + 1)];
            if (o.f()) {
                i = 3;
            } else {
                i = 2;
            }
            bArr[0] = (byte) i;
            System.arraycopy(e, 0, bArr, 1, e.length);
            return bArr;
        }
        byte[] e2 = o.i().e();
        byte[] bArr2 = new byte[(e.length + e2.length + 1)];
        bArr2[0] = 4;
        System.arraycopy(e, 0, bArr2, 1, e.length);
        System.arraycopy(e2, 0, bArr2, e.length + 1, e2.length);
        return bArr2;
    }

    public final int hashCode() {
        int i;
        ECCurve eCCurve = this.f6620a;
        if (eCCurve == null) {
            i = 0;
        } else {
            i = ~eCCurve.hashCode();
        }
        if (k()) {
            return i;
        }
        ECPoint o = o();
        return (i ^ (o.f6621a.hashCode() * 17)) ^ (o.i().hashCode() * 257);
    }

    public ECFieldElement i() {
        return this.f6624b;
    }

    public ECFieldElement j() {
        ECFieldElement[] eCFieldElementArr = this.f6623a;
        if (eCFieldElementArr.length <= 0) {
            return null;
        }
        return eCFieldElementArr[0];
    }

    public final boolean k() {
        if (!(this.f6621a == null || this.f6624b == null)) {
            ECFieldElement[] eCFieldElementArr = this.f6623a;
            if (eCFieldElementArr.length <= 0 || !eCFieldElementArr[0].i()) {
                return false;
            }
        }
        return true;
    }

    public final boolean l() {
        if (!k() && this.f6620a != null && (!r() || !q())) {
            return false;
        }
        return true;
    }

    public final ECPoint m(BigInteger bigInteger) {
        ECMultiplier eCMultiplier;
        ECCurve eCCurve = this.f6620a;
        synchronized (eCCurve) {
            if (eCCurve.f6611a == null) {
                eCCurve.f6611a = eCCurve.c();
            }
            eCMultiplier = eCCurve.f6611a;
        }
        return eCMultiplier.a(this, bigInteger);
    }

    public abstract ECPoint n();

    public final ECPoint o() {
        int g;
        if (k() || (g = g()) == 0 || g == 5) {
            return this;
        }
        ECFieldElement j = j();
        if (j.h()) {
            return this;
        }
        return p(j.g());
    }

    public final ECPoint p(ECFieldElement eCFieldElement) {
        int g = g();
        ECCurve eCCurve = this.f6620a;
        ECFieldElement eCFieldElement2 = this.f6624b;
        ECFieldElement eCFieldElement3 = this.f6621a;
        if (g != 1) {
            if (g == 2 || g == 3 || g == 4) {
                ECFieldElement o = eCFieldElement.o();
                return eCCurve.e(eCFieldElement3.j(o), eCFieldElement2.j(o.j(eCFieldElement)), this.f6622a);
            } else if (g != 6) {
                throw new IllegalStateException("not a projective coordinate system");
            }
        }
        return eCCurve.e(eCFieldElement3.j(eCFieldElement), eCFieldElement2.j(eCFieldElement), this.f6622a);
    }

    public final boolean q() {
        BigInteger bigInteger = this.f6620a.b;
        if (bigInteger == null || bigInteger.equals(ECConstants.b) || !ECAlgorithms.f(this, bigInteger).k()) {
            return true;
        }
        return false;
    }

    public abstract boolean r();

    public ECPoint s(ECFieldElement eCFieldElement) {
        if (k()) {
            return this;
        }
        ECFieldElement j = this.f6621a.j(eCFieldElement);
        boolean z = this.f6622a;
        return this.f6620a.f(j, this.f6624b, this.f6623a, z);
    }

    public ECPoint t(ECFieldElement eCFieldElement) {
        if (k()) {
            return this;
        }
        ECFieldElement j = this.f6624b.j(eCFieldElement);
        boolean z = this.f6622a;
        return this.f6620a.f(this.f6621a, j, this.f6623a, z);
    }

    public final String toString() {
        if (k()) {
            return "INF";
        }
        StringBuffer stringBuffer = new StringBuffer("(");
        stringBuffer.append(this.f6621a);
        stringBuffer.append(',');
        stringBuffer.append(this.f6624b);
        int i = 0;
        while (true) {
            ECFieldElement[] eCFieldElementArr = this.f6623a;
            if (i < eCFieldElementArr.length) {
                stringBuffer.append(',');
                stringBuffer.append(eCFieldElementArr[i]);
                i++;
            } else {
                stringBuffer.append(')');
                return stringBuffer.toString();
            }
        }
    }

    public abstract ECPoint u(ECPoint eCPoint);

    public ECPoint v() {
        return y(this);
    }

    public ECPoint w(int i) {
        if (i >= 0) {
            ECPoint eCPoint = this;
            while (true) {
                i--;
                if (i < 0) {
                    return eCPoint;
                }
                eCPoint = eCPoint.x();
            }
        } else {
            throw new IllegalArgumentException("'e' cannot be negative");
        }
    }

    public abstract ECPoint x();

    public ECPoint y(ECPoint eCPoint) {
        return x().a(eCPoint);
    }

    public static class Fp extends AbstractFp {
        public Fp() {
            throw null;
        }

        public Fp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
            if ((eCFieldElement == null) == (eCFieldElement2 != null ? false : true)) {
                this.f6622a = z;
                return;
            }
            throw new IllegalArgumentException("Exactly one of the field elements is null");
        }

        public static ECFieldElement B(ECFieldElement eCFieldElement) {
            return eCFieldElement.a(eCFieldElement).a(eCFieldElement);
        }

        public final ECFieldElement A() {
            ECFieldElement[] eCFieldElementArr = this.f6623a;
            ECFieldElement eCFieldElement = eCFieldElementArr[1];
            if (eCFieldElement != null) {
                return eCFieldElement;
            }
            ECFieldElement z = z(eCFieldElementArr[0], (ECFieldElement) null);
            eCFieldElementArr[1] = z;
            return z;
        }

        public final Fp C(boolean z) {
            ECFieldElement eCFieldElement;
            ECFieldElement eCFieldElement2 = this.f6623a[0];
            ECFieldElement A = A();
            ECFieldElement eCFieldElement3 = this.f6621a;
            ECFieldElement a = B(eCFieldElement3.o()).a(A);
            ECFieldElement eCFieldElement4 = this.f6624b;
            ECFieldElement a2 = eCFieldElement4.a(eCFieldElement4);
            ECFieldElement j = a2.j(eCFieldElement4);
            ECFieldElement j2 = eCFieldElement3.j(j);
            ECFieldElement a3 = j2.a(j2);
            ECFieldElement r = a.o().r(a3.a(a3));
            ECFieldElement o = j.o();
            ECFieldElement a4 = o.a(o);
            ECFieldElement r2 = a.j(a3.r(r)).r(a4);
            if (z) {
                ECFieldElement j3 = a4.j(A);
                eCFieldElement = j3.a(j3);
            } else {
                eCFieldElement = null;
            }
            if (!eCFieldElement2.h()) {
                a2 = a2.j(eCFieldElement2);
            }
            return new Fp(this.f6620a, r, r2, new ECFieldElement[]{a2, eCFieldElement}, this.f6622a);
        }

        /* JADX WARNING: type inference failed for: r17v0, types: [org.spongycastle.math.ec.ECPoint] */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x011f, code lost:
            if (r1 == r6) goto L_0x0121;
         */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final org.spongycastle.math.ec.ECPoint a(org.spongycastle.math.ec.ECPoint r17) {
            /*
                r16 = this;
                r0 = r16
                r1 = r17
                boolean r2 = r16.k()
                if (r2 == 0) goto L_0x000b
                return r1
            L_0x000b:
                boolean r2 = r17.k()
                if (r2 == 0) goto L_0x0012
                return r0
            L_0x0012:
                if (r0 != r1) goto L_0x0019
                org.spongycastle.math.ec.ECPoint r1 = r16.x()
                return r1
            L_0x0019:
                org.spongycastle.math.ec.ECCurve r3 = r0.f6620a
                int r2 = r3.a
                org.spongycastle.math.ec.ECFieldElement r4 = r0.f6621a
                org.spongycastle.math.ec.ECFieldElement r5 = r0.f6624b
                org.spongycastle.math.ec.ECFieldElement r6 = r1.f6621a
                org.spongycastle.math.ec.ECFieldElement r7 = r1.f6624b
                if (r2 == 0) goto L_0x01d5
                org.spongycastle.math.ec.ECFieldElement[] r8 = r0.f6623a
                r9 = 1
                r10 = 0
                org.spongycastle.math.ec.ECFieldElement[] r1 = r1.f6623a
                if (r2 == r9) goto L_0x0141
                r11 = 4
                r12 = 2
                if (r2 == r12) goto L_0x003e
                if (r2 != r11) goto L_0x0036
                goto L_0x003e
            L_0x0036:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "unsupported coordinate system"
                r1.<init>(r2)
                throw r1
            L_0x003e:
                r8 = r8[r10]
                r1 = r1[r10]
                boolean r13 = r8.h()
                if (r13 != 0) goto L_0x00a1
                boolean r15 = r8.equals(r1)
                if (r15 == 0) goto L_0x00a1
                org.spongycastle.math.ec.ECFieldElement r1 = r4.r(r6)
                org.spongycastle.math.ec.ECFieldElement r7 = r5.r(r7)
                boolean r13 = r1.i()
                if (r13 == 0) goto L_0x006c
                boolean r1 = r7.i()
                if (r1 == 0) goto L_0x0067
                org.spongycastle.math.ec.ECPoint r1 = r16.x()
                return r1
            L_0x0067:
                org.spongycastle.math.ec.ECPoint r1 = r3.l()
                return r1
            L_0x006c:
                org.spongycastle.math.ec.ECFieldElement r13 = r1.o()
                org.spongycastle.math.ec.ECFieldElement r4 = r4.j(r13)
                org.spongycastle.math.ec.ECFieldElement r6 = r6.j(r13)
                org.spongycastle.math.ec.ECFieldElement r13 = r4.r(r6)
                org.spongycastle.math.ec.ECFieldElement r5 = r13.j(r5)
                org.spongycastle.math.ec.ECFieldElement r13 = r7.o()
                org.spongycastle.math.ec.ECFieldElement r13 = r13.r(r4)
                org.spongycastle.math.ec.ECFieldElement r6 = r13.r(r6)
                org.spongycastle.math.ec.ECFieldElement r4 = r4.r(r6)
                org.spongycastle.math.ec.ECFieldElement r4 = r4.j(r7)
                org.spongycastle.math.ec.ECFieldElement r4 = r4.r(r5)
                org.spongycastle.math.ec.ECFieldElement r1 = r1.j(r8)
                r5 = r4
                r4 = r6
            L_0x009e:
                r14 = 0
                goto L_0x0121
            L_0x00a1:
                if (r13 == 0) goto L_0x00a4
                goto L_0x00b4
            L_0x00a4:
                org.spongycastle.math.ec.ECFieldElement r15 = r8.o()
                org.spongycastle.math.ec.ECFieldElement r6 = r15.j(r6)
                org.spongycastle.math.ec.ECFieldElement r15 = r15.j(r8)
                org.spongycastle.math.ec.ECFieldElement r7 = r15.j(r7)
            L_0x00b4:
                boolean r15 = r1.h()
                if (r15 == 0) goto L_0x00bb
                goto L_0x00cb
            L_0x00bb:
                org.spongycastle.math.ec.ECFieldElement r14 = r1.o()
                org.spongycastle.math.ec.ECFieldElement r4 = r14.j(r4)
                org.spongycastle.math.ec.ECFieldElement r14 = r14.j(r1)
                org.spongycastle.math.ec.ECFieldElement r5 = r14.j(r5)
            L_0x00cb:
                org.spongycastle.math.ec.ECFieldElement r6 = r4.r(r6)
                org.spongycastle.math.ec.ECFieldElement r7 = r5.r(r7)
                boolean r14 = r6.i()
                if (r14 == 0) goto L_0x00e9
                boolean r1 = r7.i()
                if (r1 == 0) goto L_0x00e4
                org.spongycastle.math.ec.ECPoint r1 = r16.x()
                return r1
            L_0x00e4:
                org.spongycastle.math.ec.ECPoint r1 = r3.l()
                return r1
            L_0x00e9:
                org.spongycastle.math.ec.ECFieldElement r14 = r6.o()
                org.spongycastle.math.ec.ECFieldElement r9 = r14.j(r6)
                org.spongycastle.math.ec.ECFieldElement r4 = r14.j(r4)
                org.spongycastle.math.ec.ECFieldElement r10 = r7.o()
                org.spongycastle.math.ec.ECFieldElement r10 = r10.a(r9)
                org.spongycastle.math.ec.ECFieldElement r12 = r4.a(r4)
                org.spongycastle.math.ec.ECFieldElement r10 = r10.r(r12)
                org.spongycastle.math.ec.ECFieldElement r4 = r4.r(r10)
                org.spongycastle.math.ec.ECFieldElement r4 = r4.k(r7, r9, r5)
                if (r13 != 0) goto L_0x0114
                org.spongycastle.math.ec.ECFieldElement r5 = r6.j(r8)
                goto L_0x0115
            L_0x0114:
                r5 = r6
            L_0x0115:
                if (r15 != 0) goto L_0x011c
                org.spongycastle.math.ec.ECFieldElement r1 = r5.j(r1)
                goto L_0x011d
            L_0x011c:
                r1 = r5
            L_0x011d:
                r5 = r4
                r4 = r10
                if (r1 != r6) goto L_0x009e
            L_0x0121:
                if (r2 != r11) goto L_0x0131
                org.spongycastle.math.ec.ECFieldElement r2 = r0.z(r1, r14)
                r6 = 2
                org.spongycastle.math.ec.ECFieldElement[] r6 = new org.spongycastle.math.ec.ECFieldElement[r6]
                r7 = 0
                r6[r7] = r1
                r8 = 1
                r6[r8] = r2
                goto L_0x0138
            L_0x0131:
                r7 = 0
                r8 = 1
                org.spongycastle.math.ec.ECFieldElement[] r2 = new org.spongycastle.math.ec.ECFieldElement[r8]
                r2[r7] = r1
                r6 = r2
            L_0x0138:
                org.spongycastle.math.ec.ECPoint$Fp r1 = new org.spongycastle.math.ec.ECPoint$Fp
                boolean r7 = r0.f6622a
                r2 = r1
                r2.<init>(r3, r4, r5, r6, r7)
                return r1
            L_0x0141:
                r2 = r10
                r8 = r8[r2]
                r1 = r1[r2]
                boolean r2 = r8.h()
                boolean r9 = r1.h()
                if (r2 == 0) goto L_0x0151
                goto L_0x0155
            L_0x0151:
                org.spongycastle.math.ec.ECFieldElement r7 = r7.j(r8)
            L_0x0155:
                if (r9 == 0) goto L_0x0158
                goto L_0x015c
            L_0x0158:
                org.spongycastle.math.ec.ECFieldElement r5 = r5.j(r1)
            L_0x015c:
                org.spongycastle.math.ec.ECFieldElement r7 = r7.r(r5)
                if (r2 == 0) goto L_0x0163
                goto L_0x0167
            L_0x0163:
                org.spongycastle.math.ec.ECFieldElement r6 = r6.j(r8)
            L_0x0167:
                if (r9 == 0) goto L_0x016a
                goto L_0x016e
            L_0x016a:
                org.spongycastle.math.ec.ECFieldElement r4 = r4.j(r1)
            L_0x016e:
                org.spongycastle.math.ec.ECFieldElement r6 = r6.r(r4)
                boolean r10 = r6.i()
                if (r10 == 0) goto L_0x0188
                boolean r1 = r7.i()
                if (r1 == 0) goto L_0x0183
                org.spongycastle.math.ec.ECPoint r1 = r16.x()
                return r1
            L_0x0183:
                org.spongycastle.math.ec.ECPoint r1 = r3.l()
                return r1
            L_0x0188:
                if (r2 == 0) goto L_0x018c
                r8 = r1
                goto L_0x0193
            L_0x018c:
                if (r9 == 0) goto L_0x018f
                goto L_0x0193
            L_0x018f:
                org.spongycastle.math.ec.ECFieldElement r8 = r8.j(r1)
            L_0x0193:
                org.spongycastle.math.ec.ECFieldElement r1 = r6.o()
                org.spongycastle.math.ec.ECFieldElement r2 = r1.j(r6)
                org.spongycastle.math.ec.ECFieldElement r1 = r1.j(r4)
                org.spongycastle.math.ec.ECFieldElement r4 = r7.o()
                org.spongycastle.math.ec.ECFieldElement r4 = r4.j(r8)
                org.spongycastle.math.ec.ECFieldElement r4 = r4.r(r2)
                org.spongycastle.math.ec.ECFieldElement r9 = r1.a(r1)
                org.spongycastle.math.ec.ECFieldElement r4 = r4.r(r9)
                org.spongycastle.math.ec.ECFieldElement r6 = r6.j(r4)
                org.spongycastle.math.ec.ECFieldElement r1 = r1.r(r4)
                org.spongycastle.math.ec.ECFieldElement r5 = r1.k(r7, r5, r2)
                org.spongycastle.math.ec.ECFieldElement r1 = r2.j(r8)
                org.spongycastle.math.ec.ECPoint$Fp r8 = new org.spongycastle.math.ec.ECPoint$Fp
                r2 = 1
                org.spongycastle.math.ec.ECFieldElement[] r7 = new org.spongycastle.math.ec.ECFieldElement[r2]
                r2 = 0
                r7[r2] = r1
                boolean r1 = r0.f6622a
                r2 = r8
                r4 = r6
                r6 = r7
                r7 = r1
                r2.<init>(r3, r4, r5, r6, r7)
                return r8
            L_0x01d5:
                org.spongycastle.math.ec.ECFieldElement r1 = r6.r(r4)
                org.spongycastle.math.ec.ECFieldElement r2 = r7.r(r5)
                boolean r7 = r1.i()
                if (r7 == 0) goto L_0x01f3
                boolean r1 = r2.i()
                if (r1 == 0) goto L_0x01ee
                org.spongycastle.math.ec.ECPoint r1 = r16.x()
                return r1
            L_0x01ee:
                org.spongycastle.math.ec.ECPoint r1 = r3.l()
                return r1
            L_0x01f3:
                org.spongycastle.math.ec.ECFieldElement r1 = r2.d(r1)
                org.spongycastle.math.ec.ECFieldElement r2 = r1.o()
                org.spongycastle.math.ec.ECFieldElement r2 = r2.r(r4)
                org.spongycastle.math.ec.ECFieldElement r2 = r2.r(r6)
                org.spongycastle.math.ec.ECFieldElement r4 = r4.r(r2)
                org.spongycastle.math.ec.ECFieldElement r1 = r1.j(r4)
                org.spongycastle.math.ec.ECFieldElement r1 = r1.r(r5)
                org.spongycastle.math.ec.ECPoint$Fp r4 = new org.spongycastle.math.ec.ECPoint$Fp
                boolean r5 = r0.f6622a
                r4.<init>(r3, r2, r1, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.math.ec.ECPoint.Fp.a(org.spongycastle.math.ec.ECPoint):org.spongycastle.math.ec.ECPoint");
        }

        public final ECPoint c() {
            b();
            return new Fp((ECCurve) null, this.f6621a, e(), false);
        }

        public final ECFieldElement j() {
            return ECPoint.super.j();
        }

        public final ECPoint n() {
            if (k()) {
                return this;
            }
            ECCurve eCCurve = this.f6620a;
            int i = eCCurve.a;
            ECFieldElement eCFieldElement = this.f6624b;
            if (i != 0) {
                return new Fp(eCCurve, this.f6621a, eCFieldElement.m(), this.f6623a, this.f6622a);
            }
            return new Fp(eCCurve, this.f6621a, eCFieldElement.m(), this.f6622a);
        }

        public final ECPoint v() {
            if (k()) {
                return this;
            }
            ECFieldElement eCFieldElement = this.f6624b;
            if (eCFieldElement.i()) {
                return this;
            }
            ECCurve eCCurve = this.f6620a;
            int i = eCCurve.a;
            if (i == 0) {
                ECFieldElement a = eCFieldElement.a(eCFieldElement);
                ECFieldElement o = a.o();
                ECFieldElement eCFieldElement2 = this.f6621a;
                ECFieldElement a2 = B(eCFieldElement2.o()).a(eCCurve.f6610a);
                ECFieldElement r = eCFieldElement2.a(eCFieldElement2).a(eCFieldElement2).j(o).r(a2.o());
                if (r.i()) {
                    return eCCurve.l();
                }
                ECFieldElement g = r.j(a).g();
                ECFieldElement j = r.j(g).j(a2);
                ECFieldElement r2 = o.o().j(g).r(j);
                ECFieldElement a3 = r2.r(j).j(j.a(r2)).a(eCFieldElement2);
                return new Fp(eCCurve, a3, eCFieldElement2.r(a3).j(r2).r(eCFieldElement), this.f6622a);
            } else if (i != 4) {
                return x().a(this);
            } else {
                return C(false).a(this);
            }
        }

        public final ECPoint w(int i) {
            ECFieldElement eCFieldElement;
            ECFieldElement j;
            int i2 = i;
            if (i2 < 0) {
                throw new IllegalArgumentException("'e' cannot be negative");
            } else if (i2 == 0 || k()) {
                return this;
            } else {
                if (i2 == 1) {
                    return x();
                }
                ECFieldElement eCFieldElement2 = this.f6624b;
                boolean i3 = eCFieldElement2.i();
                ECCurve eCCurve = this.f6620a;
                if (i3) {
                    return eCCurve.l();
                }
                int i4 = eCCurve.a;
                ECFieldElement eCFieldElement3 = eCCurve.f6610a;
                ECFieldElement[] eCFieldElementArr = this.f6623a;
                if (eCFieldElementArr.length < 1) {
                    eCFieldElement = eCCurve.j(ECConstants.b);
                } else {
                    eCFieldElement = eCFieldElementArr[0];
                }
                boolean h = eCFieldElement.h();
                ECFieldElement eCFieldElement4 = this.f6621a;
                if (!h && i4 != 0) {
                    if (i4 == 1) {
                        ECFieldElement o = eCFieldElement.o();
                        eCFieldElement4 = eCFieldElement4.j(eCFieldElement);
                        eCFieldElement2 = eCFieldElement2.j(o);
                        eCFieldElement3 = z(eCFieldElement, o);
                    } else if (i4 == 2) {
                        eCFieldElement3 = z(eCFieldElement, (ECFieldElement) null);
                    } else if (i4 == 4) {
                        eCFieldElement3 = A();
                    } else {
                        throw new IllegalStateException("unsupported coordinate system");
                    }
                }
                ECFieldElement eCFieldElement5 = eCFieldElement2;
                int i5 = 0;
                while (i5 < i2) {
                    if (eCFieldElement5.i()) {
                        return eCCurve.l();
                    }
                    ECFieldElement B = B(eCFieldElement4.o());
                    ECFieldElement a = eCFieldElement5.a(eCFieldElement5);
                    ECFieldElement j2 = a.j(eCFieldElement5);
                    ECFieldElement j3 = eCFieldElement4.j(j2);
                    ECFieldElement a2 = j3.a(j3);
                    ECFieldElement o2 = j2.o();
                    ECFieldElement a3 = o2.a(o2);
                    if (!eCFieldElement3.i()) {
                        B = B.a(eCFieldElement3);
                        ECFieldElement j4 = a3.j(eCFieldElement3);
                        eCFieldElement3 = j4.a(j4);
                    }
                    ECFieldElement r = B.o().r(a2.a(a2));
                    eCFieldElement5 = B.j(a2.r(r)).r(a3);
                    if (eCFieldElement.h()) {
                        j = a;
                    } else {
                        j = a.j(eCFieldElement);
                    }
                    i5++;
                    eCFieldElement4 = r;
                }
                if (i4 == 0) {
                    ECFieldElement g = eCFieldElement.g();
                    ECFieldElement o3 = g.o();
                    return new Fp(eCCurve, eCFieldElement4.j(o3), eCFieldElement5.j(o3.j(g)), this.f6622a);
                } else if (i4 == 1) {
                    return new Fp(eCCurve, eCFieldElement4.j(eCFieldElement), eCFieldElement5, new ECFieldElement[]{eCFieldElement.j(eCFieldElement.o())}, this.f6622a);
                } else if (i4 == 2) {
                    return new Fp(eCCurve, eCFieldElement4, eCFieldElement5, new ECFieldElement[]{eCFieldElement}, this.f6622a);
                } else if (i4 == 4) {
                    return new Fp(eCCurve, eCFieldElement4, eCFieldElement5, new ECFieldElement[]{eCFieldElement, eCFieldElement3}, this.f6622a);
                } else {
                    throw new IllegalStateException("unsupported coordinate system");
                }
            }
        }

        public final ECPoint x() {
            ECFieldElement eCFieldElement;
            ECFieldElement eCFieldElement2;
            ECFieldElement eCFieldElement3;
            ECFieldElement eCFieldElement4;
            ECFieldElement eCFieldElement5;
            ECFieldElement eCFieldElement6;
            if (k()) {
                return this;
            }
            ECFieldElement eCFieldElement7 = this.f6624b;
            boolean i = eCFieldElement7.i();
            ECCurve eCCurve = this.f6620a;
            if (i) {
                return eCCurve.l();
            }
            int i2 = eCCurve.a;
            ECFieldElement eCFieldElement8 = this.f6621a;
            if (i2 != 0) {
                ECFieldElement[] eCFieldElementArr = this.f6623a;
                if (i2 == 1) {
                    ECFieldElement eCFieldElement9 = eCFieldElementArr[0];
                    boolean h = eCFieldElement9.h();
                    ECFieldElement eCFieldElement10 = eCCurve.f6610a;
                    if (!eCFieldElement10.i() && !h) {
                        eCFieldElement10 = eCFieldElement10.j(eCFieldElement9.o());
                    }
                    ECFieldElement a = eCFieldElement10.a(B(eCFieldElement8.o()));
                    if (h) {
                        eCFieldElement = eCFieldElement7;
                    } else {
                        eCFieldElement = eCFieldElement7.j(eCFieldElement9);
                    }
                    if (h) {
                        eCFieldElement2 = eCFieldElement7.o();
                    } else {
                        eCFieldElement2 = eCFieldElement.j(eCFieldElement7);
                    }
                    ECFieldElement j = eCFieldElement8.j(eCFieldElement2);
                    ECFieldElement a2 = j.a(j);
                    ECFieldElement a3 = a2.a(a2);
                    ECFieldElement r = a.o().r(a3.a(a3));
                    ECFieldElement a4 = eCFieldElement.a(eCFieldElement);
                    ECFieldElement j2 = r.j(a4);
                    ECFieldElement a5 = eCFieldElement2.a(eCFieldElement2);
                    ECFieldElement j3 = a3.r(r).j(a);
                    ECFieldElement o = a5.o();
                    ECFieldElement r2 = j3.r(o.a(o));
                    if (h) {
                        eCFieldElement3 = a5.a(a5);
                    } else {
                        eCFieldElement3 = a4.o();
                    }
                    return new Fp(eCCurve, j2, r2, new ECFieldElement[]{eCFieldElement3.a(eCFieldElement3).j(eCFieldElement)}, this.f6622a);
                } else if (i2 == 2) {
                    ECFieldElement eCFieldElement11 = eCFieldElementArr[0];
                    boolean h2 = eCFieldElement11.h();
                    ECFieldElement o2 = eCFieldElement7.o();
                    ECFieldElement o3 = o2.o();
                    ECFieldElement eCFieldElement12 = eCCurve.f6610a;
                    ECFieldElement m = eCFieldElement12.m();
                    if (m.t().equals(BigInteger.valueOf(3))) {
                        if (h2) {
                            eCFieldElement6 = eCFieldElement11;
                        } else {
                            eCFieldElement6 = eCFieldElement11.o();
                        }
                        eCFieldElement4 = B(eCFieldElement8.a(eCFieldElement6).j(eCFieldElement8.r(eCFieldElement6)));
                        ECFieldElement j4 = o2.j(eCFieldElement8);
                        ECFieldElement a6 = j4.a(j4);
                        eCFieldElement5 = a6.a(a6);
                    } else {
                        ECFieldElement B = B(eCFieldElement8.o());
                        if (h2) {
                            eCFieldElement4 = B.a(eCFieldElement12);
                        } else if (!eCFieldElement12.i()) {
                            ECFieldElement o4 = eCFieldElement11.o().o();
                            if (m.c() < eCFieldElement12.c()) {
                                eCFieldElement4 = B.r(o4.j(m));
                            } else {
                                eCFieldElement4 = B.a(o4.j(eCFieldElement12));
                            }
                        } else {
                            eCFieldElement4 = B;
                        }
                        ECFieldElement j5 = eCFieldElement8.j(o2);
                        ECFieldElement a7 = j5.a(j5);
                        eCFieldElement5 = a7.a(a7);
                    }
                    ECFieldElement r3 = eCFieldElement4.o().r(eCFieldElement5.a(eCFieldElement5));
                    ECFieldElement j6 = eCFieldElement5.r(r3).j(eCFieldElement4);
                    ECFieldElement a8 = o3.a(o3);
                    ECFieldElement a9 = a8.a(a8);
                    ECFieldElement r4 = j6.r(a9.a(a9));
                    ECFieldElement a10 = eCFieldElement7.a(eCFieldElement7);
                    if (!h2) {
                        a10 = a10.j(eCFieldElement11);
                    }
                    return new Fp(eCCurve, r3, r4, new ECFieldElement[]{a10}, this.f6622a);
                } else if (i2 == 4) {
                    return C(true);
                } else {
                    throw new IllegalStateException("unsupported coordinate system");
                }
            } else {
                ECFieldElement d = B(eCFieldElement8.o()).a(eCCurve.f6610a).d(eCFieldElement7.a(eCFieldElement7));
                ECFieldElement r5 = d.o().r(eCFieldElement8.a(eCFieldElement8));
                return new Fp(eCCurve, r5, d.j(eCFieldElement8.r(r5)).r(eCFieldElement7), this.f6622a);
            }
        }

        public final ECPoint y(ECPoint eCPoint) {
            if (this == eCPoint) {
                return v();
            }
            if (k()) {
                return eCPoint;
            }
            if (eCPoint.k()) {
                return x();
            }
            ECFieldElement eCFieldElement = this.f6624b;
            if (eCFieldElement.i()) {
                return eCPoint;
            }
            ECCurve eCCurve = this.f6620a;
            int i = eCCurve.a;
            if (i == 0) {
                ECFieldElement eCFieldElement2 = eCPoint.f6621a;
                ECFieldElement eCFieldElement3 = this.f6621a;
                ECFieldElement r = eCFieldElement2.r(eCFieldElement3);
                ECFieldElement r2 = eCPoint.f6624b.r(eCFieldElement);
                if (!r.i()) {
                    ECFieldElement o = r.o();
                    ECFieldElement r3 = o.j(eCFieldElement3.a(eCFieldElement3).a(eCFieldElement2)).r(r2.o());
                    if (r3.i()) {
                        return eCCurve.l();
                    }
                    ECFieldElement g = r3.j(r).g();
                    ECFieldElement j = r3.j(g).j(r2);
                    ECFieldElement r4 = eCFieldElement.a(eCFieldElement).j(o).j(r).j(g).r(j);
                    ECFieldElement a = r4.r(j).j(j.a(r4)).a(eCFieldElement2);
                    return new Fp(eCCurve, a, eCFieldElement3.r(a).j(r4).r(eCFieldElement), this.f6622a);
                } else if (r2.i()) {
                    return v();
                } else {
                    return this;
                }
            } else if (i != 4) {
                return x().a(eCPoint);
            } else {
                return C(false).a(eCPoint);
            }
        }

        public final ECFieldElement z(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            ECFieldElement eCFieldElement3 = this.f6620a.f6610a;
            if (eCFieldElement3.i() || eCFieldElement.h()) {
                return eCFieldElement3;
            }
            if (eCFieldElement2 == null) {
                eCFieldElement2 = eCFieldElement.o();
            }
            ECFieldElement o = eCFieldElement2.o();
            ECFieldElement m = eCFieldElement3.m();
            if (m.c() < eCFieldElement3.c()) {
                return o.j(m).m();
            }
            return o.j(eCFieldElement3);
        }

        public Fp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
            super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
            this.f6622a = z;
        }
    }

    public static class F2m extends AbstractF2m {
        public F2m() {
            throw null;
        }

        public F2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
            if ((eCFieldElement == null) == (eCFieldElement2 != null ? false : true)) {
                if (eCFieldElement != null) {
                    ECFieldElement.F2m.u(eCFieldElement, eCFieldElement2);
                    if (eCCurve != null) {
                        ECFieldElement.F2m.u(eCFieldElement, eCCurve.f6610a);
                    }
                }
                this.f6622a = z;
                return;
            }
            throw new IllegalArgumentException("Exactly one of the field elements is null");
        }

        public final ECPoint a(ECPoint eCPoint) {
            ECFieldElement eCFieldElement;
            ECFieldElement eCFieldElement2;
            ECFieldElement eCFieldElement3;
            ECFieldElement eCFieldElement4;
            ECFieldElement eCFieldElement5;
            ECFieldElement eCFieldElement6;
            ECFieldElement eCFieldElement7;
            ECFieldElement eCFieldElement8;
            ECFieldElement eCFieldElement9;
            if (k()) {
                return eCPoint;
            }
            if (eCPoint.k()) {
                return this;
            }
            ECCurve eCCurve = this.f6620a;
            int i = eCCurve.a;
            ECFieldElement eCFieldElement10 = this.f6624b;
            ECFieldElement eCFieldElement11 = eCPoint.f6624b;
            ECFieldElement eCFieldElement12 = this.f6621a;
            ECFieldElement eCFieldElement13 = eCPoint.f6621a;
            if (i != 0) {
                ECFieldElement[] eCFieldElementArr = this.f6623a;
                ECFieldElement[] eCFieldElementArr2 = eCPoint.f6623a;
                if (i == 1) {
                    ECFieldElement eCFieldElement14 = eCFieldElementArr[0];
                    ECFieldElement eCFieldElement15 = eCFieldElementArr2[0];
                    boolean h = eCFieldElement15.h();
                    ECFieldElement j = eCFieldElement14.j(eCFieldElement11);
                    if (h) {
                        eCFieldElement = eCFieldElement10;
                    } else {
                        eCFieldElement = eCFieldElement10.j(eCFieldElement15);
                    }
                    ECFieldElement a = j.a(eCFieldElement);
                    ECFieldElement j2 = eCFieldElement14.j(eCFieldElement13);
                    if (h) {
                        eCFieldElement2 = eCFieldElement12;
                    } else {
                        eCFieldElement2 = eCFieldElement12.j(eCFieldElement15);
                    }
                    ECFieldElement a2 = j2.a(eCFieldElement2);
                    if (!a2.i()) {
                        ECFieldElement o = a2.o();
                        ECFieldElement j3 = o.j(a2);
                        if (!h) {
                            eCFieldElement14 = eCFieldElement14.j(eCFieldElement15);
                        }
                        ECFieldElement a3 = a.a(a2);
                        ECFieldElement a4 = a3.l(a, o, eCCurve.f6610a).j(eCFieldElement14).a(j3);
                        ECFieldElement j4 = a2.j(a4);
                        if (!h) {
                            o = o.j(eCFieldElement15);
                        }
                        ECFieldElement l = a.l(eCFieldElement12, a2, eCFieldElement10).l(o, a3, a4);
                        return new F2m(eCCurve, j4, l, new ECFieldElement[]{j3.j(eCFieldElement14)}, this.f6622a);
                    } else if (a.i()) {
                        return x();
                    } else {
                        return eCCurve.l();
                    }
                } else if (i != 6) {
                    throw new IllegalStateException("unsupported coordinate system");
                } else if (!eCFieldElement12.i()) {
                    ECFieldElement eCFieldElement16 = eCFieldElementArr[0];
                    ECFieldElement eCFieldElement17 = eCFieldElementArr2[0];
                    boolean h2 = eCFieldElement16.h();
                    if (!h2) {
                        eCFieldElement4 = eCFieldElement13.j(eCFieldElement16);
                        eCFieldElement3 = eCFieldElement11.j(eCFieldElement16);
                    } else {
                        eCFieldElement3 = eCFieldElement11;
                        eCFieldElement4 = eCFieldElement13;
                    }
                    boolean h3 = eCFieldElement17.h();
                    if (!h3) {
                        eCFieldElement12 = eCFieldElement12.j(eCFieldElement17);
                        eCFieldElement5 = eCFieldElement10.j(eCFieldElement17);
                    } else {
                        eCFieldElement5 = eCFieldElement10;
                    }
                    ECFieldElement a5 = eCFieldElement5.a(eCFieldElement3);
                    ECFieldElement a6 = eCFieldElement12.a(eCFieldElement4);
                    if (!a6.i()) {
                        if (eCFieldElement13.i()) {
                            ECPoint o2 = o();
                            ECFieldElement eCFieldElement18 = o2.f6621a;
                            ECFieldElement i2 = o2.i();
                            ECFieldElement d = i2.a(eCFieldElement11).d(eCFieldElement18);
                            eCFieldElement7 = xx.N(d, d, eCFieldElement18).a(eCCurve.f6610a);
                            if (eCFieldElement7.i()) {
                                return new F2m(eCCurve, eCFieldElement7, eCCurve.f6614b.n(), this.f6622a);
                            }
                            ECFieldElement a7 = d.j(eCFieldElement18.a(eCFieldElement7)).a(eCFieldElement7).a(i2).d(eCFieldElement7).a(eCFieldElement7);
                            eCFieldElement8 = eCCurve.j(ECConstants.b);
                            eCFieldElement6 = a7;
                        } else {
                            ECFieldElement o3 = a6.o();
                            ECFieldElement j5 = a5.j(eCFieldElement12);
                            ECFieldElement j6 = a5.j(eCFieldElement4);
                            ECFieldElement j7 = j5.j(j6);
                            if (j7.i()) {
                                return new F2m(eCCurve, j7, eCCurve.f6614b.n(), this.f6622a);
                            }
                            ECFieldElement j8 = a5.j(o3);
                            if (!h3) {
                                j8 = j8.j(eCFieldElement17);
                            }
                            ECFieldElement p = j6.a(o3).p(j8, eCFieldElement10.a(eCFieldElement16));
                            if (!h2) {
                                eCFieldElement9 = j8.j(eCFieldElement16);
                            } else {
                                eCFieldElement9 = j8;
                            }
                            eCFieldElement7 = j7;
                            eCFieldElement6 = p;
                            eCFieldElement8 = eCFieldElement9;
                        }
                        return new F2m(eCCurve, eCFieldElement7, eCFieldElement6, new ECFieldElement[]{eCFieldElement8}, this.f6622a);
                    } else if (a5.i()) {
                        return x();
                    } else {
                        return eCCurve.l();
                    }
                } else if (eCFieldElement13.i()) {
                    return eCCurve.l();
                } else {
                    return eCPoint.a(this);
                }
            } else {
                ECFieldElement a8 = eCFieldElement12.a(eCFieldElement13);
                ECFieldElement a9 = eCFieldElement10.a(eCFieldElement11);
                if (!a8.i()) {
                    ECFieldElement d2 = a9.d(a8);
                    ECFieldElement a10 = xx.N(d2, d2, a8).a(eCCurve.f6610a);
                    return new F2m(eCCurve, a10, d2.j(eCFieldElement12.a(a10)).a(a10).a(eCFieldElement10), this.f6622a);
                } else if (a9.i()) {
                    return x();
                } else {
                    return eCCurve.l();
                }
            }
        }

        public final ECPoint c() {
            b();
            return new F2m((ECCurve) null, this.f6621a, e(), false);
        }

        public final boolean f() {
            ECFieldElement eCFieldElement = this.f6621a;
            if (eCFieldElement.i()) {
                return false;
            }
            int g = g();
            ECFieldElement eCFieldElement2 = this.f6624b;
            if (g != 5 && g != 6) {
                return eCFieldElement2.d(eCFieldElement).s();
            }
            if (eCFieldElement2.s() != eCFieldElement.s()) {
                return true;
            }
            return false;
        }

        public final ECFieldElement i() {
            int g = g();
            ECFieldElement eCFieldElement = this.f6624b;
            if ((g == 5 || g == 6) && !k()) {
                ECFieldElement eCFieldElement2 = this.f6621a;
                if (!eCFieldElement2.i()) {
                    ECFieldElement j = eCFieldElement.a(eCFieldElement2).j(eCFieldElement2);
                    if (6 != g) {
                        return j;
                    }
                    ECFieldElement eCFieldElement3 = this.f6623a[0];
                    if (!eCFieldElement3.h()) {
                        return j.d(eCFieldElement3);
                    }
                    return j;
                }
            }
            return eCFieldElement;
        }

        public final ECPoint n() {
            if (k()) {
                return this;
            }
            ECFieldElement eCFieldElement = this.f6621a;
            if (eCFieldElement.i()) {
                return this;
            }
            int g = g();
            ECCurve eCCurve = this.f6620a;
            ECFieldElement eCFieldElement2 = this.f6624b;
            if (g == 0) {
                return new F2m(eCCurve, eCFieldElement, eCFieldElement2.a(eCFieldElement), this.f6622a);
            }
            ECFieldElement[] eCFieldElementArr = this.f6623a;
            if (g == 1) {
                ECFieldElement eCFieldElement3 = eCFieldElementArr[0];
                ECCurve eCCurve2 = this.f6620a;
                ECFieldElement a = eCFieldElement2.a(eCFieldElement);
                return new F2m(eCCurve2, eCFieldElement, a, new ECFieldElement[]{eCFieldElement3}, this.f6622a);
            } else if (g == 5) {
                return new F2m(eCCurve, eCFieldElement, eCFieldElement2.b(), this.f6622a);
            } else {
                if (g == 6) {
                    ECFieldElement eCFieldElement4 = eCFieldElementArr[0];
                    ECCurve eCCurve3 = this.f6620a;
                    ECFieldElement a2 = eCFieldElement2.a(eCFieldElement4);
                    return new F2m(eCCurve3, eCFieldElement, a2, new ECFieldElement[]{eCFieldElement4}, this.f6622a);
                }
                throw new IllegalStateException("unsupported coordinate system");
            }
        }

        public final ECPoint x() {
            ECFieldElement eCFieldElement;
            ECFieldElement eCFieldElement2;
            ECFieldElement eCFieldElement3;
            ECFieldElement eCFieldElement4;
            ECFieldElement eCFieldElement5;
            ECFieldElement eCFieldElement6;
            ECFieldElement eCFieldElement7;
            if (k()) {
                return this;
            }
            ECFieldElement eCFieldElement8 = this.f6621a;
            boolean i = eCFieldElement8.i();
            ECCurve eCCurve = this.f6620a;
            if (i) {
                return eCCurve.l();
            }
            int i2 = eCCurve.a;
            ECFieldElement eCFieldElement9 = this.f6624b;
            if (i2 != 0) {
                ECFieldElement[] eCFieldElementArr = this.f6623a;
                if (i2 == 1) {
                    ECFieldElement eCFieldElement10 = eCFieldElementArr[0];
                    boolean h = eCFieldElement10.h();
                    if (h) {
                        eCFieldElement = eCFieldElement8;
                    } else {
                        eCFieldElement = eCFieldElement8.j(eCFieldElement10);
                    }
                    if (!h) {
                        eCFieldElement9 = eCFieldElement9.j(eCFieldElement10);
                    }
                    ECFieldElement o = eCFieldElement8.o();
                    ECFieldElement a = o.a(eCFieldElement9);
                    ECFieldElement o2 = eCFieldElement.o();
                    ECFieldElement a2 = a.a(eCFieldElement);
                    ECFieldElement l = a2.l(a, o2, eCCurve.f6610a);
                    return new F2m(eCCurve, eCFieldElement.j(l), o.o().l(eCFieldElement, l, a2), new ECFieldElement[]{eCFieldElement.j(o2)}, this.f6622a);
                } else if (i2 == 6) {
                    ECFieldElement eCFieldElement11 = eCFieldElementArr[0];
                    boolean h2 = eCFieldElement11.h();
                    if (h2) {
                        eCFieldElement2 = eCFieldElement9;
                    } else {
                        eCFieldElement2 = eCFieldElement9.j(eCFieldElement11);
                    }
                    if (h2) {
                        eCFieldElement3 = eCFieldElement11;
                    } else {
                        eCFieldElement3 = eCFieldElement11.o();
                    }
                    ECFieldElement eCFieldElement12 = eCCurve.f6610a;
                    if (h2) {
                        eCFieldElement4 = eCFieldElement12;
                    } else {
                        eCFieldElement4 = eCFieldElement12.j(eCFieldElement3);
                    }
                    ECFieldElement N = xx.N(eCFieldElement9, eCFieldElement2, eCFieldElement4);
                    if (N.i()) {
                        return new F2m(eCCurve, N, eCCurve.f6614b.n(), this.f6622a);
                    }
                    ECFieldElement o3 = N.o();
                    if (h2) {
                        eCFieldElement5 = N;
                    } else {
                        eCFieldElement5 = N.j(eCFieldElement3);
                    }
                    ECFieldElement eCFieldElement13 = eCCurve.f6614b;
                    if (eCFieldElement13.c() < (eCCurve.k() >> 1)) {
                        ECFieldElement o4 = eCFieldElement9.a(eCFieldElement8).o();
                        if (eCFieldElement13.h()) {
                            eCFieldElement7 = eCFieldElement4.a(eCFieldElement3).o();
                        } else {
                            eCFieldElement7 = eCFieldElement4.p(eCFieldElement13, eCFieldElement3.o());
                        }
                        eCFieldElement6 = o4.a(N).a(eCFieldElement3).j(o4).a(eCFieldElement7).a(o3);
                        if (eCFieldElement12.i()) {
                            eCFieldElement6 = eCFieldElement6.a(eCFieldElement5);
                        } else if (!eCFieldElement12.h()) {
                            eCFieldElement6 = eCFieldElement6.a(eCFieldElement12.b().j(eCFieldElement5));
                        }
                    } else {
                        if (!h2) {
                            eCFieldElement8 = eCFieldElement8.j(eCFieldElement11);
                        }
                        eCFieldElement6 = eCFieldElement8.p(N, eCFieldElement2).a(o3).a(eCFieldElement5);
                    }
                    return new F2m(eCCurve, o3, eCFieldElement6, new ECFieldElement[]{eCFieldElement5}, this.f6622a);
                } else {
                    throw new IllegalStateException("unsupported coordinate system");
                }
            } else {
                ECFieldElement a3 = eCFieldElement9.d(eCFieldElement8).a(eCFieldElement8);
                ECFieldElement a4 = a3.o().a(a3).a(eCCurve.f6610a);
                return new F2m(eCCurve, a4, eCFieldElement8.p(a4, a3.b()), this.f6622a);
            }
        }

        public final ECPoint y(ECPoint eCPoint) {
            if (k()) {
                return eCPoint;
            }
            if (eCPoint.k()) {
                return x();
            }
            ECFieldElement eCFieldElement = this.f6621a;
            if (eCFieldElement.i()) {
                return eCPoint;
            }
            ECCurve eCCurve = this.f6620a;
            if (eCCurve.a != 6) {
                return x().a(eCPoint);
            }
            ECFieldElement eCFieldElement2 = eCPoint.f6623a[0];
            ECFieldElement eCFieldElement3 = eCPoint.f6621a;
            if (eCFieldElement3.i() || !eCFieldElement2.h()) {
                return x().a(eCPoint);
            }
            ECFieldElement eCFieldElement4 = this.f6623a[0];
            ECFieldElement o = eCFieldElement.o();
            ECFieldElement eCFieldElement5 = this.f6624b;
            ECFieldElement o2 = eCFieldElement5.o();
            ECFieldElement o3 = eCFieldElement4.o();
            ECFieldElement a = eCCurve.f6610a.j(o3).a(o2).a(eCFieldElement5.j(eCFieldElement4));
            ECFieldElement b = eCPoint.f6624b.b();
            ECFieldElement l = eCCurve.f6610a.a(b).j(o3).a(o2).l(a, o, o3);
            ECFieldElement j = eCFieldElement3.j(o3);
            ECFieldElement o4 = j.a(a).o();
            if (o4.i()) {
                if (l.i()) {
                    return eCPoint.x();
                }
                return eCCurve.l();
            } else if (l.i()) {
                return new F2m(eCCurve, l, eCCurve.f6614b.n(), this.f6622a);
            } else {
                ECFieldElement j2 = l.o().j(j);
                ECFieldElement j3 = l.j(o4).j(o3);
                return new F2m(eCCurve, j2, l.a(o4).o().l(a, b, j3), new ECFieldElement[]{j3}, this.f6622a);
            }
        }

        public F2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
            super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
            this.f6622a = z;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ECPoint(org.spongycastle.math.ec.ECCurve r7, org.spongycastle.math.ec.ECFieldElement r8, org.spongycastle.math.ec.ECFieldElement r9) {
        /*
            r6 = this;
            r0 = 0
            if (r7 != 0) goto L_0x0005
            r1 = r0
            goto L_0x0007
        L_0x0005:
            int r1 = r7.a
        L_0x0007:
            if (r1 == 0) goto L_0x0041
            r2 = 5
            if (r1 == r2) goto L_0x0041
            java.math.BigInteger r2 = org.spongycastle.math.ec.ECConstants.b
            org.spongycastle.math.ec.ECFieldElement r2 = r7.j(r2)
            r3 = 1
            if (r1 == r3) goto L_0x003c
            r4 = 2
            if (r1 == r4) goto L_0x003c
            r5 = 3
            if (r1 == r5) goto L_0x0033
            r5 = 4
            if (r1 == r5) goto L_0x002a
            r4 = 6
            if (r1 != r4) goto L_0x0022
            goto L_0x003c
        L_0x0022:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "unknown coordinate system"
            r7.<init>(r8)
            throw r7
        L_0x002a:
            org.spongycastle.math.ec.ECFieldElement[] r1 = new org.spongycastle.math.ec.ECFieldElement[r4]
            r1[r0] = r2
            org.spongycastle.math.ec.ECFieldElement r0 = r7.f6610a
            r1[r3] = r0
            goto L_0x0043
        L_0x0033:
            org.spongycastle.math.ec.ECFieldElement[] r1 = new org.spongycastle.math.ec.ECFieldElement[r5]
            r1[r0] = r2
            r1[r3] = r2
            r1[r4] = r2
            goto L_0x0043
        L_0x003c:
            org.spongycastle.math.ec.ECFieldElement[] r1 = new org.spongycastle.math.ec.ECFieldElement[r3]
            r1[r0] = r2
            goto L_0x0043
        L_0x0041:
            org.spongycastle.math.ec.ECFieldElement[] r1 = b
        L_0x0043:
            r6.<init>(r7, r8, r9, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.math.ec.ECPoint.<init>(org.spongycastle.math.ec.ECCurve, org.spongycastle.math.ec.ECFieldElement, org.spongycastle.math.ec.ECFieldElement):void");
    }
}
