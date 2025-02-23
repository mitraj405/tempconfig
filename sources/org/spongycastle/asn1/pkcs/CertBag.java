package org.spongycastle.asn1.pkcs;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class CertBag extends ASN1Object {
    public final ASN1ObjectIdentifier Z0;
    public final ASN1Encodable a;

    public CertBag(ASN1Sequence aSN1Sequence) {
        this.Z0 = (ASN1ObjectIdentifier) aSN1Sequence.s(0);
        this.a = ((DERTaggedObject) aSN1Sequence.s(1)).r();
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(this.Z0);
        aSN1EncodableVector.a(new DERTaggedObject(0, this.a));
        return new DERSequence(aSN1EncodableVector);
    }

    public CertBag(ASN1ObjectIdentifier aSN1ObjectIdentifier, DEROctetString dEROctetString) {
        this.Z0 = aSN1ObjectIdentifier;
        this.a = dEROctetString;
    }
}
