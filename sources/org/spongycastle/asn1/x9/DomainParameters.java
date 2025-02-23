package org.spongycastle.asn1.x9;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class DomainParameters extends ASN1Object {
    public final ASN1Integer a;

    /* renamed from: a  reason: collision with other field name */
    public final ValidationParams f5782a;
    public final ASN1Integer b;
    public final ASN1Integer c;
    public final ASN1Integer d;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: org.spongycastle.asn1.ASN1Encodable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DomainParameters(org.spongycastle.asn1.ASN1Sequence r4) {
        /*
            r3 = this;
            r3.<init>()
            int r0 = r4.size()
            r1 = 3
            if (r0 < r1) goto L_0x007f
            int r0 = r4.size()
            r1 = 5
            if (r0 > r1) goto L_0x007f
            java.util.Enumeration r4 = r4.t()
            java.lang.Object r0 = r4.nextElement()
            org.spongycastle.asn1.ASN1Integer r0 = org.spongycastle.asn1.ASN1Integer.q(r0)
            r3.a = r0
            java.lang.Object r0 = r4.nextElement()
            org.spongycastle.asn1.ASN1Integer r0 = org.spongycastle.asn1.ASN1Integer.q(r0)
            r3.b = r0
            java.lang.Object r0 = r4.nextElement()
            org.spongycastle.asn1.ASN1Integer r0 = org.spongycastle.asn1.ASN1Integer.q(r0)
            r3.c = r0
            boolean r0 = r4.hasMoreElements()
            r1 = 0
            if (r0 == 0) goto L_0x0041
            java.lang.Object r0 = r4.nextElement()
            org.spongycastle.asn1.ASN1Encodable r0 = (org.spongycastle.asn1.ASN1Encodable) r0
            goto L_0x0042
        L_0x0041:
            r0 = r1
        L_0x0042:
            if (r0 == 0) goto L_0x005e
            boolean r2 = r0 instanceof org.spongycastle.asn1.ASN1Integer
            if (r2 == 0) goto L_0x005e
            org.spongycastle.asn1.ASN1Integer r0 = org.spongycastle.asn1.ASN1Integer.q(r0)
            r3.d = r0
            boolean r0 = r4.hasMoreElements()
            if (r0 == 0) goto L_0x005c
            java.lang.Object r4 = r4.nextElement()
            r0 = r4
            org.spongycastle.asn1.ASN1Encodable r0 = (org.spongycastle.asn1.ASN1Encodable) r0
            goto L_0x0060
        L_0x005c:
            r0 = r1
            goto L_0x0060
        L_0x005e:
            r3.d = r1
        L_0x0060:
            if (r0 == 0) goto L_0x007c
            org.spongycastle.asn1.ASN1Primitive r4 = r0.b()
            boolean r0 = r4 instanceof org.spongycastle.asn1.x9.ValidationParams
            if (r0 == 0) goto L_0x006e
            r1 = r4
            org.spongycastle.asn1.x9.ValidationParams r1 = (org.spongycastle.asn1.x9.ValidationParams) r1
            goto L_0x0079
        L_0x006e:
            if (r4 == 0) goto L_0x0079
            org.spongycastle.asn1.x9.ValidationParams r1 = new org.spongycastle.asn1.x9.ValidationParams
            org.spongycastle.asn1.ASN1Sequence r4 = org.spongycastle.asn1.ASN1Sequence.q(r4)
            r1.<init>(r4)
        L_0x0079:
            r3.f5782a = r1
            goto L_0x007e
        L_0x007c:
            r3.f5782a = r1
        L_0x007e:
            return
        L_0x007f:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Bad sequence size: "
            r1.<init>(r2)
            java.lang.String r4 = defpackage.C0709Uj.k(r4, r1)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.x9.DomainParameters.<init>(org.spongycastle.asn1.ASN1Sequence):void");
    }

    public static DomainParameters g(ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable instanceof DomainParameters) {
            return (DomainParameters) aSN1Encodable;
        }
        if (aSN1Encodable != null) {
            return new DomainParameters(ASN1Sequence.q(aSN1Encodable));
        }
        return null;
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(this.a);
        aSN1EncodableVector.a(this.b);
        aSN1EncodableVector.a(this.c);
        ASN1Integer aSN1Integer = this.d;
        if (aSN1Integer != null) {
            aSN1EncodableVector.a(aSN1Integer);
        }
        ValidationParams validationParams = this.f5782a;
        if (validationParams != null) {
            aSN1EncodableVector.a(validationParams);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
