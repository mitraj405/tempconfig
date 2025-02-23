package org.spongycastle.jcajce.provider.asymmetric.elgamal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.oiw.ElGamalParameter;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.crypto.params.ElGamalParameters;
import org.spongycastle.crypto.params.ElGamalPublicKeyParameters;
import org.spongycastle.jce.interfaces.ElGamalPublicKey;
import org.spongycastle.jce.spec.ElGamalParameterSpec;
import org.spongycastle.jce.spec.ElGamalPublicKeySpec;

public class BCElGamalPublicKey implements ElGamalPublicKey, DHPublicKey {
    static final long serialVersionUID = 8712728417091216948L;
    public final BigInteger a;

    /* renamed from: a  reason: collision with other field name */
    public transient ElGamalParameterSpec f6438a;

    public BCElGamalPublicKey(ElGamalPublicKeySpec elGamalPublicKeySpec) {
        elGamalPublicKeySpec.getClass();
        this.a = null;
        throw null;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.f6438a = new ElGamalParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f6438a.a);
        objectOutputStream.writeObject(this.f6438a.b);
    }

    public final ElGamalParameterSpec a() {
        return this.f6438a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof DHPublicKey)) {
            return false;
        }
        DHPublicKey dHPublicKey = (DHPublicKey) obj;
        if (!getY().equals(dHPublicKey.getY()) || !getParams().getG().equals(dHPublicKey.getParams().getG()) || !getParams().getP().equals(dHPublicKey.getParams().getP()) || getParams().getL() != dHPublicKey.getParams().getL()) {
            return false;
        }
        return true;
    }

    public final String getAlgorithm() {
        return "ElGamal";
    }

    public final byte[] getEncoded() {
        try {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = OIWObjectIdentifiers.i;
            ElGamalParameterSpec elGamalParameterSpec = this.f6438a;
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(aSN1ObjectIdentifier, new ElGamalParameter(elGamalParameterSpec.a, elGamalParameterSpec.b)), (ASN1Object) new ASN1Integer(this.a)).f("DER");
        } catch (IOException unused) {
            return null;
        }
    }

    public final String getFormat() {
        return "X.509";
    }

    public final DHParameterSpec getParams() {
        ElGamalParameterSpec elGamalParameterSpec = this.f6438a;
        return new DHParameterSpec(elGamalParameterSpec.a, elGamalParameterSpec.b);
    }

    public final BigInteger getY() {
        return this.a;
    }

    public final int hashCode() {
        return ((getY().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getL();
    }

    public BCElGamalPublicKey(DHPublicKeySpec dHPublicKeySpec) {
        this.a = dHPublicKeySpec.getY();
        this.f6438a = new ElGamalParameterSpec(dHPublicKeySpec.getP(), dHPublicKeySpec.getG());
    }

    public BCElGamalPublicKey(ElGamalPublicKey elGamalPublicKey) {
        this.a = elGamalPublicKey.getY();
        this.f6438a = elGamalPublicKey.a();
    }

    public BCElGamalPublicKey(DHPublicKey dHPublicKey) {
        this.a = dHPublicKey.getY();
        this.f6438a = new ElGamalParameterSpec(dHPublicKey.getParams().getP(), dHPublicKey.getParams().getG());
    }

    public BCElGamalPublicKey(ElGamalPublicKeyParameters elGamalPublicKeyParameters) {
        this.a = elGamalPublicKeyParameters.a;
        ElGamalParameters elGamalParameters = elGamalPublicKeyParameters.a;
        this.f6438a = new ElGamalParameterSpec(elGamalParameters.b, elGamalParameters.a);
    }

    public BCElGamalPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        ElGamalParameter g = ElGamalParameter.g(subjectPublicKeyInfo.f5753a.a);
        try {
            this.a = ((ASN1Integer) subjectPublicKeyInfo.h()).t();
            this.f6438a = new ElGamalParameterSpec(g.a.s(), g.b.s());
        } catch (IOException unused) {
            throw new IllegalArgumentException("invalid info structure in DSA public key");
        }
    }
}
