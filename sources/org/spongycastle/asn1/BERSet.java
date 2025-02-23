package org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

public class BERSet extends ASN1Set {
    public BERSet() {
    }

    public final void h(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.c(49);
        aSN1OutputStream.c(128);
        Enumeration t = t();
        while (t.hasMoreElements()) {
            aSN1OutputStream.g((ASN1Encodable) t.nextElement());
        }
        aSN1OutputStream.c(0);
        aSN1OutputStream.c(0);
    }

    public final int i() throws IOException {
        Enumeration t = t();
        int i = 0;
        while (t.hasMoreElements()) {
            i += ((ASN1Encodable) t.nextElement()).b().i();
        }
        return i + 2 + 2;
    }

    public BERSet(ASN1Primitive aSN1Primitive) {
        super(aSN1Primitive);
    }

    public BERSet(ASN1EncodableVector aSN1EncodableVector) {
        super(aSN1EncodableVector, false);
    }

    public BERSet(ASN1Encodable[] aSN1EncodableArr) {
        super(aSN1EncodableArr, false);
    }
}
