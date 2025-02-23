package org.spongycastle.asn1.gm;

import org.spongycastle.asn1.ASN1ObjectIdentifier;

public interface GMObjectIdentifiers {
    public static final ASN1ObjectIdentifier a;
    public static final ASN1ObjectIdentifier b;
    public static final ASN1ObjectIdentifier c;
    public static final ASN1ObjectIdentifier d;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.2.156.10197.1");
        aSN1ObjectIdentifier.q("101.1");
        aSN1ObjectIdentifier.q("101.2");
        aSN1ObjectIdentifier.q("101.3");
        aSN1ObjectIdentifier.q("101.4");
        C1058d.J(aSN1ObjectIdentifier, "102.1", "102.2", "102.3", "102.4");
        C1058d.J(aSN1ObjectIdentifier, "102.5", "102.6", "103.1", "103.2");
        C1058d.J(aSN1ObjectIdentifier, "103.3", "103.4", "103.5", "103.6");
        C1058d.J(aSN1ObjectIdentifier, "104.1", "104.2", "104.3", "104.4");
        C1058d.J(aSN1ObjectIdentifier, "104.5", "104.6", "104.7", "104.8");
        C1058d.J(aSN1ObjectIdentifier, "104.9", "104.10", "104.11", "104.12");
        aSN1ObjectIdentifier.q("104.100");
        aSN1ObjectIdentifier.q("201");
        a = new ASN1ObjectIdentifier("301", aSN1ObjectIdentifier);
        aSN1ObjectIdentifier.q("301.1");
        aSN1ObjectIdentifier.q("301.2");
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier("301.3", aSN1ObjectIdentifier);
        b = new ASN1ObjectIdentifier("301.101", aSN1ObjectIdentifier);
        C1058d.J(aSN1ObjectIdentifier2, C0515Ga.AVLBLTY_ONLY, C0515Ga.FARE_ONLY, "2.1", "2.2");
        C1058d.J(aSN1ObjectIdentifier2, "2.3", "2.4", "2.5", "2.6");
        C1058d.J(aSN1ObjectIdentifier2, "2.7", "2.8", "2.9", "2.10");
        aSN1ObjectIdentifier2.q("2.11");
        aSN1ObjectIdentifier.q("302");
        aSN1ObjectIdentifier.q("302.1");
        aSN1ObjectIdentifier.q("302.2");
        aSN1ObjectIdentifier.q("302.3");
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = new ASN1ObjectIdentifier("401", aSN1ObjectIdentifier);
        c = aSN1ObjectIdentifier3;
        aSN1ObjectIdentifier3.q(C0515Ga.FARE_ONLY);
        d = new ASN1ObjectIdentifier("501", aSN1ObjectIdentifier);
        C1058d.J(aSN1ObjectIdentifier, "502", "503", "504", "505");
        C1058d.J(aSN1ObjectIdentifier, "506", "507", "520", "521");
        aSN1ObjectIdentifier.q("522");
    }
}
