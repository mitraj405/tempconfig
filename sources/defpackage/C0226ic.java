package defpackage;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.MaskFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.google.firebase.perf.util.Constants;
import defpackage.C0335t2;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ic  reason: default package and case insensitive filesystem */
/* compiled from: FillContent */
public final class C0226ic implements z9, C0335t2.a, C0381wh {
    public float a;

    /* renamed from: a  reason: collision with other field name */
    public final Ch f3005a;

    /* renamed from: a  reason: collision with other field name */
    public final D9 f3006a;

    /* renamed from: a  reason: collision with other field name */
    public final Ej f3007a;

    /* renamed from: a  reason: collision with other field name */
    public final Lh f3008a = new Lh(1);

    /* renamed from: a  reason: collision with other field name */
    public WB f3009a;

    /* renamed from: a  reason: collision with other field name */
    public final Path f3010a;

    /* renamed from: a  reason: collision with other field name */
    public final String f3011a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList f3012a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    public final C0335t2<Integer, Integer> f3013a;

    /* renamed from: a  reason: collision with other field name */
    public final C0359v2 f3014a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f3015a;
    public C0335t2<Float, Float> b;

    public C0226ic(Ej ej, C0359v2 v2Var, C0292ow owVar) {
        J0 j0;
        Path path = new Path();
        this.f3010a = path;
        this.f3014a = v2Var;
        this.f3011a = owVar.f3165a;
        this.f3015a = owVar.b;
        this.f3007a = ej;
        if (v2Var.m() != null) {
            C0335t2<Float, Float> b2 = ((H0) v2Var.m().a).b();
            this.b = b2;
            b2.a(this);
            v2Var.g(this.b);
        }
        if (v2Var.n() != null) {
            this.f3006a = new D9(this, v2Var, v2Var.n());
        }
        G0 g0 = owVar.a;
        if (g0 == null || (j0 = owVar.f3163a) == null) {
            this.f3005a = null;
            this.f3013a = null;
            return;
        }
        path.setFillType(owVar.f3164a);
        C0335t2 b3 = g0.b();
        this.f3005a = (Ch) b3;
        b3.a(this);
        v2Var.g(b3);
        C0335t2<Integer, Integer> b4 = j0.b();
        this.f3013a = b4;
        b4.a(this);
        v2Var.g(b4);
    }

    public final void a(RectF rectF, Matrix matrix, boolean z) {
        Path path = this.f3010a;
        path.reset();
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f3012a;
            if (i < arrayList.size()) {
                path.addPath(((dp) arrayList.get(i)).b(), matrix);
                i++;
            } else {
                path.computeBounds(rectF, false);
                rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
                return;
            }
        }
    }

    public final void c(Canvas canvas, Matrix matrix, int i) {
        BlurMaskFilter blurMaskFilter;
        if (!this.f3015a) {
            C0400y5 y5Var = (C0400y5) this.f3005a;
            int l = y5Var.l(y5Var.b(), y5Var.d());
            PointF pointF = C0308ql.a;
            int i2 = 0;
            int max = (Math.max(0, Math.min(Constants.MAX_HOST_LENGTH, (int) ((((((float) i) / 255.0f) * ((float) this.f3013a.f().intValue())) / 100.0f) * 255.0f))) << 24) | (l & 16777215);
            Lh lh = this.f3008a;
            lh.setColor(max);
            WB wb = this.f3009a;
            if (wb != null) {
                lh.setColorFilter((ColorFilter) wb.f());
            }
            C0335t2<Float, Float> t2Var = this.b;
            if (t2Var != null) {
                float floatValue = t2Var.f().floatValue();
                if (floatValue == 0.0f) {
                    lh.setMaskFilter((MaskFilter) null);
                } else if (floatValue != this.a) {
                    C0359v2 v2Var = this.f3014a;
                    if (v2Var.a == floatValue) {
                        blurMaskFilter = v2Var.f3346a;
                    } else {
                        BlurMaskFilter blurMaskFilter2 = new BlurMaskFilter(floatValue / 2.0f, BlurMaskFilter.Blur.NORMAL);
                        v2Var.f3346a = blurMaskFilter2;
                        v2Var.a = floatValue;
                        blurMaskFilter = blurMaskFilter2;
                    }
                    lh.setMaskFilter(blurMaskFilter);
                }
                this.a = floatValue;
            }
            D9 d9 = this.f3006a;
            if (d9 != null) {
                d9.a(lh);
            }
            Path path = this.f3010a;
            path.reset();
            while (true) {
                ArrayList arrayList = this.f3012a;
                if (i2 < arrayList.size()) {
                    path.addPath(((dp) arrayList.get(i2)).b(), matrix);
                    i2++;
                } else {
                    canvas.drawPath(path, lh);
                    C1354qp.G();
                    return;
                }
            }
        }
    }

    public final void d(List<V6> list, List<V6> list2) {
        for (int i = 0; i < list2.size(); i++) {
            V6 v6 = list2.get(i);
            if (v6 instanceof dp) {
                this.f3012a.add((dp) v6);
            }
        }
    }

    public final void e(C0344tk tkVar, Object obj) {
        if (obj == Kj.f356a) {
            this.f3005a.k(tkVar);
        } else if (obj == Kj.f364d) {
            this.f3013a.k(tkVar);
        } else {
            ColorFilter colorFilter = Kj.f351a;
            C0359v2 v2Var = this.f3014a;
            if (obj == colorFilter) {
                WB wb = this.f3009a;
                if (wb != null) {
                    v2Var.q(wb);
                }
                if (tkVar == null) {
                    this.f3009a = null;
                    return;
                }
                WB wb2 = new WB(tkVar, null);
                this.f3009a = wb2;
                wb2.a(this);
                v2Var.g(this.f3009a);
            } else if (obj == Kj.f361c) {
                C0335t2<Float, Float> t2Var = this.b;
                if (t2Var != null) {
                    t2Var.k(tkVar);
                    return;
                }
                WB wb3 = new WB(tkVar, null);
                this.b = wb3;
                wb3.a(this);
                v2Var.g(this.b);
            } else {
                Integer num = Kj.f366e;
                D9 d9 = this.f3006a;
                if (obj == num && d9 != null) {
                    d9.a.k(tkVar);
                } else if (obj == Kj.v && d9 != null) {
                    d9.b(tkVar);
                } else if (obj == Kj.w && d9 != null) {
                    d9.b.k(tkVar);
                } else if (obj == Kj.x && d9 != null) {
                    d9.c.k(tkVar);
                } else if (obj == Kj.y && d9 != null) {
                    d9.d.k(tkVar);
                }
            }
        }
    }

    public final void f() {
        this.f3007a.invalidateSelf();
    }

    public final String getName() {
        return this.f3011a;
    }

    public final void i(uh uhVar, int i, ArrayList arrayList, uh uhVar2) {
        C0308ql.d(uhVar, i, arrayList, uhVar2, this);
    }
}
