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
import org.spongycastle.pqc.crypto.xmss.XMSSPublicKeyParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSSigner;
import org.spongycastle.pqc.jcajce.interfaces.StateAwareSignature;

public class XMSSSignatureSpi extends Signature implements StateAwareSignature {
    public SecureRandom a;

    /* renamed from: a  reason: collision with other field name */
    public final Digest f6837a;

    /* renamed from: a  reason: collision with other field name */
    public final XMSSSigner f6838a;

    public static class withSha256 extends XMSSSignatureSpi {
        public withSha256() {
            super("SHA256withXMSS", new SHA256Digest(), new XMSSSigner());
        }
    }

    public static class withSha512 extends XMSSSignatureSpi {
        public withSha512() {
            super("SHA512withXMSS", new SHA512Digest(), new XMSSSigner());
        }
    }

    public static class withShake128 extends XMSSSignatureSpi {
        public withShake128() {
            super("SHAKE128withXMSSMT", new SHAKEDigest(128), new XMSSSigner());
        }
    }

    public static class withShake256 extends XMSSSignatureSpi {
        public withShake256() {
            super("SHAKE256withXMSS", new SHAKEDigest(256), new XMSSSigner());
        }
    }

    public XMSSSignatureSpi(String str, ExtendedDigest extendedDigest, XMSSSigner xMSSSigner) {
        super(str);
        this.f6837a = extendedDigest;
        this.f6838a = xMSSSigner;
    }

    public final Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public final void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        this.a = secureRandom;
        engineInitSign(privateKey);
    }

    public final void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof BCXMSSPublicKey) {
            XMSSPublicKeyParameters xMSSPublicKeyParameters = ((BCXMSSPublicKey) publicKey).a;
            this.f6837a.reset();
            this.f6838a.b(false, xMSSPublicKeyParameters);
            return;
        }
        throw new InvalidKeyException("unknown public key passed to XMSS");
    }

    public final void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public final byte[] engineSign() throws SignatureException {
        try {
            return this.f6838a.a(DigestUtil.b(this.f6837a));
        } catch (Exception e) {
            if (e instanceof IllegalStateException) {
                throw new SignatureException(e.getMessage());
            }
            throw new SignatureException(e.toString());
        }
    }

    public final void engineUpdate(byte b) throws SignatureException {
        this.f6837a.d(b);
    }

    public final boolean engineVerify(byte[] bArr) throws SignatureException {
        return this.f6838a.c(DigestUtil.b(this.f6837a), bArr);
    }

    public final void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public final void engineUpdate(byte[] bArr, int i, int i2) throws SignatureException {
        this.f6837a.update(bArr, i, i2);
    }

    public final void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof BCXMSSPrivateKey) {
            BCXMSSPrivateKey bCXMSSPrivateKey = (BCXMSSPrivateKey) privateKey;
            CipherParameters cipherParameters = bCXMSSPrivateKey.a;
            bCXMSSPrivateKey.getClass();
            SecureRandom secureRandom = this.a;
            if (secureRandom != null) {
                cipherParameters = new ParametersWithRandom(cipherParameters, secureRandom);
            }
            this.f6837a.reset();
            this.f6838a.b(true, cipherParameters);
            return;
        }
        throw new InvalidKeyException("unknown private key passed to XMSS");
    }
}
