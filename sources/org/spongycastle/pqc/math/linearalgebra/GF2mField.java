package org.spongycastle.pqc.math.linearalgebra;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.security.SecureRandom;

public class GF2mField {
    public final int a = 0;
    public final int b;

    public GF2mField(int i, int i2) {
        if (i != PolynomialRingGF2.a(i2)) {
            throw new IllegalArgumentException(" Error: the degree is not correct");
        } else if (PolynomialRingGF2.c(i2)) {
            this.a = i;
            this.b = i2;
        } else {
            throw new IllegalArgumentException(" Error: given polynomial is reducible");
        }
    }

    public final int a(SecureRandom secureRandom) {
        int i = this.a;
        int a2 = RandUtils.a(1 << i, secureRandom);
        int i2 = 0;
        while (a2 == 0 && i2 < 1048576) {
            a2 = RandUtils.a(1 << i, secureRandom);
            i2++;
        }
        if (i2 == 1048576) {
            return 1;
        }
        return a2;
    }

    public final int b(int i) {
        int i2 = (1 << this.a) - 2;
        if (i2 == 0) {
            return 1;
        }
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        if (i2 < 0) {
            i = b(i);
            i2 = -i2;
        }
        int i3 = 1;
        while (i2 != 0) {
            if ((i2 & 1) == 1) {
                i3 = d(i3, i);
            }
            i = d(i, i);
            i2 >>>= 1;
        }
        return i3;
    }

    public final boolean c(int i) {
        int i2 = this.a;
        if (i2 == 31) {
            if (i >= 0) {
                return true;
            }
            return false;
        } else if (i < 0 || i >= (1 << i2)) {
            return false;
        } else {
            return true;
        }
    }

    public final int d(int i, int i2) {
        return PolynomialRingGF2.d(i, i2, this.b);
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof GF2mField)) {
            GF2mField gF2mField = (GF2mField) obj;
            if (this.a == gF2mField.a && this.b == gF2mField.b) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return this.b;
    }

    public final String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder("Finite Field GF(2^");
        sb.append(this.a);
        sb.append(") = GF(2)[X]/<");
        int i = this.b;
        if (i == 0) {
            str = "0";
        } else {
            if (((byte) (i & 1)) == 1) {
                str2 = C0515Ga.AVLBLTY_ONLY;
            } else {
                str2 = "";
            }
            int i2 = i >>> 1;
            int i3 = 1;
            while (i2 != 0) {
                if (((byte) (i2 & 1)) == 1) {
                    str2 = str2 + "+x^" + i3;
                }
                i2 >>>= 1;
                i3++;
            }
            str = str2;
        }
        return C0709Uj.j(sb, str, "> ");
    }

    public GF2mField(byte[] bArr) {
        if (bArr.length == 4) {
            byte b2 = ((bArr[3] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | (bArr[0] & UnsignedBytes.MAX_VALUE) | ((bArr[1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[2] & UnsignedBytes.MAX_VALUE) << Ascii.DLE);
            this.b = b2;
            if (PolynomialRingGF2.c(b2)) {
                this.a = PolynomialRingGF2.a(b2);
                return;
            }
            throw new IllegalArgumentException("byte array is not an encoded finite field");
        }
        throw new IllegalArgumentException("byte array is not an encoded finite field");
    }
}
