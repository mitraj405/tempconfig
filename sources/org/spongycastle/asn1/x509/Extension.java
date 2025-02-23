package org.spongycastle.asn1.x509;

import java.io.IOException;
import org.spongycastle.asn1.ASN1Boolean;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class Extension extends ASN1Object {
    public static final ASN1ObjectIdentifier a1 = new ASN1ObjectIdentifier("2.5.29.15").v();
    public static final ASN1ObjectIdentifier b1 = new ASN1ObjectIdentifier("2.5.29.17").v();
    public static final ASN1ObjectIdentifier c1 = lf.p("2.5.29.18");
    public static final ASN1ObjectIdentifier d1 = lf.p("2.5.29.19");
    public static final ASN1ObjectIdentifier e1 = lf.p("2.5.29.20");
    public static final ASN1ObjectIdentifier f1 = lf.p("2.5.29.21");
    public static final ASN1ObjectIdentifier g1 = new ASN1ObjectIdentifier("2.5.29.27").v();
    public static final ASN1ObjectIdentifier h1 = lf.p("2.5.29.28");
    public static final ASN1ObjectIdentifier i1 = lf.p("2.5.29.29");
    public static final ASN1ObjectIdentifier j1 = lf.p("2.5.29.30");
    public static final ASN1ObjectIdentifier k1 = lf.p("2.5.29.31");
    public static final ASN1ObjectIdentifier l1 = lf.p("2.5.29.32");
    public static final ASN1ObjectIdentifier m1 = lf.p("2.5.29.33");
    public static final ASN1ObjectIdentifier n1 = lf.p("2.5.29.35");
    public static final ASN1ObjectIdentifier o1 = lf.p("2.5.29.36");
    public static final ASN1ObjectIdentifier p1 = lf.p("2.5.29.37");
    public static final ASN1ObjectIdentifier q1 = lf.p("2.5.29.46");
    public static final ASN1ObjectIdentifier r1 = lf.p("2.5.29.54");
    public static final ASN1ObjectIdentifier s1 = lf.p("1.3.6.1.5.5.7.1.1");
    public static final ASN1ObjectIdentifier t1 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.3").v();
    public static final ASN1ObjectIdentifier u1 = new ASN1ObjectIdentifier("2.5.29.56").v();
    public static final ASN1ObjectIdentifier v1 = lf.p("2.5.29.55");
    public final ASN1ObjectIdentifier Z0;
    public final ASN1OctetString a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f5740a;

    static {
        new ASN1ObjectIdentifier("2.5.29.9").v();
        new ASN1ObjectIdentifier("2.5.29.14").v();
        new ASN1ObjectIdentifier("2.5.29.16").v();
        new ASN1ObjectIdentifier("2.5.29.23").v();
        new ASN1ObjectIdentifier("2.5.29.24").v();
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.11").v();
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.12").v();
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.2").v();
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.4").v();
        new ASN1ObjectIdentifier("2.5.29.60").v();
    }

    public Extension(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            this.Z0 = ASN1ObjectIdentifier.u(aSN1Sequence.s(0));
            this.f5740a = false;
            this.a = ASN1OctetString.q(aSN1Sequence.s(1));
        } else if (aSN1Sequence.size() == 3) {
            this.Z0 = ASN1ObjectIdentifier.u(aSN1Sequence.s(0));
            this.f5740a = ASN1Boolean.r(aSN1Sequence.s(1)).t();
            this.a = ASN1OctetString.q(aSN1Sequence.s(2));
        } else {
            throw new IllegalArgumentException(C0709Uj.k(aSN1Sequence, new StringBuilder("Bad sequence size: ")));
        }
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(this.Z0);
        if (this.f5740a) {
            aSN1EncodableVector.a(ASN1Boolean.b);
        }
        aSN1EncodableVector.a(this.a);
        return new DERSequence(aSN1EncodableVector);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Extension)) {
            return false;
        }
        Extension extension = (Extension) obj;
        if (!extension.Z0.equals(this.Z0) || !extension.a.equals(this.a) || extension.f5740a != this.f5740a) {
            return false;
        }
        return true;
    }

    public final ASN1Primitive g() {
        try {
            return ASN1Primitive.k(this.a.s());
        } catch (IOException e) {
            throw new IllegalArgumentException("can't convert extension: " + e);
        }
    }

    public final int hashCode() {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this.Z0;
        ASN1OctetString aSN1OctetString = this.a;
        if (this.f5740a) {
            return aSN1ObjectIdentifier.hashCode() ^ aSN1OctetString.hashCode();
        }
        return ~(aSN1ObjectIdentifier.hashCode() ^ aSN1OctetString.hashCode());
    }
}
