package org.spongycastle.pqc.jcajce.provider.mceliece;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import org.spongycastle.pqc.asn1.McEliecePrivateKey;
import org.spongycastle.pqc.asn1.McEliecePublicKey;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters;
import org.spongycastle.pqc.crypto.mceliece.McEliecePublicKeyParameters;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
import org.spongycastle.pqc.math.linearalgebra.GF2mField;
import org.spongycastle.pqc.math.linearalgebra.Permutation;
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

public class McElieceKeyFactorySpi extends KeyFactorySpi implements AsymmetricKeyInfoConverter {
    public final PrivateKey a(PrivateKeyInfo privateKeyInfo) throws IOException {
        McEliecePrivateKey mcEliecePrivateKey;
        ASN1Primitive h = privateKeyInfo.h();
        h.getClass();
        if (h instanceof McEliecePrivateKey) {
            mcEliecePrivateKey = (McEliecePrivateKey) h;
        } else {
            mcEliecePrivateKey = new McEliecePrivateKey(ASN1Sequence.q(h));
        }
        int i = mcEliecePrivateKey.c;
        int i2 = mcEliecePrivateKey.d;
        byte[] bArr = mcEliecePrivateKey.a;
        return new BCMcEliecePrivateKey(new McEliecePrivateKeyParameters(i, i2, new GF2mField(bArr), new PolynomialGF2mSmallM(new GF2mField(bArr), mcEliecePrivateKey.b), new Permutation(mcEliecePrivateKey.f6646d), new Permutation(mcEliecePrivateKey.e), new GF2Matrix(mcEliecePrivateKey.f6645c)));
    }

    public final PublicKey b(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        McEliecePublicKey mcEliecePublicKey;
        ASN1Primitive h = subjectPublicKeyInfo.h();
        if (h instanceof McEliecePublicKey) {
            mcEliecePublicKey = (McEliecePublicKey) h;
        } else if (h != null) {
            mcEliecePublicKey = new McEliecePublicKey(ASN1Sequence.q(h));
        } else {
            mcEliecePublicKey = null;
        }
        return new BCMcEliecePublicKey(new McEliecePublicKeyParameters(mcEliecePublicKey.c, mcEliecePublicKey.d, new GF2Matrix(mcEliecePublicKey.a)));
    }

    public final PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        McEliecePrivateKey mcEliecePrivateKey;
        if (keySpec instanceof PKCS8EncodedKeySpec) {
            try {
                PrivateKeyInfo g = PrivateKeyInfo.g(ASN1Primitive.k(((PKCS8EncodedKeySpec) keySpec).getEncoded()));
                try {
                    if (PQCObjectIdentifiers.f.equals(g.f5702a.Z0)) {
                        ASN1Primitive h = g.h();
                        if (h instanceof McEliecePrivateKey) {
                            mcEliecePrivateKey = (McEliecePrivateKey) h;
                        } else if (h != null) {
                            mcEliecePrivateKey = new McEliecePrivateKey(ASN1Sequence.q(h));
                        } else {
                            mcEliecePrivateKey = null;
                        }
                        int i = mcEliecePrivateKey.c;
                        byte[] bArr = mcEliecePrivateKey.a;
                        return new BCMcEliecePrivateKey(new McEliecePrivateKeyParameters(i, mcEliecePrivateKey.d, new GF2mField(bArr), new PolynomialGF2mSmallM(new GF2mField(bArr), mcEliecePrivateKey.b), new Permutation(mcEliecePrivateKey.f6646d), new Permutation(mcEliecePrivateKey.e), new GF2Matrix(mcEliecePrivateKey.f6645c)));
                    }
                    throw new InvalidKeySpecException("Unable to recognise OID in McEliece private key");
                } catch (IOException unused) {
                    throw new InvalidKeySpecException("Unable to decode PKCS8EncodedKeySpec.");
                }
            } catch (IOException e) {
                throw new InvalidKeySpecException("Unable to decode PKCS8EncodedKeySpec: " + e);
            }
        } else {
            throw new InvalidKeySpecException("Unsupported key specification: " + keySpec.getClass() + ".");
        }
    }

    public final PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        McEliecePublicKey mcEliecePublicKey;
        if (keySpec instanceof X509EncodedKeySpec) {
            try {
                SubjectPublicKeyInfo g = SubjectPublicKeyInfo.g(ASN1Primitive.k(((X509EncodedKeySpec) keySpec).getEncoded()));
                try {
                    if (PQCObjectIdentifiers.f.equals(g.f5753a.Z0)) {
                        ASN1Primitive h = g.h();
                        if (h instanceof McEliecePublicKey) {
                            mcEliecePublicKey = (McEliecePublicKey) h;
                        } else if (h != null) {
                            mcEliecePublicKey = new McEliecePublicKey(ASN1Sequence.q(h));
                        } else {
                            mcEliecePublicKey = null;
                        }
                        return new BCMcEliecePublicKey(new McEliecePublicKeyParameters(mcEliecePublicKey.c, mcEliecePublicKey.d, new GF2Matrix(mcEliecePublicKey.a)));
                    }
                    throw new InvalidKeySpecException("Unable to recognise OID in McEliece public key");
                } catch (IOException e) {
                    throw new InvalidKeySpecException(C0709Uj.g(e, new StringBuilder("Unable to decode X509EncodedKeySpec: ")));
                }
            } catch (IOException e2) {
                throw new InvalidKeySpecException(e2.toString());
            }
        } else {
            throw new InvalidKeySpecException("Unsupported key specification: " + keySpec.getClass() + ".");
        }
    }

    public final KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        return null;
    }

    public final Key engineTranslateKey(Key key) throws InvalidKeyException {
        return null;
    }
}
