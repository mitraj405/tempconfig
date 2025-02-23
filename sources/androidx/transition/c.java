package androidx.transition;

import androidx.transition.Transition;

/* compiled from: FragmentTransitionSupport */
public final class c implements Transition.TransitionListener {
    public final /* synthetic */ Runnable a;

    public c(Runnable runnable) {
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
