package org.spongycastle.math.ec;

import java.math.BigInteger;

public class MontgomeryLadderMultiplier extends AbstractECMultiplier {
    public final ECPoint b(ECPoint eCPoint, BigInteger bigInteger) {
        ECPoint[] eCPointArr = {eCPoint.f6620a.l(), eCPoint};
        int bitLength = bigInteger.bitLength();
        while (true) {
            bitLength--;
            if (bitLength < 0) {
                return eCPointArr[0];
            }
            int testBit = bigInteger.testBit(bitLength);
            int i = 1 - testBit;
            eCPointArr[i] = eCPointArr[i].a(eCPointArr[testBit]);
            eCPointArr[testBit] = eCPointArr[testBit].x();
        }
    }
}
