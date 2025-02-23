package defpackage;

import android.graphics.Color;
import android.graphics.PointF;
import com.google.firebase.perf.util.Constants;
import defpackage.Tg;
import java.io.IOException;
import java.util.ArrayList;

/* renamed from: Wg  reason: default package */
/* compiled from: JsonUtils */
public final class Wg {
    public static final Tg.a a = Tg.a.a("x", "y");

    public static int a(Tg tg) throws IOException {
        tg.a();
        int m = (int) (tg.m() * 255.0d);
        int m2 = (int) (tg.m() * 255.0d);
        int m3 = (int) (tg.m() * 255.0d);
        while (tg.j()) {
            tg.v();
        }
        tg.c();
        return Color.argb(Constants.MAX_HOST_LENGTH, m, m2, m3);
    }

    public static PointF b(Tg tg, float f) throws IOException {
        int V = xx.V(tg.r());
        if (V == 0) {
            tg.a();
            float m = (float) tg.m();
            float m2 = (float) tg.m();
            while (tg.r() != 2) {
                tg.v();
            }
            tg.c();
            return new PointF(m * f, m2 * f);
        } else if (V == 2) {
            tg.b();
            float f2 = 0.0f;
            float f3 = 0.0f;
            while (tg.j()) {
                int t = tg.t(a);
                if (t == 0) {
                    f2 = d(tg);
                } else if (t != 1) {
                    tg.u();
                    tg.v();
                } else {
                    f3 = d(tg);
                }
            }
            tg.e();
            return new PointF(f2 * f, f3 * f);
        } else if (V == 6) {
            float m3 = (float) tg.m();
            float m4 = (float) tg.m();
            while (tg.j()) {
                tg.v();
            }
            return new PointF(m3 * f, m4 * f);
        } else {
            throw new IllegalArgumentException("Unknown point starts with ".concat(lf.A(tg.r())));
        }
    }

    public static ArrayList c(Tg tg, float f) throws IOException {
        ArrayList arrayList = new ArrayList();
        tg.a();
        while (tg.r() == 1) {
            tg.a();
            arrayList.add(b(tg, f));
            tg.c();
        }
        tg.c();
        return arrayList;
    }

    public static float d(Tg tg) throws IOException {
        int r = tg.r();
        int V = xx.V(r);
        if (V == 0) {
            tg.a();
            float m = (float) tg.m();
            while (tg.j()) {
                tg.v();
            }
            tg.c();
            return m;
        } else if (V == 6) {
            return (float) tg.m();
        } else {
            throw new IllegalArgumentException("Unknown value for token of type ".concat(lf.A(r)));
        }
    }
}
