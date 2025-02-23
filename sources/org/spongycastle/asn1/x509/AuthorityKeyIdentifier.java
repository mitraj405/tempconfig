package org.spongycastle.asn1.x509;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class AuthorityKeyIdentifier extends ASN1Object {
    public final ASN1Integer a = null;

    /* renamed from: a  reason: collision with other field name */
    public final ASN1OctetString f5726a = null;

    /* renamed from: a  reason: collision with other field name */
    public final GeneralNames f5727a = null;

    public AuthorityKeyIdentifier(ASN1Sequence aSN1Sequence) {
        Enumeration t = aSN1Sequence.t();
        while (t.hasMoreElements()) {
            ASN1TaggedObject q = ASN1TaggedObject.q(t.nextElement());
            int i = q.c;
            if (i == 0) {
                this.f5726a = ASN1OctetString.r(q, false);
            } else if (i == 1) {
                this.f5727a = GeneralNames.g(ASN1Sequence.r(q, false));
            } else if (i == 2) {
                this.a = ASN1Integer.r(q, false);
            } else {
                throw new IllegalArgumentException("illegal tag");
            }
        }
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1OctetString aSN1OctetString = this.f5726a;
        if (aSN1OctetString != null) {
            aSN1EncodableVector.a(new DERTaggedObject(false, 0, aSN1OctetString));
        }
        GeneralNames generalNames = this.f5727a;
        if (generalNames != null) {
            aSN1EncodableVector.a(new DERTaggedObject(false, 1, generalNames));
        }
        ASN1Integer aSN1Integer = this.a;
        if (aSN1Integer != null) {
            aSN1EncodableVector.a(new DERTaggedObject(false, 2, aSN1Integer));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public final String toString() {
        return "AuthorityKeyIdentifier: KeyID(" + this.f5726a.s() + ")";
    }
}
