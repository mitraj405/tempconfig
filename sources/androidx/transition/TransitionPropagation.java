package androidx.transition;

import android.annotation.SuppressLint;
import android.view.ViewGroup;

public abstract class TransitionPropagation {
    public abstract void a(TransitionValues transitionValues);

    @SuppressLint({"NullableCollection"})
    public abstract void b();

    public abstract long c(ViewGroup viewGroup, Transition transition, TransitionValues transitionValues, TransitionValues transitionValues2);
}
