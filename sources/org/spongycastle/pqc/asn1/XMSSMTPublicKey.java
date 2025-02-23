package org.spongycastle.pqc.asn1;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;

public class XMSSMTPublicKey extends ASN1Object {
    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(new ASN1Integer(0));
        aSN1EncodableVector.a(new DEROctetString((byte[]) null));
        aSN1EncodableVector.a(new DEROctetString((byte[]) null));
        return new DERSequence(aSN1EncodableVector);
    }
}
