package org.spongycastle.pqc.jcajce.provider.sphincs;

import com.google.android.gms.ads.AdRequest;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.digests.SHA3Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.digests.SHA512tDigest;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.pqc.crypto.sphincs.SPHINCS256Signer;
import org.spongycastle.pqc.crypto.sphincs.SPHINCSPrivateKeyParameters;
import org.spongycastle.pqc.crypto.sphincs.SPHINCSPublicKeyParameters;
import org.spongycastle.util.Arrays;

public class SignatureSpi extends java.security.SignatureSpi {
    public SecureRandom a;

    /* renamed from: a  reason: collision with other field name */
    public final Digest f6825a;

    /* renamed from: a  reason: collision with other field name */
    public final SPHINCS256Signer f6826a;

    public static class withSha3_512 extends SignatureSpi {
        public withSha3_512() {
            super(new SHA3Digest((int) AdRequest.MAX_CONTENT_URL_LENGTH), new SPHINCS256Signer(new SHA3Digest(256), new SHA3Digest((int) AdRequest.MAX_CONTENT_URL_LENGTH)));
        }
    }

    public static class withSha512 extends SignatureSpi {
        public withSha512() {
            super(new SHA512Digest(), new SPHINCS256Signer(new SHA512tDigest(256), new SHA512Digest()));
        }
    }

    public SignatureSpi(ExtendedDigest extendedDigest, SPHINCS256Signer sPHINCS256Signer) {
        this.f6825a = extendedDigest;
        this.f6826a = sPHINCS256Signer;
    }

    public final Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public final void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        this.a = secureRandom;
        engineInitSign(privateKey);
    }

    public final void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof BCSphincs256PublicKey) {
            SPHINCSPublicKeyParameters sPHINCSPublicKeyParameters = ((BCSphincs256PublicKey) publicKey).a;
            this.f6825a.reset();
            SPHINCS256Signer sPHINCS256Signer = this.f6826a;
            sPHINCS256Signer.getClass();
            sPHINCS256Signer.f6747a = Arrays.c(sPHINCSPublicKeyParameters.a);
            return;
        }
        throw new InvalidKeyException("unknown public key passed to SPHINCS-256");
    }

    public final void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public final byte[] engineSign() throws SignatureException {
        Digest digest = this.f6825a;
        byte[] bArr = new byte[digest.f()];
        digest.c(0, bArr);
        try {
            return this.f6826a.a(bArr);
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    public final void engineUpdate(byte b) throws SignatureException {
        this.f6825a.d(b);
    }

    public final boolean engineVerify(byte[] bArr) throws SignatureException {
        Digest digest = this.f6825a;
        byte[] bArr2 = new byte[digest.f()];
        digest.c(0, bArr2);
        return this.f6826a.b(bArr2, bArr);
    }

    public final void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public final void engineUpdate(byte[] bArr, int i, int i2) throws SignatureException {
        this.f6825a.update(bArr, i, i2);
    }

    public final void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof BCSphincs256PrivateKey) {
            CipherParameters cipherParameters = ((BCSphincs256PrivateKey) privateKey).a;
            SecureRandom secureRandom = this.a;
            if (secureRandom != null) {
                cipherParameters = new ParametersWithRandom(cipherParameters, secureRandom);
            }
            this.f6825a.reset();
            SPHINCS256Signer sPHINCS256Signer = this.f6826a;
            sPHINCS256Signer.getClass();
            sPHINCS256Signer.f6747a = Arrays.c(((SPHINCSPrivateKeyParameters) cipherParameters).a);
            return;
        }
        throw new InvalidKeyException("unknown private key passed to SPHINCS-256");
    }
}
