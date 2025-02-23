package org.spongycastle.asn1.x509;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class GeneralSubtree extends ASN1Object {
    public static final BigInteger a = BigInteger.valueOf(0);

    /* renamed from: a  reason: collision with other field name */
    public final ASN1Integer f5742a;

    /* renamed from: a  reason: collision with other field name */
    public final GeneralName f5743a;
    public final ASN1Integer b;

    public GeneralSubtree(ASN1Sequence aSN1Sequence) {
        this.f5743a = GeneralName.g(aSN1Sequence.s(0));
        int size = aSN1Sequence.size();
        if (size == 1) {
            return;
        }
        if (size == 2) {
            ASN1TaggedObject q = ASN1TaggedObject.q(aSN1Sequence.s(1));
            int i = q.c;
            if (i == 0) {
                this.f5742a = ASN1Integer.r(q, false);
            } else if (i == 1) {
                this.b = ASN1Integer.r(q, false);
            } else {
                throw new IllegalArgumentException("Bad tag number: " + q.c);
            }
        } else if (size == 3) {
            ASN1TaggedObject q2 = ASN1TaggedObject.q(aSN1Sequence.s(1));
            if (q2.c == 0) {
                this.f5742a = ASN1Integer.r(q2, false);
                ASN1TaggedObject q3 = ASN1TaggedObject.q(aSN1Sequence.s(2));
                if (q3.c == 1) {
                    this.b = ASN1Integer.r(q3, false);
                    return;
                }
                throw new IllegalArgumentException("Bad tag number for 'maximum': " + q3.c);
            }
            throw new IllegalArgumentException("Bad tag number for 'minimum': " + q2.c);
        } else {
            throw new IllegalArgumentException(C0709Uj.k(aSN1Sequence, new StringBuilder("Bad sequence size: ")));
        }
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(this.f5743a);
        ASN1Integer aSN1Integer = this.f5742a;
        if (aSN1Integer != null && !aSN1Integer.t().equals(a)) {
            aSN1EncodableVector.a(new DERTaggedObject(false, 0, aSN1Integer));
        }
        ASN1Integer aSN1Integer2 = this.b;
        if (aSN1Integer2 != null) {
            aSN1EncodableVector.a(new DERTaggedObject(false, 1, aSN1Integer2));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
