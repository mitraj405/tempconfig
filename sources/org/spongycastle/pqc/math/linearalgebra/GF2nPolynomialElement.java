package org.spongycastle.pqc.math.linearalgebra;

public class GF2nPolynomialElement extends GF2nElement {
    public final GF2Polynomial a;

    public GF2nPolynomialElement(GF2nPolynomialElement gF2nPolynomialElement) {
        this.a = gF2nPolynomialElement.a;
        this.a = new GF2Polynomial(gF2nPolynomialElement.a);
    }

    public final Object clone() {
        return new GF2nPolynomialElement(this);
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof GF2nPolynomialElement)) {
            return false;
        }
        GF2nPolynomialElement gF2nPolynomialElement = (GF2nPolynomialElement) obj;
        GF2nField gF2nField = this.a;
        if (gF2nField != gF2nPolynomialElement.a) {
            if (gF2nField.a == null) {
                gF2nField.a();
            }
            GF2Polynomial gF2Polynomial = new GF2Polynomial(gF2nField.a);
            GF2nField gF2nField2 = gF2nPolynomialElement.a;
            if (gF2nField2.a == null) {
                gF2nField2.a();
            }
            if (!gF2Polynomial.equals(new GF2Polynomial(gF2nField2.a))) {
                return false;
            }
        }
        return this.a.equals(gF2nPolynomialElement.a);
    }

    public final int hashCode() {
        return this.a.hashCode() + this.a.hashCode();
    }

    public final String toString() {
        GF2Polynomial gF2Polynomial = this.a;
        gF2Polynomial.getClass();
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        String str = new String();
        int i = gF2Polynomial.f6848b;
        while (true) {
            i--;
            if (i < 0) {
                return str;
            }
            StringBuilder J = xx.J(str);
            J.append(cArr[(gF2Polynomial.f6847a[i] >>> 28) & 15]);
            StringBuilder J2 = xx.J(J.toString());
            J2.append(cArr[(gF2Polynomial.f6847a[i] >>> 24) & 15]);
            StringBuilder J3 = xx.J(J2.toString());
            J3.append(cArr[(gF2Polynomial.f6847a[i] >>> 20) & 15]);
            StringBuilder J4 = xx.J(J3.toString());
            J4.append(cArr[(gF2Polynomial.f6847a[i] >>> 16) & 15]);
            StringBuilder J5 = xx.J(J4.toString());
            J5.append(cArr[(gF2Polynomial.f6847a[i] >>> 12) & 15]);
            StringBuilder J6 = xx.J(J5.toString());
            J6.append(cArr[(gF2Polynomial.f6847a[i] >>> 8) & 15]);
            StringBuilder J7 = xx.J(J6.toString());
            J7.append(cArr[(gF2Polynomial.f6847a[i] >>> 4) & 15]);
            StringBuilder J8 = xx.J(J7.toString());
            J8.append(cArr[gF2Polynomial.f6847a[i] & 15]);
            str = C1058d.z(J8.toString(), " ");
        }
    }
}
