package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import java.util.ArrayList;

/* renamed from: U0  reason: default package */
/* compiled from: AnimatedVectorDrawableCompat */
public final class U0 extends AnimatorListenerAdapter {
    public final /* synthetic */ AnimatedVectorDrawableCompat a;

    public U0(AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
        this.a = animatedVectorDrawableCompat;
    }

    public final void onAnimationEnd(Animator animator) {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = this.a;
        ArrayList arrayList = new ArrayList(animatedVectorDrawableCompat.f2547a);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((Animatable2Compat$AnimationCallback) arrayList.get(i)).onAnimationEnd(animatedVectorDrawableCompat);
        }
    }

    public final void onAnimationStart(Animator animator) {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = this.a;
        ArrayList arrayList = new ArrayList(animatedVectorDrawableCompat.f2547a);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((Animatable2Compat$AnimationCallback) arrayList.get(i)).onAnimationStart(animatedVectorDrawableCompat);
        }
    }
}
