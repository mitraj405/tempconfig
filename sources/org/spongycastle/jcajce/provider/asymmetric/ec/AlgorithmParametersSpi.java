package org.spongycastle.jcajce.provider.asymmetric.ec;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.EllipticCurve;
import java.security.spec.InvalidParameterSpecException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Vector;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.anssi.ANSSINamedCurves;
import org.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.spongycastle.asn1.gm.GMNamedCurves;
import org.spongycastle.asn1.nist.NISTNamedCurves;
import org.spongycastle.asn1.sec.SECNamedCurves;
import org.spongycastle.asn1.teletrust.TeleTrusTNamedCurves;
import org.spongycastle.asn1.x9.ECNamedCurveTable;
import org.spongycastle.asn1.x9.X962NamedCurves;
import org.spongycastle.asn1.x9.X962Parameters;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECNamedCurveSpec;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.Strings;

public class AlgorithmParametersSpi extends java.security.AlgorithmParametersSpi {
    public String a;

    /* renamed from: a  reason: collision with other field name */
    public ECParameterSpec f6383a;

    public final byte[] engineGetEncoded(String str) throws IOException {
        X962Parameters x962Parameters;
        if (str == null || str.equals("ASN.1")) {
            ECParameterSpec eCParameterSpec = this.f6383a;
            if (eCParameterSpec == null) {
                x962Parameters = new X962Parameters(DERNull.a);
            } else {
                String str2 = this.a;
                if (str2 != null) {
                    x962Parameters = new X962Parameters(ECUtil.h(str2));
                } else {
                    org.spongycastle.jce.spec.ECParameterSpec f = EC5Util.f(eCParameterSpec, false);
                    x962Parameters = new X962Parameters(new X9ECParameters(f.f6602a, f.f6603a, f.a, f.b, f.f6604a));
                }
            }
            return x962Parameters.e();
        }
        throw new IOException(C0709Uj.i("Unknown parameters format in AlgorithmParameters object: ", str));
    }

    public final <T extends AlgorithmParameterSpec> T engineGetParameterSpec(Class<T> cls) throws InvalidParameterSpecException {
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        if (ECParameterSpec.class.isAssignableFrom(cls) || cls == AlgorithmParameterSpec.class) {
            return this.f6383a;
        }
        if (ECGenParameterSpec.class.isAssignableFrom(cls)) {
            String str = this.a;
            if (str != null) {
                ASN1ObjectIdentifier h = ECUtil.h(str);
                if (h != null) {
                    return new ECGenParameterSpec(h.c);
                }
                return new ECGenParameterSpec(this.a);
            }
            org.spongycastle.jce.spec.ECParameterSpec f = EC5Util.f(this.f6383a, false);
            Vector vector = new Vector();
            ECNamedCurveTable.a(vector, X962NamedCurves.a.keys());
            ECNamedCurveTable.a(vector, SECNamedCurves.c.elements());
            ECNamedCurveTable.a(vector, NISTNamedCurves.a.keys());
            ECNamedCurveTable.a(vector, TeleTrusTNamedCurves.a.keys());
            ECNamedCurveTable.a(vector, ANSSINamedCurves.c.elements());
            ECNamedCurveTable.a(vector, GMNamedCurves.c.elements());
            Enumeration elements = vector.elements();
            while (true) {
                if (!elements.hasMoreElements()) {
                    aSN1ObjectIdentifier = null;
                    break;
                }
                String str2 = (String) elements.nextElement();
                X9ECParameters b = ECNamedCurveTable.b(str2);
                if (b.a.equals(f.a) && b.b.equals(f.b) && b.f5787a.i(f.f6602a) && b.g().d(f.f6603a)) {
                    aSN1ObjectIdentifier = (ASN1ObjectIdentifier) X962NamedCurves.a.get(Strings.e(str2));
                    if (aSN1ObjectIdentifier == null) {
                        aSN1ObjectIdentifier = (ASN1ObjectIdentifier) SECNamedCurves.a.get(Strings.e(str2));
                    }
                    if (aSN1ObjectIdentifier == null) {
                        aSN1ObjectIdentifier = (ASN1ObjectIdentifier) NISTNamedCurves.a.get(Strings.g(str2));
                    }
                    if (aSN1ObjectIdentifier == null) {
                        aSN1ObjectIdentifier = (ASN1ObjectIdentifier) TeleTrusTNamedCurves.a.get(Strings.e(str2));
                    }
                    if (aSN1ObjectIdentifier == null) {
                        aSN1ObjectIdentifier = (ASN1ObjectIdentifier) ANSSINamedCurves.a.get(Strings.e(str2));
                    }
                    if (aSN1ObjectIdentifier == null) {
                        aSN1ObjectIdentifier = (ASN1ObjectIdentifier) GMNamedCurves.a.get(Strings.e(str2));
                    }
                }
            }
            if (aSN1ObjectIdentifier != null) {
                return new ECGenParameterSpec(aSN1ObjectIdentifier.c);
            }
        }
        throw new InvalidParameterSpecException("EC AlgorithmParameters cannot convert to ".concat(cls.getName()));
    }

