package org.spongycastle.pqc.asn1;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.util.Arrays;

public class XMSSPublicKey extends ASN1Object {
    public final byte[] a;
    public final byte[] b;

    public XMSSPublicKey(byte[] bArr, byte[] bArr2) {
        this.a = Arrays.c(bArr);
        this.b = Arrays.c(bArr2);
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(new ASN1Integer(0));
        aSN1EncodableVector.a(new DEROctetString(this.a));
        aSN1EncodableVector.a(new DEROctetString(this.b));
        return new DERSequence(aSN1EncodableVector);
    }

    public XMSSPublicKey(ASN1Sequence aSN1Sequence) {
        if (ASN1Integer.q(aSN1Sequence.s(0)).t().equals(BigInteger.valueOf(0))) {
            this.a = Arrays.c(ASN1OctetString.q(aSN1Sequence.s(1)).s());
            this.b = Arrays.c(ASN1OctetString.q(aSN1Sequence.s(2)).s());
            return;
        }
        throw new IllegalArgumentException("unknown version of sequence");
    }
}
