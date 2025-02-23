package org.spongycastle.jcajce.provider.asymmetric.ec;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.util.Hashtable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.x9.ECNamedCurveTable;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.generators.ECKeyPairGenerator;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECKeyGenerationParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECNamedCurveGenParameterSpec;
import org.spongycastle.jce.spec.ECNamedCurveSpec;
import org.spongycastle.math.ec.ECCurve;

public abstract class KeyPairGeneratorSpi extends KeyPairGenerator {

    public static class ECDH extends EC {
        public ECDH() {
            super("ECDH", BouncyCastleProvider.f6565a);
        }
    }

    public static class ECDHC extends EC {
        public ECDHC() {
            super("ECDHC", BouncyCastleProvider.f6565a);
        }
    }

    public static class ECDSA extends EC {
        public ECDSA() {
            super("ECDSA", BouncyCastleProvider.f6565a);
        }
    }

    public static class ECMQV extends EC {
        public ECMQV() {
            super("ECMQV", BouncyCastleProvider.f6565a);
        }
    }

    public KeyPairGeneratorSpi(String str) {
        super(str);
    }

    public static class EC extends KeyPairGeneratorSpi {
        public static final Hashtable a;

        /* renamed from: a  reason: collision with other field name */
        public int f6403a = 239;

        /* renamed from: a  reason: collision with other field name */
        public final String f6404a;

        /* renamed from: a  reason: collision with other field name */
        public AlgorithmParameterSpec f6405a = null;

        /* renamed from: a  reason: collision with other field name */
        public final ECKeyPairGenerator f6406a = new ECKeyPairGenerator();

        /* renamed from: a  reason: collision with other field name */
        public ECKeyGenerationParameters f6407a;

        /* renamed from: a  reason: collision with other field name */
        public final ProviderConfiguration f6408a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f6409a;

        static {
            Hashtable hashtable = new Hashtable();
            a = hashtable;
            hashtable.put(192, new ECGenParameterSpec("prime192v1"));
            hashtable.put(239, new ECGenParameterSpec("prime239v1"));
            hashtable.put(256, new ECGenParameterSpec("prime256v1"));
            hashtable.put(224, new ECGenParameterSpec("P-224"));
            hashtable.put(384, new ECGenParameterSpec("P-384"));
            hashtable.put(521, new ECGenParameterSpec("P-521"));
        }

        public EC() {
            super("EC");
            new SecureRandom();
            this.f6409a = false;
            this.f6404a = "EC";
            this.f6408a = BouncyCastleProvider.f6565a;
        }

        public static ECKeyGenerationParameters a(ECParameterSpec eCParameterSpec, SecureRandom secureRandom) {
            ECCurve b = EC5Util.b(eCParameterSpec.getCurve());
            return new ECKeyGenerationParameters(secureRandom, new ECDomainParameters(b, EC5Util.d(b, eCParameterSpec.getGenerator()), eCParameterSpec.getOrder(), BigInteger.valueOf((long) eCParameterSpec.getCofactor())));
        }

        public final void b(String str, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            X9ECParameters c = ECUtils.c(str);
            if (c == null) {
                try {
                    c = ECNamedCurveTable.c(new ASN1ObjectIdentifier(str));
                    if (c == null) {
                        c = (X9ECParameters) this.f6408a.c().get(new ASN1ObjectIdentifier(str));
                        if (c == null) {
                            throw new InvalidAlgorithmParameterException("unknown curve OID: ".concat(str));
                        }
                    }
                } catch (IllegalArgumentException unused) {
                    throw new InvalidAlgorithmParameterException(C0709Uj.i("unknown curve name: ", str));
                }
            }
            ECNamedCurveSpec eCNamedCurveSpec = new ECNamedCurveSpec(str, c.f5787a, c.g(), c.a, c.b, (byte[]) null);
            this.f6405a = eCNamedCurveSpec;
            this.f6407a = a(eCNamedCurveSpec, secureRandom);
        }

