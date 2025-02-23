package defpackage;

import java.io.IOException;

/* renamed from: cv  reason: default package */
/* compiled from: ScaleXYParser */
public final class cv implements XB<bv> {
    public static final cv a = new cv();

    public final Object d(Tg tg, float f) throws IOException {
        boolean z = true;
        if (tg.r() != 1) {
            z = false;
        }
        if (z) {
            tg.a();
        }
        float m = (float) tg.m();
        float m2 = (float) tg.m();
        while (tg.j()) {
            tg.v();
        }
        if (z) {
            tg.c();
        }
        return new bv((m / 100.0f) * f, (m2 / 100.0f) * f);
    }
}
