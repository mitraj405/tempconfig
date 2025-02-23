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
import org.spongycastle.pqc.asn1.McElieceCCA2PrivateKey;
import org.spongycastle.pqc.asn1.McElieceCCA2PublicKey;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2PrivateKeyParameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2PublicKeyParameters;
import org.spongycastle.pqc.math.linearalgebra.GF2mField;
import org.spongycastle.pqc.math.linearalgebra.Permutation;
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

public class McElieceCCA2KeyFactorySpi extends KeyFactorySpi implements AsymmetricKeyInfoConverter {
    public final PrivateKey a(PrivateKeyInfo privateKeyInfo) throws IOException {
        McElieceCCA2PrivateKey mcElieceCCA2PrivateKey;
        ASN1Primitive h = privateKeyInfo.h();
        h.getClass();
        if (h instanceof McElieceCCA2PrivateKey) {
            mcElieceCCA2PrivateKey = (McElieceCCA2PrivateKey) h;
        } else {
            mcElieceCCA2PrivateKey = new McElieceCCA2PrivateKey(ASN1Sequence.q(h));
        }
        int i = mcElieceCCA2PrivateKey.c;
        int i2 = mcElieceCCA2PrivateKey.d;
        byte[] bArr = mcElieceCCA2PrivateKey.f6642a;
        return new BCMcElieceCCA2PrivateKey(new McElieceCCA2PrivateKeyParameters(i, i2, new GF2mField(bArr), new PolynomialGF2mSmallM(new GF2mField(bArr), mcElieceCCA2PrivateKey.b), new Permutation(mcElieceCCA2PrivateKey.f6643c), (String) null));
    }

    public final PublicKey b(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        McElieceCCA2PublicKey mcElieceCCA2PublicKey;
        ASN1Primitive h = subjectPublicKeyInfo.h();
        if (h instanceof McElieceCCA2PublicKey) {
            mcElieceCCA2PublicKey = (McElieceCCA2PublicKey) h;
        } else if (h != null) {
            mcElieceCCA2PublicKey = new McElieceCCA2PublicKey(ASN1Sequence.q(h));
        } else {
            mcElieceCCA2PublicKey = null;
        }
        return new BCMcElieceCCA2PublicKey(new McElieceCCA2PublicKeyParameters(mcElieceCCA2PublicKey.c, mcElieceCCA2PublicKey.d, mcElieceCCA2PublicKey.f6644a, Utils.b(mcElieceCCA2PublicKey.a).b()));
    }

    public final PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        McElieceCCA2PrivateKey mcElieceCCA2PrivateKey;
        if (keySpec instanceof PKCS8EncodedKeySpec) {
            try {
                PrivateKeyInfo g = PrivateKeyInfo.g(ASN1Primitive.k(((PKCS8EncodedKeySpec) keySpec).getEncoded()));
                try {
                    if (PQCObjectIdentifiers.g.equals(g.f5702a.Z0)) {
                        ASN1Primitive h = g.h();
                        if (h instanceof McElieceCCA2PrivateKey) {
                            mcElieceCCA2PrivateKey = (McElieceCCA2PrivateKey) h;
                        } else if (h != null) {
                            mcElieceCCA2PrivateKey = new McElieceCCA2PrivateKey(ASN1Sequence.q(h));
                        } else {
                            mcElieceCCA2PrivateKey = null;
                        }
                        int i = mcElieceCCA2PrivateKey.c;
                        byte[] bArr = mcElieceCCA2PrivateKey.f6642a;
                        return new BCMcElieceCCA2PrivateKey(new McElieceCCA2PrivateKeyParameters(i, mcElieceCCA2PrivateKey.d, new GF2mField(bArr), new PolynomialGF2mSmallM(new GF2mField(bArr), mcElieceCCA2PrivateKey.b), new Permutation(mcElieceCCA2PrivateKey.f6643c), Utils.b(mcElieceCCA2PrivateKey.a).b()));
                    }
                    throw new InvalidKeySpecException("Unable to recognise OID in McEliece public key");
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
        McElieceCCA2PublicKey mcElieceCCA2PublicKey;
        if (keySpec instanceof X509EncodedKeySpec) {
            try {
                SubjectPublicKeyInfo g = SubjectPublicKeyInfo.g(ASN1Primitive.k(((X509EncodedKeySpec) keySpec).getEncoded()));
                try {
                    if (PQCObjectIdentifiers.g.equals(g.f5753a.Z0)) {
                        ASN1Primitive h = g.h();
                        if (h instanceof McElieceCCA2PublicKey) {
                            mcElieceCCA2PublicKey = (McElieceCCA2PublicKey) h;
                        } else if (h != null) {
                            mcElieceCCA2PublicKey = new McElieceCCA2PublicKey(ASN1Sequence.q(h));
                        } else {
                            mcElieceCCA2PublicKey = null;
                        }
                        return new BCMcElieceCCA2PublicKey(new McElieceCCA2PublicKeyParameters(mcElieceCCA2PublicKey.c, mcElieceCCA2PublicKey.d, mcElieceCCA2PublicKey.f6644a, Utils.b(mcElieceCCA2PublicKey.a).b()));
                    }
                    throw new InvalidKeySpecException("Unable to recognise OID in McEliece private key");
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
