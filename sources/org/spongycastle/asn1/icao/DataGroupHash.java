package org.spongycastle.asn1.icao;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class DataGroupHash extends ASN1Object {
    public final ASN1Primitive b() {
        return new DERSequence(xx.M((ASN1Encodable) null, (ASN1Encodable) null));
    }
}
