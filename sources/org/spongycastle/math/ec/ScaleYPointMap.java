package org.spongycastle.math.ec;

public class ScaleYPointMap implements ECPointMap {
    public final ECPoint a(ECPoint eCPoint) {
        return eCPoint.t((ECFieldElement) null);
    }
}
