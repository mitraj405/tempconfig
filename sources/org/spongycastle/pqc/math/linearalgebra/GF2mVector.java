package org.spongycastle.pqc.math.linearalgebra;

public class GF2mVector extends Vector {
    public final GF2mField a;

    /* renamed from: a  reason: collision with other field name */
    public final int[] f6849a;

    public GF2mVector(GF2mField gF2mField, int[] iArr) {
        this.a = gF2mField;
        this.a = iArr.length;
        int length = iArr.length;
        do {
            length--;
            if (length < 0) {
                int[] iArr2 = new int[iArr.length];
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                this.f6849a = iArr2;
                return;
            }
        } while (gF2mField.c(iArr[length]));
        throw new ArithmeticException("Element array is not specified over the given finite field.");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof GF2mVector)) {
            return false;
        }
        GF2mVector gF2mVector = (GF2mVector) obj;
        if (!this.a.equals(gF2mVector.a)) {
            return false;
        }
        return IntUtils.b(this.f6849a, gF2mVector.f6849a);
    }

    public final int hashCode() {
        return this.f6849a.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int[] iArr = this.f6849a;
            if (i >= iArr.length) {
                return stringBuffer.toString();
            }
            for (int i2 = 0; i2 < this.a.a; i2++) {
                if (((1 << (i2 & 31)) & iArr[i]) != 0) {
                    stringBuffer.append('1');
                } else {
                    stringBuffer.append('0');
                }
            }
            stringBuffer.append(' ');
            i++;
        }
    }
}
