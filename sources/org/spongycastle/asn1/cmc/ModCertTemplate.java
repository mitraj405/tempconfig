package org.spongycastle.asn1.cmc;

import org.spongycastle.asn1.ASN1Boolean;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class ModCertTemplate extends ASN1Object {
    public final ASN1Primitive b() {
        ASN1EncodableVector M = xx.M((ASN1Encodable) null, (ASN1Encodable) null);
        M.a(ASN1Boolean.a);
        M.a((ASN1Encodable) null);
        return new DERSequence(M);
    }
}
