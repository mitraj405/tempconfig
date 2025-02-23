package org.spongycastle.math.ec;

import java.math.BigInteger;

public class ReferenceMultiplier extends AbstractECMultiplier {
    public final ECPoint b(ECPoint eCPoint, BigInteger bigInteger) {
        return ECAlgorithms.f(eCPoint, bigInteger);
    }
}
