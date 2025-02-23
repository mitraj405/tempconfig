package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.math.MathUtils;
import com.google.android.material.progressindicator.DrawingDelegate;

final class LinearDrawingDelegate extends DrawingDelegate<LinearProgressIndicatorSpec> {
    private float displayedCornerRadius;
    private float displayedTrackThickness;
    private float totalTrackLengthFraction;
    private float trackLength = 300.0f;
    private boolean useStrokeCap;

    public LinearDrawingDelegate(LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(linearProgressIndicatorSpec);
    }

    private void drawLine(Canvas canvas, Paint paint, float f, float f2, int i, int i2, int i3) {
        Paint.Cap cap;
        Paint paint2 = paint;
        float w = C1354qp.w(f, 0.0f, 1.0f);
        float w2 = C1354qp.w(f2, 0.0f, 1.0f);
        float lerp = MathUtils.lerp(1.0f - this.totalTrackLengthFraction, 1.0f, w);
        float lerp2 = MathUtils.lerp(1.0f - this.totalTrackLengthFraction, 1.0f, w2);
        float w3 = 1.0f - C1354qp.w(lerp2, 0.99f, 1.0f);
        float f3 = this.trackLength;
        int w4 = (int) ((lerp * f3) + ((float) ((int) ((C1354qp.w(lerp, 0.0f, 0.01f) * ((float) i2)) / 0.01f))));
        int i4 = (int) ((lerp2 * f3) - ((float) ((int) ((w3 * ((float) i3)) / 0.01f))));
        float f4 = (-f3) / 2.0f;
        if (w4 <= i4) {
            float f5 = this.displayedCornerRadius;
            float f6 = ((float) w4) + f5;
            float f7 = ((float) i4) - f5;
            float f8 = f5 * 2.0f;
            paint2.setColor(i);
            paint2.setAntiAlias(true);
            paint2.setStrokeWidth(this.displayedTrackThickness);
            if (f6 >= f7) {
                drawRoundedBlock(canvas, paint, new PointF(f6 + f4, 0.0f), new PointF(f7 + f4, 0.0f), f8, this.displayedTrackThickness);
                return;
            }
            paint2.setStyle(Paint.Style.STROKE);
            if (this.useStrokeCap) {
                cap = Paint.Cap.ROUND;
            } else {
                cap = Paint.Cap.BUTT;
            }
            paint2.setStrokeCap(cap);
            float f9 = f6 + f4;
            float f10 = f7 + f4;
            canvas.drawLine(f9, 0.0f, f10, 0.0f, paint);
            if (!this.useStrokeCap && this.displayedCornerRadius > 0.0f) {
                paint2.setStyle(Paint.Style.FILL);
                if (f6 > 0.0f) {
                    drawRoundedBlock(canvas, paint, new PointF(f9, 0.0f), f8, this.displayedTrackThickness);
                }
                if (f7 < this.trackLength) {
                    drawRoundedBlock(canvas, paint, new PointF(f10, 0.0f), f8, this.displayedTrackThickness);
                }
            }
        }
    }

    private void drawRoundedBlock(Canvas canvas, Paint paint, PointF pointF, float f, float f2) {
        drawRoundedBlock(canvas, paint, pointF, (PointF) null, f, f2);
    }

    public void adjustCanvas(Canvas canvas, Rect rect, float f, boolean z, boolean z2) {
        boolean z3;
        this.trackLength = (float) rect.width();
        float f2 = (float) ((LinearProgressIndicatorSpec) this.spec).trackThickness;
        canvas.translate((((float) rect.width()) / 2.0f) + ((float) rect.left), Math.max(0.0f, (((float) rect.height()) - f2) / 2.0f) + (((float) rect.height()) / 2.0f) + ((float) rect.top));
        if (((LinearProgressIndicatorSpec) this.spec).drawHorizontallyInverse) {
            canvas.scale(-1.0f, 1.0f);
        }
        float f3 = this.trackLength / 2.0f;
        float f4 = f2 / 2.0f;
        canvas.clipRect(-f3, -f4, f3, f4);
        S s = this.spec;
        if (((LinearProgressIndicatorSpec) s).trackThickness / 2 == ((LinearProgressIndicatorSpec) s).trackCornerRadius) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.useStrokeCap = z3;
        this.displayedTrackThickness = ((float) ((LinearProgressIndicatorSpec) s).trackThickness) * f;
        this.displayedCornerRadius = ((float) Math.min(((LinearProgressIndicatorSpec) s).trackThickness / 2, ((LinearProgressIndicatorSpec) s).trackCornerRadius)) * f;
        if (z || z2) {
            if ((z && ((LinearProgressIndicatorSpec) this.spec).showAnimationBehavior == 2) || (z2 && ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior == 1)) {
                canvas.scale(1.0f, -1.0f);
            }
            if (z || (z2 && ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior != 3)) {
                canvas.translate(0.0f, ((1.0f - f) * ((float) ((LinearProgressIndicatorSpec) this.spec).trackThickness)) / 2.0f);
            }
        }
        if (!z2 || ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior != 3) {
            this.totalTrackLengthFraction = 1.0f;
        } else {
            this.totalTrackLengthFraction = f;
        }
    }

    public void drawStopIndicator(Canvas canvas, Paint paint, int i, int i2) {
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(i, i2);
        if (((LinearProgressIndicatorSpec) this.spec).trackStopIndicatorSize > 0 && compositeARGBWithAlpha != 0) {
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(compositeARGBWithAlpha);
            PointF pointF = new PointF((this.trackLength / 2.0f) - (this.displayedTrackThickness / 2.0f), 0.0f);
            S s = this.spec;
            drawRoundedBlock(canvas, paint, pointF, (float) ((LinearProgressIndicatorSpec) s).trackStopIndicatorSize, (float) ((LinearProgressIndicatorSpec) s).trackStopIndicatorSize);
        }
    }

    public void fillIndicator(Canvas canvas, Paint paint, DrawingDelegate.ActiveIndicator activeIndicator, int i) {
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(activeIndicator.color, i);
        float f = activeIndicator.startFraction;
        float f2 = activeIndicator.endFraction;
        int i2 = activeIndicator.gapSize;
        drawLine(canvas, paint, f, f2, compositeARGBWithAlpha, i2, i2);
    }

    public void fillTrack(Canvas canvas, Paint paint, float f, float f2, int i, int i2, int i3) {
        drawLine(canvas, paint, f, f2, MaterialColors.compositeARGBWithAlpha(i, i2), i3, i3);
    }

    public int getPreferredHeight() {
        return ((LinearProgressIndicatorSpec) this.spec).trackThickness;
    }

    public int getPreferredWidth() {
        return -1;
    }

    private void drawRoundedBlock(Canvas canvas, Paint paint, PointF pointF, PointF pointF2, float f, float f2) {
        float min = Math.min(f2, this.displayedTrackThickness);
        float f3 = f / 2.0f;
        float min2 = Math.min(f3, (this.displayedCornerRadius * min) / this.displayedTrackThickness);
        RectF rectF = new RectF((-f) / 2.0f, (-min) / 2.0f, f3, min / 2.0f);
        paint.setStyle(Paint.Style.FILL);
        canvas.save();
        if (pointF2 != null) {
            canvas.translate(pointF2.x, pointF2.y);
            Path path = new Path();
            path.addRoundRect(rectF, min2, min2, Path.Direction.CCW);
            canvas.clipPath(path);
            canvas.translate(-pointF2.x, -pointF2.y);
        }
        canvas.translate(pointF.x, pointF.y);
        canvas.drawRoundRect(rectF, min2, min2, paint);
        canvas.restore();
    }
}
