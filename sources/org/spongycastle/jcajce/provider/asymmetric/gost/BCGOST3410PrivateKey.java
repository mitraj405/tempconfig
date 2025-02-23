package org.spongycastle.jcajce.provider.asymmetric.gost;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.crypto.params.GOST3410PrivateKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jce.interfaces.GOST3410Params;
import org.spongycastle.jce.interfaces.GOST3410PrivateKey;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.spongycastle.jce.spec.GOST3410ParameterSpec;
import org.spongycastle.jce.spec.GOST3410PrivateKeySpec;
import org.spongycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;

public class BCGOST3410PrivateKey implements GOST3410PrivateKey, PKCS12BagAttributeCarrier {
    static final long serialVersionUID = 8581661527592305464L;
    public final BigInteger a;

    /* renamed from: a  reason: collision with other field name */
    public transient PKCS12BagAttributeCarrierImpl f6446a = new PKCS12BagAttributeCarrierImpl();

    /* renamed from: a  reason: collision with other field name */
    public transient GOST3410Params f6447a;

    public BCGOST3410PrivateKey() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        String str = (String) objectInputStream.readObject();
        if (str != null) {
            this.f6447a = new GOST3410ParameterSpec(str, (String) objectInputStream.readObject(), (String) objectInputStream.readObject());
        } else {
            this.f6447a = new GOST3410ParameterSpec(new GOST3410PublicKeyParameterSetSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject()));
            objectInputStream.readObject();
            objectInputStream.readObject();
        }
        this.f6446a = new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        if (this.f6447a.d() != null) {
            objectOutputStream.writeObject(this.f6447a.d());
            objectOutputStream.writeObject(this.f6447a.c());
            objectOutputStream.writeObject(this.f6447a.b());
            return;
        }
        objectOutputStream.writeObject((Object) null);
        objectOutputStream.writeObject(this.f6447a.a().a);
        objectOutputStream.writeObject(this.f6447a.a().b);
        objectOutputStream.writeObject(this.f6447a.a().c);
        objectOutputStream.writeObject(this.f6447a.c());
        objectOutputStream.writeObject(this.f6447a.b());
    }

    public final GOST3410Params a() {
        return this.f6447a;
    }

    public final ASN1Encodable d(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return this.f6446a.d(aSN1ObjectIdentifier);
    }

    public final Enumeration e() {
        return this.f6446a.e();
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (!(obj instanceof GOST3410PrivateKey)) {
            return false;
        }
        GOST3410PrivateKey gOST3410PrivateKey = (GOST3410PrivateKey) obj;
        if (!this.a.equals(gOST3410PrivateKey.getX()) || !this.f6447a.a().equals(gOST3410PrivateKey.a().a()) || !this.f6447a.c().equals(gOST3410PrivateKey.a().c())) {
            return false;
        }
        String b = this.f6447a.b();
        String b2 = gOST3410PrivateKey.a().b();
        if (b == b2) {
            z = true;
        } else if (b == null) {
            z = false;
        } else {
            z = b.equals(b2);
        }
        if (z) {
            return true;
        }
        return false;
    }

    public final void f(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.f6446a.f(aSN1ObjectIdentifier, aSN1Encodable);
    }

    public final String getAlgorithm() {
        return "GOST3410";
    }

    public final byte[] getEncoded() {
        byte[] bArr;
        PrivateKeyInfo privateKeyInfo;
        byte[] byteArray = this.a.toByteArray();
        if (byteArray[0] == 0) {
            bArr = new byte[(byteArray.length - 1)];
        } else {
            bArr = new byte[byteArray.length];
        }
        for (int i = 0; i != bArr.length; i++) {
            bArr[i] = byteArray[(byteArray.length - 1) - i];
        }
        try {
            if (this.f6447a instanceof GOST3410ParameterSpec) {
                privateKeyInfo = new PrivateKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.k, new GOST3410PublicKeyAlgParameters(new ASN1ObjectIdentifier(this.f6447a.d()), new ASN1ObjectIdentifier(this.f6447a.c()))), new DEROctetString(bArr));
            } else {
                privateKeyInfo = new PrivateKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.k), new DEROctetString(bArr));
            }
            return privateKeyInfo.f("DER");
        } catch (IOException unused) {
            return null;
        }
    }

    public final String getFormat() {
        return "PKCS#8";
    }

    public final BigInteger getX() {
        return this.a;
    }

    public final int hashCode() {
        return this.a.hashCode() ^ this.f6447a.hashCode();
    }

    public BCGOST3410PrivateKey(GOST3410PrivateKey gOST3410PrivateKey) {
        this.a = gOST3410PrivateKey.getX();
        this.f6447a = gOST3410PrivateKey.a();
    }

    public BCGOST3410PrivateKey(GOST3410PrivateKeySpec gOST3410PrivateKeySpec) {
        this.a = gOST3410PrivateKeySpec.a;
        this.f6447a = new GOST3410ParameterSpec(new GOST3410PublicKeyParameterSetSpec(gOST3410PrivateKeySpec.b, gOST3410PrivateKeySpec.c, gOST3410PrivateKeySpec.d));
    }

    public BCGOST3410PrivateKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        GOST3410PublicKeyAlgParameters gOST3410PublicKeyAlgParameters = new GOST3410PublicKeyAlgParameters((ASN1Sequence) privateKeyInfo.f5702a.a);
        byte[] s = ASN1OctetString.q(privateKeyInfo.h()).s();
        byte[] bArr = new byte[s.length];
        for (int i = 0; i != s.length; i++) {
            bArr[i] = s[(s.length - 1) - i];
        }
        this.a = new BigInteger(1, bArr);
        this.f6447a = GOST3410ParameterSpec.e(gOST3410PublicKeyAlgParameters);
    }

    public BCGOST3410PrivateKey(GOST3410PrivateKeyParameters gOST3410PrivateKeyParameters, GOST3410ParameterSpec gOST3410ParameterSpec) {
        this.a = gOST3410PrivateKeyParameters.a;
        this.f6447a = gOST3410ParameterSpec;
        if (gOST3410ParameterSpec == null) {
            throw new IllegalArgumentException("spec is null");
        }
    }
}
