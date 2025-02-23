package androidx.core.view;

import android.view.View;
import androidx.core.view.f;

/* compiled from: ViewCompat */
public final class e extends f.b<Boolean> {
    public e(int i) {
        super(i, Boolean.class, 0, 28);
    }

    public final Object b(View view) {
        return Boolean.valueOf(f.h.c(view));
    }

    public final void c(View view, Object obj) {
        f.h.g(view, ((Boolean) obj).booleanValue());
    }

    public final boolean f(Object obj, Object obj2) {
        return !f.b.a((Boolean) obj, (Boolean) obj2);
    }
}
