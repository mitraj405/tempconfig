package org.spongycastle.asn1.x509;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.TBSCertList;

public class CertificateList extends ASN1Object {
    public final DERBitString a;

    /* renamed from: a  reason: collision with other field name */
    public final AlgorithmIdentifier f5734a;

    /* renamed from: a  reason: collision with other field name */
    public final TBSCertList f5735a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5736a = false;
    public int c;

    public CertificateList(ASN1Sequence aSN1Sequence) {
        TBSCertList tBSCertList;
        if (aSN1Sequence.size() == 3) {
            ASN1Encodable s = aSN1Sequence.s(0);
            if (s instanceof TBSCertList) {
                tBSCertList = (TBSCertList) s;
            } else if (s != null) {
                tBSCertList = new TBSCertList(ASN1Sequence.q(s));
            } else {
                tBSCertList = null;
            }
            this.f5735a = tBSCertList;
            this.f5734a = AlgorithmIdentifier.g(aSN1Sequence.s(1));
            this.a = DERBitString.u(aSN1Sequence.s(2));
            return;
        }
        throw new IllegalArgumentException("sequence wrong size for CertificateList");
    }

    public static CertificateList g(Object obj) {
        if (obj instanceof CertificateList) {
            return (CertificateList) obj;
        }
        if (obj != null) {
            return new CertificateList(ASN1Sequence.q(obj));
        }
        return null;
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(this.f5735a);
        aSN1EncodableVector.a(this.f5734a);
        aSN1EncodableVector.a(this.a);
        return new DERSequence(aSN1EncodableVector);
    }

    public final Enumeration h() {
        ASN1Sequence aSN1Sequence = this.f5735a.f5754a;
        if (aSN1Sequence == null) {
            return new TBSCertList.EmptyEnumeration();
        }
        return new TBSCertList.RevokedCertificatesEnumeration(aSN1Sequence.t());
    }

    public final int hashCode() {
        if (!this.f5736a) {
            this.c = super.hashCode();
            this.f5736a = true;
        }
        return this.c;
    }
}
