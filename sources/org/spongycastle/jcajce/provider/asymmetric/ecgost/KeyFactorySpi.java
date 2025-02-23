package org.spongycastle.jcajce.provider.asymmetric.ecgost;

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
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECParameterSpec;
import org.spongycastle.jce.spec.ECPrivateKeySpec;
import org.spongycastle.jce.spec.ECPublicKeySpec;

public class KeyFactorySpi extends BaseKeyFactorySpi {
    public final PrivateKey a(PrivateKeyInfo privateKeyInfo) throws IOException {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = privateKeyInfo.f5702a.Z0;
        if (aSN1ObjectIdentifier.equals(CryptoProObjectIdentifiers.l)) {
            return new BCECGOST3410PrivateKey(privateKeyInfo);
        }
        if (aSN1ObjectIdentifier.equals(CryptoProObjectIdentifiers.y)) {
            return new BCECGOST3410PrivateKey(privateKeyInfo);
        }
        if (aSN1ObjectIdentifier.equals(CryptoProObjectIdentifiers.x)) {
            return new BCECGOST3410PrivateKey(privateKeyInfo);
        }
        throw new IOException("algorithm identifier " + aSN1ObjectIdentifier + " in key not recognised");
    }

    public final PublicKey b(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = subjectPublicKeyInfo.f5753a.Z0;
        if (aSN1ObjectIdentifier.equals(CryptoProObjectIdentifiers.l)) {
            return new BCECGOST3410PublicKey(subjectPublicKeyInfo);
        }
        if (aSN1ObjectIdentifier.equals(CryptoProObjectIdentifiers.y)) {
            return new BCECGOST3410PublicKey(subjectPublicKeyInfo);
        }
        if (aSN1ObjectIdentifier.equals(CryptoProObjectIdentifiers.x)) {
            return new BCECGOST3410PublicKey(subjectPublicKeyInfo);
        }
        throw new IOException("algorithm identifier " + aSN1ObjectIdentifier + " in key not recognised");
    }

    public final PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof ECPrivateKeySpec) {
            return new BCECGOST3410PrivateKey((ECPrivateKeySpec) keySpec);
        }
        if (keySpec instanceof java.security.spec.ECPrivateKeySpec) {
            return new BCECGOST3410PrivateKey((java.security.spec.ECPrivateKeySpec) keySpec);
        }
        return super.engineGeneratePrivate(keySpec);
    }

    public final PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof ECPublicKeySpec) {
            return new BCECGOST3410PublicKey((ECPublicKeySpec) keySpec, BouncyCastleProvider.f6565a);
        }
        if (keySpec instanceof java.security.spec.ECPublicKeySpec) {
            return new BCECGOST3410PublicKey((java.security.spec.ECPublicKeySpec) keySpec);
        }
        return super.engineGeneratePublic(keySpec);
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
        throw new InvalidKeyException("key type unknown");
    }
}
