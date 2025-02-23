package defpackage;

import android.graphics.PointF;
import java.util.List;

/* renamed from: L0  reason: default package */
/* compiled from: AnimatableSplitDimensionPathValue */
public final class L0 implements R0<PointF, PointF> {
    public final H0 a;
    public final H0 b;

    public L0(H0 h0, H0 h02) {
        this.a = h0;
        this.b = h02;
    }

    public final boolean a() {
        if (!this.a.a() || !this.b.a()) {
            return false;
        }
        return true;
    }

    public final C0335t2<PointF, PointF> b() {
        return new Fx((C0093Gc) this.a.b(), (C0093Gc) this.b.b());
    }

    public final List<Bh<PointF>> c() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }
}
