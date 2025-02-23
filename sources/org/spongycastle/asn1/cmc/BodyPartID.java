package org.spongycastle.asn1.cmc;

import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;

public class BodyPartID extends ASN1Object {
    public final ASN1Primitive b() {
        return new ASN1Integer(0);
    }
}
