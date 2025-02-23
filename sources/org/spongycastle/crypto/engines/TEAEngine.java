package org.spongycastle.crypto.engines;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;

public class TEAEngine implements BlockCipher {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6055a = false;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f6056b;
    public int c;
    public int d;

    public final void a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.f6056b = z;
            this.f6055a = true;
            byte[] bArr = ((KeyParameter) cipherParameters).a;
            if (bArr.length == 16) {
                this.a = d(0, bArr);
                this.b = d(4, bArr);
                this.c = d(8, bArr);
                this.d = d(12, bArr);
                return;
            }
            throw new IllegalArgumentException("Key size must be 128 bits.");
        }
        throw new IllegalArgumentException(xx.H(cipherParameters, "invalid parameter passed to TEA init - "));
    }

    public final String b() {
        return "TEA";
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
        if (!this.f6055a) {
            throw new IllegalStateException("TEA not initialised");
        } else if (i + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 8 <= bArr2.length) {
            int i3 = 0;
            if (this.f6056b) {
                int d2 = d(i, bArr);
                int d3 = d(i + 4, bArr);
                int i4 = 0;
                while (i3 != 32) {
                    i4 -= 1640531527;
                    d2 += (((d3 << 4) + this.a) ^ (d3 + i4)) ^ ((d3 >>> 5) + this.b);
                    d3 += (((d2 << 4) + this.c) ^ (d2 + i4)) ^ ((d2 >>> 5) + this.d);
                    i3++;
                }
                f(d2, bArr2, i2);
                f(d3, bArr2, i2 + 4);
                return 8;
            }
            int d4 = d(i, bArr);
            int d5 = d(i + 4, bArr);
            int i5 = -957401312;
            while (i3 != 32) {
                d5 -= (((d4 << 4) + this.c) ^ (d4 + i5)) ^ ((d4 >>> 5) + this.d);
                d4 -= (((d5 << 4) + this.a) ^ (d5 + i5)) ^ ((d5 >>> 5) + this.b);
                i5 += 1640531527;
                i3++;
            }
            f(d4, bArr2, i2);
            f(d5, bArr2, i2 + 4);
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
