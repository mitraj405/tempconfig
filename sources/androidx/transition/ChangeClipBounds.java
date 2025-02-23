package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import java.util.HashMap;

public class ChangeClipBounds extends Transition {
    public static final Rect a = new Rect();

    /* renamed from: a  reason: collision with other field name */
    public static final String[] f2474a = {"android:clipBounds:clip"};

    public static class a extends AnimatorListenerAdapter implements Transition.TransitionListener {
        public final Rect a;

        /* renamed from: a  reason: collision with other field name */
        public final View f2475a;
        public final Rect b;

        public a(Rect rect, Rect rect2, View view) {
            this.f2475a = view;
            this.a = rect;
            this.b = rect2;
        }

        public final void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        public final void onTransitionPause(Transition transition) {
            View view = this.f2475a;
            Rect clipBounds = view.getClipBounds();
            if (clipBounds == null) {
                clipBounds = ChangeClipBounds.a;
            }
            view.setTag(Br.transition_clip, clipBounds);
            view.setClipBounds(this.b);
        }

        public final void onTransitionResume(Transition transition) {
            int i = Br.transition_clip;
            View view = this.f2475a;
            view.setClipBounds((Rect) view.getTag(i));
            view.setTag(i, (Object) null);
        }

        public final void onAnimationEnd(Animator animator, boolean z) {
            View view = this.f2475a;
            if (!z) {
                view.setClipBounds(this.b);
            } else {
                view.setClipBounds(this.a);
            }
        }

        public final void onTransitionCancel(Transition transition) {
        }

        public final void onTransitionEnd(Transition transition) {
        }

        public final void onTransitionStart(Transition transition) {
        }
    }

    public ChangeClipBounds() {
    }

    public final void a(TransitionValues transitionValues, boolean z) {
        Rect rect;
        View view = transitionValues.a;
        if (view.getVisibility() != 8) {
            Rect rect2 = null;
            if (z) {
                rect = (Rect) view.getTag(Br.transition_clip);
            } else {
                rect = null;
            }
            if (rect == null) {
                rect = view.getClipBounds();
            }
            if (rect != a) {
                rect2 = rect;
            }
            HashMap hashMap = transitionValues.f2517a;
            hashMap.put("android:clipBounds:clip", rect2);
            if (rect2 == null) {
                hashMap.put("android:clipBounds:bounds", new Rect(0, 0, view.getWidth(), view.getHeight()));
            }
        }
    }

    public final void captureEndValues(TransitionValues transitionValues) {
        a(transitionValues, false);
    }

    public final void captureStartValues(TransitionValues transitionValues) {
        a(transitionValues, true);
    }

    public final Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        Rect rect;
        Rect rect2;
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        HashMap hashMap = transitionValues.f2517a;
        if (!hashMap.containsKey("android:clipBounds:clip")) {
            return null;
        }
        HashMap hashMap2 = transitionValues2.f2517a;
        if (!hashMap2.containsKey("android:clipBounds:clip")) {
            return null;
        }
        Rect rect3 = (Rect) hashMap.get("android:clipBounds:clip");
        Rect rect4 = (Rect) hashMap2.get("android:clipBounds:clip");
        if (rect3 == null && rect4 == null) {
            return null;
        }
        if (rect3 == null) {
            rect = (Rect) hashMap.get("android:clipBounds:bounds");
        } else {
            rect = rect3;
        }
        if (rect4 == null) {
            rect2 = (Rect) hashMap2.get("android:clipBounds:bounds");
        } else {
            rect2 = rect4;
        }
        if (rect.equals(rect2)) {
            return null;
        }
        transitionValues2.a.setClipBounds(rect3);
        Es es = new Es(new Rect());
        ObjectAnimator ofObject = ObjectAnimator.ofObject(transitionValues2.a, TC.f547a, es, new Rect[]{rect, rect2});
        a aVar = new a(rect3, rect4, transitionValues2.a);
        ofObject.addListener(aVar);
        addListener(aVar);
        return ofObject;
    }

    public final String[] getTransitionProperties() {
        return f2474a;
    }

    public final boolean isSeekingSupported() {
        return true;
    }

    public ChangeClipBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
