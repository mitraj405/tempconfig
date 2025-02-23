package defpackage;

import android.window.BackEvent;

/* renamed from: X0  reason: default package */
/* compiled from: BackEventCompat.kt */
public final class X0 {
    public static final X0 a = new X0();

    public final BackEvent a(float f, float f2, float f3, int i) {
        return new BackEvent(f, f2, f3, i);
    }

    public final float b(BackEvent backEvent) {
        C1177ig.f(backEvent, "backEvent");
        return backEvent.getProgress();
    }

    public final int c(BackEvent backEvent) {
        C1177ig.f(backEvent, "backEvent");
        return backEvent.getSwipeEdge();
    }

    public final float d(BackEvent backEvent) {
        C1177ig.f(backEvent, "backEvent");
        return backEvent.getTouchX();
    }

    public final float e(BackEvent backEvent) {
        C1177ig.f(backEvent, "backEvent");
        return backEvent.getTouchY();
    }
}
