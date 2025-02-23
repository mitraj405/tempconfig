package com.google.android.material.sidesheet;

import android.view.View;

public abstract class SideSheetCallback implements SheetCallback {
    public abstract void onSlide(View view, float f);

    public abstract void onStateChanged(View view, int i);

    public void onLayout(View view) {
    }
}
