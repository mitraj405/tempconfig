package defpackage;

import android.graphics.PointF;

/* renamed from: Gs  reason: default package */
/* compiled from: RectangleShape */
public final class Gs implements Z6 {
    public final H0 a;

    /* renamed from: a  reason: collision with other field name */
    public final R0<PointF, PointF> f235a;

    /* renamed from: a  reason: collision with other field name */
    public final String f236a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f237a;
    public final R0<PointF, PointF> b;

    public Gs(String str, R0 r0, G0 g0, H0 h0, boolean z) {
        this.f236a = str;
        this.f235a = r0;
        this.b = g0;
        this.a = h0;
        this.f237a = z;
    }

    public final V6 a(Ej ej, C0359v2 v2Var) {
        return new Fs(ej, v2Var, this);
    }

    public final String toString() {
        return "RectangleShape{position=" + this.f235a + ", size=" + this.b + '}';
    }
}
