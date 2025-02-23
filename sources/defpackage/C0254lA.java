package defpackage;

/* renamed from: lA  reason: default package and case insensitive filesystem */
/* compiled from: Topic.kt */
public final class C0254lA {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final long f3079a;
    public final long b;

    public C0254lA(long j, long j2, int i) {
        this.f3079a = j;
        this.b = j2;
        this.a = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0254lA)) {
            return false;
        }
        C0254lA lAVar = (C0254lA) obj;
        if (this.f3079a == lAVar.f3079a && this.b == lAVar.b && this.a == lAVar.a) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = Long.hashCode(this.b);
        return Integer.hashCode(this.a) + ((hashCode + (Long.hashCode(this.f3079a) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TaxonomyVersion=");
        sb.append(this.f3079a);
        sb.append(", ModelVersion=");
        sb.append(this.b);
        sb.append(", TopicCode=");
        return C0709Uj.i("Topic { ", lf.k(sb, this.a, " }"));
    }
}
