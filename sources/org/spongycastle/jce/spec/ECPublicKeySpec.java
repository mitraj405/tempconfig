package org.spongycastle.jce.spec;

import org.spongycastle.math.ec.ECPoint;

public class ECPublicKeySpec extends ECKeySpec {
    public final ECPoint a;

    public ECPublicKeySpec(ECPoint eCPoint, ECParameterSpec eCParameterSpec) {
        super(eCParameterSpec);
        if (eCPoint.f6620a != null) {
            this.a = eCPoint.o();
        } else {
            this.a = eCPoint;
        }
    }
}
