package org.spongycastle.x509;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.x509.Attribute;

public class X509Attribute extends ASN1Object {
    public final Attribute a;

    public X509Attribute(ASN1Encodable aSN1Encodable) {
        Attribute attribute;
        if (aSN1Encodable instanceof Attribute) {
            attribute = (Attribute) aSN1Encodable;
        } else if (aSN1Encodable != null) {
            attribute = new Attribute(ASN1Sequence.q(aSN1Encodable));
        } else {
            attribute = null;
        }
        this.a = attribute;
    }

    public final ASN1Primitive b() {
        return this.a.b();
    }
}
