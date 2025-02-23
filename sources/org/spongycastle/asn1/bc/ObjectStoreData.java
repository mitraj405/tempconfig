package org.spongycastle.asn1.bc;

import java.math.BigInteger;
import java.util.Date;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERGeneralizedTime;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERUTF8String;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class ObjectStoreData extends ASN1Object {
    public final BigInteger a;

    /* renamed from: a  reason: collision with other field name */
    public final ASN1GeneralizedTime f5681a;

    /* renamed from: a  reason: collision with other field name */
    public final ObjectDataSequence f5682a;

    /* renamed from: a  reason: collision with other field name */
    public final AlgorithmIdentifier f5683a;
    public final ASN1GeneralizedTime b;
    public final String c;

    public ObjectStoreData(AlgorithmIdentifier algorithmIdentifier, Date date, Date date2, ObjectDataSequence objectDataSequence) {
        this.a = BigInteger.valueOf(1);
        this.f5683a = algorithmIdentifier;
        this.f5681a = new DERGeneralizedTime(date);
        this.b = new DERGeneralizedTime(date2);
        this.f5682a = objectDataSequence;
        this.c = null;
    }

    public static ObjectStoreData g(Object obj) {
        if (obj instanceof ObjectStoreData) {
            return (ObjectStoreData) obj;
        }
        if (obj != null) {
            return new ObjectStoreData(ASN1Sequence.q(obj));
        }
        return null;
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(new ASN1Integer(this.a));
        aSN1EncodableVector.a(this.f5683a);
        aSN1EncodableVector.a(this.f5681a);
        aSN1EncodableVector.a(this.b);
        aSN1EncodableVector.a(this.f5682a);
        String str = this.c;
        if (str != null) {
            aSN1EncodableVector.a(new DERUTF8String(str));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public ObjectStoreData(ASN1Sequence aSN1Sequence) {
        ObjectDataSequence objectDataSequence;
        this.a = ASN1Integer.q(aSN1Sequence.s(0)).t();
        this.f5683a = AlgorithmIdentifier.g(aSN1Sequence.s(1));
        this.f5681a = ASN1GeneralizedTime.r(aSN1Sequence.s(2));
        this.b = ASN1GeneralizedTime.r(aSN1Sequence.s(3));
        ASN1Encodable s = aSN1Sequence.s(4);
        String str = null;
        if (s instanceof ObjectDataSequence) {
            objectDataSequence = (ObjectDataSequence) s;
        } else {
            objectDataSequence = s != null ? new ObjectDataSequence(ASN1Sequence.q(s)) : null;
        }
        this.f5682a = objectDataSequence;
        this.c = aSN1Sequence.size() == 6 ? DERUTF8String.q(aSN1Sequence.s(5)).c() : str;
    }
}
