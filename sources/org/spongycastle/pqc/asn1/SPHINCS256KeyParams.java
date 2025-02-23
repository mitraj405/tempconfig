package org.spongycastle.pqc.asn1;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class SPHINCS256KeyParams extends ASN1Object {
    public final ASN1Integer a;

    /* renamed from: a  reason: collision with other field name */
    public final AlgorithmIdentifier f6654a;

    public SPHINCS256KeyParams(AlgorithmIdentifier algorithmIdentifier) {
        this.a = new ASN1Integer(0);
        this.f6654a = algorithmIdentifier;
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(this.a);
        aSN1EncodableVector.a(this.f6654a);
        return new DERSequence(aSN1EncodableVector);
    }

    public SPHINCS256KeyParams(ASN1Sequence aSN1Sequence) {
        this.a = ASN1Integer.q(aSN1Sequence.s(0));
        this.f6654a = AlgorithmIdentifier.g(aSN1Sequence.s(1));
    }
}
