package org.spongycastle.crypto.params;

import org.spongycastle.math.ec.ECPoint;

public class ECPublicKeyParameters extends ECKeyParameters {
    public final ECPoint a;

    public ECPublicKeyParameters(ECPoint eCPoint, ECDomainParameters eCDomainParameters) {
        super(false, eCDomainParameters);
        if (eCPoint == null) {
            throw new IllegalArgumentException("point has null value");
        } else if (!eCPoint.k()) {
            ECPoint o = eCPoint.o();
            if (o.l()) {
                this.a = o;
                return;
            }
            throw new IllegalArgumentException("point not on curve");
        } else {
            throw new IllegalArgumentException("point at infinity");
        }
    }
}
