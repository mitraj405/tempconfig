package defpackage;

import java.util.List;

/* renamed from: Lz  reason: default package */
/* compiled from: TextKeyframeAnimation */
public final class Lz extends Ch<q9> {
    public Lz(List<Bh<q9>> list) {
        super(list);
    }

    public final Object g(Bh bh, float f) {
        T t;
        float f2;
        q9 q9Var;
        C0344tk tkVar = this.f3287a;
        T t2 = bh.f65a;
        if (tkVar != null) {
            float f3 = bh.a;
            Float f4 = bh.f64a;
            if (f4 == null) {
                f2 = Float.MAX_VALUE;
            } else {
                f2 = f4.floatValue();
            }
            q9 q9Var2 = (q9) t2;
            T t3 = bh.f69b;
            if (t3 == null) {
                q9Var = q9Var2;
            } else {
                q9Var = (q9) t3;
            }
            return (q9) tkVar.b(f3, f2, q9Var2, q9Var, f, d(), this.a);
        } else if (f != 1.0f || (t = bh.f69b) == null) {
            return (q9) t2;
        } else {
            return (q9) t;
        }
    }
}
