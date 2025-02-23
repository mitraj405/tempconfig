package defpackage;

import android.transition.Transition;

/* renamed from: ud  reason: default package and case insensitive filesystem */
/* compiled from: FragmentTransitionCompat21 */
public final class C0354ud implements Transition.TransitionListener {
    public final /* synthetic */ Runnable a;

    public C0354ud(Runnable runnable) {
        this.a = runnable;
    }

    public final void onTransitionEnd(Transition transition) {
        this.a.run();
    }

    public final void onTransitionCancel(Transition transition) {
    }

    public final void onTransitionPause(Transition transition) {
    }

    public final void onTransitionResume(Transition transition) {
    }

    public final void onTransitionStart(Transition transition) {
    }
}
