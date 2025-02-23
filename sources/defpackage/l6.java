package defpackage;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.collection.LongSparseArray;
import defpackage.UB;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: l6  reason: default package */
/* compiled from: CompositionLayer */
public final class l6 extends C0359v2 {
    public final Paint a = new Paint();

    /* renamed from: a  reason: collision with other field name */
    public C0335t2<Float, Float> f3074a;
    public final ArrayList b = new ArrayList();
    public boolean c = true;
    public final RectF f = new RectF();
    public final RectF g = new RectF();

    public l6(Ej ej, Sh sh, List<Sh> list, C0181ej ejVar) {
        super(ej, sh);
        int i;
        C0359v2 v2Var;
        C0359v2 v2Var2;
        H0 h0 = sh.f522a;
        if (h0 != null) {
            C0335t2<Float, Float> b2 = h0.b();
            this.f3074a = b2;
            g(b2);
            this.f3074a.a(this);
        } else {
            this.f3074a = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(ejVar.f2907b.size());
        int size = list.size() - 1;
        C0359v2 v2Var3 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Sh sh2 = list.get(size);
            int V = xx.V(sh2.f519a);
            if (V == 0) {
                v2Var2 = new l6(ej, sh2, ejVar.f2904a.get(sh2.f533b), ejVar);
            } else if (V == 1) {
                v2Var2 = new wx(ej, sh2);
            } else if (V == 2) {
                v2Var2 = new C0355uf(ej, sh2);
            } else if (V == 3) {
                v2Var2 = new C0229in(ej, sh2);
            } else if (V == 4) {
                v2Var2 = new tw(ej, sh2, this);
            } else if (V != 5) {
                Ai.b("Unknown layer type ".concat(lf.B(sh2.f519a)));
                v2Var2 = null;
            } else {
                v2Var2 = new Mz(ej, sh2);
            }
            if (v2Var2 != null) {
                longSparseArray.e(v2Var2.f3345a.f520a, v2Var2);
                if (v2Var3 != null) {
                    v2Var3.f3353a = v2Var2;
                    v2Var3 = null;
                } else {
                    this.b.add(0, v2Var2);
                    int V2 = xx.V(sh2.g);
                    if (V2 == 1 || V2 == 2) {
                        v2Var3 = v2Var2;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < longSparseArray.f(); i++) {
            if (longSparseArray.f1324a) {
                longSparseArray.c();
            }
            C0359v2 v2Var4 = (C0359v2) longSparseArray.d(longSparseArray.f1325a[i], (Long) null);
            if (!(v2Var4 == null || (v2Var = (C0359v2) longSparseArray.d(v2Var4.f3345a.f532b, (Long) null)) == null)) {
                v2Var4.f3357b = v2Var;
            }
        }
    }

    public final void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        ArrayList arrayList = this.b;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            RectF rectF2 = this.f;
            rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
            ((C0359v2) arrayList.get(size)).a(rectF2, this.f3359c, true);
            rectF.union(rectF2);
        }
    }

    public final void e(C0344tk tkVar, Object obj) {
        super.e(tkVar, obj);
        if (obj != Kj.t) {
            return;
        }
        if (tkVar == null) {
            C0335t2<Float, Float> t2Var = this.f3074a;
            if (t2Var != null) {
                t2Var.k((C0344tk) null);
                return;
            }
            return;
        }
        WB wb = new WB(tkVar, null);
        this.f3074a = wb;
        wb.a(this);
        g(this.f3074a);
    }

    public final void l(Canvas canvas, Matrix matrix, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        RectF rectF = this.g;
        Sh sh = this.f3345a;
        rectF.set(0.0f, 0.0f, (float) sh.e, (float) sh.f);
        matrix.mapRect(rectF);
        boolean z4 = this.f3341a.i;
        ArrayList arrayList = this.b;
        if (!z4 || arrayList.size() <= 1 || i == 255) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            Paint paint = this.a;
            paint.setAlpha(i);
            UB.a aVar = UB.f567a;
            canvas.saveLayer(rectF, paint);
            C1354qp.G();
        } else {
            canvas.save();
        }
        if (z) {
            i = 255;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (this.c || !"__container".equals(sh.f527a)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2 || rectF.isEmpty()) {
                z3 = true;
            } else {
                z3 = canvas.clipRect(rectF);
            }
            if (z3) {
                ((C0359v2) arrayList.get(size)).c(canvas, matrix, i);
            }
        }
        canvas.restore();
        C1354qp.G();
    }

    public final void r(uh uhVar, int i, ArrayList arrayList, uh uhVar2) {
        int i2 = 0;
        while (true) {
            ArrayList arrayList2 = this.b;
            if (i2 < arrayList2.size()) {
                ((C0359v2) arrayList2.get(i2)).i(uhVar, i, arrayList, uhVar2);
                i2++;
            } else {
                return;
            }
        }
    }

    public final void s(boolean z) {
        super.s(z);
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((C0359v2) it.next()).s(z);
        }
    }

    public final void t(float f2) {
        super.t(f2);
        C0335t2<Float, Float> t2Var = this.f3074a;
        Sh sh = this.f3345a;
        if (t2Var != null) {
            C0181ej ejVar = this.f3341a.f145a;
            f2 = ((t2Var.f().floatValue() * sh.f526a.c) - sh.f526a.a) / ((ejVar.b - ejVar.a) + 0.01f);
        }
        if (this.f3074a == null) {
            C0181ej ejVar2 = sh.f526a;
            f2 -= sh.b / (ejVar2.b - ejVar2.a);
        }
        if (sh.a != 0.0f && !"__container".equals(sh.f527a)) {
            f2 /= sh.a;
        }
        ArrayList arrayList = this.b;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size >= 0) {
                ((C0359v2) arrayList.get(size)).t(f2);
            } else {
                return;
            }
        }
    }
}
