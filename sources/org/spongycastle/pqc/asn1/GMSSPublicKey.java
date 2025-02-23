package org.spongycastle.pqc.asn1;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;

public class GMSSPublicKey extends ASN1Object {
    public GMSSPublicKey() {
        throw null;
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector E = C1058d.E((ASN1Encodable) null);
        E.a(new DEROctetString((byte[]) null));
        return new DERSequence(E);
    }
}
