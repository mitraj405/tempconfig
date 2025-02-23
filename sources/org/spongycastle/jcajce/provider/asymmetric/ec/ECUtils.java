package org.spongycastle.jcajce.provider.asymmetric.ec;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PublicKey;
import java.security.spec.ECParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.x9.X962Parameters;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jce.spec.ECNamedCurveSpec;
import org.spongycastle.math.ec.ECCurve;

class ECUtils {
    public static AsymmetricKeyParameter a(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof BCECPublicKey) {
            return ((BCECPublicKey) publicKey).f6388a;
        }
        return ECUtil.c(publicKey);
    }

    public static X962Parameters b(ECParameterSpec eCParameterSpec) {
        if (eCParameterSpec instanceof ECNamedCurveSpec) {
            ECNamedCurveSpec eCNamedCurveSpec = (ECNamedCurveSpec) eCParameterSpec;
            ASN1ObjectIdentifier h = ECUtil.h(eCNamedCurveSpec.a);
            if (h == null) {
                h = new ASN1ObjectIdentifier(eCNamedCurveSpec.a);
            }
            return new X962Parameters(h);
        } else if (eCParameterSpec == null) {
            return new X962Parameters(DERNull.a);
        } else {
            ECCurve b = EC5Util.b(eCParameterSpec.getCurve());
            return new X962Parameters(new X9ECParameters(b, EC5Util.d(b, eCParameterSpec.getGenerator()), eCParameterSpec.getOrder(), BigInteger.valueOf((long) eCParameterSpec.getCofactor()), eCParameterSpec.getCurve().getSeed()));
        }
    }

    public static X9ECParameters c(String str) {
        try {
            if (str.charAt(0) >= '0' && str.charAt(0) <= '2') {
                return ECUtil.g(new ASN1ObjectIdentifier(str));
            }
            if (str.indexOf(32) > 0) {
                return ECUtil.f(str.substring(str.indexOf(32) + 1));
            }
            return ECUtil.f(str);
        } catch (IllegalArgumentException unused) {
            return ECUtil.f(str);
        }
    }
}
