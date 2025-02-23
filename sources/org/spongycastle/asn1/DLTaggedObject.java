package org.spongycastle.asn1;

import java.io.IOException;

public class DLTaggedObject extends ASN1TaggedObject {
    public DLTaggedObject(boolean z, int i, ASN1Encodable aSN1Encodable) {
        super(z, i, aSN1Encodable);
    }

    public final void h(ASN1OutputStream aSN1OutputStream) throws IOException {
        ASN1Primitive p = this.a.b().p();
        boolean z = this.f5664a;
        int i = this.c;
        int i2 = 160;
        if (z) {
            aSN1OutputStream.h(160, i);
            aSN1OutputStream.f(p.i());
            aSN1OutputStream.g(p);
            return;
        }
        if (!p.n()) {
            i2 = 128;
        }
        aSN1OutputStream.h(i2, i);
        aSN1OutputStream.e(p);
    }

    public final int i() throws IOException {
        int b;
        int i = this.a.b().p().i();
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
        return this.a.b().p().n();
    }
}
