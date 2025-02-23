package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1ObjectIdentifier;

public interface X509ObjectIdentifiers {
    public static final ASN1ObjectIdentifier g0 = new ASN1ObjectIdentifier("2.5.4.20").v();
    public static final ASN1ObjectIdentifier h0 = lf.p("2.5.4.41");
    public static final ASN1ObjectIdentifier i0 = lf.p("2.5.4.97");
    public static final ASN1ObjectIdentifier j0 = lf.p("1.3.14.3.2.26");
    public static final ASN1ObjectIdentifier k0 = new ASN1ObjectIdentifier("2.5.8.1.1").v();

    static {
        new ASN1ObjectIdentifier("2.5.4.3").v();
        new ASN1ObjectIdentifier("2.5.4.6").v();
        new ASN1ObjectIdentifier("2.5.4.7").v();
        new ASN1ObjectIdentifier("2.5.4.8").v();
        new ASN1ObjectIdentifier("2.5.4.10").v();
        new ASN1ObjectIdentifier("2.5.4.11").v();
        new ASN1ObjectIdentifier("1.3.36.3.2.1").v();
        new ASN1ObjectIdentifier("1.3.36.3.3.1.2").v();
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.5.5.7");
        aSN1ObjectIdentifier.q(C0515Ga.AVLBLTY_ONLY);
        new ASN1ObjectIdentifier("2.5.29");
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier("48", aSN1ObjectIdentifier);
        new ASN1ObjectIdentifier(C0515Ga.FARE_ONLY, aSN1ObjectIdentifier2).v();
        new ASN1ObjectIdentifier(C0515Ga.AVLBLTY_ONLY, aSN1ObjectIdentifier2).v();
    }
}
