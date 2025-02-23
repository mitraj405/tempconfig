package org.spongycastle.jcajce.provider.asymmetric.dh;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import javax.crypto.spec.DHParameterSpec;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.generators.DHBasicKeyPairGenerator;
import org.spongycastle.crypto.generators.DHParametersGenerator;
import org.spongycastle.crypto.params.DHKeyGenerationParameters;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPrivateKeyParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.PrimeCertaintyCalculator;
import org.spongycastle.jce.provider.BouncyCastleProvider;

public class KeyPairGeneratorSpi extends KeyPairGenerator {
    public static final Object a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public static final Hashtable f6354a = new Hashtable();

    /* renamed from: a  reason: collision with other field name */
    public int f6355a = 2048;

    /* renamed from: a  reason: collision with other field name */
    public SecureRandom f6356a = new SecureRandom();

    /* renamed from: a  reason: collision with other field name */
    public final DHBasicKeyPairGenerator f6357a = new DHBasicKeyPairGenerator();

    /* renamed from: a  reason: collision with other field name */
    public DHKeyGenerationParameters f6358a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6359a = false;

    public KeyPairGeneratorSpi() {
        super("DH");
    }

    public final KeyPair generateKeyPair() {
        if (!this.f6359a) {
            Integer valueOf = Integer.valueOf(this.f6355a);
            Hashtable hashtable = f6354a;
            if (hashtable.containsKey(valueOf)) {
                this.f6358a = (DHKeyGenerationParameters) hashtable.get(valueOf);
            } else {
                DHParameterSpec a2 = BouncyCastleProvider.f6565a.a(this.f6355a);
                if (a2 != null) {
                    this.f6358a = new DHKeyGenerationParameters(this.f6356a, new DHParameters(a2.getL(), a2.getP(), a2.getG(), (BigInteger) null));
                } else {
                    synchronized (a) {
                        if (hashtable.containsKey(valueOf)) {
                            this.f6358a = (DHKeyGenerationParameters) hashtable.get(valueOf);
                        } else {
                            DHParametersGenerator dHParametersGenerator = new DHParametersGenerator();
                            int i = this.f6355a;
                            int a3 = PrimeCertaintyCalculator.a(i);
                            SecureRandom secureRandom = this.f6356a;
                            dHParametersGenerator.a = i;
                            dHParametersGenerator.b = a3;
                            dHParametersGenerator.f6075a = secureRandom;
                            DHKeyGenerationParameters dHKeyGenerationParameters = new DHKeyGenerationParameters(secureRandom, dHParametersGenerator.a());
                            this.f6358a = dHKeyGenerationParameters;
                            hashtable.put(valueOf, dHKeyGenerationParameters);
                        }
                    }
                }
            }
            DHBasicKeyPairGenerator dHBasicKeyPairGenerator = this.f6357a;
            DHKeyGenerationParameters dHKeyGenerationParameters2 = this.f6358a;
            dHBasicKeyPairGenerator.getClass();
            dHBasicKeyPairGenerator.a = dHKeyGenerationParameters2;
            this.f6359a = true;
        }
        AsymmetricCipherKeyPair a4 = this.f6357a.a();
        return new KeyPair(new BCDHPublicKey((DHPublicKeyParameters) a4.a), new BCDHPrivateKey((DHPrivateKeyParameters) a4.b));
    }

    public final void initialize(int i, SecureRandom secureRandom) {
        this.f6355a = i;
        this.f6356a = secureRandom;
        this.f6359a = false;
    }

    public final void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof DHParameterSpec) {
            DHParameterSpec dHParameterSpec = (DHParameterSpec) algorithmParameterSpec;
            DHKeyGenerationParameters dHKeyGenerationParameters = new DHKeyGenerationParameters(secureRandom, new DHParameters(dHParameterSpec.getL(), dHParameterSpec.getP(), dHParameterSpec.getG(), (BigInteger) null));
            this.f6358a = dHKeyGenerationParameters;
            DHBasicKeyPairGenerator dHBasicKeyPairGenerator = this.f6357a;
            dHBasicKeyPairGenerator.getClass();
            dHBasicKeyPairGenerator.a = dHKeyGenerationParameters;
            this.f6359a = true;
            return;
        }
        throw new InvalidAlgorithmParameterException("parameter object not a DHParameterSpec");
    }
}
