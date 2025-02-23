package org.spongycastle.asn1.bc;

import org.spongycastle.asn1.ASN1ObjectIdentifier;

public interface BCObjectIdentifiers {
    public static final ASN1ObjectIdentifier a;
    public static final ASN1ObjectIdentifier b;
    public static final ASN1ObjectIdentifier c;
    public static final ASN1ObjectIdentifier d;
    public static final ASN1ObjectIdentifier e;
    public static final ASN1ObjectIdentifier f;
    public static final ASN1ObjectIdentifier g;
    public static final ASN1ObjectIdentifier h;
    public static final ASN1ObjectIdentifier i;
    public static final ASN1ObjectIdentifier j;
    public static final ASN1ObjectIdentifier k;
    public static final ASN1ObjectIdentifier l;
    public static final ASN1ObjectIdentifier m;
    public static final ASN1ObjectIdentifier n;
    public static final ASN1ObjectIdentifier o;
    public static final ASN1ObjectIdentifier p;
    public static final ASN1ObjectIdentifier q;
    public static final ASN1ObjectIdentifier r;
    public static final ASN1ObjectIdentifier s;
    public static final ASN1ObjectIdentifier t;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.4.1.22554");
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier(C0515Ga.AVLBLTY_ONLY, aSN1ObjectIdentifier);
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = new ASN1ObjectIdentifier(C0515Ga.AVLBLTY_ONLY, aSN1ObjectIdentifier2);
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = new ASN1ObjectIdentifier("2.1", aSN1ObjectIdentifier2);
        aSN1ObjectIdentifier2.q("2.2");
        aSN1ObjectIdentifier2.q("2.3");
        aSN1ObjectIdentifier2.q("2.4");
        aSN1ObjectIdentifier3.q(C0515Ga.AVLBLTY_ONLY);
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = new ASN1ObjectIdentifier(C0515Ga.FARE_ONLY, aSN1ObjectIdentifier3);
        aSN1ObjectIdentifier4.q(C0515Ga.AVLBLTY_ONLY);
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = new ASN1ObjectIdentifier(C0515Ga.FARE_ONLY, aSN1ObjectIdentifier4);
        a = new ASN1ObjectIdentifier("1.2", aSN1ObjectIdentifier5);
        b = new ASN1ObjectIdentifier("1.22", aSN1ObjectIdentifier5);
        c = new ASN1ObjectIdentifier("1.42", aSN1ObjectIdentifier5);
        d = new ASN1ObjectIdentifier("1.2", aSN1ObjectIdentifier6);
        e = new ASN1ObjectIdentifier("1.22", aSN1ObjectIdentifier6);
        f = new ASN1ObjectIdentifier("1.42", aSN1ObjectIdentifier6);
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = new ASN1ObjectIdentifier(C0515Ga.FARE_ONLY, aSN1ObjectIdentifier);
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = new ASN1ObjectIdentifier(C0515Ga.AVLBLTY_ONLY, aSN1ObjectIdentifier7);
        g = aSN1ObjectIdentifier8;
        new ASN1ObjectIdentifier(C0515Ga.AVLBLTY_ONLY, aSN1ObjectIdentifier8);
        h = new ASN1ObjectIdentifier(C0515Ga.FARE_ONLY, aSN1ObjectIdentifier8);
        i = new ASN1ObjectIdentifier(C0515Ga.FARE_AVLBLTY, aSN1ObjectIdentifier8);
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = new ASN1ObjectIdentifier(C0515Ga.FARE_ONLY, aSN1ObjectIdentifier7);
        j = aSN1ObjectIdentifier9;
        k = new ASN1ObjectIdentifier(C0515Ga.AVLBLTY_ONLY, aSN1ObjectIdentifier9);
        l = new ASN1ObjectIdentifier(C0515Ga.FARE_ONLY, aSN1ObjectIdentifier9);
        m = new ASN1ObjectIdentifier(C0515Ga.FARE_AVLBLTY, aSN1ObjectIdentifier9);
        n = new ASN1ObjectIdentifier("4", aSN1ObjectIdentifier9);
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = new ASN1ObjectIdentifier(C0515Ga.FARE_AVLBLTY, aSN1ObjectIdentifier7);
        o = aSN1ObjectIdentifier10;
        p = new ASN1ObjectIdentifier(C0515Ga.AVLBLTY_ONLY, aSN1ObjectIdentifier10);
        q = new ASN1ObjectIdentifier(C0515Ga.FARE_ONLY, aSN1ObjectIdentifier10);
        r = new ASN1ObjectIdentifier(C0515Ga.FARE_AVLBLTY, aSN1ObjectIdentifier10);
        s = new ASN1ObjectIdentifier("4", aSN1ObjectIdentifier10);
        t = new ASN1ObjectIdentifier(C0515Ga.AVLBLTY_ONLY, new ASN1ObjectIdentifier(C0515Ga.FARE_AVLBLTY, aSN1ObjectIdentifier));
    }
}
