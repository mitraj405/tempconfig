package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.math.MathUtils;
import com.google.android.material.progressindicator.DrawingDelegate;

final class CircularDrawingDelegate extends DrawingDelegate<CircularProgressIndicatorSpec> {
    private static final float ROUND_CAP_RAMP_DOWN_THRESHHOLD = 0.01f;
    private float adjustedRadius;
    private float displayedCornerRadius;
    private float displayedTrackThickness;
    private float totalTrackLengthFraction;
    private boolean useStrokeCap;

    public CircularDrawingDelegate(CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(circularProgressIndicatorSpec);
    }

    private void drawArc(Canvas canvas, Paint paint, float f, float f2, int i, int i2, int i3) {
        float f3;
        Paint.Cap cap;
        Paint paint2 = paint;
        if (f2 >= f) {
            f3 = f2 - f;
        } else {
            f3 = (f2 + 1.0f) - f;
        }
        float f4 = f % 1.0f;
        if (this.totalTrackLengthFraction < 1.0f) {
            float f5 = f4 + f3;
            if (f5 > 1.0f) {
                Canvas canvas2 = canvas;
                Paint paint3 = paint;
                int i4 = i;
                drawArc(canvas2, paint3, f4, 1.0f, i4, i2, 0);
                drawArc(canvas2, paint3, 1.0f, f5, i4, 0, i3);
                return;
            }
        }
        float degrees = (float) Math.toDegrees((double) (this.displayedCornerRadius / this.adjustedRadius));
        if (f4 == 0.0f && f3 >= 0.99f) {
            f3 += (((degrees * 2.0f) / 360.0f) * (f3 - 0.99f)) / ROUND_CAP_RAMP_DOWN_THRESHHOLD;
        }
        float lerp = MathUtils.lerp(1.0f - this.totalTrackLengthFraction, 1.0f, f4);
        float lerp2 = MathUtils.lerp(0.0f, this.totalTrackLengthFraction, f3);
        float degrees2 = (float) Math.toDegrees((double) (((float) i2) / this.adjustedRadius));
        float degrees3 = ((lerp2 * 360.0f) - degrees2) - ((float) Math.toDegrees((double) (((float) i3) / this.adjustedRadius)));
        float f6 = (lerp * 360.0f) + degrees2;
        if (degrees3 > 0.0f) {
            paint2.setAntiAlias(true);
            paint2.setColor(i);
            paint2.setStrokeWidth(this.displayedTrackThickness);
            float f7 = degrees * 2.0f;
            if (degrees3 < f7) {
                float f8 = degrees3 / f7;
                paint2.setStyle(Paint.Style.FILL);
                drawRoundedBlock(canvas, paint, (degrees * f8) + f6, this.displayedCornerRadius * 2.0f, this.displayedTrackThickness, f8);
                return;
            }
            float f9 = this.adjustedRadius;
            RectF rectF = new RectF(-f9, -f9, f9, f9);
            paint2.setStyle(Paint.Style.STROKE);
            if (this.useStrokeCap) {
                cap = Paint.Cap.ROUND;
            } else {
                cap = Paint.Cap.BUTT;
            }
            paint2.setStrokeCap(cap);
            float f10 = f6 + degrees;
            canvas.drawArc(rectF, f10, degrees3 - f7, false, paint);
            if (!this.useStrokeCap && this.displayedCornerRadius > 0.0f) {
                paint2.setStyle(Paint.Style.FILL);
                Canvas canvas3 = canvas;
                Paint paint4 = paint;
                drawRoundedBlock(canvas3, paint4, f10, this.displayedCornerRadius * 2.0f, this.displayedTrackThickness);
                drawRoundedBlock(canvas3, paint4, (f6 + degrees3) - degrees, this.displayedCornerRadius * 2.0f, this.displayedTrackThickness);
            }
        }
    }

    private void drawRoundedBlock(Canvas canvas, Paint paint, float f, float f2, float f3) {
        drawRoundedBlock(canvas, paint, f, f2, f3, 1.0f);
    }

    private int getSize() {
        S s = this.spec;
        return (((CircularProgressIndicatorSpec) s).indicatorInset * 2) + ((CircularProgressIndicatorSpec) s).indicatorSize;
    }

