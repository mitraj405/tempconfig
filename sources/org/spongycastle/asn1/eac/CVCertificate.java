package org.spongycastle.asn1.eac;

import java.io.IOException;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERApplicationSpecific;
import org.spongycastle.asn1.DEROctetString;

public class CVCertificate extends ASN1Object {
    public final ASN1Primitive b() {
        ASN1EncodableVector E = C1058d.E((ASN1Encodable) null);
        try {
            E.a(new DERApplicationSpecific(55, new DEROctetString((byte[]) null)));
            return new DERApplicationSpecific(33, E);
        } catch (IOException unused) {
            throw new IllegalStateException("unable to convert signature!");
        }
    }
}
