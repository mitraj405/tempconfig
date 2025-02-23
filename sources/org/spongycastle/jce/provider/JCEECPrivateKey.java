package org.spongycastle.jce.provider;

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
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.sec.ECPrivateKeyStructure;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x9.X962Parameters;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jce.interfaces.ECPointEncoder;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.spongycastle.jce.spec.ECNamedCurveSpec;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.Strings;

public class JCEECPrivateKey implements ECPrivateKey, org.spongycastle.jce.interfaces.ECPrivateKey, PKCS12BagAttributeCarrier, ECPointEncoder {
    public BigInteger a;

    /* renamed from: a  reason: collision with other field name */
    public ECParameterSpec f6574a;

    /* renamed from: a  reason: collision with other field name */
    public DERBitString f6575a;

    /* renamed from: a  reason: collision with other field name */
    public PKCS12BagAttributeCarrierImpl f6576a = new PKCS12BagAttributeCarrierImpl();

    /* renamed from: a  reason: collision with other field name */
    public boolean f6577a;
    public String c = "EC";

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        PrivateKeyInfo g = PrivateKeyInfo.g(ASN1Primitive.k((byte[]) objectInputStream.readObject()));
        ASN1Primitive aSN1Primitive = new X962Parameters((ASN1Primitive) g.f5702a.a).a;
        ASN1Primitive aSN1Primitive2 = null;
        if (aSN1Primitive instanceof ASN1ObjectIdentifier) {
            ASN1ObjectIdentifier u = ASN1ObjectIdentifier.u(aSN1Primitive);
            X9ECParameters g2 = ECUtil.g(u);
            if (g2 == null) {
                ECDomainParameters eCDomainParameters = (ECDomainParameters) ECGOST3410NamedCurves.b.get(u);
                ECCurve eCCurve = eCDomainParameters.a;
                eCDomainParameters.a();
                EllipticCurve a2 = EC5Util.a(eCCurve);
                String b = ECGOST3410NamedCurves.b(u);
                ECPoint eCPoint = eCDomainParameters.f6230a;
                eCPoint.b();
                this.f6574a = new ECNamedCurveSpec(b, a2, new java.security.spec.ECPoint(eCPoint.f6621a.t(), eCPoint.e().t()), eCDomainParameters.g, eCDomainParameters.h);
            } else {
                EllipticCurve a3 = EC5Util.a(g2.f5787a);
                String d = ECUtil.d(u);
                ECPoint g3 = g2.g();
                g3.b();
                this.f6574a = new ECNamedCurveSpec(d, a3, new java.security.spec.ECPoint(g3.f6621a.t(), g2.g().e().t()), g2.a, g2.b);
            }
        } else if (aSN1Primitive instanceof ASN1Null) {
            this.f6574a = null;
        } else {
            X9ECParameters h = X9ECParameters.h(aSN1Primitive);
            EllipticCurve a4 = EC5Util.a(h.f5787a);
            ECPoint g4 = h.g();
            g4.b();
            this.f6574a = new ECParameterSpec(a4, new java.security.spec.ECPoint(g4.f6621a.t(), h.g().e().t()), h.a, h.b.intValue());
        }
        ASN1Primitive h2 = g.h();
        if (h2 instanceof ASN1Integer) {
            this.a = ASN1Integer.q(h2).t();
        } else {
            ASN1Sequence aSN1Sequence = new ECPrivateKeyStructure((ASN1Sequence) h2).a;
            this.a = new BigInteger(1, ((ASN1OctetString) aSN1Sequence.s(1)).s());
            Enumeration t = aSN1Sequence.t();
            while (true) {
                if (!t.hasMoreElements()) {
                    break;
                }
                ASN1Encodable aSN1Encodable = (ASN1Encodable) t.nextElement();
                if (aSN1Encodable instanceof ASN1TaggedObject) {
                    ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Encodable;
                    if (aSN1TaggedObject.c == 1) {
                        aSN1Primitive2 = aSN1TaggedObject.r();
                        aSN1Primitive2.getClass();
                        break;
                    }
                }
            }
            this.f6575a = (DERBitString) aSN1Primitive2;
        }
        this.c = (String) objectInputStream.readObject();
        this.f6577a = objectInputStream.readBoolean();
        PKCS12BagAttributeCarrierImpl pKCS12BagAttributeCarrierImpl = new PKCS12BagAttributeCarrierImpl();
        this.f6576a = pKCS12BagAttributeCarrierImpl;
        pKCS12BagAttributeCarrierImpl.a(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(getEncoded());
        objectOutputStream.writeObject(this.c);
        objectOutputStream.writeBoolean(this.f6577a);
        this.f6576a.b(objectOutputStream);
    }

