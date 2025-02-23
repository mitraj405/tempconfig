package org.spongycastle.math.ec;

import java.math.BigInteger;

public class ZSignedDigitR2LMultiplier extends AbstractECMultiplier {
    public final ECPoint b(ECPoint eCPoint, BigInteger bigInteger) {
        ECPoint eCPoint2;
        ECPoint l = eCPoint.f6620a.l();
        int bitLength = bigInteger.bitLength();
        int lowestSetBit = bigInteger.getLowestSetBit();
        ECPoint w = eCPoint.w(lowestSetBit);
        while (true) {
            lowestSetBit++;
            if (lowestSetBit >= bitLength) {
                return l.a(w);
            }
            if (bigInteger.testBit(lowestSetBit)) {
                eCPoint2 = w;
            } else {
                eCPoint2 = w.n();
            }
            l = l.a(eCPoint2);
            w = w.x();
        }
    }
}
