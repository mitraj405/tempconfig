package org.spongycastle.jcajce.provider.asymmetric.util;

import java.math.BigInteger;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.EllipticCurve;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import org.spongycastle.asn1.ASN1Null;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.x9.ECNamedCurveTable;
import org.spongycastle.asn1.x9.X962Parameters;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.crypto.ec.CustomNamedCurves;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECNamedCurveParameterSpec;
import org.spongycastle.jce.spec.ECNamedCurveSpec;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.field.FiniteField;
import org.spongycastle.math.field.Polynomial;
import org.spongycastle.math.field.PolynomialExtensionField;
import org.spongycastle.util.Arrays;

public class EC5Util {
    public static final HashMap a = new HashMap();

    static {
        Enumeration elements = CustomNamedCurves.f5885a.elements();
        while (elements.hasMoreElements()) {
            String str = (String) elements.nextElement();
            X9ECParameters b = ECNamedCurveTable.b(str);
            if (b != null) {
                a.put(b.f5787a, CustomNamedCurves.d(str).f5787a);
            }
        }
        X9ECParameters d = CustomNamedCurves.d("Curve25519");
        HashMap hashMap = a;
        BigInteger b2 = d.f5787a.f6613a.b();
        ECCurve eCCurve = d.f5787a;
        hashMap.put(new ECCurve.Fp(b2, eCCurve.f6610a.t(), eCCurve.f6614b.t()), eCCurve);
    }

    public static EllipticCurve a(ECCurve eCCurve) {
        boolean z;
        ECField eCField;
        FiniteField finiteField = eCCurve.f6613a;
        int i = 0;
        if (finiteField.a() == 1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            eCField = new ECFieldFp(finiteField.b());
        } else {
            Polynomial c = ((PolynomialExtensionField) finiteField).c();
            int[] a2 = c.a();
            int[] o = Arrays.o(1, a2.length - 1, a2);
            int length = o.length;
            int[] iArr = new int[length];
            while (true) {
                length--;
                if (length < 0) {
                    break;
                }
                iArr[length] = o[i];
                i++;
            }
            eCField = new ECFieldF2m(c.b(), iArr);
        }
        return new EllipticCurve(eCField, eCCurve.f6610a.t(), eCCurve.f6614b.t(), (byte[]) null);
    }

    public static ECCurve b(EllipticCurve ellipticCurve) {
        int i;
        ECField field = ellipticCurve.getField();
        BigInteger a2 = ellipticCurve.getA();
        BigInteger b = ellipticCurve.getB();
        if (field instanceof ECFieldFp) {
            ECCurve.Fp fp = new ECCurve.Fp(((ECFieldFp) field).getP(), a2, b);
            HashMap hashMap = a;
            if (hashMap.containsKey(fp)) {
                return (ECCurve) hashMap.get(fp);
            }
            return fp;
        }
        ECFieldF2m eCFieldF2m = (ECFieldF2m) field;
        int m = eCFieldF2m.getM();
        int[] midTermsOfReductionPolynomial = eCFieldF2m.getMidTermsOfReductionPolynomial();
        int[] iArr = new int[3];
        if (midTermsOfReductionPolynomial.length == 1) {
            iArr[0] = midTermsOfReductionPolynomial[0];
        } else if (midTermsOfReductionPolynomial.length == 3) {
            int i2 = midTermsOfReductionPolynomial[0];
            int i3 = midTermsOfReductionPolynomial[1];
            if (i2 >= i3 || i2 >= (i = midTermsOfReductionPolynomial[2])) {
                int i4 = midTermsOfReductionPolynomial[2];
                if (i3 < i4) {
                    iArr[0] = i3;
                    int i5 = midTermsOfReductionPolynomial[0];
                    if (i5 < i4) {
                        iArr[1] = i5;
                        iArr[2] = i4;
                    } else {
                        iArr[1] = i4;
                        iArr[2] = i5;
                    }
                } else {
                    iArr[0] = i4;
                    int i6 = midTermsOfReductionPolynomial[0];
                    if (i6 < i3) {
                        iArr[1] = i6;
                        iArr[2] = midTermsOfReductionPolynomial[1];
                    } else {
                        iArr[1] = i3;
                        iArr[2] = i6;
                    }
                }
            } else {
                iArr[0] = i2;
                if (i3 < i) {
                    iArr[1] = i3;
                    iArr[2] = i;
                } else {
                    iArr[1] = i;
                    iArr[2] = midTermsOfReductionPolynomial[1];
                }
            }
        } else {
            throw new IllegalArgumentException("Only Trinomials and pentanomials supported");
        }
        return new ECCurve.F2m(m, iArr[0], iArr[1], iArr[2], a2, b);
    }

    public static ECPoint c(ECParameterSpec eCParameterSpec, java.security.spec.ECPoint eCPoint) {
        return d(b(eCParameterSpec.getCurve()), eCPoint);
    }

    public static ECPoint d(ECCurve eCCurve, java.security.spec.ECPoint eCPoint) {
        return eCCurve.d(eCPoint.getAffineX(), eCPoint.getAffineY(), false);
    }

    public static ECParameterSpec e(EllipticCurve ellipticCurve, org.spongycastle.jce.spec.ECParameterSpec eCParameterSpec) {
        if (eCParameterSpec instanceof ECNamedCurveParameterSpec) {
            String str = ((ECNamedCurveParameterSpec) eCParameterSpec).a;
            ECPoint eCPoint = eCParameterSpec.f6603a;
            eCPoint.b();
            return new ECNamedCurveSpec(str, ellipticCurve, new java.security.spec.ECPoint(eCPoint.f6621a.t(), eCParameterSpec.f6603a.e().t()), eCParameterSpec.a, eCParameterSpec.b);
        }
        ECPoint eCPoint2 = eCParameterSpec.f6603a;
        eCPoint2.b();
        return new ECParameterSpec(ellipticCurve, new java.security.spec.ECPoint(eCPoint2.f6621a.t(), eCParameterSpec.f6603a.e().t()), eCParameterSpec.a, eCParameterSpec.b.intValue());
    }

