package org.spongycastle.asn1.teletrust;

import org.spongycastle.asn1.ASN1ObjectIdentifier;

public interface TeleTrusTObjectIdentifiers {
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
    public static final ASN1ObjectIdentifier u;
    public static final ASN1ObjectIdentifier v;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.36.3");
        a = new ASN1ObjectIdentifier("2.1", aSN1ObjectIdentifier);
        b = new ASN1ObjectIdentifier("2.2", aSN1ObjectIdentifier);
        c = new ASN1ObjectIdentifier("2.3", aSN1ObjectIdentifier);
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier("3.1", aSN1ObjectIdentifier);
        d = new ASN1ObjectIdentifier(C0515Ga.FARE_ONLY, aSN1ObjectIdentifier2);
        e = new ASN1ObjectIdentifier(C0515Ga.FARE_AVLBLTY, aSN1ObjectIdentifier2);
        f = new ASN1ObjectIdentifier("4", aSN1ObjectIdentifier2);
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = new ASN1ObjectIdentifier("3.2", aSN1ObjectIdentifier);
        g = new ASN1ObjectIdentifier(C0515Ga.AVLBLTY_ONLY, aSN1ObjectIdentifier3);
        h = new ASN1ObjectIdentifier(C0515Ga.FARE_ONLY, aSN1ObjectIdentifier3);
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = new ASN1ObjectIdentifier(C0515Ga.AVLBLTY_ONLY, new ASN1ObjectIdentifier(C0515Ga.AVLBLTY_ONLY, new ASN1ObjectIdentifier("3.2.8", aSN1ObjectIdentifier)));
        i = new ASN1ObjectIdentifier(C0515Ga.AVLBLTY_ONLY, aSN1ObjectIdentifier4);
        j = new ASN1ObjectIdentifier(C0515Ga.FARE_ONLY, aSN1ObjectIdentifier4);
        k = new ASN1ObjectIdentifier(C0515Ga.FARE_AVLBLTY, aSN1ObjectIdentifier4);
        l = new ASN1ObjectIdentifier("4", aSN1ObjectIdentifier4);
        m = new ASN1ObjectIdentifier("5", aSN1ObjectIdentifier4);
        n = new ASN1ObjectIdentifier("6", aSN1ObjectIdentifier4);
        o = new ASN1ObjectIdentifier("7", aSN1ObjectIdentifier4);
        p = new ASN1ObjectIdentifier("8", aSN1ObjectIdentifier4);
        q = new ASN1ObjectIdentifier("9", aSN1ObjectIdentifier4);
        r = new ASN1ObjectIdentifier("10", aSN1ObjectIdentifier4);
        s = new ASN1ObjectIdentifier("11", aSN1ObjectIdentifier4);
        t = new ASN1ObjectIdentifier("12", aSN1ObjectIdentifier4);
        u = new ASN1ObjectIdentifier("13", aSN1ObjectIdentifier4);
        v = new ASN1ObjectIdentifier("14", aSN1ObjectIdentifier4);
    }
}
