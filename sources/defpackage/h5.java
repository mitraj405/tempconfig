package defpackage;

import android.graphics.PointF;

/* renamed from: h5  reason: default package */
/* compiled from: CircleShape */
public final class h5 implements Z6 {
    public final G0 a;

    /* renamed from: a  reason: collision with other field name */
    public final R0<PointF, PointF> f2983a;

    /* renamed from: a  reason: collision with other field name */
    public final String f2984a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f2985a;
    public final boolean b;

    public h5(String str, R0<PointF, PointF> r0, G0 g0, boolean z, boolean z2) {
        this.f2984a = str;
        this.f2983a = r0;
        this.a = g0;
        this.f2985a = z;
        this.b = z2;
    }

    public final V6 a(Ej ej, C0359v2 v2Var) {
        return new C0193fa(ej, v2Var, this);
    }
}
