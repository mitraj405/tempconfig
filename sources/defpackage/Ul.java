package defpackage;

import android.view.animation.Interpolator;

/* renamed from: Ul  reason: default package */
/* compiled from: MotionController */
public final class Ul implements Interpolator {
    public final /* synthetic */ T9 a;

    public Ul(T9 t9) {
        this.a = t9;
    }

    public final float getInterpolation(float f) {
        return (float) this.a.a((double) f);
    }
}
