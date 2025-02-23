package defpackage;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* renamed from: Qe  reason: default package and case insensitive filesystem */
/* compiled from: HeightAnimation */
public final class C0652Qe extends Animation {
    public final float a;

    /* renamed from: a  reason: collision with other field name */
    public final View f3765a;
    public final int c;

    public C0652Qe(View view, int i, int i2) {
        this.f3765a = view;
        this.c = i;
        this.a = (float) (i2 - i);
    }

    public final void applyTransformation(float f, Transformation transformation) {
        View view = this.f3765a;
        view.getLayoutParams().height = (int) ((this.a * f) + ((float) this.c));
        view.requestLayout();
    }

    public final boolean willChangeBounds() {
        return true;
    }
}
