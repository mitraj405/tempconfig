package org.spongycastle.crypto.params;

import org.spongycastle.crypto.CipherParameters;

public class MQVPrivateParameters implements CipherParameters {
    public final ECPrivateKeyParameters a;

    /* renamed from: a  reason: collision with other field name */
    public final ECPublicKeyParameters f6232a;
    public final ECPrivateKeyParameters b;

    public MQVPrivateParameters(ECPrivateKeyParameters eCPrivateKeyParameters, ECPrivateKeyParameters eCPrivateKeyParameters2, ECPublicKeyParameters eCPublicKeyParameters) {
        if (eCPrivateKeyParameters == null) {
            throw new NullPointerException("staticPrivateKey cannot be null");
        } else if (eCPrivateKeyParameters2 != null) {
            ECDomainParameters eCDomainParameters = eCPrivateKeyParameters.a;
            if (eCDomainParameters.equals(eCPrivateKeyParameters2.a)) {
                if (eCPublicKeyParameters == null) {
                    eCPublicKeyParameters = new ECPublicKeyParameters(eCDomainParameters.f6230a.m(eCPrivateKeyParameters2.a), eCDomainParameters);
                } else if (!eCDomainParameters.equals(eCPublicKeyParameters.a)) {
                    throw new IllegalArgumentException("Ephemeral public key has different domain parameters");
                }
                this.a = eCPrivateKeyParameters;
                this.b = eCPrivateKeyParameters2;
                this.f6232a = eCPublicKeyParameters;
                return;
            }
            throw new IllegalArgumentException("Static and ephemeral private keys have different domain parameters");
        } else {
            throw new NullPointerException("ephemeralPrivateKey cannot be null");
        }
    }
}
