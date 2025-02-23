package com.google.android.material.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

public class FadeThroughDrawable extends Drawable {
    private final float[] alphas = new float[2];
    private final Drawable fadeInDrawable;
    private final Drawable fadeOutDrawable;
    private float progress;

    public FadeThroughDrawable(Drawable drawable, Drawable drawable2) {
        this.fadeOutDrawable = drawable.getConstantState().newDrawable().mutate();
        Drawable mutate = drawable2.getConstantState().newDrawable().mutate();
        this.fadeInDrawable = mutate;
        mutate.setAlpha(0);
    }

    public void draw(Canvas canvas) {
        this.fadeOutDrawable.draw(canvas);
        this.fadeInDrawable.draw(canvas);
    }

    public int getIntrinsicHeight() {
        return Math.max(this.fadeOutDrawable.getIntrinsicHeight(), this.fadeInDrawable.getIntrinsicHeight());
    }

    public int getIntrinsicWidth() {
        return Math.max(this.fadeOutDrawable.getIntrinsicWidth(), this.fadeInDrawable.getIntrinsicWidth());
    }

    public int getMinimumHeight() {
        return Math.max(this.fadeOutDrawable.getMinimumHeight(), this.fadeInDrawable.getMinimumHeight());
    }

    public int getMinimumWidth() {
        return Math.max(this.fadeOutDrawable.getMinimumWidth(), this.fadeInDrawable.getMinimumWidth());
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isStateful() {
        if (this.fadeOutDrawable.isStateful() || this.fadeInDrawable.isStateful()) {
            return true;
        }
        return false;
    }

    public void setAlpha(int i) {
        if (this.progress <= 0.5f) {
            this.fadeOutDrawable.setAlpha(i);
            this.fadeInDrawable.setAlpha(0);
        } else {
            this.fadeOutDrawable.setAlpha(0);
            this.fadeInDrawable.setAlpha(i);
        }
        invalidateSelf();
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.fadeOutDrawable.setBounds(i, i2, i3, i4);
        this.fadeInDrawable.setBounds(i, i2, i3, i4);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.fadeOutDrawable.setColorFilter(colorFilter);
        this.fadeInDrawable.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setProgress(float f) {
        if (this.progress != f) {
            this.progress = f;
            FadeThroughUtils.calculateFadeOutAndInAlphas(f, this.alphas);
            this.fadeOutDrawable.setAlpha((int) (this.alphas[0] * 255.0f));
            this.fadeInDrawable.setAlpha((int) (this.alphas[1] * 255.0f));
            invalidateSelf();
        }
    }

    public boolean setState(int[] iArr) {
        boolean state = this.fadeOutDrawable.setState(iArr);
        boolean state2 = this.fadeInDrawable.setState(iArr);
        if (state || state2) {
            return true;
        }
        return false;
    }
}
