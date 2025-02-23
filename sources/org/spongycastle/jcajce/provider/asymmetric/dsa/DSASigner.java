package org.spongycastle.jcajce.provider.asymmetric.dsa;

import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.NullDigest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA224Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.params.DSAParameters;
import org.spongycastle.crypto.params.DSAPrivateKeyParameters;
import org.spongycastle.crypto.params.DSAPublicKeyParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.signers.HMacDSAKCalculator;
import org.spongycastle.crypto.util.DigestFactory;
import org.spongycastle.util.Arrays;

public class DSASigner extends SignatureSpi implements PKCSObjectIdentifiers, X509ObjectIdentifiers {
    public SecureRandom a;

    /* renamed from: a  reason: collision with other field name */
    public final DSA f6365a;

    /* renamed from: a  reason: collision with other field name */
    public final Digest f6366a;

    public static class detDSA extends DSASigner {
        public detDSA() {
            super(new org.spongycastle.crypto.signers.DSASigner(new HMacDSAKCalculator(new SHA1Digest())), new SHA1Digest());
        }
    }

    public static class detDSA224 extends DSASigner {
        public detDSA224() {
            super(new org.spongycastle.crypto.signers.DSASigner(new HMacDSAKCalculator(new SHA224Digest())), new SHA224Digest());
        }
    }

    public static class detDSA256 extends DSASigner {
        public detDSA256() {
            super(new org.spongycastle.crypto.signers.DSASigner(new HMacDSAKCalculator(new SHA256Digest())), new SHA256Digest());
        }
    }

    public static class detDSA384 extends DSASigner {
        public detDSA384() {
            super(new org.spongycastle.crypto.signers.DSASigner(new HMacDSAKCalculator(new SHA384Digest())), new SHA384Digest());
        }
    }

    public static class detDSA512 extends DSASigner {
        public detDSA512() {
            super(new org.spongycastle.crypto.signers.DSASigner(new HMacDSAKCalculator(new SHA512Digest())), new SHA512Digest());
        }
    }

    public static class detDSASha3_224 extends DSASigner {
        public detDSASha3_224() {
            super(new org.spongycastle.crypto.signers.DSASigner(new HMacDSAKCalculator(DigestFactory.a())), DigestFactory.a());
        }
    }

    public static class detDSASha3_256 extends DSASigner {
        public detDSASha3_256() {
            super(new org.spongycastle.crypto.signers.DSASigner(new HMacDSAKCalculator(DigestFactory.b())), DigestFactory.b());
        }
    }

    public static class detDSASha3_384 extends DSASigner {
        public detDSASha3_384() {
            super(new org.spongycastle.crypto.signers.DSASigner(new HMacDSAKCalculator(DigestFactory.c())), DigestFactory.c());
        }
    }

    public static class detDSASha3_512 extends DSASigner {
        public detDSASha3_512() {
            super(new org.spongycastle.crypto.signers.DSASigner(new HMacDSAKCalculator(DigestFactory.d())), DigestFactory.d());
        }
    }

    public static class dsa224 extends DSASigner {
        public dsa224() {
            super(new org.spongycastle.crypto.signers.DSASigner(), new SHA224Digest());
        }
    }

    public static class dsa256 extends DSASigner {
        public dsa256() {
            super(new org.spongycastle.crypto.signers.DSASigner(), new SHA256Digest());
        }
    }

    public static class dsa384 extends DSASigner {
        public dsa384() {
            super(new org.spongycastle.crypto.signers.DSASigner(), new SHA384Digest());
        }
    }

    public static class dsa512 extends DSASigner {
        public dsa512() {
            super(new org.spongycastle.crypto.signers.DSASigner(), new SHA512Digest());
        }
    }

    public static class dsaSha3_224 extends DSASigner {
        public dsaSha3_224() {
            super(new org.spongycastle.crypto.signers.DSASigner(), DigestFactory.a());
        }
    }

    public static class dsaSha3_256 extends DSASigner {
        public dsaSha3_256() {
            super(new org.spongycastle.crypto.signers.DSASigner(), DigestFactory.b());
        }
    }

    public static class dsaSha3_384 extends DSASigner {
        public dsaSha3_384() {
            super(new org.spongycastle.crypto.signers.DSASigner(), DigestFactory.c());
        }
    }

