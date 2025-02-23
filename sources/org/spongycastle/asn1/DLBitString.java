package org.spongycastle.asn1;

import java.io.IOException;

public class DLBitString extends ASN1BitString {
    public DLBitString(byte[] bArr, int i) {
        super(bArr, i);
    }

    public final void h(ASN1OutputStream aSN1OutputStream) throws IOException {
        byte[] bArr = this.f5654a;
        int length = bArr.length + 1;
        byte[] bArr2 = new byte[length];
        bArr2[0] = (byte) this.c;
        System.arraycopy(bArr, 0, bArr2, 1, length - 1);
        aSN1OutputStream.d(3, bArr2);
    }

    public final int i() {
        byte[] bArr = this.f5654a;
        return StreamUtil.a(bArr.length + 1) + 1 + bArr.length + 1;
    }

    public final boolean n() {
        return false;
    }
}
