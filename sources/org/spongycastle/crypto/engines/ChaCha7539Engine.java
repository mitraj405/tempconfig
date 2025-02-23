package org.spongycastle.crypto.engines;

import org.spongycastle.util.Pack;

public class ChaCha7539Engine extends Salsa20Engine {
    public final String b() {
        return "ChaCha7539-" + this.a;
    }

    public final void c() {
        int[] iArr = this.f6047a;
        int i = iArr[12] + 1;
        iArr[12] = i;
        if (i == 0) {
            throw new IllegalStateException("attempt to increase counter past 2^32.");
        }
    }

    public final void e(byte[] bArr) {
        int[] iArr = this.f6047a;
        int i = this.a;
        int[] iArr2 = this.f6048b;
        ChaChaEngine.k(iArr, i, iArr2);
        int i2 = 0;
        for (int e : iArr2) {
            Pack.e(e, bArr, i2);
            i2 += 4;
        }
    }

    public final int f() {
        return 12;
    }

    public final void h() {
        this.f6047a[12] = 0;
    }

    public final void j(byte[] bArr, byte[] bArr2) {
        int[] iArr = this.f6047a;
        if (bArr != null) {
            if (bArr.length == 32) {
                Salsa20Engine.g(bArr.length, iArr);
                Pack.g(bArr, 0, iArr, 4, 8);
            } else {
                throw new IllegalArgumentException(b() + " requires 256 bit key");
            }
        }
        Pack.g(bArr2, 0, iArr, 13, 3);
    }
}
