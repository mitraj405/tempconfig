package org.spongycastle.asn1.pkcs;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;

public class PKCS12PBEParams extends ASN1Object {
    public final ASN1Integer a;

    /* renamed from: a  reason: collision with other field name */
    public final ASN1OctetString f5699a;

    public PKCS12PBEParams(byte[] bArr, int i) {
        this.f5699a = new DEROctetString(bArr);
        this.a = new ASN1Integer((long) i);
    }

    public static PKCS12PBEParams g(ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable instanceof PKCS12PBEParams) {
            return (PKCS12PBEParams) aSN1Encodable;
        }
        if (aSN1Encodable != null) {
            return new PKCS12PBEParams(ASN1Sequence.q(aSN1Encodable));
        }
        return null;
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(this.f5699a);
        aSN1EncodableVector.a(this.a);
        return new DERSequence(aSN1EncodableVector);
    }

    public PKCS12PBEParams(ASN1Sequence aSN1Sequence) {
        this.f5699a = (ASN1OctetString) aSN1Sequence.s(0);
        this.a = ASN1Integer.q(aSN1Sequence.s(1));
    }
}
