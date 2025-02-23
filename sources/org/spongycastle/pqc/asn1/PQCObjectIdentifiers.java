package org.spongycastle.pqc.asn1;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.bc.BCObjectIdentifiers;

public interface PQCObjectIdentifiers {
    public static final ASN1ObjectIdentifier a;
    public static final ASN1ObjectIdentifier b;
    public static final ASN1ObjectIdentifier c;
    public static final ASN1ObjectIdentifier d;
    public static final ASN1ObjectIdentifier e;
    public static final ASN1ObjectIdentifier f = new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.1");
    public static final ASN1ObjectIdentifier g = new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.2");
    public static final ASN1ObjectIdentifier h = BCObjectIdentifiers.g;
    public static final ASN1ObjectIdentifier i = BCObjectIdentifiers.h;
    public static final ASN1ObjectIdentifier j = BCObjectIdentifiers.i;
    public static final ASN1ObjectIdentifier k = BCObjectIdentifiers.t;
    public static final ASN1ObjectIdentifier l = BCObjectIdentifiers.j;
    public static final ASN1ObjectIdentifier m = BCObjectIdentifiers.o;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.5.3.2");
        a = aSN1ObjectIdentifier;
        aSN1ObjectIdentifier.q(C0515Ga.AVLBLTY_ONLY);
        b = new ASN1ObjectIdentifier(C0515Ga.FARE_ONLY, aSN1ObjectIdentifier);
        c = new ASN1ObjectIdentifier(C0515Ga.FARE_AVLBLTY, aSN1ObjectIdentifier);
        d = new ASN1ObjectIdentifier("4", aSN1ObjectIdentifier);
        e = new ASN1ObjectIdentifier("5", aSN1ObjectIdentifier);
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.3");
        aSN1ObjectIdentifier2.q(C0515Ga.AVLBLTY_ONLY);
        aSN1ObjectIdentifier2.q(C0515Ga.FARE_ONLY);
        aSN1ObjectIdentifier2.q(C0515Ga.FARE_AVLBLTY);
        aSN1ObjectIdentifier2.q("4");
        aSN1ObjectIdentifier2.q("5");
        new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.2.1");
        new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.2.2");
        new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.2.3");
    }
}
