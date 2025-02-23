package org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

public class BERTaggedObject extends ASN1TaggedObject {
    public BERTaggedObject() {
        throw null;
    }

    public BERTaggedObject(boolean z, int i, ASN1Encodable aSN1Encodable) {
        super(z, i, aSN1Encodable);
    }

    public final void h(ASN1OutputStream aSN1OutputStream) throws IOException {
        Enumeration enumeration;
        aSN1OutputStream.h(160, this.c);
        aSN1OutputStream.c(128);
        boolean z = this.f5664a;
        ASN1Encodable aSN1Encodable = this.a;
        if (!z) {
            if (aSN1Encodable instanceof ASN1OctetString) {
                if (aSN1Encodable instanceof BEROctetString) {
                    enumeration = ((BEROctetString) aSN1Encodable).t();
                } else {
                    enumeration = new BEROctetString(((ASN1OctetString) aSN1Encodable).s()).t();
                }
            } else if (aSN1Encodable instanceof ASN1Sequence) {
                enumeration = ((ASN1Sequence) aSN1Encodable).t();
            } else if (aSN1Encodable instanceof ASN1Set) {
                enumeration = ((ASN1Set) aSN1Encodable).t();
            } else {
                throw new ASN1Exception("not implemented: ".concat(aSN1Encodable.getClass().getName()));
            }
            while (enumeration.hasMoreElements()) {
                aSN1OutputStream.g((ASN1Encodable) enumeration.nextElement());
            }
        } else {
            aSN1OutputStream.g(aSN1Encodable);
        }
        aSN1OutputStream.c(0);
        aSN1OutputStream.c(0);
    }

    public final int i() throws IOException {
        int b;
        int i = this.a.b().i();
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
}
