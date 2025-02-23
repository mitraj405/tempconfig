package defpackage;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* renamed from: Ry  reason: default package */
/* compiled from: SwipeRefreshLayout */
public final class Ry extends Animation {
    public final /* synthetic */ SwipeRefreshLayout a;

    public Ry(SwipeRefreshLayout swipeRefreshLayout) {
        this.a = swipeRefreshLayout;
    }

    public final void applyTransformation(float f, Transformation transformation) {
        this.a.setAnimationProgress(1.0f - f);
    }
}
