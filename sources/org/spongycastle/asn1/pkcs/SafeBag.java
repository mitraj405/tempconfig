package org.spongycastle.asn1.pkcs;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERSet;
import org.spongycastle.asn1.DLSequence;
import org.spongycastle.asn1.DLTaggedObject;

public class SafeBag extends ASN1Object {
    public final ASN1ObjectIdentifier Z0;
    public final ASN1Encodable a;

    /* renamed from: a  reason: collision with other field name */
    public final ASN1Set f5709a;

    public SafeBag(ASN1ObjectIdentifier aSN1ObjectIdentifier, DERSequence dERSequence, DERSet dERSet) {
        this.Z0 = aSN1ObjectIdentifier;
        this.a = dERSequence;
        this.f5709a = dERSet;
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(this.Z0);
        aSN1EncodableVector.a(new DLTaggedObject(true, 0, this.a));
        ASN1Set aSN1Set = this.f5709a;
        if (aSN1Set != null) {
            aSN1EncodableVector.a(aSN1Set);
        }
        return new DLSequence(aSN1EncodableVector);
    }

    public SafeBag(ASN1Sequence aSN1Sequence) {
        this.Z0 = (ASN1ObjectIdentifier) aSN1Sequence.s(0);
        this.a = ((ASN1TaggedObject) aSN1Sequence.s(1)).r();
        if (aSN1Sequence.size() == 3) {
            this.f5709a = (ASN1Set) aSN1Sequence.s(2);
        }
    }
}
