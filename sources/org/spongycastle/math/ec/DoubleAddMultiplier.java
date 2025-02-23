package org.spongycastle.math.ec;

import java.math.BigInteger;

public class DoubleAddMultiplier extends AbstractECMultiplier {
    public final ECPoint b(ECPoint eCPoint, BigInteger bigInteger) {
        ECPoint[] eCPointArr = {eCPoint.f6620a.l(), eCPoint};
        int bitLength = bigInteger.bitLength();
        for (int i = 0; i < bitLength; i++) {
            int testBit = bigInteger.testBit(i);
            int i2 = 1 - testBit;
            eCPointArr[i2] = eCPointArr[i2].y(eCPointArr[testBit]);
        }
        return eCPointArr[0];
    }
}
