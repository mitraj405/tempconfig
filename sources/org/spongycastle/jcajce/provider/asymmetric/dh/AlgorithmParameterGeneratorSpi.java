package org.spongycastle.jcajce.provider.asymmetric.dh;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.DHGenParameterSpec;
import javax.crypto.spec.DHParameterSpec;
import org.spongycastle.crypto.generators.DHParametersGenerator;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.BaseAlgorithmParameterGeneratorSpi;
import org.spongycastle.jcajce.provider.asymmetric.util.PrimeCertaintyCalculator;

public class AlgorithmParameterGeneratorSpi extends BaseAlgorithmParameterGeneratorSpi {
    public int a = 2048;

    /* renamed from: a  reason: collision with other field name */
    public SecureRandom f6339a;
    public int b = 0;

    public final AlgorithmParameters engineGenerateParameters() {
        DHParametersGenerator dHParametersGenerator = new DHParametersGenerator();
        int a2 = PrimeCertaintyCalculator.a(this.a);
        SecureRandom secureRandom = this.f6339a;
        if (secureRandom != null) {
            dHParametersGenerator.a = this.a;
            dHParametersGenerator.b = a2;
            dHParametersGenerator.f6075a = secureRandom;
        } else {
            int i = this.a;
            SecureRandom secureRandom2 = new SecureRandom();
            dHParametersGenerator.a = i;
            dHParametersGenerator.b = a2;
            dHParametersGenerator.f6075a = secureRandom2;
        }
        DHParameters a3 = dHParametersGenerator.a();
        try {
            AlgorithmParameters b2 = this.a.b("DH");
            b2.init(new DHParameterSpec(a3.b, a3.a, this.b));
            return b2;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public final void engineInit(int i, SecureRandom secureRandom) {
        this.a = i;
        this.f6339a = secureRandom;
    }

    public final void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof DHGenParameterSpec) {
            DHGenParameterSpec dHGenParameterSpec = (DHGenParameterSpec) algorithmParameterSpec;
            this.a = dHGenParameterSpec.getPrimeSize();
            this.b = dHGenParameterSpec.getExponentSize();
            this.f6339a = secureRandom;
            return;
        }
        throw new InvalidAlgorithmParameterException("DH parameter generator requires a DHGenParameterSpec for initialisation");
    }
}
