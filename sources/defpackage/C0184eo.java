package defpackage;

import android.view.View;
import android.view.ViewTreeObserver;

/* renamed from: eo  reason: default package and case insensitive filesystem */
/* compiled from: OneShotPreDrawListener */
public final class C0184eo implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
    public final View a;

    /* renamed from: a  reason: collision with other field name */
    public ViewTreeObserver f2912a;

    /* renamed from: a  reason: collision with other field name */
    public final Runnable f2913a;

    public C0184eo(View view, Runnable runnable) {
        this.a = view;
        this.f2912a = view.getViewTreeObserver();
        this.f2913a = runnable;
    }

    public static void a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        } else if (runnable != null) {
            C0184eo eoVar = new C0184eo(view, runnable);
            view.getViewTreeObserver().addOnPreDrawListener(eoVar);
            view.addOnAttachStateChangeListener(eoVar);
        } else {
            throw new NullPointerException("runnable == null");
        }
    }

    public final boolean onPreDraw() {
        boolean isAlive = this.f2912a.isAlive();
        View view = this.a;
        if (isAlive) {
            this.f2912a.removeOnPreDrawListener(this);
        } else {
            view.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view.removeOnAttachStateChangeListener(this);
        this.f2913a.run();
        return true;
    }

    public final void onViewAttachedToWindow(View view) {
        this.f2912a = view.getViewTreeObserver();
    }

    public final void onViewDetachedFromWindow(View view) {
        boolean isAlive = this.f2912a.isAlive();
        View view2 = this.a;
        if (isAlive) {
            this.f2912a.removeOnPreDrawListener(this);
        } else {
            view2.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view2.removeOnAttachStateChangeListener(this);
    }
}
