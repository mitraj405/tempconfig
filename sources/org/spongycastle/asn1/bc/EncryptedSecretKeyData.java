package org.spongycastle.asn1.bc;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.util.Arrays;

public class EncryptedSecretKeyData extends ASN1Object {
    public final ASN1OctetString a;

    /* renamed from: a  reason: collision with other field name */
    public final AlgorithmIdentifier f5677a;

    public EncryptedSecretKeyData(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this.f5677a = algorithmIdentifier;
        this.a = new DEROctetString(Arrays.c(bArr));
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(this.f5677a);
        aSN1EncodableVector.a(this.a);
        return new DERSequence(aSN1EncodableVector);
    }

    public EncryptedSecretKeyData(ASN1Sequence aSN1Sequence) {
        this.f5677a = AlgorithmIdentifier.g(aSN1Sequence.s(0));
        this.a = ASN1OctetString.q(aSN1Sequence.s(1));
    }
}
