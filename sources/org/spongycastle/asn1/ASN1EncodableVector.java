package org.spongycastle.asn1;

import java.util.Vector;

public class ASN1EncodableVector {
    public final Vector a = new Vector();

    public final void a(ASN1Encodable aSN1Encodable) {
        this.a.addElement(aSN1Encodable);
    }

    public final ASN1Encodable b(int i) {
        return (ASN1Encodable) this.a.elementAt(i);
    }

    public final int c() {
        return this.a.size();
    }
}
