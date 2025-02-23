package org.spongycastle.math.ec;

import java.math.BigInteger;
import java.util.Hashtable;
import java.util.Random;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.ec.endo.ECEndomorphism;
import org.spongycastle.math.ec.endo.GLVEndomorphism;
import org.spongycastle.math.field.FiniteField;
import org.spongycastle.math.field.FiniteFields;
import org.spongycastle.util.BigIntegers;

public abstract class ECCurve {
    public int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public BigInteger f6609a;

    /* renamed from: a  reason: collision with other field name */
    public ECFieldElement f6610a;

    /* renamed from: a  reason: collision with other field name */
    public ECMultiplier f6611a = null;

    /* renamed from: a  reason: collision with other field name */
    public ECEndomorphism f6612a = null;

    /* renamed from: a  reason: collision with other field name */
    public final FiniteField f6613a;
    public BigInteger b;

    /* renamed from: b  reason: collision with other field name */
    public ECFieldElement f6614b;

    public static abstract class AbstractF2m extends ECCurve {
        public BigInteger[] a;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public AbstractF2m(int r6, int r7, int r8, int r9) {
            /*
                r5 = this;
                if (r7 == 0) goto L_0x004c
                r0 = 2
                r1 = 1
                r2 = 3
                r3 = 0
                if (r8 != 0) goto L_0x001f
                if (r9 != 0) goto L_0x0017
                int[] r8 = new int[r2]
                r8[r3] = r3
                r8[r1] = r7
                r8[r0] = r6
                org.spongycastle.math.field.PolynomialExtensionField r6 = org.spongycastle.math.field.FiniteFields.a(r8)
                goto L_0x0035
            L_0x0017:
                java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
                java.lang.String r7 = "k3 must be 0 if k2 == 0"
                r6.<init>(r7)
                throw r6
            L_0x001f:
                if (r8 <= r7) goto L_0x0044
                if (r9 <= r8) goto L_0x003c
                r4 = 5
                int[] r4 = new int[r4]
                r4[r3] = r3
                r4[r1] = r7
                r4[r0] = r8
                r4[r2] = r9
                r7 = 4
                r4[r7] = r6
                org.spongycastle.math.field.PolynomialExtensionField r6 = org.spongycastle.math.field.FiniteFields.a(r4)
            L_0x0035:
                r5.<init>(r6)
                r6 = 0
                r5.a = r6
                return
            L_0x003c:
                java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
                java.lang.String r7 = "k3 must be > k2"
                r6.<init>(r7)
                throw r6
            L_0x0044:
                java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
                java.lang.String r7 = "k2 must be > k1"
                r6.<init>(r7)
                throw r6
            L_0x004c:
                java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
                java.lang.String r7 = "k1 must be > 0"
                r6.<init>(r7)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.math.ec.ECCurve.AbstractF2m.<init>(int, int, int, int):void");
        }

        public final ECPoint d(BigInteger bigInteger, BigInteger bigInteger2, boolean z) {
            ECFieldElement j = j(bigInteger);
            ECFieldElement j2 = j(bigInteger2);
            int i = this.a;
            if (i == 5 || i == 6) {
                if (!j.i()) {
                    j2 = j2.d(j).a(j);
                } else if (!j2.o().equals(this.f6614b)) {
                    throw new IllegalArgumentException();
                }
            }
            return e(j, j2, z);
        }

        public final ECPoint h(int i, BigInteger bigInteger) {
            ECFieldElement eCFieldElement;
            boolean z;
            ECFieldElement j = j(bigInteger);
            if (j.i()) {
                eCFieldElement = this.f6614b.n();
            } else {
                ECFieldElement a2 = j.o().g().j(this.f6614b).a(this.f6610a).a(j);
                if (!a2.i()) {
                    ECFieldElement j2 = j(ECConstants.a);
                    int k = k();
                    Random random = new Random();
                    while (true) {
                        ECFieldElement j3 = j(new BigInteger(k, random));
                        ECFieldElement eCFieldElement2 = a2;
                        ECFieldElement eCFieldElement3 = j2;
                        for (int i2 = 1; i2 < k; i2++) {
                            ECFieldElement o = eCFieldElement2.o();
                            eCFieldElement3 = eCFieldElement3.o().a(o.j(j3));
                            eCFieldElement2 = o.a(a2);
                        }
                        if (eCFieldElement2.i()) {
                            if (!eCFieldElement3.o().a(eCFieldElement3).i()) {
                                a2 = eCFieldElement3;
                                break;
                            }
                        } else {
                            a2 = null;
                            break;
                        }
                    }
                }
                if (a2 != null) {
                    boolean s = a2.s();
                    if (i == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (s != z) {
                        a2 = a2.b();
                    }
                    int i3 = this.a;
                    if (i3 == 5 || i3 == 6) {
                        eCFieldElement = a2.a(j);
                    } else {
                        eCFieldElement = a2.j(j);
                    }
                } else {
                    eCFieldElement = null;
                }
            }
            if (eCFieldElement != null) {
                return e(j, eCFieldElement, true);
            }
            throw new IllegalArgumentException("Invalid point compression");
        }

        public final boolean o(BigInteger bigInteger) {
            if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > k()) {
                return false;
            }
            return true;
        }

        public boolean t() {
            if (this.f6609a == null || this.b == null || !this.f6614b.h() || (!this.f6610a.i() && !this.f6610a.h())) {
                return false;
            }
            return true;
        }
    }

    public static abstract class AbstractFp extends ECCurve {
        public AbstractFp(BigInteger bigInteger) {
            super(FiniteFields.b(bigInteger));
        }

        public final ECPoint h(int i, BigInteger bigInteger) {
            boolean z;
            ECFieldElement j = j(bigInteger);
            ECFieldElement n = j.o().a(this.f6610a).j(j).a(this.f6614b).n();
            if (n != null) {
                boolean s = n.s();
                if (i == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (s != z) {
                    n = n.m();
                }
                return e(j, n, true);
            }
            throw new IllegalArgumentException("Invalid point compression");
        }

        public final boolean o(BigInteger bigInteger) {
            if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(this.f6613a.b()) >= 0) {
                return false;
            }
            return true;
        }
    }

    public class Config {
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public final ECMultiplier f6616a;

        /* renamed from: a  reason: collision with other field name */
        public ECEndomorphism f6617a;

        public Config(int i, ECEndomorphism eCEndomorphism, ECMultiplier eCMultiplier) {
            this.a = i;
            this.f6617a = eCEndomorphism;
            this.f6616a = eCMultiplier;
        }

        public final ECCurve a() {
            if (ECCurve.this.r(this.a)) {
                ECCurve a2 = ECCurve.this.a();
                if (a2 != ECCurve.this) {
                    synchronized (a2) {
                        a2.a = this.a;
                        a2.f6612a = this.f6617a;
                        a2.f6611a = this.f6616a;
                    }
                    return a2;
                }
                throw new IllegalStateException("implementation returned current curve");
            }
            throw new IllegalStateException("unsupported coordinate system");
        }
    }

