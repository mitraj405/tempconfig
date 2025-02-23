package org.spongycastle.math.ec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.endo.ECEndomorphism;
import org.spongycastle.math.ec.endo.GLVEndomorphism;
import org.spongycastle.math.field.FiniteField;
import org.spongycastle.math.field.PolynomialExtensionField;

public class ECAlgorithms {
    public static ECPoint a(ECPoint eCPoint, BigInteger bigInteger, ECPoint eCPoint2, BigInteger bigInteger2) {
        boolean z;
        ECPoint[] eCPointArr;
        ECPoint[] eCPointArr2;
        ECPoint[] eCPointArr3;
        ECPoint[] eCPointArr4;
        boolean z2 = false;
        if (bigInteger.signum() < 0) {
            z = true;
        } else {
            z = false;
        }
        if (bigInteger2.signum() < 0) {
            z2 = true;
        }
        BigInteger abs = bigInteger.abs();
        BigInteger abs2 = bigInteger2.abs();
        int max = Math.max(2, Math.min(16, WNafUtil.e(abs.bitLength())));
        int max2 = Math.max(2, Math.min(16, WNafUtil.e(abs2.bitLength())));
        WNafPreCompInfo g = WNafUtil.g(eCPoint, max);
        WNafPreCompInfo g2 = WNafUtil.g(eCPoint2, max2);
        if (z) {
            eCPointArr = g.b;
        } else {
            eCPointArr = g.f6635a;
        }
        ECPoint[] eCPointArr5 = eCPointArr;
        if (z2) {
            eCPointArr2 = g2.b;
        } else {
            eCPointArr2 = g2.f6635a;
        }
        ECPoint[] eCPointArr6 = eCPointArr2;
        if (z) {
            eCPointArr3 = g.f6635a;
        } else {
            eCPointArr3 = g.b;
        }
        ECPoint[] eCPointArr7 = eCPointArr3;
        if (z2) {
            eCPointArr4 = g2.f6635a;
        } else {
            eCPointArr4 = g2.b;
        }
        return b(eCPointArr5, eCPointArr7, WNafUtil.b(max, abs), eCPointArr6, eCPointArr4, WNafUtil.b(max2, abs2));
    }

    public static ECPoint b(ECPoint[] eCPointArr, ECPoint[] eCPointArr2, byte[] bArr, ECPoint[] eCPointArr3, ECPoint[] eCPointArr4, byte[] bArr2) {
        byte b;
        byte b2;
        ECPoint eCPoint;
        ECPoint[] eCPointArr5;
        ECPoint[] eCPointArr6;
        int max = Math.max(bArr.length, bArr2.length);
        ECPoint l = eCPointArr[0].f6620a.l();
        int i = 0;
        ECPoint eCPoint2 = l;
        for (int i2 = max - 1; i2 >= 0; i2--) {
            if (i2 < bArr.length) {
                b = bArr[i2];
            } else {
                b = 0;
            }
            if (i2 < bArr2.length) {
                b2 = bArr2[i2];
            } else {
                b2 = 0;
            }
            if ((b | b2) == 0) {
                i++;
            } else {
                if (b != 0) {
                    int abs = Math.abs(b);
                    if (b < 0) {
                        eCPointArr6 = eCPointArr2;
                    } else {
                        eCPointArr6 = eCPointArr;
                    }
                    eCPoint = l.a(eCPointArr6[abs >>> 1]);
                } else {
                    eCPoint = l;
                }
                if (b2 != 0) {
                    int abs2 = Math.abs(b2);
                    if (b2 < 0) {
                        eCPointArr5 = eCPointArr4;
                    } else {
                        eCPointArr5 = eCPointArr3;
                    }
                    eCPoint = eCPoint.a(eCPointArr5[abs2 >>> 1]);
                }
                if (i > 0) {
                    eCPoint2 = eCPoint2.w(i);
                    i = 0;
                }
                eCPoint2 = eCPoint2.y(eCPoint);
            }
        }
        if (i > 0) {
            return eCPoint2.w(i);
        }
        return eCPoint2;
    }

    public static ECPoint c(boolean[] zArr, WNafPreCompInfo[] wNafPreCompInfoArr, byte[][] bArr) {
        byte b;
        boolean z;
        ECPoint[] eCPointArr;
        int i = 0;
        for (byte[] length : bArr) {
            i = Math.max(i, length.length);
        }
        ECPoint l = wNafPreCompInfoArr[0].f6635a[0].f6620a.l();
        int i2 = 0;
        ECPoint eCPoint = l;
        for (int i3 = i - 1; i3 >= 0; i3--) {
            ECPoint eCPoint2 = l;
            for (int i4 = 0; i4 < r0; i4++) {
                byte[] bArr2 = bArr[i4];
                if (i3 < bArr2.length) {
                    b = bArr2[i3];
                } else {
                    b = 0;
                }
                if (b != 0) {
                    int abs = Math.abs(b);
                    WNafPreCompInfo wNafPreCompInfo = wNafPreCompInfoArr[i4];
                    if (b < 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z == zArr[i4]) {
                        eCPointArr = wNafPreCompInfo.f6635a;
                    } else {
                        eCPointArr = wNafPreCompInfo.b;
                    }
                    eCPoint2 = eCPoint2.a(eCPointArr[abs >>> 1]);
                }
            }
            if (eCPoint2 == l) {
                i2++;
            } else {
                if (i2 > 0) {
                    eCPoint = eCPoint.w(i2);
                    i2 = 0;
                }
                eCPoint = eCPoint.y(eCPoint2);
            }
        }
        if (i2 > 0) {
            return eCPoint.w(i2);
        }
        return eCPoint;
    }

