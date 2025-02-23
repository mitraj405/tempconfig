package com.google.android.material.motion;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.util.Property;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.BackEventCompat;
import androidx.core.view.f;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import java.util.WeakHashMap;

public class MaterialSideContainerBackHelper extends MaterialBackAnimationHelper<View> {
    private final float maxScaleXDistanceGrow;
    private final float maxScaleXDistanceShrink;
    private final float maxScaleYDistance;

    public MaterialSideContainerBackHelper(View view) {
        super(view);
        Resources resources = view.getResources();
        this.maxScaleXDistanceShrink = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_shrink);
        this.maxScaleXDistanceGrow = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_grow);
        this.maxScaleYDistance = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_y_distance);
    }

    private boolean checkAbsoluteGravity(int i, int i2) {
        V v = this.view;
        WeakHashMap<View, GC> weakHashMap = f.f1839a;
        if ((Gravity.getAbsoluteGravity(i, v.getLayoutDirection()) & i2) == i2) {
            return true;
        }
        return false;
    }

    private int getEdgeMargin(boolean z) {
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return 0;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (z) {
            return marginLayoutParams.leftMargin;
        }
        return marginLayoutParams.rightMargin;
    }

    public void cancelBackProgress() {
        if (super.onCancelBackProgress() != null) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(this.view, View.SCALE_X, new float[]{1.0f}), ObjectAnimator.ofFloat(this.view, View.SCALE_Y, new float[]{1.0f})});
            V v = this.view;
            if (v instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) v;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(viewGroup.getChildAt(i), View.SCALE_Y, new float[]{1.0f})});
                }
            }
            animatorSet.setDuration((long) this.cancelDuration);
            animatorSet.start();
        }
    }

    public void finishBackProgress(BackEventCompat backEventCompat, final int i, Animator.AnimatorListener animatorListener, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        final boolean z;
        if (backEventCompat.f805a == 0) {
            z = true;
        } else {
            z = false;
        }
        boolean checkAbsoluteGravity = checkAbsoluteGravity(i, 3);
        float scaleX = (this.view.getScaleX() * ((float) this.view.getWidth())) + ((float) getEdgeMargin(checkAbsoluteGravity));
        V v = this.view;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (checkAbsoluteGravity) {
            scaleX = -scaleX;
        }
        fArr[0] = scaleX;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(v, property, fArr);
        if (animatorUpdateListener != null) {
            ofFloat.addUpdateListener(animatorUpdateListener);
        }
        ofFloat.setInterpolator(new FastOutSlowInInterpolator());
        ofFloat.setDuration((long) AnimationUtils.lerp(this.hideDurationMax, this.hideDurationMin, backEventCompat.c));
        ofFloat.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                MaterialSideContainerBackHelper.this.view.setTranslationX(0.0f);
                MaterialSideContainerBackHelper.this.updateBackProgress(0.0f, z, i);
            }
        });
        if (animatorListener != null) {
            ofFloat.addListener(animatorListener);
        }
        ofFloat.start();
    }

    public void startBackProgress(BackEventCompat backEventCompat) {
        super.onStartBackProgress(backEventCompat);
    }

    public void updateBackProgress(BackEventCompat backEventCompat, int i) {
        if (super.onUpdateBackProgress(backEventCompat) != null) {
            updateBackProgress(backEventCompat.c, backEventCompat.f805a == 0, i);
        }
    }

    public void updateBackProgress(float f, boolean z, int i) {
        float f2;
        float interpolateProgress = interpolateProgress(f);
        boolean checkAbsoluteGravity = checkAbsoluteGravity(i, 3);
        boolean z2 = z == checkAbsoluteGravity;
        int width = this.view.getWidth();
        int height = this.view.getHeight();
        float f3 = (float) width;
        if (f3 > 0.0f) {
            float f4 = (float) height;
            if (f4 > 0.0f) {
                float f5 = this.maxScaleXDistanceShrink / f3;
                float f6 = this.maxScaleXDistanceGrow / f3;
                float f7 = this.maxScaleYDistance / f4;
                V v = this.view;
                if (checkAbsoluteGravity) {
                    f3 = 0.0f;
                }
                v.setPivotX(f3);
                if (!z2) {
                    f6 = -f5;
                }
                float lerp = AnimationUtils.lerp(0.0f, f6, interpolateProgress);
                float f8 = lerp + 1.0f;
                this.view.setScaleX(f8);
                float lerp2 = 1.0f - AnimationUtils.lerp(0.0f, f7, interpolateProgress);
                this.view.setScaleY(lerp2);
                V v2 = this.view;
                if (v2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) v2;
                    for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                        View childAt = viewGroup.getChildAt(i2);
                        if (checkAbsoluteGravity) {
                            f2 = (float) (childAt.getWidth() + (width - childAt.getRight()));
                        } else {
                            f2 = (float) (-childAt.getLeft());
                        }
                        childAt.setPivotX(f2);
                        childAt.setPivotY((float) (-childAt.getTop()));
                        float f9 = z2 ? 1.0f - lerp : 1.0f;
                        float f10 = lerp2 != 0.0f ? (f8 / lerp2) * f9 : 1.0f;
                        childAt.setScaleX(f9);
                        childAt.setScaleY(f10);
                    }
                }
            }
        }
    }
}
