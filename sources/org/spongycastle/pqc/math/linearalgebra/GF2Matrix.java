package org.spongycastle.pqc.math.linearalgebra;

import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.perf.util.Constants;
import java.lang.reflect.Array;
import java.security.SecureRandom;

public class GF2Matrix extends Matrix {
    public int[][] a;
    public int c;

    public GF2Matrix(byte[] bArr) {
        if (bArr.length >= 9) {
            this.a = LittleEndianConversions.b(0, bArr);
            int b = LittleEndianConversions.b(4, bArr);
            this.b = b;
            int i = this.a;
            int i2 = ((b + 7) >>> 3) * i;
            if (i > 0) {
                int i3 = 8;
                if (i2 == bArr.length - 8) {
                    int i4 = (b + 31) >>> 5;
                    this.c = i4;
                    int[] iArr = new int[2];
                    iArr[1] = i4;
                    iArr[0] = i;
                    this.a = (int[][]) Array.newInstance(Integer.TYPE, iArr);
                    int i5 = this.b;
                    int i6 = i5 >> 5;
                    int i7 = i5 & 31;
                    for (int i8 = 0; i8 < this.a; i8++) {
                        int i9 = 0;
                        while (i9 < i6) {
                            this.a[i8][i9] = LittleEndianConversions.b(i3, bArr);
                            i9++;
                            i3 += 4;
                        }
                        int i10 = 0;
                        while (i10 < i7) {
                            int[] iArr2 = this.a[i8];
                            iArr2[i6] = ((bArr[i3] & UnsignedBytes.MAX_VALUE) << i10) ^ iArr2[i6];
                            i10 += 8;
                            i3++;
                        }
                    }
                    return;
                }
            }
            throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
        }
        throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
    }

    public final void a(int i, int i2) {
        this.a = i;
        this.b = i2;
        int i3 = (i2 + 31) >>> 5;
        this.c = i3;
        int[] iArr = new int[2];
        iArr[1] = i3;
        iArr[0] = i;
        this.a = (int[][]) Array.newInstance(Integer.TYPE, iArr);
        for (int i4 = 0; i4 < this.a; i4++) {
            for (int i5 = 0; i5 < this.c; i5++) {
                this.a[i4][i5] = 0;
            }
        }
    }

