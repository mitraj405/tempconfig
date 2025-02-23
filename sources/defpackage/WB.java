package defpackage;

import java.util.Collections;

/* renamed from: WB  reason: default package */
/* compiled from: ValueCallbackKeyframeAnimation */
public final class WB<K, A> extends C0335t2<K, A> {
    public final A b;

    public WB(C0344tk tkVar, A a) {
        super(Collections.emptyList());
        k(tkVar);
        this.b = a;
    }

    public final float c() {
        return 1.0f;
    }

    public final A f() {
        C0344tk tkVar = this.f3287a;
        A a = this.b;
        float f = this.a;
        return tkVar.b(0.0f, 0.0f, a, a, f, f, f);
    }

    public final A g(Bh<K> bh, float f) {
        return f();
    }

    public final void i() {
        if (this.f3287a != null) {
            super.i();
        }
    }

    public final void j(float f) {
        this.a = f;
    }
}
