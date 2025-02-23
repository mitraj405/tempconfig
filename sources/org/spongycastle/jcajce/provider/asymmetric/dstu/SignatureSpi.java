package org.spongycastle.jcajce.provider.asymmetric.dstu;

import com.google.common.base.Ascii;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.ua.DSTU4145Params;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.digests.GOST3411Digest;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.signers.DSTU4145Signer;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jce.interfaces.ECKey;

public class SignatureSpi extends java.security.SignatureSpi implements PKCSObjectIdentifiers, X509ObjectIdentifiers {
    public static final byte[] a = {10, 9, Ascii.CR, 6, Ascii.SO, Ascii.VT, 4, 5, Ascii.SI, 1, 3, Ascii.FF, 7, 0, 8, 2, 8, 0, Ascii.FF, 4, 9, 6, 7, Ascii.VT, 2, 3, 1, Ascii.SI, 5, Ascii.SO, 10, Ascii.CR, Ascii.SI, 6, 5, 8, Ascii.SO, Ascii.VT, 10, 4, Ascii.FF, 0, 3, 7, 2, 9, 1, Ascii.CR, 3, 8, Ascii.CR, 9, 6, Ascii.VT, Ascii.SI, 0, 2, 5, Ascii.FF, 10, 4, Ascii.SO, 1, 7, Ascii.SI, 8, Ascii.SO, 9, 7, 2, 0, Ascii.CR, Ascii.FF, 6, 1, 5, Ascii.VT, 4, 3, 10, 2, 8, 9, 7, 5, Ascii.SI, 0, Ascii.VT, Ascii.FF, 1, Ascii.CR, Ascii.SO, 10, 3, 6, 4, 3, 8, Ascii.VT, 5, 6, 4, Ascii.SO, 10, 2, Ascii.FF, 1, 7, 9, Ascii.SI, Ascii.CR, 0, 1, 2, 3, Ascii.SO, 6, Ascii.CR, Ascii.VT, 8, Ascii.SI, 10, Ascii.FF, 5, 7, 9, 0, 4};

    /* renamed from: a  reason: collision with other field name */
    public GOST3411Digest f6381a;

    /* renamed from: a  reason: collision with other field name */
    public final DSTU4145Signer f6382a = new DSTU4145Signer();

    public final Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public final void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        AsymmetricKeyParameter asymmetricKeyParameter;
        if (privateKey instanceof ECKey) {
            asymmetricKeyParameter = ECUtil.b(privateKey);
        } else {
            asymmetricKeyParameter = null;
        }
        this.f6381a = new GOST3411Digest(a);
        SecureRandom secureRandom = this.appRandom;
        DSTU4145Signer dSTU4145Signer = this.f6382a;
        if (secureRandom != null) {
            dSTU4145Signer.a(true, new ParametersWithRandom(asymmetricKeyParameter, secureRandom));
        } else {
            dSTU4145Signer.a(true, asymmetricKeyParameter);
        }
    }

    public final void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        CipherParameters cipherParameters;
        byte[] bArr;
        if (publicKey instanceof BCDSTU4145PublicKey) {
            cipherParameters = ((BCDSTU4145PublicKey) publicKey).f6377a;
        } else {
            cipherParameters = ECUtil.c(publicKey);
        }
        DSTU4145Params dSTU4145Params = ((BCDSTU4145PublicKey) publicKey).f6376a;
        if (dSTU4145Params != null) {
            bArr = dSTU4145Params.f5718a;
        } else {
            bArr = DSTU4145Params.b;
        }
        byte[] bArr2 = new byte[128];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            bArr2[i2] = (byte) ((bArr[i] >> 4) & 15);
            bArr2[i2 + 1] = (byte) (bArr[i] & Ascii.SI);
        }
        this.f6381a = new GOST3411Digest(bArr2);
        this.f6382a.a(false, cipherParameters);
    }

    public final void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public byte[] engineSign() throws SignatureException {
        int i;
        this.f6381a.getClass();
        byte[] bArr = new byte[32];
        this.f6381a.c(0, bArr);
        try {
            BigInteger[] b = this.f6382a.b(bArr);
            byte[] byteArray = b[0].toByteArray();
            byte[] byteArray2 = b[1].toByteArray();
            if (byteArray.length > byteArray2.length) {
                i = byteArray.length;
            } else {
                i = byteArray2.length;
            }
            int i2 = i * 2;
            byte[] bArr2 = new byte[i2];
            System.arraycopy(byteArray2, 0, bArr2, (i2 / 2) - byteArray2.length, byteArray2.length);
            System.arraycopy(byteArray, 0, bArr2, i2 - byteArray.length, byteArray.length);
            return new DEROctetString(bArr2).e();
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    public final void engineUpdate(byte b) throws SignatureException {
        this.f6381a.d(b);
    }

    public boolean engineVerify(byte[] bArr) throws SignatureException {
        this.f6381a.getClass();
        byte[] bArr2 = new byte[32];
        this.f6381a.c(0, bArr2);
        try {
            byte[] s = ((ASN1OctetString) ASN1Primitive.k(bArr)).s();
            byte[] bArr3 = new byte[(s.length / 2)];
            byte[] bArr4 = new byte[(s.length / 2)];
            System.arraycopy(s, 0, bArr4, 0, s.length / 2);
            System.arraycopy(s, s.length / 2, bArr3, 0, s.length / 2);
            BigInteger bigInteger = new BigInteger(1, bArr4);
            return this.f6382a.c(new BigInteger[]{new BigInteger(1, bArr3), bigInteger}[0], bigInteger, bArr2);
        } catch (Exception unused) {
            throw new SignatureException("error decoding signature bytes.");
        }
    }

    public final void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public final void engineUpdate(byte[] bArr, int i, int i2) throws SignatureException {
        this.f6381a.update(bArr, i, i2);
    }
}
