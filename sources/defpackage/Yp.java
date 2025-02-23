package defpackage;

/* renamed from: Yp  reason: default package */
/* compiled from: Preference */
public final class Yp {
    public final Long a;

    /* renamed from: a  reason: collision with other field name */
    public final String f715a;

    public Yp(String str, long j) {
        this.f715a = str;
        this.a = Long.valueOf(j);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Yp)) {
            return false;
        }
        Yp yp = (Yp) obj;
        if (!this.f715a.equals(yp.f715a)) {
            return false;
        }
        Long l = yp.a;
        Long l2 = this.a;
        if (l2 != null) {
            return l2.equals(l);
        }
        if (l == null) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int hashCode = this.f715a.hashCode() * 31;
        Long l = this.a;
        if (l != null) {
            i = l.hashCode();
        } else {
            i = 0;
        }
        return hashCode + i;
    }
}
