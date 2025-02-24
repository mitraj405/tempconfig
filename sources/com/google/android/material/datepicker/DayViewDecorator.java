package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;

public abstract class DayViewDecorator implements Parcelable {
    public ColorStateList getBackgroundColor(Context context, int i, int i2, int i3, boolean z, boolean z2) {
        return null;
    }

    public Drawable getCompoundDrawableBottom(Context context, int i, int i2, int i3, boolean z, boolean z2) {
        return null;
    }

    public Drawable getCompoundDrawableLeft(Context context, int i, int i2, int i3, boolean z, boolean z2) {
        return null;
    }

    public Drawable getCompoundDrawableRight(Context context, int i, int i2, int i3, boolean z, boolean z2) {
        return null;
    }

    public Drawable getCompoundDrawableTop(Context context, int i, int i2, int i3, boolean z, boolean z2) {
        return null;
    }

    public ColorStateList getTextColor(Context context, int i, int i2, int i3, boolean z, boolean z2) {
        return null;
    }

    public void initialize(Context context) {
    }

    public CharSequence getContentDescription(Context context, int i, int i2, int i3, boolean z, boolean z2, CharSequence charSequence) {
        return charSequence;
    }
}
