package org.spongycastle.math.ec;

public class ScaleXPointMap implements ECPointMap {
    public final ECFieldElement a;

    public ScaleXPointMap(ECFieldElement eCFieldElement) {
        this.a = eCFieldElement;
    }

    public final ECPoint a(ECPoint eCPoint) {
        return eCPoint.s(this.a);
    }
}
