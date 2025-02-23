package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.params.DHKeyGenerationParameters;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPrivateKeyParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;

public class DHBasicKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    public DHKeyGenerationParameters a;

    public final AsymmetricCipherKeyPair a() {
        DHKeyGeneratorHelper dHKeyGeneratorHelper = DHKeyGeneratorHelper.f6074a;
        DHKeyGenerationParameters dHKeyGenerationParameters = this.a;
        DHParameters dHParameters = dHKeyGenerationParameters.a;
        dHKeyGeneratorHelper.getClass();
        BigInteger a2 = DHKeyGeneratorHelper.a(dHKeyGenerationParameters.a, dHParameters);
        return new AsymmetricCipherKeyPair(new DHPublicKeyParameters(dHParameters.a.modPow(a2, dHParameters.b), dHParameters), new DHPrivateKeyParameters(a2, dHParameters));
    }
}
