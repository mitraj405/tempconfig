package com.google.android.material.slider;

import android.view.ViewTreeObserver;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class a implements ViewTreeObserver.OnScrollChangedListener {
    public final /* synthetic */ BaseSlider a;

    public /* synthetic */ a(BaseSlider baseSlider) {
        this.a = baseSlider;
    }

    public final void onScrollChanged() {
        this.a.updateLabels();
    }
}
