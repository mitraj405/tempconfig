package org.spongycastle.asn1.oiw;

import java.math.BigInteger;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class ElGamalParameter extends ASN1Object {
    public final ASN1Integer a;
    public final ASN1Integer b;

    public ElGamalParameter(BigInteger bigInteger, BigInteger bigInteger2) {
        this.a = new ASN1Integer(bigInteger);
        this.b = new ASN1Integer(bigInteger2);
    }

    public static ElGamalParameter g(ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable instanceof ElGamalParameter) {
            return (ElGamalParameter) aSN1Encodable;
        }
        if (aSN1Encodable != null) {
            return new ElGamalParameter(ASN1Sequence.q(aSN1Encodable));
        }
        return null;
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(this.a);
        aSN1EncodableVector.a(this.b);
        return new DERSequence(aSN1EncodableVector);
    }

    public ElGamalParameter(ASN1Sequence aSN1Sequence) {
        Enumeration t = aSN1Sequence.t();
        this.a = (ASN1Integer) t.nextElement();
        this.b = (ASN1Integer) t.nextElement();
    }
}
