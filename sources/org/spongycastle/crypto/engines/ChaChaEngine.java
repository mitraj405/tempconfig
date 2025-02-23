package org.spongycastle.crypto.engines;

import org.spongycastle.util.Pack;

public class ChaChaEngine extends Salsa20Engine {
    public ChaChaEngine() {
    }

    public static void k(int[] iArr, int i, int[] iArr2) {
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        if (iArr3.length != 16) {
            throw new IllegalArgumentException();
        } else if (iArr4.length != 16) {
            throw new IllegalArgumentException();
        } else if (i % 2 == 0) {
            int i2 = iArr3[0];
            int i3 = iArr3[1];
            int i4 = iArr3[2];
            int i5 = iArr3[3];
            int i6 = iArr3[4];
            int i7 = iArr3[5];
            int i8 = iArr3[6];
            int i9 = iArr3[7];
            int i10 = iArr3[8];
            int i11 = iArr3[9];
            int i12 = iArr3[10];
            int i13 = iArr3[11];
            int i14 = iArr3[12];
            int i15 = iArr3[13];
            int i16 = iArr3[14];
            int i17 = iArr3[15];
            int i18 = i16;
            int i19 = i15;
            int i20 = i14;
            int i21 = i13;
            int i22 = i12;
            int i23 = i11;
            int i24 = i10;
            int i25 = i9;
            int i26 = i8;
            int i27 = i7;
            int i28 = i6;
            int i29 = i5;
            int i30 = i4;
            int i31 = i3;
            int i32 = i2;
            for (int i33 = i; i33 > 0; i33 -= 2) {
                int i34 = i32 + i28;
                int i35 = i20 ^ i34;
                int i36 = (i35 >>> -16) | (i35 << 16);
                int i37 = i24 + i36;
                int i38 = i28 ^ i37;
                int i39 = (i38 >>> -12) | (i38 << 12);
                int i40 = i34 + i39;
                int i41 = i36 ^ i40;
                int i42 = (i41 >>> -8) | (i41 << 8);
                int i43 = i37 + i42;
                int i44 = i39 ^ i43;
                int i45 = (i44 >>> -7) | (i44 << 7);
                int i46 = i31 + i27;
                int i47 = i19 ^ i46;
                int i48 = (i47 >>> -16) | (i47 << 16);
                int i49 = i23 + i48;
                int i50 = i27 ^ i49;
                int i51 = (i50 >>> -12) | (i50 << 12);
                int i52 = i46 + i51;
                int i53 = i48 ^ i52;
                int i54 = (i53 >>> -8) | (i53 << 8);
                int i55 = i49 + i54;
                int i56 = i51 ^ i55;
                int i57 = (i56 >>> -7) | (i56 << 7);
                int i58 = i30 + i26;
                int i59 = i18 ^ i58;
                int i60 = (i59 >>> -16) | (i59 << 16);
                int i61 = i22 + i60;
                int i62 = i26 ^ i61;
                int i63 = (i62 >>> -12) | (i62 << 12);
                int i64 = i58 + i63;
                int i65 = i60 ^ i64;
                int i66 = (i65 >>> -8) | (i65 << 8);
                int i67 = i61 + i66;
                int i68 = i63 ^ i67;
                int i69 = (i68 >>> -7) | (i68 << 7);
                int i70 = i29 + i25;
                int i71 = i17 ^ i70;
                int i72 = (i71 >>> -16) | (i71 << 16);
                int i73 = i21 + i72;
                int i74 = i25 ^ i73;
                int i75 = (i74 >>> -12) | (i74 << 12);
                int i76 = i70 + i75;
                int i77 = i72 ^ i76;
                int i78 = (i77 >>> -8) | (i77 << 8);
                int i79 = i73 + i78;
                int i80 = i75 ^ i79;
                int i81 = (i80 >>> -7) | (i80 << 7);
                int i82 = i40 + i57;
                int i83 = i78 ^ i82;
                int i84 = (i83 >>> -16) | (i83 << 16);
                int i85 = i67 + i84;
                int i86 = i57 ^ i85;
                int i87 = (i86 >>> -12) | (i86 << 12);
                i32 = i82 + i87;
                int i88 = i84 ^ i32;
                i17 = (i88 >>> -8) | (i88 << 8);
                i22 = i85 + i17;
                int i89 = i87 ^ i22;
                i27 = (i89 >>> -7) | (i89 << 7);
                int i90 = i52 + i69;
                int i91 = i42 ^ i90;
                int i92 = (i91 >>> -16) | (i91 << 16);
                int i93 = i79 + i92;
                int i94 = i69 ^ i93;
                int i95 = (i94 >>> -12) | (i94 << 12);
                i31 = i90 + i95;
                int i96 = i92 ^ i31;
                i20 = (i96 >>> -8) | (i96 << 8);
                i21 = i93 + i20;
                int i97 = i95 ^ i21;
                i26 = (i97 >>> -7) | (i97 << 7);
                int i98 = i64 + i81;
                int i99 = i54 ^ i98;
                int i100 = (i99 >>> -16) | (i99 << 16);
                int i101 = i43 + i100;
                int i102 = i81 ^ i101;
                int i103 = (i102 >>> -12) | (i102 << 12);
                i30 = i98 + i103;
                int i104 = i100 ^ i30;
                i19 = (i104 >>> -8) | (i104 << 8);
                i24 = i101 + i19;
                int i105 = i103 ^ i24;
                i25 = (i105 >>> -7) | (i105 << 7);
                int i106 = i76 + i45;
                int i107 = i66 ^ i106;
                int i108 = (i107 >>> -16) | (i107 << 16);
                int i109 = i55 + i108;
                int i110 = i45 ^ i109;
                int i111 = (i110 >>> -12) | (i110 << 12);
                i29 = i106 + i111;
                int i112 = i108 ^ i29;
                i18 = (i112 >>> -8) | (i112 << 8);
                i23 = i109 + i18;
                int i113 = i111 ^ i23;
                i28 = (i113 >>> -7) | (i113 << 7);
            }
            iArr4[0] = i32 + iArr3[0];
            iArr4[1] = i31 + iArr3[1];
            iArr4[2] = i30 + iArr3[2];
            iArr4[3] = i29 + iArr3[3];
            iArr4[4] = i28 + iArr3[4];
            iArr4[5] = i27 + iArr3[5];
            iArr4[6] = i26 + iArr3[6];
            iArr4[7] = i25 + iArr3[7];
            iArr4[8] = i24 + iArr3[8];
            iArr4[9] = i23 + iArr3[9];
            iArr4[10] = i22 + iArr3[10];
            iArr4[11] = i21 + iArr3[11];
            iArr4[12] = i20 + iArr3[12];
            iArr4[13] = i19 + iArr3[13];
            iArr4[14] = i18 + iArr3[14];
            iArr4[15] = i17 + iArr3[15];
        } else {
            throw new IllegalArgumentException("Number of rounds must be even");
        }
    }

