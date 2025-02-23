package org.spongycastle.jcajce.provider.asymmetric.ecgost;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.digests.GOST3411Digest;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.signers.ECGOST3410Signer;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.GOST3410Util;
import org.spongycastle.jce.interfaces.ECKey;
import org.spongycastle.jce.interfaces.ECPublicKey;
import org.spongycastle.jce.interfaces.GOST3410Key;
import org.spongycastle.jce.provider.BouncyCastleProvider;

public class SignatureSpi extends java.security.SignatureSpi implements PKCSObjectIdentifiers, X509ObjectIdentifiers {
    public final GOST3411Digest a = new GOST3411Digest();

    /* renamed from: a  reason: collision with other field name */
    public final ECGOST3410Signer f6421a = new ECGOST3410Signer();

    public final Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public final void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        CipherParameters cipherParameters;
        if (privateKey instanceof ECKey) {
            cipherParameters = ECUtil.b(privateKey);
        } else {
            cipherParameters = GOST3410Util.a(privateKey);
        }
        this.a.reset();
        SecureRandom secureRandom = this.appRandom;
        ECGOST3410Signer eCGOST3410Signer = this.f6421a;
        if (secureRandom != null) {
            eCGOST3410Signer.a(true, new ParametersWithRandom(cipherParameters, secureRandom));
        } else {
            eCGOST3410Signer.a(true, cipherParameters);
        }
    }

    public final void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        CipherParameters cipherParameters;
        if (publicKey instanceof ECPublicKey) {
            if (publicKey instanceof BCECGOST3410PublicKey) {
                cipherParameters = ((BCECGOST3410PublicKey) publicKey).f6415a;
            } else {
                cipherParameters = ECUtil.c(publicKey);
            }
        } else if (publicKey instanceof GOST3410Key) {
            cipherParameters = GOST3410Util.b(publicKey);
        } else {
            try {
                cipherParameters = ECUtil.c(BouncyCastleProvider.g(SubjectPublicKeyInfo.g(publicKey.getEncoded())));
            } catch (Exception unused) {
                throw new InvalidKeyException("can't recognise key type in DSA based signer");
            }
        }
        this.a.reset();
        this.f6421a.a(false, cipherParameters);
    }

    public final void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public final byte[] engineSign() throws SignatureException {
        GOST3411Digest gOST3411Digest = this.a;
        gOST3411Digest.getClass();
        byte[] bArr = new byte[32];
        gOST3411Digest.c(0, bArr);
        try {
            byte[] bArr2 = new byte[64];
            BigInteger[] b = this.f6421a.b(bArr);
            byte[] byteArray = b[0].toByteArray();
            byte[] byteArray2 = b[1].toByteArray();
            if (byteArray2[0] != 0) {
                System.arraycopy(byteArray2, 0, bArr2, 32 - byteArray2.length, byteArray2.length);
            } else {
                System.arraycopy(byteArray2, 1, bArr2, 32 - (byteArray2.length - 1), byteArray2.length - 1);
            }
            if (byteArray[0] != 0) {
                System.arraycopy(byteArray, 0, bArr2, 64 - byteArray.length, byteArray.length);
            } else {
                System.arraycopy(byteArray, 1, bArr2, 64 - (byteArray.length - 1), byteArray.length - 1);
            }
            return bArr2;
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    public final void engineUpdate(byte b) throws SignatureException {
        this.a.d(b);
    }

    public final boolean engineVerify(byte[] bArr) throws SignatureException {
        GOST3411Digest gOST3411Digest = this.a;
        gOST3411Digest.getClass();
        byte[] bArr2 = new byte[32];
        gOST3411Digest.c(0, bArr2);
        try {
            byte[] bArr3 = new byte[32];
            byte[] bArr4 = new byte[32];
            System.arraycopy(bArr, 0, bArr4, 0, 32);
            System.arraycopy(bArr, 32, bArr3, 0, 32);
            BigInteger bigInteger = new BigInteger(1, bArr4);
            return this.f6421a.c(new BigInteger[]{new BigInteger(1, bArr3), bigInteger}[0], bigInteger, bArr2);
        } catch (Exception unused) {
            throw new SignatureException("error decoding signature bytes.");
        }
    }

    public final void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public final void engineUpdate(byte[] bArr, int i, int i2) throws SignatureException {
        this.a.update(bArr, i, i2);
    }
}
