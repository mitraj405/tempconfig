package org.spongycastle.pqc.jcajce.provider.xmss;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.digests.SHAKEDigest;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.pqc.crypto.xmss.XMSSMTPublicKeyParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSMTSigner;
import org.spongycastle.pqc.jcajce.interfaces.StateAwareSignature;

public class XMSSMTSignatureSpi extends Signature implements StateAwareSignature {
    public SecureRandom a;

    /* renamed from: a  reason: collision with other field name */
    public final Digest f6835a;

    /* renamed from: a  reason: collision with other field name */
    public final XMSSMTSigner f6836a;

    public static class withSha256 extends XMSSMTSignatureSpi {
        public withSha256() {
            super("SHA256withXMSSMT", new SHA256Digest(), new XMSSMTSigner());
        }
    }

    public static class withSha512 extends XMSSMTSignatureSpi {
        public withSha512() {
            super("SHA512withXMSSMT", new SHA512Digest(), new XMSSMTSigner());
        }
    }

    public static class withShake128 extends XMSSMTSignatureSpi {
        public withShake128() {
            super("SHAKE128withXMSSMT", new SHAKEDigest(128), new XMSSMTSigner());
        }
    }

    public static class withShake256 extends XMSSMTSignatureSpi {
        public withShake256() {
            super("SHAKE256withXMSSMT", new SHAKEDigest(256), new XMSSMTSigner());
        }
    }

    public XMSSMTSignatureSpi(String str, ExtendedDigest extendedDigest, XMSSMTSigner xMSSMTSigner) {
        super(str);
        this.f6835a = extendedDigest;
        this.f6836a = xMSSMTSigner;
    }

    public final Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public final void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        this.a = secureRandom;
        engineInitSign(privateKey);
    }

    public final void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof BCXMSSMTPublicKey) {
            XMSSMTPublicKeyParameters xMSSMTPublicKeyParameters = ((BCXMSSMTPublicKey) publicKey).a;
            this.f6835a.reset();
            this.f6836a.b(false, xMSSMTPublicKeyParameters);
            return;
        }
        throw new InvalidKeyException("unknown public key passed to XMSSMT");
    }

    public final void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public final byte[] engineSign() throws SignatureException {
        try {
            return this.f6836a.a(DigestUtil.b(this.f6835a));
        } catch (Exception e) {
            if (e instanceof IllegalStateException) {
                throw new SignatureException(e.getMessage());
            }
            throw new SignatureException(e.toString());
        }
    }

    public final void engineUpdate(byte b) throws SignatureException {
        this.f6835a.d(b);
    }

    public final boolean engineVerify(byte[] bArr) throws SignatureException {
        return this.f6836a.c(DigestUtil.b(this.f6835a), bArr);
    }

    public final void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public final void engineUpdate(byte[] bArr, int i, int i2) throws SignatureException {
        this.f6835a.update(bArr, i, i2);
    }

    public final void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof BCXMSSMTPrivateKey) {
            BCXMSSMTPrivateKey bCXMSSMTPrivateKey = (BCXMSSMTPrivateKey) privateKey;
            CipherParameters cipherParameters = bCXMSSMTPrivateKey.a;
            bCXMSSMTPrivateKey.getClass();
            SecureRandom secureRandom = this.a;
            if (secureRandom != null) {
                cipherParameters = new ParametersWithRandom(cipherParameters, secureRandom);
            }
            this.f6835a.reset();
            this.f6836a.b(true, cipherParameters);
            return;
        }
        throw new InvalidKeyException("unknown private key passed to XMSSMT");
    }
}
