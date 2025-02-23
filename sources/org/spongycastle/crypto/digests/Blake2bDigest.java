package org.spongycastle.crypto.digests;

import com.google.android.gms.ads.AdRequest;
import com.google.common.base.Ascii;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.util.Arrays;

public class Blake2bDigest implements ExtendedDigest {
    public static final byte[][] a = {new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Ascii.VT, Ascii.FF, Ascii.CR, Ascii.SO, Ascii.SI}, new byte[]{Ascii.SO, 10, 4, 8, 9, Ascii.SI, Ascii.CR, 6, 1, Ascii.FF, 0, 2, Ascii.VT, 7, 5, 3}, new byte[]{Ascii.VT, 8, Ascii.FF, 0, 5, 2, Ascii.SI, Ascii.CR, 10, Ascii.SO, 3, 6, 7, 1, 9, 4}, new byte[]{7, 9, 3, 1, Ascii.CR, Ascii.FF, Ascii.VT, Ascii.SO, 2, 6, 5, 10, 4, 0, Ascii.SI, 8}, new byte[]{9, 0, 5, 7, 2, 4, 10, Ascii.SI, Ascii.SO, 1, Ascii.VT, Ascii.FF, 6, 8, 3, Ascii.CR}, new byte[]{2, Ascii.FF, 6, 10, 0, Ascii.VT, 8, 3, 4, Ascii.CR, 7, 5, Ascii.SI, Ascii.SO, 1, 9}, new byte[]{Ascii.FF, 5, 1, Ascii.SI, Ascii.SO, Ascii.CR, 4, 10, 0, 7, 6, 3, 9, 2, 8, Ascii.VT}, new byte[]{Ascii.CR, Ascii.VT, 7, Ascii.SO, Ascii.FF, 1, 3, 9, 5, 0, Ascii.SI, 4, 8, 6, 2, 10}, new byte[]{6, Ascii.SI, Ascii.SO, 9, Ascii.VT, 3, 0, 8, Ascii.FF, 2, Ascii.CR, 7, 1, 4, 10, 5}, new byte[]{10, 2, 8, 4, 7, 6, 1, 5, Ascii.SI, Ascii.VT, 9, Ascii.SO, 3, Ascii.FF, Ascii.CR, 0}, new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Ascii.VT, Ascii.FF, Ascii.CR, Ascii.SO, Ascii.SI}, new byte[]{Ascii.SO, 10, 4, 8, 9, Ascii.SI, Ascii.CR, 6, 1, Ascii.FF, 0, 2, Ascii.VT, 7, 5, 3}};
    public static final long[] c = {7640891576956012808L, -4942790177534073029L, 4354685564936845355L, -6534734903238641935L, 5840696475078001361L, -7276294671716946913L, 2270897969802886507L, 6620516959819538809L};

    /* renamed from: a  reason: collision with other field name */
    public final int f5812a;

    /* renamed from: a  reason: collision with other field name */
    public long f5813a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f5814a;

    /* renamed from: a  reason: collision with other field name */
    public final long[] f5815a;
    public final int b;

    /* renamed from: b  reason: collision with other field name */
    public long f5816b;

    /* renamed from: b  reason: collision with other field name */
    public final byte[] f5817b;

    /* renamed from: b  reason: collision with other field name */
    public long[] f5818b;

    /* renamed from: c  reason: collision with other field name */
    public int f5819c;

    /* renamed from: c  reason: collision with other field name */
    public long f5820c;

    /* renamed from: c  reason: collision with other field name */
    public final byte[] f5821c;
    public final byte[] d;

    public Blake2bDigest() {
        this((int) AdRequest.MAX_CONTENT_URL_LENGTH);
    }

    public static long e(int i, byte[] bArr) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public final void a(long j, long j2, int i, int i2, int i3, int i4) {
        long[] jArr = this.f5815a;
        long j3 = jArr[i] + jArr[i2] + j;
        jArr[i] = j3;
        long j4 = jArr[i4] ^ j3;
        long j5 = (j4 << 32) | (j4 >>> 32);
        jArr[i4] = j5;
        long j6 = jArr[i3] + j5;
        jArr[i3] = j6;
        long j7 = jArr[i2] ^ j6;
        long j8 = (j7 << 40) | (j7 >>> 24);
        jArr[i2] = j8;
        long j9 = jArr[i] + j8 + j2;
        jArr[i] = j9;
        long j10 = jArr[i4] ^ j9;
        long j11 = (j10 << 48) | (j10 >>> 16);
        jArr[i4] = j11;
        long j12 = jArr[i3] + j11;
        jArr[i3] = j12;
        long j13 = jArr[i2] ^ j12;
        jArr[i2] = (j13 << 1) | (j13 >>> 63);
    }

    public final String b() {
        return "Blake2b";
    }

    public final int c(int i, byte[] bArr) {
        long[] jArr;
        int i2;
        int i3;
        this.f5820c = -1;
        long j = this.f5813a;
        long j2 = (long) this.f5819c;
        long j3 = j + j2;
        this.f5813a = j3;
        if (j3 < 0 && j2 > (-j3)) {
            this.f5816b++;
        }
        byte[] bArr2 = this.d;
        i(0, bArr2);
        Arrays.p(bArr2, (byte) 0);
        Arrays.q(this.f5815a);
        int i4 = 0;
        while (true) {
            jArr = this.f5818b;
            int length = jArr.length;
            i2 = this.f5812a;
            if (i4 >= length || (i3 = i4 * 8) >= i2) {
                Arrays.q(jArr);
                reset();
            } else {
                long j4 = jArr[i4];
                byte[] bArr3 = {(byte) ((int) j4), (byte) ((int) (j4 >> 8)), (byte) ((int) (j4 >> 16)), (byte) ((int) (j4 >> 24)), (byte) ((int) (j4 >> 32)), (byte) ((int) (j4 >> 40)), (byte) ((int) (j4 >> 48)), (byte) ((int) (j4 >> 56))};
                if (i3 < i2 - 8) {
                    System.arraycopy(bArr3, 0, bArr, i3 + i, 8);
                } else {
                    System.arraycopy(bArr3, 0, bArr, i + i3, i2 - i3);
                }
                i4++;
            }
        }
        Arrays.q(jArr);
        reset();
        return i2;
    }

    public final void d(byte b2) {
        int i = this.f5819c;
        int i2 = 128 - i;
        byte[] bArr = this.d;
        if (i2 == 0) {
            long j = this.f5813a + 128;
            this.f5813a = j;
            if (j == 0) {
                this.f5816b++;
            }
            i(0, bArr);
            Arrays.p(bArr, (byte) 0);
            bArr[0] = b2;
            this.f5819c = 1;
            return;
        }
        bArr[i] = b2;
        this.f5819c = i + 1;
    }

    public final int f() {
        return this.f5812a;
    }

    public final int h() {
        return 128;
    }

    public final void i(int i, byte[] bArr) {
        long[] jArr = this.f5818b;
        int length = jArr.length;
        int i2 = 0;
        long[] jArr2 = this.f5815a;
        System.arraycopy(jArr, 0, jArr2, 0, length);
        long[] jArr3 = c;
        System.arraycopy(jArr3, 0, jArr2, this.f5818b.length, 4);
        jArr2[12] = this.f5813a ^ jArr3[4];
        jArr2[13] = this.f5816b ^ jArr3[5];
        jArr2[14] = this.f5820c ^ jArr3[6];
        jArr2[15] = jArr3[7];
        long[] jArr4 = new long[16];
        for (int i3 = 0; i3 < 16; i3++) {
            jArr4[i3] = e((i3 * 8) + i, bArr);
        }
        int i4 = 0;
        while (i4 < 12) {
            byte[][] bArr2 = a;
            byte[] bArr3 = bArr2[i4];
            int i5 = i4;
            long[] jArr5 = jArr4;
            a(jArr4[bArr3[0]], jArr4[bArr3[1]], 0, 4, 8, 12);
            byte[] bArr4 = bArr2[i5];
            a(jArr5[bArr4[2]], jArr5[bArr4[3]], 1, 5, 9, 13);
            byte[] bArr5 = bArr2[i5];
            a(jArr5[bArr5[4]], jArr5[bArr5[5]], 2, 6, 10, 14);
            byte[] bArr6 = bArr2[i5];
            a(jArr5[bArr6[6]], jArr5[bArr6[7]], 3, 7, 11, 15);
            byte[] bArr7 = bArr2[i5];
            a(jArr5[bArr7[8]], jArr5[bArr7[9]], 0, 5, 10, 15);
            byte[] bArr8 = bArr2[i5];
            a(jArr5[bArr8[10]], jArr5[bArr8[11]], 1, 6, 11, 12);
            byte[] bArr9 = bArr2[i5];
            a(jArr5[bArr9[12]], jArr5[bArr9[13]], 2, 7, 8, 13);
            byte[] bArr10 = bArr2[i5];
            a(jArr5[bArr10[14]], jArr5[bArr10[15]], 3, 4, 9, 14);
            i4 = i5 + 1;
            jArr4 = jArr5;
        }
        while (true) {
            long[] jArr6 = this.f5818b;
            if (i2 < jArr6.length) {
                jArr6[i2] = (jArr6[i2] ^ jArr2[i2]) ^ jArr2[i2 + 8];
                i2++;
            } else {
                return;
            }
        }
    }

    public final void j() {
        if (this.f5818b == null) {
            long[] jArr = new long[8];
            this.f5818b = jArr;
            long[] jArr2 = c;
            jArr[0] = jArr2[0] ^ ((long) (((this.b << 8) | this.f5812a) | 16842752));
            jArr[1] = jArr2[1];
            jArr[2] = jArr2[2];
            jArr[3] = jArr2[3];
            long j = jArr2[4];
            jArr[4] = j;
            jArr[5] = jArr2[5];
            byte[] bArr = this.f5814a;
            if (bArr != null) {
                jArr[4] = j ^ e(0, bArr);
                long[] jArr3 = this.f5818b;
                jArr3[5] = jArr3[5] ^ e(8, bArr);
            }
            long[] jArr4 = this.f5818b;
            long j2 = jArr2[6];
            jArr4[6] = j2;
            jArr4[7] = jArr2[7];
            byte[] bArr2 = this.f5817b;
            if (bArr2 != null) {
                jArr4[6] = j2 ^ e(0, bArr2);
                long[] jArr5 = this.f5818b;
                jArr5[7] = jArr5[7] ^ e(8, bArr2);
            }
        }
    }

    public final void reset() {
        this.f5819c = 0;
        this.f5820c = 0;
        this.f5813a = 0;
        this.f5816b = 0;
        this.f5818b = null;
        byte[] bArr = this.d;
        Arrays.p(bArr, (byte) 0);
        byte[] bArr2 = this.f5821c;
        if (bArr2 != null) {
            System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
            this.f5819c = 128;
        }
        j();
    }

    public final void update(byte[] bArr, int i, int i2) {
        int i3;
        if (bArr != null && i2 != 0) {
            int i4 = this.f5819c;
            byte[] bArr2 = this.d;
            if (i4 != 0) {
                i3 = 128 - i4;
                if (i3 < i2) {
                    System.arraycopy(bArr, i, bArr2, i4, i3);
                    long j = this.f5813a + 128;
                    this.f5813a = j;
                    if (j == 0) {
                        this.f5816b++;
                    }
                    i(0, bArr2);
                    this.f5819c = 0;
                    Arrays.p(bArr2, (byte) 0);
                } else {
                    System.arraycopy(bArr, i, bArr2, i4, i2);
                    this.f5819c += i2;
                    return;
                }
            } else {
                i3 = 0;
            }
            int i5 = i2 + i;
            int i6 = i5 - 128;
            int i7 = i + i3;
            while (i7 < i6) {
                long j2 = this.f5813a + 128;
                this.f5813a = j2;
                if (j2 == 0) {
                    this.f5816b++;
                }
                i(i7, bArr);
                i7 += 128;
            }
            int i8 = i5 - i7;
            System.arraycopy(bArr, i7, bArr2, 0, i8);
            this.f5819c += i8;
        }
    }

    public Blake2bDigest(Blake2bDigest blake2bDigest) {
        this.f5812a = 64;
        this.b = 0;
        this.f5814a = null;
        this.f5817b = null;
        this.f5821c = null;
        this.d = null;
        this.f5819c = 0;
        this.f5815a = new long[16];
        this.f5818b = null;
        this.f5813a = 0;
        this.f5816b = 0;
        this.f5820c = 0;
        this.f5819c = blake2bDigest.f5819c;
        this.d = Arrays.c(blake2bDigest.d);
        this.b = blake2bDigest.b;
        this.f5821c = Arrays.c(blake2bDigest.f5821c);
        this.f5812a = blake2bDigest.f5812a;
        this.f5818b = Arrays.e(blake2bDigest.f5818b);
        this.f5817b = Arrays.c(blake2bDigest.f5817b);
        this.f5814a = Arrays.c(blake2bDigest.f5814a);
        this.f5813a = blake2bDigest.f5813a;
        this.f5816b = blake2bDigest.f5816b;
        this.f5820c = blake2bDigest.f5820c;
    }

    public Blake2bDigest(int i) {
        this.f5812a = 64;
        this.b = 0;
        this.f5814a = null;
        this.f5817b = null;
        this.f5821c = null;
        this.d = null;
        this.f5819c = 0;
        this.f5815a = new long[16];
        this.f5818b = null;
        this.f5813a = 0;
        this.f5816b = 0;
        this.f5820c = 0;
        if (i == 160 || i == 256 || i == 384 || i == 512) {
            this.d = new byte[128];
            this.b = 0;
            this.f5812a = i / 8;
            j();
            return;
        }
        throw new IllegalArgumentException("Blake2b digest restricted to one of [160, 256, 384, 512]");
    }
}
