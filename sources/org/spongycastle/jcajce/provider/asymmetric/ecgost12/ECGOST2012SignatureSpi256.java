package org.spongycastle.jcajce.provider.asymmetric.ecgost12;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.digests.GOST3411_2012_256Digest;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.signers.ECGOST3410_2012Signer;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jce.interfaces.ECKey;
import org.spongycastle.jce.interfaces.ECPublicKey;
import org.spongycastle.jce.provider.BouncyCastleProvider;

public class ECGOST2012SignatureSpi256 extends SignatureSpi implements PKCSObjectIdentifiers, X509ObjectIdentifiers {
    public final GOST3411_2012_256Digest a = new GOST3411_2012_256Digest();

    /* renamed from: a  reason: collision with other field name */
    public final ECGOST3410_2012Signer f6428a = new ECGOST3410_2012Signer();
    public final int c = 64;
    public final int d = 32;

    public final Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public final void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof ECKey) {
            AsymmetricKeyParameter b = ECUtil.b(privateKey);
            this.a.reset();
            SecureRandom secureRandom = this.appRandom;
            ECGOST3410_2012Signer eCGOST3410_2012Signer = this.f6428a;
            if (secureRandom != null) {
                eCGOST3410_2012Signer.a(true, new ParametersWithRandom(b, secureRandom));
            } else {
                eCGOST3410_2012Signer.a(true, b);
            }
        } else {
            throw new InvalidKeyException("cannot recognise key type in ECGOST-2012-256 signer");
        }
    }

    public final void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        CipherParameters cipherParameters;
        if (!(publicKey instanceof ECPublicKey)) {
            try {
                cipherParameters = ECUtil.c(BouncyCastleProvider.g(SubjectPublicKeyInfo.g(publicKey.getEncoded())));
            } catch (Exception unused) {
                throw new InvalidKeyException("cannot recognise key type in ECGOST-2012-256 signer");
            }
        } else if (publicKey instanceof BCECGOST3410_2012PublicKey) {
            cipherParameters = ((BCECGOST3410_2012PublicKey) publicKey).f6427a;
        } else {
            cipherParameters = ECUtil.c(publicKey);
        }
        this.a.reset();
        this.f6428a.a(false, cipherParameters);
    }

    public final void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public final byte[] engineSign() throws SignatureException {
        int i = this.c;
        GOST3411_2012_256Digest gOST3411_2012_256Digest = this.a;
        gOST3411_2012_256Digest.getClass();
        byte[] bArr = new byte[32];
        gOST3411_2012_256Digest.c(0, bArr);
        try {
            byte[] bArr2 = new byte[i];
            BigInteger[] b = this.f6428a.b(bArr);
            byte[] byteArray = b[0].toByteArray();
            byte[] byteArray2 = b[1].toByteArray();
            byte b2 = byteArray2[0];
            int i2 = this.d;
            if (b2 != 0) {
                System.arraycopy(byteArray2, 0, bArr2, i2 - byteArray2.length, byteArray2.length);
            } else {
                System.arraycopy(byteArray2, 1, bArr2, i2 - (byteArray2.length - 1), byteArray2.length - 1);
            }
            if (byteArray[0] != 0) {
                System.arraycopy(byteArray, 0, bArr2, i - byteArray.length, byteArray.length);
            } else {
                System.arraycopy(byteArray, 1, bArr2, i - (byteArray.length - 1), byteArray.length - 1);
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
        int i = this.d;
        GOST3411_2012_256Digest gOST3411_2012_256Digest = this.a;
        gOST3411_2012_256Digest.getClass();
        byte[] bArr2 = new byte[32];
        gOST3411_2012_256Digest.c(0, bArr2);
        try {
            byte[] bArr3 = new byte[i];
            byte[] bArr4 = new byte[i];
            System.arraycopy(bArr, 0, bArr4, 0, i);
            System.arraycopy(bArr, i, bArr3, 0, i);
            BigInteger bigInteger = new BigInteger(1, bArr4);
            return this.f6428a.c(new BigInteger[]{new BigInteger(1, bArr3), bigInteger}[0], bigInteger, bArr2);
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
