package org.spongycastle.pqc.asn1;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.util.Arrays;

public class XMSSMTPrivateKey extends ASN1Object {
    public final byte[] a;
    public final byte[] b;
    public final int c;

    /* renamed from: c  reason: collision with other field name */
    public final byte[] f6657c;
    public final byte[] d;
    public final byte[] e;

    public XMSSMTPrivateKey(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        this.c = i;
        this.a = Arrays.c(bArr);
        this.b = Arrays.c(bArr2);
        this.f6657c = Arrays.c(bArr3);
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
        aSN1EncodableVector2.a(new DEROctetString(this.f6657c));
        aSN1EncodableVector2.a(new DEROctetString(this.d));
        aSN1EncodableVector.a(new DERSequence(aSN1EncodableVector2));
        aSN1EncodableVector.a(new DERTaggedObject(true, 0, new DEROctetString(this.e)));
        return new DERSequence(aSN1EncodableVector);
    }
}
