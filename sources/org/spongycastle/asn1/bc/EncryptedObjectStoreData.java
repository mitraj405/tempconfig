package org.spongycastle.asn1.bc;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class EncryptedObjectStoreData extends ASN1Object {
    public final ASN1OctetString a;

    /* renamed from: a  reason: collision with other field name */
    public final AlgorithmIdentifier f5675a;

    public EncryptedObjectStoreData(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this.f5675a = algorithmIdentifier;
        this.a = new DEROctetString(bArr);
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(this.f5675a);
        aSN1EncodableVector.a(this.a);
        return new DERSequence(aSN1EncodableVector);
    }

    public EncryptedObjectStoreData(ASN1Sequence aSN1Sequence) {
        this.f5675a = AlgorithmIdentifier.g(aSN1Sequence.s(0));
        this.a = ASN1OctetString.q(aSN1Sequence.s(1));
    }
}