    public static class dsaSha3_512 extends DSASigner {
        public dsaSha3_512() {
            super(new org.spongycastle.crypto.signers.DSASigner(), DigestFactory.d());
        }
    }

    public static class noneDSA extends DSASigner {
        public noneDSA() {
            super(new org.spongycastle.crypto.signers.DSASigner(), new NullDigest());
        }
    }

    public static class stdDSA extends DSASigner {
        public stdDSA() {
            super(new org.spongycastle.crypto.signers.DSASigner(), new SHA1Digest());
        }
    }

    public DSASigner(org.spongycastle.crypto.signers.DSASigner dSASigner, Digest digest) {
        this.f6366a = digest;
        this.f6365a = dSASigner;
    }

    public static BigInteger[] a(byte[] bArr) throws IOException {
        ASN1Sequence aSN1Sequence = (ASN1Sequence) ASN1Primitive.k(bArr);
        if (aSN1Sequence.size() != 2) {
            throw new IOException("malformed signature");
        } else if (Arrays.a(bArr, aSN1Sequence.f("DER"))) {
            return new BigInteger[]{((ASN1Integer) aSN1Sequence.s(0)).t(), ((ASN1Integer) aSN1Sequence.s(1)).t()};
        } else {
            throw new IOException("malformed signature");
        }
    }

    public final Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public final void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        this.a = secureRandom;
        engineInitSign(privateKey);
    }

    public final void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        DSAPublicKeyParameters dSAPublicKeyParameters;
        ASN1ObjectIdentifier[] aSN1ObjectIdentifierArr = DSAUtil.a;
        if (publicKey instanceof BCDSAPublicKey) {
            dSAPublicKeyParameters = ((BCDSAPublicKey) publicKey).f6364a;
        } else if (publicKey instanceof DSAPublicKey) {
            dSAPublicKeyParameters = new BCDSAPublicKey((DSAPublicKey) publicKey).f6364a;
        } else {
            try {
                dSAPublicKeyParameters = new BCDSAPublicKey(SubjectPublicKeyInfo.g(publicKey.getEncoded())).f6364a;
            } catch (Exception unused) {
                throw new InvalidKeyException("can't identify DSA public key: ".concat(publicKey.getClass().getName()));
            }
        }
        this.f6366a.reset();
        this.f6365a.a(false, dSAPublicKeyParameters);
    }

    public final void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public final byte[] engineSign() throws SignatureException {
        Digest digest = this.f6366a;
        byte[] bArr = new byte[digest.f()];
        digest.c(0, bArr);
        try {
            BigInteger[] b = this.f6365a.b(bArr);
            return new DERSequence((ASN1Encodable[]) new ASN1Integer[]{new ASN1Integer(b[0]), new ASN1Integer(b[1])}).f("DER");
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    public final void engineUpdate(byte b) throws SignatureException {
        this.f6366a.d(b);
    }

    public final boolean engineVerify(byte[] bArr) throws SignatureException {
        Digest digest = this.f6366a;
        byte[] bArr2 = new byte[digest.f()];
        digest.c(0, bArr2);
        try {
            BigInteger[] a2 = a(bArr);
            return this.f6365a.c(a2[0], a2[1], bArr2);
        } catch (Exception unused) {
            throw new SignatureException("error decoding signature bytes.");
        }
    }

    public final void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public final void engineUpdate(byte[] bArr, int i, int i2) throws SignatureException {
        this.f6366a.update(bArr, i, i2);
    }

    public final void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        ASN1ObjectIdentifier[] aSN1ObjectIdentifierArr = DSAUtil.a;
        if (privateKey instanceof DSAPrivateKey) {
            DSAPrivateKey dSAPrivateKey = (DSAPrivateKey) privateKey;
            CipherParameters dSAPrivateKeyParameters = new DSAPrivateKeyParameters(dSAPrivateKey.getX(), new DSAParameters(dSAPrivateKey.getParams().getP(), dSAPrivateKey.getParams().getQ(), dSAPrivateKey.getParams().getG()));
            SecureRandom secureRandom = this.a;
            if (secureRandom != null) {
                dSAPrivateKeyParameters = new ParametersWithRandom(dSAPrivateKeyParameters, secureRandom);
            }
            this.f6366a.reset();
            this.f6365a.a(true, dSAPrivateKeyParameters);
            return;
        }
        throw new InvalidKeyException("can't identify DSA private key.");
    }
}
