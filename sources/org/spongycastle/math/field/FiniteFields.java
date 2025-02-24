package org.spongycastle.math.field;

import java.math.BigInteger;

public abstract class FiniteFields {
    public static final FiniteField a = new PrimeField(BigInteger.valueOf(2));
    public static final FiniteField b = new PrimeField(BigInteger.valueOf(3));

    public static PolynomialExtensionField a(int[] iArr) {
        if (iArr[0] == 0) {
            int i = 1;
            while (i < iArr.length) {
                if (iArr[i] > iArr[i - 1]) {
                    i++;
                } else {
                    throw new IllegalArgumentException("Polynomial exponents must be montonically increasing");
                }
            }
            return new GenericPolynomialExtensionField(a, new GF2Polynomial(iArr));
        }
        throw new IllegalArgumentException("Irreducible polynomials in GF(2) must have constant term");
    }

    public static FiniteField b(BigInteger bigInteger) {
        int bitLength = bigInteger.bitLength();
        if (bigInteger.signum() <= 0 || bitLength < 2) {
            throw new IllegalArgumentException("'characteristic' must be >= 2");
        }
        if (bitLength < 3) {
            int intValue = bigInteger.intValue();
            if (intValue == 2) {
                return a;
            }
            if (intValue == 3) {
                return b;
            }
        }
        return new PrimeField(bigInteger);
    }
}
