package defpackage;

import android.annotation.SuppressLint;
import android.view.View;

/* renamed from: XC  reason: default package */
/* compiled from: ViewUtilsApi22 */
public class XC extends WC {
    public static boolean f = true;

    /* renamed from: XC$a */
    /* compiled from: ViewUtilsApi22 */
    public static class a {
        public static void a(View view, int i, int i2, int i3, int i4) {
            view.setLeftTopRightBottom(i, i2, i3, i4);
        }
    }

    @SuppressLint({"NewApi"})
    public void g(View view, int i, int i2, int i3, int i4) {
        if (f) {
            try {
                a.a(view, i, i2, i3, i4);
            } catch (NoSuchMethodError unused) {
                f = false;
            }
        }
    }
}
