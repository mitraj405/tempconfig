package com.google.android.material.shadow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.google.android.material.R;
import defpackage.d7;

@Deprecated
public class ShadowDrawableWrapper extends x9 {
    static final double COS_45 = Math.cos(Math.toRadians(45.0d));
    static final float SHADOW_BOTTOM_SCALE = 1.0f;
    static final float SHADOW_HORIZ_SCALE = 0.5f;
    static final float SHADOW_MULTIPLIER = 1.5f;
    static final float SHADOW_TOP_SCALE = 0.25f;
    private boolean addPaddingForCorners = true;
    final RectF contentBounds;
    float cornerRadius;
    final Paint cornerShadowPaint;
    Path cornerShadowPath;
    private boolean dirty = true;
    final Paint edgeShadowPaint;
    float maxShadowSize;
    private boolean printedShadowClipWarning = false;
    float rawMaxShadowSize;
    float rawShadowSize;
    private float rotation;
    private final int shadowEndColor;
    private final int shadowMiddleColor;
    float shadowSize;
    private final int shadowStartColor;

    public ShadowDrawableWrapper(Context context, Drawable drawable, float f, float f2, float f3) {
        super(drawable);
        int i = R.color.design_fab_shadow_start_color;
        Object obj = d7.a;
        this.shadowStartColor = d7.b.a(context, i);
        this.shadowMiddleColor = d7.b.a(context, R.color.design_fab_shadow_mid_color);
        this.shadowEndColor = d7.b.a(context, R.color.design_fab_shadow_end_color);
        Paint paint = new Paint(5);
        this.cornerShadowPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.cornerRadius = (float) Math.round(f);
        this.contentBounds = new RectF();
        Paint paint2 = new Paint(paint);
        this.edgeShadowPaint = paint2;
        paint2.setAntiAlias(false);
        setShadowSize(f2, f3);
    }

    private void buildComponents(Rect rect) {
        float f = this.rawMaxShadowSize;
        float f2 = SHADOW_MULTIPLIER * f;
        this.contentBounds.set(((float) rect.left) + f, ((float) rect.top) + f2, ((float) rect.right) - f, ((float) rect.bottom) - f2);
        Drawable drawable = getDrawable();
        RectF rectF = this.contentBounds;
        drawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        buildShadowCorners();
    }

    private void buildShadowCorners() {
        float f = this.cornerRadius;
        RectF rectF = new RectF(-f, -f, f, f);
        RectF rectF2 = new RectF(rectF);
        float f2 = this.shadowSize;
        rectF2.inset(-f2, -f2);
        Path path = this.cornerShadowPath;
        if (path == null) {
            this.cornerShadowPath = new Path();
        } else {
            path.reset();
        }
        this.cornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
        this.cornerShadowPath.moveTo(-this.cornerRadius, 0.0f);
        this.cornerShadowPath.rLineTo(-this.shadowSize, 0.0f);
        this.cornerShadowPath.arcTo(rectF2, 180.0f, 90.0f, false);
        this.cornerShadowPath.arcTo(rectF, 270.0f, -90.0f, false);
        this.cornerShadowPath.close();
        float f3 = -rectF2.top;
        if (f3 > 0.0f) {
            float f4 = this.cornerRadius / f3;
            Paint paint = this.cornerShadowPaint;
            RadialGradient radialGradient = r8;
            float[] fArr = {0.0f, f4, ((1.0f - f4) / 2.0f) + f4, 1.0f};
            RadialGradient radialGradient2 = new RadialGradient(0.0f, 0.0f, f3, new int[]{0, this.shadowStartColor, this.shadowMiddleColor, this.shadowEndColor}, fArr, Shader.TileMode.CLAMP);
            paint.setShader(radialGradient);
        }
        Paint paint2 = this.edgeShadowPaint;
        float f5 = rectF.top;
        float f6 = rectF2.top;
        int[] iArr = {this.shadowStartColor, this.shadowMiddleColor, this.shadowEndColor};
        paint2.setShader(new LinearGradient(0.0f, f5, 0.0f, f6, iArr, new float[]{0.0f, SHADOW_HORIZ_SCALE, 1.0f}, Shader.TileMode.CLAMP));
        this.edgeShadowPaint.setAntiAlias(false);
    }

    public static float calculateHorizontalPadding(float f, float f2, boolean z) {
        if (!z) {
            return f;
        }
        return (float) (((1.0d - COS_45) * ((double) f2)) + ((double) f));
    }

    public static float calculateVerticalPadding(float f, float f2, boolean z) {
        if (!z) {
            return f * SHADOW_MULTIPLIER;
        }
        return (float) (((1.0d - COS_45) * ((double) f2)) + ((double) (f * SHADOW_MULTIPLIER)));
    }

