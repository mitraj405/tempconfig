package org.spongycastle.asn1.misc;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.util.Arrays;

public class CAST5CBCParameters extends ASN1Object {
    public final ASN1Integer a;

    /* renamed from: a  reason: collision with other field name */
    public final ASN1OctetString f5688a;

    public CAST5CBCParameters(byte[] bArr, int i) {
        this.f5688a = new DEROctetString(Arrays.c(bArr));
        this.a = new ASN1Integer((long) i);
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(this.f5688a);
        aSN1EncodableVector.a(this.a);
        return new DERSequence(aSN1EncodableVector);
    }

    public CAST5CBCParameters(ASN1Sequence aSN1Sequence) {
        this.f5688a = (ASN1OctetString) aSN1Sequence.s(0);
        this.a = (ASN1Integer) aSN1Sequence.s(1);
    }
}
