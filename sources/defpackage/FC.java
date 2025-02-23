package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* renamed from: FC  reason: default package */
/* compiled from: ViewPropertyAnimatorCompat */
public final class FC extends AnimatorListenerAdapter {
    public final /* synthetic */ IC a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ View f199a;

    public FC(IC ic, View view) {
        this.a = ic;
        this.f199a = view;
    }

    public final void onAnimationCancel(Animator animator) {
        this.a.onAnimationCancel();
    }

    public final void onAnimationEnd(Animator animator) {
        this.a.onAnimationEnd();
    }

    public final void onAnimationStart(Animator animator) {
        this.a.a();
    }
}
