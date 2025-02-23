package org.spongycastle.pqc.math.linearalgebra;

import com.google.common.primitives.UnsignedBytes;
import java.security.SecureRandom;

public class GF2Vector extends Vector {
    public final int[] a;

    public GF2Vector(int i) {
        if (i >= 0) {
            this.a = i;
            this.a = new int[((i + 31) >> 5)];
            return;
        }
        throw new ArithmeticException("Negative length.");
    }

    public static GF2Vector a(int i, byte[] bArr) {
        if (i >= 0) {
            if (bArr.length <= ((i + 7) >> 3)) {
                int length = (bArr.length + 3) / 4;
                int length2 = bArr.length & 3;
                int[] iArr = new int[length];
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                while (i3 <= length - 2) {
                    iArr[i3] = LittleEndianConversions.b(i4, bArr);
                    i3++;
                    i4 += 4;
                }
                if (length2 != 0) {
                    int i5 = length - 1;
                    while (true) {
                        length2--;
                        if (length2 < 0) {
                            break;
                        }
                        i2 |= (bArr[i4 + length2] & UnsignedBytes.MAX_VALUE) << (length2 * 8);
                    }
                    iArr[i5] = i2;
                } else {
                    iArr[length - 1] = LittleEndianConversions.b(i4, bArr);
                }
                return new GF2Vector(i, iArr);
            }
            throw new ArithmeticException("length mismatch");
        }
        throw new ArithmeticException("negative length");
    }

    public final Vector b(Vector vector) {
        if (vector instanceof GF2Vector) {
            GF2Vector gF2Vector = (GF2Vector) vector;
            if (this.a == gF2Vector.a) {
                int[] a2 = IntUtils.a(gF2Vector.a);
                int length = a2.length;
                while (true) {
                    length--;
                    if (length < 0) {
                        return new GF2Vector(this.a, a2);
                    }
                    a2[length] = a2[length] ^ this.a[length];
                }
            } else {
                throw new ArithmeticException("length mismatch");
            }
        } else {
            throw new ArithmeticException("vector is not defined over GF(2)");
        }
    }

    public final GF2Vector c(int i) {
        int i2;
        int i3 = this.a;
        if (i > i3) {
            throw new ArithmeticException("invalid length");
        } else if (i == i3) {
            return new GF2Vector(this);
        } else {
            GF2Vector gF2Vector = new GF2Vector(i);
            int i4 = this.a;
            int i5 = (i4 - i) >> 5;
            int i6 = (i4 - i) & 31;
            int i7 = (i + 31) >> 5;
            int i8 = 0;
            int[] iArr = this.a;
            int[] iArr2 = gF2Vector.a;
            if (i6 != 0) {
                while (true) {
                    i2 = i7 - 1;
                    if (i8 >= i2) {
                        break;
                    }
                    int i9 = i5 + 1;
                    iArr2[i8] = (iArr[i5] >>> i6) | (iArr[i9] << (32 - i6));
                    i8++;
                    i5 = i9;
                }
                int i10 = i5 + 1;
                int i11 = iArr[i5] >>> i6;
                iArr2[i2] = i11;
                if (i10 < iArr.length) {
                    iArr2[i2] = (iArr[i10] << (32 - i6)) | i11;
                }
            } else {
                System.arraycopy(iArr, i5, iArr2, 0, i7);
            }
            return gF2Vector;
        }
    }

    public final byte[] d() {
        int i = (this.a + 7) >> 3;
        int[] iArr = this.a;
        int length = iArr.length;
        byte[] bArr = new byte[i];
        int i2 = 0;
        int i3 = 0;
        while (i2 <= length - 2) {
            LittleEndianConversions.a(iArr[i2], bArr, i3);
            i2++;
            i3 += 4;
        }
        int i4 = iArr[length - 1];
        int i5 = i - i3;
        while (true) {
            i5--;
            if (i5 < 0) {
                return bArr;
            }
            bArr[i3 + i5] = (byte) (i4 >>> (i5 * 8));
        }
    }

    public final GF2Vector e(Permutation permutation) {
        int[] a2 = IntUtils.a(permutation.a);
        int i = this.a;
        if (i == a2.length) {
            GF2Vector gF2Vector = new GF2Vector(i);
            for (int i2 = 0; i2 < a2.length; i2++) {
                int i3 = a2[i2];
                if (((1 << (i3 & 31)) & this.a[i3 >> 5]) != 0) {
                    int i4 = i2 >> 5;
                    int[] iArr = gF2Vector.a;
                    iArr[i4] = (1 << (i2 & 31)) | iArr[i4];
                }
            }
            return gF2Vector;
        }
        throw new ArithmeticException("length mismatch");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof GF2Vector)) {
            return false;
        }
        GF2Vector gF2Vector = (GF2Vector) obj;
        if (this.a != gF2Vector.a || !IntUtils.b(this.a, gF2Vector.a)) {
            return false;
        }
        return true;
    }

    public final void f(int i) {
        if (i < this.a) {
            int i2 = i >> 5;
            int[] iArr = this.a;
            iArr[i2] = (1 << (i & 31)) | iArr[i2];
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    public final int hashCode() {
        return this.a.hashCode() + (this.a * 31);
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < this.a; i++) {
            if (i != 0 && (i & 31) == 0) {
                stringBuffer.append(' ');
            }
            if ((this.a[i >> 5] & (1 << (i & 31))) == 0) {
                stringBuffer.append('0');
            } else {
                stringBuffer.append('1');
            }
        }
        return stringBuffer.toString();
    }

    public GF2Vector(int i, SecureRandom secureRandom) {
        this.a = i;
        int i2 = (i + 31) >> 5;
        this.a = new int[i2];
        int i3 = i2 - 1;
        for (int i4 = i3; i4 >= 0; i4--) {
            this.a[i4] = secureRandom.nextInt();
        }
        int i5 = i & 31;
        if (i5 != 0) {
            int[] iArr = this.a;
            iArr[i3] = ((1 << i5) - 1) & iArr[i3];
        }
    }

    public GF2Vector(int i, int i2, SecureRandom secureRandom) {
        if (i2 <= i) {
            this.a = i;
            this.a = new int[((i + 31) >> 5)];
            int[] iArr = new int[i];
            for (int i3 = 0; i3 < i; i3++) {
                iArr[i3] = i3;
            }
            for (int i4 = 0; i4 < i2; i4++) {
                int a2 = RandUtils.a(i, secureRandom);
                f(iArr[a2]);
                i--;
                iArr[a2] = iArr[i];
            }
            return;
        }
        throw new ArithmeticException("The hamming weight is greater than the length of vector.");
    }

    public GF2Vector(int i, int[] iArr) {
        if (i >= 0) {
            this.a = i;
            int i2 = (i + 31) >> 5;
            if (iArr.length == i2) {
                int[] iArr2 = new int[iArr.length];
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                this.a = iArr2;
                int i3 = i & 31;
                if (i3 != 0) {
                    int i4 = i2 - 1;
                    iArr2[i4] = ((1 << i3) - 1) & iArr2[i4];
                    return;
                }
                return;
            }
            throw new ArithmeticException("length mismatch");
        }
        throw new ArithmeticException("negative length");
    }

    public GF2Vector(GF2Vector gF2Vector) {
        this.a = gF2Vector.a;
        this.a = IntUtils.a(gF2Vector.a);
    }

    public GF2Vector(int[] iArr, int i) {
        this.a = iArr;
        this.a = i;
    }
}
