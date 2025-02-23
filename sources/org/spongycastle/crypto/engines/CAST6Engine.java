package org.spongycastle.crypto.engines;

public final class CAST6Engine extends CAST5Engine {
    public final int[] k = new int[48];
    public final int[] l = new int[48];
    public final int[] m = new int[192];
    public final int[] n = new int[192];
    public final int[] o = new int[8];

    public final String b() {
        return "CAST6";
    }

    public final int c() {
        return 16;
    }

    public final int l(int i, int i2, byte[] bArr, byte[] bArr2) {
        int i3;
        int[] iArr;
        int[] iArr2;
        int i4 = i;
        int i5 = i2;
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        int i6 = 4;
        int[] iArr3 = new int[4];
        int g = g(i4, bArr3);
        int g2 = g(i4 + 4, bArr3);
        int g3 = g(i4 + 8, bArr3);
        int g4 = g(i4 + 12, bArr3);
        int i7 = 0;
        while (true) {
            iArr = this.k;
            iArr2 = this.l;
            if (i7 >= 6) {
                break;
            }
            int i8 = (11 - i7) * i6;
            g3 ^= CAST5Engine.h(g4, iArr2[i8], iArr[i8]);
            int i9 = i8 + 1;
            g2 ^= CAST5Engine.i(g3, iArr2[i9], iArr[i9]);
            int i10 = i8 + 2;
            g ^= CAST5Engine.j(g2, iArr2[i10], iArr[i10]);
            int i11 = i8 + 3;
            g4 ^= CAST5Engine.h(g, iArr2[i11], iArr[i11]);
            i7++;
            i6 = 4;
        }
        for (i3 = 6; i3 < 12; i3++) {
            int i12 = (11 - i3) * 4;
            int i13 = i12 + 3;
            g4 ^= CAST5Engine.h(g, iArr2[i13], iArr[i13]);
            int i14 = i12 + 2;
            g ^= CAST5Engine.j(g2, iArr2[i14], iArr[i14]);
            int i15 = i12 + 1;
            g2 ^= CAST5Engine.i(g3, iArr2[i15], iArr[i15]);
            g3 ^= CAST5Engine.h(g4, iArr2[i12], iArr[i12]);
        }
        iArr3[0] = g;
        iArr3[1] = g2;
        iArr3[2] = g3;
        iArr3[3] = g4;
        d(g, bArr4, i5);
        d(iArr3[1], bArr4, i5 + 4);
        d(iArr3[2], bArr4, i5 + 8);
        d(iArr3[3], bArr4, i5 + 12);
        return 16;
    }

    public final int m(int i, int i2, byte[] bArr, byte[] bArr2) {
        int i3;
        int[] iArr;
        int[] iArr2;
        int i4 = i;
        int i5 = i2;
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        int[] iArr3 = new int[4];
        int g = g(i4, bArr3);
        int g2 = g(i4 + 4, bArr3);
        int g3 = g(i4 + 8, bArr3);
        int g4 = g(i4 + 12, bArr3);
        int i6 = 0;
        while (true) {
            iArr = this.k;
            iArr2 = this.l;
            if (i6 >= 6) {
                break;
            }
            int i7 = i6 * 4;
            g3 ^= CAST5Engine.h(g4, iArr2[i7], iArr[i7]);
            int i8 = i7 + 1;
            g2 ^= CAST5Engine.i(g3, iArr2[i8], iArr[i8]);
            int i9 = i7 + 2;
            g ^= CAST5Engine.j(g2, iArr2[i9], iArr[i9]);
            int i10 = i7 + 3;
            g4 ^= CAST5Engine.h(g, iArr2[i10], iArr[i10]);
            i6++;
        }
        for (i3 = 6; i3 < 12; i3++) {
            int i11 = i3 * 4;
            int i12 = i11 + 3;
            g4 ^= CAST5Engine.h(g, iArr2[i12], iArr[i12]);
            int i13 = i11 + 2;
            g ^= CAST5Engine.j(g2, iArr2[i13], iArr[i13]);
            int i14 = i11 + 1;
            g2 ^= CAST5Engine.i(g3, iArr2[i14], iArr[i14]);
            g3 ^= CAST5Engine.h(g4, iArr2[i11], iArr[i11]);
        }
        iArr3[0] = g;
        iArr3[1] = g2;
        iArr3[2] = g3;
        iArr3[3] = g4;
        d(g, bArr4, i5);
        d(iArr3[1], bArr4, i5 + 4);
        d(iArr3[2], bArr4, i5 + 8);
        d(iArr3[3], bArr4, i5 + 12);
        return 16;
    }

