package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.BERSequence;

public class SignedData extends ASN1Object {
    static {
        new ASN1Integer(1);
        new ASN1Integer(3);
        new ASN1Integer(4);
        new ASN1Integer(5);
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a((ASN1Encodable) null);
        aSN1EncodableVector.a((ASN1Encodable) null);
        aSN1EncodableVector.a((ASN1Encodable) null);
        aSN1EncodableVector.a((ASN1Encodable) null);
        return new BERSequence(aSN1EncodableVector);
    }
}
