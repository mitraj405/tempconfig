package defpackage;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;

/* renamed from: YC  reason: default package */
/* compiled from: ViewUtilsApi23 */
public class YC extends XC {
    public static boolean g = true;

    /* renamed from: YC$a */
    /* compiled from: ViewUtilsApi23 */
    public static class a {
        public static void a(View view, int i) {
            view.setTransitionVisibility(i);
        }
    }

    @SuppressLint({"NewApi"})
    public void c(View view, int i) {
        if (Build.VERSION.SDK_INT == 28) {
            super.c(view, i);
        } else if (g) {
            try {
                a.a(view, i);
            } catch (NoSuchMethodError unused) {
                g = false;
            }
        }
    }
}
