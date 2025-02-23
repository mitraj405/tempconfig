package defpackage;

import android.graphics.PointF;
import java.util.List;

/* renamed from: Hp  reason: default package */
/* compiled from: PointKeyframeAnimation */
public final class Hp extends Ch<PointF> {
    public final PointF a = new PointF();

    public Hp(List<Bh<PointF>> list) {
        super(list);
    }

    public final Object g(Bh bh, float f) {
        return h(bh, f, f, f);
    }

    /* renamed from: l */
    public final PointF h(Bh<PointF> bh, float f, float f2, float f3) {
        T t;
        T t2 = bh.f65a;
        if (t2 == null || (t = bh.f69b) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF = (PointF) t2;
        PointF pointF2 = (PointF) t;
        C0344tk tkVar = this.f3287a;
        if (tkVar != null) {
            PointF pointF3 = (PointF) tkVar.b(bh.a, bh.f64a.floatValue(), pointF, pointF2, f, e(), this.a);
            if (pointF3 != null) {
                return pointF3;
            }
        }
        PointF pointF4 = this.a;
        float f4 = pointF.x;
        float a2 = lf.a(pointF2.x, f4, f2, f4);
        float f5 = pointF.y;
        pointF4.set(a2, ((pointF2.y - f5) * f3) + f5);
        return pointF4;
    }
}
