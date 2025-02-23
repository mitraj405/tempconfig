package com.google.android.material.shape;

import android.graphics.Outline;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;

class ShapeableDelegateV22 extends ShapeableDelegate {
    private boolean canUseViewOutline = false;
    /* access modifiers changed from: private */
    public float cornerRadius = 0.0f;

    public ShapeableDelegateV22(View view) {
        initMaskOutlineProvider(view);
    }

    private float getDefaultCornerRadius() {
        RectF rectF;
        ShapeAppearanceModel shapeAppearanceModel = this.shapeAppearanceModel;
        if (shapeAppearanceModel == null || (rectF = this.maskBounds) == null) {
            return 0.0f;
        }
        return shapeAppearanceModel.topRightCornerSize.getCornerSize(rectF);
    }

    private void initMaskOutlineProvider(View view) {
        view.setOutlineProvider(new ViewOutlineProvider() {
            public void getOutline(View view, Outline outline) {
                ShapeableDelegateV22 shapeableDelegateV22 = ShapeableDelegateV22.this;
                if (shapeableDelegateV22.shapeAppearanceModel != null && !shapeableDelegateV22.maskBounds.isEmpty()) {
                    ShapeableDelegateV22 shapeableDelegateV222 = ShapeableDelegateV22.this;
                    RectF rectF = shapeableDelegateV222.maskBounds;
                    outline.setRoundRect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom, shapeableDelegateV222.cornerRadius);
                }
            }
        });
    }

    private boolean isShapeRoundRect() {
        ShapeAppearanceModel shapeAppearanceModel;
        if (this.maskBounds.isEmpty() || (shapeAppearanceModel = this.shapeAppearanceModel) == null) {
            return false;
        }
        return shapeAppearanceModel.isRoundRect(this.maskBounds);
    }

    private boolean offsetZeroCornerEdgeBoundsIfPossible() {
        ShapeAppearanceModel shapeAppearanceModel;
        if (!this.maskBounds.isEmpty() && (shapeAppearanceModel = this.shapeAppearanceModel) != null && this.offsetZeroCornerEdgeBoundsEnabled && !shapeAppearanceModel.isRoundRect(this.maskBounds) && shapeUsesAllRoundedCornerTreatments(this.shapeAppearanceModel)) {
            float cornerSize = this.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(this.maskBounds);
            float cornerSize2 = this.shapeAppearanceModel.getTopRightCornerSize().getCornerSize(this.maskBounds);
            float cornerSize3 = this.shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(this.maskBounds);
            float cornerSize4 = this.shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(this.maskBounds);
            int i = (cornerSize > 0.0f ? 1 : (cornerSize == 0.0f ? 0 : -1));
            if (i == 0 && cornerSize3 == 0.0f && cornerSize2 == cornerSize4) {
                RectF rectF = this.maskBounds;
                rectF.set(rectF.left - cornerSize2, rectF.top, rectF.right, rectF.bottom);
                this.cornerRadius = cornerSize2;
                return true;
            } else if (i == 0 && cornerSize2 == 0.0f && cornerSize3 == cornerSize4) {
                RectF rectF2 = this.maskBounds;
                rectF2.set(rectF2.left, rectF2.top - cornerSize3, rectF2.right, rectF2.bottom);
                this.cornerRadius = cornerSize3;
                return true;
            } else if (cornerSize2 == 0.0f && cornerSize4 == 0.0f && cornerSize == cornerSize3) {
                RectF rectF3 = this.maskBounds;
                rectF3.set(rectF3.left, rectF3.top, rectF3.right + cornerSize, rectF3.bottom);
                this.cornerRadius = cornerSize;
                return true;
            } else if (cornerSize3 == 0.0f && cornerSize4 == 0.0f && cornerSize == cornerSize2) {
                RectF rectF4 = this.maskBounds;
                rectF4.set(rectF4.left, rectF4.top, rectF4.right, rectF4.bottom + cornerSize);
                this.cornerRadius = cornerSize;
                return true;
            }
        }
        return false;
    }

    private static boolean shapeUsesAllRoundedCornerTreatments(ShapeAppearanceModel shapeAppearanceModel) {
        if (!(shapeAppearanceModel.getTopLeftCorner() instanceof RoundedCornerTreatment) || !(shapeAppearanceModel.getTopRightCorner() instanceof RoundedCornerTreatment) || !(shapeAppearanceModel.getBottomLeftCorner() instanceof RoundedCornerTreatment) || !(shapeAppearanceModel.getBottomRightCorner() instanceof RoundedCornerTreatment)) {
            return false;
        }
        return true;
    }

    public float getCornerRadius() {
        return this.cornerRadius;
    }

    public void invalidateClippingMethod(View view) {
        boolean z;
        this.cornerRadius = getDefaultCornerRadius();
        if (isShapeRoundRect() || offsetZeroCornerEdgeBoundsIfPossible()) {
            z = true;
        } else {
            z = false;
        }
        this.canUseViewOutline = z;
        view.setClipToOutline(!shouldUseCompatClipping());
        if (shouldUseCompatClipping()) {
            view.invalidate();
        } else {
            view.invalidateOutline();
        }
    }

    public boolean shouldUseCompatClipping() {
        if (!this.canUseViewOutline || this.forceCompatClippingEnabled) {
            return true;
        }
        return false;
    }
}
