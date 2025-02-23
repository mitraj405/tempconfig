package org.spongycastle.pqc.crypto.mceliece;

import java.math.BigInteger;
import org.spongycastle.pqc.math.linearalgebra.GF2Vector;
import org.spongycastle.pqc.math.linearalgebra.IntegerFunctions;

final class Conversions {
    public static final BigInteger a = BigInteger.valueOf(0);
    public static final BigInteger b = BigInteger.valueOf(1);

    private Conversions() {
    }

    public static GF2Vector a(int i, byte[] bArr, int i2) {
        if (i >= i2) {
            BigInteger a2 = IntegerFunctions.a(i, i2);
            BigInteger bigInteger = new BigInteger(1, bArr);
            if (bigInteger.compareTo(a2) < 0) {
                GF2Vector gF2Vector = new GF2Vector(i);
                int i3 = i;
                for (int i4 = 0; i4 < i; i4++) {
                    a2 = a2.multiply(BigInteger.valueOf((long) (i3 - i2))).divide(BigInteger.valueOf((long) i3));
                    i3--;
                    if (a2.compareTo(bigInteger) <= 0) {
                        gF2Vector.f(i4);
                        bigInteger = bigInteger.subtract(a2);
                        i2--;
                        if (i3 == i2) {
                            a2 = b;
                        } else {
                            a2 = a2.multiply(BigInteger.valueOf((long) (i2 + 1))).divide(BigInteger.valueOf((long) (i3 - i2)));
                        }
                    }
                }
                return gF2Vector;
            }
            throw new IllegalArgumentException("Encoded number too large.");
        }
        throw new IllegalArgumentException("n < t");
    }
}
