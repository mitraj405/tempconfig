package org.spongycastle.asn1.cryptopro;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class GOST3410PublicKeyAlgParameters extends ASN1Object {
    public final ASN1ObjectIdentifier Z0;
    public final ASN1ObjectIdentifier a1;
    public final ASN1ObjectIdentifier b1;

    public GOST3410PublicKeyAlgParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1ObjectIdentifier aSN1ObjectIdentifier2) {
        this.Z0 = aSN1ObjectIdentifier;
        this.a1 = aSN1ObjectIdentifier2;
        this.b1 = null;
    }

    public static GOST3410PublicKeyAlgParameters g(ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable instanceof GOST3410PublicKeyAlgParameters) {
            return (GOST3410PublicKeyAlgParameters) aSN1Encodable;
        }
        if (aSN1Encodable != null) {
            return new GOST3410PublicKeyAlgParameters(ASN1Sequence.q(aSN1Encodable));
        }
        return null;
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(this.Z0);
        aSN1EncodableVector.a(this.a1);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this.b1;
        if (aSN1ObjectIdentifier != null) {
            aSN1EncodableVector.a(aSN1ObjectIdentifier);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public GOST3410PublicKeyAlgParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1ObjectIdentifier aSN1ObjectIdentifier2, ASN1ObjectIdentifier aSN1ObjectIdentifier3) {
        this.Z0 = aSN1ObjectIdentifier;
        this.a1 = aSN1ObjectIdentifier2;
        this.b1 = aSN1ObjectIdentifier3;
    }

    public GOST3410PublicKeyAlgParameters(ASN1Sequence aSN1Sequence) {
        this.Z0 = (ASN1ObjectIdentifier) aSN1Sequence.s(0);
        this.a1 = (ASN1ObjectIdentifier) aSN1Sequence.s(1);
        if (aSN1Sequence.size() > 2) {
            this.b1 = (ASN1ObjectIdentifier) aSN1Sequence.s(2);
        }
    }
}
