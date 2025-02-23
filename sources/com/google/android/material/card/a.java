package com.google.android.material.card;

import android.animation.ValueAnimator;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ MaterialCardViewHelper a;

    public /* synthetic */ a(MaterialCardViewHelper materialCardViewHelper) {
        this.a = materialCardViewHelper;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.lambda$animateCheckedIcon$0(valueAnimator);
    }
}
