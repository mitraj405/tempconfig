package org.spongycastle.crypto.prng.drbg;

import com.google.common.primitives.UnsignedBytes;
import java.util.Hashtable;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.prng.EntropySource;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.encoders.Hex;

public class CTRSP800DRBG implements SP80090DRBG {
    public static final byte[] a = Hex.a("000102030405060708090A0B0C0D0E0F101112131415161718191A1B1C1D1E1F");

    /* renamed from: a  reason: collision with other field name */
    public final int f6252a;

    /* renamed from: a  reason: collision with other field name */
    public long f6253a = 0;

    /* renamed from: a  reason: collision with other field name */
    public final BlockCipher f6254a;

    /* renamed from: a  reason: collision with other field name */
    public final EntropySource f6255a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f6256a = false;
    public final int b;

    public CTRSP800DRBG(EntropySource entropySource) {
        this.f6255a = entropySource;
        this.f6254a = null;
        this.f6252a = 0;
        this.b = 0;
        throw null;
    }

    public static void e(int i, byte[] bArr, int i2) {
        bArr[i2 + 0] = (byte) (i >> 24);
        bArr[i2 + 1] = (byte) (i >> 16);
        bArr[i2 + 2] = (byte) (i >> 8);
        bArr[i2 + 3] = (byte) i;
    }

    public static void g(int i, int i2, byte[] bArr, byte[] bArr2) {
        int i3 = i + 0;
        bArr2[i2 + 0] = (byte) (bArr[i3] & 254);
        int i4 = i + 1;
        bArr2[i2 + 1] = (byte) ((bArr[i3] << 7) | ((bArr[i4] & 252) >>> 1));
        int i5 = i + 2;
        bArr2[i2 + 2] = (byte) ((bArr[i4] << 6) | ((bArr[i5] & 248) >>> 2));
        int i6 = i + 3;
        bArr2[i2 + 3] = (byte) ((bArr[i5] << 5) | ((bArr[i6] & 240) >>> 3));
        int i7 = i + 4;
        bArr2[i2 + 4] = (byte) ((bArr[i6] << 4) | ((bArr[i7] & 224) >>> 4));
        int i8 = i + 5;
        bArr2[i2 + 5] = (byte) ((bArr[i7] << 3) | ((bArr[i8] & 192) >>> 5));
        int i9 = i + 6;
        bArr2[i2 + 6] = (byte) ((bArr[i8] << 2) | ((bArr[i9] & UnsignedBytes.MAX_POWER_OF_TWO) >>> 6));
        int i10 = i2 + 7;
        bArr2[i10] = (byte) (bArr[i9] << 1);
        while (i2 <= i10) {
            byte b2 = bArr2[i2];
            bArr2[i2] = (byte) (((((b2 >> 7) ^ ((((((b2 >> 1) ^ (b2 >> 2)) ^ (b2 >> 3)) ^ (b2 >> 4)) ^ (b2 >> 5)) ^ (b2 >> 6))) ^ 1) & 1) | (b2 & 254));
            i2++;
        }
    }

    public final void a() {
        byte[] a2 = this.f6255a.a();
        if (a2.length >= (this.b + 7) / 8) {
            d(c(0, Arrays.i(a2, (byte[]) null)), (byte[]) null, (byte[]) null);
            this.f6253a = 1;
            return;
        }
        throw new IllegalStateException("Insufficient entropy provided by entropy source");
    }

    public final int b(byte[] bArr, boolean z) {
        boolean z2 = false;
        if (this.f6256a) {
            if (this.f6253a > 2147483648L) {
                return -1;
            }
            Hashtable hashtable = Utils.a;
            if (bArr != null && bArr.length > 512) {
                z2 = true;
            }
            if (z2) {
                throw new IllegalArgumentException("Number of bits per request limited to 4096");
            }
        } else if (this.f6253a > 140737488355328L) {
            return -1;
        } else {
            Hashtable hashtable2 = Utils.a;
            if (bArr != null && bArr.length > 32768) {
                z2 = true;
            }
            if (z2) {
                throw new IllegalArgumentException("Number of bits per request limited to 262144");
            }
        }
        if (z) {
            byte[] a2 = this.f6255a.a();
            if (a2.length >= (this.b + 7) / 8) {
                d(c(0, Arrays.i(a2, (byte[]) null)), (byte[]) null, (byte[]) null);
                this.f6253a = 1;
            } else {
                throw new IllegalStateException("Insufficient entropy provided by entropy source");
            }
        }
        throw null;
    }

