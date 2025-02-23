package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;
import in.juspay.hyper.constants.LogCategory;

/* compiled from: SavedStateHandleController.kt */
public final class SavedStateHandleController implements f {
    public final k a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f2196a;
    public final String c;

    public SavedStateHandleController(String str, k kVar) {
        this.c = str;
        this.a = kVar;
    }

    public final void b(LifecycleOwner lifecycleOwner, Lifecycle.a aVar) {
        if (aVar == Lifecycle.a.ON_DESTROY) {
            this.f2196a = false;
            lifecycleOwner.getLifecycle().c(this);
        }
    }

    public final void c(Lifecycle lifecycle, SavedStateRegistry savedStateRegistry) {
        C1177ig.f(savedStateRegistry, "registry");
        C1177ig.f(lifecycle, LogCategory.LIFECYCLE);
        if (!this.f2196a) {
            this.f2196a = true;
            lifecycle.a(this);
            savedStateRegistry.c(this.c, this.a.f2208a);
            return;
        }
        throw new IllegalStateException("Already attached to lifecycleOwner".toString());
    }
}
