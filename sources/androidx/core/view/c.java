package androidx.core.view;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.f;

/* compiled from: ViewCompat */
public final class c extends f.b<CharSequence> {
    public c(int i) {
        super(i, CharSequence.class, 8, 28);
    }

    public final Object b(View view) {
        return f.h.b(view);
    }

    public final void c(View view, Object obj) {
        f.h.h(view, (CharSequence) obj);
    }

    public final boolean f(Object obj, Object obj2) {
        return !TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
    }
}
