package org.spongycastle.asn1.x509.sigi;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class NameOrPseudonym extends ASN1Object implements ASN1Choice {
    public final ASN1Primitive b() {
        return new DERSequence(xx.M((ASN1Encodable) null, (ASN1Encodable) null));
    }
}
