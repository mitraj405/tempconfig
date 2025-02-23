package org.spongycastle.asn1.rosstandart;

import org.spongycastle.asn1.ASN1ObjectIdentifier;

public interface RosstandartObjectIdentifiers {
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

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier(C0515Ga.AVLBLTY_ONLY, new ASN1ObjectIdentifier("1.2.643.7"));
        a = new ASN1ObjectIdentifier("1.2.2", aSN1ObjectIdentifier);
        b = new ASN1ObjectIdentifier("1.2.3", aSN1ObjectIdentifier);
        c = new ASN1ObjectIdentifier("1.4.1", aSN1ObjectIdentifier);
        d = new ASN1ObjectIdentifier("1.4.2", aSN1ObjectIdentifier);
        e = new ASN1ObjectIdentifier("1.1.1", aSN1ObjectIdentifier);
        f = new ASN1ObjectIdentifier("1.1.2", aSN1ObjectIdentifier);
        g = new ASN1ObjectIdentifier("1.3.2", aSN1ObjectIdentifier);
        h = new ASN1ObjectIdentifier("1.3.3", aSN1ObjectIdentifier);
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier("1.6", aSN1ObjectIdentifier);
        i = new ASN1ObjectIdentifier(C0515Ga.AVLBLTY_ONLY, aSN1ObjectIdentifier2);
        j = new ASN1ObjectIdentifier(C0515Ga.FARE_ONLY, aSN1ObjectIdentifier2);
        k = new ASN1ObjectIdentifier("2.1.1.1", aSN1ObjectIdentifier);
        l = new ASN1ObjectIdentifier("2.1.2.1", aSN1ObjectIdentifier);
        m = new ASN1ObjectIdentifier("2.1.2.2", aSN1ObjectIdentifier);
        n = new ASN1ObjectIdentifier("2.1.2.3", aSN1ObjectIdentifier);
        aSN1ObjectIdentifier.q("2.5.1.1");
    }
}
