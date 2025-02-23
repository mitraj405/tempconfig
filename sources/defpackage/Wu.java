package defpackage;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.f;
import androidx.savedstate.SavedStateRegistry;

/* renamed from: Wu  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class Wu implements f {
    public final /* synthetic */ SavedStateRegistry a;

    public /* synthetic */ Wu(SavedStateRegistry savedStateRegistry) {
        this.a = savedStateRegistry;
    }

    public final void b(LifecycleOwner lifecycleOwner, Lifecycle.a aVar) {
        SavedStateRegistry savedStateRegistry = this.a;
        C1177ig.f(savedStateRegistry, "this$0");
        if (aVar == Lifecycle.a.ON_START) {
            savedStateRegistry.c = true;
        } else if (aVar == Lifecycle.a.ON_STOP) {
            savedStateRegistry.c = false;
        }
    }
}
