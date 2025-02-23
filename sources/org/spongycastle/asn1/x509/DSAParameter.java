package org.spongycastle.asn1.x509;

import java.math.BigInteger;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class DSAParameter extends ASN1Object {
    public final ASN1Integer a;
    public final ASN1Integer b;
    public final ASN1Integer c;

    public DSAParameter(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.a = new ASN1Integer(bigInteger);
        this.b = new ASN1Integer(bigInteger2);
        this.c = new ASN1Integer(bigInteger3);
    }

    public static DSAParameter g(ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable instanceof DSAParameter) {
            return (DSAParameter) aSN1Encodable;
        }
        if (aSN1Encodable != null) {
            return new DSAParameter(ASN1Sequence.q(aSN1Encodable));
        }
        return null;
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(this.a);
        aSN1EncodableVector.a(this.b);
        aSN1EncodableVector.a(this.c);
        return new DERSequence(aSN1EncodableVector);
    }

    public DSAParameter(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 3) {
            Enumeration t = aSN1Sequence.t();
            this.a = ASN1Integer.q(t.nextElement());
            this.b = ASN1Integer.q(t.nextElement());
            this.c = ASN1Integer.q(t.nextElement());
            return;
        }
        throw new IllegalArgumentException(C0709Uj.k(aSN1Sequence, new StringBuilder("Bad sequence size: ")));
    }
}
