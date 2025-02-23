package org.spongycastle.asn1.x500;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x500.style.AbstractX500NameStyle;
import org.spongycastle.asn1.x500.style.BCStyle;
import org.spongycastle.asn1.x500.style.RFC4519Style;

public class X500Name extends ASN1Object implements ASN1Choice {
    public static final BCStyle a = BCStyle.f5722a;

    /* renamed from: a  reason: collision with other field name */
    public final X500NameStyle f5719a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5720a;

    /* renamed from: a  reason: collision with other field name */
    public final RDN[] f5721a;
    public int c;

    public X500Name(RFC4519Style rFC4519Style, X500Name x500Name) {
        this.f5721a = x500Name.f5721a;
        this.f5719a = rFC4519Style;
    }

    public static X500Name g(Object obj) {
        if (obj instanceof X500Name) {
            return (X500Name) obj;
        }
        if (obj != null) {
            return new X500Name(ASN1Sequence.q(obj));
        }
        return null;
    }

    public final ASN1Primitive b() {
        return new DERSequence((ASN1Encodable[]) this.f5721a);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof X500Name) && !(obj instanceof ASN1Sequence)) {
            return false;
        }
        if (b().equals(((ASN1Encodable) obj).b())) {
            return true;
        }
        try {
            return this.f5719a.b(this, new X500Name(ASN1Sequence.q(((ASN1Encodable) obj).b())));
        } catch (Exception unused) {
            return false;
        }
    }

    public final RDN[] h() {
        RDN[] rdnArr = this.f5721a;
        int length = rdnArr.length;
        RDN[] rdnArr2 = new RDN[length];
        System.arraycopy(rdnArr, 0, rdnArr2, 0, length);
        return rdnArr2;
    }

    public final int hashCode() {
        if (this.f5720a) {
            return this.c;
        }
        this.f5720a = true;
        int c2 = this.f5719a.c(this);
        this.c = c2;
        return c2;
    }

    public final String toString() {
        return this.f5719a.a(this);
    }

    public X500Name(ASN1Sequence aSN1Sequence) {
        this((AbstractX500NameStyle) a, aSN1Sequence);
    }

    public X500Name(AbstractX500NameStyle abstractX500NameStyle, ASN1Sequence aSN1Sequence) {
        RDN rdn;
        this.f5719a = abstractX500NameStyle;
        this.f5721a = new RDN[aSN1Sequence.size()];
        Enumeration t = aSN1Sequence.t();
        int i = 0;
        while (t.hasMoreElements()) {
            RDN[] rdnArr = this.f5721a;
            int i2 = i + 1;
            Object nextElement = t.nextElement();
            if (nextElement instanceof RDN) {
                rdn = (RDN) nextElement;
            } else {
                rdn = nextElement != null ? new RDN(ASN1Set.q(nextElement)) : null;
            }
            rdnArr[i] = rdn;
            i = i2;
        }
    }
}
