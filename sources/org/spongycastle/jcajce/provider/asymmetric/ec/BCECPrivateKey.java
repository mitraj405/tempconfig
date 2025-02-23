package org.spongycastle.jcajce.provider.asymmetric.ec;

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
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x9.X962Parameters;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jce.interfaces.ECPointEncoder;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECPrivateKeySpec;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPoint;

public class BCECPrivateKey implements ECPrivateKey, org.spongycastle.jce.interfaces.ECPrivateKey, PKCS12BagAttributeCarrier, ECPointEncoder {
    static final long serialVersionUID = 994553197664784084L;
    public transient BigInteger a;

    /* renamed from: a  reason: collision with other field name */
    public transient ECParameterSpec f6384a;

    /* renamed from: a  reason: collision with other field name */
    public transient DERBitString f6385a;

    /* renamed from: a  reason: collision with other field name */
    public transient PKCS12BagAttributeCarrierImpl f6386a = new PKCS12BagAttributeCarrierImpl();

    /* renamed from: a  reason: collision with other field name */
    public transient ProviderConfiguration f6387a;
    public final String c = "EC";

    public BCECPrivateKey() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.f6387a = BouncyCastleProvider.f6565a;
        c(PrivateKeyInfo.g(ASN1Primitive.k((byte[]) objectInputStream.readObject())));
        this.f6386a = new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public final org.spongycastle.jce.spec.ECParameterSpec a() {
        ECParameterSpec eCParameterSpec = this.f6384a;
        if (eCParameterSpec == null) {
            return null;
        }
        return EC5Util.f(eCParameterSpec, false);
    }

    public final org.spongycastle.jce.spec.ECParameterSpec b() {
        ECParameterSpec eCParameterSpec = this.f6384a;
        if (eCParameterSpec != null) {
            return EC5Util.f(eCParameterSpec, false);
        }
        return this.f6387a.d();
    }

    public final void c(PrivateKeyInfo privateKeyInfo) throws IOException {
        X962Parameters g = X962Parameters.g(privateKeyInfo.f5702a.a);
        this.f6384a = EC5Util.g(g, EC5Util.h(this.f6387a, g));
        ASN1Primitive h = privateKeyInfo.h();
        if (h instanceof ASN1Integer) {
            this.a = ASN1Integer.q(h).t();
            return;
        }
        org.spongycastle.asn1.sec.ECPrivateKey g2 = org.spongycastle.asn1.sec.ECPrivateKey.g(h);
        this.a = g2.h();
        this.f6385a = g2.i();
    }

    public final ASN1Encodable d(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return this.f6386a.d(aSN1ObjectIdentifier);
    }

