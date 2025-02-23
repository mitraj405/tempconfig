package org.spongycastle.crypto.engines;

import com.google.common.primitives.UnsignedBytes;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;

public class RC6Engine implements BlockCipher {
    public boolean a;

    /* renamed from: a  reason: collision with other field name */
    public int[] f6015a = null;

    public final void a(boolean z, CipherParameters cipherParameters) {
        int[] iArr;
        int i;
        if (cipherParameters instanceof KeyParameter) {
            this.a = z;
            byte[] bArr = ((KeyParameter) cipherParameters).a;
            int length = (bArr.length + 3) / 4;
            int length2 = ((bArr.length + 4) - 1) / 4;
            int[] iArr2 = new int[length2];
            for (int length3 = bArr.length - 1; length3 >= 0; length3--) {
                int i2 = length3 / 4;
                iArr2[i2] = (iArr2[i2] << 8) + (bArr[length3] & UnsignedBytes.MAX_VALUE);
            }
            int[] iArr3 = new int[44];
            this.f6015a = iArr3;
            iArr3[0] = -1209970333;
            int i3 = 1;
            while (true) {
                iArr = this.f6015a;
                if (i3 >= iArr.length) {
                    break;
                }
                iArr[i3] = iArr[i3 - 1] - 1640531527;
                i3++;
            }
            if (length2 > iArr.length) {
                i = length2 * 3;
            } else {
                i = iArr.length * 3;
            }
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < i; i8++) {
                int[] iArr4 = this.f6015a;
                int i9 = iArr4[i4] + i5 + i6;
                i5 = (i9 << 3) | (i9 >>> -3);
                iArr4[i4] = i5;
                int i10 = iArr2[i7] + i5 + i6;
                int i11 = i6 + i5;
                i6 = (i10 >>> (-i11)) | (i10 << i11);
                iArr2[i7] = i6;
                i4 = (i4 + 1) % iArr4.length;
                i7 = (i7 + 1) % length2;
            }
            return;
        }
        throw new IllegalArgumentException(xx.H(cipherParameters, "invalid parameter passed to RC6 init - "));
    }

    public final String b() {
        return "RC6";
    }

    public final int c() {
        return 16;
    }

    public final int d(int i, byte[] bArr) {
        int i2 = 0;
        for (int i3 = 3; i3 >= 0; i3--) {
            i2 = (i2 << 8) + (bArr[i3 + i] & UnsignedBytes.MAX_VALUE);
        }
        return i2;
    }

    public final int e(int i, int i2, byte[] bArr, byte[] bArr2) {
        int i3 = i;
        int i4 = i2;
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        if (this.f6015a == null) {
            throw new IllegalStateException("RC6 engine not initialised");
        } else if (i3 + 16 > bArr3.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i4 + 16 <= bArr4.length) {
            int i5 = 20;
            if (this.a) {
                int d = d(i3, bArr3);
                int d2 = d(i3 + 4, bArr3);
                int d3 = d(i3 + 8, bArr3);
                int d4 = d(i3 + 12, bArr3);
                int[] iArr = this.f6015a;
                int i6 = d2 + iArr[0];
                int i7 = d4 + iArr[1];
                int i8 = 1;
                while (i8 <= 20) {
                    int i9 = ((i6 * 2) + 1) * i6;
                    int i10 = (i9 >>> -5) | (i9 << 5);
                    int i11 = ((i7 * 2) + 1) * i7;
                    int i12 = (i11 >>> -5) | (i11 << 5);
                    int i13 = d ^ i10;
                    int[] iArr2 = this.f6015a;
                    int i14 = i8 * 2;
                    int i15 = d3 ^ i12;
                    int i16 = ((i15 >>> (-i10)) | (i15 << i10)) + iArr2[i14 + 1];
                    i8++;
                    d3 = i7;
                    i7 = ((i13 >>> (-i12)) | (i13 << i12)) + iArr2[i14];
                    d = i6;
                    i6 = i16;
                }
                int[] iArr3 = this.f6015a;
                int i17 = d3 + iArr3[43];
                f(d + iArr3[42], bArr4, i4);
                f(i6, bArr4, i4 + 4);
                f(i17, bArr4, i4 + 8);
                f(i7, bArr4, i4 + 12);
                return 16;
            }
            int d5 = d(i3, bArr3);
            int d6 = d(i3 + 4, bArr3);
            int d7 = d(i3 + 8, bArr3);
            int d8 = d(i3 + 12, bArr3);
            int[] iArr4 = this.f6015a;
            int i18 = d7 - iArr4[43];
            int i19 = d5 - iArr4[42];
            while (i5 >= 1) {
                int i20 = ((i19 * 2) + 1) * i19;
                int i21 = (i20 >>> -5) | (i20 << 5);
                int i22 = ((i18 * 2) + 1) * i18;
                int i23 = (i22 >>> -5) | (i22 << 5);
                int[] iArr5 = this.f6015a;
                int i24 = i5 * 2;
                int i25 = d6 - iArr5[i24 + 1];
                int i26 = d8 - iArr5[i24];
                i5--;
                int i27 = i19;
                i19 = ((i26 << (-i23)) | (i26 >>> i23)) ^ i21;
                d8 = i18;
                i18 = ((i25 << (-i21)) | (i25 >>> i21)) ^ i23;
                d6 = i27;
            }
            int[] iArr6 = this.f6015a;
            f(i19, bArr4, i4);
            f(d6 - iArr6[0], bArr4, i4 + 4);
            f(i18, bArr4, i4 + 8);
            f(d8 - iArr6[1], bArr4, i4 + 12);
            return 16;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public final void f(int i, byte[] bArr, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            bArr[i3 + i2] = (byte) i;
            i >>>= 8;
        }
    }

    public final void reset() {
    }
}
