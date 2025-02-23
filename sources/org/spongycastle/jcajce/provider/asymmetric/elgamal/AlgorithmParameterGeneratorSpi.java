package org.spongycastle.jcajce.provider.asymmetric.elgamal;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.DHGenParameterSpec;
import javax.crypto.spec.DHParameterSpec;
import org.spongycastle.crypto.generators.ElGamalParametersGenerator;
import org.spongycastle.crypto.params.ElGamalParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.BaseAlgorithmParameterGeneratorSpi;

public class AlgorithmParameterGeneratorSpi extends BaseAlgorithmParameterGeneratorSpi {
    public int a = UserMetadata.MAX_ATTRIBUTE_SIZE;

    /* renamed from: a  reason: collision with other field name */
    public SecureRandom f6435a;
    public int b = 0;

    public final AlgorithmParameters engineGenerateParameters() {
        ElGamalParametersGenerator elGamalParametersGenerator = new ElGamalParametersGenerator();
        SecureRandom secureRandom = this.f6435a;
        if (secureRandom != null) {
            elGamalParametersGenerator.a = this.a;
            elGamalParametersGenerator.b = 20;
            elGamalParametersGenerator.f6082a = secureRandom;
        } else {
            int i = this.a;
            SecureRandom secureRandom2 = new SecureRandom();
            elGamalParametersGenerator.a = i;
            elGamalParametersGenerator.b = 20;
            elGamalParametersGenerator.f6082a = secureRandom2;
        }
        ElGamalParameters a2 = elGamalParametersGenerator.a();
        try {
            AlgorithmParameters b2 = this.a.b("ElGamal");
            b2.init(new DHParameterSpec(a2.b, a2.a, this.b));
            return b2;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public final void engineInit(int i, SecureRandom secureRandom) {
        this.a = i;
        this.f6435a = secureRandom;
    }

    public final void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof DHGenParameterSpec) {
            DHGenParameterSpec dHGenParameterSpec = (DHGenParameterSpec) algorithmParameterSpec;
            this.a = dHGenParameterSpec.getPrimeSize();
            this.b = dHGenParameterSpec.getExponentSize();
            this.f6435a = secureRandom;
            return;
        }
        throw new InvalidAlgorithmParameterException("DH parameter generator requires a DHGenParameterSpec for initialisation");
    }
}
