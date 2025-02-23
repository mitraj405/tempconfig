package org.spongycastle.jce.provider;

import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

/* compiled from: BrokenPBE */
class OldPKCS12ParametersGenerator extends PBEParametersGenerator {
    public final KeyParameter c(int i) {
        int i2 = i / 8;
        return new KeyParameter(g(3, i2), 0, i2);
    }

    public final KeyParameter d(int i) {
        int i2 = i / 8;
        return new KeyParameter(g(1, i2), 0, i2);
    }

    public final ParametersWithIV e(int i, int i2) {
        int i3 = i / 8;
        int i4 = i2 / 8;
        byte[] g = g(1, i3);
        return new ParametersWithIV(new KeyParameter(g, 0, i3), g(2, i4), 0, i4);
    }

    public final byte[] g(int i, int i2) {
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3 = new byte[i2];
        byte[] bArr4 = this.b;
        if (bArr4 == null || bArr4.length == 0) {
            bArr = new byte[0];
        } else {
            int length = (((bArr4.length + 0) - 1) / 0) * 0;
            bArr = new byte[length];
            for (int i3 = 0; i3 != length; i3++) {
                byte[] bArr5 = this.b;
                bArr[i3] = bArr5[i3 % bArr5.length];
            }
        }
        byte[] bArr6 = this.f5798a;
        if (bArr6 == null || bArr6.length == 0) {
            bArr2 = new byte[0];
        } else {
            int length2 = (((bArr6.length + 0) - 1) / 0) * 0;
            bArr2 = new byte[length2];
            for (int i4 = 0; i4 != length2; i4++) {
                byte[] bArr7 = this.f5798a;
                bArr2[i4] = bArr7[i4 % bArr7.length];
            }
        }
        byte[] bArr8 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr8, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr8, bArr.length, bArr2.length);
        if (1 > ((i2 + 0) - 1) / 0) {
            return bArr3;
        }
        throw null;
    }
}