    public static class F2m extends AbstractF2m {
        public final ECPoint.F2m a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;

        public F2m(int i, int i2, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            this(i, i2, 0, 0, bigInteger, bigInteger2, bigInteger3, bigInteger4);
        }

        public final ECCurve a() {
            return new F2m(this.b, this.c, this.d, this.e, this.f6610a, this.f6614b, this.f6609a, this.b);
        }

        public final ECMultiplier c() {
            if (t()) {
                return new WTauNafMultiplier();
            }
            return ECCurve.super.c();
        }

        public final ECPoint e(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
            return new ECPoint.F2m(this, eCFieldElement, eCFieldElement2, z);
        }

        public final ECPoint f(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
            return new ECPoint.F2m(this, eCFieldElement, eCFieldElement2, eCFieldElementArr, z);
        }

        public final ECFieldElement j(BigInteger bigInteger) {
            return new ECFieldElement.F2m(this.b, this.c, this.d, this.e, bigInteger);
        }

        public final int k() {
            return this.b;
        }

        public final ECPoint l() {
            return this.a;
        }

        public final boolean r(int i) {
            if (i == 0 || i == 1 || i == 6) {
                return true;
            }
            return false;
        }

        public F2m(int i, int i2, int i3, int i4, BigInteger bigInteger, BigInteger bigInteger2) {
            this(i, i2, i3, i4, bigInteger, bigInteger2, (BigInteger) null, (BigInteger) null);
        }

