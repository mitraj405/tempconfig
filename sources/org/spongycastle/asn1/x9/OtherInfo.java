package org.spongycastle.asn1.x9;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class OtherInfo extends ASN1Object {
    public final ASN1Primitive b() {
        ASN1EncodableVector E = C1058d.E((ASN1Encodable) null);
        E.a(new DERTaggedObject(2, (ASN1Encodable) null));
        return new DERSequence(E);
    }
}
