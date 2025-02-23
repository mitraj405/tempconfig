package com.google.android.material.drawable;

import android.graphics.drawable.Drawable;

public class ScaledDrawableWrapper extends x9 {
    private final int height;
    private final int width;

    public ScaledDrawableWrapper(Drawable drawable, int i, int i2) {
        super(drawable);
        this.width = i;
        this.height = i2;
    }

    public int getIntrinsicHeight() {
        return this.height;
    }

    public int getIntrinsicWidth() {
        return this.width;
    }
}
