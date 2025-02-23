package org.spongycastle.pqc.math.linearalgebra;

import com.google.common.primitives.UnsignedBytes;
import java.math.BigInteger;
import java.security.SecureRandom;

public class Permutation {
    public final int[] a;

    public Permutation(int i) {
        if (i > 0) {
            this.a = new int[i];
            for (int i2 = i - 1; i2 >= 0; i2--) {
                this.a[i2] = i2;
            }
            return;
        }
        throw new IllegalArgumentException("invalid length");
    }

    public final byte[] a() {
        int i;
        int[] iArr = this.a;
        int length = iArr.length;
        int i2 = length - 1;
        BigInteger bigInteger = IntegerFunctions.a;
        if (i2 == 0) {
            i = 1;
        } else {
            if (i2 < 0) {
                i2 = -i2;
            }
            int i3 = 0;
            while (i2 > 0) {
                i3++;
                i2 >>>= 8;
            }
            i = i3;
        }
        byte[] bArr = new byte[((length * i) + 4)];
        LittleEndianConversions.a(length, bArr, 0);
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            int i6 = (i4 * i) + 4;
            int i7 = i;
            while (true) {
                i7--;
                if (i7 < 0) {
                    break;
                }
                bArr[i6 + i7] = (byte) (i5 >>> (i7 * 8));
            }
        }
        return bArr;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Permutation)) {
            return false;
        }
        return IntUtils.b(this.a, ((Permutation) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        int[] iArr = this.a;
        sb.append(iArr[0]);
        String sb2 = sb.toString();
        for (int i = 1; i < iArr.length; i++) {
            StringBuilder n = lf.n(sb2, ", ");
            n.append(iArr[i]);
            sb2 = n.toString();
        }
        return C1058d.z(sb2, "]");
    }

    public Permutation(byte[] bArr) {
        int i;
        if (bArr.length > 4) {
            boolean z = false;
            int b = LittleEndianConversions.b(0, bArr);
            int i2 = b - 1;
            BigInteger bigInteger = IntegerFunctions.a;
            if (i2 == 0) {
                i = 1;
            } else {
                i = 0;
                for (i2 = i2 < 0 ? -i2 : i2; i2 > 0; i2 >>>= 8) {
                    i++;
                }
            }
            if (bArr.length == (b * i) + 4) {
                this.a = new int[b];
                for (int i3 = 0; i3 < b; i3++) {
                    int[] iArr = this.a;
                    int i4 = (i3 * i) + 4;
                    int i5 = 0;
                    for (int i6 = i - 1; i6 >= 0; i6--) {
                        i5 |= (bArr[i4 + i6] & UnsignedBytes.MAX_VALUE) << (i6 * 8);
                    }
                    iArr[i3] = i5;
                }
                int[] iArr2 = this.a;
                int length = iArr2.length;
                boolean[] zArr = new boolean[length];
                int i7 = 0;
                while (true) {
                    if (i7 < length) {
                        int i8 = iArr2[i7];
                        if (i8 < 0 || i8 >= length || zArr[i8]) {
                            break;
                        }
                        zArr[i8] = true;
                        i7++;
                    } else {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    throw new IllegalArgumentException("invalid encoding");
                }
                return;
            }
            throw new IllegalArgumentException("invalid encoding");
        }
        throw new IllegalArgumentException("invalid encoding");
    }

    public Permutation(int i, SecureRandom secureRandom) {
        if (i > 0) {
            this.a = new int[i];
            int[] iArr = new int[i];
            for (int i2 = 0; i2 < i; i2++) {
                iArr[i2] = i2;
            }
            int i3 = i;
            for (int i4 = 0; i4 < i; i4++) {
                int a2 = RandUtils.a(i3, secureRandom);
                i3--;
                this.a[i4] = iArr[a2];
                iArr[a2] = iArr[i3];
            }
            return;
        }
        throw new IllegalArgumentException("invalid length");
    }
}
