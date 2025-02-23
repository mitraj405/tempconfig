package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;
import in.juspay.hyper.constants.LogCategory;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* compiled from: LegacySavedStateHandleController.kt */
public final class d {

    /* compiled from: LegacySavedStateHandleController.kt */
    public static final class a implements SavedStateRegistry.a {
        public final void a(Xu xu) {
            LinkedHashMap linkedHashMap;
            C1177ig.f(xu, "owner");
            if (xu instanceof AC) {
                ViewModelStore viewModelStore = ((AC) xu).getViewModelStore();
                SavedStateRegistry savedStateRegistry = xu.getSavedStateRegistry();
                viewModelStore.getClass();
                Iterator it = new HashSet(viewModelStore.a.keySet()).iterator();
                while (true) {
                    boolean hasNext = it.hasNext();
                    linkedHashMap = viewModelStore.a;
                    if (!hasNext) {
                        break;
                    }
                    String str = (String) it.next();
                    C1177ig.f(str, "key");
                    C0404yC yCVar = (C0404yC) linkedHashMap.get(str);
                    C1177ig.c(yCVar);
                    d.a(yCVar, savedStateRegistry, xu.getLifecycle());
                }
                if (!new HashSet(linkedHashMap.keySet()).isEmpty()) {
                    savedStateRegistry.d();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner".toString());
        }
    }

    public static final void a(C0404yC yCVar, SavedStateRegistry savedStateRegistry, Lifecycle lifecycle) {
        Object obj;
        boolean z;
        C1177ig.f(savedStateRegistry, "registry");
        C1177ig.f(lifecycle, LogCategory.LIFECYCLE);
        HashMap hashMap = yCVar.a;
        if (hashMap == null) {
            obj = null;
        } else {
            synchronized (hashMap) {
                obj = yCVar.a.get("androidx.lifecycle.savedstate.vm.tag");
            }
        }
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) obj;
        if (savedStateHandleController != null && !savedStateHandleController.f2196a) {
            savedStateHandleController.c(lifecycle, savedStateRegistry);
            Lifecycle.State b = lifecycle.b();
            if (b != Lifecycle.State.INITIALIZED) {
                if (b.compareTo(Lifecycle.State.STARTED) >= 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    lifecycle.a(new LegacySavedStateHandleController$tryToAddRecreator$1(lifecycle, savedStateRegistry));
                    return;
                }
            }
            savedStateRegistry.d();
        }
    }
}
