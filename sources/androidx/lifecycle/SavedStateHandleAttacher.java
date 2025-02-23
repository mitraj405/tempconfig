package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* compiled from: SavedStateHandleSupport.kt */
public final class SavedStateHandleAttacher implements f {
    public final Uu a;

    public SavedStateHandleAttacher(Uu uu) {
        this.a = uu;
    }

    public final void b(LifecycleOwner lifecycleOwner, Lifecycle.a aVar) {
        boolean z;
        if (aVar == Lifecycle.a.ON_CREATE) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            lifecycleOwner.getLifecycle().c(this);
            this.a.c();
            return;
        }
        throw new IllegalStateException(("Next event must be ON_CREATE, it was " + aVar).toString());
    }
}
