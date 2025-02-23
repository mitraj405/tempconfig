package org.spongycastle.pqc.asn1;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;

public class McEliecePublicKey extends ASN1Object {
    public final GF2Matrix a;
    public final int c;
    public final int d;

    public McEliecePublicKey(int i, int i2, GF2Matrix gF2Matrix) {
        this.c = i;
        this.d = i2;
        this.a = new GF2Matrix(gF2Matrix);
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(new ASN1Integer((long) this.c));
        aSN1EncodableVector.a(new ASN1Integer((long) this.d));
        aSN1EncodableVector.a(new DEROctetString(this.a.d()));
        return new DERSequence(aSN1EncodableVector);
    }

    public McEliecePublicKey(ASN1Sequence aSN1Sequence) {
        this.c = ((ASN1Integer) aSN1Sequence.s(0)).t().intValue();
        this.d = ((ASN1Integer) aSN1Sequence.s(1)).t().intValue();
        this.a = new GF2Matrix(((ASN1OctetString) aSN1Sequence.s(2)).s());
    }
}
