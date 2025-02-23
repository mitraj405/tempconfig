package org.spongycastle.pqc.math.linearalgebra;

public final class PolynomialRingGF2 {
    private PolynomialRingGF2() {
    }

    public static int a(int i) {
        int i2 = -1;
        while (i != 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    public static int b(int i) {
        if (i < 0) {
            System.err.println("The Degree is negative");
            return 0;
        } else if (i > 31) {
            System.err.println("The Degree is more then 31");
            return 0;
        } else if (i == 0) {
            return 1;
        } else {
            int i2 = 1 << (i + 1);
            for (int i3 = (1 << i) + 1; i3 < i2; i3 += 2) {
                if (c(i3)) {
                    return i3;
                }
            }
            return 0;
        }
    }

    public static boolean c(int i) {
        if (i == 0) {
            return false;
        }
        int a = a(i) >>> 1;
        int i2 = 2;
        for (int i3 = 0; i3 < a; i3++) {
            i2 = d(i2, i2, i);
            int i4 = i2 ^ 2;
            int i5 = i;
            while (i5 != 0) {
                int e = e(i4, i5);
                i4 = i5;
                i5 = e;
            }
            if (i4 != 1) {
                return false;
            }
        }
        return true;
    }

    public static int d(int i, int i2, int i3) {
        int e = e(i, i3);
        int e2 = e(i2, i3);
        int i4 = 0;
        if (e2 != 0) {
            int a = 1 << a(i3);
            while (e != 0) {
                if (((byte) (e & 1)) == 1) {
                    i4 ^= e2;
                }
                e >>>= 1;
                e2 <<= 1;
                if (e2 >= a) {
                    e2 ^= i3;
                }
            }
        }
        return i4;
    }

    public static int e(int i, int i2) {
        if (i2 == 0) {
            System.err.println("Error: to be divided by 0");
            return 0;
        }
        while (a(i) >= a(i2)) {
            i ^= i2 << (a(i) - a(i2));
        }
        return i;
    }
}
