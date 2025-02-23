package androidx.activity;

import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.f;

final class ImmLeaksCleaner implements f {
    public static int c;

    public ImmLeaksCleaner() {
        throw null;
    }

    public final void b(LifecycleOwner lifecycleOwner, Lifecycle.a aVar) {
        if (aVar == Lifecycle.a.ON_DESTROY) {
            if (c == 0) {
                Class<InputMethodManager> cls = InputMethodManager.class;
                try {
                    c = 2;
                    cls.getDeclaredField("mServedView").setAccessible(true);
                    cls.getDeclaredField("mNextServedView").setAccessible(true);
                    cls.getDeclaredField("mH").setAccessible(true);
                    c = 1;
                } catch (NoSuchFieldException unused) {
                }
            }
            if (c == 1) {
                throw null;
            }
        }
    }
}
