package com.google.android.material.search;

import android.animation.ValueAnimator;
import android.graphics.Rect;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class i implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ float a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Rect f3516a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ SearchViewAnimationHelper f3517a;
    public final /* synthetic */ float b;

    public /* synthetic */ i(SearchViewAnimationHelper searchViewAnimationHelper, float f, float f2, Rect rect) {
        this.f3517a = searchViewAnimationHelper;
        this.a = f;
        this.b = f2;
        this.f3516a = rect;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f3517a.lambda$getRootViewAnimator$2(this.a, this.b, this.f3516a, valueAnimator);
    }
}
