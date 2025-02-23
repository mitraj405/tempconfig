package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class PasswordRecipientInfo extends ASN1Object {
    public final ASN1Primitive b() {
        return new DERSequence(C1058d.F((ASN1Encodable) null, (ASN1Encodable) null, (ASN1Encodable) null));
    }
}
