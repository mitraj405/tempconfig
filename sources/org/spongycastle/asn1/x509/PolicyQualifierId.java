package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1ObjectIdentifier;

public class PolicyQualifierId extends ASN1ObjectIdentifier {
    static {
        new PolicyQualifierId("1.3.6.1.5.5.7.2.1");
        new PolicyQualifierId("1.3.6.1.5.5.7.2.2");
    }

    public PolicyQualifierId(String str) {
        super(str);
    }
}
