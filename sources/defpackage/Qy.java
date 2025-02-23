package defpackage;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* renamed from: Qy  reason: default package */
/* compiled from: SwipeRefreshLayout */
public final class Qy extends Animation {
    public final /* synthetic */ SwipeRefreshLayout a;

    public Qy(SwipeRefreshLayout swipeRefreshLayout) {
        this.a = swipeRefreshLayout;
    }

    public final void applyTransformation(float f, Transformation transformation) {
        this.a.setAnimationProgress(f);
    }
}
