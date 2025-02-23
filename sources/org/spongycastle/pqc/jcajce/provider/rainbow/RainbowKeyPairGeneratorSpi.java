package org.spongycastle.pqc.jcajce.provider.rainbow;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.pqc.crypto.rainbow.RainbowKeyGenerationParameters;
import org.spongycastle.pqc.crypto.rainbow.RainbowKeyPairGenerator;
import org.spongycastle.pqc.crypto.rainbow.RainbowParameters;
import org.spongycastle.pqc.crypto.rainbow.RainbowPrivateKeyParameters;
import org.spongycastle.pqc.crypto.rainbow.RainbowPublicKeyParameters;
import org.spongycastle.pqc.jcajce.spec.RainbowParameterSpec;
import org.spongycastle.util.Arrays;

public class RainbowKeyPairGeneratorSpi extends KeyPairGenerator {
    public SecureRandom a = new SecureRandom();

    /* renamed from: a  reason: collision with other field name */
    public final RainbowKeyPairGenerator f6821a = new RainbowKeyPairGenerator();

    /* renamed from: a  reason: collision with other field name */
    public boolean f6822a = false;

    public RainbowKeyPairGeneratorSpi() {
        super("Rainbow");
    }

    public final KeyPair generateKeyPair() {
        boolean z = this.f6822a;
        RainbowKeyPairGenerator rainbowKeyPairGenerator = this.f6821a;
        if (!z) {
            rainbowKeyPairGenerator.b(new RainbowKeyGenerationParameters(this.a, new RainbowParameters(Arrays.d(new RainbowParameterSpec().a))));
            this.f6822a = true;
        }
        AsymmetricCipherKeyPair a2 = rainbowKeyPairGenerator.a();
        RainbowPublicKeyParameters rainbowPublicKeyParameters = (RainbowPublicKeyParameters) a2.a;
        RainbowPrivateKeyParameters rainbowPrivateKeyParameters = (RainbowPrivateKeyParameters) a2.b;
        return new KeyPair(new BCRainbowPublicKey(rainbowPublicKeyParameters.c, rainbowPublicKeyParameters.f6738a, rainbowPublicKeyParameters.b, rainbowPublicKeyParameters.a), new BCRainbowPrivateKey(rainbowPrivateKeyParameters.f6736a, rainbowPrivateKeyParameters.f6735a, rainbowPrivateKeyParameters.f6737b, rainbowPrivateKeyParameters.b, rainbowPrivateKeyParameters.a, rainbowPrivateKeyParameters.f6734a));
    }

    public final void initialize(int i, SecureRandom secureRandom) {
        this.a = secureRandom;
    }

    public final void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof RainbowParameterSpec) {
            this.f6821a.b(new RainbowKeyGenerationParameters(secureRandom, new RainbowParameters(Arrays.d(((RainbowParameterSpec) algorithmParameterSpec).a))));
            this.f6822a = true;
            return;
        }
        throw new InvalidAlgorithmParameterException("parameter object not a RainbowParameterSpec");
    }
}
