package org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

public class DERSequence extends ASN1Sequence {
    public int c = -1;

    public DERSequence() {
    }

    public final void h(ASN1OutputStream aSN1OutputStream) throws IOException {
        DEROutputStream a = aSN1OutputStream.a();
        int v = v();
        aSN1OutputStream.c(48);
        aSN1OutputStream.f(v);
        Enumeration t = t();
        while (t.hasMoreElements()) {
            a.g((ASN1Encodable) t.nextElement());
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
                i += ((ASN1Encodable) t.nextElement()).b().o().i();
            }
            this.c = i;
        }
        return this.c;
    }

    public DERSequence(int i) {
        super((ASN1Primitive) null);
    }

    public DERSequence(ASN1EncodableVector aSN1EncodableVector) {
        super(aSN1EncodableVector);
    }

    public DERSequence(ASN1Encodable[] aSN1EncodableArr) {
        super(aSN1EncodableArr);
    }
}
