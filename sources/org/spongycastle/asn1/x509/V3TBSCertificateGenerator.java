package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.DERTaggedObject;

public class V3TBSCertificateGenerator {
    public V3TBSCertificateGenerator() {
        new DERTaggedObject(true, 0, new ASN1Integer(2));
    }
}
