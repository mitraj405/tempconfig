package defpackage;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;

/* renamed from: WC  reason: default package */
/* compiled from: ViewUtilsApi21 */
public class WC extends VC {
    public static boolean c = true;
    public static boolean d = true;
    public static boolean e = true;

    /* renamed from: WC$a */
    /* compiled from: ViewUtilsApi21 */
    public static class a {
        public static void a(View view, Matrix matrix) {
            view.setAnimationMatrix(matrix);
        }

        public static void b(View view, Matrix matrix) {
            view.transformMatrixToGlobal(matrix);
        }

        public static void c(View view, Matrix matrix) {
            view.transformMatrixToLocal(matrix);
        }
    }

    @SuppressLint({"NewApi"})
    public void d(View view, Matrix matrix) {
        if (c) {
            try {
                a.a(view, matrix);
            } catch (NoSuchMethodError unused) {
                c = false;
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void e(View view, Matrix matrix) {
        if (d) {
            try {
                a.b(view, matrix);
            } catch (NoSuchMethodError unused) {
                d = false;
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void f(View view, Matrix matrix) {
        if (e) {
            try {
                a.c(view, matrix);
            } catch (NoSuchMethodError unused) {
                e = false;
            }
        }
    }
}
