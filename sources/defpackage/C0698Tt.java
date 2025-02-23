package defpackage;

import java.io.Serializable;

/* renamed from: Tt  reason: default package and case insensitive filesystem */
/* compiled from: Result.kt */
public final class C0698Tt<T> implements Serializable {

    /* renamed from: Tt$a */
    /* compiled from: Result.kt */
    public static final class a implements Serializable {
        public final Throwable a;

        public a(Throwable th) {
            C1177ig.f(th, "exception");
            this.a = th;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof a) {
                if (C1177ig.a(this.a, ((a) obj).a)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Failure(" + this.a + ')';
        }
    }

    public static final Throwable a(Object obj) {
        if (obj instanceof a) {
            return ((a) obj).a;
        }
        return null;
    }
}
