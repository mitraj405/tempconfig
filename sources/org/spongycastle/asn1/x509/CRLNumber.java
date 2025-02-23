package org.spongycastle.asn1.x509;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;

public class CRLNumber extends ASN1Object {
    public final BigInteger a;

    public CRLNumber(BigInteger bigInteger) {
        this.a = bigInteger;
    }

    public final ASN1Primitive b() {
        return new ASN1Integer(this.a);
    }

    public final String toString() {
        return "CRLNumber: " + this.a;
    }
}
