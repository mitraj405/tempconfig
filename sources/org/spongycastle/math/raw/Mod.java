package org.spongycastle.math.raw;

public abstract class Mod {
    public static int a(int[] iArr, int[] iArr2, int i, int[] iArr3, int i2) {
        int i3;
        int i4;
        int length = iArr.length;
        int i5 = 0;
        while (true) {
            i3 = iArr2[0];
            if (i3 != 0) {
                break;
            }
            int i6 = i;
            int i7 = 0;
            while (true) {
                i6--;
                if (i6 < 0) {
                    break;
                }
                int i8 = iArr2[i6];
                iArr2[i6] = i7;
                i7 = i8;
            }
            i5 += 32;
        }
        int i9 = 0;
        while ((i3 & 1) == 0) {
            i3 >>>= 1;
            i9++;
        }
        if (i9 > 0) {
            int i10 = 0;
            while (true) {
                i--;
                if (i < 0) {
                    break;
                }
                int i11 = iArr2[i];
                iArr2[i] = (i10 << (-i9)) | (i11 >>> i9);
                i10 = i11;
            }
            i5 += i9;
        }
        for (int i12 = 0; i12 < i5; i12++) {
            if ((iArr3[0] & 1) != 0) {
                if (i2 < 0) {
                    i4 = Nat.d(iArr, length, iArr3);
                } else {
                    i4 = Nat.x(iArr, length, iArr3);
                }
                i2 = i4 + i2;
            }
            int i13 = i2;
            int i14 = length;
            while (true) {
                i14--;
                if (i14 < 0) {
                    break;
                }
                int i15 = iArr3[i14];
                iArr3[i14] = (i13 << 31) | (i15 >>> 1);
                i13 = i15;
            }
        }
        return i2;
    }

    public static void b(int[] iArr, int[] iArr2, int[] iArr3) {
        int i;
        int length = iArr.length;
        if (Nat.q(length, iArr2)) {
            throw new IllegalArgumentException("'x' cannot be 0");
        } else if (Nat.p(length, iArr2)) {
            System.arraycopy(iArr2, 0, iArr3, 0, length);
        } else {
            int[] iArr4 = new int[length];
            System.arraycopy(iArr2, 0, iArr4, 0, length);
            int[] iArr5 = new int[length];
            iArr5[0] = 1;
            if ((1 & iArr4[0]) == 0) {
                i = a(iArr, iArr4, length, iArr5, 0);
            } else {
                i = 0;
            }
            if (!Nat.p(length, iArr4)) {
                int[] iArr6 = new int[length];
                System.arraycopy(iArr, 0, iArr6, 0, length);
                int[] iArr7 = new int[length];
                int i2 = length;
                int i3 = 0;
                while (true) {
                    int i4 = i2 - 1;
                    if (iArr4[i4] == 0 && iArr6[i4] == 0) {
                        i2 = i4;
                    } else if (Nat.k(iArr4, i2, iArr6)) {
                        Nat.x(iArr6, i2, iArr4);
                        i = a(iArr, iArr4, i2, iArr5, (Nat.x(iArr7, length, iArr5) - i3) + i);
                        if (Nat.p(i2, iArr4)) {
                            if (i < 0) {
                                Nat.a(iArr.length, iArr5, iArr, iArr3);
                                return;
                            } else {
                                System.arraycopy(iArr5, 0, iArr3, 0, iArr.length);
                                return;
                            }
                        }
                    } else {
                        Nat.x(iArr4, i2, iArr6);
                        i3 = a(iArr, iArr6, i2, iArr7, (Nat.x(iArr5, length, iArr7) - i) + i3);
                        if (Nat.p(i2, iArr6)) {
                            if (i3 < 0) {
                                Nat.a(iArr.length, iArr7, iArr, iArr3);
                                return;
                            } else {
                                System.arraycopy(iArr7, 0, iArr3, 0, iArr.length);
                                return;
                            }
                        }
                    }
                }
            } else if (i < 0) {
                Nat.a(iArr.length, iArr5, iArr, iArr3);
            } else {
                System.arraycopy(iArr5, 0, iArr3, 0, iArr.length);
            }
        }
    }
}
