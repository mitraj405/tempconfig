package defpackage;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.appcompat.app.h;

/* renamed from: EC  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class EC implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ JC a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ View f132a;

    public /* synthetic */ EC(h.c cVar, View view) {
        this.a = cVar;
        this.f132a = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ((View) h.this.f969a.getParent()).invalidate();
    }
}
