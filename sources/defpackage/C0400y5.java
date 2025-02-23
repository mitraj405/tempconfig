package defpackage;

import java.util.List;

/* renamed from: y5  reason: default package and case insensitive filesystem */
/* compiled from: ColorKeyframeAnimation */
public final class C0400y5 extends Ch<Integer> {
    public C0400y5(List<Bh<Integer>> list) {
        super(list);
    }

    public final Object g(Bh bh, float f) {
        return Integer.valueOf(l(bh, f));
    }

    public final int l(Bh<Integer> bh, float f) {
        if (bh.f65a == null || bh.f69b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        C0344tk tkVar = this.f3287a;
        T t = bh.f65a;
        if (tkVar != null) {
            Integer num = (Integer) tkVar.b(bh.a, bh.f64a.floatValue(), (Integer) t, (Integer) bh.f69b, f, e(), this.a);
            if (num != null) {
                return num.intValue();
            }
        }
        return r1.p(C0308ql.b(f, 0.0f, 1.0f), ((Integer) t).intValue(), ((Integer) bh.f69b).intValue());
    }
}
