package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.j;
import androidx.fragment.app.s;

/* compiled from: DefaultSpecialEffectsController */
public final class c extends AnimatorListenerAdapter {
    public final /* synthetic */ View a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ViewGroup f2134a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ j.a f2135a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ s.d f2136a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f2137a;

    public c(ViewGroup viewGroup, View view, boolean z, s.d dVar, j.a aVar) {
        this.f2134a = viewGroup;
        this.a = view;
        this.f2137a = z;
        this.f2136a = dVar;
        this.f2135a = aVar;
    }

    public final void onAnimationEnd(Animator animator) {
        ViewGroup viewGroup = this.f2134a;
        View view = this.a;
        viewGroup.endViewTransition(view);
        if (this.f2137a) {
            this.f2136a.f2171a.a(view);
        }
        this.f2135a.a();
    }
}
