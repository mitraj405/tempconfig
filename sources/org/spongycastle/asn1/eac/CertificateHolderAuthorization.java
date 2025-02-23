package org.spongycastle.asn1.eac;

import java.util.Hashtable;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERApplicationSpecific;

public class CertificateHolderAuthorization extends ASN1Object {
    static {
        EACObjectIdentifiers.a.q("3.1.2.1");
        Hashtable hashtable = new Hashtable();
        BidirectionalMap bidirectionalMap = new BidirectionalMap();
        new Hashtable();
        hashtable.put(2, "RADG4");
        hashtable.put(1, "RADG3");
        bidirectionalMap.put(192, "CVCA");
        bidirectionalMap.put(128, "DV_DOMESTIC");
        bidirectionalMap.put(64, "DV_FOREIGN");
        bidirectionalMap.put(0, "IS");
    }

    public final ASN1Primitive b() {
        return new DERApplicationSpecific(76, xx.M((ASN1Encodable) null, (ASN1Encodable) null));
    }
}
