package org.spongycastle.crypto.params;

import org.spongycastle.crypto.CipherParameters;

public class MQVPublicParameters implements CipherParameters {
    public final ECPublicKeyParameters a;
    public final ECPublicKeyParameters b;

    public MQVPublicParameters(ECPublicKeyParameters eCPublicKeyParameters, ECPublicKeyParameters eCPublicKeyParameters2) {
        if (eCPublicKeyParameters == null) {
            throw new NullPointerException("staticPublicKey cannot be null");
        } else if (eCPublicKeyParameters2 == null) {
            throw new NullPointerException("ephemeralPublicKey cannot be null");
        } else if (eCPublicKeyParameters.a.equals(eCPublicKeyParameters2.a)) {
            this.a = eCPublicKeyParameters;
            this.b = eCPublicKeyParameters2;
        } else {
            throw new IllegalArgumentException("Static and ephemeral public keys have different domain parameters");
        }
    }
}
