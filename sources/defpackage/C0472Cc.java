package defpackage;

import android.graphics.Rect;

/* renamed from: Cc  reason: default package and case insensitive filesystem */
/* compiled from: FitCenterStrategy */
public final class C0472Cc extends C1333pq {
    public final float a(C1205jx jxVar, C1205jx jxVar2) {
        if (jxVar.c <= 0 || jxVar.d <= 0) {
            return 0.0f;
        }
        C1205jx f = jxVar.f(jxVar2);
        int i = f.c;
        float f2 = (((float) i) * 1.0f) / ((float) jxVar.c);
        if (f2 > 1.0f) {
            f2 = (float) Math.pow((double) (1.0f / f2), 1.1d);
        }
        float f3 = ((((float) jxVar2.d) * 1.0f) / ((float) f.d)) * ((((float) jxVar2.c) * 1.0f) / ((float) i));
        return (((1.0f / f3) / f3) / f3) * f2;
    }

    public final Rect b(C1205jx jxVar, C1205jx jxVar2) {
        C1205jx f = jxVar.f(jxVar2);
        jxVar.toString();
        f.toString();
        jxVar2.toString();
        int i = f.c;
        int i2 = (i - jxVar2.c) / 2;
        int i3 = f.d;
        int i4 = (i3 - jxVar2.d) / 2;
        return new Rect(-i2, -i4, i - i2, i3 - i4);
    }
}
