package defpackage;

import java.util.Arrays;

/* renamed from: Lj  reason: default package */
/* compiled from: LottieResult */
public final class Lj<V> {
    public final V a;

    /* renamed from: a  reason: collision with other field name */
    public final Throwable f387a;

    public Lj(C0181ej ejVar) {
        this.a = ejVar;
        this.f387a = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Lj)) {
            return false;
        }
        Lj lj = (Lj) obj;
        V v = this.a;
        if (v != null && v.equals(lj.a)) {
            return true;
        }
        Throwable th = this.f387a;
        if (th == null || lj.f387a == null) {
            return false;
        }
        return th.toString().equals(th.toString());
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.f387a});
    }

    public Lj(Throwable th) {
        this.f387a = th;
        this.a = null;
    }
}
