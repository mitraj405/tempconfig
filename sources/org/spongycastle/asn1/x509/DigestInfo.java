package org.spongycastle.asn1.x509;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;

public class DigestInfo extends ASN1Object {
    public final AlgorithmIdentifier a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f5737a;

    public DigestInfo(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this.f5737a = bArr;
        this.a = algorithmIdentifier;
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(this.a);
        aSN1EncodableVector.a(new DEROctetString(this.f5737a));
        return new DERSequence(aSN1EncodableVector);
    }

    public DigestInfo(ASN1Sequence aSN1Sequence) {
        Enumeration t = aSN1Sequence.t();
        this.a = AlgorithmIdentifier.g(t.nextElement());
        this.f5737a = ASN1OctetString.q(t.nextElement()).s();
    }
}
