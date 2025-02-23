package org.spongycastle.asn1.misc;

import org.spongycastle.asn1.ASN1ObjectIdentifier;

public interface MiscObjectIdentifiers {
    public static final ASN1ObjectIdentifier a;
    public static final ASN1ObjectIdentifier b;
    public static final ASN1ObjectIdentifier c;
    public static final ASN1ObjectIdentifier d;
    public static final ASN1ObjectIdentifier e = new ASN1ObjectIdentifier("1.3.6.1.4.1.188.7.1.1.2");
    public static final ASN1ObjectIdentifier f;
    public static final ASN1ObjectIdentifier g;
    public static final ASN1ObjectIdentifier h;
    public static final ASN1ObjectIdentifier i;
    public static final ASN1ObjectIdentifier j;
    public static final ASN1ObjectIdentifier k;
    public static final ASN1ObjectIdentifier l;
    public static final ASN1ObjectIdentifier m;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("2.16.840.1.113730.1");
        a = new ASN1ObjectIdentifier(C0515Ga.AVLBLTY_ONLY, aSN1ObjectIdentifier);
        aSN1ObjectIdentifier.q(C0515Ga.FARE_ONLY);
        b = new ASN1ObjectIdentifier(C0515Ga.FARE_AVLBLTY, aSN1ObjectIdentifier);
        C1058d.J(aSN1ObjectIdentifier, "4", "7", "8", "12");
        aSN1ObjectIdentifier.q("13");
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier("2.16.840.1.113733.1");
        c = new ASN1ObjectIdentifier("6.3", aSN1ObjectIdentifier2);
        C1058d.J(aSN1ObjectIdentifier2, "6.9", "6.11", "6.13", "6.15");
        aSN1ObjectIdentifier2.q("8.1");
        new ASN1ObjectIdentifier("2.16.840.1.113719").q("1.9.4.1");
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = new ASN1ObjectIdentifier("1.2.840.113533.7");
        aSN1ObjectIdentifier3.q("65.0");
        d = new ASN1ObjectIdentifier("66.10", aSN1ObjectIdentifier3);
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = new ASN1ObjectIdentifier(C0515Ga.AVLBLTY_ONLY, new ASN1ObjectIdentifier("1.3.6.1.4.1.3029"));
        f = new ASN1ObjectIdentifier("1.1", aSN1ObjectIdentifier4);
        g = new ASN1ObjectIdentifier("1.2", aSN1ObjectIdentifier4);
        h = new ASN1ObjectIdentifier("1.3", aSN1ObjectIdentifier4);
        i = new ASN1ObjectIdentifier("1.4", aSN1ObjectIdentifier4);
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = new ASN1ObjectIdentifier("1.3.6.1.4.1.1722.12.2");
        j = new ASN1ObjectIdentifier("1.5", aSN1ObjectIdentifier5);
        k = new ASN1ObjectIdentifier("1.8", aSN1ObjectIdentifier5);
        l = new ASN1ObjectIdentifier("1.12", aSN1ObjectIdentifier5);
        m = new ASN1ObjectIdentifier("1.16", aSN1ObjectIdentifier5);
    }
}
