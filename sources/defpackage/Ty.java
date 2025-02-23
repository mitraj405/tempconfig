package defpackage;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* renamed from: Ty  reason: default package */
/* compiled from: SwipeRefreshLayout */
public final class Ty extends Animation {
    public final /* synthetic */ SwipeRefreshLayout a;

    public Ty(SwipeRefreshLayout swipeRefreshLayout) {
        this.a = swipeRefreshLayout;
    }

    public final void applyTransformation(float f, Transformation transformation) {
        SwipeRefreshLayout swipeRefreshLayout = this.a;
        float f2 = swipeRefreshLayout.e;
        swipeRefreshLayout.setAnimationProgress(((-f2) * f) + f2);
        swipeRefreshLayout.e(f);
    }
}
