package org.spongycastle.math.ec;

import java.math.BigInteger;

public class WNafL2RMultiplier extends AbstractECMultiplier {
    public final ECPoint b(ECPoint eCPoint, BigInteger bigInteger) {
        int[] iArr;
        ECPoint[] eCPointArr;
        ECPoint[] eCPointArr2;
        ECPoint eCPoint2;
        ECPoint eCPoint3 = eCPoint;
        int max = Math.max(2, Math.min(16, WNafUtil.e(bigInteger.bitLength())));
        WNafPreCompInfo g = WNafUtil.g(eCPoint3, max);
        ECPoint[] eCPointArr3 = g.f6635a;
        ECPoint[] eCPointArr4 = g.b;
        if (max == 2) {
            iArr = WNafUtil.a(bigInteger);
        } else if (max < 2 || max > 16) {
            throw new IllegalArgumentException("'width' must be in the range [2, 16]");
        } else if ((bigInteger.bitLength() >>> 16) != 0) {
            throw new IllegalArgumentException("'k' must have bitlength < 2^16");
        } else if (bigInteger.signum() == 0) {
            iArr = WNafUtil.b;
        } else {
            int bitLength = (bigInteger.bitLength() / max) + 1;
            int[] iArr2 = new int[bitLength];
            int i = 1 << max;
            int i2 = i - 1;
            int i3 = i >>> 1;
            BigInteger bigInteger2 = bigInteger;
            int i4 = 0;
            int i5 = 0;
            boolean z = false;
            while (i4 <= bigInteger2.bitLength()) {
                if (bigInteger2.testBit(i4) == z) {
                    i4++;
                } else {
                    bigInteger2 = bigInteger2.shiftRight(i4);
                    int intValue = bigInteger2.intValue() & i2;
                    if (z) {
                        intValue++;
                    }
                    if ((intValue & i3) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        intValue -= i;
                    }
                    if (i5 > 0) {
                        i4--;
                    }
                    iArr2[i5] = (intValue << 16) | i4;
                    i4 = max;
                    i5++;
                }
            }
            if (bitLength > i5) {
                iArr = new int[i5];
                System.arraycopy(iArr2, 0, iArr, 0, i5);
            } else {
                iArr = iArr2;
            }
        }
        ECPoint l = eCPoint3.f6620a.l();
        int length = iArr.length;
        if (length > 1) {
            length--;
            int i6 = iArr[length];
            int i7 = i6 >> 16;
            int i8 = i6 & 65535;
            int abs = Math.abs(i7);
            if (i7 < 0) {
                eCPointArr2 = eCPointArr4;
            } else {
                eCPointArr2 = eCPointArr3;
            }
            if ((abs << 2) < (1 << max)) {
                byte b = LongArray.a[abs];
                int i9 = max - b;
                eCPoint2 = eCPointArr2[((1 << (max - 1)) - 1) >>> 1].a(eCPointArr2[(((abs ^ (1 << (b - 1))) << i9) + 1) >>> 1]);
                i8 -= i9;
            } else {
                eCPoint2 = eCPointArr2[abs >>> 1];
            }
            l = eCPoint2.w(i8);
        }
        while (length > 0) {
            length--;
            int i10 = iArr[length];
            int i11 = i10 >> 16;
            int i12 = i10 & 65535;
            int abs2 = Math.abs(i11);
            if (i11 < 0) {
                eCPointArr = eCPointArr4;
            } else {
                eCPointArr = eCPointArr3;
            }
            l = l.y(eCPointArr[abs2 >>> 1]).w(i12);
        }
        return l;
    }
}
