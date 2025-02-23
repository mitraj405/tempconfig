package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;

public class IssuerSerial extends ASN1Object {
    public final ASN1Integer a;

    /* renamed from: a  reason: collision with other field name */
    public final DERBitString f5746a;

    /* renamed from: a  reason: collision with other field name */
    public final GeneralNames f5747a;

    public IssuerSerial(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2 || aSN1Sequence.size() == 3) {
            this.f5747a = GeneralNames.g(aSN1Sequence.s(0));
            this.a = ASN1Integer.q(aSN1Sequence.s(1));
            if (aSN1Sequence.size() == 3) {
                this.f5746a = DERBitString.u(aSN1Sequence.s(2));
                return;
            }
            return;
        }
        throw new IllegalArgumentException(C0709Uj.k(aSN1Sequence, new StringBuilder("Bad sequence size: ")));
    }

    public static IssuerSerial g(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Sequence r = ASN1Sequence.r(aSN1TaggedObject, z);
        if (r instanceof IssuerSerial) {
            return (IssuerSerial) r;
        }
        if (r != null) {
            return new IssuerSerial(ASN1Sequence.q(r));
        }
        return null;
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(this.f5747a);
        aSN1EncodableVector.a(this.a);
        DERBitString dERBitString = this.f5746a;
        if (dERBitString != null) {
            aSN1EncodableVector.a(dERBitString);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