    public final byte[] c(int i, byte[] bArr) {
        int i2;
        byte[] bArr2 = bArr;
        BlockCipher blockCipher = this.f6254a;
        int c = blockCipher.c();
        int length = bArr2.length;
        int i3 = length + 8;
        int i4 = ((((i3 + 1) + c) - 1) / c) * c;
        byte[] bArr3 = new byte[i4];
        int i5 = 0;
        e(length, bArr3, 0);
        e(i / 8, bArr3, 4);
        System.arraycopy(bArr2, 0, bArr3, 8, length);
        bArr3[i3] = UnsignedBytes.MAX_POWER_OF_TWO;
        int i6 = this.f6252a;
        int i7 = i6 / 8;
        int i8 = i7 + c;
        byte[] bArr4 = new byte[i8];
        byte[] bArr5 = new byte[c];
        byte[] bArr6 = new byte[c];
        byte[] bArr7 = new byte[i7];
        System.arraycopy(a, 0, bArr7, 0, i7);
        int i9 = 0;
        while (true) {
            int i10 = i9 * c;
            i2 = i7;
            if (i10 * 8 >= (c * 8) + i6) {
                break;
            }
            e(i9, bArr6, i5);
            int c2 = blockCipher.c();
            byte[] bArr8 = new byte[c2];
            int i11 = i4 / c2;
            int i12 = i6;
            byte[] bArr9 = new byte[c2];
            int i13 = i4;
            int i14 = i9;
            blockCipher.a(true, new KeyParameter(f(bArr7)));
            blockCipher.e(0, 0, bArr6, bArr8);
            int i15 = 0;
            while (i15 < i11) {
                int i16 = i15 * c2;
                int i17 = i11;
                int i18 = 0;
                while (i18 < c2) {
                    bArr9[i18] = (byte) (bArr8[i18] ^ bArr3[i18 + i16]);
                    i18++;
                    c2 = c2;
                }
                blockCipher.e(0, 0, bArr9, bArr8);
                i15++;
                i11 = i17;
                c2 = c2;
            }
            System.arraycopy(bArr8, 0, bArr5, 0, c);
            int i19 = i8 - i10;
            if (i19 > c) {
                i19 = c;
            }
            System.arraycopy(bArr5, 0, bArr4, i10, i19);
            i9 = i14 + 1;
            i5 = 0;
            i6 = i12;
            i4 = i13;
            i7 = i2;
        }
        int i20 = i5;
        byte[] bArr10 = new byte[c];
        int i21 = i2;
        System.arraycopy(bArr4, i20, bArr7, i20, i21);
        System.arraycopy(bArr4, i21, bArr10, i20, c);
        int i22 = i / 2;
        byte[] bArr11 = new byte[i22];
        blockCipher.a(true, new KeyParameter(f(bArr7)));
        int i23 = i20;
        while (true) {
            int i24 = i23 * c;
            if (i24 >= i22) {
                return bArr11;
            }
            blockCipher.e(i20, i20, bArr10, bArr10);
            int i25 = i22 - i24;
            if (i25 > c) {
                i25 = c;
            }
            System.arraycopy(bArr10, i20, bArr11, i24, i25);
            i23++;
        }
    }

    public final void d(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = bArr;
        byte[] bArr5 = bArr2;
        byte[] bArr6 = bArr3;
        int length = bArr4.length;
        byte[] bArr7 = new byte[length];
        BlockCipher blockCipher = this.f6254a;
        byte[] bArr8 = new byte[blockCipher.c()];
        int c = blockCipher.c();
        int i = 1;
        blockCipher.a(true, new KeyParameter(f(bArr5)));
        int i2 = 0;
        while (true) {
            int i3 = i2 * c;
            if (i3 >= bArr4.length) {
                break;
            }
            int i4 = i;
            byte b2 = i4;
            while (i4 <= bArr6.length) {
                int i5 = (bArr6[bArr6.length - i4] & UnsignedBytes.MAX_VALUE) + b2;
                if (i5 > 255) {
                    b2 = 1;
                } else {
                    b2 = 0;
                }
                bArr6[bArr6.length - i4] = (byte) i5;
                i4++;
            }
            blockCipher.e(0, 0, bArr6, bArr8);
            int i6 = length - i3;
            if (i6 > c) {
                i6 = c;
            }
            System.arraycopy(bArr8, 0, bArr7, i3, i6);
            i2++;
            i = 1;
        }
        for (int i7 = 0; i7 < length; i7++) {
            bArr7[i7] = (byte) (bArr4[i7] ^ bArr7[i7 + 0]);
        }
        System.arraycopy(bArr7, 0, bArr5, 0, bArr5.length);
        System.arraycopy(bArr7, bArr5.length, bArr6, 0, bArr6.length);
    }

    public final byte[] f(byte[] bArr) {
        if (!this.f6256a) {
            return bArr;
        }
        byte[] bArr2 = new byte[24];
        g(0, 0, bArr, bArr2);
        g(7, 8, bArr, bArr2);
        g(14, 16, bArr, bArr2);
        return bArr2;
    }
}