        public F2m(int i, int i2, int i3, int i4, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            super(i, i2, i3, i4);
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.f6609a = bigInteger3;
            this.b = bigInteger4;
            this.a = new ECPoint.F2m(this, (ECFieldElement) null, (ECFieldElement) null, false);
            this.f6610a = j(bigInteger);
            this.f6614b = j(bigInteger2);
            this.a = 6;
        }

        public F2m(int i, int i2, int i3, int i4, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, BigInteger bigInteger, BigInteger bigInteger2) {
            super(i, i2, i3, i4);
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.f6609a = bigInteger;
            this.b = bigInteger2;
            this.a = new ECPoint.F2m(this, (ECFieldElement) null, (ECFieldElement) null, false);
            this.f6610a = eCFieldElement;
            this.f6614b = eCFieldElement2;
            this.a = 6;
        }
    }

    public static class Fp extends AbstractFp {
        public final ECPoint.Fp a;
        public final BigInteger c;
        public final BigInteger d;

        public Fp(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            this(bigInteger, bigInteger2, bigInteger3, (BigInteger) null, (BigInteger) null);
        }

        public final ECCurve a() {
            return new Fp(this.c, this.d, this.f6610a, this.f6614b, this.f6609a, this.b);
        }

        public final ECPoint e(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
            return new ECPoint.Fp(this, eCFieldElement, eCFieldElement2, z);
        }

        public final ECPoint f(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
            return new ECPoint.Fp(this, eCFieldElement, eCFieldElement2, eCFieldElementArr, z);
        }

        public final ECFieldElement j(BigInteger bigInteger) {
            return new ECFieldElement.Fp(this.c, this.d, bigInteger);
        }

        public final int k() {
            return this.c.bitLength();
        }

        public final ECPoint l() {
            return this.a;
        }

        public final ECPoint n(ECPoint eCPoint) {
            int i;
            if (this == eCPoint.f6620a || this.a != 2 || eCPoint.k() || ((i = eCPoint.f6620a.a) != 2 && i != 3 && i != 4)) {
                return ECCurve.super.n(eCPoint);
            }
            return new ECPoint.Fp(this, j(eCPoint.f6621a.t()), j(eCPoint.f6624b.t()), new ECFieldElement[]{j(eCPoint.f6623a[0].t())}, eCPoint.f6622a);
        }

        public final boolean r(int i) {
            if (i == 0 || i == 1 || i == 2 || i == 4) {
                return true;
            }
            return false;
        }

        public Fp(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5) {
            super(bigInteger);
            this.c = bigInteger;
            this.d = ECFieldElement.Fp.u(bigInteger);
            this.a = new ECPoint.Fp(this, (ECFieldElement) null, (ECFieldElement) null, false);
            this.f6610a = j(bigInteger2);
            this.f6614b = j(bigInteger3);
            this.f6609a = bigInteger4;
            this.b = bigInteger5;
            this.a = 4;
        }

        public Fp(BigInteger bigInteger, BigInteger bigInteger2, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, BigInteger bigInteger3, BigInteger bigInteger4) {
            super(bigInteger);
            this.c = bigInteger;
            this.d = bigInteger2;
            this.a = new ECPoint.Fp(this, (ECFieldElement) null, (ECFieldElement) null, false);
            this.f6610a = eCFieldElement;
            this.f6614b = eCFieldElement2;
            this.f6609a = bigInteger3;
            this.b = bigInteger4;
            this.a = 4;
        }
    }

    public ECCurve(FiniteField finiteField) {
        this.f6613a = finiteField;
    }

    public abstract ECCurve a();

    public final synchronized Config b() {
        return new Config(this.a, this.f6612a, this.f6611a);
    }

