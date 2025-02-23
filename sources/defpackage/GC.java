package defpackage;

import android.animation.Animator;
import android.view.View;
import java.lang.ref.WeakReference;

/* renamed from: GC  reason: default package */
/* compiled from: ViewPropertyAnimatorCompat */
public final class GC {
    public final WeakReference<View> a;

    public GC(View view) {
        this.a = new WeakReference<>(view);
    }

    public final void a(float f) {
        View view = this.a.get();
        if (view != null) {
            view.animate().alpha(f);
        }
    }

    public final void b() {
        View view = this.a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public final void c(long j) {
        View view = this.a.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
    }

    public final void d(IC ic) {
        View view = this.a.get();
        if (view == null) {
            return;
        }
        if (ic != null) {
            view.animate().setListener(new FC(ic, view));
        } else {
            view.animate().setListener((Animator.AnimatorListener) null);
        }
    }

    public final void e(float f) {
        View view = this.a.get();
        if (view != null) {
            view.animate().translationY(f);
        }
    }
}
