package org.spongycastle.asn1.dvcs;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERTaggedObject;

public class CertEtcToken extends ASN1Object implements ASN1Choice {
    public static final boolean[] a = {false, true, false, true, false, true, false, false, true};

    public final ASN1Primitive b() {
        return new DERTaggedObject(a[0], 0, (ASN1Encodable) null);
    }

    public final String toString() {
        return "CertEtcToken {\nnull}\n";
    }
}
