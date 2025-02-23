package org.spongycastle.asn1.pkcs;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class RSAESOAEPparams extends ASN1Object {
    public static final AlgorithmIdentifier d;
    public static final AlgorithmIdentifier e;
    public static final AlgorithmIdentifier f = new AlgorithmIdentifier(PKCSObjectIdentifiers.h, new DEROctetString(new byte[0]));
    public final AlgorithmIdentifier a;
    public final AlgorithmIdentifier b;
    public final AlgorithmIdentifier c;

    static {
        AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(OIWObjectIdentifiers.f, DERNull.a);
        d = algorithmIdentifier;
        e = new AlgorithmIdentifier(PKCSObjectIdentifiers.g, algorithmIdentifier);
    }

    public RSAESOAEPparams() {
        this.a = d;
        this.b = e;
        this.c = f;
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        AlgorithmIdentifier algorithmIdentifier = d;
        AlgorithmIdentifier algorithmIdentifier2 = this.a;
        if (!algorithmIdentifier2.equals(algorithmIdentifier)) {
            aSN1EncodableVector.a(new DERTaggedObject(true, 0, algorithmIdentifier2));
        }
        AlgorithmIdentifier algorithmIdentifier3 = e;
        AlgorithmIdentifier algorithmIdentifier4 = this.b;
        if (!algorithmIdentifier4.equals(algorithmIdentifier3)) {
            aSN1EncodableVector.a(new DERTaggedObject(true, 1, algorithmIdentifier4));
        }
        AlgorithmIdentifier algorithmIdentifier5 = f;
        AlgorithmIdentifier algorithmIdentifier6 = this.c;
        if (!algorithmIdentifier6.equals(algorithmIdentifier5)) {
            aSN1EncodableVector.a(new DERTaggedObject(true, 2, algorithmIdentifier6));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public RSAESOAEPparams(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2, AlgorithmIdentifier algorithmIdentifier3) {
        this.a = algorithmIdentifier;
        this.b = algorithmIdentifier2;
        this.c = algorithmIdentifier3;
    }

    public RSAESOAEPparams(ASN1Sequence aSN1Sequence) {
        this.a = d;
        this.b = e;
        this.c = f;
        for (int i = 0; i != aSN1Sequence.size(); i++) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Sequence.s(i);
            int i2 = aSN1TaggedObject.c;
            if (i2 == 0) {
                this.a = AlgorithmIdentifier.g(ASN1Sequence.r(aSN1TaggedObject, true));
            } else if (i2 == 1) {
                this.b = AlgorithmIdentifier.g(ASN1Sequence.r(aSN1TaggedObject, true));
            } else if (i2 == 2) {
                this.c = AlgorithmIdentifier.g(ASN1Sequence.r(aSN1TaggedObject, true));
            } else {
                throw new IllegalArgumentException("unknown tag");
            }
        }
    }
}
