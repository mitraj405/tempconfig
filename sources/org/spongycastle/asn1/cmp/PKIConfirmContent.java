package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERNull;

public class PKIConfirmContent extends ASN1Object {
    public final DERNull a = DERNull.a;

    public final ASN1Primitive b() {
        return this.a;
    }
}
