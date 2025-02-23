package org.spongycastle.asn1.x9;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;

public class ValidationParams extends ASN1Object {
    public final ASN1Integer a;

    /* renamed from: a  reason: collision with other field name */
    public final DERBitString f5783a;

    public ValidationParams(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            this.f5783a = DERBitString.u(aSN1Sequence.s(0));
            this.a = ASN1Integer.q(aSN1Sequence.s(1));
            return;
        }
        throw new IllegalArgumentException(C0709Uj.k(aSN1Sequence, new StringBuilder("Bad sequence size: ")));
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(this.f5783a);
        aSN1EncodableVector.a(this.a);
        return new DERSequence(aSN1EncodableVector);
    }
}
