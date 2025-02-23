package org.spongycastle.asn1.x509;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Boolean;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;

public class X509Extensions extends ASN1Object {
    public static final ASN1ObjectIdentifier Z0 = new ASN1ObjectIdentifier("2.5.29.27");
    public static final ASN1ObjectIdentifier a1 = new ASN1ObjectIdentifier("2.5.29.28");
    public static final ASN1ObjectIdentifier b1 = new ASN1ObjectIdentifier("2.5.29.56");
    public final Hashtable a = new Hashtable();

    /* renamed from: a  reason: collision with other field name */
    public final Vector f5775a = new Vector();

    static {
        new ASN1ObjectIdentifier("2.5.29.9");
        new ASN1ObjectIdentifier("2.5.29.14");
        new ASN1ObjectIdentifier("2.5.29.15");
        new ASN1ObjectIdentifier("2.5.29.16");
        new ASN1ObjectIdentifier("2.5.29.17");
        new ASN1ObjectIdentifier("2.5.29.18");
        new ASN1ObjectIdentifier("2.5.29.19");
        new ASN1ObjectIdentifier("2.5.29.20");
        new ASN1ObjectIdentifier("2.5.29.21");
        new ASN1ObjectIdentifier("2.5.29.23");
        new ASN1ObjectIdentifier("2.5.29.24");
        new ASN1ObjectIdentifier("2.5.29.29");
        new ASN1ObjectIdentifier("2.5.29.30");
        new ASN1ObjectIdentifier("2.5.29.31");
        new ASN1ObjectIdentifier("2.5.29.32");
        new ASN1ObjectIdentifier("2.5.29.33");
        new ASN1ObjectIdentifier("2.5.29.35");
        new ASN1ObjectIdentifier("2.5.29.36");
        new ASN1ObjectIdentifier("2.5.29.37");
        new ASN1ObjectIdentifier("2.5.29.46");
        new ASN1ObjectIdentifier("2.5.29.54");
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.1");
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.11");
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.12");
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.2");
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.3");
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.4");
        new ASN1ObjectIdentifier("2.5.29.55");
    }

    public X509Extensions(ASN1Sequence aSN1Sequence) {
        Enumeration t = aSN1Sequence.t();
        while (t.hasMoreElements()) {
            ASN1Sequence q = ASN1Sequence.q(t.nextElement());
            if (q.size() == 3) {
                this.a.put(q.s(0), new X509Extension(ASN1Boolean.r(q.s(1)), ASN1OctetString.q(q.s(2))));
            } else if (q.size() == 2) {
                this.a.put(q.s(0), new X509Extension(ASN1OctetString.q(q.s(1))));
            } else {
                throw new IllegalArgumentException(C0709Uj.k(q, new StringBuilder("Bad sequence size: ")));
            }
            this.f5775a.addElement(q.s(0));
        }
    }

    public static X509Extensions g(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive == null || (aSN1Primitive instanceof X509Extensions)) {
            return (X509Extensions) aSN1Primitive;
        }
        if (aSN1Primitive instanceof ASN1Sequence) {
            return new X509Extensions((ASN1Sequence) aSN1Primitive);
        }
        if (aSN1Primitive instanceof Extensions) {
            return new X509Extensions((ASN1Sequence) ((Extensions) aSN1Primitive).b());
        }
        if (aSN1Primitive instanceof ASN1TaggedObject) {
            return g(((ASN1TaggedObject) aSN1Primitive).r());
        }
        throw new IllegalArgumentException("illegal object in getInstance: ".concat(aSN1Primitive.getClass().getName()));
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        Enumeration elements = this.f5775a.elements();
        while (elements.hasMoreElements()) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) elements.nextElement();
            X509Extension x509Extension = (X509Extension) this.a.get(aSN1ObjectIdentifier);
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            aSN1EncodableVector2.a(aSN1ObjectIdentifier);
            if (x509Extension.f5774a) {
                aSN1EncodableVector2.a(ASN1Boolean.b);
            }
            aSN1EncodableVector2.a(x509Extension.f5773a);
            aSN1EncodableVector.a(new DERSequence(aSN1EncodableVector2));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
