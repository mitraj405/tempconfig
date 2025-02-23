package defpackage;

/* renamed from: s0  reason: default package and case insensitive filesystem */
/* compiled from: AlgorithmInfo */
public abstract class C1379s0 implements C1271n0 {
    public final Bi a = C0473Ci.d(getClass());

    /* renamed from: a  reason: collision with other field name */
    public String f6950a;
    public String b;

    public final String e() {
        return this.f6950a;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append("(");
        sb.append(this.f6950a);
        sb.append("|");
        return C0709Uj.j(sb, this.b, ")");
    }
}
