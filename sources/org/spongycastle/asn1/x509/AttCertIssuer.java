package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERTaggedObject;

public class AttCertIssuer extends ASN1Object implements ASN1Choice {
    public final ASN1Object a;

    /* renamed from: a  reason: collision with other field name */
    public final ASN1Primitive f5725a;

    public AttCertIssuer(GeneralNames generalNames) {
        this.a = generalNames;
        this.f5725a = generalNames.b();
    }

    public static AttCertIssuer g(ASN1Encodable aSN1Encodable) {
        V2Form v2Form;
        V2Form v2Form2;
        if (aSN1Encodable == null || (aSN1Encodable instanceof AttCertIssuer)) {
            return (AttCertIssuer) aSN1Encodable;
        }
        boolean z = aSN1Encodable instanceof V2Form;
        if (z) {
            if (z) {
                v2Form2 = (V2Form) aSN1Encodable;
            } else {
                v2Form2 = new V2Form(ASN1Sequence.q(aSN1Encodable));
            }
            return new AttCertIssuer(v2Form2);
        } else if (aSN1Encodable instanceof GeneralNames) {
            return new AttCertIssuer((GeneralNames) aSN1Encodable);
        } else {
            if (aSN1Encodable instanceof ASN1TaggedObject) {
                ASN1Sequence r = ASN1Sequence.r((ASN1TaggedObject) aSN1Encodable, false);
                if (r instanceof V2Form) {
                    v2Form = (V2Form) r;
                } else if (r != null) {
                    v2Form = new V2Form(ASN1Sequence.q(r));
                } else {
                    v2Form = null;
                }
                return new AttCertIssuer(v2Form);
            } else if (aSN1Encodable instanceof ASN1Sequence) {
                return new AttCertIssuer(GeneralNames.g(aSN1Encodable));
            } else {
                throw new IllegalArgumentException("unknown object in factory: ".concat(aSN1Encodable.getClass().getName()));
            }
        }
    }

    public final ASN1Primitive b() {
        return this.f5725a;
    }

    public AttCertIssuer(V2Form v2Form) {
        this.a = v2Form;
        this.f5725a = new DERTaggedObject(false, 0, v2Form);
    }
}
