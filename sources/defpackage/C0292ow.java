package defpackage;

import android.graphics.Path;

/* renamed from: ow  reason: default package and case insensitive filesystem */
/* compiled from: ShapeFill */
public final class C0292ow implements Z6 {
    public final G0 a;

    /* renamed from: a  reason: collision with other field name */
    public final J0 f3163a;

    /* renamed from: a  reason: collision with other field name */
    public final Path.FillType f3164a;

    /* renamed from: a  reason: collision with other field name */
    public final String f3165a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f3166a;
    public final boolean b;

    public C0292ow(String str, boolean z, Path.FillType fillType, G0 g0, J0 j0, boolean z2) {
        this.f3165a = str;
        this.f3166a = z;
        this.f3164a = fillType;
        this.a = g0;
        this.f3163a = j0;
        this.b = z2;
    }

    public final V6 a(Ej ej, C0359v2 v2Var) {
        return new C0226ic(ej, v2Var, this);
    }

    public final String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f3166a + '}';
    }
}
