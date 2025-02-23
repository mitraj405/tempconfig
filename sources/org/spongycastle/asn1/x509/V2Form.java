package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class V2Form extends ASN1Object {
    public final GeneralNames a;

    /* renamed from: a  reason: collision with other field name */
    public final IssuerSerial f5771a;

    /* renamed from: a  reason: collision with other field name */
    public final ObjectDigestInfo f5772a;

    public V2Form(ASN1Sequence aSN1Sequence) {
        int i;
        ObjectDigestInfo objectDigestInfo;
        if (aSN1Sequence.size() <= 3) {
            if (!(aSN1Sequence.s(0) instanceof ASN1TaggedObject)) {
                this.a = GeneralNames.g(aSN1Sequence.s(0));
                i = 1;
            } else {
                i = 0;
            }
            while (i != aSN1Sequence.size()) {
                ASN1TaggedObject q = ASN1TaggedObject.q(aSN1Sequence.s(i));
                int i2 = q.c;
                if (i2 == 0) {
                    this.f5771a = IssuerSerial.g(q, false);
                } else if (i2 == 1) {
                    ASN1Sequence r = ASN1Sequence.r(q, false);
                    if (r instanceof ObjectDigestInfo) {
                        objectDigestInfo = (ObjectDigestInfo) r;
                    } else if (r != null) {
                        objectDigestInfo = new ObjectDigestInfo(ASN1Sequence.q(r));
                    } else {
                        objectDigestInfo = null;
                    }
                    this.f5772a = objectDigestInfo;
                } else {
                    throw new IllegalArgumentException("Bad tag number: " + q.c);
                }
                i++;
            }
            return;
        }
        throw new IllegalArgumentException(C0709Uj.k(aSN1Sequence, new StringBuilder("Bad sequence size: ")));
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        GeneralNames generalNames = this.a;
        if (generalNames != null) {
            aSN1EncodableVector.a(generalNames);
        }
        IssuerSerial issuerSerial = this.f5771a;
        if (issuerSerial != null) {
            aSN1EncodableVector.a(new DERTaggedObject(false, 0, issuerSerial));
        }
        ObjectDigestInfo objectDigestInfo = this.f5772a;
        if (objectDigestInfo != null) {
            aSN1EncodableVector.a(new DERTaggedObject(false, 1, objectDigestInfo));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
