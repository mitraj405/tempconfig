package org.spongycastle.asn1.cmc;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class PKIData extends ASN1Object {
    public final ASN1Primitive b() {
        return new DERSequence(new ASN1Encodable[]{new DERSequence((ASN1Encodable[]) null), new DERSequence((ASN1Encodable[]) null), new DERSequence((ASN1Encodable[]) null), new DERSequence((ASN1Encodable[]) null)});
    }
}
