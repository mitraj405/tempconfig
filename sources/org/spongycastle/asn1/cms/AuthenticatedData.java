package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.BERSequence;

public class AuthenticatedData extends ASN1Object {
    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a((ASN1Encodable) null);
        aSN1EncodableVector.a((ASN1Encodable) null);
        aSN1EncodableVector.a((ASN1Encodable) null);
        aSN1EncodableVector.a((ASN1Encodable) null);
        aSN1EncodableVector.a((ASN1Encodable) null);
        return new BERSequence(aSN1EncodableVector);
    }
}
