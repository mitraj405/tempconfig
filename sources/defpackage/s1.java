package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.f;
import defpackage.v9;

/* renamed from: s1  reason: default package */
/* compiled from: AppCompatSeekBarHelper */
public final class s1 extends p1 {
    public ColorStateList a = null;

    /* renamed from: a  reason: collision with other field name */
    public PorterDuff.Mode f3242a = null;

    /* renamed from: a  reason: collision with other field name */
    public Drawable f3243a;

    /* renamed from: a  reason: collision with other field name */
    public final SeekBar f3244a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f3245a = false;
    public boolean b = false;

    public s1(SeekBar seekBar) {
        super(seekBar);
        this.f3244a = seekBar;
    }

    public final void a(AttributeSet attributeSet, int i) {
        super.a(attributeSet, i);
        SeekBar seekBar = this.f3244a;
        Context context = seekBar.getContext();
        int[] iArr = ps.AppCompatSeekBar;
        TintTypedArray m = TintTypedArray.m(context, attributeSet, iArr, i);
        f.n(seekBar, seekBar.getContext(), iArr, attributeSet, m.f1265a, i);
        Drawable f = m.f(ps.AppCompatSeekBar_android_thumb);
        if (f != null) {
            seekBar.setThumb(f);
        }
        Drawable e = m.e(ps.AppCompatSeekBar_tickMark);
        Drawable drawable = this.f3243a;
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback) null);
        }
        this.f3243a = e;
        if (e != null) {
            e.setCallback(seekBar);
            v9.b.b(e, seekBar.getLayoutDirection());
            if (e.isStateful()) {
                e.setState(seekBar.getDrawableState());
            }
            c();
        }
        seekBar.invalidate();
        int i2 = ps.AppCompatSeekBar_tickMarkTintMode;
        if (m.l(i2)) {
            this.f3242a = w9.c(m.h(i2, -1), this.f3242a);
            this.b = true;
        }
        int i3 = ps.AppCompatSeekBar_tickMarkTint;
        if (m.l(i3)) {
            this.a = m.b(i3);
            this.f3245a = true;
        }
        m.n();
        c();
    }

    public final void c() {
        Drawable drawable = this.f3243a;
        if (drawable == null) {
            return;
        }
        if (this.f3245a || this.b) {
            Drawable mutate = drawable.mutate();
            this.f3243a = mutate;
            if (this.f3245a) {
                v9.a.h(mutate, this.a);
            }
            if (this.b) {
                v9.a.i(this.f3243a, this.f3242a);
            }
            if (this.f3243a.isStateful()) {
                this.f3243a.setState(this.f3244a.getDrawableState());
            }
        }
    }

    public final void d(Canvas canvas) {
        int i;
        if (this.f3243a != null) {
            SeekBar seekBar = this.f3244a;
            int max = seekBar.getMax();
            int i2 = 1;
            if (max > 1) {
                int intrinsicWidth = this.f3243a.getIntrinsicWidth();
                int intrinsicHeight = this.f3243a.getIntrinsicHeight();
                if (intrinsicWidth >= 0) {
                    i = intrinsicWidth / 2;
                } else {
                    i = 1;
                }
                if (intrinsicHeight >= 0) {
                    i2 = intrinsicHeight / 2;
                }
                this.f3243a.setBounds(-i, -i2, i, i2);
                float width = ((float) ((seekBar.getWidth() - seekBar.getPaddingLeft()) - seekBar.getPaddingRight())) / ((float) max);
                int save = canvas.save();
                canvas.translate((float) seekBar.getPaddingLeft(), (float) (seekBar.getHeight() / 2));
                for (int i3 = 0; i3 <= max; i3++) {
                    this.f3243a.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }
}
