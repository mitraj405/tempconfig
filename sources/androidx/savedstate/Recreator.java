package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.f;
import androidx.savedstate.SavedStateRegistry;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* compiled from: Recreator.kt */
public final class Recreator implements f {
    public final Xu a;

    /* compiled from: Recreator.kt */
    public static final class a implements SavedStateRegistry.b {
        public final LinkedHashSet a = new LinkedHashSet();

        public a(SavedStateRegistry savedStateRegistry) {
            C1177ig.f(savedStateRegistry, "registry");
            savedStateRegistry.c("androidx.savedstate.Restarter", this);
        }

        public final Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList(this.a));
            return bundle;
        }
    }

    public Recreator(Xu xu) {
        C1177ig.f(xu, "owner");
        this.a = xu;
    }

    public final void b(LifecycleOwner lifecycleOwner, Lifecycle.a aVar) {
        if (aVar == Lifecycle.a.ON_CREATE) {
            lifecycleOwner.getLifecycle().c(this);
            Xu xu = this.a;
            Bundle a2 = xu.getSavedStateRegistry().a("androidx.savedstate.Restarter");
            if (a2 != null) {
                ArrayList<String> stringArrayList = a2.getStringArrayList("classes_to_restore");
                if (stringArrayList != null) {
                    for (String next : stringArrayList) {
                        try {
                            Class<? extends U> asSubclass = Class.forName(next, false, Recreator.class.getClassLoader()).asSubclass(SavedStateRegistry.a.class);
                            C1177ig.e(asSubclass, "{\n                Class.…class.java)\n            }");
                            try {
                                Constructor<? extends U> declaredConstructor = asSubclass.getDeclaredConstructor(new Class[0]);
                                declaredConstructor.setAccessible(true);
                                try {
                                    Object newInstance = declaredConstructor.newInstance(new Object[0]);
                                    C1177ig.e(newInstance, "{\n                constr…wInstance()\n            }");
                                    ((SavedStateRegistry.a) newInstance).a(xu);
                                } catch (Exception e) {
                                    throw new RuntimeException(C0709Uj.i("Failed to instantiate ", next), e);
                                }
                            } catch (NoSuchMethodException e2) {
                                throw new IllegalStateException("Class " + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
                            }
                        } catch (ClassNotFoundException e3) {
                            throw new RuntimeException(lf.j("Class ", next, " wasn't found"), e3);
                        }
                    }
                    return;
                }
                throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
            }
            return;
        }
        throw new AssertionError("Next event must be ON_CREATE");
    }
}
