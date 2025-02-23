package org.spongycastle.pqc.crypto.mceliece;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
import org.spongycastle.pqc.math.linearalgebra.GF2mField;
import org.spongycastle.pqc.math.linearalgebra.GoppaCode;
import org.spongycastle.pqc.math.linearalgebra.IntUtils;
import org.spongycastle.pqc.math.linearalgebra.Permutation;
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;
import org.spongycastle.pqc.math.linearalgebra.PolynomialRingGF2m;

public class McElieceKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public SecureRandom f6687a;

    /* renamed from: a  reason: collision with other field name */
    public McElieceKeyGenerationParameters f6688a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6689a = false;
    public int b;
    public int c;
    public int d;

    public final AsymmetricCipherKeyPair a() {
        boolean z;
        if (!this.f6689a) {
            b(new McElieceKeyGenerationParameters(new SecureRandom(), new McElieceParameters()));
        }
        GF2mField gF2mField = new GF2mField(this.a, this.d);
        PolynomialGF2mSmallM polynomialGF2mSmallM = new PolynomialGF2mSmallM(gF2mField, this.c, this.f6687a);
        new PolynomialRingGF2m(gF2mField, polynomialGF2mSmallM);
        GoppaCode.MaMaPe a2 = GoppaCode.a(GoppaCode.b(gF2mField, polynomialGF2mSmallM), this.f6687a);
        Permutation permutation = a2.f6850a;
        GF2Matrix c2 = a2.a.c();
        int i = c2.b;
        int i2 = c2.a;
        GF2Matrix gF2Matrix = new GF2Matrix(i2, i + i2);
        int i3 = c2.a;
        int i4 = (i3 - 1) + c2.b;
        int i5 = i3 - 1;
        while (true) {
            z = false;
            if (i5 < 0) {
                break;
            }
            System.arraycopy(c2.a[i5], 0, gF2Matrix.a[i5], 0, c2.c);
            int[] iArr = gF2Matrix.a[i5];
            int i6 = i4 >> 5;
            iArr[i6] = iArr[i6] | (1 << (i4 & 31));
            i5--;
            i4--;
        }
        int i7 = c2.a;
        SecureRandom secureRandom = this.f6687a;
        GF2Matrix[] gF2MatrixArr = new GF2Matrix[2];
        int i8 = (i7 + 31) >> 5;
        GF2Matrix gF2Matrix2 = new GF2Matrix(i7, 'L', secureRandom);
        GF2Matrix gF2Matrix3 = new GF2Matrix(i7, 'U', secureRandom);
        GF2Matrix f = gF2Matrix2.f(gF2Matrix3);
        Permutation permutation2 = new Permutation(i7, secureRandom);
        int[] a3 = IntUtils.a(permutation2.a);
        int[] iArr2 = new int[2];
        iArr2[1] = i8;
        iArr2[0] = i7;
        int[][] iArr3 = (int[][]) Array.newInstance(Integer.TYPE, iArr2);
        int i9 = 0;
        while (i9 < i7) {
            System.arraycopy(f.a[a3[i9]], 0, iArr3[i9], 0, i8);
            i9++;
            z = false;
            a3 = a3;
            f = f;
        }
        gF2MatrixArr[z] = new GF2Matrix(i7, iArr3);
        GF2Matrix gF2Matrix4 = new GF2Matrix(i7);
        int i10 = 0;
        while (i10 < i7) {
            int i11 = i10 >>> 5;
            int i12 = 1 << (i10 & 31);
            int i13 = i10 + 1;
            int i14 = i13;
            while (i13 < i7) {
                Permutation permutation3 = permutation;
                if ((gF2Matrix2.a[i13][i11] & i12) != 0) {
                    int i15 = 0;
                    while (i15 <= i11) {
                        int i16 = i12;
                        int[][] iArr4 = gF2Matrix4.a;
                        int[] iArr5 = iArr4[i13];
                        iArr5[i15] = iArr5[i15] ^ iArr4[i10][i15];
                        i15++;
                        i12 = i16;
                    }
                }
                i13++;
                permutation = permutation3;
                i12 = i12;
            }
            i10 = i14;
        }
        Permutation permutation4 = permutation;
        GF2Matrix gF2Matrix5 = new GF2Matrix(i7);
        int i17 = i7 - 1;
        while (i17 >= 0) {
            int i18 = i17 >>> 5;
            int i19 = 1 << (i17 & 31);
            int i20 = i17 - 1;
            int i21 = i20;
            while (i21 >= 0) {
                int i22 = i20;
                if ((gF2Matrix3.a[i21][i18] & i19) != 0) {
                    int i23 = i18;
                    while (i23 < i8) {
                        int i24 = i19;
                        int[][] iArr6 = gF2Matrix5.a;
                        int[] iArr7 = iArr6[i21];
                        iArr7[i23] = iArr6[i17][i23] ^ iArr7[i23];
                        i23++;
                        i19 = i24;
                    }
                }
                i21--;
                i20 = i22;
                i19 = i19;
            }
            i17 = i20;
        }
        gF2MatrixArr[1] = gF2Matrix5.f(gF2Matrix4.g(permutation2));
        Permutation permutation5 = new Permutation(this.b, this.f6687a);
        return new AsymmetricCipherKeyPair(new McEliecePublicKeyParameters(this.b, this.c, gF2MatrixArr[0].f(gF2Matrix).g(permutation5)), new McEliecePrivateKeyParameters(this.b, i7, gF2mField, polynomialGF2mSmallM, permutation4, permutation5, gF2MatrixArr[1]));
    }

    public final void b(KeyGenerationParameters keyGenerationParameters) {
        this.f6688a = (McElieceKeyGenerationParameters) keyGenerationParameters;
        this.f6687a = new SecureRandom();
        McElieceParameters mcElieceParameters = this.f6688a.a;
        this.a = mcElieceParameters.c;
        this.b = mcElieceParameters.e;
        this.c = mcElieceParameters.d;
        this.d = mcElieceParameters.f;
        this.f6689a = true;
    }
}
