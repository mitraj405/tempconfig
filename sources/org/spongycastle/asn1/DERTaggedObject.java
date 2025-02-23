package org.spongycastle.asn1;

import java.io.IOException;

public class DERTaggedObject extends ASN1TaggedObject {
    public DERTaggedObject(boolean z, int i, ASN1Encodable aSN1Encodable) {
        super(z, i, aSN1Encodable);
    }

    public final void h(ASN1OutputStream aSN1OutputStream) throws IOException {
        ASN1Primitive o = this.a.b().o();
        boolean z = this.f5664a;
        int i = this.c;
        int i2 = 160;
        if (z) {
            aSN1OutputStream.h(160, i);
            aSN1OutputStream.f(o.i());
            aSN1OutputStream.g(o);
            return;
        }
        if (!o.n()) {
            i2 = 128;
        }
        aSN1OutputStream.h(i2, i);
        aSN1OutputStream.e(o);
    }

    public final int i() throws IOException {
        int b;
        int i = this.a.b().o().i();
        boolean z = this.f5664a;
        int i2 = this.c;
        if (z) {
            b = StreamUtil.b(i2) + StreamUtil.a(i);
        } else {
            i--;
            b = StreamUtil.b(i2);
        }
        return b + i;
    }

    public final boolean n() {
        if (this.f5664a) {
            return true;
        }
        return this.a.b().o().n();
    }

    public DERTaggedObject(int i, ASN1Encodable aSN1Encodable) {
        super(true, i, aSN1Encodable);
    }
}
