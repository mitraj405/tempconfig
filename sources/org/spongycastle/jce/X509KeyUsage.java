package org.spongycastle.jce;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.x509.KeyUsage;

public class X509KeyUsage extends ASN1Object {
    public final ASN1Primitive b() {
        return new KeyUsage().a;
    }
}
