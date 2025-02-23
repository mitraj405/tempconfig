package org.spongycastle.jcajce.provider.asymmetric.util;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Hashtable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.anssi.ANSSINamedCurves;
import org.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.spongycastle.asn1.gm.GMNamedCurves;
import org.spongycastle.asn1.nist.NISTNamedCurves;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.sec.SECNamedCurves;
import org.spongycastle.asn1.teletrust.TeleTrusTNamedCurves;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x9.X962NamedCurves;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.asn1.x9.X9ECParametersHolder;
import org.spongycastle.crypto.ec.CustomNamedCurves;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECNamedDomainParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jce.interfaces.ECPrivateKey;
import org.spongycastle.jce.interfaces.ECPublicKey;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECNamedCurveParameterSpec;
import org.spongycastle.jce.spec.ECParameterSpec;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Fingerprint;
import org.spongycastle.util.Strings;

public class ECUtil {
    public static String a(ECPoint eCPoint, ECParameterSpec eCParameterSpec) {
        ECCurve eCCurve = eCParameterSpec.f6602a;
        if (eCCurve != null) {
            return new Fingerprint(Arrays.k(eCPoint.h(false), eCCurve.f6610a.e(), eCCurve.f6614b.e(), eCParameterSpec.f6603a.h(false))).toString();
        }
        return new Fingerprint(eCPoint.h(false)).toString();
    }

