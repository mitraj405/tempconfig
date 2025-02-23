package org.spongycastle.asn1.x509;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class Extensions extends ASN1Object {
    public final Hashtable a = new Hashtable();

    /* renamed from: a  reason: collision with other field name */
    public final Vector f5741a = new Vector();

    public Extensions(ASN1Sequence aSN1Sequence) {
        Extension extension;
        Enumeration t = aSN1Sequence.t();
        while (t.hasMoreElements()) {
            Object nextElement = t.nextElement();
            ASN1ObjectIdentifier aSN1ObjectIdentifier = Extension.a1;
            if (nextElement instanceof Extension) {
                extension = (Extension) nextElement;
            } else if (nextElement != null) {
                extension = new Extension(ASN1Sequence.q(nextElement));
            } else {
                extension = null;
            }
            boolean containsKey = this.a.containsKey(extension.Z0);
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = extension.Z0;
            if (!containsKey) {
                this.a.put(aSN1ObjectIdentifier2, extension);
                this.f5741a.addElement(aSN1ObjectIdentifier2);
            } else {
                throw new IllegalArgumentException("repeated extension found: " + aSN1ObjectIdentifier2);
            }
        }
    }

    public static Extensions h(ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable instanceof Extensions) {
            return (Extensions) aSN1Encodable;
        }
        if (aSN1Encodable != null) {
            return new Extensions(ASN1Sequence.q(aSN1Encodable));
        }
        return null;
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        Enumeration elements = this.f5741a.elements();
        while (elements.hasMoreElements()) {
            aSN1EncodableVector.a((Extension) this.a.get((ASN1ObjectIdentifier) elements.nextElement()));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public final Extension g(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (Extension) this.a.get(aSN1ObjectIdentifier);
    }

    public final Enumeration i() {
        return this.f5741a.elements();
    }
}
