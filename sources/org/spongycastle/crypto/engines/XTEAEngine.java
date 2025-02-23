package org.spongycastle.crypto.engines;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;

public class XTEAEngine implements BlockCipher {
    public boolean a = false;

    /* renamed from: a  reason: collision with other field name */
    public final int[] f6070a = new int[4];
    public boolean b;

    /* renamed from: b  reason: collision with other field name */
    public final int[] f6071b = new int[32];
    public final int[] c = new int[32];

    public final void a(boolean z, CipherParameters cipherParameters) {
        int[] iArr;
        if (cipherParameters instanceof KeyParameter) {
            this.b = z;
            this.a = true;
            byte[] bArr = ((KeyParameter) cipherParameters).a;
            if (bArr.length == 16) {
                int i = 0;
                int i2 = 0;
                while (true) {
                    iArr = this.f6070a;
                    if (i >= 4) {
                        break;
                    }
                    iArr[i] = d(i2, bArr);
                    i++;
                    i2 += 4;
                }
                int i3 = 0;
                for (int i4 = 0; i4 < 32; i4++) {
                    this.f6071b[i4] = iArr[i3 & 3] + i3;
                    i3 -= 1640531527;
                    this.c[i4] = iArr[(i3 >>> 11) & 3] + i3;
                }
                return;
            }
            throw new IllegalArgumentException("Key size must be 128 bits.");
        }
        throw new IllegalArgumentException(xx.H(cipherParameters, "invalid parameter passed to TEA init - "));
    }

    public final String b() {
        return "XTEA";
    }

    public final int c() {
        return 8;
    }

    public final int d(int i, byte[] bArr) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        return (bArr[i] << Ascii.CAN) | ((bArr[i2] & UnsignedBytes.MAX_VALUE) << Ascii.DLE) | ((bArr[i3] & UnsignedBytes.MAX_VALUE) << 8) | (bArr[i3 + 1] & UnsignedBytes.MAX_VALUE);
    }

    public final int e(int i, int i2, byte[] bArr, byte[] bArr2) {
        if (!this.a) {
            throw new IllegalStateException("XTEA not initialised");
        } else if (i + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 8 <= bArr2.length) {
            boolean z = this.b;
            int[] iArr = this.f6071b;
            int[] iArr2 = this.c;
            if (z) {
                int d = d(i, bArr);
                int d2 = d(i + 4, bArr);
                for (int i3 = 0; i3 < 32; i3++) {
                    d += (((d2 << 4) ^ (d2 >>> 5)) + d2) ^ iArr[i3];
                    d2 += (((d << 4) ^ (d >>> 5)) + d) ^ iArr2[i3];
                }
                f(d, bArr2, i2);
                f(d2, bArr2, i2 + 4);
                return 8;
            }
            int d3 = d(i, bArr);
            int d4 = d(i + 4, bArr);
            for (int i4 = 31; i4 >= 0; i4--) {
                d4 -= (((d3 << 4) ^ (d3 >>> 5)) + d3) ^ iArr2[i4];
                d3 -= (((d4 << 4) ^ (d4 >>> 5)) + d4) ^ iArr[i4];
            }
            f(d3, bArr2, i2);
            f(d4, bArr2, i2 + 4);
            return 8;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public final void f(int i, byte[] bArr, int i2) {
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i >>> 24);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i >>> 16);
        bArr[i4] = (byte) (i >>> 8);
        bArr[i4 + 1] = (byte) i;
    }

    public final void reset() {
    }
}
