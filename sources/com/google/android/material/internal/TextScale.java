package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import java.util.HashMap;

public class TextScale extends Transition {
    private static final String PROPNAME_SCALE = "android:textscale:scale";

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.a;
        if (view instanceof TextView) {
            transitionValues.f2517a.put(PROPNAME_SCALE, Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        float f;
        if (transitionValues == null || transitionValues2 == null || !(transitionValues.a instanceof TextView)) {
            return null;
        }
        View view = transitionValues2.a;
        if (!(view instanceof TextView)) {
            return null;
        }
        final TextView textView = (TextView) view;
        HashMap hashMap = transitionValues.f2517a;
        float f2 = 1.0f;
        if (hashMap.get(PROPNAME_SCALE) != null) {
            f = ((Float) hashMap.get(PROPNAME_SCALE)).floatValue();
        } else {
            f = 1.0f;
        }
        HashMap hashMap2 = transitionValues2.f2517a;
        if (hashMap2.get(PROPNAME_SCALE) != null) {
            f2 = ((Float) hashMap2.get(PROPNAME_SCALE)).floatValue();
        }
        if (f == f2) {
            return null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f, f2});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                textView.setScaleX(floatValue);
                textView.setScaleY(floatValue);
            }
        });
        return ofFloat;
    }
}
