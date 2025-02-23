package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: DefaultItemAnimator */
public final class c extends AnimatorListenerAdapter {
    public final /* synthetic */ View a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ViewPropertyAnimator f2374a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ RecyclerView.ViewHolder f2375a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ a f2376a;

    public c(View view, ViewPropertyAnimator viewPropertyAnimator, a aVar, RecyclerView.ViewHolder viewHolder) {
        this.f2376a = aVar;
        this.f2375a = viewHolder;
        this.a = view;
        this.f2374a = viewPropertyAnimator;
    }

    public final void onAnimationCancel(Animator animator) {
        this.a.setAlpha(1.0f);
    }

    public final void onAnimationEnd(Animator animator) {
        this.f2374a.setListener((Animator.AnimatorListener) null);
        a aVar = this.f2376a;
        RecyclerView.ViewHolder viewHolder = this.f2375a;
        aVar.h(viewHolder);
        aVar.i.remove(viewHolder);
        aVar.o();
    }

    public final void onAnimationStart(Animator animator) {
        this.f2376a.getClass();
    }
}
