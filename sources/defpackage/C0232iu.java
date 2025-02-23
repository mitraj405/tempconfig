package defpackage;

import android.graphics.PointF;
import defpackage.C0335t2;
import java.util.ArrayList;
import java.util.List;

/* renamed from: iu  reason: default package and case insensitive filesystem */
/* compiled from: RoundedCornersContent */
public final class C0232iu implements uw, C0335t2.a {
    public final Ej a;

    /* renamed from: a  reason: collision with other field name */
    public mw f3021a;

    /* renamed from: a  reason: collision with other field name */
    public final C0335t2<Float, Float> f3022a;

    public C0232iu(Ej ej, C0359v2 v2Var, hu huVar) {
        this.a = ej;
        huVar.getClass();
        C0335t2<Float, Float> b = huVar.a.b();
        this.f3022a = b;
        v2Var.g(b);
        b.a(this);
    }

    public static int e(int i, int i2) {
        int i3 = i / i2;
        if ((i ^ i2) < 0 && i2 * i3 != i) {
            i3--;
        }
        return i - (i3 * i2);
    }

    public final void f() {
        this.a.invalidateSelf();
    }

    public final mw h(mw mwVar) {
        PointF pointF;
        PointF pointF2;
        boolean z;
        float f;
        ArrayList arrayList;
        int i;
        PointF pointF3;
        PointF pointF4;
        boolean z2;
        mw mwVar2 = mwVar;
        ArrayList arrayList2 = mwVar2.f3107a;
        if (arrayList2.size() <= 2) {
            return mwVar2;
        }
        float floatValue = this.f3022a.f().floatValue();
        if (floatValue == 0.0f) {
            return mwVar2;
        }
        ArrayList arrayList3 = mwVar2.f3107a;
        boolean z3 = mwVar2.f3108a;
        int size = arrayList3.size() - 1;
        int i2 = 0;
        int i3 = 0;
        while (size >= 0) {
            E7 e7 = (E7) arrayList3.get(size);
            int i4 = size - 1;
            E7 e72 = (E7) arrayList3.get(e(i4, arrayList3.size()));
            if (size != 0 || z3) {
                pointF3 = e72.c;
            } else {
                pointF3 = mwVar2.a;
            }
            if (size != 0 || z3) {
                pointF4 = e72.b;
            } else {
                pointF4 = pointF3;
            }
            PointF pointF5 = e7.a;
            if (!mwVar2.f3108a && size == 0 && size == arrayList3.size() - 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!pointF4.equals(pointF3) || !pointF5.equals(pointF3) || z2) {
                i3++;
            } else {
                i3 += 2;
            }
            size = i4;
        }
        mw mwVar3 = this.f3021a;
        if (mwVar3 == null || mwVar3.f3107a.size() != i3) {
            ArrayList arrayList4 = new ArrayList(i3);
            for (int i5 = 0; i5 < i3; i5++) {
                arrayList4.add(new E7());
            }
            this.f3021a = new mw(new PointF(0.0f, 0.0f), false, arrayList4);
        }
        mw mwVar4 = this.f3021a;
        mwVar4.f3108a = z3;
        PointF pointF6 = mwVar2.a;
        mwVar4.a(pointF6.x, pointF6.y);
        ArrayList arrayList5 = mwVar4.f3107a;
        boolean z4 = mwVar2.f3108a;
        int i6 = 0;
        while (i2 < arrayList2.size()) {
            E7 e73 = (E7) arrayList2.get(i2);
            E7 e74 = (E7) arrayList2.get(e(i2 - 1, arrayList2.size()));
            E7 e75 = (E7) arrayList2.get(e(i2 - 2, arrayList2.size()));
            if (i2 != 0 || z4) {
                pointF = e74.c;
            } else {
                pointF = mwVar2.a;
            }
            if (i2 != 0 || z4) {
                pointF2 = e74.b;
            } else {
                pointF2 = pointF;
            }
            PointF pointF7 = e73.a;
            PointF pointF8 = e75.c;
            if (!mwVar2.f3108a && i2 == 0 && i2 == arrayList2.size() - 1) {
                z = true;
            } else {
                z = false;
            }
            boolean equals = pointF2.equals(pointF);
            PointF pointF9 = e73.c;
            if (!equals || !pointF7.equals(pointF) || z) {
                arrayList = arrayList2;
                f = floatValue;
                i = i2;
                E7 e76 = (E7) arrayList5.get(e(i6 - 1, arrayList5.size()));
                PointF pointF10 = e74.c;
                e76.b.set(pointF10.x, pointF10.y);
                PointF pointF11 = e74.c;
                e76.c.set(pointF11.x, pointF11.y);
                ((E7) arrayList5.get(i6)).a.set(pointF9.x, pointF9.y);
            } else {
                float f2 = pointF.x;
                float f3 = f2 - pointF8.x;
                float f4 = pointF.y;
                arrayList = arrayList2;
                double d = (double) (pointF9.x - f2);
                i = i2;
                float min = Math.min(floatValue / ((float) Math.hypot((double) f3, (double) (f4 - pointF8.y))), 0.5f);
                float min2 = Math.min(floatValue / ((float) Math.hypot(d, (double) (pointF9.y - f4))), 0.5f);
                float f5 = pointF.x;
                float a2 = lf.a(pointF8.x, f5, min, f5);
                float f6 = pointF.y;
                float a3 = lf.a(pointF8.y, f6, min, f6);
                float a4 = lf.a(pointF9.x, f5, min2, f5);
                float a5 = lf.a(pointF9.y, f6, min2, f6);
                float f7 = a2 - ((a2 - f5) * 0.5519f);
                float f8 = a3 - ((a3 - f6) * 0.5519f);
                float f9 = a4 - ((a4 - f5) * 0.5519f);
                float f10 = a5 - ((a5 - f6) * 0.5519f);
                E7 e77 = (E7) arrayList5.get(e(i6 - 1, arrayList5.size()));
                E7 e78 = (E7) arrayList5.get(i6);
                f = floatValue;
                e77.b.set(a2, a3);
                e77.c.set(a2, a3);
                if (i == 0) {
                    mwVar4.a(a2, a3);
                }
                e78.a.set(f7, f8);
                i6++;
                e78.b.set(f9, f10);
                e78.c.set(a4, a5);
                ((E7) arrayList5.get(i6)).a.set(a4, a5);
            }
            i6++;
            i2 = i + 1;
            mwVar2 = mwVar;
            arrayList2 = arrayList;
            floatValue = f;
        }
        return mwVar4;
    }

    public final void d(List<V6> list, List<V6> list2) {
    }
}
