package org.spongycastle.jcajce.provider.asymmetric.dsa;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAParameterSpec;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.generators.DSAParametersGenerator;
import org.spongycastle.crypto.params.DSAParameterGenerationParameters;
import org.spongycastle.crypto.params.DSAParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.BaseAlgorithmParameterGeneratorSpi;
import org.spongycastle.jcajce.provider.asymmetric.util.PrimeCertaintyCalculator;

public class AlgorithmParameterGeneratorSpi extends BaseAlgorithmParameterGeneratorSpi {
    public int a = 2048;

    /* renamed from: a  reason: collision with other field name */
    public SecureRandom f6360a;

    public final AlgorithmParameters engineGenerateParameters() {
        DSAParametersGenerator dSAParametersGenerator;
        if (this.a <= 1024) {
            dSAParametersGenerator = new DSAParametersGenerator();
        } else {
            dSAParametersGenerator = new DSAParametersGenerator(new SHA256Digest());
        }
        if (this.f6360a == null) {
            this.f6360a = new SecureRandom();
        }
        int a2 = PrimeCertaintyCalculator.a(this.a);
        int i = this.a;
        if (i == 1024) {
            dSAParametersGenerator.e(new DSAParameterGenerationParameters(UserMetadata.MAX_ATTRIBUTE_SIZE, 160, a2, this.f6360a));
        } else if (i > 1024) {
            dSAParametersGenerator.e(new DSAParameterGenerationParameters(i, 256, a2, this.f6360a));
        } else {
            dSAParametersGenerator.d(i, a2, this.f6360a);
        }
        DSAParameters b = dSAParametersGenerator.b();
        try {
            AlgorithmParameters b2 = this.a.b("DSA");
            b2.init(new DSAParameterSpec(b.c, b.b, b.a));
            return b2;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public final void engineInit(int i, SecureRandom secureRandom) {
        if (i < 512 || i > 3072) {
            throw new InvalidParameterException("strength must be from 512 - 3072");
        } else if (i <= 1024 && i % 64 != 0) {
            throw new InvalidParameterException("strength must be a multiple of 64 below 1024 bits.");
        } else if (i <= 1024 || i % UserMetadata.MAX_ATTRIBUTE_SIZE == 0) {
            this.a = i;
            this.f6360a = secureRandom;
        } else {
            throw new InvalidParameterException("strength must be a multiple of 1024 above 1024 bits.");
        }
    }

    public final void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for DSA parameter generation.");
    }
}
