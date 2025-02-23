package org.spongycastle.math.ec;

import java.math.BigInteger;

public abstract class WNafUtil {
    public static final byte[] a = new byte[0];

    /* renamed from: a  reason: collision with other field name */
    public static final int[] f6636a = {13, 41, 121, 337, 897, 2305};

    /* renamed from: a  reason: collision with other field name */
    public static final ECPoint[] f6637a = new ECPoint[0];
    public static final int[] b = new int[0];

    public static int[] a(BigInteger bigInteger) {
        int i;
        if ((bigInteger.bitLength() >>> 16) != 0) {
            throw new IllegalArgumentException("'k' must have bitlength < 2^16");
        } else if (bigInteger.signum() == 0) {
            return b;
        } else {
            BigInteger add = bigInteger.shiftLeft(1).add(bigInteger);
            int bitLength = add.bitLength();
            int i2 = bitLength >> 1;
            int[] iArr = new int[i2];
            BigInteger xor = add.xor(bigInteger);
            int i3 = bitLength - 1;
            int i4 = 1;
            int i5 = 0;
            int i6 = 0;
            while (i4 < i3) {
                if (!xor.testBit(i4)) {
                    i6++;
                } else {
                    if (bigInteger.testBit(i4)) {
                        i = -1;
                    } else {
                        i = 1;
                    }
                    iArr[i5] = i6 | (i << 16);
                    i4++;
                    i6 = 1;
                    i5++;
                }
                i4++;
            }
            int i7 = i5 + 1;
            iArr[i5] = 65536 | i6;
            if (i2 <= i7) {
                return iArr;
            }
            int[] iArr2 = new int[i7];
            System.arraycopy(iArr, 0, iArr2, 0, i7);
            return iArr2;
        }
    }

    public static byte[] b(int i, BigInteger bigInteger) {
        int i2;
        byte[] bArr = a;
        if (i == 2) {
            if (bigInteger.signum() == 0) {
                return bArr;
            }
            BigInteger add = bigInteger.shiftLeft(1).add(bigInteger);
            int bitLength = add.bitLength() - 1;
            byte[] bArr2 = new byte[bitLength];
            BigInteger xor = add.xor(bigInteger);
            int i3 = 1;
            while (i3 < bitLength) {
                if (xor.testBit(i3)) {
                    int i4 = i3 - 1;
                    if (bigInteger.testBit(i3)) {
                        i2 = -1;
                    } else {
                        i2 = 1;
                    }
                    bArr2[i4] = (byte) i2;
                    i3++;
                }
                i3++;
            }
            bArr2[bitLength - 1] = 1;
            return bArr2;
        } else if (i < 2 || i > 8) {
            throw new IllegalArgumentException("'width' must be in the range [2, 8]");
        } else if (bigInteger.signum() == 0) {
            return bArr;
        } else {
            int bitLength2 = bigInteger.bitLength() + 1;
            byte[] bArr3 = new byte[bitLength2];
            int i5 = 1 << i;
            int i6 = i5 - 1;
            int i7 = i5 >>> 1;
            int i8 = 0;
            int i9 = 0;
            boolean z = false;
            while (i8 <= bigInteger.bitLength()) {
                if (bigInteger.testBit(i8) == z) {
                    i8++;
                } else {
                    bigInteger = bigInteger.shiftRight(i8);
                    int intValue = bigInteger.intValue() & i6;
                    if (z) {
                        intValue++;
                    }
                    if ((intValue & i7) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        intValue -= i5;
                    }
                    if (i9 > 0) {
                        i8--;
                    }
                    int i10 = i9 + i8;
                    bArr3[i10] = (byte) intValue;
                    i9 = i10 + 1;
                    i8 = i;
                }
            }
            if (bitLength2 <= i9) {
                return bArr3;
            }
            byte[] bArr4 = new byte[i9];
            System.arraycopy(bArr3, 0, bArr4, 0, i9);
            return bArr4;
        }
    }

    public static int c(BigInteger bigInteger) {
        if (bigInteger.signum() == 0) {
            return 0;
        }
        return bigInteger.shiftLeft(1).add(bigInteger).xor(bigInteger).bitCount();
    }

    public static WNafPreCompInfo d(ECPoint eCPoint) {
        PreCompInfo m = eCPoint.f6620a.m(eCPoint, "bc_wnaf");
        if (m == null || !(m instanceof WNafPreCompInfo)) {
            return new WNafPreCompInfo();
        }
        return (WNafPreCompInfo) m;
    }

    public static int e(int i) {
        int[] iArr = f6636a;
        int i2 = 0;
        while (i2 < 6 && i >= iArr[i2]) {
            i2++;
        }
        return i2 + 2;
    }

