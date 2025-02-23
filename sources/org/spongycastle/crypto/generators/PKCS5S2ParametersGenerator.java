package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;

public class PKCS5S2ParametersGenerator extends PBEParametersGenerator {
    public final HMac a;
    public final byte[] c;

    public PKCS5S2ParametersGenerator() {
        this(new SHA1Digest());
    }

    public final KeyParameter c(int i) {
        return d(i);
    }

    public final KeyParameter d(int i) {
        int i2 = i / 8;
        return new KeyParameter(Arrays.n(0, g(i2), i2), 0, i2);
    }

    public final ParametersWithIV e(int i, int i2) {
        int i3 = i / 8;
        int i4 = i2 / 8;
        byte[] g = g(i3 + i4);
        return new ParametersWithIV(new KeyParameter(g, 0, i3), g, i3, i4);
    }

    public final byte[] g(int i) {
        HMac hMac = this.a;
        int i2 = hMac.f6108a;
        byte b = 1;
        int i3 = ((i + i2) - 1) / i2;
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[(i3 * i2)];
        hMac.a(new KeyParameter(this.f5798a));
        int i4 = 1;
        int i5 = 0;
        while (i4 <= i3) {
            int i6 = 3;
            while (true) {
                byte b2 = (byte) (bArr[i6] + b);
                bArr[i6] = b2;
                if (b2 != 0) {
                    break;
                }
                i6--;
            }
            byte[] bArr3 = this.b;
            int i7 = this.a;
            if (i7 != 0) {
                if (bArr3 != null) {
                    hMac.update(bArr3, 0, bArr3.length);
                }
                hMac.update(bArr, 0, 4);
                byte[] bArr4 = this.c;
                hMac.c(0, bArr4);
                System.arraycopy(bArr4, 0, bArr2, i5, bArr4.length);
                for (int i8 = b; i8 < i7; i8++) {
                    hMac.update(bArr4, 0, bArr4.length);
                    hMac.c(0, bArr4);
                    for (int i9 = 0; i9 != bArr4.length; i9++) {
                        int i10 = i5 + i9;
                        bArr2[i10] = (byte) (bArr2[i10] ^ bArr4[i9]);
                    }
                }
                i5 += i2;
                i4++;
                b = 1;
            } else {
                throw new IllegalArgumentException("iteration count must be at least 1.");
            }
        }
        return bArr2;
    }

    public PKCS5S2ParametersGenerator(ExtendedDigest extendedDigest) {
        HMac hMac = new HMac(extendedDigest);
        this.a = hMac;
        this.c = new byte[hMac.f6108a];
    }
}
