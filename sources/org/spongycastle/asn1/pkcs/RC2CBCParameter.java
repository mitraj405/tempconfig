package org.spongycastle.asn1.pkcs;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;

public class RC2CBCParameter extends ASN1Object {
    public final ASN1Integer a;

    /* renamed from: a  reason: collision with other field name */
    public final ASN1OctetString f5703a;

    public RC2CBCParameter(byte[] bArr) {
        this.a = null;
        this.f5703a = new DEROctetString(bArr);
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1Integer aSN1Integer = this.a;
        if (aSN1Integer != null) {
            aSN1EncodableVector.a(aSN1Integer);
        }
        aSN1EncodableVector.a(this.f5703a);
        return new DERSequence(aSN1EncodableVector);
    }

    public RC2CBCParameter(int i, byte[] bArr) {
        this.a = new ASN1Integer((long) i);
        this.f5703a = new DEROctetString(bArr);
    }

    public RC2CBCParameter(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 1) {
            this.a = null;
            this.f5703a = (ASN1OctetString) aSN1Sequence.s(0);
            return;
        }
        this.a = (ASN1Integer) aSN1Sequence.s(0);
        this.f5703a = (ASN1OctetString) aSN1Sequence.s(1);
    }
}
