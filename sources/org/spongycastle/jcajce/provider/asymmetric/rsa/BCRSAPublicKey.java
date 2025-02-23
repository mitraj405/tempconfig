package org.spongycastle.jcajce.provider.asymmetric.rsa;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Fingerprint;
import org.spongycastle.util.Strings;

public class BCRSAPublicKey implements RSAPublicKey {
    public static final AlgorithmIdentifier b = new AlgorithmIdentifier(PKCSObjectIdentifiers.a, DERNull.a);
    static final long serialVersionUID = 2675817738516720772L;
    public BigInteger a;

    /* renamed from: a  reason: collision with other field name */
    public transient AlgorithmIdentifier f6454a;

    /* renamed from: b  reason: collision with other field name */
    public BigInteger f6455b;

    public BCRSAPublicKey(RSAKeyParameters rSAKeyParameters) {
        this.f6454a = b;
        this.a = rSAKeyParameters.a;
        this.f6455b = rSAKeyParameters.b;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        try {
            this.f6454a = AlgorithmIdentifier.g(objectInputStream.readObject());
        } catch (Exception unused) {
            this.f6454a = b;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        if (!this.f6454a.equals(b)) {
            objectOutputStream.writeObject(this.f6454a.e());
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RSAPublicKey)) {
            return false;
        }
        RSAPublicKey rSAPublicKey = (RSAPublicKey) obj;
        if (!getModulus().equals(rSAPublicKey.getModulus()) || !getPublicExponent().equals(rSAPublicKey.getPublicExponent())) {
            return false;
        }
        return true;
    }

    public final String getAlgorithm() {
        return "RSA";
    }

    public final byte[] getEncoded() {
        return KeyUtil.b(this.f6454a, new org.spongycastle.asn1.pkcs.RSAPublicKey(getModulus(), getPublicExponent()));
    }

    public final String getFormat() {
        return "X.509";
    }

    public final BigInteger getModulus() {
        return this.a;
    }

    public final BigInteger getPublicExponent() {
        return this.f6455b;
    }

    public final int hashCode() {
        return getModulus().hashCode() ^ getPublicExponent().hashCode();
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer("RSA Public Key [");
        String str = Strings.a;
        BigInteger modulus = getModulus();
        BigInteger publicExponent = getPublicExponent();
        ASN1ObjectIdentifier[] aSN1ObjectIdentifierArr = RSAUtil.a;
        stringBuffer.append(new Fingerprint(Arrays.i(modulus.toByteArray(), publicExponent.toByteArray())).toString());
        stringBuffer.append("]");
        stringBuffer.append(str);
        stringBuffer.append("            modulus: ");
        stringBuffer.append(getModulus().toString(16));
        stringBuffer.append(str);
        stringBuffer.append("    public exponent: ");
        stringBuffer.append(getPublicExponent().toString(16));
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    public BCRSAPublicKey(RSAPublicKeySpec rSAPublicKeySpec) {
        this.f6454a = b;
        this.a = rSAPublicKeySpec.getModulus();
        this.f6455b = rSAPublicKeySpec.getPublicExponent();
    }

    public BCRSAPublicKey(RSAPublicKey rSAPublicKey) {
        this.f6454a = b;
        this.a = rSAPublicKey.getModulus();
        this.f6455b = rSAPublicKey.getPublicExponent();
    }

    public BCRSAPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        org.spongycastle.asn1.pkcs.RSAPublicKey rSAPublicKey;
        try {
            ASN1Primitive h = subjectPublicKeyInfo.h();
            if (h instanceof org.spongycastle.asn1.pkcs.RSAPublicKey) {
                rSAPublicKey = (org.spongycastle.asn1.pkcs.RSAPublicKey) h;
            } else {
                rSAPublicKey = h != null ? new org.spongycastle.asn1.pkcs.RSAPublicKey(ASN1Sequence.q(h)) : null;
            }
            this.f6454a = subjectPublicKeyInfo.f5753a;
            this.a = rSAPublicKey.a;
            this.f6455b = rSAPublicKey.b;
        } catch (IOException unused) {
            throw new IllegalArgumentException("invalid info structure in RSA public key");
        }
    }
}
