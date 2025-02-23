package org.spongycastle.pqc.asn1;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class XMSSKeyParams extends ASN1Object {
    public final ASN1Integer a;

    /* renamed from: a  reason: collision with other field name */
    public final AlgorithmIdentifier f6655a;
    public final int c;

    public XMSSKeyParams(int i, AlgorithmIdentifier algorithmIdentifier) {
        this.a = new ASN1Integer(0);
        this.c = i;
        this.f6655a = algorithmIdentifier;
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(this.a);
        aSN1EncodableVector.a(new ASN1Integer((long) this.c));
        aSN1EncodableVector.a(this.f6655a);
        return new DERSequence(aSN1EncodableVector);
    }

    public XMSSKeyParams(ASN1Sequence aSN1Sequence) {
        this.a = ASN1Integer.q(aSN1Sequence.s(0));
        this.c = ASN1Integer.q(aSN1Sequence.s(1)).t().intValue();
        this.f6655a = AlgorithmIdentifier.g(aSN1Sequence.s(2));
    }
}
