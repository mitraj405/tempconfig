package org.spongycastle.pqc.math.linearalgebra;

public class GF2nPolynomial {
    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof GF2nPolynomial)) {
            return false;
        }
        GF2nPolynomial gF2nPolynomial = (GF2nPolynomial) obj;
        return true;
    }

    public final int hashCode() {
        throw null;
    }
}
