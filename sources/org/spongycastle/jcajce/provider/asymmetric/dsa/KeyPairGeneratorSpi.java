package org.spongycastle.jcajce.provider.asymmetric.dsa;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAParameterSpec;
import java.util.Hashtable;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.generators.DSAKeyPairGenerator;
import org.spongycastle.crypto.generators.DSAParametersGenerator;
import org.spongycastle.crypto.params.DSAKeyGenerationParameters;
import org.spongycastle.crypto.params.DSAParameterGenerationParameters;
import org.spongycastle.crypto.params.DSAParameters;
import org.spongycastle.crypto.params.DSAPrivateKeyParameters;
import org.spongycastle.crypto.params.DSAPublicKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.PrimeCertaintyCalculator;
import org.spongycastle.util.Properties;

public class KeyPairGeneratorSpi extends KeyPairGenerator {
    public static final Object a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public static final Hashtable f6367a = new Hashtable();

    /* renamed from: a  reason: collision with other field name */
    public int f6368a = 2048;

    /* renamed from: a  reason: collision with other field name */
    public SecureRandom f6369a = new SecureRandom();

    /* renamed from: a  reason: collision with other field name */
    public final DSAKeyPairGenerator f6370a = new DSAKeyPairGenerator();

    /* renamed from: a  reason: collision with other field name */
    public DSAKeyGenerationParameters f6371a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6372a = false;

    public KeyPairGeneratorSpi() {
        super("DSA");
    }

    public final KeyPair generateKeyPair() {
        DSAParametersGenerator dSAParametersGenerator;
        if (!this.f6372a) {
            Integer valueOf = Integer.valueOf(this.f6368a);
            Hashtable hashtable = f6367a;
            if (hashtable.containsKey(valueOf)) {
                this.f6371a = (DSAKeyGenerationParameters) hashtable.get(valueOf);
            } else {
                synchronized (a) {
                    try {
                        if (hashtable.containsKey(valueOf)) {
                            this.f6371a = (DSAKeyGenerationParameters) hashtable.get(valueOf);
                        } else {
                            int a2 = PrimeCertaintyCalculator.a(this.f6368a);
                            int i = this.f6368a;
                            if (i == 1024) {
                                dSAParametersGenerator = new DSAParametersGenerator();
                                if (Properties.b("org.spongycastle.dsa.FIPS186-2for1024bits")) {
                                    dSAParametersGenerator.d(this.f6368a, a2, this.f6369a);
                                } else {
                                    dSAParametersGenerator.e(new DSAParameterGenerationParameters(UserMetadata.MAX_ATTRIBUTE_SIZE, 160, a2, this.f6369a));
                                }
                            } else if (i > 1024) {
                                DSAParameterGenerationParameters dSAParameterGenerationParameters = new DSAParameterGenerationParameters(i, 256, a2, this.f6369a);
                                dSAParametersGenerator = new DSAParametersGenerator(new SHA256Digest());
                                dSAParametersGenerator.e(dSAParameterGenerationParameters);
                            } else {
                                dSAParametersGenerator = new DSAParametersGenerator();
                                dSAParametersGenerator.d(this.f6368a, a2, this.f6369a);
                            }
                            DSAKeyGenerationParameters dSAKeyGenerationParameters = new DSAKeyGenerationParameters(this.f6369a, dSAParametersGenerator.b());
                            this.f6371a = dSAKeyGenerationParameters;
                            hashtable.put(valueOf, dSAKeyGenerationParameters);
                        }
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
            }
            DSAKeyPairGenerator dSAKeyPairGenerator = this.f6370a;
            DSAKeyGenerationParameters dSAKeyGenerationParameters2 = this.f6371a;
            dSAKeyPairGenerator.getClass();
            dSAKeyPairGenerator.a = dSAKeyGenerationParameters2;
            this.f6372a = true;
        }
        AsymmetricCipherKeyPair a3 = this.f6370a.a();
        return new KeyPair(new BCDSAPublicKey((DSAPublicKeyParameters) a3.a), new BCDSAPrivateKey((DSAPrivateKeyParameters) a3.b));
    }

    public final void initialize(int i, SecureRandom secureRandom) {
        if (i < 512 || i > 4096 || ((i < 1024 && i % 64 != 0) || (i >= 1024 && i % UserMetadata.MAX_ATTRIBUTE_SIZE != 0))) {
            throw new InvalidParameterException("strength must be from 512 - 4096 and a multiple of 1024 above 1024");
        }
        this.f6368a = i;
        this.f6369a = secureRandom;
        this.f6372a = false;
    }

    public final void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof DSAParameterSpec) {
            DSAParameterSpec dSAParameterSpec = (DSAParameterSpec) algorithmParameterSpec;
            DSAKeyGenerationParameters dSAKeyGenerationParameters = new DSAKeyGenerationParameters(secureRandom, new DSAParameters(dSAParameterSpec.getP(), dSAParameterSpec.getQ(), dSAParameterSpec.getG()));
            this.f6371a = dSAKeyGenerationParameters;
            DSAKeyPairGenerator dSAKeyPairGenerator = this.f6370a;
            dSAKeyPairGenerator.getClass();
            dSAKeyPairGenerator.a = dSAKeyGenerationParameters;
            this.f6372a = true;
            return;
        }
        throw new InvalidAlgorithmParameterException("parameter object not a DSAParameterSpec");
    }
}
