package org.spongycastle.asn1.eac;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class RSAPublicKey extends PublicKeyDataObject {
    public final ASN1Primitive b() {
        ASN1EncodableVector E = C1058d.E((ASN1Encodable) null);
        E.a(new UnsignedInteger(1));
        E.a(new UnsignedInteger(2));
        return new DERSequence(E);
    }
}
