package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.animation.BaseInterpolator;
import androidx.transition.Transition;

/* compiled from: TranslationAnimationCreator */
public final class g {
    public static ObjectAnimator a(View view, TransitionValues transitionValues, int i, int i2, float f, float f2, float f3, float f4, BaseInterpolator baseInterpolator, Transition transition) {
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) transitionValues.a.getTag(Br.transition_position);
        if (iArr != null) {
            f = ((float) (iArr[0] - i)) + translationX;
            f2 = ((float) (iArr[1] - i2)) + translationY;
        }
        view.setTranslationX(f);
        view.setTranslationY(f2);
        if (f == f3 && f2 == f4) {
            return null;
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{f, f3}), PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{f2, f4})});
        a aVar = new a(view, transitionValues.a, translationX, translationY);
        transition.addListener(aVar);
        ofPropertyValuesHolder.addListener(aVar);
        ofPropertyValuesHolder.setInterpolator(baseInterpolator);
        return ofPropertyValuesHolder;
    }

    /* compiled from: TranslationAnimationCreator */
    public static class a extends AnimatorListenerAdapter implements Transition.TransitionListener {
        public float a;

        /* renamed from: a  reason: collision with other field name */
        public final View f2540a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f2541a;

        /* renamed from: a  reason: collision with other field name */
        public int[] f2542a;
        public float b;

        /* renamed from: b  reason: collision with other field name */
        public final View f2543b;
        public final float c;
        public final float d;

        public a(View view, View view2, float f, float f2) {
            this.f2543b = view;
            this.f2540a = view2;
            this.c = f;
            this.d = f2;
            int i = Br.transition_position;
            int[] iArr = (int[]) view2.getTag(i);
            this.f2542a = iArr;
            if (iArr != null) {
                view2.setTag(i, (Object) null);
            }
        }

        public final void onAnimationCancel(Animator animator) {
            this.f2541a = true;
            float f = this.c;
            View view = this.f2543b;
            view.setTranslationX(f);
            view.setTranslationY(this.d);
        }

        public final void onAnimationEnd(Animator animator, boolean z) {
            if (!z) {
                float f = this.c;
                View view = this.f2543b;
                view.setTranslationX(f);
                view.setTranslationY(this.d);
            }
        }

        public final void onTransitionCancel(Transition transition) {
            this.f2541a = true;
            float f = this.c;
            View view = this.f2543b;
            view.setTranslationX(f);
            view.setTranslationY(this.d);
        }

        public final void onTransitionEnd(Transition transition, boolean z) {
            if (!this.f2541a) {
                this.f2540a.setTag(Br.transition_position, (Object) null);
            }
        }

        public final void onTransitionPause(Transition transition) {
            if (this.f2542a == null) {
                this.f2542a = new int[2];
            }
            int[] iArr = this.f2542a;
            View view = this.f2543b;
            view.getLocationOnScreen(iArr);
            this.f2540a.setTag(Br.transition_position, this.f2542a);
            this.a = view.getTranslationX();
            this.b = view.getTranslationY();
            view.setTranslationX(this.c);
            view.setTranslationY(this.d);
        }

        public final void onTransitionResume(Transition transition) {
            float f = this.a;
            View view = this.f2543b;
            view.setTranslationX(f);
            view.setTranslationY(this.b);
        }

        public final void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        public final void onTransitionEnd(Transition transition) {
            onTransitionEnd(transition, false);
        }

        public final void onTransitionStart(Transition transition) {
        }
    }
}
