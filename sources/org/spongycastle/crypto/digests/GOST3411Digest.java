package org.spongycastle.crypto.digests;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.lang.reflect.Array;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.engines.GOST28147Engine;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithSBox;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Memoable;
import org.spongycastle.util.Pack;

public class GOST3411Digest implements ExtendedDigest, Memoable {
    public static final byte[] m = {0, -1, 0, -1, 0, -1, 0, -1, -1, 0, -1, 0, -1, 0, -1, 0, 0, -1, -1, 0, -1, 0, 0, -1, -1, 0, 0, 0, -1, -1, 0, -1};
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public long f5833a;

    /* renamed from: a  reason: collision with other field name */
    public final GOST28147Engine f5834a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f5835a;

    /* renamed from: a  reason: collision with other field name */
    public final short[] f5836a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[][] f5837a;
    public final byte[] b;

    /* renamed from: b  reason: collision with other field name */
    public final short[] f5838b;
    public final byte[] c;
    public final byte[] d;
    public final byte[] e;
    public byte[] f;
    public final byte[] g;
    public final byte[] h;
    public final byte[] i;
    public final byte[] j;
    public byte[] k;
    public final byte[] l;

    public GOST3411Digest() {
        this.f5835a = new byte[32];
        this.b = new byte[32];
        this.c = new byte[32];
        this.d = new byte[32];
        this.f5837a = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{4, 32});
        this.e = new byte[32];
        GOST28147Engine gOST28147Engine = new GOST28147Engine();
        this.f5834a = gOST28147Engine;
        this.g = new byte[32];
        this.h = new byte[8];
        this.f5836a = new short[16];
        this.f5838b = new short[16];
        this.i = new byte[32];
        this.j = new byte[32];
        this.k = new byte[32];
        this.l = new byte[32];
        byte[] i2 = GOST28147Engine.i("D-A");
        this.f = i2;
        gOST28147Engine.a(true, new ParametersWithSBox((CipherParameters) null, i2));
        reset();
    }

    public final Memoable a() {
        return new GOST3411Digest(this);
    }

    public final String b() {
        return "GOST3411";
    }

    public final int c(int i2, byte[] bArr) {
        byte[] bArr2 = this.b;
        Pack.l(this.f5833a * 8, bArr2, 0);
        while (this.a != 0) {
            d((byte) 0);
        }
        l(0, bArr2);
        l(0, this.d);
        byte[] bArr3 = this.f5835a;
        System.arraycopy(bArr3, 0, bArr, i2, bArr3.length);
        reset();
        return 32;
    }

    public final void d(byte b2) {
        int i2 = this.a;
        int i3 = i2 + 1;
        this.a = i3;
        byte[] bArr = this.e;
        bArr[i2] = b2;
        if (i3 == bArr.length) {
            int i4 = 0;
            int i5 = 0;
            while (true) {
                byte[] bArr2 = this.d;
                if (i4 == bArr2.length) {
                    break;
                }
                int i6 = (bArr2[i4] & UnsignedBytes.MAX_VALUE) + (bArr[i4] & UnsignedBytes.MAX_VALUE) + i5;
                bArr2[i4] = (byte) i6;
                i5 = i6 >>> 8;
                i4++;
            }
            l(0, bArr);
            this.a = 0;
        }
        this.f5833a++;
    }

    public final void e(Memoable memoable) {
        GOST3411Digest gOST3411Digest = (GOST3411Digest) memoable;
        byte[] bArr = gOST3411Digest.f;
        this.f = bArr;
        this.f5834a.a(true, new ParametersWithSBox((CipherParameters) null, bArr));
        reset();
        byte[] bArr2 = gOST3411Digest.f5835a;
        System.arraycopy(bArr2, 0, this.f5835a, 0, bArr2.length);
        byte[] bArr3 = gOST3411Digest.b;
        System.arraycopy(bArr3, 0, this.b, 0, bArr3.length);
        byte[] bArr4 = gOST3411Digest.c;
        System.arraycopy(bArr4, 0, this.c, 0, bArr4.length);
        byte[] bArr5 = gOST3411Digest.d;
        System.arraycopy(bArr5, 0, this.d, 0, bArr5.length);
        byte[][] bArr6 = gOST3411Digest.f5837a;
        byte[] bArr7 = bArr6[1];
        byte[][] bArr8 = this.f5837a;
        System.arraycopy(bArr7, 0, bArr8[1], 0, bArr7.length);
        byte[] bArr9 = bArr6[2];
        System.arraycopy(bArr9, 0, bArr8[2], 0, bArr9.length);
        byte[] bArr10 = bArr6[3];
        System.arraycopy(bArr10, 0, bArr8[3], 0, bArr10.length);
        byte[] bArr11 = gOST3411Digest.e;
        System.arraycopy(bArr11, 0, this.e, 0, bArr11.length);
        this.a = gOST3411Digest.a;
        this.f5833a = gOST3411Digest.f5833a;
    }

    public final int f() {
        return 32;
    }

    public final int h() {
        return 32;
    }

    public final void i(byte[] bArr) {
        int i2 = 0;
        while (true) {
            byte[] bArr2 = this.h;
            if (i2 < 8) {
                bArr2[i2] = (byte) (bArr[i2] ^ bArr[i2 + 8]);
                i2++;
            } else {
                System.arraycopy(bArr, 8, bArr, 0, 24);
                System.arraycopy(bArr2, 0, bArr, 24, 8);
                return;
            }
        }
    }

    public final byte[] j(byte[] bArr) {
        int i2 = 0;
        while (true) {
            byte[] bArr2 = this.g;
            if (i2 >= 8) {
                return bArr2;
            }
            int i3 = i2 * 4;
            bArr2[i3] = bArr[i2];
            bArr2[i3 + 1] = bArr[i2 + 8];
            bArr2[i3 + 2] = bArr[i2 + 16];
            bArr2[i3 + 3] = bArr[i2 + 24];
            i2++;
        }
    }

    public final void k(byte[] bArr) {
        short[] sArr;
        int i2 = 0;
        while (true) {
            int length = bArr.length / 2;
            sArr = this.f5836a;
            if (i2 >= length) {
                break;
            }
            int i3 = i2 * 2;
            sArr[i2] = (short) ((bArr[i3] & UnsignedBytes.MAX_VALUE) | ((bArr[i3 + 1] << 8) & Ascii.NUL));
            i2++;
        }
        short[] sArr2 = this.f5838b;
        sArr2[15] = (short) (((((sArr[0] ^ sArr[1]) ^ sArr[2]) ^ sArr[3]) ^ sArr[12]) ^ sArr[15]);
        System.arraycopy(sArr, 1, sArr2, 0, 15);
        for (int i4 = 0; i4 < bArr.length / 2; i4++) {
            int i5 = i4 * 2;
            short s = sArr2[i4];
            bArr[i5 + 1] = (byte) (s >> 8);
            bArr[i5] = (byte) s;
        }
    }

    public final void l(int i2, byte[] bArr) {
        byte[] bArr2;
        byte[] bArr3 = this.c;
        System.arraycopy(bArr, 0, bArr3, 0, 32);
        byte[] bArr4 = this.f5835a;
        byte[] bArr5 = this.j;
        System.arraycopy(bArr4, 0, bArr5, 0, 32);
        System.arraycopy(bArr3, 0, this.k, 0, 32);
        int i3 = 0;
        while (true) {
            bArr2 = this.l;
            if (i3 >= 32) {
                break;
            }
            bArr2[i3] = (byte) (bArr5[i3] ^ this.k[i3]);
            i3++;
        }
        byte[] j2 = j(bArr2);
        KeyParameter keyParameter = new KeyParameter(j2, 0, j2.length);
        GOST28147Engine gOST28147Engine = this.f5834a;
        gOST28147Engine.a(true, keyParameter);
        byte[] bArr6 = this.i;
        gOST28147Engine.e(0, 0, bArr4, bArr6);
        for (int i4 = 1; i4 < 4; i4++) {
            i(bArr5);
            for (int i5 = 0; i5 < 32; i5++) {
                bArr5[i5] = (byte) (bArr5[i5] ^ this.f5837a[i4][i5]);
            }
            byte[] bArr7 = this.k;
            i(bArr7);
            i(bArr7);
            this.k = bArr7;
            for (int i6 = 0; i6 < 32; i6++) {
                bArr2[i6] = (byte) (bArr5[i6] ^ this.k[i6]);
            }
            byte[] j3 = j(bArr2);
            int i7 = i4 * 8;
            gOST28147Engine.a(true, new KeyParameter(j3, 0, j3.length));
            gOST28147Engine.e(i7, i7, bArr4, bArr6);
        }
        for (int i8 = 0; i8 < 12; i8++) {
            k(bArr6);
        }
        for (int i9 = 0; i9 < 32; i9++) {
            bArr6[i9] = (byte) (bArr6[i9] ^ bArr3[i9]);
        }
        k(bArr6);
        for (int i10 = 0; i10 < 32; i10++) {
            bArr6[i10] = (byte) (bArr4[i10] ^ bArr6[i10]);
        }
        for (int i11 = 0; i11 < 61; i11++) {
            k(bArr6);
        }
        System.arraycopy(bArr6, 0, bArr4, 0, bArr4.length);
    }

    public final void reset() {
        byte[][] bArr;
        this.f5833a = 0;
        this.a = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr2 = this.f5835a;
            if (i2 >= bArr2.length) {
                break;
            }
            bArr2[i2] = 0;
            i2++;
        }
        int i3 = 0;
        while (true) {
            byte[] bArr3 = this.b;
            if (i3 >= bArr3.length) {
                break;
            }
            bArr3[i3] = 0;
            i3++;
        }
        int i4 = 0;
        while (true) {
            byte[] bArr4 = this.c;
            if (i4 >= bArr4.length) {
                break;
            }
            bArr4[i4] = 0;
            i4++;
        }
        int i5 = 0;
        while (true) {
            bArr = this.f5837a;
            byte[] bArr5 = bArr[1];
            if (i5 >= bArr5.length) {
                break;
            }
            bArr5[i5] = 0;
            i5++;
        }
        int i6 = 0;
        while (true) {
            byte[] bArr6 = bArr[3];
            if (i6 >= bArr6.length) {
                break;
            }
            bArr6[i6] = 0;
            i6++;
        }
        int i7 = 0;
        while (true) {
            byte[] bArr7 = this.d;
            if (i7 >= bArr7.length) {
                break;
            }
            bArr7[i7] = 0;
            i7++;
        }
        int i8 = 0;
        while (true) {
            byte[] bArr8 = this.e;
            if (i8 < bArr8.length) {
                bArr8[i8] = 0;
                i8++;
            } else {
                System.arraycopy(m, 0, bArr[2], 0, 32);
                return;
            }
        }
    }

    public final void update(byte[] bArr, int i2, int i3) {
        while (this.a != 0 && i3 > 0) {
            d(bArr[i2]);
            i2++;
            i3--;
        }
        while (true) {
            byte[] bArr2 = this.e;
            if (i3 <= bArr2.length) {
                break;
            }
            System.arraycopy(bArr, i2, bArr2, 0, bArr2.length);
            int i4 = 0;
            int i5 = 0;
            while (true) {
                byte[] bArr3 = this.d;
                if (i4 == bArr3.length) {
                    break;
                }
                int i6 = (bArr3[i4] & UnsignedBytes.MAX_VALUE) + (bArr2[i4] & UnsignedBytes.MAX_VALUE) + i5;
                bArr3[i4] = (byte) i6;
                i5 = i6 >>> 8;
                i4++;
            }
            l(0, bArr2);
            i2 += bArr2.length;
            i3 -= bArr2.length;
            this.f5833a += (long) bArr2.length;
        }
        while (i3 > 0) {
            d(bArr[i2]);
            i2++;
            i3--;
        }
    }

    public GOST3411Digest(byte[] bArr) {
        this.f5835a = new byte[32];
        this.b = new byte[32];
        this.c = new byte[32];
        this.d = new byte[32];
        this.f5837a = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{4, 32});
        this.e = new byte[32];
        GOST28147Engine gOST28147Engine = new GOST28147Engine();
        this.f5834a = gOST28147Engine;
        this.g = new byte[32];
        this.h = new byte[8];
        this.f5836a = new short[16];
        this.f5838b = new short[16];
        this.i = new byte[32];
        this.j = new byte[32];
        this.k = new byte[32];
        this.l = new byte[32];
        byte[] c2 = Arrays.c(bArr);
        this.f = c2;
        gOST28147Engine.a(true, new ParametersWithSBox((CipherParameters) null, c2));
        reset();
    }

    public GOST3411Digest(GOST3411Digest gOST3411Digest) {
        this.f5835a = new byte[32];
        this.b = new byte[32];
        this.c = new byte[32];
        this.d = new byte[32];
        this.f5837a = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{4, 32});
        this.e = new byte[32];
        this.f5834a = new GOST28147Engine();
        this.g = new byte[32];
        this.h = new byte[8];
        this.f5836a = new short[16];
        this.f5838b = new short[16];
        this.i = new byte[32];
        this.j = new byte[32];
        this.k = new byte[32];
        this.l = new byte[32];
        e(gOST3411Digest);
    }
}
