package org.spongycastle.jcajce.provider.asymmetric.ec;

import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.digests.SM3Digest;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.signers.SM2Signer;
import org.spongycastle.jcajce.provider.asymmetric.util.DSABase;
import org.spongycastle.jcajce.provider.asymmetric.util.DSAEncoder;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.util.Arrays;

public class GMSignatureSpi extends DSABase {

    public static class StdDSAEncoder implements DSAEncoder {
        private StdDSAEncoder() {
        }

        public /* synthetic */ StdDSAEncoder(int i) {
            this();
        }

        public final byte[] a(BigInteger bigInteger, BigInteger bigInteger2) throws IOException {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            aSN1EncodableVector.a(new ASN1Integer(bigInteger));
            aSN1EncodableVector.a(new ASN1Integer(bigInteger2));
            return new DERSequence(aSN1EncodableVector).f("DER");
        }

        public final BigInteger[] b(byte[] bArr) throws IOException {
            ASN1Sequence aSN1Sequence = (ASN1Sequence) ASN1Primitive.k(bArr);
            if (aSN1Sequence.size() != 2) {
                throw new IOException("malformed signature");
            } else if (Arrays.a(bArr, aSN1Sequence.f("DER"))) {
                return new BigInteger[]{ASN1Integer.q(aSN1Sequence.s(0)).t(), ASN1Integer.q(aSN1Sequence.s(1)).t()};
            } else {
                throw new IOException("malformed signature");
            }
        }
    }

    public static class sm3WithSM2 extends GMSignatureSpi {
        public sm3WithSM2() {
            super(new SM3Digest(), new SM2Signer(), new StdDSAEncoder(0));
        }
    }

    public GMSignatureSpi(SM3Digest sM3Digest, SM2Signer sM2Signer, DSAEncoder dSAEncoder) {
        super(sM3Digest, sM2Signer, dSAEncoder);
    }

    public final void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        AsymmetricKeyParameter b = ECUtil.b(privateKey);
        this.f6480a.reset();
        SecureRandom secureRandom = this.appRandom;
        DSA dsa = this.a;
        if (secureRandom != null) {
            dsa.a(true, new ParametersWithRandom(b, secureRandom));
        } else {
            dsa.a(true, b);
        }
    }

    public final void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        AsymmetricKeyParameter a = ECUtils.a(publicKey);
        this.f6480a.reset();
        this.a.a(false, a);
    }
}
