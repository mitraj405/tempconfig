package org.spongycastle.jcajce.provider.asymmetric.rsa;

import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.DigestInfo;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.digests.MD2Digest;
import org.spongycastle.crypto.digests.MD4Digest;
import org.spongycastle.crypto.digests.MD5Digest;
import org.spongycastle.crypto.digests.NullDigest;
import org.spongycastle.crypto.digests.RIPEMD128Digest;
import org.spongycastle.crypto.digests.RIPEMD160Digest;
import org.spongycastle.crypto.digests.RIPEMD256Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA224Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.digests.SHA512tDigest;
import org.spongycastle.crypto.encodings.PKCS1Encoding;
import org.spongycastle.crypto.engines.RSABlindedEngine;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.crypto.util.DigestFactory;
import org.spongycastle.util.Arrays;

public class DigestSignatureSpi extends SignatureSpi {
    public final AlgorithmIdentifier a;

    /* renamed from: a  reason: collision with other field name */
    public final AsymmetricBlockCipher f6461a;

    /* renamed from: a  reason: collision with other field name */
    public final Digest f6462a;

    public static class MD2 extends DigestSignatureSpi {
        public MD2() {
            super(PKCSObjectIdentifiers.B, new MD2Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class MD4 extends DigestSignatureSpi {
        public MD4() {
            super(PKCSObjectIdentifiers.C, new MD4Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class MD5 extends DigestSignatureSpi {
        public MD5() {
            super(PKCSObjectIdentifiers.D, new MD5Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class RIPEMD128 extends DigestSignatureSpi {
        public RIPEMD128() {
            super(TeleTrusTObjectIdentifiers.b, new RIPEMD128Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class RIPEMD160 extends DigestSignatureSpi {
        public RIPEMD160() {
            super(TeleTrusTObjectIdentifiers.a, new RIPEMD160Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class RIPEMD256 extends DigestSignatureSpi {
        public RIPEMD256() {
            super(TeleTrusTObjectIdentifiers.c, new RIPEMD256Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class SHA1 extends DigestSignatureSpi {
        public SHA1() {
            super(OIWObjectIdentifiers.f, new SHA1Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class SHA224 extends DigestSignatureSpi {
        public SHA224() {
            super(NISTObjectIdentifiers.d, new SHA224Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class SHA256 extends DigestSignatureSpi {
        public SHA256() {
            super(NISTObjectIdentifiers.a, new SHA256Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class SHA384 extends DigestSignatureSpi {
        public SHA384() {
            super(NISTObjectIdentifiers.b, new SHA384Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class SHA3_224 extends DigestSignatureSpi {
        public SHA3_224() {
            super(NISTObjectIdentifiers.g, DigestFactory.a(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class SHA3_256 extends DigestSignatureSpi {
        public SHA3_256() {
            super(NISTObjectIdentifiers.h, DigestFactory.b(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class SHA3_384 extends DigestSignatureSpi {
        public SHA3_384() {
            super(NISTObjectIdentifiers.i, DigestFactory.c(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class SHA3_512 extends DigestSignatureSpi {
        public SHA3_512() {
            super(NISTObjectIdentifiers.j, DigestFactory.d(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class SHA512 extends DigestSignatureSpi {
        public SHA512() {
            super(NISTObjectIdentifiers.c, new SHA512Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class SHA512_224 extends DigestSignatureSpi {
        public SHA512_224() {
            super(NISTObjectIdentifiers.e, new SHA512tDigest(224), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class SHA512_256 extends DigestSignatureSpi {
        public SHA512_256() {
            super(NISTObjectIdentifiers.f, new SHA512tDigest(256), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class noneRSA extends DigestSignatureSpi {
        public noneRSA() {
            super(new PKCS1Encoding(new RSABlindedEngine()), new NullDigest());
        }
    }

    public DigestSignatureSpi(PKCS1Encoding pKCS1Encoding, NullDigest nullDigest) {
        this.f6462a = nullDigest;
        this.f6461a = pKCS1Encoding;
        this.a = null;
    }

    public final Object engineGetParameter(String str) {
        return null;
    }

    public final AlgorithmParameters engineGetParameters() {
        return null;
    }

    public final void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        String str;
        if (privateKey instanceof RSAPrivateKey) {
            RSAKeyParameters a2 = RSAUtil.a((RSAPrivateKey) privateKey);
            this.f6462a.reset();
            this.f6461a.a(true, a2);
            return;
        }
        StringBuilder sb = new StringBuilder("Supplied key (");
        if (privateKey == null) {
            str = null;
        } else {
            str = privateKey.getClass().getName();
        }
        throw new InvalidKeyException(C0709Uj.j(sb, str, ") is not a RSAPrivateKey instance"));
    }

    public final void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        String str;
        if (publicKey instanceof RSAPublicKey) {
            RSAKeyParameters b = RSAUtil.b((RSAPublicKey) publicKey);
            this.f6462a.reset();
            this.f6461a.a(false, b);
            return;
        }
        StringBuilder sb = new StringBuilder("Supplied key (");
        if (publicKey == null) {
            str = null;
        } else {
            str = publicKey.getClass().getName();
        }
        throw new InvalidKeyException(C0709Uj.j(sb, str, ") is not a RSAPublicKey instance"));
    }

    public final void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public final byte[] engineSign() throws SignatureException {
        Digest digest = this.f6462a;
        byte[] bArr = new byte[digest.f()];
        digest.c(0, bArr);
        try {
            AlgorithmIdentifier algorithmIdentifier = this.a;
            if (algorithmIdentifier != null) {
                bArr = new DigestInfo(algorithmIdentifier, bArr).f("DER");
            }
            return this.f6461a.c(0, bArr, bArr.length);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new SignatureException("key too small for signature type");
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    public final void engineUpdate(byte b) throws SignatureException {
        this.f6462a.d(b);
    }

    public final boolean engineVerify(byte[] bArr) throws SignatureException {
        Digest digest = this.f6462a;
        byte[] bArr2 = new byte[digest.f()];
        digest.c(0, bArr2);
        try {
            byte[] c = this.f6461a.c(0, bArr, bArr.length);
            AlgorithmIdentifier algorithmIdentifier = this.a;
            if (algorithmIdentifier != null) {
                bArr2 = new DigestInfo(algorithmIdentifier, bArr2).f("DER");
            }
            if (c.length == bArr2.length) {
                return Arrays.l(c, bArr2);
            }
            if (c.length == bArr2.length - 2) {
                bArr2[1] = (byte) (bArr2[1] - 2);
                byte b = (byte) (bArr2[3] - 2);
                bArr2[3] = b;
                int i = b + 4;
                int i2 = i + 2;
                byte b2 = 0;
                for (int i3 = 0; i3 < bArr2.length - i2; i3++) {
                    b2 |= c[i + i3] ^ bArr2[i2 + i3];
                }
                for (int i4 = 0; i4 < i; i4++) {
                    b2 |= c[i4] ^ bArr2[i4];
                }
                if (b2 == 0) {
                    return true;
                }
                return false;
            }
            Arrays.l(bArr2, bArr2);
            return false;
        } catch (Exception unused) {
        }
    }

    public final void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public final void engineUpdate(byte[] bArr, int i, int i2) throws SignatureException {
        this.f6462a.update(bArr, i, i2);
    }

    public DigestSignatureSpi(ASN1ObjectIdentifier aSN1ObjectIdentifier, ExtendedDigest extendedDigest, PKCS1Encoding pKCS1Encoding) {
        this.f6462a = extendedDigest;
        this.f6461a = pKCS1Encoding;
        this.a = new AlgorithmIdentifier(aSN1ObjectIdentifier, DERNull.a);
    }
}
