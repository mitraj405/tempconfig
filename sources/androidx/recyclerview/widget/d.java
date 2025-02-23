package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: DefaultItemAnimator */
public final class d extends AnimatorListenerAdapter {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ View f2377a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ViewPropertyAnimator f2378a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ RecyclerView.ViewHolder f2379a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ a f2380a;
    public final /* synthetic */ int b;

    public d(a aVar, RecyclerView.ViewHolder viewHolder, int i, View view, int i2, ViewPropertyAnimator viewPropertyAnimator) {
        this.f2380a = aVar;
        this.f2379a = viewHolder;
        this.a = i;
        this.f2377a = view;
        this.b = i2;
        this.f2378a = viewPropertyAnimator;
    }

    public final void onAnimationCancel(Animator animator) {
        int i = this.a;
        View view = this.f2377a;
        if (i != 0) {
            view.setTranslationX(0.0f);
        }
        if (this.b != 0) {
            view.setTranslationY(0.0f);
        }
    }

    public final void onAnimationEnd(Animator animator) {
        this.f2378a.setListener((Animator.AnimatorListener) null);
        a aVar = this.f2380a;
        RecyclerView.ViewHolder viewHolder = this.f2379a;
        aVar.h(viewHolder);
        aVar.j.remove(viewHolder);
        aVar.o();
    }

    public final void onAnimationStart(Animator animator) {
        this.f2380a.getClass();
    }
}
