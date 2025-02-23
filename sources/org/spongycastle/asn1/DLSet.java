package org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

public class DLSet extends ASN1Set {
    public int c = -1;

    public DLSet() {
    }

    public final void h(ASN1OutputStream aSN1OutputStream) throws IOException {
        ASN1OutputStream b = aSN1OutputStream.b();
        int v = v();
        aSN1OutputStream.c(49);
        aSN1OutputStream.f(v);
        Enumeration t = t();
        while (t.hasMoreElements()) {
            b.g((ASN1Encodable) t.nextElement());
        }
    }

    public final int i() throws IOException {
        int v = v();
        return StreamUtil.a(v) + 1 + v;
    }

    public final int v() throws IOException {
        if (this.c < 0) {
            Enumeration t = t();
            int i = 0;
            while (t.hasMoreElements()) {
                i += ((ASN1Encodable) t.nextElement()).b().p().i();
            }
            this.c = i;
        }
        return this.c;
    }

    public DLSet(ASN1Primitive aSN1Primitive) {
        super(aSN1Primitive);
    }

    public DLSet(ASN1EncodableVector aSN1EncodableVector) {
        super(aSN1EncodableVector, false);
    }

    public DLSet(ASN1Encodable[] aSN1EncodableArr) {
        super(aSN1EncodableArr, false);
    }
}
