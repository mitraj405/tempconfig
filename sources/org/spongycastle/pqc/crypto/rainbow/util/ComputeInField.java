package org.spongycastle.pqc.crypto.rainbow.util;

import java.lang.reflect.Array;

public class ComputeInField {
    public short[] a;

    /* renamed from: a  reason: collision with other field name */
    public short[][] f6743a;

    public static short[][] a(short[][] sArr, short[][] sArr2) {
        if (sArr.length == sArr2.length && sArr[0].length == sArr2[0].length) {
            int length = sArr.length;
            int[] iArr = new int[2];
            iArr[1] = sArr.length;
            iArr[0] = length;
            short[][] sArr3 = (short[][]) Array.newInstance(Short.TYPE, iArr);
            for (int i = 0; i < sArr.length; i++) {
                for (int i2 = 0; i2 < sArr2.length; i2++) {
                    sArr3[i][i2] = (short) (sArr[i][i2] ^ sArr2[i][i2]);
                }
            }
            return sArr3;
        }
        throw new RuntimeException("Addition is not possible!");
    }

    public static short[] b(short[] sArr, short[] sArr2) {
        if (sArr.length == sArr2.length) {
            int length = sArr.length;
            short[] sArr3 = new short[length];
            for (int i = 0; i < length; i++) {
                sArr3[i] = (short) (sArr[i] ^ sArr2[i]);
            }
            return sArr3;
        }
        throw new RuntimeException("Multiplication is not possible!");
    }

    public static short[] f(short[] sArr, short s) {
        int length = sArr.length;
        short[] sArr2 = new short[length];
        for (int i = 0; i < length; i++) {
            sArr2[i] = GF2Field.b(s, sArr[i]);
        }
        return sArr2;
    }

    public static short[][] g(short[] sArr, short[] sArr2) {
        if (sArr.length == sArr2.length) {
            int length = sArr.length;
            int[] iArr = new int[2];
            iArr[1] = sArr2.length;
            iArr[0] = length;
            short[][] sArr3 = (short[][]) Array.newInstance(Short.TYPE, iArr);
            for (int i = 0; i < sArr.length; i++) {
                for (int i2 = 0; i2 < sArr2.length; i2++) {
                    sArr3[i][i2] = GF2Field.b(sArr[i], sArr2[i2]);
                }
            }
            return sArr3;
        }
        throw new RuntimeException("Multiplication is not possible!");
    }

    public static short[] h(short[][] sArr, short[] sArr2) throws RuntimeException {
        if (sArr[0].length == sArr2.length) {
            short[] sArr3 = new short[sArr.length];
            for (int i = 0; i < sArr.length; i++) {
                for (int i2 = 0; i2 < sArr2.length; i2++) {
                    sArr3[i] = (short) (GF2Field.b(sArr[i][i2], sArr2[i2]) ^ sArr3[i]);
                }
            }
            return sArr3;
        }
        throw new RuntimeException("Multiplication is not possible!");
    }

