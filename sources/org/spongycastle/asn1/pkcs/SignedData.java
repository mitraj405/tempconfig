package org.spongycastle.asn1.pkcs;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.BERSequence;
import org.spongycastle.asn1.DERSet;
import org.spongycastle.asn1.DERTaggedObject;

public class SignedData extends ASN1Object implements PKCSObjectIdentifiers {
    public final ASN1Integer a;

    /* renamed from: a  reason: collision with other field name */
    public final ASN1Set f5710a;

    /* renamed from: a  reason: collision with other field name */
    public final ContentInfo f5711a;
    public final ASN1Set b;
    public final ASN1Set c;
    public final ASN1Set d;

    public SignedData(ASN1Integer aSN1Integer, DERSet dERSet, ContentInfo contentInfo, DERSet dERSet2, DERSet dERSet3) {
        this.a = aSN1Integer;
        this.f5710a = dERSet;
        this.f5711a = contentInfo;
        this.b = dERSet2;
        this.c = null;
        this.d = dERSet3;
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(this.a);
        aSN1EncodableVector.a(this.f5710a);
        aSN1EncodableVector.a(this.f5711a);
        ASN1Set aSN1Set = this.b;
        if (aSN1Set != null) {
            aSN1EncodableVector.a(new DERTaggedObject(false, 0, aSN1Set));
        }
        ASN1Set aSN1Set2 = this.c;
        if (aSN1Set2 != null) {
            aSN1EncodableVector.a(new DERTaggedObject(false, 1, aSN1Set2));
        }
        aSN1EncodableVector.a(this.d);
        return new BERSequence(aSN1EncodableVector);
    }

    public SignedData(ASN1Sequence aSN1Sequence) {
        Enumeration t = aSN1Sequence.t();
        this.a = (ASN1Integer) t.nextElement();
        this.f5710a = (ASN1Set) t.nextElement();
        this.f5711a = ContentInfo.g(t.nextElement());
        while (t.hasMoreElements()) {
            ASN1Primitive aSN1Primitive = (ASN1Primitive) t.nextElement();
            if (aSN1Primitive instanceof ASN1TaggedObject) {
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Primitive;
                int i = aSN1TaggedObject.c;
                if (i == 0) {
                    this.b = ASN1Set.r(aSN1TaggedObject);
                } else if (i == 1) {
                    this.c = ASN1Set.r(aSN1TaggedObject);
                } else {
                    throw new IllegalArgumentException("unknown tag value " + aSN1TaggedObject.c);
                }
            } else {
                this.d = (ASN1Set) aSN1Primitive;
            }
        }
    }
}
