package org.spongycastle.asn1.dvcs;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class DVCSRequest extends ASN1Object {
    public final ASN1Primitive b() {
        return new DERSequence(xx.M((ASN1Encodable) null, (ASN1Encodable) null));
    }

    public final String toString() {
        return lf.j("DVCSRequest {\nrequestInformation: null\ndata: null\n", "", "}\n");
    }
}
