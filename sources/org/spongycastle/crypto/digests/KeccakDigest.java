package org.spongycastle.crypto.digests;

import com.google.common.primitives.UnsignedBytes;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;

public class KeccakDigest implements ExtendedDigest {
    public static final int[] a;
    public static final long[] b;

    /* renamed from: a  reason: collision with other field name */
    public int f5844a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5845a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f5846a;

    /* renamed from: a  reason: collision with other field name */
    public final long[] f5847a;

    /* renamed from: b  reason: collision with other field name */
    public int f5848b;
    public int c;

    static {
        boolean z;
        long[] jArr = new long[24];
        int i = 1;
        int i2 = 0;
        byte[] bArr = {1};
        for (int i3 = 0; i3 < 24; i3++) {
            jArr[i3] = 0;
            for (int i4 = 0; i4 < 7; i4++) {
                int i5 = (1 << i4) - 1;
                byte b2 = bArr[0];
                if ((b2 & 1) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                byte b3 = b2 & UnsignedBytes.MAX_POWER_OF_TWO;
                int i6 = b2 << 1;
                if (b3 != 0) {
                    bArr[0] = (byte) (i6 ^ 113);
                } else {
                    bArr[0] = (byte) i6;
                }
                if (z) {
                    jArr[i3] = jArr[i3] ^ (1 << i5);
                }
            }
        }
        b = jArr;
        int[] iArr = new int[25];
        iArr[0] = 0;
        int i7 = 0;
        while (i2 < 24) {
            int i8 = i2 + 1;
            iArr[((i7 % 5) * 5) + (i % 5)] = (((i2 + 2) * i8) / 2) % 64;
            int i9 = i7 * 1;
            i7 = ((i7 * 3) + (i * 2)) % 5;
            i = (i9 + (i * 0)) % 5;
            i2 = i8;
        }
        a = iArr;
    }

    public KeccakDigest() {
        this(288);
    }

    public static long l(int i, long j) {
        return (j >>> (-i)) | (j << i);
    }

    public final void a(int i, byte[] bArr) {
        int i2 = this.f5844a >> 6;
        for (int i3 = 0; i3 < i2; i3++) {
            long[] jArr = this.f5847a;
            jArr[i3] = jArr[i3] ^ Pack.h(i, bArr);
            i += 8;
        }
        e();
    }

    public String b() {
        return "Keccak-" + this.c;
    }

    public int c(int i, byte[] bArr) {
        m((long) this.c, bArr, i);
        reset();
        return this.c / 8;
    }

    public final void d(byte b2) {
        i(0, new byte[]{b2}, 1);
    }

    public final void e() {
        int i = 0;
        int i2 = 0;
        while (i2 < 24) {
            long[] jArr = this.f5847a;
            long j = (((jArr[i] ^ jArr[5]) ^ jArr[10]) ^ jArr[15]) ^ jArr[20];
            long j2 = (((jArr[1] ^ jArr[6]) ^ jArr[11]) ^ jArr[16]) ^ jArr[21];
            long j3 = (((jArr[2] ^ jArr[7]) ^ jArr[12]) ^ jArr[17]) ^ jArr[22];
            long j4 = (((jArr[3] ^ jArr[8]) ^ jArr[13]) ^ jArr[18]) ^ jArr[23];
            long j5 = (((jArr[4] ^ jArr[9]) ^ jArr[14]) ^ jArr[19]) ^ jArr[24];
            long l = l(1, j2) ^ j5;
            jArr[i] = jArr[i] ^ l;
            jArr[5] = jArr[5] ^ l;
            jArr[10] = jArr[10] ^ l;
            jArr[15] = jArr[15] ^ l;
            jArr[20] = jArr[20] ^ l;
            long l2 = l(1, j3) ^ j;
            jArr[1] = jArr[1] ^ l2;
            jArr[6] = jArr[6] ^ l2;
            jArr[11] = jArr[11] ^ l2;
            jArr[16] = jArr[16] ^ l2;
            jArr[21] = l2 ^ jArr[21];
            long l3 = l(1, j4) ^ j2;
            jArr[2] = jArr[2] ^ l3;
            jArr[7] = jArr[7] ^ l3;
            jArr[12] = jArr[12] ^ l3;
            jArr[17] = jArr[17] ^ l3;
            jArr[22] = l3 ^ jArr[22];
            long l4 = l(1, j5) ^ j3;
            jArr[3] = jArr[3] ^ l4;
            jArr[8] = jArr[8] ^ l4;
            jArr[13] = jArr[13] ^ l4;
            jArr[18] = jArr[18] ^ l4;
            jArr[23] = l4 ^ jArr[23];
            long l5 = l(1, j) ^ j4;
            jArr[4] = jArr[4] ^ l5;
            jArr[9] = jArr[9] ^ l5;
            jArr[14] = jArr[14] ^ l5;
            jArr[19] = jArr[19] ^ l5;
            jArr[24] = l5 ^ jArr[24];
            for (int i3 = 1; i3 < 25; i3++) {
                jArr[i3] = l(a[i3], jArr[i3]);
            }
            long j6 = jArr[1];
            jArr[1] = jArr[6];
            jArr[6] = jArr[9];
            jArr[9] = jArr[22];
            jArr[22] = jArr[14];
            jArr[14] = jArr[20];
            jArr[20] = jArr[2];
            jArr[2] = jArr[12];
            jArr[12] = jArr[13];
            jArr[13] = jArr[19];
            jArr[19] = jArr[23];
            jArr[23] = jArr[15];
            jArr[15] = jArr[4];
            jArr[4] = jArr[24];
            jArr[24] = jArr[21];
            jArr[21] = jArr[8];
            jArr[8] = jArr[16];
            jArr[16] = jArr[5];
            jArr[5] = jArr[3];
            jArr[3] = jArr[18];
            jArr[18] = jArr[17];
            jArr[17] = jArr[11];
            jArr[11] = jArr[7];
            jArr[7] = jArr[10];
            jArr[10] = j6;
            int i4 = i;
            while (i4 < 25) {
                int i5 = i4 + 0;
                long j7 = jArr[i5];
                int i6 = i4 + 1;
                long j8 = jArr[i6];
                long j9 = ~j8;
                int i7 = i4 + 2;
                long j10 = jArr[i7];
                long j11 = ~j10;
                int i8 = i4 + 3;
                long j12 = (j9 & j10) ^ j7;
                long j13 = jArr[i8];
                long j14 = (j11 & j13) ^ j8;
                long j15 = ~j13;
                int i9 = i4 + 4;
                int i10 = i4;
                long j16 = jArr[i9];
                jArr[i5] = j12;
                jArr[i6] = j14;
                jArr[i7] = (j15 & j16) ^ j10;
                jArr[i8] = j13 ^ ((~j16) & j7);
                jArr[i9] = j16 ^ ((~j7) & j8);
                i4 = i10 + 5;
                i2 = i2;
            }
            int i11 = i2;
            i = 0;
            jArr[0] = jArr[0] ^ b[i11];
            i2 = i11 + 1;
        }
    }

    public final int f() {
        return this.c / 8;
    }

    public final int h() {
        return this.f5844a / 8;
    }

    public final void i(int i, byte[] bArr, int i2) {
        int i3;
        int i4 = this.f5848b;
        if (i4 % 8 != 0) {
            throw new IllegalStateException("attempt to absorb with odd length queue");
        } else if (!this.f5845a) {
            int i5 = i4 >> 3;
            int i6 = this.f5844a >> 3;
            int i7 = 0;
            while (i7 < i2) {
                if (i5 != 0 || i7 > (i3 = i2 - i6)) {
                    int min = Math.min(i6 - i5, i2 - i7);
                    byte[] bArr2 = this.f5846a;
                    System.arraycopy(bArr, i + i7, bArr2, i5, min);
                    i5 += min;
                    i7 += min;
                    if (i5 == i6) {
                        a(0, bArr2);
                        i5 = 0;
                    }
                } else {
                    do {
                        a(i + i7, bArr);
                        i7 += i6;
                    } while (i7 <= i3);
                }
            }
            this.f5848b = i5 << 3;
        } else {
            throw new IllegalStateException("attempt to absorb while squeezing");
        }
    }

    public final void j(int i, int i2) {
        if (i2 < 1 || i2 > 7) {
            throw new IllegalArgumentException("'bits' must be in the range 1 to 7");
        }
        int i3 = this.f5848b;
        if (i3 % 8 != 0) {
            throw new IllegalStateException("attempt to absorb with odd length queue");
        } else if (!this.f5845a) {
            this.f5846a[i3 >> 3] = (byte) (i & ((1 << i2) - 1));
            this.f5848b = i3 + i2;
        } else {
            throw new IllegalStateException("attempt to absorb while squeezing");
        }
    }

    public final void k(int i) {
        if (i == 128 || i == 224 || i == 256 || i == 288 || i == 384 || i == 512) {
            int i2 = 1600 - (i << 1);
            if (i2 <= 0 || i2 >= 1600 || i2 % 64 != 0) {
                throw new IllegalStateException("invalid rate value");
            }
            this.f5844a = i2;
            int i3 = 0;
            while (true) {
                long[] jArr = this.f5847a;
                if (i3 < jArr.length) {
                    jArr[i3] = 0;
                    i3++;
                } else {
                    Arrays.p(this.f5846a, (byte) 0);
                    this.f5848b = 0;
                    this.f5845a = false;
                    this.c = (1600 - i2) / 2;
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("bitLength must be one of 128, 224, 256, 288, 384, or 512.");
        }
    }

    public final void m(long j, byte[] bArr, int i) {
        boolean z = this.f5845a;
        long[] jArr = this.f5847a;
        byte[] bArr2 = this.f5846a;
        if (!z) {
            int i2 = this.f5848b;
            int i3 = i2 >> 3;
            bArr2[i3] = (byte) (bArr2[i3] | ((byte) ((int) (1 << (i2 & 7)))));
            int i4 = i2 + 1;
            this.f5848b = i4;
            if (i4 == this.f5844a) {
                a(0, bArr2);
                this.f5848b = 0;
            }
            int i5 = this.f5848b;
            int i6 = i5 >> 6;
            int i7 = i5 & 63;
            int i8 = 0;
            for (int i9 = 0; i9 < i6; i9++) {
                jArr[i9] = jArr[i9] ^ Pack.h(i8, bArr2);
                i8 += 8;
            }
            if (i7 > 0) {
                jArr[i6] = jArr[i6] ^ (Pack.h(i8, bArr2) & ((1 << i7) - 1));
            }
            int i10 = (this.f5844a - 1) >> 6;
            jArr[i10] = jArr[i10] ^ Long.MIN_VALUE;
            e();
            int i11 = this.f5844a >> 6;
            int i12 = 0;
            for (int i13 = 0; i13 < i11; i13++) {
                Pack.l(jArr[0 + i13], bArr2, i12);
                i12 += 8;
            }
            this.f5848b = this.f5844a;
            this.f5845a = true;
        }
        long j2 = 0;
        if (j % 8 == 0) {
            while (j2 < j) {
                if (this.f5848b == 0) {
                    e();
                    int i14 = this.f5844a >> 6;
                    int i15 = 0;
                    for (int i16 = 0; i16 < i14; i16++) {
                        Pack.l(jArr[0 + i16], bArr2, i15);
                        i15 += 8;
                    }
                    this.f5848b = this.f5844a;
                }
                int min = (int) Math.min((long) this.f5848b, j - j2);
                System.arraycopy(bArr2, (this.f5844a - this.f5848b) / 8, bArr, i + ((int) (j2 / 8)), min / 8);
                this.f5848b -= min;
                j2 += (long) min;
            }
            return;
        }
        throw new IllegalStateException("outputLength not a multiple of 8");
    }

    public final void reset() {
        k(this.c);
    }

    public final void update(byte[] bArr, int i, int i2) {
        i(i, bArr, i2);
    }

    public KeccakDigest(int i) {
        this.f5847a = new long[25];
        this.f5846a = new byte[192];
        k(i);
    }

    public KeccakDigest(KeccakDigest keccakDigest) {
        long[] jArr = new long[25];
        this.f5847a = jArr;
        byte[] bArr = new byte[192];
        this.f5846a = bArr;
        long[] jArr2 = keccakDigest.f5847a;
        System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
        byte[] bArr2 = keccakDigest.f5846a;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        this.f5844a = keccakDigest.f5844a;
        this.f5848b = keccakDigest.f5848b;
        this.c = keccakDigest.c;
        this.f5845a = keccakDigest.f5845a;
    }
}
