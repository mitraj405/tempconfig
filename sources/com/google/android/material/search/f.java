package com.google.android.material.search;

import android.animation.ValueAnimator;
import com.google.android.material.internal.FadeThroughDrawable;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class f implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ FadeThroughDrawable a;

    public /* synthetic */ f(FadeThroughDrawable fadeThroughDrawable) {
        this.a = fadeThroughDrawable;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.setProgress(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
