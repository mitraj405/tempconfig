package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;

public class TargetInformation extends ASN1Object {
    public final ASN1Sequence a;

    public TargetInformation(ASN1Sequence aSN1Sequence) {
        this.a = aSN1Sequence;
    }

    public final ASN1Primitive b() {
        return this.a;
    }
}
