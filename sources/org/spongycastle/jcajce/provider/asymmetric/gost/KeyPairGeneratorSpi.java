package org.spongycastle.jcajce.provider.asymmetric.gost;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.generators.GOST3410KeyPairGenerator;
import org.spongycastle.crypto.params.GOST3410KeyGenerationParameters;
import org.spongycastle.crypto.params.GOST3410Parameters;
import org.spongycastle.crypto.params.GOST3410PrivateKeyParameters;
import org.spongycastle.crypto.params.GOST3410PublicKeyParameters;
import org.spongycastle.jce.spec.GOST3410ParameterSpec;
import org.spongycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;

public class KeyPairGeneratorSpi extends KeyPairGenerator {
    public final GOST3410KeyPairGenerator a = new GOST3410KeyPairGenerator();

    /* renamed from: a  reason: collision with other field name */
    public GOST3410ParameterSpec f6449a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6450a = false;

    public KeyPairGeneratorSpi() {
        super("GOST3410");
    }

    public final void a(GOST3410ParameterSpec gOST3410ParameterSpec, SecureRandom secureRandom) {
        GOST3410PublicKeyParameterSetSpec gOST3410PublicKeyParameterSetSpec = gOST3410ParameterSpec.f6605a;
        GOST3410KeyGenerationParameters gOST3410KeyGenerationParameters = new GOST3410KeyGenerationParameters(secureRandom, new GOST3410Parameters(gOST3410PublicKeyParameterSetSpec.a, gOST3410PublicKeyParameterSetSpec.b, gOST3410PublicKeyParameterSetSpec.c));
        GOST3410KeyPairGenerator gOST3410KeyPairGenerator = this.a;
        gOST3410KeyPairGenerator.getClass();
        gOST3410KeyPairGenerator.a = gOST3410KeyGenerationParameters;
        this.f6450a = true;
        this.f6449a = gOST3410ParameterSpec;
    }

    public final KeyPair generateKeyPair() {
        if (!this.f6450a) {
            a(new GOST3410ParameterSpec(CryptoProObjectIdentifiers.p.c, CryptoProObjectIdentifiers.o.c, (String) null), new SecureRandom());
        }
        AsymmetricCipherKeyPair a2 = this.a.a();
        return new KeyPair(new BCGOST3410PublicKey((GOST3410PublicKeyParameters) a2.a, this.f6449a), new BCGOST3410PrivateKey((GOST3410PrivateKeyParameters) a2.b, this.f6449a));
    }

    public final void initialize(int i, SecureRandom secureRandom) {
    }

    public final void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof GOST3410ParameterSpec) {
            a((GOST3410ParameterSpec) algorithmParameterSpec, secureRandom);
            return;
        }
        throw new InvalidAlgorithmParameterException("parameter object not a GOST3410ParameterSpec");
    }
}
