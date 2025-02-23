package defpackage;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.MaskFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import com.google.firebase.perf.util.Constants;
import defpackage.C0335t2;
import java.util.ArrayList;
import java.util.List;

/* renamed from: B2  reason: default package */
/* compiled from: BaseStrokeContent */
public abstract class B2 implements C0335t2.a, C0381wh, z9 {
    public float a;

    /* renamed from: a  reason: collision with other field name */
    public final D9 f24a;

    /* renamed from: a  reason: collision with other field name */
    public final Ej f25a;

    /* renamed from: a  reason: collision with other field name */
    public final C0093Gc f26a;

    /* renamed from: a  reason: collision with other field name */
    public final Lh f27a;

    /* renamed from: a  reason: collision with other field name */
    public WB f28a;

    /* renamed from: a  reason: collision with other field name */
    public final Path f29a = new Path();

    /* renamed from: a  reason: collision with other field name */
    public final PathMeasure f30a = new PathMeasure();

    /* renamed from: a  reason: collision with other field name */
    public final RectF f31a = new RectF();

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList f32a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    public final C0335t2<?, Integer> f33a;

    /* renamed from: a  reason: collision with other field name */
    public final C0359v2 f34a;

    /* renamed from: a  reason: collision with other field name */
    public final float[] f35a;
    public final C0093Gc b;

    /* renamed from: b  reason: collision with other field name */
    public final Path f36b = new Path();

    /* renamed from: b  reason: collision with other field name */
    public final ArrayList f37b;

    /* renamed from: b  reason: collision with other field name */
    public C0335t2<Float, Float> f38b;

    /* renamed from: B2$a */
    /* compiled from: BaseStrokeContent */
    public static final class a {
        public final MA a;

        /* renamed from: a  reason: collision with other field name */
        public final ArrayList f39a = new ArrayList();

        public a(MA ma) {
            this.a = ma;
        }
    }

