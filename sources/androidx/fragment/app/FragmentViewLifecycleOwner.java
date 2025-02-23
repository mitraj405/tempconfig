package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.c;
import androidx.lifecycle.m;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;

public final class FragmentViewLifecycleOwner implements c, Xu, AC {
    public final Fragment a;

    /* renamed from: a  reason: collision with other field name */
    public LifecycleRegistry f2128a = null;

    /* renamed from: a  reason: collision with other field name */
    public ViewModelProvider.Factory f2129a;

    /* renamed from: a  reason: collision with other field name */
    public final ViewModelStore f2130a;

    /* renamed from: a  reason: collision with other field name */
    public SavedStateRegistryController f2131a = null;

    public FragmentViewLifecycleOwner(Fragment fragment, ViewModelStore viewModelStore) {
        this.a = fragment;
        this.f2130a = viewModelStore;
    }

    public final void a(Lifecycle.a aVar) {
        this.f2128a.f(aVar);
    }

    public final void b() {
        if (this.f2128a == null) {
            this.f2128a = new LifecycleRegistry(this);
            this.f2131a = new SavedStateRegistryController(this);
        }
    }

    public final ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        Application application;
        Fragment fragment = this.a;
        ViewModelProvider.Factory defaultViewModelProviderFactory = fragment.getDefaultViewModelProviderFactory();
        if (!defaultViewModelProviderFactory.equals(fragment.mDefaultFactory)) {
            this.f2129a = defaultViewModelProviderFactory;
            return defaultViewModelProviderFactory;
        }
        if (this.f2129a == null) {
            Context applicationContext = fragment.requireContext().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                } else if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                } else {
                    applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
                }
            }
            this.f2129a = new m(application, this, fragment.getArguments());
        }
        return this.f2129a;
    }

    public final Lifecycle getLifecycle() {
        b();
        return this.f2128a;
    }

    public final SavedStateRegistry getSavedStateRegistry() {
        b();
        return this.f2131a.f2413a;
    }

    public final ViewModelStore getViewModelStore() {
        b();
        return this.f2130a;
    }
}
