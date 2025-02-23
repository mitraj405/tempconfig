package defpackage;

import android.graphics.drawable.Drawable;

/* renamed from: gu  reason: default package */
/* compiled from: RoundRectDrawableWithShadow */
public final class gu extends Drawable {
    public static final double a = Math.cos(Math.toRadians(45.0d));

    /* renamed from: a  reason: collision with other field name */
    public static final /* synthetic */ int f2974a = 0;

    public static float a(float f, float f2, boolean z) {
        if (!z) {
            return f * 1.5f;
        }
        return (float) (((1.0d - a) * ((double) f2)) + ((double) (f * 1.5f)));
    }
}
