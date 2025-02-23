package org.spongycastle.crypto.engines;

import com.google.common.primitives.UnsignedBytes;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.RC5Parameters;

public class RC564Engine implements BlockCipher {
    public int a = 12;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6013a;

    /* renamed from: a  reason: collision with other field name */
    public long[] f6014a = null;

    public static long d(int i, byte[] bArr) {
        long j = 0;
        for (int i2 = 7; i2 >= 0; i2--) {
            j = (j << 8) + ((long) (bArr[i2 + i] & UnsignedBytes.MAX_VALUE));
        }
        return j;
    }

    public static long f(long j, long j2) {
        long j3 = j2 & 63;
        return (j >>> ((int) (64 - j3))) | (j << ((int) j3));
    }

    public static void g(long j, byte[] bArr, int i) {
        for (int i2 = 0; i2 < 8; i2++) {
            bArr[i2 + i] = (byte) ((int) j);
            j >>>= 8;
        }
    }

    public final void a(boolean z, CipherParameters cipherParameters) {
        long[] jArr;
        int i;
        if (cipherParameters instanceof RC5Parameters) {
            RC5Parameters rC5Parameters = (RC5Parameters) cipherParameters;
            this.f6013a = z;
            this.a = rC5Parameters.c;
            byte[] bArr = rC5Parameters.a;
            int length = (bArr.length + 7) / 8;
            long[] jArr2 = new long[length];
            for (int i2 = 0; i2 != bArr.length; i2++) {
                int i3 = i2 / 8;
                jArr2[i3] = jArr2[i3] + (((long) (bArr[i2] & UnsignedBytes.MAX_VALUE)) << ((i2 % 8) * 8));
            }
            long[] jArr3 = new long[((this.a + 1) * 2)];
            this.f6014a = jArr3;
            jArr3[0] = -5196783011329398165L;
            int i4 = 1;
            while (true) {
                jArr = this.f6014a;
                if (i4 >= jArr.length) {
                    break;
                }
                jArr[i4] = jArr[i4 - 1] - 7046029254386353131L;
                i4++;
            }
            if (length > jArr.length) {
                i = length * 3;
            } else {
                i = jArr.length * 3;
            }
            long j = 0;
            long j2 = 0;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < i; i7++) {
                long[] jArr4 = this.f6014a;
                j = f(jArr4[i5] + j + j2, 3);
                jArr4[i5] = j;
                j2 = f(jArr2[i6] + j + j2, j2 + j);
                jArr2[i6] = j2;
                i5 = (i5 + 1) % this.f6014a.length;
                i6 = (i6 + 1) % length;
            }
            return;
        }
        throw new IllegalArgumentException(xx.H(cipherParameters, "invalid parameter passed to RC564 init - "));
    }

    public final String b() {
        return "RC5-64";
    }

    public final int c() {
        return 16;
    }

    public final int e(int i, int i2, byte[] bArr, byte[] bArr2) {
        int i3 = i;
        int i4 = i2;
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        if (this.f6013a) {
            long d = d(i3, bArr3) + this.f6014a[0];
            long d2 = d(i3 + 8, bArr3) + this.f6014a[1];
            for (int i5 = 1; i5 <= this.a; i5++) {
                int i6 = i5 * 2;
                d = f(d ^ d2, d2) + this.f6014a[i6];
                d2 = f(d2 ^ d, d) + this.f6014a[i6 + 1];
            }
            g(d, bArr4, i4);
            g(d2, bArr4, i4 + 8);
            return 16;
        }
        long d3 = d(i3, bArr3);
        long d4 = d(i3 + 8, bArr3);
        int i7 = this.a;
        for (int i8 = 1; i7 >= i8; i8 = 1) {
            long[] jArr = this.f6014a;
            int i9 = i7 * 2;
            long j = d4 - jArr[i9 + 1];
            long j2 = d3 & 63;
            d4 = ((j << ((int) (64 - j2))) | (j >>> ((int) j2))) ^ d3;
            long j3 = d3 - jArr[i9];
            long j4 = 63 & d4;
            d3 = ((j3 << ((int) (64 - j4))) | (j3 >>> ((int) j4))) ^ d4;
            i7--;
        }
        g(d3 - this.f6014a[0], bArr4, i4);
        g(d4 - this.f6014a[1], bArr4, i4 + 8);
        return 16;
    }

    public final void reset() {
    }
}
