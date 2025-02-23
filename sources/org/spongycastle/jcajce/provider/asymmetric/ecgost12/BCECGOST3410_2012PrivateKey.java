package org.spongycastle.jcajce.provider.asymmetric.ecgost12;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.EllipticCurve;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Null;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.rosstandart.RosstandartObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x9.X962Parameters;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jce.ECGOST3410NamedCurveTable;
import org.spongycastle.jce.interfaces.ECPointEncoder;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECNamedCurveParameterSpec;
import org.spongycastle.jce.spec.ECNamedCurveSpec;
import org.spongycastle.jce.spec.ECPrivateKeySpec;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPoint;

public class BCECGOST3410_2012PrivateKey implements ECPrivateKey, org.spongycastle.jce.interfaces.ECPrivateKey, PKCS12BagAttributeCarrier, ECPointEncoder {
    static final long serialVersionUID = 7245981689601667138L;
    public transient BigInteger a;

    /* renamed from: a  reason: collision with other field name */
    public transient ECParameterSpec f6422a;

    /* renamed from: a  reason: collision with other field name */
    public transient DERBitString f6423a;

    /* renamed from: a  reason: collision with other field name */
    public transient GOST3410PublicKeyAlgParameters f6424a;

    /* renamed from: a  reason: collision with other field name */
    public transient PKCS12BagAttributeCarrierImpl f6425a = new PKCS12BagAttributeCarrierImpl();
    public final String c = "ECGOST3410-2012";

    public BCECGOST3410_2012PrivateKey() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        c(PrivateKeyInfo.g(ASN1Primitive.k((byte[]) objectInputStream.readObject())));
        this.f6425a = new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public final org.spongycastle.jce.spec.ECParameterSpec a() {
        ECParameterSpec eCParameterSpec = this.f6422a;
        if (eCParameterSpec == null) {
            return null;
        }
        return EC5Util.f(eCParameterSpec, false);
    }

    public final org.spongycastle.jce.spec.ECParameterSpec b() {
        ECParameterSpec eCParameterSpec = this.f6422a;
        if (eCParameterSpec != null) {
            return EC5Util.f(eCParameterSpec, false);
        }
        return BouncyCastleProvider.f6565a.d();
    }

    public final void c(PrivateKeyInfo privateKeyInfo) throws IOException {
        ASN1Primitive b = privateKeyInfo.f5702a.a.b();
        boolean z = b instanceof ASN1Sequence;
        AlgorithmIdentifier algorithmIdentifier = privateKeyInfo.f5702a;
        if (!z || !(ASN1Sequence.q(b).size() == 2 || ASN1Sequence.q(b).size() == 3)) {
            ASN1Primitive aSN1Primitive = X962Parameters.g(algorithmIdentifier.a).a;
            if (aSN1Primitive instanceof ASN1ObjectIdentifier) {
                ASN1ObjectIdentifier u = ASN1ObjectIdentifier.u(aSN1Primitive);
                X9ECParameters g = ECUtil.g(u);
                if (g == null) {
                    ECDomainParameters eCDomainParameters = (ECDomainParameters) ECGOST3410NamedCurves.b.get(u);
                    ECCurve eCCurve = eCDomainParameters.a;
                    eCDomainParameters.a();
                    EllipticCurve a2 = EC5Util.a(eCCurve);
                    String b2 = ECGOST3410NamedCurves.b(u);
                    ECPoint eCPoint = eCDomainParameters.f6230a;
                    eCPoint.b();
                    this.f6422a = new ECNamedCurveSpec(b2, a2, new java.security.spec.ECPoint(eCPoint.f6621a.t(), eCPoint.e().t()), eCDomainParameters.g, eCDomainParameters.h);
                } else {
                    EllipticCurve a3 = EC5Util.a(g.f5787a);
                    String d = ECUtil.d(u);
                    ECPoint g2 = g.g();
                    g2.b();
                    this.f6422a = new ECNamedCurveSpec(d, a3, new java.security.spec.ECPoint(g2.f6621a.t(), g.g().e().t()), g.a, g.b);
                }
            } else if (aSN1Primitive instanceof ASN1Null) {
                this.f6422a = null;
            } else {
                X9ECParameters h = X9ECParameters.h(aSN1Primitive);
                EllipticCurve a4 = EC5Util.a(h.f5787a);
                ECPoint g3 = h.g();
                g3.b();
                this.f6422a = new ECParameterSpec(a4, new java.security.spec.ECPoint(g3.f6621a.t(), h.g().e().t()), h.a, h.b.intValue());
            }
            ASN1Primitive h2 = privateKeyInfo.h();
            if (h2 instanceof ASN1Integer) {
                this.a = ASN1Integer.q(h2).t();
                return;
            }
            org.spongycastle.asn1.sec.ECPrivateKey g4 = org.spongycastle.asn1.sec.ECPrivateKey.g(h2);
            this.a = g4.h();
            this.f6423a = g4.i();
            return;
        }
        GOST3410PublicKeyAlgParameters g5 = GOST3410PublicKeyAlgParameters.g(algorithmIdentifier.a);
        this.f6424a = g5;
        ECNamedCurveParameterSpec a5 = ECGOST3410NamedCurveTable.a(ECGOST3410NamedCurves.b(g5.Z0));
        EllipticCurve a6 = EC5Util.a(a5.f6602a);
        String b3 = ECGOST3410NamedCurves.b(this.f6424a.Z0);
        ECPoint eCPoint2 = a5.f6603a;
        eCPoint2.b();
        this.f6422a = new ECNamedCurveSpec(b3, a6, new java.security.spec.ECPoint(eCPoint2.f6621a.t(), eCPoint2.e().t()), a5.a, a5.b);
        ASN1Primitive h3 = privateKeyInfo.h();
        if (h3 instanceof ASN1Integer) {
            this.a = ASN1Integer.q(h3).s();
            return;
        }
        byte[] s = ASN1OctetString.q(h3).s();
        byte[] bArr = new byte[s.length];
        for (int i = 0; i != s.length; i++) {
            bArr[i] = s[(s.length - 1) - i];
        }
        this.a = new BigInteger(1, bArr);
    }

