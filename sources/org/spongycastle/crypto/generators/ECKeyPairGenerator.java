package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECKeyGenerationParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.FixedPointCombMultiplier;
import org.spongycastle.math.ec.WNafUtil;

public class ECKeyPairGenerator implements AsymmetricCipherKeyPairGenerator, ECConstants {
    public SecureRandom a;

    /* renamed from: a  reason: collision with other field name */
    public ECDomainParameters f6081a;

    public AsymmetricCipherKeyPair a() {
        BigInteger bigInteger = this.f6081a.g;
        int bitLength = bigInteger.bitLength();
        int i = bitLength >>> 2;
        while (true) {
            BigInteger bigInteger2 = new BigInteger(bitLength, this.a);
            if (bigInteger2.compareTo(ECConstants.c) >= 0 && bigInteger2.compareTo(bigInteger) < 0 && WNafUtil.c(bigInteger2) >= i) {
                return new AsymmetricCipherKeyPair(new ECPublicKeyParameters(new FixedPointCombMultiplier().a(this.f6081a.f6230a, bigInteger2), this.f6081a), new ECPrivateKeyParameters(bigInteger2, this.f6081a));
            }
        }
    }

    public final void b(KeyGenerationParameters keyGenerationParameters) {
        ECKeyGenerationParameters eCKeyGenerationParameters = (ECKeyGenerationParameters) keyGenerationParameters;
        SecureRandom secureRandom = eCKeyGenerationParameters.a;
        this.a = secureRandom;
        this.f6081a = eCKeyGenerationParameters.a;
        if (secureRandom == null) {
            this.a = new SecureRandom();
        }
    }
}
