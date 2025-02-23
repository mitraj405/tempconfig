package com.google.android.material.internal;

import android.animation.ValueAnimator;
import android.view.View;
import com.google.android.material.internal.MultiViewUpdateListener;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class a implements MultiViewUpdateListener.Listener {
    public final /* synthetic */ int a;

    public /* synthetic */ a(int i) {
        this.a = i;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator, View view) {
        switch (this.a) {
            case 0:
                MultiViewUpdateListener.setTranslationX(valueAnimator, view);
                return;
            default:
                MultiViewUpdateListener.setTranslationY(valueAnimator, view);
                return;
        }
    }
}
