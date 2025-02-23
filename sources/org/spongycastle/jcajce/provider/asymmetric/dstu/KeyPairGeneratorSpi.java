package org.spongycastle.jcajce.provider.asymmetric.dstu;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ua.DSTU4145NamedCurves;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.generators.DSTU4145KeyPairGenerator;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECKeyGenerationParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECNamedCurveGenParameterSpec;
import org.spongycastle.jce.spec.ECNamedCurveSpec;
import org.spongycastle.jce.spec.ECParameterSpec;
import org.spongycastle.math.ec.ECCurve;

public class KeyPairGeneratorSpi extends KeyPairGenerator {
    public final String a = "DSTU4145";

    /* renamed from: a  reason: collision with other field name */
    public AlgorithmParameterSpec f6378a = null;

    /* renamed from: a  reason: collision with other field name */
    public final DSTU4145KeyPairGenerator f6379a = new DSTU4145KeyPairGenerator();

    /* renamed from: a  reason: collision with other field name */
    public boolean f6380a = false;

    public KeyPairGeneratorSpi() {
        super("DSTU4145");
    }

    public final KeyPair generateKeyPair() {
        if (this.f6380a) {
            AsymmetricCipherKeyPair a2 = this.f6379a.a();
            ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) a2.a;
            ECPrivateKeyParameters eCPrivateKeyParameters = (ECPrivateKeyParameters) a2.b;
            AlgorithmParameterSpec algorithmParameterSpec = this.f6378a;
            boolean z = algorithmParameterSpec instanceof ECParameterSpec;
            String str = this.a;
            if (z) {
                ECParameterSpec eCParameterSpec = (ECParameterSpec) algorithmParameterSpec;
                BCDSTU4145PublicKey bCDSTU4145PublicKey = new BCDSTU4145PublicKey(str, eCPublicKeyParameters, eCParameterSpec);
                return new KeyPair(bCDSTU4145PublicKey, new BCDSTU4145PrivateKey(str, eCPrivateKeyParameters, bCDSTU4145PublicKey, eCParameterSpec));
            } else if (algorithmParameterSpec == null) {
                return new KeyPair(new BCDSTU4145PublicKey(str, eCPublicKeyParameters), new BCDSTU4145PrivateKey(str, eCPrivateKeyParameters));
            } else {
                java.security.spec.ECParameterSpec eCParameterSpec2 = (java.security.spec.ECParameterSpec) algorithmParameterSpec;
                BCDSTU4145PublicKey bCDSTU4145PublicKey2 = new BCDSTU4145PublicKey(str, eCPublicKeyParameters, eCParameterSpec2);
                return new KeyPair(bCDSTU4145PublicKey2, new BCDSTU4145PrivateKey(str, eCPrivateKeyParameters, bCDSTU4145PublicKey2, eCParameterSpec2));
            }
        } else {
            throw new IllegalStateException("DSTU Key Pair Generator not initialised");
        }
    }

    public final void initialize(int i, SecureRandom secureRandom) {
        AlgorithmParameterSpec algorithmParameterSpec = this.f6378a;
        if (algorithmParameterSpec != null) {
            try {
                initialize((AlgorithmParameterSpec) (ECGenParameterSpec) algorithmParameterSpec, secureRandom);
            } catch (InvalidAlgorithmParameterException unused) {
                throw new InvalidParameterException("key size not configurable.");
            }
        } else {
            throw new InvalidParameterException("unknown key size.");
        }
    }

    public final void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        String str;
        boolean z = algorithmParameterSpec instanceof ECParameterSpec;
        DSTU4145KeyPairGenerator dSTU4145KeyPairGenerator = this.f6379a;
        if (z) {
            ECParameterSpec eCParameterSpec = (ECParameterSpec) algorithmParameterSpec;
            this.f6378a = algorithmParameterSpec;
            dSTU4145KeyPairGenerator.b(new ECKeyGenerationParameters(secureRandom, new ECDomainParameters(eCParameterSpec.f6602a, eCParameterSpec.f6603a, eCParameterSpec.a, eCParameterSpec.b)));
            this.f6380a = true;
        } else if (algorithmParameterSpec instanceof java.security.spec.ECParameterSpec) {
            java.security.spec.ECParameterSpec eCParameterSpec2 = (java.security.spec.ECParameterSpec) algorithmParameterSpec;
            this.f6378a = algorithmParameterSpec;
            ECCurve b = EC5Util.b(eCParameterSpec2.getCurve());
            dSTU4145KeyPairGenerator.b(new ECKeyGenerationParameters(secureRandom, new ECDomainParameters(b, EC5Util.d(b, eCParameterSpec2.getGenerator()), eCParameterSpec2.getOrder(), BigInteger.valueOf((long) eCParameterSpec2.getCofactor()))));
            this.f6380a = true;
        } else {
            boolean z2 = algorithmParameterSpec instanceof ECGenParameterSpec;
            if (z2 || (algorithmParameterSpec instanceof ECNamedCurveGenParameterSpec)) {
                if (z2) {
                    str = ((ECGenParameterSpec) algorithmParameterSpec).getName();
                } else {
                    ((ECNamedCurveGenParameterSpec) algorithmParameterSpec).getClass();
                    str = null;
                }
                String str2 = str;
                ECDomainParameters a2 = DSTU4145NamedCurves.a(new ASN1ObjectIdentifier(str2));
                if (a2 != null) {
                    ECNamedCurveSpec eCNamedCurveSpec = new ECNamedCurveSpec(str2, a2.a, a2.f6230a, a2.g, a2.h, a2.a());
                    this.f6378a = eCNamedCurveSpec;
                    ECCurve b2 = EC5Util.b(eCNamedCurveSpec.getCurve());
                    dSTU4145KeyPairGenerator.b(new ECKeyGenerationParameters(secureRandom, new ECDomainParameters(b2, EC5Util.d(b2, eCNamedCurveSpec.getGenerator()), eCNamedCurveSpec.getOrder(), BigInteger.valueOf((long) eCNamedCurveSpec.getCofactor()))));
                    this.f6380a = true;
                    return;
                }
                throw new InvalidAlgorithmParameterException("unknown curve name: ".concat(str2));
            }
            if (algorithmParameterSpec == null) {
                ProviderConfiguration providerConfiguration = BouncyCastleProvider.f6565a;
                if (providerConfiguration.d() != null) {
                    ECParameterSpec d = providerConfiguration.d();
                    this.f6378a = algorithmParameterSpec;
                    dSTU4145KeyPairGenerator.b(new ECKeyGenerationParameters(secureRandom, new ECDomainParameters(d.f6602a, d.f6603a, d.a, d.b)));
                    this.f6380a = true;
                    return;
                }
            }
            if (algorithmParameterSpec == null && BouncyCastleProvider.f6565a.d() == null) {
                throw new InvalidAlgorithmParameterException("null parameter passed but no implicitCA set");
            }
            throw new InvalidAlgorithmParameterException("parameter object not a ECParameterSpec: ".concat(algorithmParameterSpec.getClass().getName()));
        }
    }
}
