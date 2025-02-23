package org.spongycastle.jcajce.provider.asymmetric.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OutputStream;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;

public class PKCS12BagAttributeCarrierImpl implements PKCS12BagAttributeCarrier {
    public Hashtable a;

    /* renamed from: a  reason: collision with other field name */
    public Vector f6482a;

    public PKCS12BagAttributeCarrierImpl() {
        Hashtable hashtable = new Hashtable();
        Vector vector = new Vector();
        this.a = hashtable;
        this.f6482a = vector;
    }

    public final void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Object readObject = objectInputStream.readObject();
        if (readObject instanceof Hashtable) {
            this.a = (Hashtable) readObject;
            this.f6482a = (Vector) objectInputStream.readObject();
            return;
        }
        ASN1InputStream aSN1InputStream = new ASN1InputStream((byte[]) readObject);
        while (true) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) aSN1InputStream.j();
            if (aSN1ObjectIdentifier != null) {
                f(aSN1ObjectIdentifier, aSN1InputStream.j());
            } else {
                return;
            }
        }
    }

    public final void b(ObjectOutputStream objectOutputStream) throws IOException {
        if (this.f6482a.size() == 0) {
            objectOutputStream.writeObject(new Hashtable());
            objectOutputStream.writeObject(new Vector());
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ASN1OutputStream aSN1OutputStream = new ASN1OutputStream(byteArrayOutputStream);
        Enumeration e = e();
        while (e.hasMoreElements()) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) e.nextElement();
            aSN1OutputStream.g(aSN1ObjectIdentifier);
            aSN1OutputStream.g((ASN1Encodable) this.a.get(aSN1ObjectIdentifier));
        }
        objectOutputStream.writeObject(byteArrayOutputStream.toByteArray());
    }

    public final ASN1Encodable d(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (ASN1Encodable) this.a.get(aSN1ObjectIdentifier);
    }

    public final Enumeration e() {
        return this.f6482a.elements();
    }

    public final void f(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        if (this.a.containsKey(aSN1ObjectIdentifier)) {
            this.a.put(aSN1ObjectIdentifier, aSN1Encodable);
            return;
        }
        this.a.put(aSN1ObjectIdentifier, aSN1Encodable);
        this.f6482a.addElement(aSN1ObjectIdentifier);
    }
}
