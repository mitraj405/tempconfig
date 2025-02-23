package defpackage;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* renamed from: Hw  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0432Hw implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ View f3500a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ViewGroup.MarginLayoutParams f3501a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ SideSheetBehavior f3502a;

    public /* synthetic */ C0432Hw(SideSheetBehavior sideSheetBehavior, ViewGroup.MarginLayoutParams marginLayoutParams, int i, View view) {
        this.f3502a = sideSheetBehavior;
        this.f3501a = marginLayoutParams;
        this.a = i;
        this.f3500a = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f3502a.lambda$getCoplanarFinishAnimatorUpdateListener$1(this.f3501a, this.a, this.f3500a, valueAnimator);
    }
}
