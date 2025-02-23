package defpackage;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* renamed from: Sy  reason: default package */
/* compiled from: SwipeRefreshLayout */
public final class Sy extends Animation {
    public final /* synthetic */ SwipeRefreshLayout a;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    public Sy(SwipeRefreshLayout swipeRefreshLayout, int i, int i2) {
        this.a = swipeRefreshLayout;
        this.c = i;
        this.d = i2;
    }

    public final void applyTransformation(float f, Transformation transformation) {
        l5 l5Var = this.a.f2445a;
        int i = this.c;
        l5Var.setAlpha((int) ((((float) (this.d - i)) * f) + ((float) i)));
    }
}
