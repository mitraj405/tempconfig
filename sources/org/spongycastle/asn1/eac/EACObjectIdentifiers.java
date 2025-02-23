package org.spongycastle.asn1.eac;

import org.spongycastle.asn1.ASN1ObjectIdentifier;

public interface EACObjectIdentifiers {
    public static final ASN1ObjectIdentifier a;
    public static final ASN1ObjectIdentifier b;
    public static final ASN1ObjectIdentifier c;
    public static final ASN1ObjectIdentifier d;
    public static final ASN1ObjectIdentifier e;
    public static final ASN1ObjectIdentifier f;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("0.4.0.127.0.7");
        a = aSN1ObjectIdentifier;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier("2.2.1", aSN1ObjectIdentifier);
        aSN1ObjectIdentifier2.q(C0515Ga.AVLBLTY_ONLY);
        aSN1ObjectIdentifier2.q(C0515Ga.FARE_ONLY);
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = new ASN1ObjectIdentifier("2.2.3", aSN1ObjectIdentifier);
        new ASN1ObjectIdentifier(C0515Ga.AVLBLTY_ONLY, aSN1ObjectIdentifier3).q(C0515Ga.AVLBLTY_ONLY);
        new ASN1ObjectIdentifier(C0515Ga.FARE_ONLY, aSN1ObjectIdentifier3).q(C0515Ga.AVLBLTY_ONLY);
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = new ASN1ObjectIdentifier("2.2.2", aSN1ObjectIdentifier);
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = new ASN1ObjectIdentifier(C0515Ga.AVLBLTY_ONLY, aSN1ObjectIdentifier4);
        aSN1ObjectIdentifier5.q(C0515Ga.AVLBLTY_ONLY);
        aSN1ObjectIdentifier5.q(C0515Ga.FARE_ONLY);
        aSN1ObjectIdentifier5.q(C0515Ga.FARE_AVLBLTY);
        aSN1ObjectIdentifier5.q("4");
        aSN1ObjectIdentifier5.q("5");
        aSN1ObjectIdentifier5.q("6");
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = new ASN1ObjectIdentifier(C0515Ga.FARE_ONLY, aSN1ObjectIdentifier4);
        b = new ASN1ObjectIdentifier(C0515Ga.AVLBLTY_ONLY, aSN1ObjectIdentifier6);
        c = new ASN1ObjectIdentifier(C0515Ga.FARE_ONLY, aSN1ObjectIdentifier6);
        d = new ASN1ObjectIdentifier(C0515Ga.FARE_AVLBLTY, aSN1ObjectIdentifier6);
        e = new ASN1ObjectIdentifier("4", aSN1ObjectIdentifier6);
        f = new ASN1ObjectIdentifier("5", aSN1ObjectIdentifier6);
        aSN1ObjectIdentifier.q("3.1.2.1");
    }
}
