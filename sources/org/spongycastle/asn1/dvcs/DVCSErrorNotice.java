package org.spongycastle.asn1.dvcs;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class DVCSErrorNotice extends ASN1Object {
    public final ASN1Primitive b() {
        return new DERSequence(C1058d.E((ASN1Encodable) null));
    }

    public final String toString() {
        return lf.j("DVCSErrorNotice {\ntransactionStatus: null\n", "", "}\n");
    }
}