    public final ASN1Encodable d(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return this.f6425a.d(aSN1ObjectIdentifier);
    }

    public final Enumeration e() {
        return this.f6425a.e();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof BCECGOST3410_2012PrivateKey)) {
            return false;
        }
        BCECGOST3410_2012PrivateKey bCECGOST3410_2012PrivateKey = (BCECGOST3410_2012PrivateKey) obj;
        if (!this.a.equals(bCECGOST3410_2012PrivateKey.a) || !b().equals(bCECGOST3410_2012PrivateKey.b())) {
            return false;
        }
        return true;
    }

    public final void f(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.f6425a.f(aSN1ObjectIdentifier, aSN1Encodable);
    }

    public final String getAlgorithm() {
        return this.c;
    }

    public final byte[] getEncoded() {
        boolean z;
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        int i;
        X962Parameters x962Parameters;
        int i2;
        org.spongycastle.asn1.sec.ECPrivateKey eCPrivateKey;
        if (this.a.bitLength() > 256) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            aSN1ObjectIdentifier = RosstandartObjectIdentifiers.f;
        } else {
            aSN1ObjectIdentifier = RosstandartObjectIdentifiers.e;
        }
        if (z) {
            i = 64;
        } else {
            i = 32;
        }
        if (this.f6424a != null) {
            byte[] bArr = new byte[i];
            byte[] byteArray = getS().toByteArray();
            if (byteArray.length < i) {
                byte[] bArr2 = new byte[i];
                System.arraycopy(byteArray, 0, bArr2, i - byteArray.length, byteArray.length);
                byteArray = bArr2;
            }
            for (int i3 = 0; i3 != i; i3++) {
                bArr[0 + i3] = byteArray[(byteArray.length - 1) - i3];
            }
            try {
                return new PrivateKeyInfo(new AlgorithmIdentifier(aSN1ObjectIdentifier, this.f6424a), new DEROctetString(bArr)).f("DER");
            } catch (IOException unused) {
                return null;
            }
        } else {
            ECParameterSpec eCParameterSpec = this.f6422a;
            if (eCParameterSpec instanceof ECNamedCurveSpec) {
                ASN1ObjectIdentifier h = ECUtil.h(((ECNamedCurveSpec) eCParameterSpec).a);
                if (h == null) {
                    h = new ASN1ObjectIdentifier(((ECNamedCurveSpec) this.f6422a).a);
                }
                x962Parameters = new X962Parameters(h);
                i2 = ECUtil.i(BouncyCastleProvider.f6565a, this.f6422a.getOrder(), getS());
            } else if (eCParameterSpec == null) {
                x962Parameters = new X962Parameters(DERNull.a);
                i2 = ECUtil.i(BouncyCastleProvider.f6565a, (BigInteger) null, getS());
            } else {
                ECCurve b = EC5Util.b(eCParameterSpec.getCurve());
                x962Parameters = new X962Parameters(new X9ECParameters(b, EC5Util.d(b, this.f6422a.getGenerator()), this.f6422a.getOrder(), BigInteger.valueOf((long) this.f6422a.getCofactor()), this.f6422a.getCurve().getSeed()));
                i2 = ECUtil.i(BouncyCastleProvider.f6565a, this.f6422a.getOrder(), getS());
            }
            if (this.f6423a != null) {
                eCPrivateKey = new org.spongycastle.asn1.sec.ECPrivateKey(i2, getS(), this.f6423a, x962Parameters);
            } else {
                eCPrivateKey = new org.spongycastle.asn1.sec.ECPrivateKey(i2, getS(), (DERBitString) null, x962Parameters);
            }
            try {
                return new PrivateKeyInfo(new AlgorithmIdentifier(aSN1ObjectIdentifier, x962Parameters.a), eCPrivateKey.a).f("DER");
            } catch (IOException unused2) {
                return null;
            }
        }
    }

    public final String getFormat() {
        return "PKCS#8";
    }

    public final ECParameterSpec getParams() {
        return this.f6422a;
    }

    public final BigInteger getS() {
        return this.a;
    }

    public final int hashCode() {
        return this.a.hashCode() ^ b().hashCode();
    }

    public final String toString() {
        return ECUtil.k(this.c, this.a, b());
    }

    public final BigInteger v() {
        return this.a;
    }

    public BCECGOST3410_2012PrivateKey(ECPrivateKeySpec eCPrivateKeySpec) {
        this.a = eCPrivateKeySpec.a;
        org.spongycastle.jce.spec.ECParameterSpec eCParameterSpec = eCPrivateKeySpec.a;
        if (eCParameterSpec != null) {
            this.f6422a = EC5Util.e(EC5Util.a(eCParameterSpec.f6602a), eCParameterSpec);
        } else {
            this.f6422a = null;
        }
    }

    public BCECGOST3410_2012PrivateKey(java.security.spec.ECPrivateKeySpec eCPrivateKeySpec) {
        this.a = eCPrivateKeySpec.getS();
        this.f6422a = eCPrivateKeySpec.getParams();
    }

    public BCECGOST3410_2012PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, BCECGOST3410_2012PublicKey bCECGOST3410_2012PublicKey, ECParameterSpec eCParameterSpec) {
        DERBitString dERBitString;
        ECDomainParameters eCDomainParameters = eCPrivateKeyParameters.a;
        this.c = str;
        this.a = eCPrivateKeyParameters.a;
        if (eCParameterSpec == null) {
            ECCurve eCCurve = eCDomainParameters.a;
            eCDomainParameters.a();
            EllipticCurve a2 = EC5Util.a(eCCurve);
            ECPoint eCPoint = eCDomainParameters.f6230a;
            eCPoint.b();
            this.f6422a = new ECParameterSpec(a2, new java.security.spec.ECPoint(eCPoint.f6621a.t(), eCPoint.e().t()), eCDomainParameters.g, eCDomainParameters.h.intValue());
        } else {
            this.f6422a = eCParameterSpec;
        }
        this.f6424a = bCECGOST3410_2012PublicKey.f6426a;
        try {
            dERBitString = SubjectPublicKeyInfo.g(ASN1Primitive.k(bCECGOST3410_2012PublicKey.getEncoded())).a;
        } catch (IOException unused) {
            dERBitString = null;
        }
        this.f6423a = dERBitString;
    }

    public BCECGOST3410_2012PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, BCECGOST3410_2012PublicKey bCECGOST3410_2012PublicKey, org.spongycastle.jce.spec.ECParameterSpec eCParameterSpec) {
        DERBitString dERBitString;
        ECDomainParameters eCDomainParameters = eCPrivateKeyParameters.a;
        this.c = str;
        this.a = eCPrivateKeyParameters.a;
        if (eCParameterSpec == null) {
            ECCurve eCCurve = eCDomainParameters.a;
            eCDomainParameters.a();
            EllipticCurve a2 = EC5Util.a(eCCurve);
            ECPoint eCPoint = eCDomainParameters.f6230a;
            eCPoint.b();
            this.f6422a = new ECParameterSpec(a2, new java.security.spec.ECPoint(eCPoint.f6621a.t(), eCPoint.e().t()), eCDomainParameters.g, eCDomainParameters.h.intValue());
        } else {
            EllipticCurve a3 = EC5Util.a(eCParameterSpec.f6602a);
            ECPoint eCPoint2 = eCParameterSpec.f6603a;
            eCPoint2.b();
            this.f6422a = new ECParameterSpec(a3, new java.security.spec.ECPoint(eCPoint2.f6621a.t(), eCPoint2.e().t()), eCParameterSpec.a, eCParameterSpec.b.intValue());
        }
        this.f6424a = bCECGOST3410_2012PublicKey.f6426a;
        try {
            dERBitString = SubjectPublicKeyInfo.g(ASN1Primitive.k(bCECGOST3410_2012PublicKey.getEncoded())).a;
        } catch (IOException unused) {
            dERBitString = null;
        }
        this.f6423a = dERBitString;
    }

    public BCECGOST3410_2012PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters) {
        this.c = str;
        this.a = eCPrivateKeyParameters.a;
        this.f6422a = null;
    }

    public BCECGOST3410_2012PrivateKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        c(privateKeyInfo);
    }
}
