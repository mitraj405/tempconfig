package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import com.google.android.material.animation.AnimationUtils;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ExpandCollapseAnimationHelper {
    private ValueAnimator.AnimatorUpdateListener additionalUpdateListener;
    private final View collapsedView;
    private int collapsedViewOffsetY;
    private long duration;
    private final List<View> endAnchoredViews = new ArrayList();
    /* access modifiers changed from: private */
    public final View expandedView;
    private int expandedViewOffsetY;
    private final List<AnimatorListenerAdapter> listeners = new ArrayList();

    public ExpandCollapseAnimationHelper(View view, View view2) {
        this.collapsedView = view;
        this.expandedView = view2;
    }

    private void addListeners(Animator animator, List<AnimatorListenerAdapter> list) {
        for (AnimatorListenerAdapter addListener : list) {
            animator.addListener(addListener);
        }
    }

    private AnimatorSet getAnimatorSet(boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{getExpandCollapseAnimator(z), getExpandedViewChildrenAlphaAnimator(z), getEndAnchoredViewsTranslateAnimator(z)});
        return animatorSet;
    }

    private Animator getEndAnchoredViewsTranslateAnimator(boolean z) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(float) ((this.collapsedView.getRight() - this.expandedView.getRight()) + (this.expandedView.getLeft() - this.collapsedView.getLeft())), 0.0f});
        ofFloat.addUpdateListener(MultiViewUpdateListener.translationXListener((Collection<View>) this.endAnchoredViews));
        ofFloat.setDuration(this.duration);
        ofFloat.setInterpolator(ReversableAnimatedValueInterpolator.of(z, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        return ofFloat;
    }

    private Animator getExpandCollapseAnimator(boolean z) {
        Rect calculateRectFromBounds = ViewUtils.calculateRectFromBounds(this.collapsedView, this.collapsedViewOffsetY);
        Rect calculateRectFromBounds2 = ViewUtils.calculateRectFromBounds(this.expandedView, this.expandedViewOffsetY);
        Rect rect = new Rect(calculateRectFromBounds);
        ValueAnimator ofObject = ValueAnimator.ofObject(new RectEvaluator(rect), new Object[]{calculateRectFromBounds, calculateRectFromBounds2});
        ofObject.addUpdateListener(new Cb(this, rect));
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.additionalUpdateListener;
        if (animatorUpdateListener != null) {
            ofObject.addUpdateListener(animatorUpdateListener);
        }
        ofObject.setDuration(this.duration);
        ofObject.setInterpolator(ReversableAnimatedValueInterpolator.of(z, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        return ofObject;
    }

    private Animator getExpandedViewChildrenAlphaAnimator(boolean z) {
        List<View> children = ViewUtils.getChildren(this.expandedView);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(MultiViewUpdateListener.alphaListener((Collection<View>) children));
        ofFloat.setDuration(this.duration);
        ofFloat.setInterpolator(ReversableAnimatedValueInterpolator.of(z, AnimationUtils.LINEAR_INTERPOLATOR));
        return ofFloat;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$getExpandCollapseAnimator$0(Rect rect, ValueAnimator valueAnimator) {
        ViewUtils.setBoundsFromRect(this.expandedView, rect);
    }

    @CanIgnoreReturnValue
    public ExpandCollapseAnimationHelper addEndAnchoredViews(View... viewArr) {
        Collections.addAll(this.endAnchoredViews, viewArr);
        return this;
    }

    @CanIgnoreReturnValue
    public ExpandCollapseAnimationHelper addListener(AnimatorListenerAdapter animatorListenerAdapter) {
        this.listeners.add(animatorListenerAdapter);
        return this;
    }

    public Animator getCollapseAnimator() {
        AnimatorSet animatorSet = getAnimatorSet(false);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                ExpandCollapseAnimationHelper.this.expandedView.setVisibility(8);
            }
        });
        addListeners(animatorSet, this.listeners);
        return animatorSet;
    }

    public Animator getExpandAnimator() {
        AnimatorSet animatorSet = getAnimatorSet(true);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                ExpandCollapseAnimationHelper.this.expandedView.setVisibility(0);
            }
        });
        addListeners(animatorSet, this.listeners);
        return animatorSet;
    }

    @CanIgnoreReturnValue
    public ExpandCollapseAnimationHelper setAdditionalUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.additionalUpdateListener = animatorUpdateListener;
        return this;
    }

    @CanIgnoreReturnValue
    public ExpandCollapseAnimationHelper setCollapsedViewOffsetY(int i) {
        this.collapsedViewOffsetY = i;
        return this;
    }

    @CanIgnoreReturnValue
    public ExpandCollapseAnimationHelper setDuration(long j) {
        this.duration = j;
        return this;
    }

    @CanIgnoreReturnValue
    public ExpandCollapseAnimationHelper setExpandedViewOffsetY(int i) {
        this.expandedViewOffsetY = i;
        return this;
    }

    @CanIgnoreReturnValue
    public ExpandCollapseAnimationHelper addEndAnchoredViews(Collection<View> collection) {
        this.endAnchoredViews.addAll(collection);
        return this;
    }
}
