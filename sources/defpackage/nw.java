package defpackage;

import android.graphics.PointF;
import defpackage.Tg;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* renamed from: nw  reason: default package */
/* compiled from: ShapeDataParser */
public final class nw implements XB<mw> {
    public static final Tg.a a = Tg.a.a("c", "v", "i", "o");

    /* renamed from: a  reason: collision with other field name */
    public static final nw f3121a = new nw();

    public final Object d(Tg tg, float f) throws IOException {
        if (tg.r() == 1) {
            tg.a();
        }
        tg.b();
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        boolean z = false;
        while (tg.j()) {
            int t = tg.t(a);
            if (t == 0) {
                z = tg.l();
            } else if (t == 1) {
                arrayList = Wg.c(tg, f);
            } else if (t == 2) {
                arrayList2 = Wg.c(tg, f);
            } else if (t != 3) {
                tg.u();
                tg.v();
            } else {
                arrayList3 = Wg.c(tg, f);
            }
        }
        tg.e();
        if (tg.r() == 2) {
            tg.c();
        }
        if (arrayList == null || arrayList2 == null || arrayList3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        } else if (arrayList.isEmpty()) {
            return new mw(new PointF(), false, Collections.emptyList());
        } else {
            int size = arrayList.size();
            PointF pointF = (PointF) arrayList.get(0);
            ArrayList arrayList4 = new ArrayList(size);
            for (int i = 1; i < size; i++) {
                PointF pointF2 = (PointF) arrayList.get(i);
                int i2 = i - 1;
                arrayList4.add(new E7(C0308ql.a((PointF) arrayList.get(i2), (PointF) arrayList3.get(i2)), C0308ql.a(pointF2, (PointF) arrayList2.get(i)), pointF2));
            }
            if (z) {
                PointF pointF3 = (PointF) arrayList.get(0);
                int i3 = size - 1;
                arrayList4.add(new E7(C0308ql.a((PointF) arrayList.get(i3), (PointF) arrayList3.get(i3)), C0308ql.a(pointF3, (PointF) arrayList2.get(0)), pointF3));
            }
            return new mw(pointF, z, arrayList4);
        }
    }
}
