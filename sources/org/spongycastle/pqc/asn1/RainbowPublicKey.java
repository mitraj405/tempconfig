package org.spongycastle.pqc.asn1;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.pqc.crypto.rainbow.util.RainbowUtil;

public class RainbowPublicKey extends ASN1Object {
    public final ASN1ObjectIdentifier Z0;
    public final ASN1Integer a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6651a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[][] f6652a;
    public final ASN1Integer b;

    /* renamed from: b  reason: collision with other field name */
    public final byte[][] f6653b;

    public RainbowPublicKey(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.s(0) instanceof ASN1Integer) {
            this.a = ASN1Integer.q(aSN1Sequence.s(0));
        } else {
            this.Z0 = ASN1ObjectIdentifier.u(aSN1Sequence.s(0));
        }
        this.b = ASN1Integer.q(aSN1Sequence.s(1));
        ASN1Sequence q = ASN1Sequence.q(aSN1Sequence.s(2));
        this.f6652a = new byte[q.size()][];
        for (int i = 0; i < q.size(); i++) {
            this.f6652a[i] = ASN1OctetString.q(q.s(i)).s();
        }
        ASN1Sequence aSN1Sequence2 = (ASN1Sequence) aSN1Sequence.s(3);
        this.f6653b = new byte[aSN1Sequence2.size()][];
        for (int i2 = 0; i2 < aSN1Sequence2.size(); i2++) {
            this.f6653b[i2] = ASN1OctetString.q(aSN1Sequence2.s(i2)).s();
        }
        this.f6651a = ASN1OctetString.q(((ASN1Sequence) aSN1Sequence.s(4)).s(0)).s();
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1Integer aSN1Integer = this.a;
        if (aSN1Integer != null) {
            aSN1EncodableVector.a(aSN1Integer);
        } else {
            aSN1EncodableVector.a(this.Z0);
        }
        aSN1EncodableVector.a(this.b);
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[][] bArr = this.f6652a;
            if (i2 >= bArr.length) {
                break;
            }
            aSN1EncodableVector2.a(new DEROctetString(bArr[i2]));
            i2++;
        }
        aSN1EncodableVector.a(new DERSequence(aSN1EncodableVector2));
        ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
        while (true) {
            byte[][] bArr2 = this.f6653b;
            if (i < bArr2.length) {
                aSN1EncodableVector3.a(new DEROctetString(bArr2[i]));
                i++;
            } else {
                aSN1EncodableVector.a(new DERSequence(aSN1EncodableVector3));
                ASN1EncodableVector aSN1EncodableVector4 = new ASN1EncodableVector();
                aSN1EncodableVector4.a(new DEROctetString(this.f6651a));
                aSN1EncodableVector.a(new DERSequence(aSN1EncodableVector4));
                return new DERSequence(aSN1EncodableVector);
            }
        }
    }

    public RainbowPublicKey(int i, short[][] sArr, short[][] sArr2, short[] sArr3) {
        this.a = new ASN1Integer(0);
        this.b = new ASN1Integer((long) i);
        this.f6652a = RainbowUtil.c(sArr);
        this.f6653b = RainbowUtil.c(sArr2);
        this.f6651a = RainbowUtil.a(sArr3);
    }
}
