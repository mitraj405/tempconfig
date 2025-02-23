package org.spongycastle.pqc.math.linearalgebra;

public class GF2mMatrix extends Matrix {
    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof GF2mMatrix)) {
            return false;
        }
        GF2mMatrix gF2mMatrix = (GF2mMatrix) obj;
        throw null;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append(" x ");
        sb.append(this.b);
        sb.append(" Matrix over ");
        throw null;
    }
}
