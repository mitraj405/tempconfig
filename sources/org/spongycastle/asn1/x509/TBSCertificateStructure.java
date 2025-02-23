package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x500.X500Name;

public class TBSCertificateStructure extends ASN1Object implements X509ObjectIdentifiers, PKCSObjectIdentifiers {
    public final ASN1Sequence a;

    /* renamed from: a  reason: collision with other field name */
    public final X500Name f5770a;
    public final X500Name b;

    public TBSCertificateStructure(ASN1Sequence aSN1Sequence) {
        int i;
        this.a = aSN1Sequence;
        if (aSN1Sequence.s(0) instanceof DERTaggedObject) {
            ASN1Integer.r((ASN1TaggedObject) aSN1Sequence.s(0), true);
            i = 0;
        } else {
            new ASN1Integer(0);
            i = -1;
        }
        ASN1Integer.q(aSN1Sequence.s(i + 1));
        AlgorithmIdentifier.g(aSN1Sequence.s(i + 2));
        this.f5770a = X500Name.g(aSN1Sequence.s(i + 3));
        ASN1Sequence aSN1Sequence2 = (ASN1Sequence) aSN1Sequence.s(i + 4);
        Time.h(aSN1Sequence2.s(0));
        Time.h(aSN1Sequence2.s(1));
        this.b = X500Name.g(aSN1Sequence.s(i + 5));
        int i2 = i + 6;
        SubjectPublicKeyInfo.g(aSN1Sequence.s(i2));
        for (int size = (aSN1Sequence.size() - i2) - 1; size > 0; size--) {
            DERTaggedObject dERTaggedObject = (DERTaggedObject) aSN1Sequence.s(i2 + size);
            int i3 = dERTaggedObject.c;
            if (i3 == 1) {
                DERBitString.v(dERTaggedObject);
            } else if (i3 == 2) {
                DERBitString.v(dERTaggedObject);
            } else if (i3 == 3) {
                X509Extensions.g(dERTaggedObject);
            }
        }
    }

    public final ASN1Primitive b() {
        return this.a;
    }
}
