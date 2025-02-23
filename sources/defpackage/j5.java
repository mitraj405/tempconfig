package defpackage;

import android.animation.ValueAnimator;
import defpackage.l5;

/* renamed from: j5  reason: default package */
/* compiled from: CircularProgressDrawable */
public final class j5 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ l5.a a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ l5 f3024a;

    public j5(l5 l5Var, l5.a aVar) {
        this.f3024a = l5Var;
        this.a = aVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        l5 l5Var = this.f3024a;
        l5Var.getClass();
        l5.a aVar = this.a;
        l5.d(floatValue, aVar);
        l5Var.a(floatValue, aVar, false);
        l5Var.invalidateSelf();
    }
}
