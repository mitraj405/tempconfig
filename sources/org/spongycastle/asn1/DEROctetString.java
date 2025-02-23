package org.spongycastle.asn1;

import java.io.IOException;

public class DEROctetString extends ASN1OctetString {
    public DEROctetString(byte[] bArr) {
        super(bArr);
    }

    public final void h(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.d(4, this.a);
    }

    public final int i() {
        byte[] bArr = this.a;
        return StreamUtil.a(bArr.length) + 1 + bArr.length;
    }

    public final boolean n() {
        return false;
    }
}
