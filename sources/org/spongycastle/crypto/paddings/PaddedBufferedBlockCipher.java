package org.spongycastle.crypto.paddings;

import java.security.SecureRandom;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.ParametersWithRandom;

public class PaddedBufferedBlockCipher extends BufferedBlockCipher {
    public final BlockCipherPadding a;

    public PaddedBufferedBlockCipher(BlockCipher blockCipher, BlockCipherPadding blockCipherPadding) {
        this.f5794a = blockCipher;
        this.a = blockCipherPadding;
        this.f5796a = new byte[blockCipher.c()];
        this.a = 0;
    }

    /* JADX INFO: finally extract failed */
    public final int a(int i, byte[] bArr) throws DataLengthException, IllegalStateException, InvalidCipherTextException {
        int i2;
        int c = this.f5794a.c();
        boolean z = this.f5795a;
        BlockCipherPadding blockCipherPadding = this.a;
        if (z) {
            if (this.a != c) {
                i2 = 0;
            } else if ((c * 2) + i <= bArr.length) {
                i2 = this.f5794a.e(0, i, this.f5796a, bArr);
                this.a = 0;
            } else {
                g();
                throw new OutputLengthException("output buffer too short");
            }
            blockCipherPadding.a(this.a, this.f5796a);
            int e = this.f5794a.e(0, i + i2, this.f5796a, bArr) + i2;
            g();
            return e;
        } else if (this.a == c) {
            BlockCipher blockCipher = this.f5794a;
            byte[] bArr2 = this.f5796a;
            int e2 = blockCipher.e(0, 0, bArr2, bArr2);
            this.a = 0;
            try {
                int b = e2 - blockCipherPadding.b(this.f5796a);
                System.arraycopy(this.f5796a, 0, bArr, i, b);
                g();
                return b;
            } catch (Throwable th) {
                g();
                throw th;
            }
        } else {
            g();
            throw new DataLengthException("last block incomplete in decryption");
        }
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
            return Math.max(0, i2 - bArr.length);
        }
        return i2 - length;
    }

    public final void e(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        this.f5795a = z;
        g();
        boolean z2 = cipherParameters instanceof ParametersWithRandom;
        BlockCipherPadding blockCipherPadding = this.a;
        if (z2) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            blockCipherPadding.c(parametersWithRandom.a);
            this.f5794a.a(z, parametersWithRandom.f6234a);
            return;
        }
        blockCipherPadding.c((SecureRandom) null);
        this.f5794a.a(z, cipherParameters);
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

    public PaddedBufferedBlockCipher(BlockCipher blockCipher) {
        this(blockCipher, new PKCS7Padding());
    }
}
