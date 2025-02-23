package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;

public class PKIStatus extends ASN1Object {
    public final ASN1Integer a;

    static {
        new PKIStatus(0);
        new PKIStatus(1);
        new PKIStatus(2);
        new PKIStatus(3);
        new PKIStatus(4);
        new PKIStatus(5);
        new PKIStatus(6);
    }

    public PKIStatus(int i) {
        this.a = new ASN1Integer((long) i);
    }

    public final ASN1Primitive b() {
        return this.a;
    }
}
