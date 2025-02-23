package org.spongycastle.jcajce.provider.asymmetric.dsa;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAParameterSpec;
import java.security.spec.DSAPublicKeySpec;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.DSAParameter;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.crypto.params.DSAParameters;
import org.spongycastle.crypto.params.DSAPublicKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.spongycastle.util.Strings;

public class BCDSAPublicKey implements DSAPublicKey {
    public static final BigInteger b = BigInteger.valueOf(0);
    private static final long serialVersionUID = 1752452449903495175L;
    public final BigInteger a;

    /* renamed from: a  reason: collision with other field name */
    public transient DSAParams f6363a;

    /* renamed from: a  reason: collision with other field name */
    public transient DSAPublicKeyParameters f6364a;

    public BCDSAPublicKey(DSAPublicKeySpec dSAPublicKeySpec) {
        BigInteger y = dSAPublicKeySpec.getY();
        this.a = y;
        this.f6363a = new DSAParameterSpec(dSAPublicKeySpec.getP(), dSAPublicKeySpec.getQ(), dSAPublicKeySpec.getG());
        this.f6364a = new DSAPublicKeyParameters(y, DSAUtil.b(this.f6363a));
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        BigInteger bigInteger = (BigInteger) objectInputStream.readObject();
        if (bigInteger.equals(b)) {
            this.f6363a = null;
        } else {
            this.f6363a = new DSAParameterSpec(bigInteger, (BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
        }
        this.f6364a = new DSAPublicKeyParameters(this.a, DSAUtil.b(this.f6363a));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        DSAParams dSAParams = this.f6363a;
        if (dSAParams == null) {
            objectOutputStream.writeObject(b);
            return;
        }
        objectOutputStream.writeObject(dSAParams.getP());
        objectOutputStream.writeObject(this.f6363a.getQ());
        objectOutputStream.writeObject(this.f6363a.getG());
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof DSAPublicKey)) {
            return false;
        }
        DSAPublicKey dSAPublicKey = (DSAPublicKey) obj;
        if (this.f6363a != null) {
            if (!getY().equals(dSAPublicKey.getY()) || dSAPublicKey.getParams() == null || !getParams().getG().equals(dSAPublicKey.getParams().getG()) || !getParams().getP().equals(dSAPublicKey.getParams().getP()) || !getParams().getQ().equals(dSAPublicKey.getParams().getQ())) {
                return false;
            }
            return true;
        } else if (!getY().equals(dSAPublicKey.getY()) || dSAPublicKey.getParams() != null) {
            return false;
        } else {
            return true;
        }
    }

    public final String getAlgorithm() {
        return "DSA";
    }

    public final byte[] getEncoded() {
        DSAParams dSAParams = this.f6363a;
        BigInteger bigInteger = this.a;
        if (dSAParams == null) {
            return KeyUtil.b(new AlgorithmIdentifier(X9ObjectIdentifiers.T0), new ASN1Integer(bigInteger));
        }
        return KeyUtil.b(new AlgorithmIdentifier(X9ObjectIdentifiers.T0, new DSAParameter(dSAParams.getP(), this.f6363a.getQ(), this.f6363a.getG()).b()), new ASN1Integer(bigInteger));
    }

    public final String getFormat() {
        return "X.509";
    }

    public final DSAParams getParams() {
        return this.f6363a;
    }

    public final BigInteger getY() {
        return this.a;
    }

    public final int hashCode() {
        if (this.f6363a != null) {
            return ((getY().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getQ().hashCode();
        }
        return getY().hashCode();
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer("DSA Public Key [");
        String str = Strings.a;
        stringBuffer.append(DSAUtil.a(this.a, getParams()));
        stringBuffer.append("]");
        stringBuffer.append(str);
        stringBuffer.append("            y: ");
        stringBuffer.append(getY().toString(16));
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    public BCDSAPublicKey(DSAPublicKey dSAPublicKey) {
        BigInteger y = dSAPublicKey.getY();
        this.a = y;
        this.f6363a = dSAPublicKey.getParams();
        this.f6364a = new DSAPublicKeyParameters(y, DSAUtil.b(this.f6363a));
    }

    public BCDSAPublicKey(DSAPublicKeyParameters dSAPublicKeyParameters) {
        this.a = dSAPublicKeyParameters.a;
        DSAParameters dSAParameters = dSAPublicKeyParameters.a;
        this.f6363a = new DSAParameterSpec(dSAParameters.c, dSAParameters.b, dSAParameters.a);
        this.f6364a = dSAPublicKeyParameters;
    }

    public BCDSAPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        try {
            BigInteger t = ((ASN1Integer) subjectPublicKeyInfo.h()).t();
            this.a = t;
            AlgorithmIdentifier algorithmIdentifier = subjectPublicKeyInfo.f5753a;
            ASN1Encodable aSN1Encodable = algorithmIdentifier.a;
            if (aSN1Encodable != null && !DERNull.a.equals(aSN1Encodable.b())) {
                DSAParameter g = DSAParameter.g(algorithmIdentifier.a);
                this.f6363a = new DSAParameterSpec(g.a.s(), g.b.s(), g.c.s());
            } else {
                this.f6363a = null;
            }
            this.f6364a = new DSAPublicKeyParameters(t, DSAUtil.b(this.f6363a));
        } catch (IOException unused) {
            throw new IllegalArgumentException("invalid info structure in DSA public key");
        }
    }
}
