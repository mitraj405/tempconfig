package org.spongycastle.pqc.math.ntru.polynomial;

import java.math.BigDecimal;

public class BigDecimalPolynomial {
    public BigDecimal[] a;

    static {
        new BigDecimal("0");
        new BigDecimal("0.5");
    }

    public BigDecimalPolynomial() {
        throw null;
    }

    public BigDecimalPolynomial(BigDecimal[] bigDecimalArr) {
        this.a = bigDecimalArr;
    }

    public final Object clone() {
        return new BigDecimalPolynomial((BigDecimal[]) this.a.clone());
    }
}
