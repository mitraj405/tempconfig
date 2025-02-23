package org.spongycastle.pqc.jcajce.provider.mceliece;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2KeyGenerationParameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2KeyPairGenerator;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2Parameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2PrivateKeyParameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2PublicKeyParameters;
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

public class McElieceCCA2KeyPairGeneratorSpi extends KeyPairGenerator {
    public McElieceCCA2KeyPairGenerator a;

    public McElieceCCA2KeyPairGeneratorSpi() {
        super("McEliece-CCA2");
    }

    public final KeyPair generateKeyPair() {
        AsymmetricCipherKeyPair a2 = this.a.a();
        return new KeyPair(new BCMcElieceCCA2PublicKey((McElieceCCA2PublicKeyParameters) a2.a), new BCMcElieceCCA2PrivateKey((McElieceCCA2PrivateKeyParameters) a2.b));
    }

    public final void initialize(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
        this.a = new McElieceCCA2KeyPairGenerator();
        super.initialize(algorithmParameterSpec);
        McElieceCCA2KeyGenParameterSpec mcElieceCCA2KeyGenParameterSpec = (McElieceCCA2KeyGenParameterSpec) algorithmParameterSpec;
        this.a.b(new McElieceCCA2KeyGenerationParameters(new SecureRandom(), new McElieceCCA2Parameters(mcElieceCCA2KeyGenParameterSpec.a, mcElieceCCA2KeyGenParameterSpec.b, mcElieceCCA2KeyGenParameterSpec.f6839a)));
    }

    public final void initialize(int i, SecureRandom secureRandom) {
        this.a = new McElieceCCA2KeyPairGenerator();
        this.a.b(new McElieceCCA2KeyGenerationParameters(secureRandom, new McElieceCCA2Parameters()));
    }
}