    public final String b() {
        return "ChaCha" + this.a;
    }

    public final void c() {
        int[] iArr = this.f6047a;
        int i = iArr[12] + 1;
        iArr[12] = i;
        if (i == 0) {
            iArr[13] = iArr[13] + 1;
        }
    }

    public final void e(byte[] bArr) {
        int[] iArr = this.f6047a;
        int i = this.a;
        int[] iArr2 = this.f6048b;
        k(iArr, i, iArr2);
        int i2 = 0;
        for (int e : iArr2) {
            Pack.e(e, bArr, i2);
            i2 += 4;
        }
    }

    public final void h() {
        int[] iArr = this.f6047a;
        iArr[13] = 0;
        iArr[12] = 0;
    }

    public final void j(byte[] bArr, byte[] bArr2) {
        int[] iArr = this.f6047a;
        if (bArr != null) {
            if (bArr.length == 16 || bArr.length == 32) {
                Salsa20Engine.g(bArr.length, iArr);
                Pack.g(bArr, 0, iArr, 4, 4);
                Pack.g(bArr, bArr.length - 16, iArr, 8, 4);
            } else {
                throw new IllegalArgumentException(b() + " requires 128 bit or 256 bit key");
            }
        }
        Pack.g(bArr2, 0, iArr, 14, 2);
    }

    public ChaChaEngine(int i) {
        super(i);
    }
}
