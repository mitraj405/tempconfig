package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.j;
import defpackage.A4;

/* compiled from: DefaultSpecialEffectsController */
public final class e implements A4.a {
    public final /* synthetic */ View a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ViewGroup f2140a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ j.a f2141a;

    public e(View view, ViewGroup viewGroup, j.a aVar) {
        this.a = view;
        this.f2140a = viewGroup;
        this.f2141a = aVar;
    }

    public final void onCancel() {
        View view = this.a;
        view.clearAnimation();
        this.f2140a.endViewTransition(view);
        this.f2141a.a();
    }
}
