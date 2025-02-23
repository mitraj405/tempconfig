package defpackage;

import android.graphics.PointF;
import java.util.List;

/* renamed from: gg  reason: default package */
/* compiled from: IntegerKeyframeAnimation */
public final class gg extends Ch<Integer> {
    public gg(List<Bh<Integer>> list) {
        super(list);
    }

    public final Object g(Bh bh, float f) {
        return Integer.valueOf(l(bh, f));
    }

    public final int l(Bh<Integer> bh, float f) {
        T t = bh.f65a;
        if (t == null || bh.f69b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        C0344tk tkVar = this.f3287a;
        if (tkVar != null) {
            Integer num = (Integer) tkVar.b(bh.a, bh.f64a.floatValue(), (Integer) t, (Integer) bh.f69b, f, e(), this.a);
            if (num != null) {
                return num.intValue();
            }
        }
        if (bh.f60a == 784923401) {
            bh.f60a = ((Integer) t).intValue();
        }
        int i = bh.f60a;
        if (bh.f66b == 784923401) {
            bh.f66b = ((Integer) bh.f69b).intValue();
        }
        int i2 = bh.f66b;
        PointF pointF = C0308ql.a;
        return (int) ((f * ((float) (i2 - i))) + ((float) i));
    }
}