    public final void c() throws RuntimeException {
        for (int length = this.f6743a.length - 1; length > 0; length--) {
            int i = length - 1;
            while (i >= 0) {
                short[][] sArr = this.f6743a;
                short s = sArr[i][length];
                short a2 = GF2Field.a(sArr[length][length]);
                if (a2 != 0) {
                    int i2 = length;
                    while (true) {
                        short[][] sArr2 = this.f6743a;
                        if (i2 >= sArr2.length * 2) {
                            break;
                        }
                        short b = GF2Field.b(s, GF2Field.b(sArr2[length][i2], a2));
                        short[] sArr3 = this.f6743a[i];
                        sArr3[i2] = (short) (b ^ sArr3[i2]);
                        i2++;
                    }
                    i--;
                } else {
                    throw new RuntimeException("The matrix is not invertible");
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0054, code lost:
        r0 = r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(boolean r10) throws java.lang.RuntimeException {
        /*
            r9 = this;
            if (r10 == 0) goto L_0x0008
            short[][] r10 = r9.f6743a
            int r10 = r10.length
            int r10 = r10 * 2
            goto L_0x000d
        L_0x0008:
            short[][] r10 = r9.f6743a
            int r10 = r10.length
            int r10 = r10 + 1
        L_0x000d:
            r0 = 0
        L_0x000e:
            short[][] r1 = r9.f6743a
            int r1 = r1.length
            int r1 = r1 + -1
            if (r0 >= r1) goto L_0x0056
            int r1 = r0 + 1
            r2 = r1
        L_0x0018:
            short[][] r3 = r9.f6743a
            int r4 = r3.length
            if (r2 >= r4) goto L_0x0054
            r4 = r3[r2]
            short r4 = r4[r0]
            r3 = r3[r0]
            short r3 = r3[r0]
            short r3 = org.spongycastle.pqc.crypto.rainbow.util.GF2Field.a(r3)
            if (r3 == 0) goto L_0x004c
            r5 = r0
        L_0x002c:
            if (r5 >= r10) goto L_0x0049
            short[][] r6 = r9.f6743a
            r6 = r6[r0]
            short r6 = r6[r5]
            short r6 = org.spongycastle.pqc.crypto.rainbow.util.GF2Field.b(r6, r3)
            short r6 = org.spongycastle.pqc.crypto.rainbow.util.GF2Field.b(r4, r6)
            short[][] r7 = r9.f6743a
            r7 = r7[r2]
            short r8 = r7[r5]
            r6 = r6 ^ r8
            short r6 = (short) r6
            r7[r5] = r6
            int r5 = r5 + 1
            goto L_0x002c
        L_0x0049:
            int r2 = r2 + 1
            goto L_0x0018
        L_0x004c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "Matrix not invertible! We have to choose another one!"
            r10.<init>(r0)
            throw r10
        L_0x0054:
            r0 = r1
            goto L_0x000e
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.pqc.crypto.rainbow.util.ComputeInField.d(boolean):void");
    }

    public final short[][] e(short[][] sArr) {
        try {
            int length = sArr.length;
            int[] iArr = new int[2];
            iArr[1] = sArr.length * 2;
            int i = 0;
            iArr[0] = length;
            this.f6743a = (short[][]) Array.newInstance(Short.TYPE, iArr);
            if (sArr.length == sArr[0].length) {
                for (int i2 = 0; i2 < sArr.length; i2++) {
                    for (int i3 = 0; i3 < sArr.length; i3++) {
                        this.f6743a[i2][i3] = sArr[i2][i3];
                    }
                    for (int length2 = sArr.length; length2 < sArr.length * 2; length2++) {
                        this.f6743a[i2][length2] = 0;
                    }
                    short[][] sArr2 = this.f6743a;
                    sArr2[i2][sArr2.length + i2] = 1;
                }
                d(true);
                int i4 = 0;
                while (true) {
                    short[][] sArr3 = this.f6743a;
                    if (i4 >= sArr3.length) {
                        break;
                    }
                    short a2 = GF2Field.a(sArr3[i4][i4]);
                    int i5 = i4;
                    while (true) {
                        short[][] sArr4 = this.f6743a;
                        if (i5 >= sArr4.length * 2) {
                            break;
                        }
                        short[] sArr5 = sArr4[i4];
                        sArr5[i5] = GF2Field.b(sArr5[i5], a2);
                        i5++;
                    }
                    i4++;
                }
                c();
                short[][] sArr6 = this.f6743a;
                int length3 = sArr6.length;
                int[] iArr2 = new int[2];
                iArr2[1] = sArr6.length;
                iArr2[0] = length3;
                short[][] sArr7 = (short[][]) Array.newInstance(Short.TYPE, iArr2);
                while (true) {
                    short[][] sArr8 = this.f6743a;
                    if (i >= sArr8.length) {
                        return sArr7;
                    }
                    int length4 = sArr8.length;
                    while (true) {
                        short[][] sArr9 = this.f6743a;
                        if (length4 >= sArr9.length * 2) {
                            break;
                        }
                        sArr7[i][length4 - sArr9.length] = sArr9[i][length4];
                        length4++;
                    }
                    i++;
                }
            } else {
                throw new RuntimeException("The matrix is not invertible. Please choose another one!");
            }
        } catch (RuntimeException unused) {
            return null;
        }
    }

    public final short[] i(short[][] sArr, short[] sArr2) {
        if (sArr.length != sArr2.length) {
            return null;
        }
        try {
            int length = sArr.length;
            int[] iArr = new int[2];
            iArr[1] = sArr.length + 1;
            iArr[0] = length;
            this.f6743a = (short[][]) Array.newInstance(Short.TYPE, iArr);
            this.a = new short[sArr.length];
            for (int i = 0; i < sArr.length; i++) {
                for (int i2 = 0; i2 < sArr[0].length; i2++) {
                    this.f6743a[i][i2] = sArr[i][i2];
                }
            }
            for (int i3 = 0; i3 < sArr2.length; i3++) {
                short[] sArr3 = this.f6743a[i3];
                sArr3[sArr2.length] = (short) (sArr2[i3] ^ sArr3[sArr2.length]);
            }
            d(false);
            j();
            return this.a;
        } catch (RuntimeException unused) {
            return null;
        }
    }

    public final void j() throws IllegalStateException {
        short[][] sArr = this.f6743a;
        short a2 = GF2Field.a(sArr[sArr.length - 1][sArr.length - 1]);
        if (a2 != 0) {
            short[] sArr2 = this.a;
            short[][] sArr3 = this.f6743a;
            sArr2[sArr3.length - 1] = GF2Field.b(sArr3[sArr3.length - 1][sArr3.length], a2);
            int length = this.f6743a.length - 2;
            while (length >= 0) {
                short[][] sArr4 = this.f6743a;
                short s = sArr4[length][sArr4.length];
                for (int length2 = sArr4.length - 1; length2 > length; length2--) {
                    s = (short) (s ^ GF2Field.b(this.f6743a[length][length2], this.a[length2]));
                }
                short a3 = GF2Field.a(this.f6743a[length][length]);
                if (a3 != 0) {
                    this.a[length] = GF2Field.b(s, a3);
                    length--;
                } else {
                    throw new IllegalStateException("Not solvable equation system");
                }
            }
            return;
        }
        throw new IllegalStateException("The equation system is not solvable");
    }
}
