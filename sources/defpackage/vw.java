package defpackage;

/* renamed from: vw  reason: default package */
/* compiled from: ShapePath */
public final class vw implements Z6 {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final J0 f3385a;

    /* renamed from: a  reason: collision with other field name */
    public final String f3386a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f3387a;

    public vw(String str, int i, J0 j0, boolean z) {
        this.f3386a = str;
        this.a = i;
        this.f3385a = j0;
        this.f3387a = z;
    }

    public final V6 a(Ej ej, C0359v2 v2Var) {
        return new C0264lw(ej, v2Var, this);
    }

    public final String toString() {
        return "ShapePath{name=" + this.f3386a + ", index=" + this.a + '}';
    }
}
