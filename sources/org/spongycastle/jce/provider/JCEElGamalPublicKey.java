package org.spongycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.oiw.ElGamalParameter;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.spongycastle.jce.interfaces.ElGamalPublicKey;
import org.spongycastle.jce.spec.ElGamalParameterSpec;

public class JCEElGamalPublicKey implements ElGamalPublicKey, DHPublicKey {
    static final long serialVersionUID = 8712728417091216948L;
    public BigInteger a;

    /* renamed from: a  reason: collision with other field name */
    public ElGamalParameterSpec f6583a;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.a = (BigInteger) objectInputStream.readObject();
        this.f6583a = new ElGamalParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(getY());
        objectOutputStream.writeObject(this.f6583a.a);
        objectOutputStream.writeObject(this.f6583a.b);
    }

    public final ElGamalParameterSpec a() {
        return this.f6583a;
    }

    public final String getAlgorithm() {
        return "ElGamal";
    }

    public final byte[] getEncoded() {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = OIWObjectIdentifiers.i;
        ElGamalParameterSpec elGamalParameterSpec = this.f6583a;
        return KeyUtil.b(new AlgorithmIdentifier(aSN1ObjectIdentifier, new ElGamalParameter(elGamalParameterSpec.a, elGamalParameterSpec.b)), new ASN1Integer(this.a));
    }

    public final String getFormat() {
        return "X.509";
    }

    public final DHParameterSpec getParams() {
        ElGamalParameterSpec elGamalParameterSpec = this.f6583a;
        return new DHParameterSpec(elGamalParameterSpec.a, elGamalParameterSpec.b);
    }

    public final BigInteger getY() {
        return this.a;
    }
}
