package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.util.Arrays;

public class SubjectKeyIdentifier extends ASN1Object {
    public final byte[] a;

    public SubjectKeyIdentifier(byte[] bArr) {
        this.a = Arrays.c(bArr);
    }

    public final ASN1Primitive b() {
        return new DEROctetString(Arrays.c(this.a));
    }
}
