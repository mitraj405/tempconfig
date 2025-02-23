package defpackage;

/* renamed from: me  reason: default package and case insensitive filesystem */
/* compiled from: GetTopicsRequest.kt */
public final class C0272me {
    public final String a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f3101a;

    /* renamed from: me$a */
    /* compiled from: GetTopicsRequest.kt */
    public static final class a {
    }

    public C0272me() {
        this("", false);
    }

    public final String a() {
        return this.a;
    }

    public final boolean b() {
        return this.f3101a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0272me)) {
            return false;
        }
        C0272me meVar = (C0272me) obj;
        if (!C1177ig.a(this.a, meVar.a) || this.f3101a != meVar.f3101a) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f3101a) + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "GetTopicsRequest: adsSdkName=" + this.a + ", shouldRecordObservation=" + this.f3101a;
    }

    public C0272me(String str, boolean z) {
        C1177ig.f(str, "adsSdkName");
        this.a = str;
        this.f3101a = z;
    }
}
