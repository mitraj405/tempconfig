package org.spongycastle.jcajce.provider.asymmetric.dh;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.Enumeration;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPrivateKeySpec;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.pkcs.DHParameter;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x9.DomainParameters;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPrivateKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;

public class BCDHPrivateKey implements DHPrivateKey, PKCS12BagAttributeCarrier {
    static final long serialVersionUID = 311058815616901812L;
    public final BigInteger a;

    /* renamed from: a  reason: collision with other field name */
    public transient DHParameterSpec f6340a;

    /* renamed from: a  reason: collision with other field name */
    public transient PrivateKeyInfo f6341a;

    /* renamed from: a  reason: collision with other field name */
    public transient PKCS12BagAttributeCarrierImpl f6342a = new PKCS12BagAttributeCarrierImpl();

    public BCDHPrivateKey() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.f6340a = new DHParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), objectInputStream.readInt());
        this.f6341a = null;
        this.f6342a = new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f6340a.getP());
        objectOutputStream.writeObject(this.f6340a.getG());
        objectOutputStream.writeInt(this.f6340a.getL());
    }

    public final ASN1Encodable d(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return this.f6342a.d(aSN1ObjectIdentifier);
    }

    public final Enumeration e() {
        return this.f6342a.e();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof DHPrivateKey)) {
            return false;
        }
        DHPrivateKey dHPrivateKey = (DHPrivateKey) obj;
        if (!getX().equals(dHPrivateKey.getX()) || !getParams().getG().equals(dHPrivateKey.getParams().getG()) || !getParams().getP().equals(dHPrivateKey.getParams().getP()) || getParams().getL() != dHPrivateKey.getParams().getL()) {
            return false;
        }
        return true;
    }

    public final void f(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.f6342a.f(aSN1ObjectIdentifier, aSN1Encodable);
    }

    public final String getAlgorithm() {
        return "DH";
    }

    public final byte[] getEncoded() {
        try {
            PrivateKeyInfo privateKeyInfo = this.f6341a;
            if (privateKeyInfo != null) {
                return privateKeyInfo.f("DER");
            }
            return new PrivateKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.p, new DHParameter(this.f6340a.getL(), this.f6340a.getP(), this.f6340a.getG()).b()), new ASN1Integer(getX())).f("DER");
        } catch (Exception unused) {
            return null;
        }
    }

    public final String getFormat() {
        return "PKCS#8";
    }

    public final DHParameterSpec getParams() {
        return this.f6340a;
    }

    public final BigInteger getX() {
        return this.a;
    }

    public final int hashCode() {
        return ((getX().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getL();
    }

    public BCDHPrivateKey(DHPrivateKey dHPrivateKey) {
        this.a = dHPrivateKey.getX();
        this.f6340a = dHPrivateKey.getParams();
    }

    public BCDHPrivateKey(DHPrivateKeySpec dHPrivateKeySpec) {
        this.a = dHPrivateKeySpec.getX();
        this.f6340a = new DHParameterSpec(dHPrivateKeySpec.getP(), dHPrivateKeySpec.getG());
    }

    public BCDHPrivateKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        ASN1Sequence q = ASN1Sequence.q(privateKeyInfo.f5702a.a);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = privateKeyInfo.f5702a.Z0;
        this.f6341a = privateKeyInfo;
        this.a = ((ASN1Integer) privateKeyInfo.h()).t();
        if (aSN1ObjectIdentifier.equals(PKCSObjectIdentifiers.p)) {
            DHParameter h = DHParameter.h(q);
            if (h.i() != null) {
                this.f6340a = new DHParameterSpec(h.k(), h.g(), h.i().intValue());
            } else {
                this.f6340a = new DHParameterSpec(h.k(), h.g());
            }
        } else if (aSN1ObjectIdentifier.equals(X9ObjectIdentifiers.Y0)) {
            DomainParameters g = DomainParameters.g(q);
            this.f6340a = new DHParameterSpec(g.a.s(), g.b.s());
        } else {
            throw new IllegalArgumentException("unknown algorithm type: " + aSN1ObjectIdentifier);
        }
    }

    public BCDHPrivateKey(DHPrivateKeyParameters dHPrivateKeyParameters) {
        this.a = dHPrivateKeyParameters.a;
        DHParameters dHParameters = dHPrivateKeyParameters.a;
        this.f6340a = new DHParameterSpec(dHParameters.b, dHParameters.a, dHParameters.d);
    }
}
