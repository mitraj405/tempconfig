package org.spongycastle.asn1.dvcs;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class DVCSCertInfo extends ASN1Object {
    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(new ASN1Integer((long) 0));
        aSN1EncodableVector.a((ASN1Encodable) null);
        aSN1EncodableVector.a((ASN1Encodable) null);
        aSN1EncodableVector.a((ASN1Encodable) null);
        aSN1EncodableVector.a((ASN1Encodable) null);
        return new DERSequence(aSN1EncodableVector);
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer("DVCSCertInfo {\n");
        stringBuffer.append("version: 0\n");
        stringBuffer.append("dvReqInfo: null\nmessageImprint: null\nserialNumber: null\nresponseTime: null\n");
        stringBuffer.append("}\n");
        return stringBuffer.toString();
    }
}