    public B2(Ej ej, C0359v2 v2Var, Paint.Cap cap, Paint.Join join, float f, J0 j0, H0 h0, List<H0> list, H0 h02) {
        Lh lh = new Lh(1);
        this.f27a = lh;
        this.a = 0.0f;
        this.f25a = ej;
        this.f34a = v2Var;
        lh.setStyle(Paint.Style.STROKE);
        lh.setStrokeCap(cap);
        lh.setStrokeJoin(join);
        lh.setStrokeMiter(f);
        this.f33a = j0.b();
        this.f26a = (C0093Gc) h0.b();
        if (h02 == null) {
            this.b = null;
        } else {
            this.b = (C0093Gc) h02.b();
        }
        this.f37b = new ArrayList(list.size());
        this.f35a = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.f37b.add(list.get(i).b());
        }
        v2Var.g(this.f33a);
        v2Var.g(this.f26a);
        for (int i2 = 0; i2 < this.f37b.size(); i2++) {
            v2Var.g((C0335t2) this.f37b.get(i2));
        }
        C0093Gc gc = this.b;
        if (gc != null) {
            v2Var.g(gc);
        }
        this.f33a.a(this);
        this.f26a.a(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            ((C0335t2) this.f37b.get(i3)).a(this);
        }
        C0093Gc gc2 = this.b;
        if (gc2 != null) {
            gc2.a(this);
        }
        if (v2Var.m() != null) {
            C0335t2<Float, Float> b2 = ((H0) v2Var.m().a).b();
            this.f38b = b2;
            b2.a(this);
            v2Var.g(this.f38b);
        }
        if (v2Var.n() != null) {
            this.f24a = new D9(this, v2Var, v2Var.n());
        }
    }

    public final void a(RectF rectF, Matrix matrix, boolean z) {
        Path path = this.f29a;
        path.reset();
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f32a;
            if (i < arrayList.size()) {
                a aVar = (a) arrayList.get(i);
                for (int i2 = 0; i2 < aVar.f39a.size(); i2++) {
                    path.addPath(((dp) aVar.f39a.get(i2)).b(), matrix);
                }
                i++;
            } else {
                RectF rectF2 = this.f31a;
                path.computeBounds(rectF2, false);
                float l = this.f26a.l() / 2.0f;
                rectF2.set(rectF2.left - l, rectF2.top - l, rectF2.right + l, rectF2.bottom + l);
                rectF.set(rectF2);
                rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
                C1354qp.G();
                return;
            }
        }
    }

    public void c(Canvas canvas, Matrix matrix, int i) {
        boolean z;
        boolean z2;
        float f;
        float f2;
        float f3;
        BlurMaskFilter blurMaskFilter;
        float[] fArr;
        float f4;
        B2 b2 = this;
        Canvas canvas2 = canvas;
        Matrix matrix2 = matrix;
        float[] fArr2 = (float[]) UB.f570a.get();
        boolean z3 = false;
        fArr2[0] = 0.0f;
        fArr2[1] = 0.0f;
        fArr2[2] = 37394.73f;
        fArr2[3] = 39575.234f;
        matrix2.mapPoints(fArr2);
        if (fArr2[0] == fArr2[2] || fArr2[1] == fArr2[3]) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            C1354qp.G();
            return;
        }
        gg ggVar = (gg) b2.f33a;
        float l = (((float) i) / 255.0f) * ((float) ggVar.l(ggVar.b(), ggVar.d()));
        float f5 = 100.0f;
        PointF pointF = C0308ql.a;
        int max = Math.max(0, Math.min(Constants.MAX_HOST_LENGTH, (int) ((l / 100.0f) * 255.0f)));
        Lh lh = b2.f27a;
        lh.setAlpha(max);
        lh.setStrokeWidth(UB.d(matrix) * b2.f26a.l());
        if (lh.getStrokeWidth() <= 0.0f) {
            C1354qp.G();
            return;
        }
        ArrayList arrayList = b2.f37b;
        if (arrayList.isEmpty()) {
            C1354qp.G();
        } else {
            float d = UB.d(matrix);
            int i2 = 0;
            while (true) {
                int size = arrayList.size();
                fArr = b2.f35a;
                if (i2 >= size) {
                    break;
                }
                float floatValue = ((Float) ((C0335t2) arrayList.get(i2)).f()).floatValue();
                fArr[i2] = floatValue;
                if (i2 % 2 == 0) {
                    if (floatValue < 1.0f) {
                        fArr[i2] = 1.0f;
                    }
                } else if (floatValue < 0.1f) {
                    fArr[i2] = 0.1f;
                }
                fArr[i2] = fArr[i2] * d;
                i2++;
            }
            C0093Gc gc = b2.b;
            if (gc == null) {
                f4 = 0.0f;
            } else {
                f4 = ((Float) gc.f()).floatValue() * d;
            }
            lh.setPathEffect(new DashPathEffect(fArr, f4));
            C1354qp.G();
        }
        WB wb = b2.f28a;
        if (wb != null) {
            lh.setColorFilter((ColorFilter) wb.f());
        }
        C0335t2<Float, Float> t2Var = b2.f38b;
        if (t2Var != null) {
            float floatValue2 = t2Var.f().floatValue();
            if (floatValue2 == 0.0f) {
                lh.setMaskFilter((MaskFilter) null);
            } else if (floatValue2 != b2.a) {
                C0359v2 v2Var = b2.f34a;
                if (v2Var.a == floatValue2) {
                    blurMaskFilter = v2Var.f3346a;
                } else {
                    BlurMaskFilter blurMaskFilter2 = new BlurMaskFilter(floatValue2 / 2.0f, BlurMaskFilter.Blur.NORMAL);
                    v2Var.f3346a = blurMaskFilter2;
                    v2Var.a = floatValue2;
                    blurMaskFilter = blurMaskFilter2;
                }
                lh.setMaskFilter(blurMaskFilter);
            }
            b2.a = floatValue2;
        }
        D9 d9 = b2.f24a;
        if (d9 != null) {
            d9.a(lh);
        }
        int i3 = 0;
        while (true) {
            ArrayList arrayList2 = b2.f32a;
            if (i3 < arrayList2.size()) {
                a aVar = (a) arrayList2.get(i3);
                MA ma = aVar.a;
                Path path = b2.f29a;
                ArrayList arrayList3 = aVar.f39a;
                if (ma != null) {
                    path.reset();
                    int size2 = arrayList3.size();
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        path.addPath(((dp) arrayList3.get(size2)).b(), matrix2);
                    }
                    MA ma2 = aVar.a;
                    float floatValue3 = ((Float) ma2.f401a.f()).floatValue() / f5;
                    float floatValue4 = ((Float) ma2.b.f()).floatValue() / f5;
                    float floatValue5 = ((Float) ma2.c.f()).floatValue() / 360.0f;
                    if (floatValue3 >= 0.01f || floatValue4 <= 0.99f) {
                        PathMeasure pathMeasure = b2.f30a;
                        pathMeasure.setPath(path, z3);
                        float length = pathMeasure.getLength();
                        while (pathMeasure.nextContour()) {
                            length = pathMeasure.getLength() + length;
                        }
                        float f6 = floatValue5 * length;
                        float f7 = (floatValue3 * length) + f6;
                        float min = Math.min((floatValue4 * length) + f6, (f7 + length) - 1.0f);
                        int size3 = arrayList3.size() - 1;
                        float f8 = 0.0f;
                        while (size3 >= 0) {
                            Path path2 = b2.f36b;
                            path2.set(((dp) arrayList3.get(size3)).b());
                            path2.transform(matrix2);
                            pathMeasure.setPath(path2, z3);
                            float length2 = pathMeasure.getLength();
                            if (min > length) {
                                float f9 = min - length;
                                if (f9 < f8 + length2 && f8 < f9) {
                                    if (f7 > length) {
                                        f3 = (f7 - length) / length2;
                                    } else {
                                        f3 = 0.0f;
                                    }
                                    UB.a(path2, f3, Math.min(f9 / length2, 1.0f), 0.0f);
                                    canvas2.drawPath(path2, lh);
                                    f8 += length2;
                                    size3--;
                                    b2 = this;
                                    z3 = false;
                                }
                            }
                            float f10 = f8 + length2;
                            if (f10 >= f7 && f8 <= min) {
                                if (f10 > min || f7 >= f8) {
                                    if (f7 < f8) {
                                        f = 0.0f;
                                    } else {
                                        f = (f7 - f8) / length2;
                                    }
                                    if (min > f10) {
                                        f2 = 1.0f;
                                    } else {
                                        f2 = (min - f8) / length2;
                                    }
                                    UB.a(path2, f, f2, 0.0f);
                                    canvas2.drawPath(path2, lh);
                                } else {
                                    canvas2.drawPath(path2, lh);
                                }
                            }
                            f8 += length2;
                            size3--;
                            b2 = this;
                            z3 = false;
                        }
                        C1354qp.G();
                    } else {
                        canvas2.drawPath(path, lh);
                        C1354qp.G();
                    }
                    z2 = true;
                } else {
                    path.reset();
                    z2 = true;
                    for (int size4 = arrayList3.size() - 1; size4 >= 0; size4--) {
                        path.addPath(((dp) arrayList3.get(size4)).b(), matrix2);
                    }
                    C1354qp.G();
                    canvas2.drawPath(path, lh);
                    C1354qp.G();
                }
                i3++;
                b2 = this;
                boolean z4 = z2;
                z3 = false;
                f5 = 100.0f;
            } else {
                C1354qp.G();
                return;
            }
        }
    }

    public final void d(List<V6> list, List<V6> list2) {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) list;
        a aVar = null;
        MA ma = null;
        for (int size = arrayList2.size() - 1; size >= 0; size--) {
            V6 v6 = (V6) arrayList2.get(size);
            if (v6 instanceof MA) {
                MA ma2 = (MA) v6;
                if (ma2.a == 2) {
                    ma = ma2;
                }
            }
        }
        if (ma != null) {
            ma.e(this);
        }
        int size2 = list2.size();
        while (true) {
            size2--;
            arrayList = this.f32a;
            if (size2 < 0) {
                break;
            }
            V6 v62 = list2.get(size2);
            if (v62 instanceof MA) {
                MA ma3 = (MA) v62;
                if (ma3.a == 2) {
                    if (aVar != null) {
                        arrayList.add(aVar);
                    }
                    a aVar2 = new a(ma3);
                    ma3.e(this);
                    aVar = aVar2;
                }
            }
            if (v62 instanceof dp) {
                if (aVar == null) {
                    aVar = new a(ma);
                }
                aVar.f39a.add((dp) v62);
            }
        }
        if (aVar != null) {
            arrayList.add(aVar);
        }
    }

    public void e(C0344tk tkVar, Object obj) {
        if (obj == Kj.f364d) {
            this.f33a.k(tkVar);
        } else if (obj == Kj.h) {
            this.f26a.k(tkVar);
        } else {
            ColorFilter colorFilter = Kj.f351a;
            C0359v2 v2Var = this.f34a;
            if (obj == colorFilter) {
                WB wb = this.f28a;
                if (wb != null) {
                    v2Var.q(wb);
                }
                if (tkVar == null) {
                    this.f28a = null;
                    return;
                }
                WB wb2 = new WB(tkVar, null);
                this.f28a = wb2;
                wb2.a(this);
                v2Var.g(this.f28a);
            } else if (obj == Kj.f361c) {
                C0335t2<Float, Float> t2Var = this.f38b;
                if (t2Var != null) {
                    t2Var.k(tkVar);
                    return;
                }
                WB wb3 = new WB(tkVar, null);
                this.f38b = wb3;
                wb3.a(this);
                v2Var.g(this.f38b);
            } else {
                Integer num = Kj.f366e;
                D9 d9 = this.f24a;
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
        this.f25a.invalidateSelf();
    }

    public final void i(uh uhVar, int i, ArrayList arrayList, uh uhVar2) {
        C0308ql.d(uhVar, i, arrayList, uhVar2, this);
    }
}
