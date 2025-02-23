package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x509.GeneralName;

public class PKIHeader extends ASN1Object {
    static {
        new GeneralName(X500Name.g(new DERSequence()));
    }

    public final ASN1Primitive b() {
        return new DERSequence(C1058d.F((ASN1Encodable) null, (ASN1Encodable) null, (ASN1Encodable) null));
    }
}
