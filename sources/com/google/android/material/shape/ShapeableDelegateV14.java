package com.google.android.material.shape;

import android.view.View;

class ShapeableDelegateV14 extends ShapeableDelegate {
    public void invalidateClippingMethod(View view) {
        if (this.shapeAppearanceModel != null && !this.maskBounds.isEmpty() && shouldUseCompatClipping()) {
            view.invalidate();
        }
    }

    public boolean shouldUseCompatClipping() {
        return true;
    }
}