    public final GF2Matrix b() {
        int i = this.a;
        if (i == this.b) {
            int[] iArr = new int[2];
            iArr[1] = this.c;
            iArr[0] = i;
            int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, iArr);
            for (int i2 = this.a - 1; i2 >= 0; i2--) {
                iArr2[i2] = IntUtils.a(this.a[i2]);
            }
            int i3 = this.a;
            int[] iArr3 = new int[2];
            iArr3[1] = this.c;
            iArr3[0] = i3;
            int[][] iArr4 = (int[][]) Array.newInstance(Integer.TYPE, iArr3);
            for (int i4 = this.a - 1; i4 >= 0; i4--) {
                iArr4[i4][i4 >> 5] = 1 << (i4 & 31);
            }
            for (int i5 = 0; i5 < this.a; i5++) {
                int i6 = i5 >> 5;
                int i7 = 1 << (i5 & 31);
                if ((iArr2[i5][i6] & i7) == 0) {
                    int i8 = i5 + 1;
                    boolean z = false;
                    while (true) {
                        int i9 = this.a;
                        if (i8 >= i9) {
                            break;
                        }
                        int[] iArr5 = iArr2[i8];
                        if ((iArr5[i6] & i7) != 0) {
                            int[] iArr6 = iArr2[i5];
                            iArr2[i5] = iArr5;
                            iArr2[i8] = iArr6;
                            int[] iArr7 = iArr4[i5];
                            iArr4[i5] = iArr4[i8];
                            iArr4[i8] = iArr7;
                            z = true;
                            i8 = i9;
                        }
                        i8++;
                    }
                    if (!z) {
                        throw new ArithmeticException("Matrix is not invertible.");
                    }
                }
                for (int i10 = this.a - 1; i10 >= 0; i10--) {
                    if (i10 != i5) {
                        int[] iArr8 = iArr2[i10];
                        if ((iArr8[i6] & i7) != 0) {
                            int[] iArr9 = iArr2[i5];
                            int length = iArr8.length;
                            while (true) {
                                length--;
                                if (length < i6) {
                                    break;
                                }
                                iArr8[length] = iArr9[length] ^ iArr8[length];
                            }
                            int[] iArr10 = iArr4[i5];
                            int[] iArr11 = iArr4[i10];
                            int length2 = iArr11.length;
                            while (true) {
                                length2--;
                                if (length2 < 0) {
                                    break;
                                }
                                iArr11[length2] = iArr10[length2] ^ iArr11[length2];
                            }
                        }
                    }
                }
            }
            return new GF2Matrix(this.b, iArr4);
        }
        throw new ArithmeticException("Matrix is not invertible.");
    }

    public final GF2Matrix c() {
        int i = this.b;
        int[] iArr = new int[2];
        iArr[1] = (this.a + 31) >>> 5;
        iArr[0] = i;
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, iArr);
        int i2 = 0;
        while (true) {
            int i3 = this.a;
            if (i2 >= i3) {
                return new GF2Matrix(i3, iArr2);
            }
            for (int i4 = 0; i4 < this.b; i4++) {
                int i5 = i2 >>> 5;
                int i6 = i2 & 31;
                if (((this.a[i2][i4 >>> 5] >>> (i4 & 31)) & 1) == 1) {
                    int[] iArr3 = iArr2[i4];
                    iArr3[i5] = (1 << i6) | iArr3[i5];
                }
            }
            i2++;
        }
    }

    public final byte[] d() {
        int i = this.a;
        int i2 = 8;
        byte[] bArr = new byte[((((this.b + 7) >>> 3) * i) + 8)];
        LittleEndianConversions.a(i, bArr, 0);
        LittleEndianConversions.a(this.b, bArr, 4);
        int i3 = this.b;
        int i4 = i3 >>> 5;
        int i5 = i3 & 31;
        for (int i6 = 0; i6 < this.a; i6++) {
            int i7 = 0;
            while (i7 < i4) {
                LittleEndianConversions.a(this.a[i6][i7], bArr, i2);
                i7++;
                i2 += 4;
            }
            int i8 = 0;
            while (i8 < i5) {
                bArr[i2] = (byte) ((this.a[i6][i4] >>> i8) & Constants.MAX_HOST_LENGTH);
                i8 += 8;
                i2++;
            }
        }
        return bArr;
    }

    public final GF2Vector e(GF2Vector gF2Vector) {
        int[] iArr;
        int i = gF2Vector.a;
        int i2 = this.a;
        if (i == i2) {
            int[] iArr2 = new int[this.c];
            int i3 = i2 >> 5;
            int i4 = 1 << (i2 & 31);
            int i5 = 0;
            int i6 = 0;
            while (true) {
                iArr = gF2Vector.a;
                if (i5 >= i3) {
                    break;
                }
                int i7 = 1;
                do {
                    if ((iArr[i5] & i7) != 0) {
                        for (int i8 = 0; i8 < this.c; i8++) {
                            iArr2[i8] = iArr2[i8] ^ this.a[i6][i8];
                        }
                    }
                    i6++;
                    i7 <<= 1;
                } while (i7 != 0);
                i5++;
            }
            for (int i9 = 1; i9 != i4; i9 <<= 1) {
                if ((iArr[i3] & i9) != 0) {
                    for (int i10 = 0; i10 < this.c; i10++) {
                        iArr2[i10] = iArr2[i10] ^ this.a[i6][i10];
                    }
                }
                i6++;
            }
            return new GF2Vector(iArr2, this.b);
        }
        throw new ArithmeticException("length mismatch");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof GF2Matrix)) {
            return false;
        }
        GF2Matrix gF2Matrix = (GF2Matrix) obj;
        if (this.a != gF2Matrix.a || this.b != gF2Matrix.b || this.c != gF2Matrix.c) {
            return false;
        }
        for (int i = 0; i < this.a; i++) {
            if (!IntUtils.b(this.a[i], gF2Matrix.a[i])) {
                return false;
            }
        }
        return true;
    }

    public final GF2Matrix f(GF2Matrix gF2Matrix) {
        int i;
        if (gF2Matrix.a == this.b) {
            GF2Matrix gF2Matrix2 = new GF2Matrix(this.a, gF2Matrix.b);
            int i2 = this.b & 31;
            if (i2 == 0) {
                i = this.c;
            } else {
                i = this.c - 1;
            }
            for (int i3 = 0; i3 < this.a; i3++) {
                int i4 = 0;
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = this.a[i3][i5];
                    for (int i7 = 0; i7 < 32; i7++) {
                        if (((1 << i7) & i6) != 0) {
                            for (int i8 = 0; i8 < gF2Matrix.c; i8++) {
                                int[] iArr = gF2Matrix2.a[i3];
                                iArr[i8] = iArr[i8] ^ gF2Matrix.a[i4][i8];
                            }
                        }
                        i4++;
                    }
                }
                int i9 = this.a[i3][this.c - 1];
                for (int i10 = 0; i10 < i2; i10++) {
                    if (((1 << i10) & i9) != 0) {
                        for (int i11 = 0; i11 < gF2Matrix.c; i11++) {
                            int[] iArr2 = gF2Matrix2.a[i3];
                            iArr2[i11] = iArr2[i11] ^ gF2Matrix.a[i4][i11];
                        }
                    }
                    i4++;
                }
            }
            return gF2Matrix2;
        }
        throw new ArithmeticException("length mismatch");
    }

    public final GF2Matrix g(Permutation permutation) {
        int[] a2 = IntUtils.a(permutation.a);
        int length = a2.length;
        int i = this.b;
        if (length == i) {
            GF2Matrix gF2Matrix = new GF2Matrix(this.a, i);
            int i2 = this.b;
            while (true) {
                i2--;
                if (i2 < 0) {
                    return gF2Matrix;
                }
                int i3 = i2 >>> 5;
                int i4 = i2 & 31;
                int i5 = a2[i2];
                int i6 = i5 >>> 5;
                int i7 = i5 & 31;
                int i8 = this.a;
                while (true) {
                    i8--;
                    if (i8 >= 0) {
                        int[] iArr = gF2Matrix.a[i8];
                        iArr[i3] = iArr[i3] | (((this.a[i8][i6] >>> i7) & 1) << i4);
                    }
                }
            }
        } else {
            throw new ArithmeticException("length mismatch");
        }
    }

    public final GF2Vector h(GF2Vector gF2Vector) {
        if (gF2Vector.a == this.b) {
            int[] iArr = new int[((this.a + 31) >>> 5)];
            int i = 0;
            while (true) {
                int i2 = this.a;
                if (i >= i2) {
                    return new GF2Vector(iArr, i2);
                }
                int i3 = 0;
                for (int i4 = 0; i4 < this.c; i4++) {
                    i3 ^= this.a[i][i4] & gF2Vector.a[i4];
                }
                int i5 = 0;
                for (int i6 = 0; i6 < 32; i6++) {
                    i5 ^= (i3 >>> i6) & 1;
                }
                if (i5 == 1) {
                    int i7 = i >>> 5;
                    iArr[i7] = iArr[i7] | (1 << (i & 31));
                }
                i++;
            }
        } else {
            throw new ArithmeticException("length mismatch");
        }
    }

    public final int hashCode() {
        int i = (((this.a * 31) + this.b) * 31) + this.c;
        for (int i2 = 0; i2 < this.a; i2++) {
            i = (i * 31) + this.a[i2].hashCode();
        }
        return i;
    }

    public final String toString() {
        int i;
        int i2 = this.b & 31;
        if (i2 == 0) {
            i = this.c;
        } else {
            i = this.c - 1;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < this.a; i3++) {
            stringBuffer.append(i3 + ": ");
            for (int i4 = 0; i4 < i; i4++) {
                int i5 = this.a[i3][i4];
                for (int i6 = 0; i6 < 32; i6++) {
                    if (((i5 >>> i6) & 1) == 0) {
                        stringBuffer.append('0');
                    } else {
                        stringBuffer.append('1');
                    }
                }
                stringBuffer.append(' ');
            }
            int i7 = this.a[i3][this.c - 1];
            for (int i8 = 0; i8 < i2; i8++) {
                if (((i7 >>> i8) & 1) == 0) {
                    stringBuffer.append('0');
                } else {
                    stringBuffer.append('1');
                }
            }
            stringBuffer.append(10);
        }
        return stringBuffer.toString();
    }

    public GF2Matrix(int i, int[][] iArr) {
        int[] iArr2 = iArr[0];
        if (iArr2.length == ((i + 31) >> 5)) {
            this.b = i;
            this.a = iArr.length;
            this.c = iArr2.length;
            int i2 = i & 31;
            int i3 = i2 == 0 ? -1 : (1 << i2) - 1;
            for (int i4 = 0; i4 < this.a; i4++) {
                int[] iArr3 = iArr[i4];
                int i5 = this.c - 1;
                iArr3[i5] = iArr3[i5] & i3;
            }
            this.a = iArr;
            return;
        }
        throw new ArithmeticException("Int array does not match given number of columns.");
    }

    public GF2Matrix(int i) {
        this(i, 'I', new SecureRandom());
    }

    public GF2Matrix(int i, char c2, SecureRandom secureRandom) {
        int i2;
        if (i > 0) {
            if (c2 == 'I') {
                this.a = i;
                this.b = i;
                int i3 = (i + 31) >>> 5;
                this.c = i3;
                int[] iArr = new int[2];
                iArr[1] = i3;
                iArr[0] = i;
                this.a = (int[][]) Array.newInstance(Integer.TYPE, iArr);
                for (int i4 = 0; i4 < this.a; i4++) {
                    for (int i5 = 0; i5 < this.c; i5++) {
                        this.a[i4][i5] = 0;
                    }
                }
                for (int i6 = 0; i6 < this.a; i6++) {
                    this.a[i6][i6 >>> 5] = 1 << (i6 & 31);
                }
            } else if (c2 == 'L') {
                this.a = i;
                this.b = i;
                int i7 = (i + 31) >>> 5;
                this.c = i7;
                int[] iArr2 = new int[2];
                iArr2[1] = i7;
                iArr2[0] = i;
                this.a = (int[][]) Array.newInstance(Integer.TYPE, iArr2);
                for (int i8 = 0; i8 < this.a; i8++) {
                    int i9 = i8 >>> 5;
                    int i10 = i8 & 31;
                    int i11 = 31 - i10;
                    int i12 = 1 << i10;
                    for (int i13 = 0; i13 < i9; i13++) {
                        this.a[i8][i13] = secureRandom.nextInt();
                    }
                    this.a[i8][i9] = i12 | (secureRandom.nextInt() >>> i11);
                    while (true) {
                        i9++;
                        if (i9 >= this.c) {
                            break;
                        }
                        this.a[i8][i9] = 0;
                    }
                }
            } else if (c2 == 'R') {
                this.a = i;
                this.b = i;
                int i14 = (i + 31) >>> 5;
                this.c = i14;
                int[] iArr3 = new int[2];
                iArr3[1] = i14;
                iArr3[0] = i;
                this.a = (int[][]) Array.newInstance(Integer.TYPE, iArr3);
                GF2Matrix f = new GF2Matrix(i, 'L', secureRandom).f(new GF2Matrix(i, 'U', secureRandom));
                int[] a2 = IntUtils.a(new Permutation(i, secureRandom).a);
                for (int i15 = 0; i15 < i; i15++) {
                    System.arraycopy(f.a[i15], 0, this.a[a2[i15]], 0, this.c);
                }
            } else if (c2 == 'U') {
                this.a = i;
                this.b = i;
                int i16 = (i + 31) >>> 5;
                this.c = i16;
                int[] iArr4 = new int[2];
                iArr4[1] = i16;
                iArr4[0] = i;
                this.a = (int[][]) Array.newInstance(Integer.TYPE, iArr4);
                int i17 = i & 31;
                int i18 = i17 == 0 ? -1 : (1 << i17) - 1;
                for (int i19 = 0; i19 < this.a; i19++) {
                    int i20 = i19 >>> 5;
                    int i21 = i19 & 31;
                    int i22 = 1 << i21;
                    for (int i23 = 0; i23 < i20; i23++) {
                        this.a[i19][i23] = 0;
                    }
                    this.a[i19][i20] = (secureRandom.nextInt() << i21) | i22;
                    while (true) {
                        i20++;
                        i2 = this.c;
                        if (i20 >= i2) {
                            break;
                        }
                        this.a[i19][i20] = secureRandom.nextInt();
                    }
                    int[] iArr5 = this.a[i19];
                    int i24 = i2 - 1;
                    iArr5[i24] = iArr5[i24] & i18;
                }
            } else if (c2 == 'Z') {
                a(i, i);
            } else {
                throw new ArithmeticException("Unknown matrix type.");
            }
        } else {
            throw new ArithmeticException("Size of matrix is non-positive.");
        }
    }

    public GF2Matrix(GF2Matrix gF2Matrix) {
        this.b = gF2Matrix.b;
        this.a = gF2Matrix.a;
        this.c = gF2Matrix.c;
        this.a = new int[gF2Matrix.a.length][];
        int i = 0;
        while (true) {
            int[][] iArr = this.a;
            if (i < iArr.length) {
                iArr[i] = IntUtils.a(gF2Matrix.a[i]);
                i++;
            } else {
                return;
            }
        }
    }

    public GF2Matrix(int i, int i2) {
        if (i2 <= 0 || i <= 0) {
            throw new ArithmeticException("size of matrix is non-positive");
        }
        a(i, i2);
    }
}
