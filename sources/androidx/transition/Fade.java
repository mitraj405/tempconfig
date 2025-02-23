package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;

public class Fade extends Visibility {

    public static class a extends AnimatorListenerAdapter implements Transition.TransitionListener {
        public final View a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f2495a = false;

        public a(View view) {
            this.a = view;
        }

        public final void onAnimationCancel(Animator animator) {
            TC.b(this.a, 1.0f);
        }

        public final void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        public final void onAnimationStart(Animator animator) {
            View view = this.a;
            if (view.hasOverlappingRendering() && view.getLayerType() == 0) {
                this.f2495a = true;
                view.setLayerType(2, (Paint) null);
            }
        }

        public final void onTransitionPause(Transition transition) {
            float f;
            View view = this.a;
            if (view.getVisibility() == 0) {
                f = TC.f548a.a(view);
            } else {
                f = 0.0f;
            }
            view.setTag(Br.transition_pause_alpha, Float.valueOf(f));
        }

        public final void onTransitionResume(Transition transition) {
            this.a.setTag(Br.transition_pause_alpha, (Object) null);
        }

        public final void onTransitionStart(Transition transition) {
        }

        public final void onAnimationEnd(Animator animator, boolean z) {
            boolean z2 = this.f2495a;
            View view = this.a;
            if (z2) {
                view.setLayerType(0, (Paint) null);
            }
            if (!z) {
                TC.b(view, 1.0f);
                TC.f548a.getClass();
            }
        }

        public final void onTransitionStart(Transition transition, boolean z) {
        }

        public final void onTransitionCancel(Transition transition) {
        }

        public final void onTransitionEnd(Transition transition) {
        }
    }

    public Fade(int i) {
        setMode(i);
    }

    public static float b(TransitionValues transitionValues, float f) {
        Float f2;
        if (transitionValues == null || (f2 = (Float) transitionValues.f2517a.get("android:fade:transitionAlpha")) == null) {
            return f;
        }
        return f2.floatValue();
    }

    public final ObjectAnimator a(float f, float f2, View view) {
        if (f == f2) {
            return null;
        }
        TC.b(view, f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, TC.a, new float[]{f2});
        a aVar = new a(view);
        ofFloat.addListener(aVar);
        getRootTransition().addListener(aVar);
        return ofFloat;
    }

    public final void captureStartValues(TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        Float f = (Float) transitionValues.a.getTag(Br.transition_pause_alpha);
        if (f == null) {
            if (transitionValues.a.getVisibility() == 0) {
                f = Float.valueOf(TC.f548a.a(transitionValues.a));
            } else {
                f = Float.valueOf(0.0f);
            }
        }
        transitionValues.f2517a.put("android:fade:transitionAlpha", f);
    }

    public final boolean isSeekingSupported() {
        return true;
    }

    public final Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        TC.f548a.getClass();
        return a(b(transitionValues, 0.0f), 1.0f, view);
    }

    public final Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        TC.f548a.getClass();
        ObjectAnimator a2 = a(b(transitionValues, 1.0f), 0.0f, view);
        if (a2 == null) {
            TC.b(view, b(transitionValues2, 1.0f));
        }
        return a2;
    }

    public Fade() {
    }

    public Fade(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0385wy.d);
        setMode(SA.c(obtainStyledAttributes, (XmlResourceParser) attributeSet, "fadingMode", 0, getMode()));
        obtainStyledAttributes.recycle();
    }
}
