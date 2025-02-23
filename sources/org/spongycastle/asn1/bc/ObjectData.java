package org.spongycastle.asn1.bc;

import java.math.BigInteger;
import java.util.Date;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERGeneralizedTime;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERUTF8String;
import org.spongycastle.util.Arrays;

public class ObjectData extends ASN1Object {
    public final BigInteger a;

    /* renamed from: a  reason: collision with other field name */
    public final ASN1GeneralizedTime f5678a;

    /* renamed from: a  reason: collision with other field name */
    public final ASN1OctetString f5679a;
    public final ASN1GeneralizedTime b;
    public final String c;
    public final String d;

    public ObjectData(ASN1Sequence aSN1Sequence) {
        this.a = ASN1Integer.q(aSN1Sequence.s(0)).t();
        this.c = DERUTF8String.q(aSN1Sequence.s(1)).c();
        this.f5678a = ASN1GeneralizedTime.r(aSN1Sequence.s(2));
        this.b = ASN1GeneralizedTime.r(aSN1Sequence.s(3));
        this.f5679a = ASN1OctetString.q(aSN1Sequence.s(4));
        this.d = aSN1Sequence.size() == 6 ? DERUTF8String.q(aSN1Sequence.s(5)).c() : null;
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(new ASN1Integer(this.a));
        aSN1EncodableVector.a(new DERUTF8String(this.c));
        aSN1EncodableVector.a(this.f5678a);
        aSN1EncodableVector.a(this.b);
        aSN1EncodableVector.a(this.f5679a);
        String str = this.d;
        if (str != null) {
            aSN1EncodableVector.a(new DERUTF8String(str));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public final byte[] g() {
        return Arrays.c(this.f5679a.s());
    }

    public ObjectData(BigInteger bigInteger, String str, Date date, Date date2, byte[] bArr) {
        this.a = bigInteger;
        this.c = str;
        this.f5678a = new DERGeneralizedTime(date);
        this.b = new DERGeneralizedTime(date2);
        this.f5679a = new DEROctetString(Arrays.c(bArr));
        this.d = null;
    }
}
