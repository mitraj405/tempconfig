package org.spongycastle.math.ec;

import java.math.BigInteger;

public class FixedPointCombMultiplier extends AbstractECMultiplier {
    public final ECPoint b(ECPoint eCPoint, BigInteger bigInteger) {
        int i;
        int i2;
        FixedPointPreCompInfo fixedPointPreCompInfo;
        int i3;
        ECPoint eCPoint2 = eCPoint;
        ECCurve eCCurve = eCPoint2.f6620a;
        BigInteger bigInteger2 = eCCurve.f6609a;
        int i4 = 1;
        if (bigInteger2 == null) {
            i = eCCurve.k() + 1;
        } else {
            i = bigInteger2.bitLength();
        }
        if (bigInteger.bitLength() <= i) {
            if (i > 257) {
                i2 = 6;
            } else {
                i2 = 5;
            }
            int i5 = 1 << i2;
            ECCurve eCCurve2 = eCPoint2.f6620a;
            PreCompInfo m = eCCurve2.m(eCPoint2, "bc_fixed_point");
            if (m == null || !(m instanceof FixedPointPreCompInfo)) {
                fixedPointPreCompInfo = new FixedPointPreCompInfo();
            } else {
                fixedPointPreCompInfo = (FixedPointPreCompInfo) m;
            }
            ECPoint[] eCPointArr = fixedPointPreCompInfo.f6626a;
            if (eCPointArr == null || eCPointArr.length < i5) {
                BigInteger bigInteger3 = eCCurve2.f6609a;
                if (bigInteger3 == null) {
                    i3 = eCCurve2.k() + 1;
                } else {
                    i3 = bigInteger3.bitLength();
                }
                int i6 = ((i3 + i2) - 1) / i2;
                int i7 = i2 + 1;
                ECPoint[] eCPointArr2 = new ECPoint[i7];
                eCPointArr2[0] = eCPoint2;
                for (int i8 = 1; i8 < i2; i8++) {
                    eCPointArr2[i8] = eCPointArr2[i8 - 1].w(i6);
                }
                eCPointArr2[i2] = eCPointArr2[0].u(eCPointArr2[1]);
                ECFieldElement eCFieldElement = null;
                eCCurve2.p(eCPointArr2, 0, i7, (ECFieldElement) null);
                ECPoint[] eCPointArr3 = new ECPoint[i5];
                eCPointArr3[0] = eCPointArr2[0];
                int i9 = i2 - 1;
                while (i9 >= 0) {
                    ECPoint eCPoint3 = eCPointArr2[i9];
                    int i10 = i4 << i9;
                    for (int i11 = i10; i11 < i5; i11 += i10 << 1) {
                        eCPointArr3[i11] = eCPointArr3[i11 - i10].a(eCPoint3);
                    }
                    i9--;
                    i4 = 1;
                    eCFieldElement = null;
                }
                eCCurve2.p(eCPointArr3, 0, i5, eCFieldElement);
                fixedPointPreCompInfo.f6625a = eCPointArr2[i2];
                fixedPointPreCompInfo.f6626a = eCPointArr3;
                fixedPointPreCompInfo.a = i2;
                eCCurve2.q(eCPoint2, "bc_fixed_point", fixedPointPreCompInfo);
            }
            ECPoint[] eCPointArr4 = fixedPointPreCompInfo.f6626a;
            int i12 = fixedPointPreCompInfo.a;
            int i13 = ((i + i12) - 1) / i12;
            ECPoint l = eCCurve.l();
            int i14 = (i12 * i13) - 1;
            for (int i15 = 0; i15 < i13; i15++) {
                int i16 = 0;
                for (int i17 = i14 - i15; i17 >= 0; i17 -= i13) {
                    i16 <<= 1;
                    if (bigInteger.testBit(i17)) {
                        i16 |= 1;
                    }
                }
                BigInteger bigInteger4 = bigInteger;
                l = l.y(eCPointArr4[i16]);
            }
            return l.a(fixedPointPreCompInfo.f6625a);
        }
        throw new IllegalStateException("fixed-point comb doesn't support scalars larger than the curve order");
    }
}
