package org.spongycastle.asn1.pkcs;

import java.math.BigInteger;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class DHParameter extends ASN1Object {
    public final ASN1Integer a;
    public final ASN1Integer b;
    public final ASN1Integer c;

    public DHParameter(int i, BigInteger bigInteger, BigInteger bigInteger2) {
        this.a = new ASN1Integer(bigInteger);
        this.b = new ASN1Integer(bigInteger2);
        if (i != 0) {
            this.c = new ASN1Integer((long) i);
        } else {
            this.c = null;
        }
    }

    public static DHParameter h(Object obj) {
        if (obj instanceof DHParameter) {
            return (DHParameter) obj;
        }
        if (obj != null) {
            return new DHParameter(ASN1Sequence.q(obj));
        }
        return null;
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(this.a);
        aSN1EncodableVector.a(this.b);
        if (i() != null) {
            aSN1EncodableVector.a(this.c);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public final BigInteger g() {
        return this.b.s();
    }

    public final BigInteger i() {
        ASN1Integer aSN1Integer = this.c;
        if (aSN1Integer == null) {
            return null;
        }
        return aSN1Integer.s();
    }

    public final BigInteger k() {
        return this.a.s();
    }

    public DHParameter(ASN1Sequence aSN1Sequence) {
        Enumeration t = aSN1Sequence.t();
        this.a = ASN1Integer.q(t.nextElement());
        this.b = ASN1Integer.q(t.nextElement());
        if (t.hasMoreElements()) {
            this.c = (ASN1Integer) t.nextElement();
        } else {
            this.c = null;
        }
    }
}
