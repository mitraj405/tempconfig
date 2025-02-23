package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.BERSequence;

public class ContentInfo extends ASN1Object implements CMSObjectIdentifiers {
    public final ASN1Primitive b() {
        return new BERSequence(C1058d.E((ASN1Encodable) null));
    }
}
