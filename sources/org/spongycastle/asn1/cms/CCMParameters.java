package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.util.Arrays;

public class CCMParameters extends ASN1Object {
    public final byte[] a;
    public final int c;

    public CCMParameters(ASN1Sequence aSN1Sequence) {
        this.a = ASN1OctetString.q(aSN1Sequence.s(0)).s();
        if (aSN1Sequence.size() == 2) {
            this.c = ASN1Integer.q(aSN1Sequence.s(1)).t().intValue();
        } else {
            this.c = 12;
        }
    }

    public static CCMParameters g(Object obj) {
        if (obj instanceof CCMParameters) {
            return (CCMParameters) obj;
        }
        if (obj != null) {
            return new CCMParameters(ASN1Sequence.q(obj));
        }
        return null;
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(new DEROctetString(this.a));
        int i = this.c;
        if (i != 12) {
            aSN1EncodableVector.a(new ASN1Integer((long) i));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public final byte[] h() {
        return Arrays.c(this.a);
    }

    public CCMParameters(byte[] bArr, int i) {
        this.a = Arrays.c(bArr);
        this.c = i;
    }
}
