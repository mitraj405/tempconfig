package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.BERSequence;

public class EncryptedData extends ASN1Object {
    public final ASN1Primitive b() {
        return new BERSequence(xx.M((ASN1Encodable) null, (ASN1Encodable) null));
    }
}
