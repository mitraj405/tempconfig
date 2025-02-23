package defpackage;

import android.animation.Animator;
import defpackage.l5;

/* renamed from: k5  reason: default package */
/* compiled from: CircularProgressDrawable */
public final class k5 implements Animator.AnimatorListener {
    public final /* synthetic */ l5.a a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ l5 f3050a;

    public k5(l5 l5Var, l5.a aVar) {
        this.f3050a = l5Var;
        this.a = aVar;
    }

    public final void onAnimationRepeat(Animator animator) {
        l5 l5Var = this.f3050a;
        l5.a aVar = this.a;
        l5Var.a(1.0f, aVar, true);
        aVar.e = aVar.a;
        aVar.f = aVar.b;
        aVar.g = aVar.c;
        aVar.a((aVar.f3062a + 1) % aVar.f3067a.length);
        if (l5Var.f3061a) {
            l5Var.f3061a = false;
            animator.cancel();
            animator.setDuration(1332);
            animator.start();
            if (aVar.f3066a) {
                aVar.f3066a = false;
                return;
            }
            return;
        }
        l5Var.b += 1.0f;
    }

    public final void onAnimationStart(Animator animator) {
        this.f3050a.b = 0.0f;
    }

    public final void onAnimationCancel(Animator animator) {
    }

    public final void onAnimationEnd(Animator animator) {
    }
}
