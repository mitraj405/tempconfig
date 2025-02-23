package org.spongycastle.jcajce.provider.asymmetric.rsa;

import java.math.BigInteger;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.RSAPrivateCrtKeySpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.RSAPrivateKey;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Fingerprint;
import org.spongycastle.util.Strings;

public class BCRSAPrivateCrtKey extends BCRSAPrivateKey implements RSAPrivateCrtKey {
    static final long serialVersionUID = 7834723820638524718L;
    public final BigInteger d;
    public final BigInteger e;
    public final BigInteger f;
    public final BigInteger g;
    public final BigInteger h;
    public final BigInteger i;

    public BCRSAPrivateCrtKey(RSAPrivateCrtKeyParameters rSAPrivateCrtKeyParameters) {
        super((RSAKeyParameters) rSAPrivateCrtKeyParameters);
        this.d = rSAPrivateCrtKeyParameters.d;
        this.e = rSAPrivateCrtKeyParameters.e;
        this.f = rSAPrivateCrtKeyParameters.f;
        this.g = rSAPrivateCrtKeyParameters.g;
        this.h = rSAPrivateCrtKeyParameters.h;
        this.i = rSAPrivateCrtKeyParameters.i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RSAPrivateCrtKey)) {
            return false;
        }
        RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) obj;
        if (!getModulus().equals(rSAPrivateCrtKey.getModulus()) || !getPublicExponent().equals(rSAPrivateCrtKey.getPublicExponent()) || !getPrivateExponent().equals(rSAPrivateCrtKey.getPrivateExponent()) || !getPrimeP().equals(rSAPrivateCrtKey.getPrimeP()) || !getPrimeQ().equals(rSAPrivateCrtKey.getPrimeQ()) || !getPrimeExponentP().equals(rSAPrivateCrtKey.getPrimeExponentP()) || !getPrimeExponentQ().equals(rSAPrivateCrtKey.getPrimeExponentQ()) || !getCrtCoefficient().equals(rSAPrivateCrtKey.getCrtCoefficient())) {
            return false;
        }
        return true;
    }

    public final BigInteger getCrtCoefficient() {
        return this.i;
    }

    public final byte[] getEncoded() {
        return KeyUtil.a(new AlgorithmIdentifier(PKCSObjectIdentifiers.a, DERNull.a), new RSAPrivateKey(getModulus(), getPublicExponent(), getPrivateExponent(), getPrimeP(), getPrimeQ(), getPrimeExponentP(), getPrimeExponentQ(), getCrtCoefficient()));
    }

    public final String getFormat() {
        return "PKCS#8";
    }

    public final BigInteger getPrimeExponentP() {
        return this.g;
    }

    public final BigInteger getPrimeExponentQ() {
        return this.h;
    }

    public final BigInteger getPrimeP() {
        return this.e;
    }

    public final BigInteger getPrimeQ() {
        return this.f;
    }

    public final BigInteger getPublicExponent() {
        return this.d;
    }

    public final int hashCode() {
        return (getModulus().hashCode() ^ getPublicExponent().hashCode()) ^ getPrivateExponent().hashCode();
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer("RSA Private CRT Key [");
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

    public BCRSAPrivateCrtKey(RSAPrivateCrtKeySpec rSAPrivateCrtKeySpec) {
        this.a = rSAPrivateCrtKeySpec.getModulus();
        this.d = rSAPrivateCrtKeySpec.getPublicExponent();
        this.b = rSAPrivateCrtKeySpec.getPrivateExponent();
        this.e = rSAPrivateCrtKeySpec.getPrimeP();
        this.f = rSAPrivateCrtKeySpec.getPrimeQ();
        this.g = rSAPrivateCrtKeySpec.getPrimeExponentP();
        this.h = rSAPrivateCrtKeySpec.getPrimeExponentQ();
        this.i = rSAPrivateCrtKeySpec.getCrtCoefficient();
    }

    public BCRSAPrivateCrtKey(RSAPrivateCrtKey rSAPrivateCrtKey) {
        this.a = rSAPrivateCrtKey.getModulus();
        this.d = rSAPrivateCrtKey.getPublicExponent();
        this.b = rSAPrivateCrtKey.getPrivateExponent();
        this.e = rSAPrivateCrtKey.getPrimeP();
        this.f = rSAPrivateCrtKey.getPrimeQ();
        this.g = rSAPrivateCrtKey.getPrimeExponentP();
        this.h = rSAPrivateCrtKey.getPrimeExponentQ();
        this.i = rSAPrivateCrtKey.getCrtCoefficient();
    }

    public BCRSAPrivateCrtKey(RSAPrivateKey rSAPrivateKey) {
        this.a = rSAPrivateKey.b;
        this.d = rSAPrivateKey.c;
        this.b = rSAPrivateKey.d;
        this.e = rSAPrivateKey.e;
        this.f = rSAPrivateKey.f;
        this.g = rSAPrivateKey.g;
        this.h = rSAPrivateKey.h;
        this.i = rSAPrivateKey.i;
    }
}
