package defpackage;

/* renamed from: ta  reason: default package and case insensitive filesystem */
/* compiled from: JobSupport.kt */
public final class C1402ta implements C0449Af {
    public final boolean a;

    public C1402ta(boolean z) {
        this.a = z;
    }

    public final Rm b() {
        return null;
    }

    public final boolean isActive() {
        return this.a;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Empty{");
        if (this.a) {
            str = "Active";
        } else {
            str = "New";
        }
        sb.append(str);
        sb.append('}');
        return sb.toString();
    }
}
