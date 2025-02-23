package androidx.activity;

import android.window.BackEvent;

/* compiled from: BackEventCompat.kt */
public final class BackEventCompat {
    public final float a;

    /* renamed from: a  reason: collision with other field name */
    public final int f805a;
    public final float b;
    public final float c;

    public BackEventCompat(BackEvent backEvent) {
        C1177ig.f(backEvent, "backEvent");
        X0 x0 = X0.a;
        float d = x0.d(backEvent);
        float e = x0.e(backEvent);
        float b2 = x0.b(backEvent);
        int c2 = x0.c(backEvent);
        this.a = d;
        this.b = e;
        this.c = b2;
        this.f805a = c2;
    }

    public final String toString() {
        return "BackEventCompat{touchX=" + this.a + ", touchY=" + this.b + ", progress=" + this.c + ", swipeEdge=" + this.f805a + '}';
    }
}
