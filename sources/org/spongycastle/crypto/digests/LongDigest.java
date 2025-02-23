package org.spongycastle.crypto.digests;

import com.google.common.primitives.UnsignedBytes;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.util.Memoable;
import org.spongycastle.util.Pack;

public abstract class LongDigest implements ExtendedDigest, Memoable, EncodableDigest {
    public static final long[] b = {4794697086780616226L, 8158064640168781261L, -5349999486874862801L, -1606136188198331460L, 4131703408338449720L, 6480981068601479193L, -7908458776815382629L, -6116909921290321640L, -2880145864133508542L, 1334009975649890238L, 2608012711638119052L, 6128411473006802146L, 8268148722764581231L, -9160688886553864527L, -7215885187991268811L, -4495734319001033068L, -1973867731355612462L, -1171420211273849373L, 1135362057144423861L, 2597628984639134821L, 3308224258029322869L, 5365058923640841347L, 6679025012923562964L, 8573033837759648693L, -7476448914759557205L, -6327057829258317296L, -5763719355590565569L, -4658551843659510044L, -4116276920077217854L, -3051310485924567259L, 489312712824947311L, 1452737877330783856L, 2861767655752347644L, 3322285676063803686L, 5560940570517711597L, 5996557281743188959L, 7280758554555802590L, 8532644243296465576L, -9096487096722542874L, -7894198246740708037L, -6719396339535248540L, -6333637450476146687L, -4446306890439682159L, -4076793802049405392L, -3345356375505022440L, -2983346525034927856L, -860691631967231958L, 1182934255886127544L, 1847814050463011016L, 2177327727835720531L, 2830643537854262169L, 3796741975233480872L, 4115178125766777443L, 5681478168544905931L, 6601373596472566643L, 7507060721942968483L, 8399075790359081724L, 8693463985226723168L, -8878714635349349518L, -8302665154208450068L, -8016688836872298968L, -6606660893046293015L, -4685533653050689259L, -4147400797238176981L, -3880063495543823972L, -3348786107499101689L, -1523767162380948706L, -757361751448694408L, 500013540394364858L, 748580250866718886L, 1242879168328830382L, 1977374033974150939L, 2944078676154940804L, 3659926193048069267L, 4368137639120453308L, 4836135668995329356L, 5532061633213252278L, 6448918945643986474L, 6902733635092675308L, 7801388544844847127L};
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public long f5849a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f5850a;

    /* renamed from: a  reason: collision with other field name */
    public final long[] f5851a;

    /* renamed from: b  reason: collision with other field name */
    public int f5852b;

    /* renamed from: b  reason: collision with other field name */
    public long f5853b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public long i;
    public long j;

    public LongDigest() {
        this.f5850a = new byte[8];
        this.f5851a = new long[80];
        this.a = 0;
        reset();
    }

    public static long i(long j2, long j3, long j4) {
        return ((j2 & j4) ^ (j2 & j3)) ^ (j3 & j4);
    }

    public static long j(long j2) {
        return ((j2 >>> 39) | (j2 << 25)) ^ (((j2 << 36) | (j2 >>> 28)) ^ ((j2 << 30) | (j2 >>> 34)));
    }

    public static long k(long j2) {
        return ((j2 >>> 41) | (j2 << 23)) ^ (((j2 << 50) | (j2 >>> 14)) ^ ((j2 << 46) | (j2 >>> 18)));
    }

    public final void d(byte b2) {
        int i2 = this.a;
        int i3 = i2 + 1;
        this.a = i3;
        byte[] bArr = this.f5850a;
        bArr[i2] = b2;
        if (i3 == bArr.length) {
            this.f5851a[this.f5852b] = (((long) Pack.a(4, bArr)) & 4294967295L) | ((((long) Pack.a(0, bArr)) & 4294967295L) << 32);
            int i4 = this.f5852b + 1;
            this.f5852b = i4;
            if (i4 == 16) {
                n();
            }
            this.a = 0;
        }
        this.f5849a++;
    }

    public final int h() {
        return 128;
    }

    public final void l(LongDigest longDigest) {
        byte[] bArr = longDigest.f5850a;
        System.arraycopy(bArr, 0, this.f5850a, 0, bArr.length);
        this.a = longDigest.a;
        this.f5849a = longDigest.f5849a;
        this.f5853b = longDigest.f5853b;
        this.c = longDigest.c;
        this.d = longDigest.d;
        this.e = longDigest.e;
        this.f = longDigest.f;
        this.g = longDigest.g;
        this.h = longDigest.h;
        this.i = longDigest.i;
        this.j = longDigest.j;
        long[] jArr = this.f5851a;
        long[] jArr2 = longDigest.f5851a;
        System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
        this.f5852b = longDigest.f5852b;
    }

    public final void m() {
        long j2 = this.f5849a;
        if (j2 > 2305843009213693951L) {
            this.f5853b += j2 >>> 61;
            this.f5849a = j2 & 2305843009213693951L;
        }
        long j3 = this.f5849a << 3;
        long j4 = this.f5853b;
        d(UnsignedBytes.MAX_POWER_OF_TWO);
        while (this.a != 0) {
            d((byte) 0);
        }
        if (this.f5852b > 14) {
            n();
        }
        long[] jArr = this.f5851a;
        jArr[14] = j4;
        jArr[15] = j3;
        n();
    }

