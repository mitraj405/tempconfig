package org.spongycastle.asn1.x9;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class X9FieldID extends ASN1Object implements X9ObjectIdentifiers {
    public final ASN1ObjectIdentifier Z0;
    public final ASN1Primitive a;

    public X9FieldID(BigInteger bigInteger) {
        this.Z0 = X9ObjectIdentifiers.l0;
        this.a = new ASN1Integer(bigInteger);
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(this.Z0);
        aSN1EncodableVector.a(this.a);
        return new DERSequence(aSN1EncodableVector);
    }

    public X9FieldID(int i, int i2, int i3, int i4) {
        this.Z0 = X9ObjectIdentifiers.m0;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(new ASN1Integer((long) i));
        if (i3 == 0) {
            if (i4 == 0) {
                aSN1EncodableVector.a(X9ObjectIdentifiers.n0);
                aSN1EncodableVector.a(new ASN1Integer((long) i2));
            } else {
                throw new IllegalArgumentException("inconsistent k values");
            }
        } else if (i3 <= i2 || i4 <= i3) {
            throw new IllegalArgumentException("inconsistent k values");
        } else {
            aSN1EncodableVector.a(X9ObjectIdentifiers.o0);
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            aSN1EncodableVector2.a(new ASN1Integer((long) i2));
            aSN1EncodableVector2.a(new ASN1Integer((long) i3));
            aSN1EncodableVector2.a(new ASN1Integer((long) i4));
            aSN1EncodableVector.a(new DERSequence(aSN1EncodableVector2));
        }
        this.a = new DERSequence(aSN1EncodableVector);
    }

    public X9FieldID(ASN1Sequence aSN1Sequence) {
        this.Z0 = ASN1ObjectIdentifier.u(aSN1Sequence.s(0));
        this.a = aSN1Sequence.s(1).b();
    }
}
