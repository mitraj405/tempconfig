package org.spongycastle.asn1.cmc;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class ControlsProcessed extends ASN1Object {
    public final ASN1Primitive b() {
        return new DERSequence(0);
    }
}
