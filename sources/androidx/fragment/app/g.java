package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;

/* compiled from: DefaultSpecialEffectsController */
public final class g implements Runnable {
    public final /* synthetic */ Rect a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ View f2144a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C0379wd f2145a;

    public g(C0379wd wdVar, View view, Rect rect) {
        this.f2145a = wdVar;
        this.f2144a = view;
        this.a = rect;
    }

    public final void run() {
        this.f2145a.getClass();
        C0379wd.g(this.a, this.f2144a);
    }
}