    public ECMultiplier c() {
        ECEndomorphism eCEndomorphism = this.f6612a;
        if (eCEndomorphism instanceof GLVEndomorphism) {
            return new GLVMultiplier(this, (GLVEndomorphism) eCEndomorphism);
        }
        return new WNafL2RMultiplier();
    }

    public ECPoint d(BigInteger bigInteger, BigInteger bigInteger2, boolean z) {
        return e(j(bigInteger), j(bigInteger2), z);
    }

    public abstract ECPoint e(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z);

    public final boolean equals(Object obj) {
        if (this == obj || ((obj instanceof ECCurve) && i((ECCurve) obj))) {
            return true;
        }
        return false;
    }

    public abstract ECPoint f(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z);

    public final ECPoint g(byte[] bArr) {
        ECPoint eCPoint;
        int k = (k() + 7) / 8;
        boolean z = false;
        byte b2 = bArr[0];
        if (b2 != 0) {
            if (b2 == 2 || b2 == 3) {
                if (bArr.length == k + 1) {
                    eCPoint = h(b2 & 1, BigIntegers.d(1, bArr, k));
                    if (!eCPoint.q()) {
                        throw new IllegalArgumentException("Invalid point");
                    }
                } else {
                    throw new IllegalArgumentException("Incorrect length for compressed encoding");
                }
            } else if (b2 != 4) {
                if (b2 != 6 && b2 != 7) {
                    throw new IllegalArgumentException("Invalid point encoding 0x" + Integer.toString(b2, 16));
                } else if (bArr.length == (k * 2) + 1) {
                    BigInteger d = BigIntegers.d(1, bArr, k);
                    BigInteger d2 = BigIntegers.d(k + 1, bArr, k);
                    boolean testBit = d2.testBit(0);
                    if (b2 == 7) {
                        z = true;
                    }
                    if (testBit == z) {
                        eCPoint = s(d, d2);
                    } else {
                        throw new IllegalArgumentException("Inconsistent Y coordinate in hybrid encoding");
                    }
                } else {
                    throw new IllegalArgumentException("Incorrect length for hybrid encoding");
                }
            } else if (bArr.length == (k * 2) + 1) {
                eCPoint = s(BigIntegers.d(1, bArr, k), BigIntegers.d(k + 1, bArr, k));
            } else {
                throw new IllegalArgumentException("Incorrect length for uncompressed encoding");
            }
        } else if (bArr.length == 1) {
            eCPoint = l();
        } else {
            throw new IllegalArgumentException("Incorrect length for infinity encoding");
        }
        if (b2 == 0 || !eCPoint.k()) {
            return eCPoint;
        }
        throw new IllegalArgumentException("Invalid infinity encoding");
    }

    public abstract ECPoint h(int i, BigInteger bigInteger);

    public final int hashCode() {
        return (this.f6613a.hashCode() ^ Integer.rotateLeft(this.f6610a.t().hashCode(), 8)) ^ Integer.rotateLeft(this.f6614b.t().hashCode(), 16);
    }