    public static org.spongycastle.jce.spec.ECParameterSpec f(ECParameterSpec eCParameterSpec, boolean z) {
        ECCurve b = b(eCParameterSpec.getCurve());
        return new org.spongycastle.jce.spec.ECParameterSpec(b, d(b, eCParameterSpec.getGenerator()), eCParameterSpec.getOrder(), BigInteger.valueOf((long) eCParameterSpec.getCofactor()), eCParameterSpec.getCurve().getSeed());
    }

    public static ECParameterSpec g(X962Parameters x962Parameters, ECCurve eCCurve) {
        ASN1Primitive aSN1Primitive = x962Parameters.a;
        if (aSN1Primitive instanceof ASN1ObjectIdentifier) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) aSN1Primitive;
            X9ECParameters g = ECUtil.g(aSN1ObjectIdentifier);
            if (g == null) {
                Map c = BouncyCastleProvider.f6565a.c();
                if (!c.isEmpty()) {
                    g = (X9ECParameters) c.get(aSN1ObjectIdentifier);
                }
            }
            byte[] bArr = g.f5788a;
            EllipticCurve a2 = a(eCCurve);
            String d = ECUtil.d(aSN1ObjectIdentifier);
            ECPoint g2 = g.g();
            g2.b();
            return new ECNamedCurveSpec(d, a2, new java.security.spec.ECPoint(g2.f6621a.t(), g.g().e().t()), g.a, g.b);
        } else if (aSN1Primitive instanceof ASN1Null) {
            return null;
        } else {
            X9ECParameters h = X9ECParameters.h(aSN1Primitive);
            byte[] bArr2 = h.f5788a;
            EllipticCurve a3 = a(eCCurve);
            BigInteger bigInteger = h.a;
            BigInteger bigInteger2 = h.b;
            if (bigInteger2 != null) {
                ECPoint g3 = h.g();
                g3.b();
                return new ECParameterSpec(a3, new java.security.spec.ECPoint(g3.f6621a.t(), h.g().e().t()), bigInteger, bigInteger2.intValue());
            }
            ECPoint g4 = h.g();
            g4.b();
            return new ECParameterSpec(a3, new java.security.spec.ECPoint(g4.f6621a.t(), h.g().e().t()), bigInteger, 1);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: org.spongycastle.asn1.x9.X9ECParameters} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.spongycastle.math.ec.ECCurve h(org.spongycastle.jcajce.provider.config.ProviderConfiguration r3, org.spongycastle.asn1.x9.X962Parameters r4) {
        /*
            java.util.Set r0 = r3.b()
            org.spongycastle.asn1.ASN1Primitive r1 = r4.a
            boolean r2 = r1 instanceof org.spongycastle.asn1.ASN1ObjectIdentifier
            if (r2 == 0) goto L_0x0037
            org.spongycastle.asn1.ASN1ObjectIdentifier r4 = org.spongycastle.asn1.ASN1ObjectIdentifier.u(r1)
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0023
            boolean r0 = r0.contains(r4)
            if (r0 == 0) goto L_0x001b
            goto L_0x0023
        L_0x001b:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "named curve not acceptable"
            r3.<init>(r4)
            throw r3
        L_0x0023:
            org.spongycastle.asn1.x9.X9ECParameters r0 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.g(r4)
            if (r0 != 0) goto L_0x0034
            java.util.Map r3 = r3.c()
            java.lang.Object r3 = r3.get(r4)
            r0 = r3
            org.spongycastle.asn1.x9.X9ECParameters r0 = (org.spongycastle.asn1.x9.X9ECParameters) r0
        L_0x0034:
            org.spongycastle.math.ec.ECCurve r3 = r0.f5787a
            goto L_0x0050
        L_0x0037:
            boolean r1 = r1 instanceof org.spongycastle.asn1.ASN1Null
            if (r1 == 0) goto L_0x0042
            org.spongycastle.jce.spec.ECParameterSpec r3 = r3.d()
            org.spongycastle.math.ec.ECCurve r3 = r3.f6602a
            goto L_0x0050
        L_0x0042:
            boolean r3 = r0.isEmpty()
            if (r3 == 0) goto L_0x0051
            org.spongycastle.asn1.ASN1Primitive r3 = r4.a
            org.spongycastle.asn1.x9.X9ECParameters r3 = org.spongycastle.asn1.x9.X9ECParameters.h(r3)
            org.spongycastle.math.ec.ECCurve r3 = r3.f5787a
        L_0x0050:
            return r3
        L_0x0051:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "encoded parameters not acceptable"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.h(org.spongycastle.jcajce.provider.config.ProviderConfiguration, org.spongycastle.asn1.x9.X962Parameters):org.spongycastle.math.ec.ECCurve");
    }

    public static ECDomainParameters i(ProviderConfiguration providerConfiguration, ECParameterSpec eCParameterSpec) {
        if (eCParameterSpec != null) {
            return ECUtil.e(providerConfiguration, f(eCParameterSpec, false));
        }
        org.spongycastle.jce.spec.ECParameterSpec d = providerConfiguration.d();
        return new ECDomainParameters(d.f6602a, d.f6603a, d.a, d.b, d.f6604a);
    }
}
