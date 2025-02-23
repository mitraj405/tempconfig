package kotlin;

import java.io.Serializable;

/* compiled from: Tuples.kt */
public final class Pair<A, B> implements Serializable {
    public final A a;
    public final B b;

    public Pair(A a2, B b2) {
        this.a = a2;
        this.b = b2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        if (C1177ig.a(this.a, pair.a) && C1177ig.a(this.b, pair.b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int i2 = 0;
        A a2 = this.a;
        if (a2 == null) {
            i = 0;
        } else {
            i = a2.hashCode();
        }
        int i3 = i * 31;
        B b2 = this.b;
        if (b2 != null) {
            i2 = b2.hashCode();
        }
        return i3 + i2;
    }

    public final String toString() {
        return "(" + this.a + ", " + this.b + ')';
    }
}
