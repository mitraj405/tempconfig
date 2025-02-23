package org.spongycastle.pqc.asn1;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;

public class McElieceCCA2PublicKey extends ASN1Object {
    public final AlgorithmIdentifier a;

    /* renamed from: a  reason: collision with other field name */
    public final GF2Matrix f6644a;
    public final int c;
    public final int d;

    public McElieceCCA2PublicKey(int i, int i2, GF2Matrix gF2Matrix, AlgorithmIdentifier algorithmIdentifier) {
        this.c = i;
        this.d = i2;
        this.f6644a = new GF2Matrix(gF2Matrix.d());
        this.a = algorithmIdentifier;
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(new ASN1Integer((long) this.c));
        aSN1EncodableVector.a(new ASN1Integer((long) this.d));
        aSN1EncodableVector.a(new DEROctetString(this.f6644a.d()));
        aSN1EncodableVector.a(this.a);
        return new DERSequence(aSN1EncodableVector);
    }

    public McElieceCCA2PublicKey(ASN1Sequence aSN1Sequence) {
        this.c = ((ASN1Integer) aSN1Sequence.s(0)).t().intValue();
        this.d = ((ASN1Integer) aSN1Sequence.s(1)).t().intValue();
        this.f6644a = new GF2Matrix(((ASN1OctetString) aSN1Sequence.s(2)).s());
        this.a = AlgorithmIdentifier.g(aSN1Sequence.s(3));
    }
}
