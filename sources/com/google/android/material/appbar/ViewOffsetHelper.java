package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.f;
import java.util.WeakHashMap;

class ViewOffsetHelper {
    private boolean horizontalOffsetEnabled = true;
    private int layoutLeft;
    private int layoutTop;
    private int offsetLeft;
    private int offsetTop;
    private boolean verticalOffsetEnabled = true;
    private final View view;

    public ViewOffsetHelper(View view2) {
        this.view = view2;
    }

    public void applyOffsets() {
        View view2 = this.view;
        int top = this.offsetTop - (view2.getTop() - this.layoutTop);
        WeakHashMap<View, GC> weakHashMap = f.f1839a;
        view2.offsetTopAndBottom(top);
        View view3 = this.view;
        view3.offsetLeftAndRight(this.offsetLeft - (view3.getLeft() - this.layoutLeft));
    }

    public int getLayoutLeft() {
        return this.layoutLeft;
    }

    public int getLayoutTop() {
        return this.layoutTop;
    }

    public int getLeftAndRightOffset() {
        return this.offsetLeft;
    }

    public int getTopAndBottomOffset() {
        return this.offsetTop;
    }

    public boolean isHorizontalOffsetEnabled() {
        return this.horizontalOffsetEnabled;
    }

    public boolean isVerticalOffsetEnabled() {
        return this.verticalOffsetEnabled;
    }

    public void onViewLayout() {
        this.layoutTop = this.view.getTop();
        this.layoutLeft = this.view.getLeft();
    }

    public void setHorizontalOffsetEnabled(boolean z) {
        this.horizontalOffsetEnabled = z;
    }

    public boolean setLeftAndRightOffset(int i) {
        if (!this.horizontalOffsetEnabled || this.offsetLeft == i) {
            return false;
        }
        this.offsetLeft = i;
        applyOffsets();
        return true;
    }

    public boolean setTopAndBottomOffset(int i) {
        if (!this.verticalOffsetEnabled || this.offsetTop == i) {
            return false;
        }
        this.offsetTop = i;
        applyOffsets();
        return true;
    }

    public void setVerticalOffsetEnabled(boolean z) {
        this.verticalOffsetEnabled = z;
    }
}