    public static AsymmetricKeyParameter b(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof ECPrivateKey) {
            ECPrivateKey eCPrivateKey = (ECPrivateKey) privateKey;
            ECParameterSpec a = eCPrivateKey.a();
            if (a == null) {
                a = BouncyCastleProvider.f6565a.d();
            }
            return new ECPrivateKeyParameters(eCPrivateKey.v(), new ECDomainParameters(a.f6602a, a.f6603a, a.a, a.b, a.f6604a));
        } else if (privateKey instanceof java.security.interfaces.ECPrivateKey) {
            java.security.interfaces.ECPrivateKey eCPrivateKey2 = (java.security.interfaces.ECPrivateKey) privateKey;
            ECParameterSpec f = EC5Util.f(eCPrivateKey2.getParams(), false);
            return new ECPrivateKeyParameters(eCPrivateKey2.getS(), new ECDomainParameters(f.f6602a, f.f6603a, f.a, f.b, f.f6604a));
        } else {
            try {
                byte[] encoded = privateKey.getEncoded();
                if (encoded != null) {
                    PrivateKey f2 = BouncyCastleProvider.f(PrivateKeyInfo.g(encoded));
                    if (f2 instanceof java.security.interfaces.ECPrivateKey) {
                        return b(f2);
                    }
                    throw new InvalidKeyException("can't identify EC private key.");
                }
                throw new InvalidKeyException("no encoding for EC private key");
            } catch (Exception e) {
                throw new InvalidKeyException(C1058d.x(e, new StringBuilder("cannot identify EC private key: ")));
            }
        }
    }

    public static AsymmetricKeyParameter c(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof ECPublicKey) {
            ECPublicKey eCPublicKey = (ECPublicKey) publicKey;
            ECParameterSpec a = eCPublicKey.a();
            return new ECPublicKeyParameters(eCPublicKey.w(), new ECDomainParameters(a.f6602a, a.f6603a, a.a, a.b, a.f6604a));
        } else if (publicKey instanceof java.security.interfaces.ECPublicKey) {
            java.security.interfaces.ECPublicKey eCPublicKey2 = (java.security.interfaces.ECPublicKey) publicKey;
            ECParameterSpec f = EC5Util.f(eCPublicKey2.getParams(), false);
            return new ECPublicKeyParameters(EC5Util.c(eCPublicKey2.getParams(), eCPublicKey2.getW()), new ECDomainParameters(f.f6602a, f.f6603a, f.a, f.b, f.f6604a));
        } else {
            try {
                byte[] encoded = publicKey.getEncoded();
                if (encoded != null) {
                    PublicKey g = BouncyCastleProvider.g(SubjectPublicKeyInfo.g(encoded));
                    if (g instanceof java.security.interfaces.ECPublicKey) {
                        return c(g);
                    }
                    throw new InvalidKeyException("cannot identify EC public key.");
                }
                throw new InvalidKeyException("no encoding for EC public key");
            } catch (Exception e) {
                throw new InvalidKeyException(C1058d.x(e, new StringBuilder("cannot identify EC public key: ")));
            }
        }
    }

    public static String d(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String str = (String) X962NamedCurves.c.get(aSN1ObjectIdentifier);
        if (str != null) {
            return str;
        }
        String str2 = (String) SECNamedCurves.c.get(aSN1ObjectIdentifier);
        if (str2 == null) {
            str2 = (String) NISTNamedCurves.b.get(aSN1ObjectIdentifier);
        }
        if (str2 == null) {
            str2 = (String) TeleTrusTNamedCurves.c.get(aSN1ObjectIdentifier);
        }
        if (str2 == null) {
            str2 = ECGOST3410NamedCurves.b(aSN1ObjectIdentifier);
        }
        if (str2 == null) {
            str2 = (String) ANSSINamedCurves.c.get(aSN1ObjectIdentifier);
        }
        if (str2 == null) {
            return (String) GMNamedCurves.c.get(aSN1ObjectIdentifier);
        }
        return str2;
    }

    public static ECDomainParameters e(ProviderConfiguration providerConfiguration, ECParameterSpec eCParameterSpec) {
        if (eCParameterSpec instanceof ECNamedCurveParameterSpec) {
            ECNamedCurveParameterSpec eCNamedCurveParameterSpec = (ECNamedCurveParameterSpec) eCParameterSpec;
            h(eCNamedCurveParameterSpec.a);
            return new ECNamedDomainParameters(eCNamedCurveParameterSpec.f6602a, eCNamedCurveParameterSpec.f6603a, eCNamedCurveParameterSpec.a, eCNamedCurveParameterSpec.b, eCNamedCurveParameterSpec.f6604a);
        } else if (eCParameterSpec != null) {
            return new ECDomainParameters(eCParameterSpec.f6602a, eCParameterSpec.f6603a, eCParameterSpec.a, eCParameterSpec.b, eCParameterSpec.f6604a);
        } else {
            ECParameterSpec d = providerConfiguration.d();
            return new ECDomainParameters(d.f6602a, d.f6603a, d.a, d.b, d.f6604a);
        }
    }

    public static X9ECParameters f(String str) {
        X9ECParameters x9ECParameters;
        X9ECParameters d = CustomNamedCurves.d(str);
        if (d != null) {
            return d;
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) X962NamedCurves.a.get(Strings.e(str));
        if (aSN1ObjectIdentifier != null) {
            x9ECParameters = X962NamedCurves.b(aSN1ObjectIdentifier);
        } else {
            x9ECParameters = null;
        }
        if (x9ECParameters == null) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = (ASN1ObjectIdentifier) SECNamedCurves.a.get(Strings.e(str));
            if (aSN1ObjectIdentifier2 == null) {
                x9ECParameters = null;
            } else {
                x9ECParameters = SECNamedCurves.d(aSN1ObjectIdentifier2);
            }
        }
        if (x9ECParameters == null) {
            x9ECParameters = NISTNamedCurves.b(str);
        }
        if (x9ECParameters == null) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = (ASN1ObjectIdentifier) TeleTrusTNamedCurves.a.get(Strings.e(str));
            if (aSN1ObjectIdentifier3 != null) {
                x9ECParameters = TeleTrusTNamedCurves.b(aSN1ObjectIdentifier3);
            } else {
                x9ECParameters = null;
            }
        }
        if (x9ECParameters == null) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = (ASN1ObjectIdentifier) ANSSINamedCurves.a.get(Strings.e(str));
            if (aSN1ObjectIdentifier4 == null) {
                x9ECParameters = null;
            } else {
                x9ECParameters = ANSSINamedCurves.a(aSN1ObjectIdentifier4);
            }
        }
        if (x9ECParameters != null) {
            return x9ECParameters;
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = (ASN1ObjectIdentifier) GMNamedCurves.a.get(Strings.e(str));
        if (aSN1ObjectIdentifier5 == null) {
            return null;
        }
        return GMNamedCurves.b(aSN1ObjectIdentifier5);
    }

    public static X9ECParameters g(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        X9ECParameters x9ECParameters;
        X9ECParametersHolder x9ECParametersHolder = (X9ECParametersHolder) CustomNamedCurves.c.get(aSN1ObjectIdentifier);
        if (x9ECParametersHolder == null) {
            x9ECParameters = null;
        } else {
            x9ECParameters = x9ECParametersHolder.b();
        }
        if (x9ECParameters != null) {
            return x9ECParameters;
        }
        X9ECParameters b = X962NamedCurves.b(aSN1ObjectIdentifier);
        if (b == null) {
            b = SECNamedCurves.d(aSN1ObjectIdentifier);
        }
        if (b == null) {
            Hashtable hashtable = NISTNamedCurves.a;
            b = SECNamedCurves.d(aSN1ObjectIdentifier);
        }
        if (b == null) {
            b = TeleTrusTNamedCurves.b(aSN1ObjectIdentifier);
        }
        if (b == null) {
            b = ANSSINamedCurves.a(aSN1ObjectIdentifier);
        }
        if (b == null) {
            return GMNamedCurves.b(aSN1ObjectIdentifier);
        }
        return b;
    }

    public static ASN1ObjectIdentifier h(String str) {
        if (str.indexOf(32) > 0) {
            str = str.substring(str.indexOf(32) + 1);
        }
        try {
            if (str.charAt(0) < '0' || str.charAt(0) > '2') {
                return j(str);
            }
            return new ASN1ObjectIdentifier(str);
        } catch (IllegalArgumentException unused) {
            return j(str);
        }
    }

    public static int i(ProviderConfiguration providerConfiguration, BigInteger bigInteger, BigInteger bigInteger2) {
        if (bigInteger != null) {
            return bigInteger.bitLength();
        }
        ECParameterSpec d = providerConfiguration.d();
        if (d == null) {
            return bigInteger2.bitLength();
        }
        return d.a.bitLength();
    }

    public static ASN1ObjectIdentifier j(String str) {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) X962NamedCurves.a.get(Strings.e(str));
        if (aSN1ObjectIdentifier != null) {
            return aSN1ObjectIdentifier;
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = (ASN1ObjectIdentifier) SECNamedCurves.a.get(Strings.e(str));
        if (aSN1ObjectIdentifier2 == null) {
            aSN1ObjectIdentifier2 = (ASN1ObjectIdentifier) NISTNamedCurves.a.get(Strings.g(str));
        }
        if (aSN1ObjectIdentifier2 == null) {
            aSN1ObjectIdentifier2 = (ASN1ObjectIdentifier) TeleTrusTNamedCurves.a.get(Strings.e(str));
        }
        if (aSN1ObjectIdentifier2 == null) {
            aSN1ObjectIdentifier2 = (ASN1ObjectIdentifier) ECGOST3410NamedCurves.a.get(str);
        }
        if (aSN1ObjectIdentifier2 == null) {
            aSN1ObjectIdentifier2 = (ASN1ObjectIdentifier) ANSSINamedCurves.a.get(Strings.e(str));
        }
        if (aSN1ObjectIdentifier2 == null) {
            return (ASN1ObjectIdentifier) GMNamedCurves.a.get(Strings.e(str));
        }
        return aSN1ObjectIdentifier2;
    }

    public static String k(String str, BigInteger bigInteger, ECParameterSpec eCParameterSpec) {
        StringBuffer stringBuffer = new StringBuffer();
        String str2 = Strings.a;
        ECPoint o = eCParameterSpec.f6603a.m(bigInteger).o();
        stringBuffer.append(str);
        stringBuffer.append(" Private Key [");
        stringBuffer.append(a(o, eCParameterSpec));
        stringBuffer.append("]");
        stringBuffer.append(str2);
        stringBuffer.append("            X: ");
        o.b();
        stringBuffer.append(o.f6621a.t().toString(16));
        stringBuffer.append(str2);
        stringBuffer.append("            Y: ");
        stringBuffer.append(o.e().t().toString(16));
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    public static String l(String str, ECPoint eCPoint, ECParameterSpec eCParameterSpec) {
        StringBuffer stringBuffer = new StringBuffer();
        String str2 = Strings.a;
        stringBuffer.append(str);
        stringBuffer.append(" Public Key [");
        stringBuffer.append(a(eCPoint, eCParameterSpec));
        stringBuffer.append("]");
        stringBuffer.append(str2);
        stringBuffer.append("            X: ");
        eCPoint.b();
        stringBuffer.append(eCPoint.f6621a.t().toString(16));
        stringBuffer.append(str2);
        stringBuffer.append("            Y: ");
        stringBuffer.append(eCPoint.e().t().toString(16));
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }
}
