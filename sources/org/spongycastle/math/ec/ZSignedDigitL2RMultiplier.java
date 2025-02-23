package org.spongycastle.math.ec;

import java.math.BigInteger;

public class ZSignedDigitL2RMultiplier extends AbstractECMultiplier {
    public final ECPoint b(ECPoint eCPoint, BigInteger bigInteger) {
        ECPoint eCPoint2;
        ECPoint o = eCPoint.o();
        ECPoint n = o.n();
        int bitLength = bigInteger.bitLength();
        int lowestSetBit = bigInteger.getLowestSetBit();
        ECPoint eCPoint3 = o;
        while (true) {
            bitLength--;
            if (bitLength <= lowestSetBit) {
                return eCPoint3.w(lowestSetBit);
            }
            if (bigInteger.testBit(bitLength)) {
                eCPoint2 = o;
            } else {
                eCPoint2 = n;
            }
            eCPoint3 = eCPoint3.y(eCPoint2);
        }
    }
}
