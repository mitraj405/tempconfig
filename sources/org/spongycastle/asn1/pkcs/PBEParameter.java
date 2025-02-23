package org.spongycastle.asn1.pkcs;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;

public class PBEParameter extends ASN1Object {
    public final ASN1Integer a;

    /* renamed from: a  reason: collision with other field name */
    public final ASN1OctetString f5694a;

    public PBEParameter(byte[] bArr, int i) {
        if (bArr.length == 8) {
            this.f5694a = new DEROctetString(bArr);
            this.a = new ASN1Integer((long) i);
            return;
        }
        throw new IllegalArgumentException("salt length must be 8");
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(this.f5694a);
        aSN1EncodableVector.a(this.a);
        return new DERSequence(aSN1EncodableVector);
    }

    public PBEParameter(ASN1Sequence aSN1Sequence) {
        this.f5694a = (ASN1OctetString) aSN1Sequence.s(0);
        this.a = (ASN1Integer) aSN1Sequence.s(1);
    }
}
