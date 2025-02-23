package org.spongycastle.jcajce.provider.asymmetric.dstu;

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
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.ua.DSTU4145NamedCurves;
import org.spongycastle.asn1.ua.UAObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x9.X962Parameters;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jce.interfaces.ECPointEncoder;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECNamedCurveSpec;
import org.spongycastle.jce.spec.ECPrivateKeySpec;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPoint;

public class BCDSTU4145PrivateKey implements ECPrivateKey, org.spongycastle.jce.interfaces.ECPrivateKey, PKCS12BagAttributeCarrier, ECPointEncoder {
    static final long serialVersionUID = 7245981689601667138L;
    public transient BigInteger a;

    /* renamed from: a  reason: collision with other field name */
    public transient ECParameterSpec f6373a;

    /* renamed from: a  reason: collision with other field name */
    public transient DERBitString f6374a;

    /* renamed from: a  reason: collision with other field name */
    public transient PKCS12BagAttributeCarrierImpl f6375a = new PKCS12BagAttributeCarrierImpl();
    public final String c = "DSTU4145";

    public BCDSTU4145PrivateKey() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        c(PrivateKeyInfo.g(ASN1Primitive.k((byte[]) objectInputStream.readObject())));
        this.f6375a = new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public final org.spongycastle.jce.spec.ECParameterSpec a() {
        ECParameterSpec eCParameterSpec = this.f6373a;
        if (eCParameterSpec == null) {
            return null;
        }
        return EC5Util.f(eCParameterSpec, false);
    }

    public final org.spongycastle.jce.spec.ECParameterSpec b() {
        ECParameterSpec eCParameterSpec = this.f6373a;
        if (eCParameterSpec != null) {
            return EC5Util.f(eCParameterSpec, false);
        }
        return BouncyCastleProvider.f6565a.d();
    }

    public final void c(PrivateKeyInfo privateKeyInfo) throws IOException {
        ASN1Primitive aSN1Primitive = new X962Parameters((ASN1Primitive) privateKeyInfo.f5702a.a).a;
        if (aSN1Primitive instanceof ASN1ObjectIdentifier) {
            ASN1ObjectIdentifier u = ASN1ObjectIdentifier.u(aSN1Primitive);
            X9ECParameters g = ECUtil.g(u);
            if (g == null) {
                ECDomainParameters a2 = DSTU4145NamedCurves.a(u);
                ECCurve eCCurve = a2.a;
                a2.a();
                EllipticCurve a3 = EC5Util.a(eCCurve);
                String str = u.c;
                ECPoint eCPoint = a2.f6230a;
                eCPoint.b();
                this.f6373a = new ECNamedCurveSpec(str, a3, new java.security.spec.ECPoint(eCPoint.f6621a.t(), eCPoint.e().t()), a2.g, a2.h);
            } else {
                EllipticCurve a4 = EC5Util.a(g.f5787a);
                String d = ECUtil.d(u);
                ECPoint g2 = g.g();
                g2.b();
                this.f6373a = new ECNamedCurveSpec(d, a4, new java.security.spec.ECPoint(g2.f6621a.t(), g.g().e().t()), g.a, g.b);
            }
        } else if (aSN1Primitive instanceof ASN1Null) {
            this.f6373a = null;
        } else {
            X9ECParameters h = X9ECParameters.h(aSN1Primitive);
            EllipticCurve a5 = EC5Util.a(h.f5787a);
            ECPoint g3 = h.g();
            g3.b();
            this.f6373a = new ECParameterSpec(a5, new java.security.spec.ECPoint(g3.f6621a.t(), h.g().e().t()), h.a, h.b.intValue());
        }
        ASN1Primitive h2 = privateKeyInfo.h();
        if (h2 instanceof ASN1Integer) {
            this.a = ASN1Integer.q(h2).t();
            return;
        }
        org.spongycastle.asn1.sec.ECPrivateKey g4 = org.spongycastle.asn1.sec.ECPrivateKey.g(h2);
        this.a = g4.h();
        this.f6374a = g4.i();
    }

    public final ASN1Encodable d(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return this.f6375a.d(aSN1ObjectIdentifier);
    }

