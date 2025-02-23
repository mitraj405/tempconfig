package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;

/* compiled from: LegacySavedStateHandleController.kt */
public final class LegacySavedStateHandleController$tryToAddRecreator$1 implements f {
    public final /* synthetic */ Lifecycle a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ SavedStateRegistry f2178a;

    public LegacySavedStateHandleController$tryToAddRecreator$1(Lifecycle lifecycle, SavedStateRegistry savedStateRegistry) {
        this.a = lifecycle;
        this.f2178a = savedStateRegistry;
    }

    public final void b(LifecycleOwner lifecycleOwner, Lifecycle.a aVar) {
        if (aVar == Lifecycle.a.ON_START) {
            this.a.c(this);
            this.f2178a.d();
        }
    }
}
