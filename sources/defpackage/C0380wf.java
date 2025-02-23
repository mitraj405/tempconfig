package defpackage;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;

/* renamed from: wf  reason: default package and case insensitive filesystem */
/* compiled from: ImageViewUtils */
public final class C0380wf {
    public static boolean a = true;

    /* renamed from: wf$a */
    /* compiled from: ImageViewUtils */
    public static class a {
        public static void a(ImageView imageView, Matrix matrix) {
            imageView.animateTransform(matrix);
        }
    }

    public static void a(ImageView imageView, Matrix matrix) {
        if (Build.VERSION.SDK_INT >= 29) {
            a.a(imageView, matrix);
        } else if (matrix == null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable != null) {
                drawable.setBounds(0, 0, (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight(), (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom());
                imageView.invalidate();
            }
        } else if (a) {
            try {
                a.a(imageView, matrix);
            } catch (NoSuchMethodError unused) {
                a = false;
            }
        }
    }
}
