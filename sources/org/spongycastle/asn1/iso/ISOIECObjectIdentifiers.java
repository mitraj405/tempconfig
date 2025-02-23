package org.spongycastle.asn1.iso;

import org.spongycastle.asn1.ASN1ObjectIdentifier;

public interface ISOIECObjectIdentifiers {
    public static final ASN1ObjectIdentifier a;
    public static final ASN1ObjectIdentifier b;
    public static final ASN1ObjectIdentifier c;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("3.0", new ASN1ObjectIdentifier("1.0.10118"));
        a = new ASN1ObjectIdentifier("49", aSN1ObjectIdentifier);
        b = new ASN1ObjectIdentifier("50", aSN1ObjectIdentifier);
        c = new ASN1ObjectIdentifier("55", aSN1ObjectIdentifier);
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier("1.0.18033.2");
        aSN1ObjectIdentifier2.q("1.2");
        aSN1ObjectIdentifier2.q("2.4");
    }
}
