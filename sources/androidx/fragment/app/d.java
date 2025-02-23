package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.j;

/* compiled from: DefaultSpecialEffectsController */
public final class d implements Animation.AnimationListener {
    public final /* synthetic */ View a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ViewGroup f2138a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ j.a f2139a;

    /* compiled from: DefaultSpecialEffectsController */
    public class a implements Runnable {
        public a() {
        }

        public final void run() {
            d dVar = d.this;
            dVar.f2138a.endViewTransition(dVar.a);
            dVar.f2139a.a();
        }
    }

    public d(View view, ViewGroup viewGroup, j.a aVar) {
        this.f2138a = viewGroup;
        this.a = view;
        this.f2139a = aVar;
    }

    public final void onAnimationEnd(Animation animation) {
        this.f2138a.post(new a());
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }
}
