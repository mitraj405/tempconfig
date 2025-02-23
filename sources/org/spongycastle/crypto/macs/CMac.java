package org.spongycastle.crypto.macs;

import com.google.android.gms.ads.AdRequest;
import com.google.android.material.internal.ViewUtils;
import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.paddings.ISO7816d4Padding;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Pack;

public class CMac implements Mac {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public final CBCBlockCipher f6097a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6098a;
    public final int b;

    /* renamed from: b  reason: collision with other field name */
    public final byte[] f6099b;
    public final byte[] c;
    public final byte[] d;
    public byte[] e;
    public byte[] f;

    public CMac(BlockCipher blockCipher) {
        int i;
        int c2 = blockCipher.c() * 8;
        if (c2 % 8 != 0) {
            throw new IllegalArgumentException("MAC size must be multiple of 8");
        } else if (c2 <= blockCipher.c() * 8) {
            this.f6097a = new CBCBlockCipher(blockCipher);
            this.b = c2 / 8;
            int c3 = blockCipher.c() * 8;
            switch (c3) {
                case 64:
                case 320:
                    i = 27;
                    break;
                case 128:
                case 192:
                    i = 135;
                    break;
                case 160:
                    i = 45;
                    break;
                case 224:
                    i = 777;
                    break;
                case 256:
                    i = 1061;
                    break;
                case 384:
                    i = 4109;
                    break;
                case 448:
                    i = 2129;
                    break;
                case AdRequest.MAX_CONTENT_URL_LENGTH:
                    i = 293;
                    break;
                case ViewUtils.EDGE_TO_EDGE_FLAGS:
                    i = 655377;
                    break;
                case UserMetadata.MAX_ATTRIBUTE_SIZE:
                    i = 524355;
                    break;
                case 2048:
                    i = 548865;
                    break;
                default:
                    throw new IllegalArgumentException(lf.h("Unknown block size for CMAC: ", c3));
            }
            byte[] bArr = new byte[4];
            Pack.c(i, bArr, 0);
            this.f6098a = bArr;
            this.c = new byte[blockCipher.c()];
            this.d = new byte[blockCipher.c()];
            this.f6099b = new byte[blockCipher.c()];
            this.a = 0;
        } else {
            throw new IllegalArgumentException("MAC size must be less or equal to " + (blockCipher.c() * 8));
        }
    }

    public final void a(CipherParameters cipherParameters) {
        g(cipherParameters);
        CBCBlockCipher cBCBlockCipher = this.f6097a;
        cBCBlockCipher.a(true, cipherParameters);
        byte[] bArr = this.f6099b;
        byte[] bArr2 = new byte[bArr.length];
        cBCBlockCipher.e(0, 0, bArr, bArr2);
        byte[] f2 = f(bArr2);
        this.e = f2;
        this.f = f(f2);
        reset();
    }

    public final String b() {
        return this.f6097a.b();
    }

    public final int c(int i, byte[] bArr) {
        byte[] bArr2;
        CBCBlockCipher cBCBlockCipher = this.f6097a;
        int c2 = cBCBlockCipher.c();
        int i2 = this.a;
        byte[] bArr3 = this.d;
        if (i2 == c2) {
            bArr2 = this.e;
        } else {
            new ISO7816d4Padding().a(this.a, bArr3);
            bArr2 = this.f;
        }
        int i3 = 0;
        while (true) {
            byte[] bArr4 = this.c;
            if (i3 < bArr4.length) {
                bArr3[i3] = (byte) (bArr3[i3] ^ bArr2[i3]);
                i3++;
            } else {
                cBCBlockCipher.e(0, 0, bArr3, bArr4);
                int i4 = this.b;
                System.arraycopy(bArr4, 0, bArr, 0, i4);
                reset();
                return i4;
            }
        }
    }

    public final void d(byte b2) {
        int i = this.a;
        byte[] bArr = this.d;
        if (i == bArr.length) {
            this.f6097a.e(0, 0, bArr, this.c);
            this.a = 0;
        }
        int i2 = this.a;
        this.a = i2 + 1;
        bArr[i2] = b2;
    }

    public final int e() {
        return this.b;
    }

    public final byte[] f(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int length = bArr.length;
        int i = 0;
        while (true) {
            length--;
            if (length >= 0) {
                byte b2 = bArr[length] & UnsignedBytes.MAX_VALUE;
                bArr2[length] = (byte) (i | (b2 << 1));
                i = (b2 >>> 7) & 1;
            } else {
                byte b3 = (-i) & UnsignedBytes.MAX_VALUE;
                int length2 = bArr.length - 3;
                byte b4 = bArr2[length2];
                byte[] bArr3 = this.f6098a;
                bArr2[length2] = (byte) (b4 ^ (bArr3[1] & b3));
                int length3 = bArr.length - 2;
                bArr2[length3] = (byte) ((bArr3[2] & b3) ^ bArr2[length3]);
                int length4 = bArr.length - 1;
                bArr2[length4] = (byte) ((b3 & bArr3[3]) ^ bArr2[length4]);
                return bArr2;
            }
        }
    }

    public void g(CipherParameters cipherParameters) {
        if (cipherParameters != null && !(cipherParameters instanceof KeyParameter)) {
            throw new IllegalArgumentException("CMac mode only permits key to be set.");
        }
    }

    public final void reset() {
        int i = 0;
        while (true) {
            byte[] bArr = this.d;
            if (i < bArr.length) {
                bArr[i] = 0;
                i++;
            } else {
                this.a = 0;
                this.f6097a.reset();
                return;
            }
        }
    }

    public final void update(byte[] bArr, int i, int i2) {
        if (i2 >= 0) {
            CBCBlockCipher cBCBlockCipher = this.f6097a;
            int c2 = cBCBlockCipher.c();
            int i3 = this.a;
            int i4 = c2 - i3;
            byte[] bArr2 = this.d;
            if (i2 > i4) {
                System.arraycopy(bArr, i, bArr2, i3, i4);
                byte[] bArr3 = this.c;
                cBCBlockCipher.e(0, 0, bArr2, bArr3);
                this.a = 0;
                i2 -= i4;
                i += i4;
                while (i2 > c2) {
                    cBCBlockCipher.e(i, 0, bArr, bArr3);
                    i2 -= c2;
                    i += c2;
                }
            }
            System.arraycopy(bArr, i, bArr2, this.a, i2);
            this.a += i2;
            return;
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }
}
