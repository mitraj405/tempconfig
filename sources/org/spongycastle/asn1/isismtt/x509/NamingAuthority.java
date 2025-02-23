package org.spongycastle.asn1.isismtt.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.isismtt.ISISMTTObjectIdentifiers;

public class NamingAuthority extends ASN1Object {
    public static final ASN1ObjectIdentifier Z0 = new ASN1ObjectIdentifier(ISISMTTObjectIdentifiers.b + ".1");

    public final ASN1Primitive b() {
        return new DERSequence(new ASN1EncodableVector());
    }
}
