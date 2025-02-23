package org.spongycastle.asn1.x509;

import java.util.Enumeration;
import java.util.NoSuchElementException;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.ASN1UTCTime;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x500.X500Name;

public class TBSCertList extends ASN1Object {
    public final ASN1Integer a;

    /* renamed from: a  reason: collision with other field name */
    public final ASN1Sequence f5754a;

    /* renamed from: a  reason: collision with other field name */
    public final X500Name f5755a;

    /* renamed from: a  reason: collision with other field name */
    public final AlgorithmIdentifier f5756a;

    /* renamed from: a  reason: collision with other field name */
    public final Extensions f5757a;

    /* renamed from: a  reason: collision with other field name */
    public final Time f5758a;
    public final Time b;

    public static class CRLEntry extends ASN1Object {
        public final ASN1Sequence a;

        /* renamed from: a  reason: collision with other field name */
        public Extensions f5759a;

        public CRLEntry(ASN1Sequence aSN1Sequence) {
            if (aSN1Sequence.size() < 2 || aSN1Sequence.size() > 3) {
                throw new IllegalArgumentException(C0709Uj.k(aSN1Sequence, new StringBuilder("Bad sequence size: ")));
            }
            this.a = aSN1Sequence;
        }

        public static CRLEntry h(Object obj) {
            if (obj instanceof CRLEntry) {
                return (CRLEntry) obj;
            }
            if (obj != null) {
                return new CRLEntry(ASN1Sequence.q(obj));
            }
            return null;
        }

        public final ASN1Primitive b() {
            return this.a;
        }

        public final Extensions g() {
            if (this.f5759a == null) {
                ASN1Sequence aSN1Sequence = this.a;
                if (aSN1Sequence.size() == 3) {
                    this.f5759a = Extensions.h(aSN1Sequence.s(2));
                }
            }
            return this.f5759a;
        }

        public final ASN1Integer i() {
            return ASN1Integer.q(this.a.s(0));
        }

        public final boolean k() {
            if (this.a.size() == 3) {
                return true;
            }
            return false;
        }
    }

    public class EmptyEnumeration implements Enumeration {
        public final boolean hasMoreElements() {
            return false;
        }

        public final Object nextElement() {
            throw new NoSuchElementException("Empty Enumeration");
        }
    }

    public class RevokedCertificatesEnumeration implements Enumeration {
        public final Enumeration a;

        public RevokedCertificatesEnumeration(Enumeration enumeration) {
            this.a = enumeration;
        }

        public final boolean hasMoreElements() {
            return this.a.hasMoreElements();
        }

        public final Object nextElement() {
            return CRLEntry.h(this.a.nextElement());
        }
    }

    public TBSCertList(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() < 3 || aSN1Sequence.size() > 7) {
            throw new IllegalArgumentException(C0709Uj.k(aSN1Sequence, new StringBuilder("Bad sequence size: ")));
        }
        int i = 0;
        if (aSN1Sequence.s(0) instanceof ASN1Integer) {
            this.a = ASN1Integer.q(aSN1Sequence.s(0));
            i = 1;
        } else {
            this.a = null;
        }
        int i2 = i + 1;
        this.f5756a = AlgorithmIdentifier.g(aSN1Sequence.s(i));
        int i3 = i2 + 1;
        this.f5755a = X500Name.g(aSN1Sequence.s(i2));
        int i4 = i3 + 1;
        this.f5758a = Time.h(aSN1Sequence.s(i3));
        if (i4 < aSN1Sequence.size() && ((aSN1Sequence.s(i4) instanceof ASN1UTCTime) || (aSN1Sequence.s(i4) instanceof ASN1GeneralizedTime) || (aSN1Sequence.s(i4) instanceof Time))) {
            this.b = Time.h(aSN1Sequence.s(i4));
            i4++;
        }
        if (i4 < aSN1Sequence.size() && !(aSN1Sequence.s(i4) instanceof ASN1TaggedObject)) {
            this.f5754a = ASN1Sequence.q(aSN1Sequence.s(i4));
            i4++;
        }
        if (i4 < aSN1Sequence.size() && (aSN1Sequence.s(i4) instanceof ASN1TaggedObject)) {
            this.f5757a = Extensions.h(ASN1Sequence.r((ASN1TaggedObject) aSN1Sequence.s(i4), true));
        }
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1Integer aSN1Integer = this.a;
        if (aSN1Integer != null) {
            aSN1EncodableVector.a(aSN1Integer);
        }
        aSN1EncodableVector.a(this.f5756a);
        aSN1EncodableVector.a(this.f5755a);
        aSN1EncodableVector.a(this.f5758a);
        Time time = this.b;
        if (time != null) {
            aSN1EncodableVector.a(time);
        }
        ASN1Sequence aSN1Sequence = this.f5754a;
        if (aSN1Sequence != null) {
            aSN1EncodableVector.a(aSN1Sequence);
        }
        Extensions extensions = this.f5757a;
        if (extensions != null) {
            aSN1EncodableVector.a(new DERTaggedObject(0, extensions));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
