package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.params.GOST3410KeyGenerationParameters;
import org.spongycastle.crypto.params.GOST3410Parameters;
import org.spongycastle.crypto.params.GOST3410PrivateKeyParameters;
import org.spongycastle.crypto.params.GOST3410PublicKeyParameters;
import org.spongycastle.math.ec.WNafUtil;

public class GOST3410KeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    public GOST3410KeyGenerationParameters a;

    public final AsymmetricCipherKeyPair a() {
        GOST3410KeyGenerationParameters gOST3410KeyGenerationParameters = this.a;
        GOST3410Parameters gOST3410Parameters = gOST3410KeyGenerationParameters.a;
        SecureRandom secureRandom = gOST3410KeyGenerationParameters.a;
        BigInteger bigInteger = gOST3410Parameters.b;
        while (true) {
            BigInteger bigInteger2 = new BigInteger(256, secureRandom);
            if (bigInteger2.signum() >= 1 && bigInteger2.compareTo(bigInteger) < 0 && WNafUtil.c(bigInteger2) >= 64) {
                return new AsymmetricCipherKeyPair(new GOST3410PublicKeyParameters(gOST3410Parameters.c.modPow(bigInteger2, gOST3410Parameters.a), gOST3410Parameters), new GOST3410PrivateKeyParameters(bigInteger2, gOST3410Parameters));
            }
        }
    }
}
