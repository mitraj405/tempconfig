package org.spongycastle.math;

import java.math.BigInteger;

public abstract class Primes {
    public static final BigInteger a = BigInteger.valueOf(1);
    public static final BigInteger b = BigInteger.valueOf(2);

    public static class MROutput {
    }

    public static class STOutput {
    }

    static {
        BigInteger.valueOf(3);
    }

    public static void a(BigInteger bigInteger) {
        if (bigInteger.signum() < 1 || bigInteger.bitLength() < 2) {
            throw new IllegalArgumentException("'candidate' must be non-null and >= 2");
        }
    }
}
