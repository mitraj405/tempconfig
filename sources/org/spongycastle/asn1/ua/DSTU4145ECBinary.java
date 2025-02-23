package org.spongycastle.asn1.ua;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class DSTU4145ECBinary extends ASN1Object {
    public final BigInteger a = BigInteger.valueOf(0);

    /* renamed from: a  reason: collision with other field name */
    public final ASN1Integer f5712a;

    /* renamed from: a  reason: collision with other field name */
    public final ASN1OctetString f5713a;

    /* renamed from: a  reason: collision with other field name */
    public final DSTU4145BinaryField f5714a;
    public final ASN1Integer b;

    /* renamed from: b  reason: collision with other field name */
    public final ASN1OctetString f5715b;

    public DSTU4145ECBinary(ASN1Sequence aSN1Sequence) {
        DSTU4145BinaryField dSTU4145BinaryField;
        int i = 0;
        if (aSN1Sequence.s(0) instanceof ASN1TaggedObject) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Sequence.s(0);
            if (!aSN1TaggedObject.f5664a || aSN1TaggedObject.c != 0) {
                throw new IllegalArgumentException("object parse error");
            }
            this.a = ASN1Integer.q(aSN1TaggedObject).t();
            i = 1;
        }
        ASN1Encodable s = aSN1Sequence.s(i);
        if (s instanceof DSTU4145BinaryField) {
            dSTU4145BinaryField = (DSTU4145BinaryField) s;
        } else if (s != null) {
            dSTU4145BinaryField = new DSTU4145BinaryField(ASN1Sequence.q(s));
        } else {
            dSTU4145BinaryField = null;
        }
        this.f5714a = dSTU4145BinaryField;
        int i2 = i + 1;
        this.f5712a = ASN1Integer.q(aSN1Sequence.s(i2));
        int i3 = i2 + 1;
        this.f5713a = ASN1OctetString.q(aSN1Sequence.s(i3));
        int i4 = i3 + 1;
        this.b = ASN1Integer.q(aSN1Sequence.s(i4));
        this.f5715b = ASN1OctetString.q(aSN1Sequence.s(i4 + 1));
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        BigInteger valueOf = BigInteger.valueOf(0);
        BigInteger bigInteger = this.a;
        if (bigInteger.compareTo(valueOf) != 0) {
            aSN1EncodableVector.a(new DERTaggedObject(true, 0, new ASN1Integer(bigInteger)));
        }
        aSN1EncodableVector.a(this.f5714a);
        aSN1EncodableVector.a(this.f5712a);
        aSN1EncodableVector.a(this.f5713a);
        aSN1EncodableVector.a(this.b);
        aSN1EncodableVector.a(this.f5715b);
        return new DERSequence(aSN1EncodableVector);
    }
}
