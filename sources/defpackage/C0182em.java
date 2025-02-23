package defpackage;

import androidx.core.util.Pair;

/* renamed from: em  reason: default package and case insensitive filesystem */
/* compiled from: MutablePair */
public final class C0182em<T> {
    public T a;
    public T b;

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        F f = pair.a;
        T t = this.a;
        if (f == t || (f != null && f.equals(t))) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        T t2 = this.b;
        S s = pair.b;
        if (s == t2 || (s != null && s.equals(t2))) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        T t = this.a;
        int i2 = 0;
        if (t == null) {
            i = 0;
        } else {
            i = t.hashCode();
        }
        T t2 = this.b;
        if (t2 != null) {
            i2 = t2.hashCode();
        }
        return i ^ i2;
    }

    public final String toString() {
        return "Pair{" + this.a + " " + this.b + "}";
    }
}
