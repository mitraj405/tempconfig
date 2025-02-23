package defpackage;

/* renamed from: zw  reason: default package and case insensitive filesystem */
/* compiled from: ShapeTrimPath */
public final class C0430zw implements Z6 {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final H0 f3491a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f3492a;
    public final H0 b;
    public final H0 c;

    public C0430zw(String str, int i, H0 h0, H0 h02, H0 h03, boolean z) {
        this.a = i;
        this.f3491a = h0;
        this.b = h02;
        this.c = h03;
        this.f3492a = z;
    }

    public final V6 a(Ej ej, C0359v2 v2Var) {
        return new MA(v2Var, this);
    }

    public final String toString() {
        return "Trim Path: {start: " + this.f3491a + ", end: " + this.b + ", offset: " + this.c + "}";
    }
}
