package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.DERTaggedObject;

public class V1TBSCertificateGenerator {
    public V1TBSCertificateGenerator() {
        new DERTaggedObject(true, 0, new ASN1Integer(0));
    }
}
