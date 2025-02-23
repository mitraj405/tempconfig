package org.spongycastle.pqc.crypto.rainbow;

import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.perf.util.Constants;
import java.lang.reflect.Array;
import java.security.SecureRandom;
import org.spongycastle.pqc.crypto.rainbow.util.GF2Field;
import org.spongycastle.pqc.crypto.rainbow.util.RainbowUtil;
import org.spongycastle.util.Arrays;

public class Layer {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final short[] f6722a;

    /* renamed from: a  reason: collision with other field name */
    public final short[][] f6723a;

    /* renamed from: a  reason: collision with other field name */
    public final short[][][] f6724a;
    public final int b;

    /* renamed from: b  reason: collision with other field name */
    public final short[][][] f6725b;
    public final int c;

    public Layer(byte b2, byte b3, short[][][] sArr, short[][][] sArr2, short[][] sArr3, short[] sArr4) {
        byte b4 = b2 & UnsignedBytes.MAX_VALUE;
        this.a = b4;
        byte b5 = b3 & UnsignedBytes.MAX_VALUE;
        this.b = b5;
        this.c = b5 - b4;
        this.f6724a = sArr;
        this.f6725b = sArr2;
        this.f6723a = sArr3;
        this.f6722a = sArr4;
    }

    public final short[][] a(short[] sArr) {
        int i;
        short[][] sArr2;
        int i2 = this.c;
        int[] iArr = new int[2];
        iArr[1] = i2 + 1;
        iArr[0] = i2;
        short[][] sArr3 = (short[][]) Array.newInstance(Short.TYPE, iArr);
        short[] sArr4 = new short[i2];
        int i3 = 0;
        while (true) {
            i = this.a;
            if (i3 >= i2) {
                break;
            }
            for (int i4 = 0; i4 < i; i4++) {
                for (int i5 = 0; i5 < i; i5++) {
                    sArr4[i3] = (short) (GF2Field.b(GF2Field.b(this.f6725b[i3][i4][i5], sArr[i4]), sArr[i5]) ^ sArr4[i3]);
                }
            }
            i3++;
        }
        for (int i6 = 0; i6 < i2; i6++) {
            for (int i7 = 0; i7 < i2; i7++) {
                for (int i8 = 0; i8 < i; i8++) {
                    short b2 = GF2Field.b(this.f6724a[i6][i7][i8], sArr[i8]);
                    short[] sArr5 = sArr3[i6];
                    sArr5[i7] = (short) (b2 ^ sArr5[i7]);
                }
            }
        }
        int i9 = 0;
        while (true) {
            sArr2 = this.f6723a;
            if (i9 >= i2) {
                break;
            }
            for (int i10 = 0; i10 < i; i10++) {
                sArr4[i9] = (short) (GF2Field.b(sArr2[i9][i10], sArr[i10]) ^ sArr4[i9]);
            }
            i9++;
        }
        for (int i11 = 0; i11 < i2; i11++) {
            for (int i12 = i; i12 < this.b; i12++) {
                short[] sArr6 = sArr3[i11];
                sArr6[i12 - i] = (short) (sArr2[i11][i12] ^ sArr6[i12 - i]);
            }
        }
        for (int i13 = 0; i13 < i2; i13++) {
            sArr4[i13] = (short) (sArr4[i13] ^ this.f6722a[i13]);
        }
        for (int i14 = 0; i14 < i2; i14++) {
            sArr3[i14][i2] = sArr4[i14];
        }
        return sArr3;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == null || !(obj instanceof Layer)) {
            return false;
        }
        Layer layer = (Layer) obj;
        if (this.a != layer.a || this.b != layer.b || this.c != layer.c) {
            return false;
        }
        short[][][] sArr = this.f6724a;
        int length = sArr.length;
        short[][][] sArr2 = layer.f6724a;
        if (length != sArr2.length) {
            z = false;
        } else {
            z = true;
            for (int length2 = sArr.length - 1; length2 >= 0; length2--) {
                z &= RainbowUtil.h(sArr[length2], sArr2[length2]);
            }
        }
        if (!z) {
            return false;
        }
        short[][][] sArr3 = this.f6725b;
        int length3 = sArr3.length;
        short[][][] sArr4 = layer.f6725b;
        if (length3 != sArr4.length) {
            z2 = false;
        } else {
            z2 = true;
            for (int length4 = sArr3.length - 1; length4 >= 0; length4--) {
                z2 &= RainbowUtil.h(sArr3[length4], sArr4[length4]);
            }
        }
        if (!z2 || !RainbowUtil.h(this.f6723a, layer.f6723a) || !RainbowUtil.g(this.f6722a, layer.f6722a)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i = ((((this.a * 37) + this.b) * 37) + this.c) * 37;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            short[][][] sArr = this.f6724a;
            if (i3 == sArr.length) {
                break;
            }
            i4 = (i4 * 257) + Arrays.x(sArr[i3]);
            i3++;
        }
        int i5 = (i4 + i) * 37;
        int i6 = 0;
        while (true) {
            short[][][] sArr2 = this.f6725b;
            if (i2 != sArr2.length) {
                i6 = (i6 * 257) + Arrays.x(sArr2[i2]);
                i2++;
            } else {
                return Arrays.w(this.f6722a) + ((Arrays.x(this.f6723a) + ((i6 + i5) * 37)) * 37);
            }
        }
    }

    public Layer(int i, int i2, SecureRandom secureRandom) {
        this.a = i;
        this.b = i2;
        int i3 = i2 - i;
        this.c = i3;
        int[] iArr = new int[3];
        iArr[2] = i;
        iArr[1] = i3;
        iArr[0] = i3;
        this.f6724a = (short[][][]) Array.newInstance(Short.TYPE, iArr);
        int[] iArr2 = new int[3];
        iArr2[2] = i;
        iArr2[1] = i;
        iArr2[0] = i3;
        this.f6725b = (short[][][]) Array.newInstance(Short.TYPE, iArr2);
        int[] iArr3 = new int[2];
        iArr3[1] = i2;
        iArr3[0] = i3;
        this.f6723a = (short[][]) Array.newInstance(Short.TYPE, iArr3);
        this.f6722a = new short[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            for (int i5 = 0; i5 < this.c; i5++) {
                for (int i6 = 0; i6 < this.a; i6++) {
                    this.f6724a[i4][i5][i6] = (short) (secureRandom.nextInt() & Constants.MAX_HOST_LENGTH);
                }
            }
        }
        for (int i7 = 0; i7 < i3; i7++) {
            for (int i8 = 0; i8 < this.a; i8++) {
                for (int i9 = 0; i9 < this.a; i9++) {
                    this.f6725b[i7][i8][i9] = (short) (secureRandom.nextInt() & Constants.MAX_HOST_LENGTH);
                }
            }
        }
        for (int i10 = 0; i10 < i3; i10++) {
            for (int i11 = 0; i11 < this.b; i11++) {
                this.f6723a[i10][i11] = (short) (secureRandom.nextInt() & Constants.MAX_HOST_LENGTH);
            }
        }
        for (int i12 = 0; i12 < i3; i12++) {
            this.f6722a[i12] = (short) (secureRandom.nextInt() & Constants.MAX_HOST_LENGTH);
        }
    }
}
