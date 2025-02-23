package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class Holder extends ASN1Object {
    public final GeneralNames a;

    /* renamed from: a  reason: collision with other field name */
    public final IssuerSerial f5744a;

    /* renamed from: a  reason: collision with other field name */
    public final ObjectDigestInfo f5745a;
    public final int c = 1;

    public Holder(ASN1TaggedObject aSN1TaggedObject) {
        int i = aSN1TaggedObject.c;
        if (i == 0) {
            this.f5744a = IssuerSerial.g(aSN1TaggedObject, true);
        } else if (i == 1) {
            this.a = GeneralNames.g(ASN1Sequence.r(aSN1TaggedObject, true));
        } else {
            throw new IllegalArgumentException("unknown tag in Holder");
        }
        this.c = 0;
    }

    public static Holder g(Object obj) {
        if (obj instanceof Holder) {
            return (Holder) obj;
        }
        if (obj instanceof ASN1TaggedObject) {
            return new Holder(ASN1TaggedObject.q(obj));
        }
        if (obj != null) {
            return new Holder(ASN1Sequence.q(obj));
        }
        return null;
    }

    public final ASN1Primitive b() {
        IssuerSerial issuerSerial = this.f5744a;
        GeneralNames generalNames = this.a;
        if (this.c == 1) {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            if (issuerSerial != null) {
                aSN1EncodableVector.a(new DERTaggedObject(false, 0, issuerSerial));
            }
            if (generalNames != null) {
                aSN1EncodableVector.a(new DERTaggedObject(false, 1, generalNames));
            }
            ObjectDigestInfo objectDigestInfo = this.f5745a;
            if (objectDigestInfo != null) {
                aSN1EncodableVector.a(new DERTaggedObject(false, 2, objectDigestInfo));
            }
            return new DERSequence(aSN1EncodableVector);
        } else if (generalNames != null) {
            return new DERTaggedObject(true, 1, generalNames);
        } else {
            return new DERTaggedObject(true, 0, issuerSerial);
        }
    }

    public Holder(ASN1Sequence aSN1Sequence) {
        ObjectDigestInfo objectDigestInfo;
        if (aSN1Sequence.size() <= 3) {
            for (int i = 0; i != aSN1Sequence.size(); i++) {
                ASN1TaggedObject q = ASN1TaggedObject.q(aSN1Sequence.s(i));
                int i2 = q.c;
                if (i2 == 0) {
                    this.f5744a = IssuerSerial.g(q, false);
                } else if (i2 == 1) {
                    this.a = GeneralNames.g(ASN1Sequence.r(q, false));
                } else if (i2 == 2) {
                    ASN1Sequence r = ASN1Sequence.r(q, false);
                    if (r instanceof ObjectDigestInfo) {
                        objectDigestInfo = (ObjectDigestInfo) r;
                    } else {
                        objectDigestInfo = r != null ? new ObjectDigestInfo(ASN1Sequence.q(r)) : null;
                    }
                    this.f5745a = objectDigestInfo;
                } else {
                    throw new IllegalArgumentException("unknown tag in Holder");
                }
            }
            this.c = 1;
            return;
        }
        throw new IllegalArgumentException(C0709Uj.k(aSN1Sequence, new StringBuilder("Bad sequence size: ")));
    }
}
