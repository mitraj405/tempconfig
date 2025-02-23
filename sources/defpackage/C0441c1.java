package defpackage;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.shape.MaterialShapeDrawable;

/* renamed from: c1  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0441c1 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ColorStateList a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ AppBarLayout f3506a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ MaterialShapeDrawable f3507a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Integer f3508a;
    public final /* synthetic */ ColorStateList b;

    public /* synthetic */ C0441c1(AppBarLayout appBarLayout, ColorStateList colorStateList, ColorStateList colorStateList2, MaterialShapeDrawable materialShapeDrawable, Integer num) {
        this.f3506a = appBarLayout;
        this.a = colorStateList;
        this.b = colorStateList2;
        this.f3507a = materialShapeDrawable;
        this.f3508a = num;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f3506a.lambda$initializeLiftOnScrollWithColor$0(this.a, this.b, this.f3507a, this.f3508a, valueAnimator);
    }
}
