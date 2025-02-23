package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;

public class Certificate extends ASN1Object {
    public final ASN1Sequence a;

    /* renamed from: a  reason: collision with other field name */
    public final DERBitString f5731a;

    /* renamed from: a  reason: collision with other field name */
    public final AlgorithmIdentifier f5732a;

    /* renamed from: a  reason: collision with other field name */
    public final TBSCertificate f5733a;

    public Certificate(ASN1Sequence aSN1Sequence) {
        TBSCertificate tBSCertificate;
        this.a = aSN1Sequence;
        if (aSN1Sequence.size() == 3) {
            ASN1Encodable s = aSN1Sequence.s(0);
            if (s instanceof TBSCertificate) {
                tBSCertificate = (TBSCertificate) s;
            } else if (s != null) {
                tBSCertificate = new TBSCertificate(ASN1Sequence.q(s));
            } else {
                tBSCertificate = null;
            }
            this.f5733a = tBSCertificate;
            this.f5732a = AlgorithmIdentifier.g(aSN1Sequence.s(1));
            this.f5731a = DERBitString.u(aSN1Sequence.s(2));
            return;
        }
        throw new IllegalArgumentException("sequence wrong size for a certificate");
    }

    public static Certificate g(Object obj) {
        if (obj instanceof Certificate) {
            return (Certificate) obj;
        }
        if (obj != null) {
            return new Certificate(ASN1Sequence.q(obj));
        }
        return null;
    }

    public final ASN1Primitive b() {
        return this.a;
    }
}
