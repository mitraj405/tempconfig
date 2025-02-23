package androidx.core.util;

import java.util.Objects;

public final class Pair<F, S> {
    public final F a;
    public final S b;

    public Pair(F f, S s) {
        this.a = f;
        this.b = s;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        if (!Objects.equals(pair.a, this.a) || !Objects.equals(pair.b, this.b)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i;
        int i2 = 0;
        F f = this.a;
        if (f == null) {
            i = 0;
        } else {
            i = f.hashCode();
        }
        S s = this.b;
        if (s != null) {
            i2 = s.hashCode();
        }
        return i2 ^ i;
    }

    public final String toString() {
        return "Pair{" + this.a + " " + this.b + "}";
    }
}
