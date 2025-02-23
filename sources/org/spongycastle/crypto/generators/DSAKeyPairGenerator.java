package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.params.DSAKeyGenerationParameters;
import org.spongycastle.crypto.params.DSAParameters;
import org.spongycastle.crypto.params.DSAPrivateKeyParameters;
import org.spongycastle.crypto.params.DSAPublicKeyParameters;
import org.spongycastle.math.ec.WNafUtil;
import org.spongycastle.util.BigIntegers;

public class DSAKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    public static final BigInteger g = BigInteger.valueOf(1);
    public DSAKeyGenerationParameters a;

    public final AsymmetricCipherKeyPair a() {
        BigInteger c;
        DSAKeyGenerationParameters dSAKeyGenerationParameters = this.a;
        DSAParameters dSAParameters = dSAKeyGenerationParameters.a;
        BigInteger bigInteger = dSAParameters.b;
        SecureRandom secureRandom = dSAKeyGenerationParameters.a;
        int bitLength = bigInteger.bitLength() >>> 2;
        do {
            BigInteger bigInteger2 = g;
            c = BigIntegers.c(bigInteger2, bigInteger.subtract(bigInteger2), secureRandom);
        } while (WNafUtil.c(c) < bitLength);
        return new AsymmetricCipherKeyPair(new DSAPublicKeyParameters(dSAParameters.a.modPow(c, dSAParameters.c), dSAParameters), new DSAPrivateKeyParameters(c, dSAParameters));
    }
}
