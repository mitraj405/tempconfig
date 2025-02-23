package defpackage;

import android.graphics.PointF;
import java.util.List;

/* renamed from: Gc  reason: default package and case insensitive filesystem */
/* compiled from: FloatKeyframeAnimation */
public final class C0093Gc extends Ch<Float> {
    public C0093Gc(List<Bh<Float>> list) {
        super(list);
    }

    public final Object g(Bh bh, float f) {
        return Float.valueOf(m(bh, f));
    }

    public final float l() {
        return m(b(), d());
    }

    public final float m(Bh<Float> bh, float f) {
        if (bh.f65a == null || bh.f69b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        C0344tk tkVar = this.f3287a;
        T t = bh.f65a;
        if (tkVar != null) {
            Float f2 = (Float) tkVar.b(bh.a, bh.f64a.floatValue(), (Float) t, (Float) bh.f69b, f, e(), this.a);
            if (f2 != null) {
                return f2.floatValue();
            }
        }
        if (bh.b == -3987645.8f) {
            bh.b = ((Float) t).floatValue();
        }
        float f3 = bh.b;
        if (bh.c == -3987645.8f) {
            bh.c = ((Float) bh.f69b).floatValue();
        }
        float f4 = bh.c;
        PointF pointF = C0308ql.a;
        return lf.a(f4, f3, f, f3);
    }
}
