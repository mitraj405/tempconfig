package defpackage;

import android.annotation.SuppressLint;
import android.graphics.PointF;

/* renamed from: E7  reason: default package */
/* compiled from: CubicCurveData */
public final class E7 {
    public final PointF a;
    public final PointF b;
    public final PointF c;

    public E7() {
        this.a = new PointF();
        this.b = new PointF();
        this.c = new PointF();
    }

    @SuppressLint({"DefaultLocale"})
    public final String toString() {
        PointF pointF = this.c;
        PointF pointF2 = this.a;
        PointF pointF3 = this.b;
        return String.format("v=%.2f,%.2f cp1=%.2f,%.2f cp2=%.2f,%.2f", new Object[]{Float.valueOf(pointF.x), Float.valueOf(pointF.y), Float.valueOf(pointF2.x), Float.valueOf(pointF2.y), Float.valueOf(pointF3.x), Float.valueOf(pointF3.y)});
    }

    public E7(PointF pointF, PointF pointF2, PointF pointF3) {
        this.a = pointF;
        this.b = pointF2;
        this.c = pointF3;
    }
}
