package org.spongycastle.pqc.jcajce.provider.newhope;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.pqc.crypto.newhope.NHKeyPairGenerator;
import org.spongycastle.pqc.crypto.newhope.NHPrivateKeyParameters;
import org.spongycastle.pqc.crypto.newhope.NHPublicKeyParameters;

public class NHKeyPairGeneratorSpi extends KeyPairGenerator {
    public final SecureRandom a = new SecureRandom();

    /* renamed from: a  reason: collision with other field name */
    public final NHKeyPairGenerator f6814a = new NHKeyPairGenerator();

    /* renamed from: a  reason: collision with other field name */
    public boolean f6815a = false;

    public NHKeyPairGeneratorSpi() {
        super("NH");
    }

    public final KeyPair generateKeyPair() {
        boolean z = this.f6815a;
        NHKeyPairGenerator nHKeyPairGenerator = this.f6814a;
        if (!z) {
            SecureRandom secureRandom = this.a;
            nHKeyPairGenerator.getClass();
            nHKeyPairGenerator.a = secureRandom;
            this.f6815a = true;
        }
        AsymmetricCipherKeyPair a2 = nHKeyPairGenerator.a();
        return new KeyPair(new BCNHPublicKey((NHPublicKeyParameters) a2.a), new BCNHPrivateKey((NHPrivateKeyParameters) a2.b));
    }

    public final void initialize(int i, SecureRandom secureRandom) {
        if (i == 1024) {
            NHKeyPairGenerator nHKeyPairGenerator = this.f6814a;
            nHKeyPairGenerator.getClass();
            nHKeyPairGenerator.a = secureRandom;
            this.f6815a = true;
            return;
        }
        throw new IllegalArgumentException("strength must be 1024 bits");
    }

    public final void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("parameter object not recognised");
    }
}
