package defpackage;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat$TouchExplorationStateChangeListener;
import com.google.android.material.search.SearchBar;
import com.google.android.material.search.SearchView;

/* renamed from: Av  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class Av implements AccessibilityManagerCompat$TouchExplorationStateChangeListener, OnApplyWindowInsetsListener {
    public final /* synthetic */ ViewGroup a;

    public /* synthetic */ Av(ViewGroup viewGroup) {
        this.a = viewGroup;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return ((SearchView) this.a).lambda$setUpStatusBarSpacerInsetListener$5(view, windowInsetsCompat);
    }

    public final void onTouchExplorationStateChanged(boolean z) {
        ((SearchBar) this.a).lambda$new$0(z);
    }
}
