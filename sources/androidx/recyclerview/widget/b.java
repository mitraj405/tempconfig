package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: DefaultItemAnimator */
public final class b extends AnimatorListenerAdapter {
    public final /* synthetic */ View a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ViewPropertyAnimator f2371a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ RecyclerView.ViewHolder f2372a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ a f2373a;

    public b(View view, ViewPropertyAnimator viewPropertyAnimator, a aVar, RecyclerView.ViewHolder viewHolder) {
        this.f2373a = aVar;
        this.f2372a = viewHolder;
        this.f2371a = viewPropertyAnimator;
        this.a = view;
    }

    public final void onAnimationEnd(Animator animator) {
        this.f2371a.setListener((Animator.AnimatorListener) null);
        this.a.setAlpha(1.0f);
        a aVar = this.f2373a;
        RecyclerView.ViewHolder viewHolder = this.f2372a;
        aVar.h(viewHolder);
        aVar.k.remove(viewHolder);
        aVar.o();
    }

    public final void onAnimationStart(Animator animator) {
        this.f2373a.getClass();
    }
}
