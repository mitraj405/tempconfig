package androidx.loader.app;

import androidx.lifecycle.LifecycleOwner;

public abstract class LoaderManager {
    public static ii a(LifecycleOwner lifecycleOwner) {
        return new ii(lifecycleOwner, ((AC) lifecycleOwner).getViewModelStore());
    }
}
