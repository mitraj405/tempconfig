package org.spongycastle.pqc.math.linearalgebra;

public class GF2nONBElement extends GF2nElement {
    public final long[] a;

    public GF2nONBElement(GF2nONBElement gF2nONBElement) {
        GF2nField gF2nField = gF2nONBElement.a;
        this.a = gF2nField;
        gF2nField.getClass();
        ((GF2nONBField) this.a).getClass();
        ((GF2nONBField) this.a).getClass();
        long[] jArr = new long[0];
        this.a = jArr;
        long[] jArr2 = gF2nONBElement.a;
        long[] jArr3 = new long[jArr2.length];
        System.arraycopy(jArr2, 0, jArr3, 0, jArr2.length);
        System.arraycopy(jArr3, 0, jArr, 0, 0);
    }

    public final Object clone() {
        return new GF2nONBElement(this);
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof GF2nONBElement)) {
            return false;
        }
        GF2nONBElement gF2nONBElement = (GF2nONBElement) obj;
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        long[] jArr = this.a;
        int length = jArr.length;
        long[] jArr2 = new long[length];
        System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        String str = "";
        for (int i = length - 1; i >= 0; i--) {
            StringBuilder J = xx.J(str);
            J.append(cArr[((int) (jArr2[i] >>> 60)) & 15]);
            StringBuilder J2 = xx.J(J.toString());
            J2.append(cArr[((int) (jArr2[i] >>> 56)) & 15]);
            StringBuilder J3 = xx.J(J2.toString());
            J3.append(cArr[((int) (jArr2[i] >>> 52)) & 15]);
            StringBuilder J4 = xx.J(J3.toString());
            J4.append(cArr[((int) (jArr2[i] >>> 48)) & 15]);
            StringBuilder J5 = xx.J(J4.toString());
            J5.append(cArr[((int) (jArr2[i] >>> 44)) & 15]);
            StringBuilder J6 = xx.J(J5.toString());
            J6.append(cArr[((int) (jArr2[i] >>> 40)) & 15]);
            StringBuilder J7 = xx.J(J6.toString());
            J7.append(cArr[((int) (jArr2[i] >>> 36)) & 15]);
            StringBuilder J8 = xx.J(J7.toString());
            J8.append(cArr[((int) (jArr2[i] >>> 32)) & 15]);
            StringBuilder J9 = xx.J(J8.toString());
            J9.append(cArr[((int) (jArr2[i] >>> 28)) & 15]);
            StringBuilder J10 = xx.J(J9.toString());
            J10.append(cArr[((int) (jArr2[i] >>> 24)) & 15]);
            StringBuilder J11 = xx.J(J10.toString());
            J11.append(cArr[((int) (jArr2[i] >>> 20)) & 15]);
            StringBuilder J12 = xx.J(J11.toString());
            J12.append(cArr[((int) (jArr2[i] >>> 16)) & 15]);
            StringBuilder J13 = xx.J(J12.toString());
            J13.append(cArr[((int) (jArr2[i] >>> 12)) & 15]);
            StringBuilder J14 = xx.J(J13.toString());
            J14.append(cArr[((int) (jArr2[i] >>> 8)) & 15]);
            StringBuilder J15 = xx.J(J14.toString());
            J15.append(cArr[((int) (jArr2[i] >>> 4)) & 15]);
            StringBuilder J16 = xx.J(J15.toString());
            J16.append(cArr[((int) jArr2[i]) & 15]);
            str = C1058d.z(J16.toString(), " ");
        }
        return str;
    }
}
