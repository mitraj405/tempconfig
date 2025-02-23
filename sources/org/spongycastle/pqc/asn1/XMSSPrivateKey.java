package org.spongycastle.pqc.asn1;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.util.Arrays;

public class XMSSPrivateKey extends ASN1Object {
    public final byte[] a;
    public final byte[] b;
    public final int c;

    /* renamed from: c  reason: collision with other field name */
    public final byte[] f6658c;
    public final byte[] d;
    public final byte[] e;

    public XMSSPrivateKey(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        this.c = i;
        this.a = Arrays.c(bArr);
        this.b = Arrays.c(bArr2);
        this.f6658c = Arrays.c(bArr3);
        this.d = Arrays.c(bArr4);
        this.e = Arrays.c(bArr5);
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(new ASN1Integer(0));
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        aSN1EncodableVector2.a(new ASN1Integer((long) this.c));
        aSN1EncodableVector2.a(new DEROctetString(this.a));
        aSN1EncodableVector2.a(new DEROctetString(this.b));
        aSN1EncodableVector2.a(new DEROctetString(this.f6658c));
        aSN1EncodableVector2.a(new DEROctetString(this.d));
        aSN1EncodableVector.a(new DERSequence(aSN1EncodableVector2));
        aSN1EncodableVector.a(new DERTaggedObject(true, 0, new DEROctetString(this.e)));
        return new DERSequence(aSN1EncodableVector);
    }

    public XMSSPrivateKey(ASN1Sequence aSN1Sequence) {
        if (!ASN1Integer.q(aSN1Sequence.s(0)).t().equals(BigInteger.valueOf(0))) {
            throw new IllegalArgumentException("unknown version of sequence");
        } else if (aSN1Sequence.size() == 2 || aSN1Sequence.size() == 3) {
            ASN1Sequence q = ASN1Sequence.q(aSN1Sequence.s(1));
            this.c = ASN1Integer.q(q.s(0)).t().intValue();
            this.a = Arrays.c(ASN1OctetString.q(q.s(1)).s());
            this.b = Arrays.c(ASN1OctetString.q(q.s(2)).s());
            this.f6658c = Arrays.c(ASN1OctetString.q(q.s(3)).s());
            this.d = Arrays.c(ASN1OctetString.q(q.s(4)).s());
            if (aSN1Sequence.size() == 3) {
                this.e = Arrays.c(ASN1OctetString.r(ASN1TaggedObject.q(aSN1Sequence.s(2)), true).s());
            } else {
                this.e = null;
            }
        } else {
            throw new IllegalArgumentException("key sequence wrong size");
        }
    }
}
