package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class AccessDescription extends ASN1Object {
    static {
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.48.2");
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.48.1");
    }

    public final ASN1Primitive b() {
        return new DERSequence(xx.M((ASN1Encodable) null, (ASN1Encodable) null));
    }

    public final String toString() {
        throw null;
    }
}
