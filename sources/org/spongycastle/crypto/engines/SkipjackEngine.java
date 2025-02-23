package org.spongycastle.crypto.engines;

import com.google.common.primitives.UnsignedBytes;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;

public class SkipjackEngine implements BlockCipher {
    public static final short[] a = {163, 215, 9, 131, 248, 72, 246, 244, 179, 33, 21, 120, 153, 177, 175, 249, 231, 45, 77, 138, 206, 76, 202, 46, 82, 149, 217, 30, 78, 56, 68, 40, 10, 223, 2, 160, 23, 241, 96, 104, 18, 183, 122, 195, 233, 250, 61, 83, 150, 132, 107, 186, 242, 99, 154, 25, 124, 174, 229, 245, 247, 22, 106, 162, 57, 182, 123, 15, 193, 147, 129, 27, 238, 180, 26, 234, 208, 145, 47, 184, 85, 185, 218, 133, 63, 65, 191, 224, 90, 88, 128, 95, 102, 11, 216, 144, 53, 213, 192, 167, 51, 6, 101, 105, 69, 0, 148, 86, 109, 152, 155, 118, 151, 252, 178, 194, 176, 254, 219, 32, 225, 235, 214, 228, 221, 71, 74, 29, 66, 237, 158, 110, 73, 60, 205, 67, 39, 210, 7, 212, 222, 199, 103, 24, 137, 203, 48, 31, 141, 198, 143, 170, 200, 116, 220, 201, 93, 92, 49, 164, 112, 136, 97, 44, 159, 13, 43, 135, 80, 130, 84, 100, 38, 125, 3, 64, 52, 75, 28, 115, 209, 196, 253, 59, 204, 251, 127, 171, 230, 62, 91, 165, 173, 4, 35, 156, 20, 81, 34, 240, 41, 121, 113, 126, 255, 140, 14, 226, 12, 239, 188, 114, 117, 111, 55, 161, 236, 211, 142, 98, 139, 134, 16, 232, 8, 119, 17, 190, 146, 79, 36, 197, 50, 54, 157, 207, 243, 166, 187, 172, 94, 108, 169, 19, 87, 37, 181, 227, 189, 168, 58, 1, 5, 89, 42, 70};

    /* renamed from: a  reason: collision with other field name */
    public boolean f6053a;

    /* renamed from: a  reason: collision with other field name */
    public int[] f6054a;
    public int[] b;
    public int[] c;
    public int[] d;

