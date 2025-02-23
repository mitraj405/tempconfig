package defpackage;

import android.graphics.Rect;

/* renamed from: L4  reason: default package */
/* compiled from: CenterCropStrategy */
public final class L4 extends C1333pq {
    public final float a(C1205jx jxVar, C1205jx jxVar2) {
        if (jxVar.c <= 0 || jxVar.d <= 0) {
            return 0.0f;
        }
        C1205jx a = jxVar.a(jxVar2);
        int i = a.c;
        float f = (((float) i) * 1.0f) / ((float) jxVar.c);
        if (f > 1.0f) {
            f = (float) Math.pow((double) (1.0f / f), 1.1d);
        }
        float f2 = ((((float) a.d) * 1.0f) / ((float) jxVar2.d)) + ((((float) i) * 1.0f) / ((float) jxVar2.c));
        return ((1.0f / f2) / f2) * f;
    }

    public final Rect b(C1205jx jxVar, C1205jx jxVar2) {
        C1205jx a = jxVar.a(jxVar2);
        jxVar.toString();
        a.toString();
        jxVar2.toString();
        int i = a.c;
        int i2 = (i - jxVar2.c) / 2;
        int i3 = a.d;
        int i4 = (i3 - jxVar2.d) / 2;
        return new Rect(-i2, -i4, i - i2, i3 - i4);
    }
}
