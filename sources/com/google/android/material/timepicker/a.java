package com.google.android.material.timepicker;

import android.animation.ValueAnimator;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ClockHandView a;

    public /* synthetic */ a(ClockHandView clockHandView) {
        this.a = clockHandView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.lambda$setHandRotation$0(valueAnimator);
    }
}
