package com.google.android.material.shape;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

class ShapeableDelegateV33 extends ShapeableDelegate {
    public ShapeableDelegateV33(View view) {
        initMaskOutlineProvider(view);
    }

    private void initMaskOutlineProvider(View view) {
        view.setOutlineProvider(new ViewOutlineProvider() {
            public void getOutline(View view, Outline outline) {
                if (!ShapeableDelegateV33.this.shapePath.isEmpty()) {
                    outline.setPath(ShapeableDelegateV33.this.shapePath);
                }
            }
        });
    }

    public void invalidateClippingMethod(View view) {
        view.setClipToOutline(!shouldUseCompatClipping());
        if (shouldUseCompatClipping()) {
            view.invalidate();
        } else {
            view.invalidateOutline();
        }
    }

    public boolean shouldUseCompatClipping() {
        return this.forceCompatClippingEnabled;
    }
}
