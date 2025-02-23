package org.spongycastle.asn1.esf;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class SignerLocation extends ASN1Object {
    public final ASN1Primitive b() {
        return new DERSequence(new ASN1EncodableVector());
    }
}
