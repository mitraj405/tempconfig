package defpackage;

/* renamed from: V4  reason: default package */
/* compiled from: Channel.kt */
public final class V4<T> {
    public static final b a = new b();

    /* renamed from: a  reason: collision with other field name */
    public final Object f3815a;

    /* renamed from: V4$a */
    /* compiled from: Channel.kt */
    public static final class a extends b {
        public final Throwable a;

        public a(Throwable th) {
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
            Throwable th = this.a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        public final String toString() {
            return "Closed(" + this.a + ')';
        }
    }

    /* renamed from: V4$b */
    /* compiled from: Channel.kt */
    public static class b {
        public String toString() {
            return "Failed";
        }
    }

    public /* synthetic */ V4(Object obj) {
        this.f3815a = obj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof V4)) {
            return false;
        }
        if (!C1177ig.a(this.f3815a, ((V4) obj).f3815a)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        Object obj = this.f3815a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.f3815a;
        if (obj instanceof a) {
            return ((a) obj).toString();
        }
        return "Value(" + obj + ')';
    }
}
