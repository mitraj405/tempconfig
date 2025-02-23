package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import defpackage.v9;

public final class DrawerArrowDrawable extends Drawable {
    public static final float g = ((float) Math.toRadians(45.0d));
    public final float a;

    /* renamed from: a  reason: collision with other field name */
    public final int f981a;

    /* renamed from: a  reason: collision with other field name */
    public final Paint f982a;

    /* renamed from: a  reason: collision with other field name */
    public final Path f983a = new Path();

    /* renamed from: a  reason: collision with other field name */
    public boolean f984a;
    public final float b;

    /* renamed from: b  reason: collision with other field name */
    public final int f985b = 2;
    public final float c;
    public float d;
    public float e;
    public float f;

    public DrawerArrowDrawable(Context context) {
        Paint paint = new Paint();
        this.f982a = paint;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes((AttributeSet) null, ps.DrawerArrowToggle, C0220hr.drawerArrowStyle, C0185es.Base_Widget_AppCompat_DrawerArrowToggle);
        int color = obtainStyledAttributes.getColor(ps.DrawerArrowToggle_color, 0);
        if (color != paint.getColor()) {
            paint.setColor(color);
            invalidateSelf();
        }
        float dimension = obtainStyledAttributes.getDimension(ps.DrawerArrowToggle_thickness, 0.0f);
        if (paint.getStrokeWidth() != dimension) {
            paint.setStrokeWidth(dimension);
            this.f = (float) (Math.cos((double) g) * ((double) (dimension / 2.0f)));
            invalidateSelf();
        }
        boolean z = obtainStyledAttributes.getBoolean(ps.DrawerArrowToggle_spinBars, true);
        if (this.f984a != z) {
            this.f984a = z;
            invalidateSelf();
        }
        float round = (float) Math.round(obtainStyledAttributes.getDimension(ps.DrawerArrowToggle_gapBetweenBars, 0.0f));
        if (round != this.d) {
            this.d = round;
            invalidateSelf();
        }
        this.f981a = obtainStyledAttributes.getDimensionPixelSize(ps.DrawerArrowToggle_drawableSize, 0);
        this.b = (float) Math.round(obtainStyledAttributes.getDimension(ps.DrawerArrowToggle_barLength, 0.0f));
        this.a = (float) Math.round(obtainStyledAttributes.getDimension(ps.DrawerArrowToggle_arrowHeadLength, 0.0f));
        this.c = obtainStyledAttributes.getDimension(ps.DrawerArrowToggle_arrowShaftLength, 0.0f);
        obtainStyledAttributes.recycle();
    }

    public final void draw(Canvas canvas) {
        float f2;
        int i;
        Rect bounds = getBounds();
        boolean z = true;
        int i2 = this.f985b;
        if (i2 == 0 || (i2 != 1 && (i2 == 3 ? v9.b.a(this) != 0 : v9.b.a(this) != 1))) {
            z = false;
        }
        float f3 = this.a;
        float sqrt = (float) Math.sqrt((double) (f3 * f3 * 2.0f));
        float f4 = this.e;
        float f5 = this.b;
        float a2 = lf.a(sqrt, f5, f4, f5);
        float a3 = lf.a(this.c, f5, f4, f5);
        float f6 = 0.0f;
        float round = (float) Math.round(((this.f - 0.0f) * f4) + 0.0f);
        float f7 = this.e;
        float a4 = lf.a(g, 0.0f, f7, 0.0f);
        if (z) {
            f2 = 0.0f;
        } else {
            f2 = -180.0f;
        }
        if (z) {
            f6 = 180.0f;
        }
        float a5 = lf.a(f6, f2, f7, f2);
        double d2 = (double) a2;
        double d3 = (double) a4;
        float round2 = (float) Math.round(Math.cos(d3) * d2);
        float round3 = (float) Math.round(Math.sin(d3) * d2);
        Path path = this.f983a;
        path.rewind();
        float f8 = this.d;
        Paint paint = this.f982a;
        float strokeWidth = paint.getStrokeWidth() + f8;
        float a6 = lf.a(-this.f, strokeWidth, this.e, strokeWidth);
        float f9 = (-a3) / 2.0f;
        path.moveTo(f9 + round, 0.0f);
        path.rLineTo(a3 - (round * 2.0f), 0.0f);
        path.moveTo(f9, a6);
        path.rLineTo(round2, round3);
        path.moveTo(f9, -a6);
        path.rLineTo(round2, -round3);
        path.close();
        canvas.save();
        float strokeWidth2 = paint.getStrokeWidth();
        float height = ((float) bounds.height()) - (3.0f * strokeWidth2);
        float f10 = this.d;
        canvas.translate((float) bounds.centerX(), (strokeWidth2 * 1.5f) + f10 + ((float) ((((int) (height - (2.0f * f10))) / 4) * 2)));
        if (this.f984a) {
            if (z) {
                i = -1;
            } else {
                i = 1;
            }
            canvas.rotate(a5 * ((float) i));
        } else if (z) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(path, paint);
        canvas.restore();
    }

    public final int getIntrinsicHeight() {
        return this.f981a;
    }

    public final int getIntrinsicWidth() {
        return this.f981a;
    }

    public final int getOpacity() {
        return -3;
    }

    public final void setAlpha(int i) {
        Paint paint = this.f982a;
        if (i != paint.getAlpha()) {
            paint.setAlpha(i);
            invalidateSelf();
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.f982a.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
