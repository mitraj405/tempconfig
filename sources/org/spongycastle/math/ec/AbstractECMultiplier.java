package org.spongycastle.math.ec;

import java.math.BigInteger;

public abstract class AbstractECMultiplier implements ECMultiplier {
    public final ECPoint a(ECPoint eCPoint, BigInteger bigInteger) {
        int signum = bigInteger.signum();
        if (signum == 0 || eCPoint.k()) {
            return eCPoint.f6620a.l();
        }
        ECPoint b = b(eCPoint, bigInteger.abs());
        if (signum <= 0) {
            b = b.n();
        }
        ECAlgorithms.h(b);
        return b;
    }

    public abstract ECPoint b(ECPoint eCPoint, BigInteger bigInteger);
}