    public void adjustCanvas(Canvas canvas, Rect rect, float f, boolean z, boolean z2) {
        boolean z3;
        float width = ((float) rect.width()) / ((float) getPreferredWidth());
        float height = ((float) rect.height()) / ((float) getPreferredHeight());
        S s = this.spec;
        float f2 = (((float) ((CircularProgressIndicatorSpec) s).indicatorSize) / 2.0f) + ((float) ((CircularProgressIndicatorSpec) s).indicatorInset);
        canvas.translate((f2 * width) + ((float) rect.left), (f2 * height) + ((float) rect.top));
        canvas.rotate(-90.0f);
        canvas.scale(width, height);
        if (((CircularProgressIndicatorSpec) this.spec).indicatorDirection != 0) {
            canvas.scale(1.0f, -1.0f);
        }
        float f3 = -f2;
        canvas.clipRect(f3, f3, f2, f2);
        S s2 = this.spec;
        if (((CircularProgressIndicatorSpec) s2).trackThickness / 2 <= ((CircularProgressIndicatorSpec) s2).trackCornerRadius) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.useStrokeCap = z3;
        this.displayedTrackThickness = ((float) ((CircularProgressIndicatorSpec) s2).trackThickness) * f;
        this.displayedCornerRadius = ((float) Math.min(((CircularProgressIndicatorSpec) s2).trackThickness / 2, ((CircularProgressIndicatorSpec) s2).trackCornerRadius)) * f;
        S s3 = this.spec;
        float f4 = ((float) (((CircularProgressIndicatorSpec) s3).indicatorSize - ((CircularProgressIndicatorSpec) s3).trackThickness)) / 2.0f;
        this.adjustedRadius = f4;
        if (z || z2) {
            if ((z && ((CircularProgressIndicatorSpec) s3).showAnimationBehavior == 2) || (z2 && ((CircularProgressIndicatorSpec) s3).hideAnimationBehavior == 1)) {
                this.adjustedRadius = (((1.0f - f) * ((float) ((CircularProgressIndicatorSpec) s3).trackThickness)) / 2.0f) + f4;
            } else if ((z && ((CircularProgressIndicatorSpec) s3).showAnimationBehavior == 1) || (z2 && ((CircularProgressIndicatorSpec) s3).hideAnimationBehavior == 2)) {
                this.adjustedRadius = f4 - (((1.0f - f) * ((float) ((CircularProgressIndicatorSpec) s3).trackThickness)) / 2.0f);
            }
        }
        if (!z2 || ((CircularProgressIndicatorSpec) s3).hideAnimationBehavior != 3) {
            this.totalTrackLengthFraction = 1.0f;
        } else {
            this.totalTrackLengthFraction = f;
        }
    }

    public void fillIndicator(Canvas canvas, Paint paint, DrawingDelegate.ActiveIndicator activeIndicator, int i) {
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(activeIndicator.color, i);
        float f = activeIndicator.startFraction;
        float f2 = activeIndicator.endFraction;
        int i2 = activeIndicator.gapSize;
        drawArc(canvas, paint, f, f2, compositeARGBWithAlpha, i2, i2);
    }

    public void fillTrack(Canvas canvas, Paint paint, float f, float f2, int i, int i2, int i3) {
        drawArc(canvas, paint, f, f2, MaterialColors.compositeARGBWithAlpha(i, i2), i3, i3);
    }

    public int getPreferredHeight() {
        return getSize();
    }

    public int getPreferredWidth() {
        return getSize();
    }

    private void drawRoundedBlock(Canvas canvas, Paint paint, float f, float f2, float f3, float f4) {
        float min = (float) ((int) Math.min(f3, this.displayedTrackThickness));
        float f5 = f2 / 2.0f;
        float min2 = Math.min(f5, (this.displayedCornerRadius * min) / this.displayedTrackThickness);
        RectF rectF = new RectF((-min) / 2.0f, (-f2) / 2.0f, min / 2.0f, f5);
        canvas.save();
        double d = (double) f;
        canvas.translate((float) (Math.cos(Math.toRadians(d)) * ((double) this.adjustedRadius)), (float) (Math.sin(Math.toRadians(d)) * ((double) this.adjustedRadius)));
        canvas.rotate(f);
        canvas.scale(f4, f4);
        canvas.drawRoundRect(rectF, min2, min2, paint);
        canvas.restore();
    }

    public void drawStopIndicator(Canvas canvas, Paint paint, int i, int i2) {
    }
}
