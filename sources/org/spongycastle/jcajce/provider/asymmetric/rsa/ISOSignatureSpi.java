package org.spongycastle.jcajce.provider.asymmetric.rsa;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.MD5Digest;
import org.spongycastle.crypto.digests.RIPEMD160Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA224Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.digests.SHA512tDigest;
import org.spongycastle.crypto.digests.WhirlpoolDigest;
import org.spongycastle.crypto.engines.RSABlindedEngine;
import org.spongycastle.crypto.signers.ISO9796d2Signer;

public class ISOSignatureSpi extends SignatureSpi {
    public final ISO9796d2Signer a;

    public static class MD5WithRSAEncryption extends ISOSignatureSpi {
        public MD5WithRSAEncryption() {
            super(new RSABlindedEngine(), new MD5Digest());
        }
    }

    public static class RIPEMD160WithRSAEncryption extends ISOSignatureSpi {
        public RIPEMD160WithRSAEncryption() {
            super(new RSABlindedEngine(), new RIPEMD160Digest());
        }
    }

    public static class SHA1WithRSAEncryption extends ISOSignatureSpi {
        public SHA1WithRSAEncryption() {
            super(new RSABlindedEngine(), new SHA1Digest());
        }
    }

    public static class SHA224WithRSAEncryption extends ISOSignatureSpi {
        public SHA224WithRSAEncryption() {
            super(new RSABlindedEngine(), new SHA224Digest());
        }
    }

    public static class SHA256WithRSAEncryption extends ISOSignatureSpi {
        public SHA256WithRSAEncryption() {
            super(new RSABlindedEngine(), new SHA256Digest());
        }
    }

    public static class SHA384WithRSAEncryption extends ISOSignatureSpi {
        public SHA384WithRSAEncryption() {
            super(new RSABlindedEngine(), new SHA384Digest());
        }
    }

    public static class SHA512WithRSAEncryption extends ISOSignatureSpi {
        public SHA512WithRSAEncryption() {
            super(new RSABlindedEngine(), new SHA512Digest());
        }
    }

    public static class SHA512_224WithRSAEncryption extends ISOSignatureSpi {
        public SHA512_224WithRSAEncryption() {
            super(new RSABlindedEngine(), new SHA512tDigest(224));
        }
    }

    public static class SHA512_256WithRSAEncryption extends ISOSignatureSpi {
        public SHA512_256WithRSAEncryption() {
            super(new RSABlindedEngine(), new SHA512tDigest(256));
        }
    }

    public static class WhirlpoolWithRSAEncryption extends ISOSignatureSpi {
        public WhirlpoolWithRSAEncryption() {
            super(new RSABlindedEngine(), new WhirlpoolDigest());
        }
    }

    public ISOSignatureSpi(RSABlindedEngine rSABlindedEngine, Digest digest) {
        this.a = new ISO9796d2Signer(rSABlindedEngine, digest);
    }

    public final Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public final void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        this.a.c(true, RSAUtil.a((RSAPrivateKey) privateKey));
    }

    public final void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        this.a.c(false, RSAUtil.b((RSAPublicKey) publicKey));
    }

    public final void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public final byte[] engineSign() throws SignatureException {
        try {
            return this.a.b();
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    public final void engineUpdate(byte[] bArr, int i, int i2) throws SignatureException {
        this.a.e(bArr, i, i2);
    }

    public final boolean engineVerify(byte[] bArr) throws SignatureException {
        return this.a.f(bArr);
    }

    public final void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public final void engineUpdate(byte b) throws SignatureException {
        ISO9796d2Signer iSO9796d2Signer = this.a;
        iSO9796d2Signer.f6281a.d(b);
        int i = iSO9796d2Signer.c;
        byte[] bArr = iSO9796d2Signer.f6283b;
        if (i < bArr.length) {
            bArr[i] = b;
        }
        iSO9796d2Signer.c = i + 1;
    }
}
