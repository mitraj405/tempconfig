package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

final class RightSheetDelegate extends SheetDelegate {
    final SideSheetBehavior<? extends View> sheetBehavior;

    public RightSheetDelegate(SideSheetBehavior<? extends View> sideSheetBehavior) {
        this.sheetBehavior = sideSheetBehavior;
    }

    public int calculateInnerMargin(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    public float calculateSlideOffset(int i) {
        float hiddenOffset = (float) getHiddenOffset();
        return (hiddenOffset - ((float) i)) / (hiddenOffset - ((float) getExpandedOffset()));
    }

    public int getCoplanarSiblingAdjacentMargin(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    public int getExpandedOffset() {
        return Math.max(0, (getHiddenOffset() - this.sheetBehavior.getChildWidth()) - this.sheetBehavior.getInnerMargin());
    }

    public int getHiddenOffset() {
        return this.sheetBehavior.getParentWidth();
    }

    public int getMaxViewPositionHorizontal() {
        return this.sheetBehavior.getParentWidth();
    }

    public int getMinViewPositionHorizontal() {
        return getExpandedOffset();
    }

    public <V extends View> int getOuterEdge(V v) {
        return v.getLeft() - this.sheetBehavior.getInnerMargin();
    }

    public int getParentInnerEdge(CoordinatorLayout coordinatorLayout) {
        return coordinatorLayout.getRight();
    }

    public int getSheetEdge() {
        return 0;
    }

    public boolean isExpandingOutwards(float f) {
        if (f < 0.0f) {
            return true;
        }
        return false;
    }

    public boolean isReleasedCloseToInnerEdge(View view) {
        if (view.getLeft() > (getHiddenOffset() + getExpandedOffset()) / 2) {
            return true;
        }
        return false;
    }

    public boolean isSwipeSignificant(float f, float f2) {
        if (!SheetUtils.isSwipeMostlyHorizontal(f, f2) || Math.abs(f) <= ((float) this.sheetBehavior.getSignificantVelocityThreshold())) {
            return false;
        }
        return true;
    }

    public boolean shouldHide(View view, float f) {
        if (Math.abs((this.sheetBehavior.getHideFriction() * f) + ((float) view.getRight())) > this.sheetBehavior.getHideThreshold()) {
            return true;
        }
        return false;
    }

    public void updateCoplanarSiblingAdjacentMargin(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        marginLayoutParams.rightMargin = i;
    }

    public void updateCoplanarSiblingLayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2) {
        int parentWidth = this.sheetBehavior.getParentWidth();
        if (i <= parentWidth) {
            marginLayoutParams.rightMargin = parentWidth - i;
        }
    }
}