    public final Enumeration e() {
        return this.f6386a.e();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof BCECPrivateKey)) {
            return false;
        }
        BCECPrivateKey bCECPrivateKey = (BCECPrivateKey) obj;
        if (!this.a.equals(bCECPrivateKey.a) || !b().equals(bCECPrivateKey.b())) {
            return false;
        }
        return true;
    }

    public final void f(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.f6386a.f(aSN1ObjectIdentifier, aSN1Encodable);
    }

    public final String getAlgorithm() {
        return this.c;
    }

    public final byte[] getEncoded() {
        int i;
        org.spongycastle.asn1.sec.ECPrivateKey eCPrivateKey;
        X962Parameters b = ECUtils.b(this.f6384a);
        ECParameterSpec eCParameterSpec = this.f6384a;
        if (eCParameterSpec == null) {
            i = ECUtil.i(this.f6387a, (BigInteger) null, getS());
        } else {
            i = ECUtil.i(this.f6387a, eCParameterSpec.getOrder(), getS());
        }
        if (this.f6385a != null) {
            eCPrivateKey = new org.spongycastle.asn1.sec.ECPrivateKey(i, getS(), this.f6385a, b);
        } else {
            eCPrivateKey = new org.spongycastle.asn1.sec.ECPrivateKey(i, getS(), (DERBitString) null, b);
        }
        try {
            return new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.q0, b), eCPrivateKey).f("DER");
        } catch (IOException unused) {
            return null;
        }
    }

    public final String getFormat() {
        return "PKCS#8";
    }

    public final ECParameterSpec getParams() {
        return this.f6384a;
    }

    public final BigInteger getS() {
        return this.a;
    }

    public final int hashCode() {
        return this.a.hashCode() ^ b().hashCode();
    }

    public final String toString() {
        return ECUtil.k("EC", this.a, b());
    }

    public final BigInteger v() {
        return this.a;
    }

    public BCECPrivateKey(ECPrivateKey eCPrivateKey, ProviderConfiguration providerConfiguration) {
        this.a = eCPrivateKey.getS();
        this.c = eCPrivateKey.getAlgorithm();
        this.f6384a = eCPrivateKey.getParams();
        this.f6387a = providerConfiguration;
    }

    public BCECPrivateKey(String str, ECPrivateKeySpec eCPrivateKeySpec, ProviderConfiguration providerConfiguration) {
        this.c = str;
        this.a = eCPrivateKeySpec.a;
        org.spongycastle.jce.spec.ECParameterSpec eCParameterSpec = eCPrivateKeySpec.a;
        if (eCParameterSpec != null) {
            this.f6384a = EC5Util.e(EC5Util.a(eCParameterSpec.f6602a), eCParameterSpec);
        } else {
            this.f6384a = null;
        }
        this.f6387a = providerConfiguration;
    }

    public BCECPrivateKey(String str, java.security.spec.ECPrivateKeySpec eCPrivateKeySpec, ProviderConfiguration providerConfiguration) {
        this.c = str;
        this.a = eCPrivateKeySpec.getS();
        this.f6384a = eCPrivateKeySpec.getParams();
        this.f6387a = providerConfiguration;
    }

    public BCECPrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, BCECPublicKey bCECPublicKey, ECParameterSpec eCParameterSpec, ProviderConfiguration providerConfiguration) {
        DERBitString dERBitString;
        ECDomainParameters eCDomainParameters = eCPrivateKeyParameters.a;
        this.c = str;
        this.a = eCPrivateKeyParameters.a;
        this.f6387a = providerConfiguration;
        if (eCParameterSpec == null) {
            ECCurve eCCurve = eCDomainParameters.a;
            eCDomainParameters.a();
            EllipticCurve a2 = EC5Util.a(eCCurve);
            ECPoint eCPoint = eCDomainParameters.f6230a;
            eCPoint.b();
            this.f6384a = new ECParameterSpec(a2, new java.security.spec.ECPoint(eCPoint.f6621a.t(), eCPoint.e().t()), eCDomainParameters.g, eCDomainParameters.h.intValue());
        } else {
            this.f6384a = eCParameterSpec;
        }
        try {
            dERBitString = SubjectPublicKeyInfo.g(ASN1Primitive.k(bCECPublicKey.getEncoded())).a;
        } catch (IOException unused) {
            dERBitString = null;
        }
        this.f6385a = dERBitString;
    }

    public BCECPrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, BCECPublicKey bCECPublicKey, org.spongycastle.jce.spec.ECParameterSpec eCParameterSpec, ProviderConfiguration providerConfiguration) {
        DERBitString dERBitString;
        ECDomainParameters eCDomainParameters = eCPrivateKeyParameters.a;
        this.c = str;
        this.a = eCPrivateKeyParameters.a;
        this.f6387a = providerConfiguration;
        if (eCParameterSpec == null) {
            ECCurve eCCurve = eCDomainParameters.a;
            eCDomainParameters.a();
            EllipticCurve a2 = EC5Util.a(eCCurve);
            ECPoint eCPoint = eCDomainParameters.f6230a;
            eCPoint.b();
            this.f6384a = new ECParameterSpec(a2, new java.security.spec.ECPoint(eCPoint.f6621a.t(), eCPoint.e().t()), eCDomainParameters.g, eCDomainParameters.h.intValue());
        } else {
            this.f6384a = EC5Util.e(EC5Util.a(eCParameterSpec.f6602a), eCParameterSpec);
        }
        try {
            dERBitString = SubjectPublicKeyInfo.g(ASN1Primitive.k(bCECPublicKey.getEncoded())).a;
        } catch (IOException unused) {
            dERBitString = null;
        }
        try {
            this.f6385a = dERBitString;
        } catch (Exception unused2) {
            this.f6385a = null;
        }
    }

    public BCECPrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, ProviderConfiguration providerConfiguration) {
        this.c = str;
        this.a = eCPrivateKeyParameters.a;
        this.f6384a = null;
        this.f6387a = providerConfiguration;
    }

    public BCECPrivateKey(String str, PrivateKeyInfo privateKeyInfo, ProviderConfiguration providerConfiguration) throws IOException {
        this.c = str;
        this.f6387a = providerConfiguration;
        c(privateKeyInfo);
    }
}
