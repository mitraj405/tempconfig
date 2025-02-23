package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.paddings.BlockCipherPadding;
import org.spongycastle.crypto.params.ParametersWithIV;

public class CFBBlockCipherMac implements Mac {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public final MacCFBBlockCipher f6093a;

    /* renamed from: a  reason: collision with other field name */
    public final BlockCipherPadding f6094a = null;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6095a;
    public final int b;

    /* renamed from: b  reason: collision with other field name */
    public final byte[] f6096b;

    public CFBBlockCipherMac(BlockCipher blockCipher) {
        int c = (blockCipher.c() * 8) / 2;
        if (c % 8 == 0) {
            this.f6095a = new byte[blockCipher.c()];
            this.f6093a = new MacCFBBlockCipher(blockCipher);
            this.f6094a = null;
            this.b = c / 8;
            this.f6096b = new byte[1];
            this.a = 0;
            return;
        }
        throw new IllegalArgumentException("MAC size must be multiple of 8");
    }

    public final void a(CipherParameters cipherParameters) {
        reset();
        MacCFBBlockCipher macCFBBlockCipher = this.f6093a;
        macCFBBlockCipher.getClass();
        boolean z = cipherParameters instanceof ParametersWithIV;
        byte[] bArr = macCFBBlockCipher.b;
        byte[] bArr2 = macCFBBlockCipher.f6122a;
        BlockCipher blockCipher = macCFBBlockCipher.f6121a;
        if (z) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] bArr3 = parametersWithIV.f6233a;
            if (bArr3.length < bArr2.length) {
                System.arraycopy(bArr3, 0, bArr2, bArr2.length - bArr3.length, bArr3.length);
            } else {
                System.arraycopy(bArr3, 0, bArr2, 0, bArr2.length);
            }
            System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
            blockCipher.reset();
            blockCipher.a(true, parametersWithIV.a);
            return;
        }
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        blockCipher.reset();
        blockCipher.a(true, cipherParameters);
    }

    public final String b() {
        StringBuilder sb = new StringBuilder();
        MacCFBBlockCipher macCFBBlockCipher = this.f6093a;
        sb.append(macCFBBlockCipher.f6121a.b());
        sb.append("/CFB");
        sb.append(macCFBBlockCipher.a * 8);
        return sb.toString();
    }

    public final int c(int i, byte[] bArr) {
        MacCFBBlockCipher macCFBBlockCipher = this.f6093a;
        int i2 = macCFBBlockCipher.a;
        byte[] bArr2 = this.f6096b;
        BlockCipherPadding blockCipherPadding = this.f6094a;
        if (blockCipherPadding == null) {
            while (true) {
                int i3 = this.a;
                if (i3 >= i2) {
                    break;
                }
                bArr2[i3] = 0;
                this.a = i3 + 1;
            }
        } else {
            blockCipherPadding.a(this.a, bArr2);
        }
        byte[] bArr3 = this.f6095a;
        macCFBBlockCipher.a(0, bArr2, bArr3);
        macCFBBlockCipher.f6121a.e(0, 0, macCFBBlockCipher.b, bArr3);
        int i4 = this.b;
        System.arraycopy(bArr3, 0, bArr, 0, i4);
        reset();
        return i4;
    }

    public final void d(byte b2) {
        int i = this.a;
        byte[] bArr = this.f6096b;
        if (i == bArr.length) {
            this.f6093a.a(0, bArr, this.f6095a);
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
            byte[] bArr = this.f6096b;
            if (i < bArr.length) {
                bArr[i] = 0;
                i++;
            } else {
                this.a = 0;
                MacCFBBlockCipher macCFBBlockCipher = this.f6093a;
                byte[] bArr2 = macCFBBlockCipher.b;
                byte[] bArr3 = macCFBBlockCipher.f6122a;
                System.arraycopy(bArr3, 0, bArr2, 0, bArr3.length);
                macCFBBlockCipher.f6121a.reset();
                return;
            }
        }
    }

    public final void update(byte[] bArr, int i, int i2) {
        if (i2 >= 0) {
            MacCFBBlockCipher macCFBBlockCipher = this.f6093a;
            int i3 = macCFBBlockCipher.a;
            int i4 = this.a;
            int i5 = i3 - i4;
            byte[] bArr2 = this.f6096b;
            if (i2 > i5) {
                System.arraycopy(bArr, i, bArr2, i4, i5);
                byte[] bArr3 = this.f6095a;
                macCFBBlockCipher.a(0, bArr2, bArr3);
                this.a = 0;
                i2 -= i5;
                i += i5;
                while (i2 > i3) {
                    macCFBBlockCipher.a(i, bArr, bArr3);
                    i2 -= i3;
                    i += i3;
                }
            }
            System.arraycopy(bArr, i, bArr2, this.a, i2);
            this.a += i2;
            return;
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }
}
