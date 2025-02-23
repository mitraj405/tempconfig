package org.spongycastle.asn1.bc;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.util.Arrays;

public class SecretKeyData extends ASN1Object {
    public final ASN1ObjectIdentifier Z0;
    public final ASN1OctetString a;

    public SecretKeyData(ASN1ObjectIdentifier aSN1ObjectIdentifier, byte[] bArr) {
        this.Z0 = aSN1ObjectIdentifier;
        this.a = new DEROctetString(Arrays.c(bArr));
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(this.Z0);
        aSN1EncodableVector.a(this.a);
        return new DERSequence(aSN1EncodableVector);
    }

    public SecretKeyData(ASN1Sequence aSN1Sequence) {
        this.Z0 = ASN1ObjectIdentifier.u(aSN1Sequence.s(0));
        this.a = ASN1OctetString.q(aSN1Sequence.s(1));
    }
}
