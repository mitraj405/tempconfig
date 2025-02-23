package org.spongycastle.jcajce.provider.asymmetric.rsa;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.RSAPrivateKeySpec;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;

public class BCRSAPrivateKey implements RSAPrivateKey, PKCS12BagAttributeCarrier {
    public static final BigInteger c = BigInteger.valueOf(0);
    static final long serialVersionUID = 5110188922551353628L;
    public BigInteger a;

    /* renamed from: a  reason: collision with other field name */
    public transient PKCS12BagAttributeCarrierImpl f6453a = new PKCS12BagAttributeCarrierImpl();
    public BigInteger b;

    public BCRSAPrivateKey() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.f6453a = new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
    }

    public final ASN1Encodable d(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return this.f6453a.d(aSN1ObjectIdentifier);
    }

    public final Enumeration e() {
        return this.f6453a.e();
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
        this.f6453a.f(aSN1ObjectIdentifier, aSN1Encodable);
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

    public BCRSAPrivateKey(RSAKeyParameters rSAKeyParameters) {
        this.a = rSAKeyParameters.a;
        this.b = rSAKeyParameters.b;
    }

    public BCRSAPrivateKey(RSAPrivateKeySpec rSAPrivateKeySpec) {
        this.a = rSAPrivateKeySpec.getModulus();
        this.b = rSAPrivateKeySpec.getPrivateExponent();
    }

    public BCRSAPrivateKey(RSAPrivateKey rSAPrivateKey) {
        this.a = rSAPrivateKey.getModulus();
        this.b = rSAPrivateKey.getPrivateExponent();
    }

    public BCRSAPrivateKey(org.spongycastle.asn1.pkcs.RSAPrivateKey rSAPrivateKey) {
        this.a = rSAPrivateKey.b;
        this.b = rSAPrivateKey.d;
    }
}
