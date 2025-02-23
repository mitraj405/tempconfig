package org.spongycastle.math.field;

import org.spongycastle.util.Arrays;

class GF2Polynomial implements Polynomial {
    public final int[] a;

    public GF2Polynomial(int[] iArr) {
        this.a = Arrays.d(iArr);
    }

    public final int[] a() {
        return Arrays.d(this.a);
    }

    public final int b() {
        int[] iArr = this.a;
        return iArr[iArr.length - 1];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GF2Polynomial)) {
            return false;
        }
        return Arrays.b(this.a, ((GF2Polynomial) obj).a);
    }

    public final int hashCode() {
        return Arrays.u(this.a);
    }
}
