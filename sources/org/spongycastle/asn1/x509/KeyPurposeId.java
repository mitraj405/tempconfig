package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;

public class KeyPurposeId extends ASN1Object {
    public final ASN1ObjectIdentifier Z0;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.3");
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = Extension.p1;
        aSN1ObjectIdentifier2.getClass();
        new KeyPurposeId(new ASN1ObjectIdentifier("0", aSN1ObjectIdentifier2));
        new KeyPurposeId(new ASN1ObjectIdentifier(C0515Ga.AVLBLTY_ONLY, aSN1ObjectIdentifier));
        new KeyPurposeId(new ASN1ObjectIdentifier(C0515Ga.FARE_ONLY, aSN1ObjectIdentifier));
        new KeyPurposeId(new ASN1ObjectIdentifier(C0515Ga.FARE_AVLBLTY, aSN1ObjectIdentifier));
        new KeyPurposeId(new ASN1ObjectIdentifier("4", aSN1ObjectIdentifier));
        new KeyPurposeId(new ASN1ObjectIdentifier("5", aSN1ObjectIdentifier));
        new KeyPurposeId(new ASN1ObjectIdentifier("6", aSN1ObjectIdentifier));
        new KeyPurposeId(new ASN1ObjectIdentifier("7", aSN1ObjectIdentifier));
        new KeyPurposeId(new ASN1ObjectIdentifier("8", aSN1ObjectIdentifier));
        new KeyPurposeId(new ASN1ObjectIdentifier("9", aSN1ObjectIdentifier));
        new KeyPurposeId(new ASN1ObjectIdentifier("10", aSN1ObjectIdentifier));
        new KeyPurposeId(new ASN1ObjectIdentifier("11", aSN1ObjectIdentifier));
        new KeyPurposeId(new ASN1ObjectIdentifier("12", aSN1ObjectIdentifier));
        new KeyPurposeId(new ASN1ObjectIdentifier("13", aSN1ObjectIdentifier));
        new KeyPurposeId(new ASN1ObjectIdentifier("14", aSN1ObjectIdentifier));
        new KeyPurposeId(new ASN1ObjectIdentifier("15", aSN1ObjectIdentifier));
        new KeyPurposeId(new ASN1ObjectIdentifier("16", aSN1ObjectIdentifier));
        new KeyPurposeId(new ASN1ObjectIdentifier("17", aSN1ObjectIdentifier));
        new KeyPurposeId(new ASN1ObjectIdentifier("18", aSN1ObjectIdentifier));
        new KeyPurposeId(new ASN1ObjectIdentifier("19", aSN1ObjectIdentifier));
        new KeyPurposeId(new ASN1ObjectIdentifier("1.3.6.1.4.1.311.20.2.2"));
        new KeyPurposeId(new ASN1ObjectIdentifier("1.3.6.1.1.1.1.22"));
        new KeyPurposeId(new ASN1ObjectIdentifier("1.3.6.1.4.1.311.10.3.3"));
        new KeyPurposeId(new ASN1ObjectIdentifier("2.16.840.1.113730.4.1"));
    }

    public KeyPurposeId(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.Z0 = aSN1ObjectIdentifier;
    }

    public final ASN1Primitive b() {
        return this.Z0;
    }

    public final String toString() {
        return this.Z0.toString();
    }
}
