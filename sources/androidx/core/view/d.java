package androidx.core.view;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.f;

/* compiled from: ViewCompat */
public final class d extends f.b<CharSequence> {
    public d(int i) {
        super(i, CharSequence.class, 64, 30);
    }

    public final Object b(View view) {
        return f.j.b(view);
    }

    public final void c(View view, Object obj) {
        f.j.f(view, (CharSequence) obj);
    }

    public final boolean f(Object obj, Object obj2) {
        return !TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
    }
}