    public final void a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            byte[] bArr = ((KeyParameter) cipherParameters).a;
            this.f6053a = z;
            this.f6054a = new int[32];
            this.b = new int[32];
            this.c = new int[32];
            this.d = new int[32];
            for (int i = 0; i < 32; i++) {
                int i2 = i * 4;
                this.f6054a[i] = bArr[i2 % 10] & UnsignedBytes.MAX_VALUE;
                this.b[i] = bArr[(i2 + 1) % 10] & UnsignedBytes.MAX_VALUE;
                this.c[i] = bArr[(i2 + 2) % 10] & UnsignedBytes.MAX_VALUE;
                this.d[i] = bArr[(i2 + 3) % 10] & UnsignedBytes.MAX_VALUE;
            }
            return;
        }
        throw new IllegalArgumentException(xx.H(cipherParameters, "invalid parameter passed to SKIPJACK init - "));
    }

    public final String b() {
        return "SKIPJACK";
    }

    public final int c() {
        return 8;
    }

    public final int d(int i, int i2) {
        short s = i2 & 255;
        short[] sArr = a;
        short s2 = ((i2 >> 8) & 255) ^ sArr[this.f6054a[i] ^ s];
        short s3 = s ^ sArr[this.b[i] ^ s2];
        short s4 = s2 ^ sArr[this.c[i] ^ s3];
        return (s4 << 8) + (sArr[this.d[i] ^ s4] ^ s3);
    }

    public final int e(int i, int i2, byte[] bArr, byte[] bArr2) {
        if (this.b == null) {
            throw new IllegalStateException("SKIPJACK engine not initialised");
        } else if (i + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 8 <= bArr2.length) {
            if (this.f6053a) {
                int i3 = (bArr[i + 0] << 8) + (bArr[i + 1] & UnsignedBytes.MAX_VALUE);
                int i4 = (bArr[i + 2] << 8) + (bArr[i + 3] & UnsignedBytes.MAX_VALUE);
                int i5 = (bArr[i + 4] << 8) + (bArr[i + 5] & UnsignedBytes.MAX_VALUE);
                int i6 = (bArr[i + 6] << 8) + (bArr[i + 7] & UnsignedBytes.MAX_VALUE);
                int i7 = 0;
                for (int i8 = 0; i8 < 2; i8++) {
                    int i9 = 0;
                    while (i9 < 8) {
                        int d2 = d(i7, i3);
                        i7++;
                        i9++;
                        int i10 = i4;
                        i4 = d2;
                        i3 = (i6 ^ d2) ^ i7;
                        i6 = i5;
                        i5 = i10;
                    }
                    int i11 = 0;
                    while (i11 < 8) {
                        int i12 = i7 + 1;
                        int d3 = d(i7, i3);
                        i11++;
                        i3 = i6;
                        i6 = i5;
                        i5 = (i4 ^ i3) ^ i12;
                        i4 = d3;
                        i7 = i12;
                    }
                }
                bArr2[i2 + 0] = (byte) (i3 >> 8);
                bArr2[i2 + 1] = (byte) i3;
                bArr2[i2 + 2] = (byte) (i4 >> 8);
                bArr2[i2 + 3] = (byte) i4;
                bArr2[i2 + 4] = (byte) (i5 >> 8);
                bArr2[i2 + 5] = (byte) i5;
                bArr2[i2 + 6] = (byte) (i6 >> 8);
                bArr2[i2 + 7] = (byte) i6;
            } else {
                int i13 = (bArr[i + 0] << 8) + (bArr[i + 1] & UnsignedBytes.MAX_VALUE);
                int i14 = (bArr[i + 2] << 8) + (bArr[i + 3] & UnsignedBytes.MAX_VALUE);
                int i15 = (bArr[i + 4] << 8) + (bArr[i + 5] & UnsignedBytes.MAX_VALUE);
                int i16 = (bArr[i + 6] << 8) + (bArr[i + 7] & UnsignedBytes.MAX_VALUE);
                int i17 = 31;
                for (int i18 = 0; i18 < 2; i18++) {
                    int i19 = 0;
                    while (i19 < 8) {
                        int f = f(i17, i14);
                        i17--;
                        i19++;
                        int i20 = i16;
                        i16 = i13;
                        i13 = f;
                        i14 = (i15 ^ f) ^ (i17 + 1);
                        i15 = i20;
                    }
                    int i21 = 0;
                    while (i21 < 8) {
                        int f2 = f(i17, i14);
                        i17--;
                        i21++;
                        int i22 = i16;
                        i16 = (i13 ^ i14) ^ (i17 + 1);
                        i13 = f2;
                        i14 = i15;
                        i15 = i22;
                    }
                }
                bArr2[i2 + 0] = (byte) (i13 >> 8);
                bArr2[i2 + 1] = (byte) i13;
                bArr2[i2 + 2] = (byte) (i14 >> 8);
                bArr2[i2 + 3] = (byte) i14;
                bArr2[i2 + 4] = (byte) (i15 >> 8);
                bArr2[i2 + 5] = (byte) i15;
                bArr2[i2 + 6] = (byte) (i16 >> 8);
                bArr2[i2 + 7] = (byte) i16;
            }
            return 8;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public final int f(int i, int i2) {
        short s = i2 & 255;
        short s2 = (i2 >> 8) & 255;
        short[] sArr = a;
        short s3 = s ^ sArr[this.d[i] ^ s2];
        short s4 = s2 ^ sArr[this.c[i] ^ s3];
        short s5 = s3 ^ sArr[this.b[i] ^ s4];
        return ((sArr[this.f6054a[i] ^ s5] ^ s4) << 8) + s5;
    }

    public final void reset() {
    }
}
