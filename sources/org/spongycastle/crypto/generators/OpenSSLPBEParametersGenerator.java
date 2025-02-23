package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.digests.MD5Digest;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public class OpenSSLPBEParametersGenerator extends PBEParametersGenerator {
    public final MD5Digest a = new MD5Digest();

    public final KeyParameter c(int i) {
        return d(i);
    }

    public final KeyParameter d(int i) {
        int i2 = i / 8;
        return new KeyParameter(g(i2), 0, i2);
    }

    public final ParametersWithIV e(int i, int i2) {
        int i3 = i / 8;
        int i4 = i2 / 8;
        byte[] g = g(i3 + i4);
        return new ParametersWithIV(new KeyParameter(g, 0, i3), g, i3, i4);
    }

    public final byte[] g(int i) {
        int i2;
        MD5Digest mD5Digest = this.a;
        mD5Digest.getClass();
        byte[] bArr = new byte[16];
        byte[] bArr2 = new byte[i];
        int i3 = 0;
        while (true) {
            byte[] bArr3 = this.f5798a;
            mD5Digest.update(bArr3, 0, bArr3.length);
            byte[] bArr4 = this.b;
            mD5Digest.update(bArr4, 0, bArr4.length);
            mD5Digest.c(0, bArr);
            if (i > 16) {
                i2 = 16;
            } else {
                i2 = i;
            }
            System.arraycopy(bArr, 0, bArr2, i3, i2);
            i3 += i2;
            i -= i2;
            if (i == 0) {
                return bArr2;
            }
            mD5Digest.reset();
            mD5Digest.update(bArr, 0, 16);
        }
    }
}
