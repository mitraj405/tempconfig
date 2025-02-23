package org.spongycastle.jcajce.provider.asymmetric.ec;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECParameterSpec;
import org.spongycastle.jce.spec.ECPrivateKeySpec;
import org.spongycastle.jce.spec.ECPublicKeySpec;

public class KeyFactorySpi extends BaseKeyFactorySpi {
    public final String a;

    /* renamed from: a  reason: collision with other field name */
    public final ProviderConfiguration f6402a;

    public static class EC extends KeyFactorySpi {
        public EC() {
            super("EC", BouncyCastleProvider.f6565a);
        }
    }

    public static class ECDH extends KeyFactorySpi {
        public ECDH() {
            super("ECDH", BouncyCastleProvider.f6565a);
        }
    }

    public static class ECDHC extends KeyFactorySpi {
        public ECDHC() {
            super("ECDHC", BouncyCastleProvider.f6565a);
        }
    }

    public static class ECDSA extends KeyFactorySpi {
        public ECDSA() {
            super("ECDSA", BouncyCastleProvider.f6565a);
        }
    }

    public static class ECGOST3410 extends KeyFactorySpi {
        public ECGOST3410() {
            super("ECGOST3410", BouncyCastleProvider.f6565a);
        }
    }

    public static class ECGOST3410_2012 extends KeyFactorySpi {
        public ECGOST3410_2012() {
            super("ECGOST3410-2012", BouncyCastleProvider.f6565a);
        }
    }

    public static class ECMQV extends KeyFactorySpi {
        public ECMQV() {
            super("ECMQV", BouncyCastleProvider.f6565a);
        }
    }

    public KeyFactorySpi(String str, ProviderConfiguration providerConfiguration) {
        this.a = str;
        this.f6402a = providerConfiguration;
    }

    public final PrivateKey a(PrivateKeyInfo privateKeyInfo) throws IOException {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = privateKeyInfo.f5702a.Z0;
        if (aSN1ObjectIdentifier.equals(X9ObjectIdentifiers.q0)) {
            return new BCECPrivateKey(this.a, privateKeyInfo, this.f6402a);
        }
        throw new IOException("algorithm identifier " + aSN1ObjectIdentifier + " in key not recognised");
    }

    public final PublicKey b(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = subjectPublicKeyInfo.f5753a.Z0;
        if (aSN1ObjectIdentifier.equals(X9ObjectIdentifiers.q0)) {
            return new BCECPublicKey(this.a, subjectPublicKeyInfo, this.f6402a);
        }
        throw new IOException("algorithm identifier " + aSN1ObjectIdentifier + " in key not recognised");
    }

    public final PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        boolean z = keySpec instanceof ECPrivateKeySpec;
        ProviderConfiguration providerConfiguration = this.f6402a;
        String str = this.a;
        if (z) {
            return new BCECPrivateKey(str, (ECPrivateKeySpec) keySpec, providerConfiguration);
        }
        if (keySpec instanceof java.security.spec.ECPrivateKeySpec) {
            return new BCECPrivateKey(str, (java.security.spec.ECPrivateKeySpec) keySpec, providerConfiguration);
        }
        return super.engineGeneratePrivate(keySpec);
    }

    public final PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        try {
            boolean z = keySpec instanceof ECPublicKeySpec;
            ProviderConfiguration providerConfiguration = this.f6402a;
            String str = this.a;
            if (z) {
                return new BCECPublicKey(str, (ECPublicKeySpec) keySpec, providerConfiguration);
            }
            if (keySpec instanceof java.security.spec.ECPublicKeySpec) {
                return new BCECPublicKey(str, (java.security.spec.ECPublicKeySpec) keySpec, providerConfiguration);
            }
            return super.engineGeneratePublic(keySpec);
        } catch (Exception e) {
            throw new InvalidKeySpecException(C1058d.M(e, new StringBuilder("invalid KeySpec: ")), e);
        }
    }

    public final KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if (cls.isAssignableFrom(java.security.spec.ECPublicKeySpec.class) && (key instanceof ECPublicKey)) {
            ECPublicKey eCPublicKey = (ECPublicKey) key;
            if (eCPublicKey.getParams() != null) {
                return new java.security.spec.ECPublicKeySpec(eCPublicKey.getW(), eCPublicKey.getParams());
            }
            ECParameterSpec d = BouncyCastleProvider.f6565a.d();
            return new java.security.spec.ECPublicKeySpec(eCPublicKey.getW(), EC5Util.e(EC5Util.a(d.f6602a), d));
        } else if (cls.isAssignableFrom(java.security.spec.ECPrivateKeySpec.class) && (key instanceof ECPrivateKey)) {
            ECPrivateKey eCPrivateKey = (ECPrivateKey) key;
            if (eCPrivateKey.getParams() != null) {
                return new java.security.spec.ECPrivateKeySpec(eCPrivateKey.getS(), eCPrivateKey.getParams());
            }
            ECParameterSpec d2 = BouncyCastleProvider.f6565a.d();
            return new java.security.spec.ECPrivateKeySpec(eCPrivateKey.getS(), EC5Util.e(EC5Util.a(d2.f6602a), d2));
        } else if (cls.isAssignableFrom(ECPublicKeySpec.class) && (key instanceof ECPublicKey)) {
            ECPublicKey eCPublicKey2 = (ECPublicKey) key;
            if (eCPublicKey2.getParams() != null) {
                return new ECPublicKeySpec(EC5Util.c(eCPublicKey2.getParams(), eCPublicKey2.getW()), EC5Util.f(eCPublicKey2.getParams(), false));
            }
            return new ECPublicKeySpec(EC5Util.c(eCPublicKey2.getParams(), eCPublicKey2.getW()), BouncyCastleProvider.f6565a.d());
        } else if (!cls.isAssignableFrom(ECPrivateKeySpec.class) || !(key instanceof ECPrivateKey)) {
            return super.engineGetKeySpec(key, cls);
        } else {
            ECPrivateKey eCPrivateKey2 = (ECPrivateKey) key;
            if (eCPrivateKey2.getParams() != null) {
                return new ECPrivateKeySpec(eCPrivateKey2.getS(), EC5Util.f(eCPrivateKey2.getParams(), false));
            }
            return new ECPrivateKeySpec(eCPrivateKey2.getS(), BouncyCastleProvider.f6565a.d());
        }
    }

    public final Key engineTranslateKey(Key key) throws InvalidKeyException {
        boolean z = key instanceof ECPublicKey;
        ProviderConfiguration providerConfiguration = this.f6402a;
        if (z) {
            return new BCECPublicKey((ECPublicKey) key, providerConfiguration);
        }
        if (key instanceof ECPrivateKey) {
            return new BCECPrivateKey((ECPrivateKey) key, providerConfiguration);
        }
        throw new InvalidKeyException("key type unknown");
    }
}
