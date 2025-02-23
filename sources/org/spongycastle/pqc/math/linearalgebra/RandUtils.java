package org.spongycastle.pqc.math.linearalgebra;

import java.security.SecureRandom;

public class RandUtils {
    public static int a(int i, SecureRandom secureRandom) {
        int nextInt;
        int i2;
        if (((-i) & i) == i) {
            return (int) ((((long) i) * ((long) (secureRandom.nextInt() >>> 1))) >> 31);
        }
        do {
            nextInt = secureRandom.nextInt() >>> 1;
            i2 = nextInt % i;
        } while ((i - 1) + (nextInt - i2) < 0);
        return i2;
    }
}
