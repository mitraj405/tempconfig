package org.spongycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.pkcs.DHParameter;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;

public class JCEDHPublicKey implements DHPublicKey {
    static final long serialVersionUID = -216691575254424324L;
    public BigInteger a;

    /* renamed from: a  reason: collision with other field name */
    public DHParameterSpec f6573a;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.a = (BigInteger) objectInputStream.readObject();
        this.f6573a = new DHParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), objectInputStream.readInt());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(getY());
        objectOutputStream.writeObject(this.f6573a.getP());
        objectOutputStream.writeObject(this.f6573a.getG());
        objectOutputStream.writeInt(this.f6573a.getL());
    }

    public final String getAlgorithm() {
        return "DH";
    }

    public final byte[] getEncoded() {
        return KeyUtil.b(new AlgorithmIdentifier(PKCSObjectIdentifiers.p, new DHParameter(this.f6573a.getL(), this.f6573a.getP(), this.f6573a.getG())), new ASN1Integer(this.a));
    }

    public final String getFormat() {
        return "X.509";
    }

    public final DHParameterSpec getParams() {
        return this.f6573a;
    }

    public final BigInteger getY() {
        return this.a;
    }
}
