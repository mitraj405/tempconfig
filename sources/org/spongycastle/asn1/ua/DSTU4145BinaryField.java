package org.spongycastle.asn1.ua;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class DSTU4145BinaryField extends ASN1Object {
    public final int c;
    public final int d;
    public final int e;
    public final int f;

    public DSTU4145BinaryField(ASN1Sequence aSN1Sequence) {
        this.c = ASN1Integer.q(aSN1Sequence.s(0)).s().intValue();
        if (aSN1Sequence.s(1) instanceof ASN1Integer) {
            this.d = ((ASN1Integer) aSN1Sequence.s(1)).s().intValue();
        } else if (aSN1Sequence.s(1) instanceof ASN1Sequence) {
            ASN1Sequence q = ASN1Sequence.q(aSN1Sequence.s(1));
            this.d = ASN1Integer.q(q.s(0)).s().intValue();
            this.e = ASN1Integer.q(q.s(1)).s().intValue();
            this.f = ASN1Integer.q(q.s(2)).s().intValue();
        } else {
            throw new IllegalArgumentException("object parse error");
        }
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(new ASN1Integer((long) this.c));
        int i = this.d;
        int i2 = this.e;
        if (i2 == 0) {
            aSN1EncodableVector.a(new ASN1Integer((long) i));
        } else {
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            aSN1EncodableVector2.a(new ASN1Integer((long) i));
            aSN1EncodableVector2.a(new ASN1Integer((long) i2));
            aSN1EncodableVector2.a(new ASN1Integer((long) this.f));
            aSN1EncodableVector.a(new DERSequence(aSN1EncodableVector2));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
