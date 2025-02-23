package org.spongycastle.crypto.prng.drbg;

import org.spongycastle.math.ec.ECPoint;

public class DualECPoints {
    public DualECPoints(ECPoint eCPoint, ECPoint eCPoint2) {
        if (!eCPoint.f6620a.i(eCPoint2.f6620a)) {
            throw new IllegalArgumentException("points need to be on the same curve");
        }
    }
}
