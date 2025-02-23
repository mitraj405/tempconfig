package org.spongycastle.jcajce.provider.symmetric.util;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.KeyGeneratorSpi;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;

public class BaseKeyGenerator extends KeyGeneratorSpi {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final String f6552a;

    /* renamed from: a  reason: collision with other field name */
    public final CipherKeyGenerator f6553a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6554a = true;

    public BaseKeyGenerator(String str, int i, CipherKeyGenerator cipherKeyGenerator) {
        this.f6552a = str;
        this.a = i;
        this.f6553a = cipherKeyGenerator;
    }

    public SecretKey engineGenerateKey() {
        boolean z = this.f6554a;
        CipherKeyGenerator cipherKeyGenerator = this.f6553a;
        if (z) {
            cipherKeyGenerator.b(new KeyGenerationParameters(this.a, new SecureRandom()));
            this.f6554a = false;
        }
        return new SecretKeySpec(cipherKeyGenerator.a(), this.f6552a);
    }

    public final void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("Not Implemented");
    }

    public final void engineInit(SecureRandom secureRandom) {
        if (secureRandom != null) {
            this.f6553a.b(new KeyGenerationParameters(this.a, secureRandom));
            this.f6554a = false;
        }
    }

    public void engineInit(int i, SecureRandom secureRandom) {
        if (secureRandom == null) {
            try {
                secureRandom = new SecureRandom();
            } catch (IllegalArgumentException e) {
                throw new InvalidParameterException(e.getMessage());
            }
        }
        this.f6553a.b(new KeyGenerationParameters(i, secureRandom));
        this.f6554a = false;
    }
}
