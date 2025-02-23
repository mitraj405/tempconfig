package org.spongycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateKey;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;

public class JCERSAPrivateKey implements RSAPrivateKey, PKCS12BagAttributeCarrier {
    public static final BigInteger c = BigInteger.valueOf(0);
    static final long serialVersionUID = 5110188922551353628L;
    public BigInteger a;

    /* renamed from: a  reason: collision with other field name */
    public transient PKCS12BagAttributeCarrierImpl f6584a = new PKCS12BagAttributeCarrierImpl();
    public BigInteger b;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.a = (BigInteger) objectInputStream.readObject();
        PKCS12BagAttributeCarrierImpl pKCS12BagAttributeCarrierImpl = new PKCS12BagAttributeCarrierImpl();
        this.f6584a = pKCS12BagAttributeCarrierImpl;
        pKCS12BagAttributeCarrierImpl.a(objectInputStream);
        this.b = (BigInteger) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.a);
        this.f6584a.b(objectOutputStream);
        objectOutputStream.writeObject(this.b);
    }

    public final ASN1Encodable d(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return this.f6584a.d(aSN1ObjectIdentifier);
    }

    public final Enumeration e() {
        return this.f6584a.e();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RSAPrivateKey)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) obj;
        if (!getModulus().equals(rSAPrivateKey.getModulus()) || !getPrivateExponent().equals(rSAPrivateKey.getPrivateExponent())) {
            return false;
        }
        return true;
    }

    public final void f(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.f6584a.f(aSN1ObjectIdentifier, aSN1Encodable);
    }

    public final String getAlgorithm() {
        return "RSA";
    }

    public byte[] getEncoded() {
        AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(PKCSObjectIdentifiers.a, DERNull.a);
        BigInteger modulus = getModulus();
        BigInteger bigInteger = c;
        return KeyUtil.a(algorithmIdentifier, new org.spongycastle.asn1.pkcs.RSAPrivateKey(modulus, bigInteger, getPrivateExponent(), bigInteger, bigInteger, bigInteger, bigInteger, bigInteger));
    }

    public String getFormat() {
        return "PKCS#8";
    }

    public final BigInteger getModulus() {
        return this.a;
    }

    public final BigInteger getPrivateExponent() {
        return this.b;
    }

    public int hashCode() {
        return getModulus().hashCode() ^ getPrivateExponent().hashCode();
    }
}