    public final void n(byte[] bArr) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        byte[] bArr2 = bArr;
        int i = 1518500249;
        int i2 = 19;
        int i3 = 0;
        while (true) {
            iArr = this.m;
            iArr2 = this.n;
            if (i3 >= 24) {
                break;
            }
            for (int i4 = 0; i4 < 8; i4++) {
                int i5 = (i3 * 8) + i4;
                iArr2[i5] = i;
                i += 1859775393;
                iArr[i5] = i2;
                i2 = (i2 + 17) & 31;
            }
            i3++;
        }
        byte[] bArr3 = new byte[64];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        int i6 = 0;
        while (true) {
            iArr3 = this.o;
            if (i6 >= 8) {
                break;
            }
            iArr3[i6] = g(i6 * 4, bArr3);
            i6++;
        }
        for (int i7 = 0; i7 < 12; i7++) {
            int i8 = i7 * 2;
            int i9 = i8 * 8;
            int h = iArr3[6] ^ CAST5Engine.h(iArr3[7], iArr2[i9], iArr[i9]);
            iArr3[6] = h;
            int i10 = i9 + 1;
            int i11 = CAST5Engine.i(h, iArr2[i10], iArr[i10]) ^ iArr3[5];
            iArr3[5] = i11;
            int i12 = i9 + 2;
            int j = CAST5Engine.j(i11, iArr2[i12], iArr[i12]) ^ iArr3[4];
            iArr3[4] = j;
            int i13 = i9 + 3;
            int h2 = CAST5Engine.h(j, iArr2[i13], iArr[i13]) ^ iArr3[3];
            iArr3[3] = h2;
            int i14 = i9 + 4;
            int i15 = CAST5Engine.i(h2, iArr2[i14], iArr[i14]) ^ iArr3[2];
            iArr3[2] = i15;
            int i16 = i9 + 5;
            int j2 = CAST5Engine.j(i15, iArr2[i16], iArr[i16]) ^ iArr3[1];
            iArr3[1] = j2;
            int i17 = i9 + 6;
            int h3 = CAST5Engine.h(j2, iArr2[i17], iArr[i17]) ^ iArr3[0];
            iArr3[0] = h3;
            int i18 = i9 + 7;
            int i19 = CAST5Engine.i(h3, iArr2[i18], iArr[i18]) ^ iArr3[7];
            iArr3[7] = i19;
            int i20 = (i8 + 1) * 8;
            int h4 = CAST5Engine.h(i19, iArr2[i20], iArr[i20]) ^ iArr3[6];
            iArr3[6] = h4;
            int i21 = i20 + 1;
            int i22 = CAST5Engine.i(h4, iArr2[i21], iArr[i21]) ^ iArr3[5];
            iArr3[5] = i22;
            int i23 = i20 + 2;
            int j3 = CAST5Engine.j(i22, iArr2[i23], iArr[i23]) ^ iArr3[4];
            iArr3[4] = j3;
            int i24 = i20 + 3;
            int h5 = CAST5Engine.h(j3, iArr2[i24], iArr[i24]) ^ iArr3[3];
            iArr3[3] = h5;
            int i25 = i20 + 4;
            int i26 = CAST5Engine.i(h5, iArr2[i25], iArr[i25]) ^ iArr3[2];
            iArr3[2] = i26;
            int i27 = i20 + 5;
            int j4 = CAST5Engine.j(i26, iArr2[i27], iArr[i27]) ^ iArr3[1];
            iArr3[1] = j4;
            int i28 = i20 + 6;
            int h6 = CAST5Engine.h(j4, iArr2[i28], iArr[i28]) ^ iArr3[0];
            iArr3[0] = h6;
            int i29 = i20 + 7;
            iArr3[7] = CAST5Engine.i(h6, iArr2[i29], iArr[i29]) ^ iArr3[7];
            int i30 = i7 * 4;
            int[] iArr4 = this.k;
            iArr4[i30] = iArr3[0] & 31;
            int i31 = i30 + 1;
            iArr4[i31] = iArr3[2] & 31;
            int i32 = i30 + 2;
            iArr4[i32] = iArr3[4] & 31;
            int i33 = i30 + 3;
            iArr4[i33] = iArr3[6] & 31;
            int i34 = iArr3[7];
            int[] iArr5 = this.l;
            iArr5[i30] = i34;
            iArr5[i31] = iArr3[5];
            iArr5[i32] = iArr3[3];
            iArr5[i33] = iArr3[1];
        }
    }

    public final void reset() {
    }
}
