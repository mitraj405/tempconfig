package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.a;

/* compiled from: DefaultItemAnimator */
public final class e extends AnimatorListenerAdapter {
    public final /* synthetic */ View a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ViewPropertyAnimator f2381a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ a.d f2382a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ a f2383a;

    public e(a aVar, a.d dVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f2383a = aVar;
        this.f2382a = dVar;
        this.f2381a = viewPropertyAnimator;
        this.a = view;
    }

    public final void onAnimationEnd(Animator animator) {
        this.f2381a.setListener((Animator.AnimatorListener) null);
        View view = this.a;
        view.setAlpha(1.0f);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        a.d dVar = this.f2382a;
        RecyclerView.ViewHolder viewHolder = dVar.f2368a;
        a aVar = this.f2383a;
        aVar.h(viewHolder);
        aVar.l.remove(dVar.f2368a);
        aVar.o();
    }

    public final void onAnimationStart(Animator animator) {
        RecyclerView.ViewHolder viewHolder = this.f2382a.f2368a;
        this.f2383a.getClass();
    }
}
