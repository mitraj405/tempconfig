package defpackage;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.shape.MaterialShapeDrawable;
import in.juspay.hypernfc.Wave;

/* renamed from: d1  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0442d1 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ View f3518a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f3519a;

    public /* synthetic */ C0442d1(View view, int i, Object obj) {
        this.a = i;
        this.f3518a = view;
        this.f3519a = obj;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i = this.a;
        Object obj = this.f3519a;
        View view = this.f3518a;
        switch (i) {
            case 0:
                ((AppBarLayout) view).lambda$initializeLiftOnScrollWithElevation$1((MaterialShapeDrawable) obj, valueAnimator);
                return;
            default:
                ((Wave) view).lambda$createRingAnimator$1((Paint) obj, valueAnimator);
                return;
        }
    }
}
