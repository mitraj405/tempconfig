package org.spongycastle.crypto.engines;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;

public class NoekeonEngine implements BlockCipher {
    public static final int[] d = {0, 0, 0, 0};
    public static final int[] e = {128, 27, 54, 108, 216, 171, 77, 154, 47, 94, 188, 99, 198, 151, 53, 106, 212};
    public boolean a = false;

    /* renamed from: a  reason: collision with other field name */
    public final int[] f5998a = new int[4];
    public boolean b;

    /* renamed from: b  reason: collision with other field name */
    public final int[] f5999b = new int[4];
    public final int[] c = new int[4];

    public static int d(int i, byte[] bArr) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        return (bArr[i] << Ascii.CAN) | ((bArr[i2] & UnsignedBytes.MAX_VALUE) << Ascii.DLE) | ((bArr[i3] & UnsignedBytes.MAX_VALUE) << 8) | (bArr[i3 + 1] & UnsignedBytes.MAX_VALUE);
    }

    public static void f(int[] iArr) {
        int i = iArr[1];
        int i2 = iArr[3];
        int i3 = ~i2;
        int i4 = iArr[2];
        int i5 = i ^ (i3 & (~i4));
        iArr[1] = i5;
        int i6 = iArr[0] ^ (i4 & i5);
        iArr[0] = i6;
        iArr[3] = i6;
        iArr[0] = i2;
        int i7 = ((i2 ^ i5) ^ i6) ^ i4;
        iArr[2] = i7;
        int i8 = i5 ^ ((~i6) & (~i7));
        iArr[1] = i8;
        iArr[0] = (i7 & i8) ^ i2;
    }

    public static void g(int i, byte[] bArr, int i2) {
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i >>> 24);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i >>> 16);
        bArr[i4] = (byte) (i >>> 8);
        bArr[i4 + 1] = (byte) i;
    }

    public static void h(int[] iArr) {
        iArr[1] = j(iArr[1], 1);
        iArr[2] = j(iArr[2], 5);
        iArr[3] = j(iArr[3], 2);
    }

    public static void i(int[] iArr) {
        iArr[1] = j(iArr[1], 31);
        iArr[2] = j(iArr[2], 27);
        iArr[3] = j(iArr[3], 30);
    }

    public static int j(int i, int i2) {
        return (i >>> (32 - i2)) | (i << i2);
    }

    public static void k(int[] iArr, int[] iArr2) {
        int i = iArr[0] ^ iArr[2];
        int j = i ^ (j(i, 8) ^ j(i, 24));
        iArr[1] = iArr[1] ^ j;
        iArr[3] = j ^ iArr[3];
        for (int i2 = 0; i2 < 4; i2++) {
            iArr[i2] = iArr[i2] ^ iArr2[i2];
        }
        int i3 = iArr[1] ^ iArr[3];
        int j2 = i3 ^ (j(i3, 8) ^ j(i3, 24));
        iArr[0] = iArr[0] ^ j2;
        iArr[2] = j2 ^ iArr[2];
    }

    public final void a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.b = z;
            this.a = true;
            byte[] bArr = ((KeyParameter) cipherParameters).a;
            int d2 = d(0, bArr);
            int[] iArr = this.f5999b;
            iArr[0] = d2;
            iArr[1] = d(4, bArr);
            iArr[2] = d(8, bArr);
            iArr[3] = d(12, bArr);
            return;
        }
        throw new IllegalArgumentException(xx.H(cipherParameters, "invalid parameter passed to Noekeon init - "));
    }

    public final String b() {
        return "Noekeon";
    }

    public final int c() {
        return 16;
    }

    public final int e(int i, int i2, byte[] bArr, byte[] bArr2) {
        if (!this.a) {
            throw new IllegalStateException("Noekeon not initialised");
        } else if (i + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 16 <= bArr2.length) {
            boolean z = this.b;
            int[] iArr = e;
            int[] iArr2 = this.f5999b;
            int[] iArr3 = this.f5998a;
            if (z) {
                iArr3[0] = d(i, bArr);
                iArr3[1] = d(i + 4, bArr);
                iArr3[2] = d(i + 8, bArr);
                iArr3[3] = d(i + 12, bArr);
                int i3 = 0;
                while (i3 < 16) {
                    iArr3[0] = iArr3[0] ^ iArr[i3];
                    k(iArr3, iArr2);
                    h(iArr3);
                    f(iArr3);
                    i(iArr3);
                    i3++;
                }
                iArr3[0] = iArr[i3] ^ iArr3[0];
                k(iArr3, iArr2);
                g(iArr3[0], bArr2, i2);
                g(iArr3[1], bArr2, i2 + 4);
                g(iArr3[2], bArr2, i2 + 8);
                g(iArr3[3], bArr2, i2 + 12);
            } else {
                iArr3[0] = d(i, bArr);
                iArr3[1] = d(i + 4, bArr);
                iArr3[2] = d(i + 8, bArr);
                iArr3[3] = d(i + 12, bArr);
                int length = iArr2.length;
                int[] iArr4 = this.c;
                System.arraycopy(iArr2, 0, iArr4, 0, length);
                k(iArr4, d);
                int i4 = 16;
                while (i4 > 0) {
                    k(iArr3, iArr4);
                    iArr3[0] = iArr3[0] ^ iArr[i4];
                    h(iArr3);
                    f(iArr3);
                    i(iArr3);
                    i4--;
                }
                k(iArr3, iArr4);
                int i5 = iArr[i4] ^ iArr3[0];
                iArr3[0] = i5;
                g(i5, bArr2, i2);
                g(iArr3[1], bArr2, i2 + 4);
                g(iArr3[2], bArr2, i2 + 8);
                g(iArr3[3], bArr2, i2 + 12);
            }
            return 16;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public final void reset() {
    }
}
