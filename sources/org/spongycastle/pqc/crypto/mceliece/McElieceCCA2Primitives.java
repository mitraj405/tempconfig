package org.spongycastle.pqc.crypto.mceliece;

import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
import org.spongycastle.pqc.math.linearalgebra.GF2Vector;
import org.spongycastle.pqc.math.linearalgebra.GoppaCode;
import org.spongycastle.pqc.math.linearalgebra.Permutation;

final class McElieceCCA2Primitives {
    private McElieceCCA2Primitives() {
    }

    public static GF2Vector[] a(McElieceCCA2PrivateKeyParameters mcElieceCCA2PrivateKeyParameters, GF2Vector gF2Vector) {
        int i = mcElieceCCA2PrivateKeyParameters.d;
        Permutation permutation = mcElieceCCA2PrivateKeyParameters.f6677a;
        int[] iArr = permutation.a;
        Permutation permutation2 = new Permutation(iArr.length);
        int length = iArr.length;
        while (true) {
            length--;
            if (length >= 0) {
                permutation2.a[iArr[length]] = length;
            } else {
                GF2Vector e = gF2Vector.e(permutation2);
                GF2Vector c = GoppaCode.c(mcElieceCCA2PrivateKeyParameters.a.h(e), mcElieceCCA2PrivateKeyParameters.f6676a, mcElieceCCA2PrivateKeyParameters.f6678a, mcElieceCCA2PrivateKeyParameters.f6679a);
                GF2Vector e2 = ((GF2Vector) e.b(c)).e(permutation);
                return new GF2Vector[]{e2.c(i), c.e(permutation)};
            }
        }
    }

    public static GF2Vector b(McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters, GF2Vector gF2Vector, GF2Vector gF2Vector2) {
        int[] iArr;
        GF2Matrix gF2Matrix = mcElieceCCA2PublicKeyParameters.a;
        gF2Matrix.getClass();
        int i = gF2Vector.a;
        int i2 = gF2Matrix.a;
        if (i == i2) {
            int[] iArr2 = new int[(((gF2Matrix.b + i2) + 31) >>> 5)];
            int i3 = i2 >>> 5;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                iArr = gF2Vector.a;
                if (i4 >= i3) {
                    break;
                }
                int i6 = 1;
                do {
                    if ((iArr[i4] & i6) != 0) {
                        for (int i7 = 0; i7 < gF2Matrix.c; i7++) {
                            iArr2[i7] = iArr2[i7] ^ gF2Matrix.a[i5][i7];
                        }
                        int i8 = gF2Matrix.b + i5;
                        int i9 = i8 >>> 5;
                        iArr2[i9] = (1 << (i8 & 31)) | iArr2[i9];
                    }
                    i5++;
                    i6 <<= 1;
                } while (i6 != 0);
                i4++;
            }
            int i10 = 1 << (gF2Matrix.a & 31);
            for (int i11 = 1; i11 != i10; i11 <<= 1) {
                if ((iArr[i3] & i11) != 0) {
                    for (int i12 = 0; i12 < gF2Matrix.c; i12++) {
                        iArr2[i12] = iArr2[i12] ^ gF2Matrix.a[i5][i12];
                    }
                    int i13 = gF2Matrix.b + i5;
                    int i14 = i13 >>> 5;
                    iArr2[i14] = (1 << (i13 & 31)) | iArr2[i14];
                }
                i5++;
            }
            return (GF2Vector) new GF2Vector(iArr2, gF2Matrix.a + gF2Matrix.b).b(gF2Vector2);
        }
        throw new ArithmeticException("length mismatch");
    }
}
