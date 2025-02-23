package defpackage;

import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.os.LocaleList;
import com.google.firebase.perf.util.Constants;

/* renamed from: Lh  reason: default package */
/* compiled from: LPaint */
public final class Lh extends Paint {
    public Lh() {
    }

    public final void setAlpha(int i) {
        if (Build.VERSION.SDK_INT < 30) {
            int color = getColor();
            PointF pointF = C0308ql.a;
            setColor((Math.max(0, Math.min(Constants.MAX_HOST_LENGTH, i)) << 24) | (color & 16777215));
            return;
        }
        PointF pointF2 = C0308ql.a;
        super.setAlpha(Math.max(0, Math.min(Constants.MAX_HOST_LENGTH, i)));
    }

    public Lh(int i) {
        super(i);
    }

    public Lh(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    public Lh(PorterDuff.Mode mode, int i) {
        super(1);
        setXfermode(new PorterDuffXfermode(mode));
    }

    public final void setTextLocales(LocaleList localeList) {
    }
}