    public static ECPoint f(ECPoint eCPoint, int i, ECPointMap eCPointMap) {
        WNafPreCompInfo wNafPreCompInfo;
        ECCurve eCCurve = eCPoint.f6620a;
        WNafPreCompInfo g = g(eCPoint, i);
        ECPoint a2 = eCPointMap.a(eCPoint);
        PreCompInfo m = eCCurve.m(a2, "bc_wnaf");
        if (m == null || !(m instanceof WNafPreCompInfo)) {
            wNafPreCompInfo = new WNafPreCompInfo();
        } else {
            wNafPreCompInfo = (WNafPreCompInfo) m;
        }
        ECPoint eCPoint2 = g.a;
        if (eCPoint2 != null) {
            wNafPreCompInfo.a = eCPointMap.a(eCPoint2);
        }
        ECPoint[] eCPointArr = g.f6635a;
        int length = eCPointArr.length;
        ECPoint[] eCPointArr2 = new ECPoint[length];
        for (int i2 = 0; i2 < eCPointArr.length; i2++) {
            eCPointArr2[i2] = eCPointMap.a(eCPointArr[i2]);
        }
        wNafPreCompInfo.f6635a = eCPointArr2;
        ECPoint[] eCPointArr3 = new ECPoint[length];
        for (int i3 = 0; i3 < length; i3++) {
            eCPointArr3[i3] = eCPointArr2[i3].n();
        }
        wNafPreCompInfo.b = eCPointArr3;
        eCCurve.q(a2, "bc_wnaf", wNafPreCompInfo);
        return a2;
    }

    public static WNafPreCompInfo g(ECPoint eCPoint, int i) {
        WNafPreCompInfo wNafPreCompInfo;
        int i2;
        int i3;
        int i4;
        ECCurve eCCurve = eCPoint.f6620a;
        PreCompInfo m = eCCurve.m(eCPoint, "bc_wnaf");
        if (m == null || !(m instanceof WNafPreCompInfo)) {
            wNafPreCompInfo = new WNafPreCompInfo();
        } else {
            wNafPreCompInfo = (WNafPreCompInfo) m;
        }
        int i5 = 0;
        boolean z = true;
        int max = 1 << Math.max(0, i - 2);
        ECPoint[] eCPointArr = wNafPreCompInfo.f6635a;
        if (eCPointArr == null) {
            eCPointArr = f6637a;
            i2 = 0;
        } else {
            i2 = eCPointArr.length;
        }
        if (i2 < max) {
            ECPoint[] eCPointArr2 = new ECPoint[max];
            System.arraycopy(eCPointArr, 0, eCPointArr2, 0, eCPointArr.length);
            if (max == 1) {
                eCPointArr2[0] = eCPoint.o();
            } else {
                if (i2 == 0) {
                    eCPointArr2[0] = eCPoint;
                    i3 = 1;
                } else {
                    i3 = i2;
                }
                ECFieldElement eCFieldElement = null;
                if (max == 2) {
                    eCPointArr2[1] = eCPoint.v();
                } else {
                    ECPoint eCPoint2 = wNafPreCompInfo.a;
                    ECPoint eCPoint3 = eCPointArr2[i3 - 1];
                    if (eCPoint2 == null) {
                        eCPoint2 = eCPointArr2[0].x();
                        wNafPreCompInfo.a = eCPoint2;
                        if (!eCPoint2.k()) {
                            if (eCCurve.f6613a.a() != 1) {
                                z = false;
                            }
                            if (z && eCCurve.k() >= 64 && ((i4 = eCCurve.a) == 2 || i4 == 3 || i4 == 4)) {
                                ECFieldElement j = eCPoint2.j();
                                eCPoint2 = eCCurve.d(eCPoint2.f6621a.t(), eCPoint2.i().t(), false);
                                ECFieldElement o = j.o();
                                eCPoint3 = eCPoint3.s(o).t(o.j(j));
                                if (i2 == 0) {
                                    eCPointArr2[0] = eCPoint3;
                                }
                                eCFieldElement = j;
                            }
                        }
                    }
                    while (i3 < max) {
                        eCPoint3 = eCPoint3.a(eCPoint2);
                        eCPointArr2[i3] = eCPoint3;
                        i3++;
                    }
                }
                eCCurve.p(eCPointArr2, i2, max - i2, eCFieldElement);
            }
            eCPointArr = eCPointArr2;
        }
        wNafPreCompInfo.f6635a = eCPointArr;
        ECPoint[] eCPointArr3 = wNafPreCompInfo.b;
        if (eCPointArr3 == null) {
            eCPointArr3 = new ECPoint[max];
        } else {
            int length = eCPointArr3.length;
            if (length < max) {
                ECPoint[] eCPointArr4 = new ECPoint[max];
                System.arraycopy(eCPointArr3, 0, eCPointArr4, 0, eCPointArr3.length);
                i5 = length;
                eCPointArr3 = eCPointArr4;
            } else {
                i5 = length;
            }
        }
        while (i5 < max) {
            eCPointArr3[i5] = eCPointArr[i5].n();
            i5++;
        }
        wNafPreCompInfo.b = eCPointArr3;
        eCCurve.q(eCPoint, "bc_wnaf", wNafPreCompInfo);
        return wNafPreCompInfo;
    }
}
