package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class ClippableRoundedCornerLayout extends FrameLayout {
    private float cornerRadius;
    private Path path;

    public ClippableRoundedCornerLayout(Context context) {
        super(context);
    }

    public void dispatchDraw(Canvas canvas) {
        if (this.path == null) {
            super.dispatchDraw(canvas);
            return;
        }
        int save = canvas.save();
        canvas.clipPath(this.path);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }

    public float getCornerRadius() {
        return this.cornerRadius;
    }

    public void resetClipBoundsAndCornerRadius() {
        this.path = null;
        this.cornerRadius = 0.0f;
        invalidate();
    }

    public void updateClipBoundsAndCornerRadius(Rect rect, float f) {
        updateClipBoundsAndCornerRadius((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom, f);
    }

    public void updateCornerRadius(float f) {
        updateClipBoundsAndCornerRadius((float) getLeft(), (float) getTop(), (float) getRight(), (float) getBottom(), f);
    }

    public ClippableRoundedCornerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void updateClipBoundsAndCornerRadius(float f, float f2, float f3, float f4, float f5) {
        updateClipBoundsAndCornerRadius(new RectF(f, f2, f3, f4), f5);
    }

    public ClippableRoundedCornerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void updateClipBoundsAndCornerRadius(RectF rectF, float f) {
        if (this.path == null) {
            this.path = new Path();
        }
        this.cornerRadius = f;
        this.path.reset();
        this.path.addRoundRect(rectF, f, f, Path.Direction.CW);
        this.path.close();
        invalidate();
    }
}
