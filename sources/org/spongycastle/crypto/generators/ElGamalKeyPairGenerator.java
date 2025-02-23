package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.ElGamalKeyGenerationParameters;
import org.spongycastle.crypto.params.ElGamalParameters;
import org.spongycastle.crypto.params.ElGamalPrivateKeyParameters;
import org.spongycastle.crypto.params.ElGamalPublicKeyParameters;

public class ElGamalKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    public ElGamalKeyGenerationParameters a;

    public final AsymmetricCipherKeyPair a() {
        DHKeyGeneratorHelper dHKeyGeneratorHelper = DHKeyGeneratorHelper.f6074a;
        ElGamalParameters elGamalParameters = this.a.a;
        DHParameters dHParameters = new DHParameters(elGamalParameters.c, elGamalParameters.b, elGamalParameters.a, (BigInteger) null);
        SecureRandom secureRandom = this.a.a;
        dHKeyGeneratorHelper.getClass();
        BigInteger a2 = DHKeyGeneratorHelper.a(secureRandom, dHParameters);
        return new AsymmetricCipherKeyPair(new ElGamalPublicKeyParameters(dHParameters.a.modPow(a2, dHParameters.b), elGamalParameters), new ElGamalPrivateKeyParameters(a2, elGamalParameters));
    }
}
