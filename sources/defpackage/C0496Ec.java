package defpackage;

import android.graphics.Rect;

/* renamed from: Ec  reason: default package and case insensitive filesystem */
/* compiled from: FitXYStrategy */
public final class C0496Ec extends C1333pq {
    public final float a(C1205jx jxVar, C1205jx jxVar2) {
        int i;
        int i2 = jxVar.c;
        if (i2 <= 0 || (i = jxVar.d) <= 0) {
            return 0.0f;
        }
        int i3 = jxVar2.c;
        float f = (((float) i2) * 1.0f) / ((float) i3);
        if (f < 1.0f) {
            f = 1.0f / f;
        }
        float f2 = (float) i;
        float f3 = (float) jxVar2.d;
        float f4 = (f2 * 1.0f) / f3;
        if (f4 < 1.0f) {
            f4 = 1.0f / f4;
        }
        float f5 = (1.0f / f) / f4;
        float f6 = ((((float) i2) * 1.0f) / f2) / ((((float) i3) * 1.0f) / f3);
        if (f6 < 1.0f) {
            f6 = 1.0f / f6;
        }
        return (((1.0f / f6) / f6) / f6) * f5;
    }

    public final Rect b(C1205jx jxVar, C1205jx jxVar2) {
        return new Rect(0, 0, jxVar2.c, jxVar2.d);
    }
}
