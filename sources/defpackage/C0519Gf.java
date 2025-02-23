package defpackage;

import android.animation.TimeInterpolator;
import in.juspay.hypersdk.core.InflateView;

/* renamed from: Gf  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0519Gf implements TimeInterpolator {
    public final /* synthetic */ float[] a;

    public /* synthetic */ C0519Gf(float[] fArr) {
        this.a = fArr;
    }

    public final float getInterpolation(float f) {
        return InflateView.lambda$getCustomEasing$10(this.a, f);
    }
}