    private void drawShadow(Canvas canvas) {
        boolean z;
        boolean z2;
        float f;
        int i;
        int i2;
        float f2;
        float f3;
        float f4;
        Canvas canvas2 = canvas;
        int save = canvas.save();
        canvas2.rotate(this.rotation, this.contentBounds.centerX(), this.contentBounds.centerY());
        float f5 = this.cornerRadius;
        float f6 = (-f5) - this.shadowSize;
        float f7 = f5 * 2.0f;
        if (this.contentBounds.width() - f7 > 0.0f) {
            z = true;
        } else {
            z = false;
        }
        if (this.contentBounds.height() - f7 > 0.0f) {
            z2 = true;
        } else {
            z2 = false;
        }
        float f8 = this.rawShadowSize;
        float f9 = f8 - (SHADOW_TOP_SCALE * f8);
        float f10 = f5 / ((f8 - (SHADOW_HORIZ_SCALE * f8)) + f5);
        float f11 = f5 / (f9 + f5);
        float f12 = f5 / ((f8 - (f8 * 1.0f)) + f5);
        int save2 = canvas.save();
        RectF rectF = this.contentBounds;
        canvas2.translate(rectF.left + f5, rectF.top + f5);
        canvas2.scale(f10, f11);
        canvas2.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z) {
            canvas2.scale(1.0f / f10, 1.0f);
            i2 = save2;
            f = f12;
            i = save;
            f2 = f11;
            canvas.drawRect(0.0f, f6, this.contentBounds.width() - f7, -this.cornerRadius, this.edgeShadowPaint);
        } else {
            i2 = save2;
            f = f12;
            i = save;
            f2 = f11;
        }
        canvas2.restoreToCount(i2);
        int save3 = canvas.save();
        RectF rectF2 = this.contentBounds;
        canvas2.translate(rectF2.right - f5, rectF2.bottom - f5);
        float f13 = f;
        canvas2.scale(f10, f13);
        canvas2.rotate(180.0f);
        canvas2.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z) {
            canvas2.scale(1.0f / f10, 1.0f);
            f3 = f2;
            f4 = f13;
            canvas.drawRect(0.0f, f6, this.contentBounds.width() - f7, (-this.cornerRadius) + this.shadowSize, this.edgeShadowPaint);
        } else {
            f3 = f2;
            f4 = f13;
        }
        canvas2.restoreToCount(save3);
        int save4 = canvas.save();
        RectF rectF3 = this.contentBounds;
        canvas2.translate(rectF3.left + f5, rectF3.bottom - f5);
        canvas2.scale(f10, f4);
        canvas2.rotate(270.0f);
        canvas2.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z2) {
            canvas2.scale(1.0f / f4, 1.0f);
            canvas.drawRect(0.0f, f6, this.contentBounds.height() - f7, -this.cornerRadius, this.edgeShadowPaint);
        }
        canvas2.restoreToCount(save4);
        int save5 = canvas.save();
        RectF rectF4 = this.contentBounds;
        canvas2.translate(rectF4.right - f5, rectF4.top + f5);
        float f14 = f3;
        canvas2.scale(f10, f14);
        canvas2.rotate(90.0f);
        canvas2.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z2) {
            canvas2.scale(1.0f / f14, 1.0f);
            canvas.drawRect(0.0f, f6, this.contentBounds.height() - f7, -this.cornerRadius, this.edgeShadowPaint);
        }
        canvas2.restoreToCount(save5);
        canvas2.restoreToCount(i);
    }

    private static int toEven(float f) {
        int round = Math.round(f);
        if (round % 2 == 1) {
            return round - 1;
        }
        return round;
    }

    public void draw(Canvas canvas) {
        if (this.dirty) {
            buildComponents(getBounds());
            this.dirty = false;
        }
        drawShadow(canvas);
        super.draw(canvas);
    }

    public float getCornerRadius() {
        return this.cornerRadius;
    }

    public float getMaxShadowSize() {
        return this.rawMaxShadowSize;
    }

    public float getMinHeight() {
        float f = this.rawMaxShadowSize;
        float f2 = this.cornerRadius;
        return (this.rawMaxShadowSize * SHADOW_MULTIPLIER * 2.0f) + (Math.max(f, ((f * SHADOW_MULTIPLIER) / 2.0f) + f2) * 2.0f);
    }

    public float getMinWidth() {
        float f = this.rawMaxShadowSize;
        float f2 = f / 2.0f;
        return (this.rawMaxShadowSize * 2.0f) + (Math.max(f, f2 + this.cornerRadius) * 2.0f);
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) calculateVerticalPadding(this.rawMaxShadowSize, this.cornerRadius, this.addPaddingForCorners));
        int ceil2 = (int) Math.ceil((double) calculateHorizontalPadding(this.rawMaxShadowSize, this.cornerRadius, this.addPaddingForCorners));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public float getShadowSize() {
        return this.rawShadowSize;
    }

    public void onBoundsChange(Rect rect) {
        this.dirty = true;
    }

    public void setAddPaddingForCorners(boolean z) {
        this.addPaddingForCorners = z;
        invalidateSelf();
    }

    public void setAlpha(int i) {
        super.setAlpha(i);
        this.cornerShadowPaint.setAlpha(i);
        this.edgeShadowPaint.setAlpha(i);
    }

    public void setCornerRadius(float f) {
        float round = (float) Math.round(f);
        if (this.cornerRadius != round) {
            this.cornerRadius = round;
            this.dirty = true;
            invalidateSelf();
        }
    }

    public void setMaxShadowSize(float f) {
        setShadowSize(this.rawShadowSize, f);
    }

    public final void setRotation(float f) {
        if (this.rotation != f) {
            this.rotation = f;
            invalidateSelf();
        }
    }

    public void setShadowSize(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float even = (float) toEven(f);
        float even2 = (float) toEven(f2);
        if (even > even2) {
            if (!this.printedShadowClipWarning) {
                this.printedShadowClipWarning = true;
            }
            even = even2;
        }
        if (this.rawShadowSize != even || this.rawMaxShadowSize != even2) {
            this.rawShadowSize = even;
            this.rawMaxShadowSize = even2;
            this.shadowSize = (float) Math.round(even * SHADOW_MULTIPLIER);
            this.maxShadowSize = even2;
            this.dirty = true;
            invalidateSelf();
        }
    }

    public void setShadowSize(float f) {
        setShadowSize(f, this.rawMaxShadowSize);
    }
}
