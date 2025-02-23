package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class AlgorithmIdentifier extends ASN1Object {
    public final ASN1ObjectIdentifier Z0;
    public final ASN1Encodable a;

    public AlgorithmIdentifier(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.Z0 = aSN1ObjectIdentifier;
    }

    public static AlgorithmIdentifier g(Object obj) {
        if (obj instanceof AlgorithmIdentifier) {
            return (AlgorithmIdentifier) obj;
        }
        if (obj != null) {
            return new AlgorithmIdentifier(ASN1Sequence.q(obj));
        }
        return null;
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(this.Z0);
        ASN1Encodable aSN1Encodable = this.a;
        if (aSN1Encodable != null) {
            aSN1EncodableVector.a(aSN1Encodable);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public AlgorithmIdentifier(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.Z0 = aSN1ObjectIdentifier;
        this.a = aSN1Encodable;
    }

    public AlgorithmIdentifier(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() < 1 || aSN1Sequence.size() > 2) {
            throw new IllegalArgumentException(C0709Uj.k(aSN1Sequence, new StringBuilder("Bad sequence size: ")));
        }
        this.Z0 = ASN1ObjectIdentifier.u(aSN1Sequence.s(0));
        if (aSN1Sequence.size() == 2) {
            this.a = aSN1Sequence.s(1);
        } else {
            this.a = null;
        }
    }
}
