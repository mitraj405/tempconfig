package org.spongycastle.asn1.x509;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.x500.X500Name;

public class TBSCertificate extends ASN1Object {
    public final ASN1Integer a;

    /* renamed from: a  reason: collision with other field name */
    public final ASN1Sequence f5760a;

    /* renamed from: a  reason: collision with other field name */
    public final DERBitString f5761a;

    /* renamed from: a  reason: collision with other field name */
    public final X500Name f5762a;

    /* renamed from: a  reason: collision with other field name */
    public final AlgorithmIdentifier f5763a;

    /* renamed from: a  reason: collision with other field name */
    public final Extensions f5764a;

    /* renamed from: a  reason: collision with other field name */
    public final SubjectPublicKeyInfo f5765a;

    /* renamed from: a  reason: collision with other field name */
    public final Time f5766a;
    public final ASN1Integer b;

    /* renamed from: b  reason: collision with other field name */
    public final DERBitString f5767b;

    /* renamed from: b  reason: collision with other field name */
    public final X500Name f5768b;

    /* renamed from: b  reason: collision with other field name */
    public final Time f5769b;

    public TBSCertificate(ASN1Sequence aSN1Sequence) {
        int i;
        boolean z;
        boolean z2;
        this.f5760a = aSN1Sequence;
        if (aSN1Sequence.s(0) instanceof ASN1TaggedObject) {
            this.a = ASN1Integer.r((ASN1TaggedObject) aSN1Sequence.s(0), true);
            i = 0;
        } else {
            this.a = new ASN1Integer(0);
            i = -1;
        }
        if (this.a.t().equals(BigInteger.valueOf(0))) {
            z = false;
            z2 = true;
        } else if (this.a.t().equals(BigInteger.valueOf(1))) {
            z2 = false;
            z = true;
        } else if (this.a.t().equals(BigInteger.valueOf(2))) {
            z2 = false;
            z = false;
        } else {
            throw new IllegalArgumentException("version number not recognised");
        }
        this.b = ASN1Integer.q(aSN1Sequence.s(i + 1));
        this.f5763a = AlgorithmIdentifier.g(aSN1Sequence.s(i + 2));
        this.f5762a = X500Name.g(aSN1Sequence.s(i + 3));
        ASN1Sequence aSN1Sequence2 = (ASN1Sequence) aSN1Sequence.s(i + 4);
        this.f5766a = Time.h(aSN1Sequence2.s(0));
        this.f5769b = Time.h(aSN1Sequence2.s(1));
        this.f5768b = X500Name.g(aSN1Sequence.s(i + 5));
        int i2 = i + 6;
        this.f5765a = SubjectPublicKeyInfo.g(aSN1Sequence.s(i2));
        int size = (aSN1Sequence.size() - i2) - 1;
        if (size == 0 || !z2) {
            while (size > 0) {
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Sequence.s(i2 + size);
                int i3 = aSN1TaggedObject.c;
                if (i3 == 1) {
                    this.f5761a = DERBitString.v(aSN1TaggedObject);
                } else if (i3 == 2) {
                    this.f5767b = DERBitString.v(aSN1TaggedObject);
                } else if (i3 != 3) {
                    continue;
                } else if (!z) {
                    this.f5764a = Extensions.h(ASN1Sequence.r(aSN1TaggedObject, true));
                } else {
                    throw new IllegalArgumentException("version 2 certificate cannot contain extensions");
                }
                size--;
            }
            return;
        }
        throw new IllegalArgumentException("version 1 certificate contains extra data");
    }

    public final ASN1Primitive b() {
        return this.f5760a;
    }
}
