package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;

public class DSTU4145KeyPairGenerator extends ECKeyPairGenerator {
    public final AsymmetricCipherKeyPair a() {
        AsymmetricCipherKeyPair a = super.a();
        ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) a.a;
        return new AsymmetricCipherKeyPair(new ECPublicKeyParameters(eCPublicKeyParameters.a.n(), eCPublicKeyParameters.a), (ECPrivateKeyParameters) a.b);
    }
}
