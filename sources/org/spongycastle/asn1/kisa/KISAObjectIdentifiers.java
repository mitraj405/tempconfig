package org.spongycastle.asn1.kisa;

import org.spongycastle.asn1.ASN1ObjectIdentifier;

public interface KISAObjectIdentifiers {
    public static final ASN1ObjectIdentifier a = new ASN1ObjectIdentifier("1.2.410.200004.1.4");
    public static final ASN1ObjectIdentifier b = new ASN1ObjectIdentifier("1.2.410.200004.1.7");
    public static final ASN1ObjectIdentifier c = new ASN1ObjectIdentifier("1.2.410.200004.7.1.1.1");

    static {
        new ASN1ObjectIdentifier("1.2.410.200004.1.15");
        new ASN1ObjectIdentifier("1.2.840.113549.1.9.16.0.24");
    }
}
