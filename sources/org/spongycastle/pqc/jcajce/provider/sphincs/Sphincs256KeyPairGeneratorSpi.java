package org.spongycastle.pqc.jcajce.provider.sphincs;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.digests.SHA3Digest;
import org.spongycastle.crypto.digests.SHA512tDigest;
import org.spongycastle.pqc.crypto.sphincs.SPHINCS256KeyGenerationParameters;
import org.spongycastle.pqc.crypto.sphincs.SPHINCS256KeyPairGenerator;
import org.spongycastle.pqc.crypto.sphincs.SPHINCSPrivateKeyParameters;
import org.spongycastle.pqc.crypto.sphincs.SPHINCSPublicKeyParameters;
import org.spongycastle.pqc.jcajce.spec.SPHINCS256KeyGenParameterSpec;

public class Sphincs256KeyPairGeneratorSpi extends KeyPairGenerator {
    public final SecureRandom a = new SecureRandom();

    /* renamed from: a  reason: collision with other field name */
    public ASN1ObjectIdentifier f6827a = NISTObjectIdentifiers.f;

    /* renamed from: a  reason: collision with other field name */
    public SPHINCS256KeyGenerationParameters f6828a;

    /* renamed from: a  reason: collision with other field name */
    public final SPHINCS256KeyPairGenerator f6829a = new SPHINCS256KeyPairGenerator();

    /* renamed from: a  reason: collision with other field name */
    public boolean f6830a = false;

    public Sphincs256KeyPairGeneratorSpi() {
        super("SPHINCS256");
    }

    public final KeyPair generateKeyPair() {
        boolean z = this.f6830a;
        SPHINCS256KeyPairGenerator sPHINCS256KeyPairGenerator = this.f6829a;
        if (!z) {
            SecureRandom secureRandom = this.a;
            SHA512tDigest sHA512tDigest = new SHA512tDigest(256);
            this.f6828a = new SPHINCS256KeyGenerationParameters(secureRandom, sHA512tDigest);
            sPHINCS256KeyPairGenerator.getClass();
            sPHINCS256KeyPairGenerator.a = secureRandom;
            sPHINCS256KeyPairGenerator.f6746a = sHA512tDigest;
            this.f6830a = true;
        }
        AsymmetricCipherKeyPair a2 = sPHINCS256KeyPairGenerator.a();
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this.f6827a;
        return new KeyPair(new BCSphincs256PublicKey(aSN1ObjectIdentifier, (SPHINCSPublicKeyParameters) a2.a), new BCSphincs256PrivateKey(aSN1ObjectIdentifier, (SPHINCSPrivateKeyParameters) a2.b));
    }

    public final void initialize(int i, SecureRandom secureRandom) {
        throw new IllegalArgumentException("use AlgorithmParameterSpec");
    }

    public final void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof SPHINCS256KeyGenParameterSpec) {
            SPHINCS256KeyGenParameterSpec sPHINCS256KeyGenParameterSpec = (SPHINCS256KeyGenParameterSpec) algorithmParameterSpec;
            if (sPHINCS256KeyGenParameterSpec.a.equals("SHA512-256")) {
                this.f6827a = NISTObjectIdentifiers.f;
                this.f6828a = new SPHINCS256KeyGenerationParameters(secureRandom, new SHA512tDigest(256));
            } else if (sPHINCS256KeyGenParameterSpec.a.equals("SHA3-256")) {
                this.f6827a = NISTObjectIdentifiers.h;
                this.f6828a = new SPHINCS256KeyGenerationParameters(secureRandom, new SHA3Digest(256));
            }
            SPHINCS256KeyGenerationParameters sPHINCS256KeyGenerationParameters = this.f6828a;
            SPHINCS256KeyPairGenerator sPHINCS256KeyPairGenerator = this.f6829a;
            sPHINCS256KeyPairGenerator.getClass();
            sPHINCS256KeyPairGenerator.a = sPHINCS256KeyGenerationParameters.a;
            sPHINCS256KeyPairGenerator.f6746a = sPHINCS256KeyGenerationParameters.a;
            this.f6830a = true;
            return;
        }
        throw new InvalidAlgorithmParameterException("parameter object not a SPHINCS256KeyGenParameterSpec");
    }
}
