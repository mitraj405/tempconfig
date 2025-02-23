package defpackage;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import defpackage.C0335t2;
import java.util.ArrayList;
import java.util.List;

/* renamed from: Fs  reason: default package */
/* compiled from: RectangleContent */
public final class Fs implements C0335t2.a, C0381wh, dp {
    public final Ej a;

    /* renamed from: a  reason: collision with other field name */
    public final C0093Gc f213a;

    /* renamed from: a  reason: collision with other field name */
    public final Path f214a = new Path();

    /* renamed from: a  reason: collision with other field name */
    public final RectF f215a = new RectF();

    /* renamed from: a  reason: collision with other field name */
    public final String f216a;

    /* renamed from: a  reason: collision with other field name */
    public final C0335t2<?, PointF> f217a;

    /* renamed from: a  reason: collision with other field name */
    public final C0422zD f218a = new C0422zD();

    /* renamed from: a  reason: collision with other field name */
    public final boolean f219a;
    public final C0335t2<?, PointF> b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f220b;
    public C0335t2<Float, Float> c = null;

    public Fs(Ej ej, C0359v2 v2Var, Gs gs) {
        this.f216a = gs.f236a;
        this.f219a = gs.f237a;
        this.a = ej;
        C0335t2<PointF, PointF> b2 = gs.f235a.b();
        this.f217a = b2;
        C0335t2<PointF, PointF> b3 = gs.b.b();
        this.b = b3;
        C0335t2<Float, Float> b4 = gs.a.b();
        this.f213a = (C0093Gc) b4;
        v2Var.g(b2);
        v2Var.g(b3);
        v2Var.g(b4);
        b2.a(this);
        b3.a(this);
        b4.a(this);
    }

    public final Path b() {
        float f;
        C0335t2<Float, Float> t2Var;
        boolean z = this.f220b;
        Path path = this.f214a;
        if (z) {
            return path;
        }
        path.reset();
        if (this.f219a) {
            this.f220b = true;
            return path;
        }
        PointF f2 = this.b.f();
        float f3 = f2.x / 2.0f;
        float f4 = f2.y / 2.0f;
        C0093Gc gc = this.f213a;
        if (gc == null) {
            f = 0.0f;
        } else {
            f = gc.l();
        }
        if (f == 0.0f && (t2Var = this.c) != null) {
            f = Math.min(t2Var.f().floatValue(), Math.min(f3, f4));
        }
        float min = Math.min(f3, f4);
        if (f > min) {
            f = min;
        }
        PointF f5 = this.f217a.f();
        path.moveTo(f5.x + f3, (f5.y - f4) + f);
        path.lineTo(f5.x + f3, (f5.y + f4) - f);
        int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
        RectF rectF = this.f215a;
        if (i > 0) {
            float f6 = f5.x + f3;
            float f7 = f * 2.0f;
            float f8 = f5.y + f4;
            rectF.set(f6 - f7, f8 - f7, f6, f8);
            path.arcTo(rectF, 0.0f, 90.0f, false);
        }
        path.lineTo((f5.x - f3) + f, f5.y + f4);
        if (i > 0) {
            float f9 = f5.x - f3;
            float f10 = f5.y + f4;
            float f11 = f * 2.0f;
            rectF.set(f9, f10 - f11, f11 + f9, f10);
            path.arcTo(rectF, 90.0f, 90.0f, false);
        }
        path.lineTo(f5.x - f3, (f5.y - f4) + f);
        if (i > 0) {
            float f12 = f5.x - f3;
            float f13 = f5.y - f4;
            float f14 = f * 2.0f;
            rectF.set(f12, f13, f12 + f14, f14 + f13);
            path.arcTo(rectF, 180.0f, 90.0f, false);
        }
        path.lineTo((f5.x + f3) - f, f5.y - f4);
        if (i > 0) {
            float f15 = f5.x + f3;
            float f16 = f * 2.0f;
            float f17 = f5.y - f4;
            rectF.set(f15 - f16, f17, f15, f16 + f17);
            path.arcTo(rectF, 270.0f, 90.0f, false);
        }
        path.close();
        this.f218a.b(path);
        this.f220b = true;
        return path;
    }

    public final void d(List<V6> list, List<V6> list2) {
        int i = 0;
        while (true) {
            ArrayList arrayList = (ArrayList) list;
            if (i < arrayList.size()) {
                V6 v6 = (V6) arrayList.get(i);
                if (v6 instanceof MA) {
                    MA ma = (MA) v6;
                    if (ma.a == 1) {
                        ((List) this.f218a.f3457a).add(ma);
                        ma.e(this);
                        i++;
                    }
                }
                if (v6 instanceof C0232iu) {
                    this.c = ((C0232iu) v6).f3022a;
                }
                i++;
            } else {
                return;
            }
        }
    }

    public final void e(C0344tk tkVar, Object obj) {
        if (obj == Kj.d) {
            this.b.k(tkVar);
        } else if (obj == Kj.e) {
            this.f217a.k(tkVar);
        } else if (obj == Kj.f363d) {
            this.f213a.k(tkVar);
        }
    }

    public final void f() {
        this.f220b = false;
        this.a.invalidateSelf();
    }

    public final String getName() {
        return this.f216a;
    }

    public final void i(uh uhVar, int i, ArrayList arrayList, uh uhVar2) {
        C0308ql.d(uhVar, i, arrayList, uhVar2, this);
    }
}
