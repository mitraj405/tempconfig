package androidx.core.view;

import android.view.View;
import androidx.core.view.f;

/* compiled from: ViewCompat */
public final class b extends f.b<Boolean> {
    public b(int i) {
        super(i, Boolean.class, 0, 28);
    }

    public final Object b(View view) {
        return Boolean.valueOf(f.h.d(view));
    }

    public final void c(View view, Object obj) {
        f.h.j(view, ((Boolean) obj).booleanValue());
    }

    public final boolean f(Object obj, Object obj2) {
        return !f.b.a((Boolean) obj, (Boolean) obj2);
    }
}
