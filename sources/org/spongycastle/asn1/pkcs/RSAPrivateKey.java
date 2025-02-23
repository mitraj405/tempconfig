package org.spongycastle.asn1.pkcs;

import java.math.BigInteger;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class RSAPrivateKey extends ASN1Object {
    public final BigInteger a;

    /* renamed from: a  reason: collision with other field name */
    public final ASN1Sequence f5704a;
    public final BigInteger b;
    public final BigInteger c;
    public final BigInteger d;
    public final BigInteger e;
    public final BigInteger f;
    public final BigInteger g;
    public final BigInteger h;
    public final BigInteger i;

    public RSAPrivateKey(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigInteger bigInteger6, BigInteger bigInteger7, BigInteger bigInteger8) {
        this.f5704a = null;
        this.a = BigInteger.valueOf(0);
        this.b = bigInteger;
        this.c = bigInteger2;
        this.d = bigInteger3;
        this.e = bigInteger4;
        this.f = bigInteger5;
        this.g = bigInteger6;
        this.h = bigInteger7;
        this.i = bigInteger8;
    }

    public static RSAPrivateKey g(Object obj) {
        if (obj instanceof RSAPrivateKey) {
            return (RSAPrivateKey) obj;
        }
        if (obj != null) {
            return new RSAPrivateKey(ASN1Sequence.q(obj));
        }
        return null;
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(new ASN1Integer(this.a));
        aSN1EncodableVector.a(new ASN1Integer(this.b));
        aSN1EncodableVector.a(new ASN1Integer(this.c));
        aSN1EncodableVector.a(new ASN1Integer(this.d));
        aSN1EncodableVector.a(new ASN1Integer(this.e));
        aSN1EncodableVector.a(new ASN1Integer(this.f));
        aSN1EncodableVector.a(new ASN1Integer(this.g));
        aSN1EncodableVector.a(new ASN1Integer(this.h));
        aSN1EncodableVector.a(new ASN1Integer(this.i));
        ASN1Sequence aSN1Sequence = this.f5704a;
        if (aSN1Sequence != null) {
            aSN1EncodableVector.a(aSN1Sequence);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public RSAPrivateKey(ASN1Sequence aSN1Sequence) {
        this.f5704a = null;
        Enumeration t = aSN1Sequence.t();
        BigInteger t2 = ((ASN1Integer) t.nextElement()).t();
        if (t2.intValue() == 0 || t2.intValue() == 1) {
            this.a = t2;
            this.b = ((ASN1Integer) t.nextElement()).t();
            this.c = ((ASN1Integer) t.nextElement()).t();
            this.d = ((ASN1Integer) t.nextElement()).t();
            this.e = ((ASN1Integer) t.nextElement()).t();
            this.f = ((ASN1Integer) t.nextElement()).t();
            this.g = ((ASN1Integer) t.nextElement()).t();
            this.h = ((ASN1Integer) t.nextElement()).t();
            this.i = ((ASN1Integer) t.nextElement()).t();
            if (t.hasMoreElements()) {
                this.f5704a = (ASN1Sequence) t.nextElement();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("wrong version for RSA private key");
    }
}
