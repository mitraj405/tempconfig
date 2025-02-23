package org.spongycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPrivateKey;
import java.security.spec.DSAParameterSpec;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.DSAParameter;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;

public class JDKDSAPrivateKey implements DSAPrivateKey, PKCS12BagAttributeCarrier {
    private static final long serialVersionUID = -4677259546958385734L;
    public BigInteger a;

    /* renamed from: a  reason: collision with other field name */
    public DSAParameterSpec f6585a;

    /* renamed from: a  reason: collision with other field name */
    public PKCS12BagAttributeCarrierImpl f6586a = new PKCS12BagAttributeCarrierImpl();

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.a = (BigInteger) objectInputStream.readObject();
        this.f6585a = new DSAParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
        PKCS12BagAttributeCarrierImpl pKCS12BagAttributeCarrierImpl = new PKCS12BagAttributeCarrierImpl();
        this.f6586a = pKCS12BagAttributeCarrierImpl;
        pKCS12BagAttributeCarrierImpl.a(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.a);
        objectOutputStream.writeObject(this.f6585a.getP());
        objectOutputStream.writeObject(this.f6585a.getQ());
        objectOutputStream.writeObject(this.f6585a.getG());
        this.f6586a.b(objectOutputStream);
    }

    public final ASN1Encodable d(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return this.f6586a.d(aSN1ObjectIdentifier);
    }

    public final Enumeration e() {
        return this.f6586a.e();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof DSAPrivateKey)) {
            return false;
        }
        DSAPrivateKey dSAPrivateKey = (DSAPrivateKey) obj;
        if (!getX().equals(dSAPrivateKey.getX()) || !getParams().getG().equals(dSAPrivateKey.getParams().getG()) || !getParams().getP().equals(dSAPrivateKey.getParams().getP()) || !getParams().getQ().equals(dSAPrivateKey.getParams().getQ())) {
            return false;
        }
        return true;
    }

    public final void f(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.f6586a.f(aSN1ObjectIdentifier, aSN1Encodable);
    }

    public final String getAlgorithm() {
        return "DSA";
    }

    public final byte[] getEncoded() {
        try {
            return new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.T0, new DSAParameter(this.f6585a.getP(), this.f6585a.getQ(), this.f6585a.getG())), new ASN1Integer(getX())).f("DER");
        } catch (IOException unused) {
            return null;
        }
    }

    public final String getFormat() {
        return "PKCS#8";
    }

    public final DSAParams getParams() {
        return this.f6585a;
    }

    public final BigInteger getX() {
        return this.a;
    }

    public final int hashCode() {
        return ((getX().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getQ().hashCode();
    }
}
