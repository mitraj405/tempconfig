package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.a;

/* compiled from: DefaultItemAnimator */
public final class f extends AnimatorListenerAdapter {
    public final /* synthetic */ View a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ViewPropertyAnimator f2384a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ a.d f2385a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ a f2386a;

    public f(a aVar, a.d dVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f2386a = aVar;
        this.f2385a = dVar;
        this.f2384a = viewPropertyAnimator;
        this.a = view;
    }

    public final void onAnimationEnd(Animator animator) {
        this.f2384a.setListener((Animator.AnimatorListener) null);
        View view = this.a;
        view.setAlpha(1.0f);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        a.d dVar = this.f2385a;
        RecyclerView.ViewHolder viewHolder = dVar.f2369b;
        a aVar = this.f2386a;
        aVar.h(viewHolder);
        aVar.l.remove(dVar.f2369b);
        aVar.o();
    }

    public final void onAnimationStart(Animator animator) {
        RecyclerView.ViewHolder viewHolder = this.f2385a.f2369b;
        this.f2386a.getClass();
    }
}
