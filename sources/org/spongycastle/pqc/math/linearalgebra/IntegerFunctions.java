package org.spongycastle.pqc.math.linearalgebra;

import java.math.BigInteger;

public final class IntegerFunctions {
    public static final BigInteger a = BigInteger.valueOf(0);
    public static final BigInteger b = BigInteger.valueOf(1);

    static {
        BigInteger.valueOf(2);
        BigInteger.valueOf(4);
    }

    private IntegerFunctions() {
    }

    public static BigInteger a(int i, int i2) {
        BigInteger bigInteger = b;
        if (i != 0) {
            if (i2 > (i >>> 1)) {
                i2 = i - i2;
            }
            for (int i3 = 1; i3 <= i2; i3++) {
                bigInteger = bigInteger.multiply(BigInteger.valueOf((long) (i - (i3 - 1)))).divide(BigInteger.valueOf((long) i3));
            }
            return bigInteger;
        } else if (i2 == 0) {
            return bigInteger;
        } else {
            return a;
        }
    }
}
