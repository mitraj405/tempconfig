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
import org.spongycastle.crypto.digests.RIPEMD128Digest;
import org.spongycastle.crypto.digests.RIPEMD160Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA224Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.digests.SHA512tDigest;
import org.spongycastle.crypto.digests.WhirlpoolDigest;
import org.spongycastle.crypto.engines.RSABlindedEngine;
import org.spongycastle.crypto.signers.X931Signer;

public class X931SignatureSpi extends SignatureSpi {
    public final X931Signer a;

    public static class RIPEMD128WithRSAEncryption extends X931SignatureSpi {
        public RIPEMD128WithRSAEncryption() {
            super(new RSABlindedEngine(), new RIPEMD128Digest());
        }
    }

    public static class RIPEMD160WithRSAEncryption extends X931SignatureSpi {
        public RIPEMD160WithRSAEncryption() {
            super(new RSABlindedEngine(), new RIPEMD160Digest());
        }
    }

    public static class SHA1WithRSAEncryption extends X931SignatureSpi {
        public SHA1WithRSAEncryption() {
            super(new RSABlindedEngine(), new SHA1Digest());
        }
    }

    public static class SHA224WithRSAEncryption extends X931SignatureSpi {
        public SHA224WithRSAEncryption() {
            super(new RSABlindedEngine(), new SHA224Digest());
        }
    }

    public static class SHA256WithRSAEncryption extends X931SignatureSpi {
        public SHA256WithRSAEncryption() {
            super(new RSABlindedEngine(), new SHA256Digest());
        }
    }

    public static class SHA384WithRSAEncryption extends X931SignatureSpi {
        public SHA384WithRSAEncryption() {
            super(new RSABlindedEngine(), new SHA384Digest());
        }
    }

    public static class SHA512WithRSAEncryption extends X931SignatureSpi {
        public SHA512WithRSAEncryption() {
            super(new RSABlindedEngine(), new SHA512Digest());
        }
    }

    public static class SHA512_224WithRSAEncryption extends X931SignatureSpi {
        public SHA512_224WithRSAEncryption() {
            super(new RSABlindedEngine(), new SHA512tDigest(224));
        }
    }

    public static class SHA512_256WithRSAEncryption extends X931SignatureSpi {
        public SHA512_256WithRSAEncryption() {
            super(new RSABlindedEngine(), new SHA512tDigest(256));
        }
    }

    public static class WhirlpoolWithRSAEncryption extends X931SignatureSpi {
        public WhirlpoolWithRSAEncryption() {
            super(new RSABlindedEngine(), new WhirlpoolDigest());
        }
    }

    public X931SignatureSpi(RSABlindedEngine rSABlindedEngine, Digest digest) {
        this.a = new X931Signer(rSABlindedEngine, digest);
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
        this.a.d(bArr, i, i2);
    }

    public final boolean engineVerify(byte[] bArr) throws SignatureException {
        return this.a.e(bArr);
    }

    public final void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public final void engineUpdate(byte b) throws SignatureException {
        this.a.f6300a.d(b);
    }
}