    public static ECPoint d(ECCurve eCCurve, ECPoint eCPoint) {
        if (eCCurve.i(eCPoint.f6620a)) {
            return eCCurve.n(eCPoint);
        }
        throw new IllegalArgumentException("Point must be on the same curve");
    }

    public static boolean e(ECCurve eCCurve) {
        FiniteField finiteField = eCCurve.f6613a;
        if (finiteField.a() <= 1 || !finiteField.b().equals(ECConstants.c) || !(finiteField instanceof PolynomialExtensionField)) {
            return false;
        }
        return true;
    }

    public static ECPoint f(ECPoint eCPoint, BigInteger bigInteger) {
        BigInteger abs = bigInteger.abs();
        ECPoint l = eCPoint.f6620a.l();
        int bitLength = abs.bitLength();
        if (bitLength > 0) {
            if (abs.testBit(0)) {
                l = eCPoint;
            }
            for (int i = 1; i < bitLength; i++) {
                eCPoint = eCPoint.x();
                if (abs.testBit(i)) {
                    l = l.a(eCPoint);
                }
            }
        }
        if (bigInteger.signum() < 0) {
            return l.n();
        }
        return l;
    }

    public static ECPoint g(ECPoint eCPoint, BigInteger bigInteger, ECPoint eCPoint2, BigInteger bigInteger2) {
        boolean z;
        boolean z2;
        ECPoint eCPoint3 = eCPoint;
        BigInteger bigInteger3 = bigInteger;
        BigInteger bigInteger4 = bigInteger2;
        ECCurve eCCurve = eCPoint3.f6620a;
        ECPoint d = d(eCCurve, eCPoint2);
        if (!(eCCurve instanceof ECCurve.AbstractF2m) || !((ECCurve.AbstractF2m) eCCurve).t()) {
            ECEndomorphism eCEndomorphism = eCCurve.f6612a;
            if (eCEndomorphism instanceof GLVEndomorphism) {
                ECPoint[] eCPointArr = {eCPoint3, d};
                BigInteger[] bigIntegerArr = {bigInteger3, bigInteger4};
                GLVEndomorphism gLVEndomorphism = (GLVEndomorphism) eCEndomorphism;
                BigInteger bigInteger5 = eCPointArr[0].f6620a.f6609a;
                BigInteger[] bigIntegerArr2 = new BigInteger[4];
                int i = 0;
                for (int i2 = 0; i2 < 2; i2++) {
                    BigInteger[] a = gLVEndomorphism.a(bigIntegerArr[i2].mod(bigInteger5));
                    int i3 = i + 1;
                    bigIntegerArr2[i] = a[0];
                    i = i3 + 1;
                    bigIntegerArr2[i3] = a[1];
                }
                ScaleXPointMap b = gLVEndomorphism.b();
                gLVEndomorphism.c();
                boolean[] zArr = new boolean[4];
                WNafPreCompInfo[] wNafPreCompInfoArr = new WNafPreCompInfo[4];
                byte[][] bArr = new byte[4][];
                for (int i4 = 0; i4 < 2; i4++) {
                    int i5 = i4 << 1;
                    int i6 = i5 + 1;
                    BigInteger bigInteger6 = bigIntegerArr2[i5];
                    if (bigInteger6.signum() < 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zArr[i5] = z;
                    BigInteger abs = bigInteger6.abs();
                    BigInteger bigInteger7 = bigIntegerArr2[i6];
                    if (bigInteger7.signum() < 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zArr[i6] = z2;
                    BigInteger abs2 = bigInteger7.abs();
                    int max = Math.max(2, Math.min(16, WNafUtil.e(Math.max(abs.bitLength(), abs2.bitLength()))));
                    ECPoint eCPoint4 = eCPointArr[i4];
                    ECPoint f = WNafUtil.f(eCPoint4, max, b);
                    wNafPreCompInfoArr[i5] = WNafUtil.d(eCPoint4);
                    wNafPreCompInfoArr[i6] = WNafUtil.d(f);
                    bArr[i5] = WNafUtil.b(max, abs);
                    bArr[i6] = WNafUtil.b(max, abs2);
                }
                ECPoint c = c(zArr, wNafPreCompInfoArr, bArr);
                h(c);
                return c;
            }
            ECPoint a2 = a(eCPoint3, bigInteger3, d, bigInteger4);
            h(a2);
            return a2;
        }
        ECPoint a3 = eCPoint.m(bigInteger).a(d.m(bigInteger4));
        h(a3);
        return a3;
    }

    public static void h(ECPoint eCPoint) {
        if (!eCPoint.l()) {
            throw new IllegalArgumentException("Invalid point");
        }
    }
}
