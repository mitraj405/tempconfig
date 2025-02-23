package defpackage;

import android.graphics.Matrix;
import android.view.View;

/* renamed from: ZC  reason: default package */
/* compiled from: ViewUtilsApi29 */
public final class ZC extends YC {
    public final float a(View view) {
        return view.getTransitionAlpha();
    }

    public final void b(View view, float f) {
        view.setTransitionAlpha(f);
    }

    public final void c(View view, int i) {
        view.setTransitionVisibility(i);
    }

    public final void d(View view, Matrix matrix) {
        view.setAnimationMatrix(matrix);
    }

    public final void e(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    public final void f(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }

    public final void g(View view, int i, int i2, int i3, int i4) {
        view.setLeftTopRightBottom(i, i2, i3, i4);
    }
}
