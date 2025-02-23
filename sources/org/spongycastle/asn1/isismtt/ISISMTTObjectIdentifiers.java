package org.spongycastle.asn1.isismtt;

import org.spongycastle.asn1.ASN1ObjectIdentifier;

public interface ISISMTTObjectIdentifiers {
    public static final ASN1ObjectIdentifier a;
    public static final ASN1ObjectIdentifier b;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.36.8");
        new ASN1ObjectIdentifier(C0515Ga.AVLBLTY_ONLY, aSN1ObjectIdentifier).q(C0515Ga.AVLBLTY_ONLY);
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier(C0515Ga.FARE_AVLBLTY, aSN1ObjectIdentifier);
        a = new ASN1ObjectIdentifier(C0515Ga.AVLBLTY_ONLY, aSN1ObjectIdentifier2);
        C1058d.J(aSN1ObjectIdentifier2, C0515Ga.FARE_ONLY, C0515Ga.FARE_AVLBLTY, "4", "5");
        C1058d.J(aSN1ObjectIdentifier2, "6", "7", "8", "9");
        aSN1ObjectIdentifier2.q("10");
        b = new ASN1ObjectIdentifier("11", aSN1ObjectIdentifier2);
        aSN1ObjectIdentifier2.q("12");
        aSN1ObjectIdentifier2.q("13");
        aSN1ObjectIdentifier2.q("14");
        aSN1ObjectIdentifier2.q("15");
        new ASN1ObjectIdentifier("0.2.262.1.10.12.0");
    }
}