    public final void n() {
        long[] jArr;
        long j2 = this.f5849a;
        if (j2 > 2305843009213693951L) {
            this.f5853b += j2 >>> 61;
            this.f5849a = j2 & 2305843009213693951L;
        }
        int i2 = 16;
        while (true) {
            jArr = this.f5851a;
            if (i2 > 79) {
                break;
            }
            long j3 = jArr[i2 - 2];
            long j4 = ((j3 >>> 6) ^ (((j3 << 45) | (j3 >>> 19)) ^ ((j3 << 3) | (j3 >>> 61)))) + jArr[i2 - 7];
            long j5 = jArr[i2 - 15];
            jArr[i2] = j4 + ((j5 >>> 7) ^ (((j5 << 63) | (j5 >>> 1)) ^ ((j5 << 56) | (j5 >>> 8)))) + jArr[i2 - 16];
            i2++;
        }
        long j6 = this.c;
        long j7 = this.d;
        long j8 = this.e;
        long j9 = this.f;
        long j10 = this.g;
        long j11 = this.h;
        long j12 = j6;
        long j13 = this.i;
        long j14 = j11;
        long j15 = j7;
        long j16 = this.j;
        long j17 = j13;
        long j18 = j8;
        int i3 = 0;
        int i4 = 0;
        while (i3 < 10) {
            long[] jArr2 = jArr;
            long k = k(j10) + (((~j10) & j17) ^ (j14 & j10));
            long[] jArr3 = b;
            int i5 = i4 + 1;
            long j19 = k + jArr3[i4] + jArr2[i4] + j16;
            long j20 = j9 + j19;
            int i6 = i3;
            long j21 = j10;
            long j22 = j(j12) + i(j12, j15, j18) + j19;
            int i7 = i5 + 1;
            long k2 = j17 + k(j20) + ((j21 & j20) ^ ((~j20) & j14)) + jArr3[i5] + jArr2[i5];
            long j23 = j18 + k2;
            long j24 = j(j22) + i(j22, j12, j15) + k2;
            long j25 = j23;
            int i8 = i7 + 1;
            long k3 = k(j23) + ((j20 & j25) ^ ((~j25) & j21)) + jArr3[i7] + jArr2[i7] + j14;
            long j26 = j15 + k3;
            long j27 = j25;
            long j28 = j(j24) + i(j24, j22, j12) + k3;
            int i9 = i8 + 1;
            long k4 = k(j26) + ((j27 & j26) ^ ((~j26) & j20)) + jArr3[i8] + jArr2[i8] + j21;
            long j29 = j12 + k4;
            long j30 = j(j28) + i(j28, j24, j22) + k4;
            long j31 = j29;
            int i10 = i9 + 1;
            long k5 = k(j29) + ((j26 & j31) ^ ((~j31) & j27)) + jArr3[i9] + jArr2[i9] + j20;
            long j32 = j22 + k5;
            long j33 = j(j30) + i(j30, j28, j24) + k5;
            int i11 = i10 + 1;
            long k6 = k(j32) + ((j29 & j32) ^ ((~j32) & j26)) + jArr3[i10] + jArr2[i10] + j27;
            long j34 = j24 + k6;
            j18 = j(j33) + i(j33, j30, j28) + k6;
            long j35 = j34;
            long j36 = j32;
            int i12 = i11 + 1;
            long k7 = k(j34) + (((~j35) & j29) ^ (j32 & j35)) + jArr3[i11] + jArr2[i11] + j26;
            long j37 = j28 + k7;
            long j38 = j35;
            long j39 = j(j18) + i(j18, j33, j30) + k7;
            long k8 = k(j37) + ((j38 & j37) ^ ((~j37) & j36)) + jArr3[i12] + jArr2[i12] + j29;
            long j40 = j30 + k8;
            long j41 = j(j39) + i(j39, j18, j33) + k8;
            j9 = j33;
            j14 = j37;
            j10 = j40;
            j17 = j38;
            j15 = j39;
            j12 = j41;
            j16 = j36;
            i4 = i12 + 1;
            i3 = i6 + 1;
            jArr = jArr2;
        }
        long[] jArr4 = jArr;
        this.c += j12;
        this.d += j15;
        this.e += j18;
        this.f += j9;
        this.g += j10;
        this.h += j14;
        this.i += j17;
        this.j += j16;
        this.f5852b = 0;
        for (int i13 = 0; i13 < 16; i13++) {
            jArr4[i13] = 0;
        }
    }

    public void reset() {
        this.f5849a = 0;
        this.f5853b = 0;
        int i2 = 0;
        this.a = 0;
        int i3 = 0;
        while (true) {
            byte[] bArr = this.f5850a;
            if (i3 >= bArr.length) {
                break;
            }
            bArr[i3] = 0;
            i3++;
        }
        this.f5852b = 0;
        while (true) {
            long[] jArr = this.f5851a;
            if (i2 != jArr.length) {
                jArr[i2] = 0;
                i2++;
            } else {
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
            byte[] bArr2 = this.f5850a;
            if (i3 <= bArr2.length) {
                break;
            }
            this.f5851a[this.f5852b] = (((long) Pack.a(i2 + 4, bArr)) & 4294967295L) | ((((long) Pack.a(i2, bArr)) & 4294967295L) << 32);
            int i4 = this.f5852b + 1;
            this.f5852b = i4;
            if (i4 == 16) {
                n();
            }
            i2 += bArr2.length;
            i3 -= bArr2.length;
            this.f5849a += (long) bArr2.length;
        }
        while (i3 > 0) {
            d(bArr[i2]);
            i2++;
            i3--;
        }
    }

    public LongDigest(LongDigest longDigest) {
        this.f5850a = new byte[8];
        this.f5851a = new long[80];
        l(longDigest);
    }
}
