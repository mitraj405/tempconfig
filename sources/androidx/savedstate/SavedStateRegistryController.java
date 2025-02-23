package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;
import defpackage.Nu;
import java.util.Map;

/* compiled from: SavedStateRegistryController.kt */
public final class SavedStateRegistryController {
    public final Xu a;

    /* renamed from: a  reason: collision with other field name */
    public final SavedStateRegistry f2413a = new SavedStateRegistry();

    /* renamed from: a  reason: collision with other field name */
    public boolean f2414a;

    public SavedStateRegistryController(Xu xu) {
        this.a = xu;
    }

    public final void a() {
        boolean z;
        Xu xu = this.a;
        Lifecycle lifecycle = xu.getLifecycle();
        if (lifecycle.b() == Lifecycle.State.INITIALIZED) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            lifecycle.a(new Recreator(xu));
            SavedStateRegistry savedStateRegistry = this.f2413a;
            savedStateRegistry.getClass();
            if (!savedStateRegistry.f2412a) {
                lifecycle.a(new Wu(savedStateRegistry));
                savedStateRegistry.f2412a = true;
                this.f2414a = true;
                return;
            }
            throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
    }

    public final void b(Bundle bundle) {
        boolean z;
        Bundle bundle2;
        if (!this.f2414a) {
            a();
        }
        Lifecycle lifecycle = this.a.getLifecycle();
        if (lifecycle.b().compareTo(Lifecycle.State.STARTED) >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            SavedStateRegistry savedStateRegistry = this.f2413a;
            if (!savedStateRegistry.f2412a) {
                throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
            } else if (!savedStateRegistry.b) {
                if (bundle != null) {
                    bundle2 = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
                } else {
                    bundle2 = null;
                }
                savedStateRegistry.f2410a = bundle2;
                savedStateRegistry.b = true;
            } else {
                throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
            }
        } else {
            throw new IllegalStateException(("performRestore cannot be called when owner is " + lifecycle.b()).toString());
        }
    }

    public final void c(Bundle bundle) {
        C1177ig.f(bundle, "outBundle");
        SavedStateRegistry savedStateRegistry = this.f2413a;
        savedStateRegistry.getClass();
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = savedStateRegistry.f2410a;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        Nu<String, SavedStateRegistry.b> nu = savedStateRegistry.a;
        nu.getClass();
        Nu.d dVar = new Nu.d();
        nu.f453a.put(dVar, Boolean.FALSE);
        while (dVar.hasNext()) {
            Map.Entry entry = (Map.Entry) dVar.next();
            bundle2.putBundle((String) entry.getKey(), ((SavedStateRegistry.b) entry.getValue()).a());
        }
        if (!bundle2.isEmpty()) {
            bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
        }
    }
}
