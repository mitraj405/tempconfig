package androidx.lifecycle;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;

/* compiled from: HasDefaultViewModelProviderFactory.kt */
public interface c {
    CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.a.a;
    }

    ViewModelProvider.Factory getDefaultViewModelProviderFactory();
}
