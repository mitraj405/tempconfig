package org.spongycastle.jcajce.provider.asymmetric.elgamal;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.DHParameterSpec;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.generators.ElGamalKeyPairGenerator;
import org.spongycastle.crypto.generators.ElGamalParametersGenerator;
import org.spongycastle.crypto.params.ElGamalKeyGenerationParameters;
import org.spongycastle.crypto.params.ElGamalParameters;
import org.spongycastle.crypto.params.ElGamalPrivateKeyParameters;
import org.spongycastle.crypto.params.ElGamalPublicKeyParameters;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ElGamalParameterSpec;

public class KeyPairGeneratorSpi extends KeyPairGenerator {
    public int a = UserMetadata.MAX_ATTRIBUTE_SIZE;

    /* renamed from: a  reason: collision with other field name */
    public SecureRandom f6441a = new SecureRandom();

    /* renamed from: a  reason: collision with other field name */
    public final ElGamalKeyPairGenerator f6442a = new ElGamalKeyPairGenerator();

    /* renamed from: a  reason: collision with other field name */
    public ElGamalKeyGenerationParameters f6443a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6444a = false;
    public final int b = 20;

    public KeyPairGeneratorSpi() {
        super("ElGamal");
    }

    public final KeyPair generateKeyPair() {
        boolean z = this.f6444a;
        ElGamalKeyPairGenerator elGamalKeyPairGenerator = this.f6442a;
        if (!z) {
            DHParameterSpec a2 = BouncyCastleProvider.f6565a.a(this.a);
            if (a2 != null) {
                this.f6443a = new ElGamalKeyGenerationParameters(this.f6441a, new ElGamalParameters(a2.getL(), a2.getP(), a2.getG()));
            } else {
                ElGamalParametersGenerator elGamalParametersGenerator = new ElGamalParametersGenerator();
                int i = this.a;
                SecureRandom secureRandom = this.f6441a;
                elGamalParametersGenerator.a = i;
                elGamalParametersGenerator.b = this.b;
                elGamalParametersGenerator.f6082a = secureRandom;
                this.f6443a = new ElGamalKeyGenerationParameters(secureRandom, elGamalParametersGenerator.a());
            }
            ElGamalKeyGenerationParameters elGamalKeyGenerationParameters = this.f6443a;
            elGamalKeyPairGenerator.getClass();
            elGamalKeyPairGenerator.a = elGamalKeyGenerationParameters;
            this.f6444a = true;
        }
        AsymmetricCipherKeyPair a3 = elGamalKeyPairGenerator.a();
        return new KeyPair(new BCElGamalPublicKey((ElGamalPublicKeyParameters) a3.a), new BCElGamalPrivateKey((ElGamalPrivateKeyParameters) a3.b));
    }

    public final void initialize(int i, SecureRandom secureRandom) {
        this.a = i;
        this.f6441a = secureRandom;
    }

    public final void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        boolean z = algorithmParameterSpec instanceof ElGamalParameterSpec;
        if (z || (algorithmParameterSpec instanceof DHParameterSpec)) {
            if (z) {
                ElGamalParameterSpec elGamalParameterSpec = (ElGamalParameterSpec) algorithmParameterSpec;
                this.f6443a = new ElGamalKeyGenerationParameters(secureRandom, new ElGamalParameters(0, elGamalParameterSpec.a, elGamalParameterSpec.b));
            } else {
                DHParameterSpec dHParameterSpec = (DHParameterSpec) algorithmParameterSpec;
                this.f6443a = new ElGamalKeyGenerationParameters(secureRandom, new ElGamalParameters(dHParameterSpec.getL(), dHParameterSpec.getP(), dHParameterSpec.getG()));
            }
            ElGamalKeyGenerationParameters elGamalKeyGenerationParameters = this.f6443a;
            ElGamalKeyPairGenerator elGamalKeyPairGenerator = this.f6442a;
            elGamalKeyPairGenerator.getClass();
            elGamalKeyPairGenerator.a = elGamalKeyGenerationParameters;
            this.f6444a = true;
            return;
        }
        throw new InvalidAlgorithmParameterException("parameter object not a DHParameterSpec or an ElGamalParameterSpec");
    }
}
