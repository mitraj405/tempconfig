package com.google.android.material.search;

import android.animation.ValueAnimator;
import android.view.View;
import com.google.android.material.shape.MaterialShapeDrawable;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ MaterialShapeDrawable f3514a;

    public /* synthetic */ b(View view, MaterialShapeDrawable materialShapeDrawable) {
        this.f3514a = materialShapeDrawable;
        this.a = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        SearchBarAnimationHelper.lambda$getExpandedViewBackgroundUpdateListener$1(this.f3514a, this.a, valueAnimator);
    }
}
