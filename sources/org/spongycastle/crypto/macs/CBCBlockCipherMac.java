package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.paddings.BlockCipherPadding;
import org.spongycastle.crypto.paddings.ISO7816d4Padding;

public class CBCBlockCipherMac implements Mac {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public final CBCBlockCipher f6089a;

    /* renamed from: a  reason: collision with other field name */
    public final BlockCipherPadding f6090a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6091a;
    public final int b;

    /* renamed from: b  reason: collision with other field name */
    public final byte[] f6092b;

    public CBCBlockCipherMac() {
        throw null;
    }

    public CBCBlockCipherMac(BlockCipher blockCipher) {
        this(blockCipher, (blockCipher.c() * 8) / 2, (ISO7816d4Padding) null);
    }

    public final void a(CipherParameters cipherParameters) {
        reset();
        this.f6089a.a(true, cipherParameters);
    }

    public final String b() {
        return this.f6089a.b();
    }

    public final int c(int i, byte[] bArr) {
        CBCBlockCipher cBCBlockCipher = this.f6089a;
        int c = cBCBlockCipher.c();
        byte[] bArr2 = this.f6091a;
        byte[] bArr3 = this.f6092b;
        BlockCipherPadding blockCipherPadding = this.f6090a;
        if (blockCipherPadding == null) {
            while (true) {
                int i2 = this.a;
                if (i2 >= c) {
                    break;
                }
                bArr3[i2] = 0;
                this.a = i2 + 1;
            }
        } else {
            if (this.a == c) {
                cBCBlockCipher.e(0, 0, bArr3, bArr2);
                this.a = 0;
            }
            blockCipherPadding.a(this.a, bArr3);
        }
        cBCBlockCipher.e(0, 0, bArr3, bArr2);
        int i3 = this.b;
        System.arraycopy(bArr2, 0, bArr, 0, i3);
        reset();
        return i3;
    }

    public final void d(byte b2) {
        int i = this.a;
        byte[] bArr = this.f6092b;
        if (i == bArr.length) {
            this.f6089a.e(0, 0, bArr, this.f6091a);
            this.a = 0;
        }
        int i2 = this.a;
        this.a = i2 + 1;
        bArr[i2] = b2;
    }

    public final int e() {
        return this.b;
    }

    public final void reset() {
        int i = 0;
        while (true) {
            byte[] bArr = this.f6092b;
            if (i < bArr.length) {
                bArr[i] = 0;
                i++;
            } else {
                this.a = 0;
                this.f6089a.reset();
                return;
            }
        }
    }

    public final void update(byte[] bArr, int i, int i2) {
        if (i2 >= 0) {
            CBCBlockCipher cBCBlockCipher = this.f6089a;
            int c = cBCBlockCipher.c();
            int i3 = this.a;
            int i4 = c - i3;
            byte[] bArr2 = this.f6092b;
            if (i2 > i4) {
                System.arraycopy(bArr, i, bArr2, i3, i4);
                byte[] bArr3 = this.f6091a;
                cBCBlockCipher.e(0, 0, bArr2, bArr3);
                this.a = 0;
                i2 -= i4;
                i += i4;
                while (i2 > c) {
                    cBCBlockCipher.e(i, 0, bArr, bArr3);
                    i2 -= c;
                    i += c;
                }
            }
            System.arraycopy(bArr, i, bArr2, this.a, i2);
            this.a += i2;
            return;
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }

    public CBCBlockCipherMac(BlockCipher blockCipher, int i, ISO7816d4Padding iSO7816d4Padding) {
        if (i % 8 == 0) {
            this.f6089a = new CBCBlockCipher(blockCipher);
            this.f6090a = iSO7816d4Padding;
            this.b = i / 8;
            this.f6091a = new byte[blockCipher.c()];
            this.f6092b = new byte[blockCipher.c()];
            this.a = 0;
            return;
        }
        throw new IllegalArgumentException("MAC size must be multiple of 8");
    }
}
