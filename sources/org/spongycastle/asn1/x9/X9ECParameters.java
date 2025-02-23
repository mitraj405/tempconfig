package org.spongycastle.asn1.x9;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.math.ec.ECAlgorithms;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.field.FiniteField;
import org.spongycastle.math.field.PolynomialExtensionField;

public class X9ECParameters extends ASN1Object implements X9ObjectIdentifiers {
    public static final BigInteger c = BigInteger.valueOf(1);
    public final BigInteger a;

    /* renamed from: a  reason: collision with other field name */
    public final X9ECPoint f5785a;

    /* renamed from: a  reason: collision with other field name */
    public final X9FieldID f5786a;

    /* renamed from: a  reason: collision with other field name */
    public final ECCurve f5787a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f5788a;
    public final BigInteger b;

    public X9ECParameters(ASN1Sequence aSN1Sequence) {
        X9FieldID x9FieldID;
        if (!(aSN1Sequence.s(0) instanceof ASN1Integer) || !((ASN1Integer) aSN1Sequence.s(0)).t().equals(c)) {
            throw new IllegalArgumentException("bad version in X9ECParameters");
        }
        ASN1Encodable s = aSN1Sequence.s(1);
        if (s instanceof X9FieldID) {
            x9FieldID = (X9FieldID) s;
        } else {
            x9FieldID = s != null ? new X9FieldID(ASN1Sequence.q(s)) : null;
        }
        X9Curve x9Curve = new X9Curve(x9FieldID, ASN1Sequence.q(aSN1Sequence.s(2)));
        ECCurve eCCurve = x9Curve.a;
        this.f5787a = eCCurve;
        ASN1Encodable s2 = aSN1Sequence.s(3);
        if (s2 instanceof X9ECPoint) {
            this.f5785a = (X9ECPoint) s2;
        } else {
            this.f5785a = new X9ECPoint(eCCurve, (ASN1OctetString) s2);
        }
        this.a = ((ASN1Integer) aSN1Sequence.s(4)).t();
        this.f5788a = x9Curve.f5784a;
        if (aSN1Sequence.size() == 6) {
            this.b = ((ASN1Integer) aSN1Sequence.s(5)).t();
        }
    }

    public static X9ECParameters h(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof X9ECParameters) {
            return (X9ECParameters) aSN1Primitive;
        }
        if (aSN1Primitive != null) {
            return new X9ECParameters(ASN1Sequence.q(aSN1Primitive));
        }
        return null;
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(new ASN1Integer(c));
        aSN1EncodableVector.a(this.f5786a);
        aSN1EncodableVector.a(new X9Curve(this.f5787a, this.f5788a));
        aSN1EncodableVector.a(this.f5785a);
        aSN1EncodableVector.a(new ASN1Integer(this.a));
        BigInteger bigInteger = this.b;
        if (bigInteger != null) {
            aSN1EncodableVector.a(new ASN1Integer(bigInteger));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public final ECPoint g() {
        return this.f5785a.g();
    }

    public X9ECParameters(ECCurve.Fp fp, X9ECPoint x9ECPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        this((ECCurve) fp, x9ECPoint, bigInteger, bigInteger2, (byte[]) null);
    }

    public X9ECParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this(eCCurve, new X9ECPoint(eCPoint), bigInteger, bigInteger2, bArr);
    }

    public X9ECParameters(ECCurve eCCurve, X9ECPoint x9ECPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.f5787a = eCCurve;
        this.f5785a = x9ECPoint;
        this.a = bigInteger;
        this.b = bigInteger2;
        this.f5788a = bArr;
        boolean z = eCCurve.f6613a.a() == 1;
        FiniteField finiteField = eCCurve.f6613a;
        if (z) {
            this.f5786a = new X9FieldID(finiteField.b());
        } else if (ECAlgorithms.e(eCCurve)) {
            int[] a2 = ((PolynomialExtensionField) finiteField).c().a();
            if (a2.length == 3) {
                this.f5786a = new X9FieldID(a2[2], a2[1], 0, 0);
            } else if (a2.length == 5) {
                this.f5786a = new X9FieldID(a2[4], a2[1], a2[2], a2[3]);
            } else {
                throw new IllegalArgumentException("Only trinomial and pentomial curves are supported");
            }
        } else {
            throw new IllegalArgumentException("'curve' is of an unsupported type");
        }
    }
}
