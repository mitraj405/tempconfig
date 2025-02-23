package org.spongycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.Enumeration;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.spec.DHParameterSpec;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.oiw.ElGamalParameter;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jce.interfaces.ElGamalPrivateKey;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.spongycastle.jce.spec.ElGamalParameterSpec;

public class JCEElGamalPrivateKey implements ElGamalPrivateKey, DHPrivateKey, PKCS12BagAttributeCarrier {
    static final long serialVersionUID = 4819350091141529678L;
    public BigInteger a;

    /* renamed from: a  reason: collision with other field name */
    public final PKCS12BagAttributeCarrierImpl f6581a = new PKCS12BagAttributeCarrierImpl();

    /* renamed from: a  reason: collision with other field name */
    public ElGamalParameterSpec f6582a;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.a = (BigInteger) objectInputStream.readObject();
        this.f6582a = new ElGamalParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(getX());
        objectOutputStream.writeObject(this.f6582a.a);
        objectOutputStream.writeObject(this.f6582a.b);
    }

    public final ElGamalParameterSpec a() {
        return this.f6582a;
    }

    public final ASN1Encodable d(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return this.f6581a.d(aSN1ObjectIdentifier);
    }

    public final Enumeration e() {
        return this.f6581a.e();
    }

    public final void f(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.f6581a.f(aSN1ObjectIdentifier, aSN1Encodable);
    }

    public final String getAlgorithm() {
        return "ElGamal";
    }

    public final byte[] getEncoded() {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = OIWObjectIdentifiers.i;
        ElGamalParameterSpec elGamalParameterSpec = this.f6582a;
        return KeyUtil.a(new AlgorithmIdentifier(aSN1ObjectIdentifier, new ElGamalParameter(elGamalParameterSpec.a, elGamalParameterSpec.b)), new ASN1Integer(getX()));
    }

    public final String getFormat() {
        return "PKCS#8";
    }

    public final DHParameterSpec getParams() {
        ElGamalParameterSpec elGamalParameterSpec = this.f6582a;
        return new DHParameterSpec(elGamalParameterSpec.a, elGamalParameterSpec.b);
    }

    public final BigInteger getX() {
        return this.a;
    }
}
