package org.spongycastle.pqc.math.linearalgebra;

public abstract class GF2nField {
    public GF2Polynomial a;

    public abstract void a();

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof GF2nField)) {
            return false;
        }
        GF2nField gF2nField = (GF2nField) obj;
        if (!this.a.equals(gF2nField.a)) {
            return false;
        }
        if ((this instanceof GF2nPolynomialField) && !(gF2nField instanceof GF2nPolynomialField)) {
            return false;
        }
        if (!(this instanceof GF2nONBField) || (gF2nField instanceof GF2nONBField)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode() + 0;
    }
}
