package com.google.android.material.search;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f3515a;

    public /* synthetic */ c(Object obj, int i) {
        this.a = i;
        this.f3515a = obj;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i = this.a;
        Object obj = this.f3515a;
        switch (i) {
            case 0:
                ((View) obj).setAlpha(0.0f);
                return;
            default:
                SearchViewAnimationHelper.lambda$addDrawerArrowDrawableAnimatorIfNeeded$3((DrawerArrowDrawable) obj, valueAnimator);
                return;
        }
    }
}
