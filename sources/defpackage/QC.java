package defpackage;

import android.view.animation.Interpolator;

/* renamed from: QC  reason: default package */
/* compiled from: ViewTransition */
public final class QC implements Interpolator {
    public final /* synthetic */ T9 a;

    public QC(T9 t9) {
        this.a = t9;
    }

    public final float getInterpolation(float f) {
        return (float) this.a.a((double) f);
    }
}