    public final org.spongycastle.jce.spec.ECParameterSpec a() {
        ECParameterSpec eCParameterSpec = this.f6574a;
        if (eCParameterSpec == null) {
            return null;
        }
        return EC5Util.f(eCParameterSpec, this.f6577a);
    }

    public final org.spongycastle.jce.spec.ECParameterSpec b() {
        ECParameterSpec eCParameterSpec = this.f6574a;
        if (eCParameterSpec != null) {
            return EC5Util.f(eCParameterSpec, this.f6577a);
        }
        return ((BouncyCastleProviderConfiguration) BouncyCastleProvider.f6565a).d();
    }

    public final ASN1Encodable d(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return this.f6576a.d(aSN1ObjectIdentifier);
    }

    public final Enumeration e() {
        return this.f6576a.e();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof JCEECPrivateKey)) {
            return false;
        }
        JCEECPrivateKey jCEECPrivateKey = (JCEECPrivateKey) obj;
        if (!this.a.equals(jCEECPrivateKey.a) || !b().equals(jCEECPrivateKey.b())) {
            return false;
        }
        return true;
    }

    public final void f(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.f6576a.f(aSN1ObjectIdentifier, aSN1Encodable);
    }

    public final String getAlgorithm() {
        return this.c;
    }

    public final byte[] getEncoded() {
        X962Parameters x962Parameters;
        ECPrivateKeyStructure eCPrivateKeyStructure;
        PrivateKeyInfo privateKeyInfo;
        ECParameterSpec eCParameterSpec = this.f6574a;
        if (eCParameterSpec instanceof ECNamedCurveSpec) {
            ASN1ObjectIdentifier h = ECUtil.h(((ECNamedCurveSpec) eCParameterSpec).a);
            if (h == null) {
                h = new ASN1ObjectIdentifier(((ECNamedCurveSpec) this.f6574a).a);
            }
            x962Parameters = new X962Parameters(h);
        } else if (eCParameterSpec == null) {
            x962Parameters = new X962Parameters(DERNull.a);
        } else {
            ECCurve b = EC5Util.b(eCParameterSpec.getCurve());
            x962Parameters = new X962Parameters(new X9ECParameters(b, EC5Util.d(b, this.f6574a.getGenerator()), this.f6574a.getOrder(), BigInteger.valueOf((long) this.f6574a.getCofactor()), this.f6574a.getCurve().getSeed()));
        }
        if (this.f6575a != null) {
            eCPrivateKeyStructure = new ECPrivateKeyStructure(getS(), this.f6575a, x962Parameters);
        } else {
            eCPrivateKeyStructure = new ECPrivateKeyStructure(getS(), (DERBitString) null, x962Parameters);
        }
        try {
            ASN1Sequence aSN1Sequence = eCPrivateKeyStructure.a;
            boolean equals = this.c.equals("ECGOST3410");
            ASN1Primitive aSN1Primitive = x962Parameters.a;
            if (equals) {
                privateKeyInfo = new PrivateKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.l, aSN1Primitive), aSN1Sequence);
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
        return this.f6574a;
    }

    public final BigInteger getS() {
        return this.a;
    }

    public final int hashCode() {
        return this.a.hashCode() ^ b().hashCode();
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer("EC Private Key");
        String str = Strings.a;
        stringBuffer.append(str);
        stringBuffer.append("             S: ");
        stringBuffer.append(this.a.toString(16));
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    public final BigInteger v() {
        return this.a;
    }
}