    public final Enumeration e() {
        return this.f6375a.e();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof BCDSTU4145PrivateKey)) {
            return false;
        }
        BCDSTU4145PrivateKey bCDSTU4145PrivateKey = (BCDSTU4145PrivateKey) obj;
        if (!this.a.equals(bCDSTU4145PrivateKey.a) || !b().equals(bCDSTU4145PrivateKey.b())) {
            return false;
        }
        return true;
    }

    public final void f(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.f6375a.f(aSN1ObjectIdentifier, aSN1Encodable);
    }

    public final String getAlgorithm() {
        return this.c;
    }

    public final byte[] getEncoded() {
        X962Parameters x962Parameters;
        int i;
        org.spongycastle.asn1.sec.ECPrivateKey eCPrivateKey;
        PrivateKeyInfo privateKeyInfo;
        ECParameterSpec eCParameterSpec = this.f6373a;
        if (eCParameterSpec instanceof ECNamedCurveSpec) {
            ASN1ObjectIdentifier h = ECUtil.h(((ECNamedCurveSpec) eCParameterSpec).a);
            if (h == null) {
                h = new ASN1ObjectIdentifier(((ECNamedCurveSpec) this.f6373a).a);
            }
            x962Parameters = new X962Parameters(h);
            i = ECUtil.i(BouncyCastleProvider.f6565a, this.f6373a.getOrder(), getS());
        } else if (eCParameterSpec == null) {
            x962Parameters = new X962Parameters(DERNull.a);
            i = ECUtil.i(BouncyCastleProvider.f6565a, (BigInteger) null, getS());
        } else {
            ECCurve b = EC5Util.b(eCParameterSpec.getCurve());
            x962Parameters = new X962Parameters(new X9ECParameters(b, EC5Util.d(b, this.f6373a.getGenerator()), this.f6373a.getOrder(), BigInteger.valueOf((long) this.f6373a.getCofactor()), this.f6373a.getCurve().getSeed()));
            i = ECUtil.i(BouncyCastleProvider.f6565a, this.f6373a.getOrder(), getS());
        }
        if (this.f6374a != null) {
            eCPrivateKey = new org.spongycastle.asn1.sec.ECPrivateKey(i, getS(), this.f6374a, x962Parameters);
        } else {
            eCPrivateKey = new org.spongycastle.asn1.sec.ECPrivateKey(i, getS(), (DERBitString) null, x962Parameters);
        }
        try {
            ASN1Sequence aSN1Sequence = eCPrivateKey.a;
            boolean equals = this.c.equals("DSTU4145");
            ASN1Primitive aSN1Primitive = x962Parameters.a;
            if (equals) {
                privateKeyInfo = new PrivateKeyInfo(new AlgorithmIdentifier(UAObjectIdentifiers.b, aSN1Primitive), aSN1Sequence);
            } else {
                privateKeyInfo = new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.q0, aSN1Primitive), aSN1Sequence);
            }
            return privateKeyInfo.f("DER");
        } catch (IOException unused) {
            return null;
        }
    }

    public final String getFormat() {
        return "PKCS#8";
    }

    public final ECParameterSpec getParams() {
        return this.f6373a;
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

    public BCDSTU4145PrivateKey(ECPrivateKeySpec eCPrivateKeySpec) {
        this.a = eCPrivateKeySpec.a;
        org.spongycastle.jce.spec.ECParameterSpec eCParameterSpec = eCPrivateKeySpec.a;
        if (eCParameterSpec != null) {
            this.f6373a = EC5Util.e(EC5Util.a(eCParameterSpec.f6602a), eCParameterSpec);
        } else {
            this.f6373a = null;
        }
    }

    public BCDSTU4145PrivateKey(java.security.spec.ECPrivateKeySpec eCPrivateKeySpec) {
        this.a = eCPrivateKeySpec.getS();
        this.f6373a = eCPrivateKeySpec.getParams();
    }

    public BCDSTU4145PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, BCDSTU4145PublicKey bCDSTU4145PublicKey, ECParameterSpec eCParameterSpec) {
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
            this.f6373a = new ECParameterSpec(a2, new java.security.spec.ECPoint(eCPoint.f6621a.t(), eCPoint.e().t()), eCDomainParameters.g, eCDomainParameters.h.intValue());
        } else {
            this.f6373a = eCParameterSpec;
        }
        try {
            dERBitString = SubjectPublicKeyInfo.g(ASN1Primitive.k(bCDSTU4145PublicKey.getEncoded())).a;
        } catch (IOException unused) {
            dERBitString = null;
        }
        this.f6374a = dERBitString;
    }

    public BCDSTU4145PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, BCDSTU4145PublicKey bCDSTU4145PublicKey, org.spongycastle.jce.spec.ECParameterSpec eCParameterSpec) {
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
            this.f6373a = new ECParameterSpec(a2, new java.security.spec.ECPoint(eCPoint.f6621a.t(), eCPoint.e().t()), eCDomainParameters.g, eCDomainParameters.h.intValue());
        } else {
            EllipticCurve a3 = EC5Util.a(eCParameterSpec.f6602a);
            ECPoint eCPoint2 = eCParameterSpec.f6603a;
            eCPoint2.b();
            this.f6373a = new ECParameterSpec(a3, new java.security.spec.ECPoint(eCPoint2.f6621a.t(), eCPoint2.e().t()), eCParameterSpec.a, eCParameterSpec.b.intValue());
        }
        try {
            dERBitString = SubjectPublicKeyInfo.g(ASN1Primitive.k(bCDSTU4145PublicKey.getEncoded())).a;
        } catch (IOException unused) {
            dERBitString = null;
        }
        this.f6374a = dERBitString;
    }

    public BCDSTU4145PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters) {
        this.c = str;
        this.a = eCPrivateKeyParameters.a;
        this.f6373a = null;
    }

    public BCDSTU4145PrivateKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        c(privateKeyInfo);
    }
}
