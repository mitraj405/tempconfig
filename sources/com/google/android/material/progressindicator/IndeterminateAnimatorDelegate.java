package com.google.android.material.progressindicator;

import android.animation.Animator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;
import com.google.android.material.progressindicator.DrawingDelegate;
import java.util.ArrayList;
import java.util.List;

abstract class IndeterminateAnimatorDelegate<T extends Animator> {
    protected final List<DrawingDelegate.ActiveIndicator> activeIndicators = new ArrayList();
    protected IndeterminateDrawable drawable;

    public IndeterminateAnimatorDelegate(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.activeIndicators.add(new DrawingDelegate.ActiveIndicator());
        }
    }

    public abstract void cancelAnimatorImmediately();

    public float getFractionInRange(int i, int i2, int i3) {
        return ((float) (i - i2)) / ((float) i3);
    }

    public abstract void invalidateSpecValues();

    public abstract void registerAnimatorsCompleteCallback(Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback);

    public void registerDrawable(IndeterminateDrawable indeterminateDrawable) {
        this.drawable = indeterminateDrawable;
    }

    public abstract void requestCancelAnimatorAfterCurrentCycle();

    public abstract void resetPropertiesForNewStart();

    public abstract void setAnimationFraction(float f);

    public abstract void startAnimator();

    public abstract void unregisterAnimatorsCompleteCallback();
}
