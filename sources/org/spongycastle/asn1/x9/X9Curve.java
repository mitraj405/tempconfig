package org.spongycastle.asn1.x9;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.math.ec.ECAlgorithms;
import org.spongycastle.math.ec.ECCurve;

public class X9Curve extends ASN1Object implements X9ObjectIdentifiers {
    public ASN1ObjectIdentifier Z0 = null;
    public final ECCurve a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f5784a;

    public X9Curve(ECCurve eCCurve, byte[] bArr) {
        this.a = eCCurve;
        this.f5784a = bArr;
        if (eCCurve.f6613a.a() != 1 ? false : true) {
            this.Z0 = X9ObjectIdentifiers.l0;
        } else if (ECAlgorithms.e(eCCurve)) {
            this.Z0 = X9ObjectIdentifiers.m0;
        } else {
            throw new IllegalArgumentException("This type of ECCurve is not implemented");
        }
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        boolean equals = this.Z0.equals(X9ObjectIdentifiers.l0);
        ECCurve eCCurve = this.a;
        if (equals) {
            aSN1EncodableVector.a(new X9FieldElement(eCCurve.f6610a).b());
            aSN1EncodableVector.a(new X9FieldElement(eCCurve.f6614b).b());
        } else if (this.Z0.equals(X9ObjectIdentifiers.m0)) {
            aSN1EncodableVector.a(new X9FieldElement(eCCurve.f6610a).b());
            aSN1EncodableVector.a(new X9FieldElement(eCCurve.f6614b).b());
        }
        byte[] bArr = this.f5784a;
        if (bArr != null) {
            aSN1EncodableVector.a(new DERBitString(bArr));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public X9Curve(X9FieldID x9FieldID, ASN1Sequence aSN1Sequence) {
        int i;
        int i2;
        int i3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = x9FieldID.Z0;
        this.Z0 = aSN1ObjectIdentifier;
        boolean equals = aSN1ObjectIdentifier.equals(X9ObjectIdentifiers.l0);
        ASN1Primitive aSN1Primitive = x9FieldID.a;
        if (equals) {
            BigInteger t = ((ASN1Integer) aSN1Primitive).t();
            this.a = new ECCurve.Fp(t, new X9FieldElement(t, (ASN1OctetString) aSN1Sequence.s(0)).f5791a.t(), new X9FieldElement(t, (ASN1OctetString) aSN1Sequence.s(1)).f5791a.t());
        } else if (this.Z0.equals(X9ObjectIdentifiers.m0)) {
            ASN1Sequence q = ASN1Sequence.q(aSN1Primitive);
            int intValue = ((ASN1Integer) q.s(0)).t().intValue();
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = (ASN1ObjectIdentifier) q.s(1);
            if (aSN1ObjectIdentifier2.equals(X9ObjectIdentifiers.n0)) {
                i = ASN1Integer.q(q.s(2)).t().intValue();
                i3 = 0;
                i2 = 0;
            } else if (aSN1ObjectIdentifier2.equals(X9ObjectIdentifiers.o0)) {
                ASN1Sequence q2 = ASN1Sequence.q(q.s(2));
                int intValue2 = ASN1Integer.q(q2.s(0)).t().intValue();
                int intValue3 = ASN1Integer.q(q2.s(1)).t().intValue();
                i2 = ASN1Integer.q(q2.s(2)).t().intValue();
                i = intValue2;
                i3 = intValue3;
            } else {
                throw new IllegalArgumentException("This type of EC basis is not implemented");
            }
            int i4 = intValue;
            int i5 = i;
            int i6 = i3;
            int i7 = i2;
            this.a = new ECCurve.F2m(intValue, i, i3, i2, new X9FieldElement(i4, i5, i6, i7, (ASN1OctetString) aSN1Sequence.s(0)).f5791a.t(), new X9FieldElement(i4, i5, i6, i7, (ASN1OctetString) aSN1Sequence.s(1)).f5791a.t());
        } else {
            throw new IllegalArgumentException("This type of ECCurve is not implemented");
        }
        if (aSN1Sequence.size() == 3) {
            this.f5784a = ((DERBitString) aSN1Sequence.s(2)).r();
        }
    }
}
