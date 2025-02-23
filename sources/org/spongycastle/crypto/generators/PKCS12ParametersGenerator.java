package org.spongycastle.crypto.generators;

import com.google.common.primitives.UnsignedBytes;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public class PKCS12ParametersGenerator extends PBEParametersGenerator {
    public final Digest a;
    public final int b;
    public final int c;

    public PKCS12ParametersGenerator(Digest digest) {
        this.a = digest;
        this.b = digest.f();
        this.c = ((ExtendedDigest) digest).h();
    }

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
        PKCS12ParametersGenerator pKCS12ParametersGenerator = this;
        int i3 = i2;
        int i4 = pKCS12ParametersGenerator.c;
        byte[] bArr3 = new byte[i4];
        byte[] bArr4 = new byte[i3];
        int i5 = 0;
        for (int i6 = 0; i6 != i4; i6++) {
            bArr3[i6] = (byte) i;
        }
        byte[] bArr5 = pKCS12ParametersGenerator.b;
        int i7 = 1;
        if (bArr5 == null || bArr5.length == 0) {
            bArr = new byte[0];
        } else {
            int length = (((bArr5.length + i4) - 1) / i4) * i4;
            bArr = new byte[length];
            for (int i8 = 0; i8 != length; i8++) {
                byte[] bArr6 = pKCS12ParametersGenerator.b;
                bArr[i8] = bArr6[i8 % bArr6.length];
            }
        }
        byte[] bArr7 = pKCS12ParametersGenerator.f5798a;
        if (bArr7 == null || bArr7.length == 0) {
            bArr2 = new byte[0];
        } else {
            int length2 = (((bArr7.length + i4) - 1) / i4) * i4;
            bArr2 = new byte[length2];
            for (int i9 = 0; i9 != length2; i9++) {
                byte[] bArr8 = pKCS12ParametersGenerator.f5798a;
                bArr2[i9] = bArr8[i9 % bArr8.length];
            }
        }
        int length3 = bArr.length + bArr2.length;
        byte[] bArr9 = new byte[length3];
        System.arraycopy(bArr, 0, bArr9, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr9, bArr.length, bArr2.length);
        byte[] bArr10 = new byte[i4];
        int i10 = pKCS12ParametersGenerator.b;
        int i11 = ((i3 + i10) - 1) / i10;
        byte[] bArr11 = new byte[i10];
        int i12 = 1;
        while (i12 <= i11) {
            Digest digest = pKCS12ParametersGenerator.a;
            digest.update(bArr3, i5, i4);
            digest.update(bArr9, i5, length3);
            digest.c(i5, bArr11);
            for (int i13 = i7; i13 < pKCS12ParametersGenerator.a; i13++) {
                digest.update(bArr11, i5, i10);
                digest.c(i5, bArr11);
            }
            for (int i14 = i5; i14 != i4; i14++) {
                bArr10[i14] = bArr11[i14 % i10];
            }
            int i15 = i5;
            while (i15 != length3 / i4) {
                int i16 = i15 * i4;
                int i17 = (i4 + i16) - 1;
                int i18 = (bArr10[i4 - 1] & UnsignedBytes.MAX_VALUE) + (bArr9[i17] & UnsignedBytes.MAX_VALUE) + 1;
                bArr9[i17] = (byte) i18;
                int i19 = i18 >>> 8;
                int i20 = i4 - 2;
                while (i20 >= 0) {
                    int i21 = i16 + i20;
                    int i22 = (bArr10[i20] & UnsignedBytes.MAX_VALUE) + (bArr9[i21] & UnsignedBytes.MAX_VALUE) + i19;
                    bArr9[i21] = (byte) i22;
                    i19 = i22 >>> 8;
                    i20--;
                    i4 = i4;
                }
                i15++;
                i4 = i4;
            }
            int i23 = i4;
            if (i12 == i11) {
                int i24 = i12 - 1;
                i5 = 0;
                System.arraycopy(bArr11, 0, bArr4, i24 * i10, i3 - (i24 * i10));
            } else {
                i5 = 0;
                System.arraycopy(bArr11, 0, bArr4, (i12 - 1) * i10, i10);
            }
            i12++;
            pKCS12ParametersGenerator = this;
            i4 = i23;
            i7 = 1;
        }
        return bArr4;
    }
}
