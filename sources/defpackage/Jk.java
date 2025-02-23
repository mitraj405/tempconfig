package defpackage;

import android.animation.ValueAnimator;
import com.google.android.material.internal.ClippableRoundedCornerLayout;

/* renamed from: Jk  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class Jk implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ClippableRoundedCornerLayout a;

    public /* synthetic */ Jk(ClippableRoundedCornerLayout clippableRoundedCornerLayout) {
        this.a = clippableRoundedCornerLayout;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.updateCornerRadius(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