        public final KeyPair generateKeyPair() {
            if (!this.f6409a) {
                initialize(this.f6403a, new SecureRandom());
            }
            AsymmetricCipherKeyPair a2 = this.f6406a.a();
            ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) a2.a;
            ECPrivateKeyParameters eCPrivateKeyParameters = (ECPrivateKeyParameters) a2.b;
            AlgorithmParameterSpec algorithmParameterSpec = this.f6405a;
            boolean z = algorithmParameterSpec instanceof org.spongycastle.jce.spec.ECParameterSpec;
            ProviderConfiguration providerConfiguration = this.f6408a;
            String str = this.f6404a;
            if (z) {
                org.spongycastle.jce.spec.ECParameterSpec eCParameterSpec = (org.spongycastle.jce.spec.ECParameterSpec) algorithmParameterSpec;
                BCECPublicKey bCECPublicKey = new BCECPublicKey(str, eCPublicKeyParameters, eCParameterSpec, providerConfiguration);
                return new KeyPair(bCECPublicKey, new BCECPrivateKey(this.f6404a, eCPrivateKeyParameters, bCECPublicKey, eCParameterSpec, this.f6408a));
            } else if (algorithmParameterSpec == null) {
                return new KeyPair(new BCECPublicKey(str, eCPublicKeyParameters, providerConfiguration), new BCECPrivateKey(str, eCPrivateKeyParameters, providerConfiguration));
            } else {
                ECParameterSpec eCParameterSpec2 = (ECParameterSpec) algorithmParameterSpec;
                BCECPublicKey bCECPublicKey2 = new BCECPublicKey(str, eCPublicKeyParameters, eCParameterSpec2, providerConfiguration);
                return new KeyPair(bCECPublicKey2, new BCECPrivateKey(this.f6404a, eCPrivateKeyParameters, bCECPublicKey2, eCParameterSpec2, this.f6408a));
            }
        }

        public final void initialize(int i, SecureRandom secureRandom) {
            this.f6403a = i;
            ECGenParameterSpec eCGenParameterSpec = (ECGenParameterSpec) a.get(Integer.valueOf(i));
            if (eCGenParameterSpec != null) {
                try {
                    initialize((AlgorithmParameterSpec) eCGenParameterSpec, secureRandom);
                } catch (InvalidAlgorithmParameterException unused) {
                    throw new InvalidParameterException("key size not configurable.");
                }
            } else {
                throw new InvalidParameterException("unknown key size.");
            }
        }

        public final void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            if (algorithmParameterSpec == null) {
                org.spongycastle.jce.spec.ECParameterSpec d = this.f6408a.d();
                if (d != null) {
                    this.f6405a = null;
                    BigInteger bigInteger = d.b;
                    this.f6407a = new ECKeyGenerationParameters(secureRandom, new ECDomainParameters(d.f6602a, d.f6603a, d.a, bigInteger));
                } else {
                    throw new InvalidAlgorithmParameterException("null parameter passed but no implicitCA set");
                }
            } else if (algorithmParameterSpec instanceof org.spongycastle.jce.spec.ECParameterSpec) {
                this.f6405a = algorithmParameterSpec;
                org.spongycastle.jce.spec.ECParameterSpec eCParameterSpec = (org.spongycastle.jce.spec.ECParameterSpec) algorithmParameterSpec;
                BigInteger bigInteger2 = eCParameterSpec.b;
                this.f6407a = new ECKeyGenerationParameters(secureRandom, new ECDomainParameters(eCParameterSpec.f6602a, eCParameterSpec.f6603a, eCParameterSpec.a, bigInteger2));
            } else if (algorithmParameterSpec instanceof ECParameterSpec) {
                this.f6405a = algorithmParameterSpec;
                this.f6407a = a((ECParameterSpec) algorithmParameterSpec, secureRandom);
            } else if (algorithmParameterSpec instanceof ECGenParameterSpec) {
                b(((ECGenParameterSpec) algorithmParameterSpec).getName(), secureRandom);
            } else if (algorithmParameterSpec instanceof ECNamedCurveGenParameterSpec) {
                ECNamedCurveGenParameterSpec eCNamedCurveGenParameterSpec = (ECNamedCurveGenParameterSpec) algorithmParameterSpec;
                b((String) null, secureRandom);
            } else {
                throw new InvalidAlgorithmParameterException("parameter object not a ECParameterSpec");
            }
            this.f6406a.b(this.f6407a);
            this.f6409a = true;
        }

        public EC(String str, ProviderConfiguration providerConfiguration) {
            super(str);
            new SecureRandom();
            this.f6409a = false;
            this.f6404a = str;
            this.f6408a = providerConfiguration;
        }
    }
}
