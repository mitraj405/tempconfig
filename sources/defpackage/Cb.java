package defpackage;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import com.google.android.material.internal.ExpandCollapseAnimationHelper;

/* renamed from: Cb  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class Cb implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ Rect a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ExpandCollapseAnimationHelper f3495a;

    public /* synthetic */ Cb(ExpandCollapseAnimationHelper expandCollapseAnimationHelper, Rect rect) {
        this.f3495a = expandCollapseAnimationHelper;
        this.a = rect;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f3495a.lambda$getExpandCollapseAnimator$0(this.a, valueAnimator);
    }
}
