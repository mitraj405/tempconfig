package org.spongycastle.crypto.agreement;

import java.math.BigInteger;
import org.spongycastle.crypto.BasicAgreement;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.math.ec.ECPoint;

public class ECDHCBasicAgreement implements BasicAgreement {
    public ECPrivateKeyParameters a;

    public final void a(CipherParameters cipherParameters) {
        this.a = (ECPrivateKeyParameters) cipherParameters;
    }

    public final BigInteger b(CipherParameters cipherParameters) {
        ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) cipherParameters;
        ECDomainParameters eCDomainParameters = eCPublicKeyParameters.a;
        if (eCDomainParameters.equals(this.a.a)) {
            ECPoint o = eCPublicKeyParameters.a.m(eCDomainParameters.h.multiply(this.a.a).mod(eCDomainParameters.g)).o();
            if (!o.k()) {
                o.b();
                return o.f6621a.t();
            }
            throw new IllegalStateException("Infinity is not a valid agreement value for ECDHC");
        }
        throw new IllegalStateException("ECDHC public key has wrong domain parameters");
    }

    public final int getFieldSize() {
        return (this.a.a.a.k() + 7) / 8;
    }
}
