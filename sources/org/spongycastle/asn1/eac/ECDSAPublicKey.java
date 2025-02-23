package org.spongycastle.asn1.eac;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class ECDSAPublicKey extends PublicKeyDataObject {
    public final ASN1Primitive b() {
        ASN1EncodableVector E = C1058d.E((ASN1Encodable) null);
        E.a(new DERTaggedObject(false, 6, new DEROctetString((byte[]) null)));
        return new DERSequence(E);
    }
}
