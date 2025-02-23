package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Enumerated;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;

public class ObjectDigestInfo extends ASN1Object {
    public final ASN1ObjectIdentifier Z0;
    public final ASN1Enumerated a;

    /* renamed from: a  reason: collision with other field name */
    public final DERBitString f5751a;

    /* renamed from: a  reason: collision with other field name */
    public final AlgorithmIdentifier f5752a;

    public ObjectDigestInfo(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() > 4 || aSN1Sequence.size() < 3) {
            throw new IllegalArgumentException(C0709Uj.k(aSN1Sequence, new StringBuilder("Bad sequence size: ")));
        }
        int i = 0;
        this.a = ASN1Enumerated.q(aSN1Sequence.s(0));
        if (aSN1Sequence.size() == 4) {
            i = 1;
            this.Z0 = ASN1ObjectIdentifier.u(aSN1Sequence.s(1));
        }
        this.f5752a = AlgorithmIdentifier.g(aSN1Sequence.s(i + 1));
        this.f5751a = DERBitString.u(aSN1Sequence.s(i + 2));
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(this.a);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this.Z0;
        if (aSN1ObjectIdentifier != null) {
            aSN1EncodableVector.a(aSN1ObjectIdentifier);
        }
        aSN1EncodableVector.a(this.f5752a);
        aSN1EncodableVector.a(this.f5751a);
        return new DERSequence(aSN1EncodableVector);
    }
}
