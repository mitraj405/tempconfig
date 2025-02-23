package defpackage;

import android.graphics.PointF;
import java.util.ArrayList;

/* renamed from: ql  reason: default package and case insensitive filesystem */
/* compiled from: MiscUtils */
public final class C0308ql {
    public static final PointF a = new PointF();

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static float b(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    public static int c(float f, float f2) {
        boolean z;
        int i = (int) f;
        int i2 = (int) f2;
        int i3 = i / i2;
        if ((i ^ i2) >= 0) {
            z = true;
        } else {
            z = false;
        }
        int i4 = i % i2;
        if (!z && i4 != 0) {
            i3--;
        }
        return i - (i2 * i3);
    }

    public static void d(uh uhVar, int i, ArrayList arrayList, uh uhVar2, C0381wh whVar) {
        if (uhVar.a(i, whVar.getName())) {
            String name = whVar.getName();
            uhVar2.getClass();
            uh uhVar3 = new uh(uhVar2);
            uhVar3.f3321a.add(name);
            uh uhVar4 = new uh(uhVar3);
            uhVar4.f3322a = whVar;
            arrayList.add(uhVar4);
        }
    }
}
