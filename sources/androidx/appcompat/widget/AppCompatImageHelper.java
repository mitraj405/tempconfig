package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.view.f;

public final class AppCompatImageHelper {
    public int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public Zz f1165a;

    /* renamed from: a  reason: collision with other field name */
    public final ImageView f1166a;

    public AppCompatImageHelper(ImageView imageView) {
        this.f1166a = imageView;
    }

    public final void a() {
        Zz zz;
        ImageView imageView = this.f1166a;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            w9.a(drawable);
        }
        if (drawable != null && (zz = this.f1165a) != null) {
            o1.e(drawable, zz, imageView.getDrawableState());
        }
    }

    public final void b(AttributeSet attributeSet, int i) {
        int i2;
        ImageView imageView = this.f1166a;
        Context context = imageView.getContext();
        int[] iArr = ps.AppCompatImageView;
        TintTypedArray m = TintTypedArray.m(context, attributeSet, iArr, i);
        f.n(imageView, imageView.getContext(), iArr, attributeSet, m.f1265a, i);
        try {
            Drawable drawable = imageView.getDrawable();
            if (!(drawable != null || (i2 = m.i(ps.AppCompatImageView_srcCompat, -1)) == -1 || (drawable = r1.w(imageView.getContext(), i2)) == null)) {
                imageView.setImageDrawable(drawable);
            }
            if (drawable != null) {
                w9.a(drawable);
            }
            int i3 = ps.AppCompatImageView_tint;
            if (m.l(i3)) {
                C0367vf.c(imageView, m.b(i3));
            }
            int i4 = ps.AppCompatImageView_tintMode;
            if (m.l(i4)) {
                C0367vf.d(imageView, w9.c(m.h(i4, -1), (PorterDuff.Mode) null));
            }
        } finally {
            m.n();
        }
    }

    public final void c(int i) {
        ImageView imageView = this.f1166a;
        if (i != 0) {
            Drawable w = r1.w(imageView.getContext(), i);
            if (w != null) {
                w9.a(w);
            }
            imageView.setImageDrawable(w);
        } else {
            imageView.setImageDrawable((Drawable) null);
        }
        a();
    }
}
