package org.spongycastle.crypto.engines;

import org.spongycastle.util.Pack;

public class XSalsa20Engine extends Salsa20Engine {
    public final String b() {
        return "XSalsa20";
    }

    public final int f() {
        return 24;
    }

    public final void j(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            throw new IllegalArgumentException("XSalsa20 doesn't support re-init with null key");
        } else if (bArr.length == 32) {
            super.j(bArr, bArr2);
            int[] iArr = this.f6047a;
            Pack.g(bArr2, 8, iArr, 8, 2);
            int[] iArr2 = new int[iArr.length];
            Salsa20Engine.i(iArr, 20, iArr2);
            iArr[1] = iArr2[0] - iArr[0];
            iArr[2] = iArr2[5] - iArr[5];
            iArr[3] = iArr2[10] - iArr[10];
            iArr[4] = iArr2[15] - iArr[15];
            iArr[11] = iArr2[6] - iArr[6];
            iArr[12] = iArr2[7] - iArr[7];
            iArr[13] = iArr2[8] - iArr[8];
            iArr[14] = iArr2[9] - iArr[9];
            Pack.g(bArr2, 16, iArr, 6, 2);
        } else {
            throw new IllegalArgumentException("XSalsa20 requires a 256 bit key");
        }
    }
}
