package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.DERSequence;

public class Attribute extends ASN1Object {
    public final ASN1ObjectIdentifier Z0;
    public final ASN1Set a;

    public Attribute(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            this.Z0 = ASN1ObjectIdentifier.u(aSN1Sequence.s(0));
            this.a = ASN1Set.q(aSN1Sequence.s(1));
            return;
        }
        throw new IllegalArgumentException(C0709Uj.k(aSN1Sequence, new StringBuilder("Bad sequence size: ")));
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(this.Z0);
        aSN1EncodableVector.a(this.a);
        return new DERSequence(aSN1EncodableVector);
    }
}
