package org.spongycastle.crypto.engines;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.RC5Parameters;

public class RC532Engine implements BlockCipher {
    public int a = 12;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6011a;

    /* renamed from: a  reason: collision with other field name */
    public int[] f6012a = null;

    public final void a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof RC5Parameters) {
            RC5Parameters rC5Parameters = (RC5Parameters) cipherParameters;
            this.a = rC5Parameters.c;
            f(rC5Parameters.a);
        } else if (cipherParameters instanceof KeyParameter) {
            f(((KeyParameter) cipherParameters).a);
        } else {
            throw new IllegalArgumentException(xx.H(cipherParameters, "invalid parameter passed to RC532 init - "));
        }
        this.f6011a = z;
    }

    public final String b() {
        return "RC5-32";
    }

    public final int c() {
        return 8;
    }

    public final int d(int i, byte[] bArr) {
        return ((bArr[i + 3] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | (bArr[i] & UnsignedBytes.MAX_VALUE) | ((bArr[i + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i + 2] & UnsignedBytes.MAX_VALUE) << Ascii.DLE);
    }

    public final int e(int i, int i2, byte[] bArr, byte[] bArr2) {
        int i3 = 1;
        if (this.f6011a) {
            int d = d(i, bArr) + this.f6012a[0];
            int d2 = d(i + 4, bArr) + this.f6012a[1];
            while (i3 <= this.a) {
                int i4 = d ^ d2;
                int i5 = d2 & 31;
                int i6 = (i4 >>> (32 - i5)) | (i4 << i5);
                int[] iArr = this.f6012a;
                int i7 = i3 * 2;
                int i8 = i6 + iArr[i7];
                int i9 = d2 ^ i8;
                int i10 = i8 & 31;
                d2 = ((i9 >>> (32 - i10)) | (i9 << i10)) + iArr[i7 + 1];
                i3++;
                d = i8;
            }
            g(d, bArr2, i2);
            g(d2, bArr2, i2 + 4);
            return 8;
        }
        int d3 = d(i, bArr);
        int d4 = d(i + 4, bArr);
        for (int i11 = this.a; i11 >= 1; i11--) {
            int[] iArr2 = this.f6012a;
            int i12 = i11 * 2;
            int i13 = d4 - iArr2[i12 + 1];
            int i14 = d3 & 31;
            d4 = ((i13 << (32 - i14)) | (i13 >>> i14)) ^ d3;
            int i15 = d3 - iArr2[i12];
            int i16 = d4 & 31;
            d3 = ((i15 << (32 - i16)) | (i15 >>> i16)) ^ d4;
        }
        g(d3 - this.f6012a[0], bArr2, i2);
        g(d4 - this.f6012a[1], bArr2, i2 + 4);
        return 8;
    }

    public final void f(byte[] bArr) {
        int[] iArr;
        int i;
        int length = (bArr.length + 3) / 4;
        int[] iArr2 = new int[length];
        for (int i2 = 0; i2 != bArr.length; i2++) {
            int i3 = i2 / 4;
            iArr2[i3] = iArr2[i3] + ((bArr[i2] & UnsignedBytes.MAX_VALUE) << ((i2 % 4) * 8));
        }
        int i4 = 1;
        int[] iArr3 = new int[((this.a + 1) * 2)];
        this.f6012a = iArr3;
        iArr3[0] = -1209970333;
        while (true) {
            iArr = this.f6012a;
            if (i4 >= iArr.length) {
                break;
            }
            iArr[i4] = iArr[i4 - 1] - 1640531527;
            i4++;
        }
        if (length > iArr.length) {
            i = length * 3;
        } else {
            i = iArr.length * 3;
        }
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < i; i9++) {
            int[] iArr4 = this.f6012a;
            int i10 = iArr4[i5] + i6 + i7;
            i6 = (i10 << 3) | (i10 >>> 29);
            iArr4[i5] = i6;
            int i11 = iArr2[i8] + i6 + i7;
            int i12 = (i7 + i6) & 31;
            i7 = (i11 >>> (32 - i12)) | (i11 << i12);
            iArr2[i8] = i7;
            i5 = (i5 + 1) % iArr4.length;
            i8 = (i8 + 1) % length;
        }
    }

    public final void g(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >> 8);
        bArr[i2 + 2] = (byte) (i >> 16);
        bArr[i2 + 3] = (byte) (i >> 24);
    }

    public final void reset() {
    }
}
