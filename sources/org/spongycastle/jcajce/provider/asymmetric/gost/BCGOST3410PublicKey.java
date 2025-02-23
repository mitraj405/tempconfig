package org.spongycastle.jcajce.provider.asymmetric.gost;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.crypto.params.GOST3410PublicKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.spongycastle.jce.interfaces.GOST3410Params;
import org.spongycastle.jce.interfaces.GOST3410PublicKey;
import org.spongycastle.jce.spec.GOST3410ParameterSpec;
import org.spongycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;
import org.spongycastle.jce.spec.GOST3410PublicKeySpec;
import org.spongycastle.util.Strings;

public class BCGOST3410PublicKey implements GOST3410PublicKey {
    static final long serialVersionUID = -6251023343619275990L;
    public final BigInteger a;

    /* renamed from: a  reason: collision with other field name */
    public transient GOST3410Params f6448a;

    public BCGOST3410PublicKey(GOST3410PublicKeySpec gOST3410PublicKeySpec) {
        this.a = gOST3410PublicKeySpec.a;
        this.f6448a = new GOST3410ParameterSpec(new GOST3410PublicKeyParameterSetSpec(gOST3410PublicKeySpec.b, gOST3410PublicKeySpec.c, gOST3410PublicKeySpec.d));
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        String str = (String) objectInputStream.readObject();
        if (str != null) {
            this.f6448a = new GOST3410ParameterSpec(str, (String) objectInputStream.readObject(), (String) objectInputStream.readObject());
            return;
        }
        this.f6448a = new GOST3410ParameterSpec(new GOST3410PublicKeyParameterSetSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject()));
        objectInputStream.readObject();
        objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        if (this.f6448a.d() != null) {
            objectOutputStream.writeObject(this.f6448a.d());
            objectOutputStream.writeObject(this.f6448a.c());
            objectOutputStream.writeObject(this.f6448a.b());
            return;
        }
        objectOutputStream.writeObject((Object) null);
        objectOutputStream.writeObject(this.f6448a.a().a);
        objectOutputStream.writeObject(this.f6448a.a().b);
        objectOutputStream.writeObject(this.f6448a.a().c);
        objectOutputStream.writeObject(this.f6448a.c());
        objectOutputStream.writeObject(this.f6448a.b());
    }

    public final GOST3410Params a() {
        return this.f6448a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof BCGOST3410PublicKey)) {
            return false;
        }
        BCGOST3410PublicKey bCGOST3410PublicKey = (BCGOST3410PublicKey) obj;
        if (!this.a.equals(bCGOST3410PublicKey.a) || !this.f6448a.equals(bCGOST3410PublicKey.f6448a)) {
            return false;
        }
        return true;
    }

    public final String getAlgorithm() {
        return "GOST3410";
    }

    public final byte[] getEncoded() {
        byte[] bArr;
        SubjectPublicKeyInfo subjectPublicKeyInfo;
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
            GOST3410Params gOST3410Params = this.f6448a;
            if (!(gOST3410Params instanceof GOST3410ParameterSpec)) {
                subjectPublicKeyInfo = new SubjectPublicKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.k), (ASN1Object) new DEROctetString(bArr));
            } else if (gOST3410Params.b() != null) {
                subjectPublicKeyInfo = new SubjectPublicKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.k, new GOST3410PublicKeyAlgParameters(new ASN1ObjectIdentifier(this.f6448a.d()), new ASN1ObjectIdentifier(this.f6448a.c()), new ASN1ObjectIdentifier(this.f6448a.b()))), (ASN1Object) new DEROctetString(bArr));
            } else {
                subjectPublicKeyInfo = new SubjectPublicKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.k, new GOST3410PublicKeyAlgParameters(new ASN1ObjectIdentifier(this.f6448a.d()), new ASN1ObjectIdentifier(this.f6448a.c()))), (ASN1Object) new DEROctetString(bArr));
            }
            return KeyUtil.c(subjectPublicKeyInfo);
        } catch (IOException unused) {
            return null;
        }
    }

    public final String getFormat() {
        return "X.509";
    }

    public final BigInteger getY() {
        return this.a;
    }

    public final int hashCode() {
        return this.a.hashCode() ^ this.f6448a.hashCode();
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer("GOST3410 Public Key");
        String str = Strings.a;
        stringBuffer.append(str);
        stringBuffer.append("            y: ");
        stringBuffer.append(this.a.toString(16));
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    public BCGOST3410PublicKey(GOST3410PublicKey gOST3410PublicKey) {
        this.a = gOST3410PublicKey.getY();
        this.f6448a = gOST3410PublicKey.a();
    }

    public BCGOST3410PublicKey(GOST3410PublicKeyParameters gOST3410PublicKeyParameters, GOST3410ParameterSpec gOST3410ParameterSpec) {
        this.a = gOST3410PublicKeyParameters.a;
        this.f6448a = gOST3410ParameterSpec;
    }

    public BCGOST3410PublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        GOST3410PublicKeyAlgParameters gOST3410PublicKeyAlgParameters = new GOST3410PublicKeyAlgParameters((ASN1Sequence) subjectPublicKeyInfo.f5753a.a);
        try {
            byte[] bArr = ((DEROctetString) subjectPublicKeyInfo.h()).a;
            byte[] bArr2 = new byte[bArr.length];
            for (int i = 0; i != bArr.length; i++) {
                bArr2[i] = bArr[(bArr.length - 1) - i];
            }
            this.a = new BigInteger(1, bArr2);
            this.f6448a = GOST3410ParameterSpec.e(gOST3410PublicKeyAlgParameters);
        } catch (IOException unused) {
            throw new IllegalArgumentException("invalid info structure in GOST3410 public key");
        }
    }
}
