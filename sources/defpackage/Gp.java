package defpackage;

import android.graphics.PointF;
import java.io.IOException;

/* renamed from: Gp  reason: default package */
/* compiled from: PointFParser */
public final class Gp implements XB<PointF> {
    public static final Gp a = new Gp();

    public final Object d(Tg tg, float f) throws IOException {
        int r = tg.r();
        if (r == 1) {
            return Wg.b(tg, f);
        }
        if (r == 3) {
            return Wg.b(tg, f);
        }
        if (r == 7) {
            PointF pointF = new PointF(((float) tg.m()) * f, ((float) tg.m()) * f);
            while (tg.j()) {
                tg.v();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is ".concat(lf.A(r)));
    }
}
