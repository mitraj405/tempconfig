package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.OutputLengthException;

public class OldCTSBlockCipher extends BufferedBlockCipher {
    public final int a(int i, byte[] bArr) throws DataLengthException, IllegalStateException, InvalidCipherTextException {
        if (this.a + i <= bArr.length) {
            int c = this.f5794a.c();
            int i2 = this.a - c;
            byte[] bArr2 = new byte[c];
            if (this.f5795a) {
                this.f5794a.e(0, 0, this.f5796a, bArr2);
                int i3 = this.a;
                if (i3 >= c) {
                    while (true) {
                        byte[] bArr3 = this.f5796a;
                        if (i3 == bArr3.length) {
                            break;
                        }
                        bArr3[i3] = bArr2[i3 - c];
                        i3++;
                    }
                    for (int i4 = c; i4 != this.a; i4++) {
                        byte[] bArr4 = this.f5796a;
                        bArr4[i4] = (byte) (bArr4[i4] ^ bArr2[i4 - c]);
                    }
                    BlockCipher blockCipher = this.f5794a;
                    if (blockCipher instanceof CBCBlockCipher) {
                        ((CBCBlockCipher) blockCipher).f6136a.e(c, i, this.f5796a, bArr);
                    } else {
                        blockCipher.e(c, i, this.f5796a, bArr);
                    }
                    System.arraycopy(bArr2, 0, bArr, i + c, i2);
                } else {
                    throw new DataLengthException("need at least one block of input for CTS");
                }
            } else {
                byte[] bArr5 = new byte[c];
                BlockCipher blockCipher2 = this.f5794a;
                if (blockCipher2 instanceof CBCBlockCipher) {
                    ((CBCBlockCipher) blockCipher2).f6136a.e(0, 0, this.f5796a, bArr2);
                } else {
                    blockCipher2.e(0, 0, this.f5796a, bArr2);
                }
                for (int i5 = c; i5 != this.a; i5++) {
                    int i6 = i5 - c;
                    bArr5[i6] = (byte) (bArr2[i6] ^ this.f5796a[i5]);
                }
                System.arraycopy(this.f5796a, c, bArr2, 0, i2);
                this.f5794a.e(0, i, bArr2, bArr);
                System.arraycopy(bArr5, 0, bArr, i + c, i2);
            }
            int i7 = this.a;
            g();
            return i7;
        }
        throw new OutputLengthException("output buffer to small in doFinal");
    }

    public final int c(int i) {
        return i + this.a;
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
                    int e = this.f5794a.e(0, i3, this.f5796a, bArr2) + 0;
                    byte[] bArr4 = this.f5796a;
                    System.arraycopy(bArr4, b, bArr4, 0, b);
                    this.a = b;
                    i2 -= i5;
                    i += i5;
                    while (i2 > b) {
                        System.arraycopy(bArr, i, this.f5796a, this.a, b);
                        e += this.f5794a.e(0, i3 + e, this.f5796a, bArr2);
                        byte[] bArr5 = this.f5796a;
                        System.arraycopy(bArr5, b, bArr5, 0, b);
                        i2 -= b;
                        i += b;
                    }
                    i6 = e;
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
