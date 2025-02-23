package defpackage;

/* renamed from: xo  reason: default package and case insensitive filesystem */
/* compiled from: PackageReference.kt */
public final class C1482xo implements C1274n5 {
    public final Class<?> a;

    public C1482xo(Class cls) {
        C1177ig.f(cls, "jClass");
        this.a = cls;
    }

    public final Class<?> a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1482xo) {
            if (C1177ig.a(this.a, ((C1482xo) obj).a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return this.a.toString() + " (Kotlin reflection is not available)";
    }
}
