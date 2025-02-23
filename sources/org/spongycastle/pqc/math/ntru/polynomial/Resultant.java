package org.spongycastle.pqc.math.ntru.polynomial;

import java.math.BigInteger;

public class Resultant {
    public final BigIntPolynomial a;

    public Resultant(BigIntPolynomial bigIntPolynomial, BigInteger bigInteger) {
        this.a = bigIntPolynomial;
    }
}
