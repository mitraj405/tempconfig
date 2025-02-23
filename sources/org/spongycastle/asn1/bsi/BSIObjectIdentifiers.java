package org.spongycastle.asn1.bsi;

import org.spongycastle.asn1.ASN1ObjectIdentifier;

public interface BSIObjectIdentifiers {
    public static final ASN1ObjectIdentifier a;
    public static final ASN1ObjectIdentifier b;
    public static final ASN1ObjectIdentifier c;
    public static final ASN1ObjectIdentifier d;
    public static final ASN1ObjectIdentifier e;
    public static final ASN1ObjectIdentifier f;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("4.1", new ASN1ObjectIdentifier("1.1", new ASN1ObjectIdentifier("0.4.0.127.0.7")));
        a = new ASN1ObjectIdentifier(C0515Ga.AVLBLTY_ONLY, aSN1ObjectIdentifier);
        b = new ASN1ObjectIdentifier(C0515Ga.FARE_ONLY, aSN1ObjectIdentifier);
        c = new ASN1ObjectIdentifier(C0515Ga.FARE_AVLBLTY, aSN1ObjectIdentifier);
        d = new ASN1ObjectIdentifier("4", aSN1ObjectIdentifier);
        e = new ASN1ObjectIdentifier("5", aSN1ObjectIdentifier);
        f = new ASN1ObjectIdentifier("6", aSN1ObjectIdentifier);
    }
}
