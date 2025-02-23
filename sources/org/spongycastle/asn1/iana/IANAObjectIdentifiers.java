package org.spongycastle.asn1.iana;

import org.spongycastle.asn1.ASN1ObjectIdentifier;

public interface IANAObjectIdentifiers {
    public static final ASN1ObjectIdentifier a;
    public static final ASN1ObjectIdentifier b;
    public static final ASN1ObjectIdentifier c;
    public static final ASN1ObjectIdentifier d;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1");
        aSN1ObjectIdentifier.q(C0515Ga.AVLBLTY_ONLY);
        aSN1ObjectIdentifier.q(C0515Ga.FARE_ONLY);
        aSN1ObjectIdentifier.q(C0515Ga.FARE_AVLBLTY);
        aSN1ObjectIdentifier.q("4");
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier("5", aSN1ObjectIdentifier);
        aSN1ObjectIdentifier.q("6");
        aSN1ObjectIdentifier.q("7");
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = new ASN1ObjectIdentifier("5", aSN1ObjectIdentifier2);
        aSN1ObjectIdentifier2.q("6");
        aSN1ObjectIdentifier3.q("6");
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = new ASN1ObjectIdentifier(C0515Ga.AVLBLTY_ONLY, new ASN1ObjectIdentifier("8", aSN1ObjectIdentifier3));
        a = new ASN1ObjectIdentifier(C0515Ga.AVLBLTY_ONLY, aSN1ObjectIdentifier4);
        b = new ASN1ObjectIdentifier(C0515Ga.FARE_ONLY, aSN1ObjectIdentifier4);
        c = new ASN1ObjectIdentifier(C0515Ga.FARE_AVLBLTY, aSN1ObjectIdentifier4);
        d = new ASN1ObjectIdentifier("4", aSN1ObjectIdentifier4);
    }
}