    public final void engineInit(byte[] bArr, String str) throws IOException {
        if (str == null || str.equals("ASN.1")) {
            X962Parameters g = X962Parameters.g(bArr);
            ECCurve h = EC5Util.h(BouncyCastleProvider.f6565a, g);
            ASN1Primitive aSN1Primitive = g.a;
            if (aSN1Primitive instanceof ASN1ObjectIdentifier) {
                ASN1ObjectIdentifier u = ASN1ObjectIdentifier.u(aSN1Primitive);
                String str2 = (String) NISTNamedCurves.b.get(u);
                if (str2 == null) {
                    str2 = (String) SECNamedCurves.c.get(u);
                }
                if (str2 == null) {
                    str2 = (String) TeleTrusTNamedCurves.c.get(u);
                }
                if (str2 == null) {
                    str2 = (String) X962NamedCurves.c.get(u);
                }
                if (str2 == null) {
                    str2 = ECGOST3410NamedCurves.b(u);
                }
                if (str2 == null) {
                    str2 = (String) GMNamedCurves.c.get(u);
                }
                this.a = str2;
                if (str2 == null) {
                    this.a = u.c;
                }
            }
            this.f6383a = EC5Util.g(g, h);
            return;
        }
        throw new IOException(C0709Uj.i("Unknown encoded parameters format in AlgorithmParameters object: ", str));
    }

    public final String engineToString() {
        return "EC AlgorithmParameters ";
    }

    public final byte[] engineGetEncoded() throws IOException {
        return engineGetEncoded("ASN.1");
    }

    public final void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        if (algorithmParameterSpec instanceof ECGenParameterSpec) {
            ECGenParameterSpec eCGenParameterSpec = (ECGenParameterSpec) algorithmParameterSpec;
            X9ECParameters c = ECUtils.c(eCGenParameterSpec.getName());
            if (c != null) {
                this.a = eCGenParameterSpec.getName();
                HashMap hashMap = EC5Util.a;
                EllipticCurve a2 = EC5Util.a(c.f5787a);
                ECPoint g = c.g();
                g.b();
                this.f6383a = new ECParameterSpec(a2, new java.security.spec.ECPoint(g.f6621a.t(), c.g().e().t()), c.a, c.b.intValue());
                return;
            }
            throw new InvalidParameterSpecException("EC curve name not recognized: " + eCGenParameterSpec.getName());
        } else if (algorithmParameterSpec instanceof ECParameterSpec) {
            if (algorithmParameterSpec instanceof ECNamedCurveSpec) {
                this.a = ((ECNamedCurveSpec) algorithmParameterSpec).a;
            } else {
                this.a = null;
            }
            this.f6383a = (ECParameterSpec) algorithmParameterSpec;
        } else {
            throw new InvalidParameterSpecException("AlgorithmParameterSpec class not recognized: ".concat(algorithmParameterSpec.getClass().getName()));
        }
    }

    public final void engineInit(byte[] bArr) throws IOException {
        engineInit(bArr, "ASN.1");
    }
}
