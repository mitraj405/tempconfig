package defpackage;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* renamed from: sw  reason: default package */
/* compiled from: ShapeKeyframeAnimation */
public final class sw extends C0335t2<mw, Path> {
    public final Path a = new Path();

    /* renamed from: a  reason: collision with other field name */
    public List<uw> f3280a;

    /* renamed from: a  reason: collision with other field name */
    public final mw f3281a = new mw();

    public sw(List<Bh<mw>> list) {
        super(list);
    }

    public final Object g(Bh bh, float f) {
        boolean z;
        mw mwVar = (mw) bh.f65a;
        mw mwVar2 = (mw) bh.f69b;
        mw mwVar3 = this.f3281a;
        if (mwVar3.a == null) {
            mwVar3.a = new PointF();
        }
        int i = 0;
        if (mwVar.f3108a || mwVar2.f3108a) {
            z = true;
        } else {
            z = false;
        }
        mwVar3.f3108a = z;
        ArrayList arrayList = mwVar.f3107a;
        int size = arrayList.size();
        int size2 = mwVar2.f3107a.size();
        ArrayList arrayList2 = mwVar2.f3107a;
        if (size != size2) {
            Ai.b("Curves must have the same number of control points. Shape 1: " + arrayList.size() + "\tShape 2: " + arrayList2.size());
        }
        int min = Math.min(arrayList.size(), arrayList2.size());
        ArrayList arrayList3 = mwVar3.f3107a;
        if (arrayList3.size() < min) {
            for (int size3 = arrayList3.size(); size3 < min; size3++) {
                arrayList3.add(new E7());
            }
        } else if (arrayList3.size() > min) {
            for (int size4 = arrayList3.size() - 1; size4 >= min; size4--) {
                arrayList3.remove(arrayList3.size() - 1);
            }
        }
        PointF pointF = mwVar.a;
        PointF pointF2 = mwVar2.a;
        float f2 = pointF.x;
        float f3 = pointF2.x;
        PointF pointF3 = C0308ql.a;
        float a2 = lf.a(f3, f2, f, f2);
        float f4 = pointF.y;
        mwVar3.a(a2, ((pointF2.y - f4) * f) + f4);
        for (int size5 = arrayList3.size() - 1; size5 >= 0; size5--) {
            E7 e7 = (E7) arrayList.get(size5);
            E7 e72 = (E7) arrayList2.get(size5);
            PointF pointF4 = e7.a;
            PointF pointF5 = e72.a;
            float f5 = pointF4.x;
            float a3 = lf.a(pointF5.x, f5, f, f5);
            float f6 = pointF4.y;
            ((E7) arrayList3.get(size5)).a.set(a3, lf.a(pointF5.y, f6, f, f6));
            PointF pointF6 = e7.b;
            float f7 = pointF6.x;
            PointF pointF7 = e72.b;
            float a4 = lf.a(pointF7.x, f7, f, f7);
            float f8 = pointF6.y;
            ((E7) arrayList3.get(size5)).b.set(a4, lf.a(pointF7.y, f8, f, f8));
            PointF pointF8 = e7.c;
            float f9 = pointF8.x;
            PointF pointF9 = e72.c;
            float a5 = lf.a(pointF9.x, f9, f, f9);
            float f10 = pointF8.y;
            ((E7) arrayList3.get(size5)).c.set(a5, lf.a(pointF9.y, f10, f, f10));
        }
        List<uw> list = this.f3280a;
        if (list != null) {
            for (int size6 = list.size() - 1; size6 >= 0; size6--) {
                mwVar3 = this.f3280a.get(size6).h(mwVar3);
            }
        }
        Path path = this.a;
        path.reset();
        PointF pointF10 = mwVar3.a;
        path.moveTo(pointF10.x, pointF10.y);
        PointF pointF11 = C0308ql.a;
        pointF11.set(pointF10.x, pointF10.y);
        while (true) {
            ArrayList arrayList4 = mwVar3.f3107a;
            if (i >= arrayList4.size()) {
                break;
            }
            E7 e73 = (E7) arrayList4.get(i);
            PointF pointF12 = e73.a;
            boolean equals = pointF12.equals(pointF11);
            PointF pointF13 = e73.b;
            PointF pointF14 = e73.c;
            if (!equals || !pointF13.equals(pointF14)) {
                path.cubicTo(pointF12.x, pointF12.y, pointF13.x, pointF13.y, pointF14.x, pointF14.y);
            } else {
                path.lineTo(pointF14.x, pointF14.y);
            }
            pointF11.set(pointF14.x, pointF14.y);
            i++;
        }
        if (mwVar3.f3108a) {
            path.close();
        }
        return path;
    }
}
