package org.spongycastle.jcajce.provider.asymmetric.rsa;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.RSAKeyGenParameterSpec;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.generators.RSAKeyPairGenerator;
import org.spongycastle.crypto.params.RSAKeyGenerationParameters;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.PrimeCertaintyCalculator;

public class KeyPairGeneratorSpi extends KeyPairGenerator {
    public static final BigInteger a = BigInteger.valueOf(65537);

    /* renamed from: a  reason: collision with other field name */
    public final RSAKeyPairGenerator f6463a;

    public KeyPairGeneratorSpi() {
        super("RSA");
        RSAKeyPairGenerator rSAKeyPairGenerator = new RSAKeyPairGenerator();
        this.f6463a = rSAKeyPairGenerator;
        rSAKeyPairGenerator.c(new RSAKeyGenerationParameters(a, new SecureRandom(), 2048, PrimeCertaintyCalculator.a(2048)));
    }

    public final KeyPair generateKeyPair() {
        AsymmetricCipherKeyPair a2 = this.f6463a.a();
        return new KeyPair(new BCRSAPublicKey((RSAKeyParameters) a2.a), new BCRSAPrivateCrtKey((RSAPrivateCrtKeyParameters) a2.b));
    }

    public final void initialize(int i, SecureRandom secureRandom) {
        this.f6463a.c(new RSAKeyGenerationParameters(a, secureRandom, i, PrimeCertaintyCalculator.a(i)));
    }

    public final void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof RSAKeyGenParameterSpec) {
            RSAKeyGenParameterSpec rSAKeyGenParameterSpec = (RSAKeyGenParameterSpec) algorithmParameterSpec;
            this.f6463a.c(new RSAKeyGenerationParameters(rSAKeyGenParameterSpec.getPublicExponent(), secureRandom, rSAKeyGenParameterSpec.getKeysize(), PrimeCertaintyCalculator.a(2048)));
            return;
        }
        throw new InvalidAlgorithmParameterException("parameter object not a RSAKeyGenParameterSpec");
    }
}
