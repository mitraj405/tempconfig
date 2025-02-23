package org.spongycastle.jcajce.provider.asymmetric.dsa;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPrivateKey;
import java.security.spec.DSAParameterSpec;
import java.security.spec.DSAPrivateKeySpec;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.DSAParameter;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.crypto.params.DSAParameters;
import org.spongycastle.crypto.params.DSAPrivateKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.spongycastle.util.Strings;

public class BCDSAPrivateKey implements DSAPrivateKey, PKCS12BagAttributeCarrier {
    private static final long serialVersionUID = -4677259546958385734L;
    public final BigInteger a;

    /* renamed from: a  reason: collision with other field name */
    public transient DSAParams f6361a;

    /* renamed from: a  reason: collision with other field name */
    public transient PKCS12BagAttributeCarrierImpl f6362a = new PKCS12BagAttributeCarrierImpl();

    public BCDSAPrivateKey() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.f6361a = new DSAParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
        this.f6362a = new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f6361a.getP());
        objectOutputStream.writeObject(this.f6361a.getQ());
        objectOutputStream.writeObject(this.f6361a.getG());
    }

    public final ASN1Encodable d(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return this.f6362a.d(aSN1ObjectIdentifier);
    }

    public final Enumeration e() {
        return this.f6362a.e();
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
        this.f6362a.f(aSN1ObjectIdentifier, aSN1Encodable);
    }

    public final String getAlgorithm() {
        return "DSA";
    }

    public final byte[] getEncoded() {
        return KeyUtil.a(new AlgorithmIdentifier(X9ObjectIdentifiers.T0, new DSAParameter(this.f6361a.getP(), this.f6361a.getQ(), this.f6361a.getG()).b()), new ASN1Integer(getX()));
    }

    public final String getFormat() {
        return "PKCS#8";
    }

    public final DSAParams getParams() {
        return this.f6361a;
    }

    public final BigInteger getX() {
        return this.a;
    }

    public final int hashCode() {
        return ((getX().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getQ().hashCode();
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer("DSA Private Key [");
        String str = Strings.a;
        BigInteger modPow = getParams().getG().modPow(this.a, getParams().getP());
        stringBuffer.append(DSAUtil.a(modPow, getParams()));
        stringBuffer.append("]");
        stringBuffer.append(str);
        stringBuffer.append("            y: ");
        stringBuffer.append(modPow.toString(16));
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    public BCDSAPrivateKey(DSAPrivateKey dSAPrivateKey) {
        this.a = dSAPrivateKey.getX();
        this.f6361a = dSAPrivateKey.getParams();
    }

    public BCDSAPrivateKey(DSAPrivateKeySpec dSAPrivateKeySpec) {
        this.a = dSAPrivateKeySpec.getX();
        this.f6361a = new DSAParameterSpec(dSAPrivateKeySpec.getP(), dSAPrivateKeySpec.getQ(), dSAPrivateKeySpec.getG());
    }

    public BCDSAPrivateKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        DSAParameter g = DSAParameter.g(privateKeyInfo.f5702a.a);
        this.a = ((ASN1Integer) privateKeyInfo.h()).t();
        this.f6361a = new DSAParameterSpec(g.a.s(), g.b.s(), g.c.s());
    }

    public BCDSAPrivateKey(DSAPrivateKeyParameters dSAPrivateKeyParameters) {
        this.a = dSAPrivateKeyParameters.a;
        DSAParameters dSAParameters = dSAPrivateKeyParameters.a;
        this.f6361a = new DSAParameterSpec(dSAParameters.c, dSAParameters.b, dSAParameters.a);
    }
}