    public final boolean i(ECCurve eCCurve) {
        if (this != eCCurve) {
            if (eCCurve != null) {
                if (!this.f6613a.equals(eCCurve.f6613a) || !this.f6610a.t().equals(eCCurve.f6610a.t()) || !this.f6614b.t().equals(eCCurve.f6614b.t())) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public abstract ECFieldElement j(BigInteger bigInteger);

    public abstract int k();

    public abstract ECPoint l();

    public final PreCompInfo m(ECPoint eCPoint, String str) {
        PreCompInfo preCompInfo;
        if (eCPoint == null || this != eCPoint.f6620a) {
            throw new IllegalArgumentException("'point' must be non-null and on this curve");
        }
        synchronized (eCPoint) {
            Hashtable hashtable = eCPoint.a;
            if (hashtable == null) {
                preCompInfo = null;
            } else {
                preCompInfo = (PreCompInfo) hashtable.get(str);
            }
        }
        return preCompInfo;
    }

    public ECPoint n(ECPoint eCPoint) {
        if (this == eCPoint.f6620a) {
            return eCPoint;
        }
        if (eCPoint.k()) {
            return l();
        }
        ECPoint o = eCPoint.o();
        ECPoint d = d(o.f6621a.t(), o.i().t(), o.f6622a);
        if (d.l()) {
            return d;
        }
        throw new IllegalArgumentException("Invalid point coordinates");
    }

    public abstract boolean o(BigInteger bigInteger);

    public final void p(ECPoint[] eCPointArr, int i, int i2, ECFieldElement eCFieldElement) {
        if (i < 0 || i2 < 0 || i > eCPointArr.length - i2) {
            throw new IllegalArgumentException("invalid range specified for 'points'");
        }
        int i3 = 0;
        while (i3 < i2) {
            ECPoint eCPoint = eCPointArr[i + i3];
            if (eCPoint == null || this == eCPoint.f6620a) {
                i3++;
            } else {
                throw new IllegalArgumentException("'points' entries must be null or on this curve");
            }
        }
        int i4 = this.a;
        if (i4 != 0 && i4 != 5) {
            ECFieldElement[] eCFieldElementArr = new ECFieldElement[i2];
            int[] iArr = new int[i2];
            int i5 = 0;
            int i6 = 0;
            while (true) {
                boolean z = true;
                if (i5 >= i2) {
                    break;
                }
                int i7 = i + i5;
                ECPoint eCPoint2 = eCPointArr[i7];
                if (eCPoint2 != null) {
                    if (eCFieldElement == null) {
                        int g = eCPoint2.g();
                        if (g != 0 && g != 5 && !eCPoint2.k() && !eCPoint2.f6623a[0].h()) {
                            z = false;
                        }
                        if (z) {
                        }
                    }
                    eCFieldElementArr[i6] = eCPoint2.j();
                    iArr[i6] = i7;
                    i6++;
                }
                i5++;
            }
            if (i6 != 0) {
                ECFieldElement[] eCFieldElementArr2 = new ECFieldElement[i6];
                eCFieldElementArr2[0] = eCFieldElementArr[0];
                int i8 = 0;
                while (true) {
                    i8++;
                    if (i8 >= i6) {
                        break;
                    }
                    eCFieldElementArr2[i8] = eCFieldElementArr2[i8 - 1].j(eCFieldElementArr[0 + i8]);
                }
                int i9 = i8 - 1;
                if (eCFieldElement != null) {
                    eCFieldElementArr2[i9] = eCFieldElementArr2[i9].j(eCFieldElement);
                }
                ECFieldElement g2 = eCFieldElementArr2[i9].g();
                while (i9 > 0) {
                    int i10 = i9 - 1;
                    int i11 = i9 + 0;
                    ECFieldElement eCFieldElement2 = eCFieldElementArr[i11];
                    eCFieldElementArr[i11] = eCFieldElementArr2[i10].j(g2);
                    g2 = g2.j(eCFieldElement2);
                    i9 = i10;
                }
                eCFieldElementArr[0] = g2;
                for (int i12 = 0; i12 < i6; i12++) {
                    int i13 = iArr[i12];
                    eCPointArr[i13] = eCPointArr[i13].p(eCFieldElementArr[i12]);
                }
            }
        } else if (eCFieldElement != null) {
            throw new IllegalArgumentException("'iso' not valid for affine coordinates");
        }
    }

    public final void q(ECPoint eCPoint, String str, PreCompInfo preCompInfo) {
        if (eCPoint == null || this != eCPoint.f6620a) {
            throw new IllegalArgumentException("'point' must be non-null and on this curve");
        }
        synchronized (eCPoint) {
            Hashtable hashtable = eCPoint.a;
            if (hashtable == null) {
                hashtable = new Hashtable(4);
                eCPoint.a = hashtable;
            }
            hashtable.put(str, preCompInfo);
        }
    }

    public boolean r(int i) {
        if (i == 0) {
            return true;
        }
        return false;
    }

    public final ECPoint s(BigInteger bigInteger, BigInteger bigInteger2) {
        ECPoint d = d(bigInteger, bigInteger2, false);
        if (d.l()) {
            return d;
        }
        throw new IllegalArgumentException("Invalid point coordinates");
    }
}
