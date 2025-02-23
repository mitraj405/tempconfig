package defpackage;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* renamed from: fu  reason: default package */
/* compiled from: RoundRectDrawable */
public final class fu extends Drawable {
    public float a;

    /* renamed from: a  reason: collision with other field name */
    public ColorStateList f2949a;

    /* renamed from: a  reason: collision with other field name */
    public final Paint f2950a;

    /* renamed from: a  reason: collision with other field name */
    public PorterDuff.Mode f2951a = PorterDuff.Mode.SRC_IN;

    /* renamed from: a  reason: collision with other field name */
    public PorterDuffColorFilter f2952a;

    /* renamed from: a  reason: collision with other field name */
    public final Rect f2953a;

    /* renamed from: a  reason: collision with other field name */
    public final RectF f2954a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f2955a = false;
    public float b;

    /* renamed from: b  reason: collision with other field name */
    public ColorStateList f2956b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f2957b = true;

    public fu(float f, ColorStateList colorStateList) {
        this.a = f;
        this.f2950a = new Paint(5);
        b(colorStateList);
        this.f2954a = new RectF();
        this.f2953a = new Rect();
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public final void b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f2949a = colorStateList;
        this.f2950a.setColor(colorStateList.getColorForState(getState(), this.f2949a.getDefaultColor()));
    }

    public final void c(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        RectF rectF = this.f2954a;
        rectF.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        Rect rect2 = this.f2953a;
        rect2.set(rect);
        if (this.f2955a) {
            float a2 = gu.a(this.b, this.a, this.f2957b);
            float f = this.b;
            float f2 = this.a;
            if (this.f2957b) {
                f = (float) (((1.0d - gu.a) * ((double) f2)) + ((double) f));
            }
            rect2.inset((int) Math.ceil((double) f), (int) Math.ceil((double) a2));
            rectF.set(rect2);
        }
    }

    public final void draw(Canvas canvas) {
        boolean z;
        Paint paint = this.f2950a;
        if (this.f2952a == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.f2952a);
            z = true;
        }
        RectF rectF = this.f2954a;
        float f = this.a;
        canvas.drawRoundRect(rectF, f, f, paint);
        if (z) {
            paint.setColorFilter((ColorFilter) null);
        }
    }

    public final int getOpacity() {
        return -3;
    }

    public final void getOutline(Outline outline) {
        outline.setRoundRect(this.f2953a, this.a);
    }

    public final boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f2956b;
        if ((colorStateList2 == null || !colorStateList2.isStateful()) && (((colorStateList = this.f2949a) == null || !colorStateList.isStateful()) && !super.isStateful())) {
            return false;
        }
        return true;
    }

    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        c(rect);
    }

    public final boolean onStateChange(int[] iArr) {
        boolean z;
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f2949a;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        Paint paint = this.f2950a;
        if (colorForState != paint.getColor()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            paint.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f2956b;
        if (colorStateList2 == null || (mode = this.f2951a) == null) {
            return z;
        }
        this.f2952a = a(colorStateList2, mode);
        return true;
    }

    public final void setAlpha(int i) {
        this.f2950a.setAlpha(i);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.f2950a.setColorFilter(colorFilter);
    }

    public final void setTintList(ColorStateList colorStateList) {
        this.f2956b = colorStateList;
        this.f2952a = a(colorStateList, this.f2951a);
        invalidateSelf();
    }

    public final void setTintMode(PorterDuff.Mode mode) {
        this.f2951a = mode;
        this.f2952a = a(this.f2956b, mode);
        invalidateSelf();
    }
}
