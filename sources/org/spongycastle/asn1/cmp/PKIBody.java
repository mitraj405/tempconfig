package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERTaggedObject;

public class PKIBody extends ASN1Object implements ASN1Choice {
    public final ASN1Primitive b() {
        return new DERTaggedObject(true, 0, (ASN1Encodable) null);
    }
}
