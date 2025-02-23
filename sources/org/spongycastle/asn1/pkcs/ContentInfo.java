package org.spongycastle.asn1.pkcs;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.BERSequence;
import org.spongycastle.asn1.BERTaggedObject;
import org.spongycastle.asn1.DLSequence;

public class ContentInfo extends ASN1Object implements PKCSObjectIdentifiers {
    public final ASN1ObjectIdentifier Z0;
    public final ASN1Encodable a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f5690a = true;

    public ContentInfo(ASN1Sequence aSN1Sequence) {
        Enumeration t = aSN1Sequence.t();
        this.Z0 = (ASN1ObjectIdentifier) t.nextElement();
        if (t.hasMoreElements()) {
            this.a = ((ASN1TaggedObject) t.nextElement()).r();
        }
        this.f5690a = aSN1Sequence instanceof BERSequence;
    }

    public static ContentInfo g(Object obj) {
        if (obj instanceof ContentInfo) {
            return (ContentInfo) obj;
        }
        if (obj != null) {
            return new ContentInfo(ASN1Sequence.q(obj));
        }
        return null;
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(this.Z0);
        ASN1Encodable aSN1Encodable = this.a;
        if (aSN1Encodable != null) {
            aSN1EncodableVector.a(new BERTaggedObject(true, 0, aSN1Encodable));
        }
        if (this.f5690a) {
            return new BERSequence(aSN1EncodableVector);
        }
        return new DLSequence(aSN1EncodableVector);
    }

    public ContentInfo(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Object aSN1Object) {
        this.Z0 = aSN1ObjectIdentifier;
        this.a = aSN1Object;
    }
}
