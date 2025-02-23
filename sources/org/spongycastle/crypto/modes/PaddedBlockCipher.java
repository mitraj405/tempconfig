package org.spongycastle.crypto.modes;

import com.google.common.primitives.UnsignedBytes;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.OutputLengthException;

public class PaddedBlockCipher extends BufferedBlockCipher {
    public final int a(int i, byte[] bArr) throws DataLengthException, IllegalStateException, InvalidCipherTextException {
        int i2;
        int i3;
        int c = this.f5794a.c();
        if (this.f5795a) {
            if (this.a != c) {
                i3 = 0;
            } else if ((c * 2) + i <= bArr.length) {
                i3 = this.f5794a.e(0, i, this.f5796a, bArr);
                this.a = 0;
            } else {
                throw new OutputLengthException("output buffer too short");
            }
            byte b = (byte) (c - this.a);
            while (true) {
                int i4 = this.a;
                if (i4 >= c) {
                    break;
                }
                this.f5796a[i4] = b;
                this.a = i4 + 1;
            }
            i2 = this.f5794a.e(0, i + i3, this.f5796a, bArr) + i3;
        } else if (this.a == c) {
            BlockCipher blockCipher = this.f5794a;
            byte[] bArr2 = this.f5796a;
            int e = blockCipher.e(0, 0, bArr2, bArr2);
            this.a = 0;
            byte[] bArr3 = this.f5796a;
            byte b2 = bArr3[c - 1] & UnsignedBytes.MAX_VALUE;
            if (b2 < 0 || b2 > c) {
                throw new InvalidCipherTextException("pad block corrupted");
            }
            int i5 = e - b2;
            System.arraycopy(bArr3, 0, bArr, i, i5);
            i2 = i5;
        } else {
            throw new DataLengthException("last block incomplete in decryption");
        }
        g();
        return i2;
    }

    public final int c(int i) {
        int i2;
        int i3 = i + this.a;
        byte[] bArr = this.f5796a;
        int length = i3 % bArr.length;
        if (length != 0) {
            i3 -= length;
            i2 = bArr.length;
        } else if (!this.f5795a) {
            return i3;
        } else {
            i2 = bArr.length;
        }
        return i3 + i2;
    }

    public final int d(int i) {
        int i2 = i + this.a;
        byte[] bArr = this.f5796a;
        int length = i2 % bArr.length;
        if (length == 0) {
            return i2 - bArr.length;
        }
        return i2 - length;
    }

    public final int f(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException, IllegalStateException {
        if (i2 >= 0) {
            int b = b();
            int d = d(i2);
            if (d <= 0 || d + i3 <= bArr2.length) {
                byte[] bArr3 = this.f5796a;
                int length = bArr3.length;
                int i4 = this.a;
                int i5 = length - i4;
                int i6 = 0;
                if (i2 > i5) {
                    System.arraycopy(bArr, i, bArr3, i4, i5);
                    this.a = 0;
                    i2 -= i5;
                    i += i5;
                    i6 = this.f5794a.e(0, i3, this.f5796a, bArr2) + 0;
                    while (i2 > this.f5796a.length) {
                        i6 += this.f5794a.e(i, i3 + i6, bArr, bArr2);
                        i2 -= b;
                        i += b;
                    }
                }
                System.arraycopy(bArr, i, this.f5796a, this.a, i2);
                this.a += i2;
                return i6;
            }
            throw new OutputLengthException("output buffer too short");
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }
}
