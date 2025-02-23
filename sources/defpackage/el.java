package defpackage;

/* renamed from: el  reason: default package */
/* compiled from: MergePaths */
public final class el implements Z6 {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f2910a;

    public el(String str, int i, boolean z) {
        this.a = i;
        this.f2910a = z;
    }

    public final V6 a(Ej ej, C0359v2 v2Var) {
        if (ej.f159d) {
            return new fl(this);
        }
        Ai.b("Animation contains merge paths but they are disabled.");
        return null;
    }

    public final String toString() {
        return "MergePaths{mode=" + C0709Uj.v(this.a) + '}';
    }
}
