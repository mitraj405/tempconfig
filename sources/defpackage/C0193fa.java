package defpackage;

import android.graphics.Path;
import android.graphics.PointF;
import defpackage.C0335t2;
import java.util.ArrayList;
import java.util.List;

/* renamed from: fa  reason: default package and case insensitive filesystem */
/* compiled from: EllipseContent */
public final class C0193fa implements dp, C0335t2.a, C0381wh {
    public final Ch a;

    /* renamed from: a  reason: collision with other field name */
    public final Ej f2930a;

    /* renamed from: a  reason: collision with other field name */
    public final Path f2931a = new Path();

    /* renamed from: a  reason: collision with other field name */
    public final h5 f2932a;

    /* renamed from: a  reason: collision with other field name */
    public final String f2933a;

    /* renamed from: a  reason: collision with other field name */
    public final C0335t2<?, PointF> f2934a;

    /* renamed from: a  reason: collision with other field name */
    public final C0422zD f2935a = new C0422zD();

    /* renamed from: a  reason: collision with other field name */
    public boolean f2936a;

    public C0193fa(Ej ej, C0359v2 v2Var, h5 h5Var) {
        this.f2933a = h5Var.f2984a;
        this.f2930a = ej;
        C0335t2 b = h5Var.a.b();
        this.a = (Ch) b;
        C0335t2<PointF, PointF> b2 = h5Var.f2983a.b();
        this.f2934a = b2;
        this.f2932a = h5Var;
        v2Var.g(b);
        v2Var.g(b2);
        b.a(this);
        b2.a(this);
    }

    public final Path b() {
        boolean z = this.f2936a;
        Path path = this.f2931a;
        if (z) {
            return path;
        }
        path.reset();
        h5 h5Var = this.f2932a;
        if (h5Var.b) {
            this.f2936a = true;
            return path;
        }
        PointF pointF = (PointF) this.a.f();
        float f = pointF.x / 2.0f;
        float f2 = pointF.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = f2 * 0.55228f;
        path.reset();
        if (h5Var.f2985a) {
            float f5 = -f2;
            path.moveTo(0.0f, f5);
            float f6 = 0.0f - f3;
            float f7 = -f;
            float f8 = 0.0f - f4;
            Path path2 = path;
            path2.cubicTo(f6, f5, f7, f8, f7, 0.0f);
            float f9 = f4 + 0.0f;
            path2.cubicTo(f7, f9, f6, f2, 0.0f, f2);
            float f10 = f3 + 0.0f;
            path2.cubicTo(f10, f2, f, f9, f, 0.0f);
            path2.cubicTo(f, f8, f10, f5, 0.0f, f5);
        } else {
            float f11 = -f2;
            path.moveTo(0.0f, f11);
            float f12 = f3 + 0.0f;
            float f13 = 0.0f - f4;
            Path path3 = path;
            path3.cubicTo(f12, f11, f, f13, f, 0.0f);
            float f14 = f4 + 0.0f;
            path3.cubicTo(f, f14, f12, f2, 0.0f, f2);
            float f15 = 0.0f - f3;
            float f16 = -f;
            path3.cubicTo(f15, f2, f16, f14, f16, 0.0f);
            path3.cubicTo(f16, f13, f15, f11, 0.0f, f11);
        }
        PointF f17 = this.f2934a.f();
        path.offset(f17.x, f17.y);
        path.close();
        this.f2935a.b(path);
        this.f2936a = true;
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
                        ((List) this.f2935a.f3457a).add(ma);
                        ma.e(this);
                    }
                }
                i++;
            } else {
                return;
            }
        }
    }

    public final void e(C0344tk tkVar, Object obj) {
        if (obj == Kj.c) {
            this.a.k(tkVar);
        } else if (obj == Kj.e) {
            this.f2934a.k(tkVar);
        }
    }

    public final void f() {
        this.f2936a = false;
        this.f2930a.invalidateSelf();
    }

    public final String getName() {
        return this.f2933a;
    }

    public final void i(uh uhVar, int i, ArrayList arrayList, uh uhVar2) {
        C0308ql.d(uhVar, i, arrayList, uhVar2, this);
    }
}
