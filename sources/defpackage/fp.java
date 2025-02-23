package defpackage;

import android.graphics.Path;
import android.graphics.PointF;
import defpackage.UB;

/* renamed from: fp  reason: default package */
/* compiled from: PathKeyframe */
public final class fp extends Bh<PointF> {
    public final Bh<PointF> a;

    /* renamed from: a  reason: collision with other field name */
    public Path f2943a;

    public fp(C0181ej ejVar, Bh<PointF> bh) {
        super(ejVar, (PointF) bh.f65a, (PointF) bh.f69b, bh.f62a, bh.f68b, bh.f70c, bh.a, bh.f64a);
        this.a = bh;
        d();
    }

    public final void d() {
        boolean z;
        T t;
        T t2 = this.f69b;
        T t3 = this.f65a;
        if (t2 == null || t3 == null || !((PointF) t3).equals(((PointF) t2).x, ((PointF) t2).y)) {
            z = false;
        } else {
            z = true;
        }
        if (t3 != null && (t = this.f69b) != null && !z) {
            PointF pointF = (PointF) t3;
            PointF pointF2 = (PointF) t;
            Bh<PointF> bh = this.a;
            PointF pointF3 = bh.f61a;
            PointF pointF4 = bh.f67b;
            UB.a aVar = UB.f567a;
            Path path = new Path();
            path.moveTo(pointF.x, pointF.y);
            if (pointF3 == null || pointF4 == null || (pointF3.length() == 0.0f && pointF4.length() == 0.0f)) {
                path.lineTo(pointF2.x, pointF2.y);
            } else {
                float f = pointF.x;
                float f2 = pointF2.x;
                float f3 = pointF2.y;
                path.cubicTo(pointF3.x + f, pointF.y + pointF3.y, f2 + pointF4.x, f3 + pointF4.y, f2, f3);
            }
            this.f2943a = path;
        }
    }
}
