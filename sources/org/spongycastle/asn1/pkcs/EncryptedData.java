package org.spongycastle.asn1.pkcs;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.BEROctetString;
import org.spongycastle.asn1.BERSequence;
import org.spongycastle.asn1.BERTaggedObject;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class EncryptedData extends ASN1Object {
    public final ASN1Sequence a;

    public EncryptedData(ASN1Sequence aSN1Sequence) {
        if (((ASN1Integer) aSN1Sequence.s(0)).t().intValue() == 0) {
            this.a = ASN1Sequence.q(aSN1Sequence.s(1));
            return;
        }
        throw new IllegalArgumentException("sequence not version 0");
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(new ASN1Integer(0));
        aSN1EncodableVector.a(this.a);
        return new BERSequence(aSN1EncodableVector);
    }

    public EncryptedData(ASN1ObjectIdentifier aSN1ObjectIdentifier, AlgorithmIdentifier algorithmIdentifier, BEROctetString bEROctetString) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(aSN1ObjectIdentifier);
        aSN1EncodableVector.a(algorithmIdentifier.b());
        aSN1EncodableVector.a(new BERTaggedObject(false, 0, bEROctetString));
        this.a = new BERSequence(aSN1EncodableVector);
    }
}
