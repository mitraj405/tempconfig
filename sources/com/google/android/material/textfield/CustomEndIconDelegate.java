package com.google.android.material.textfield;

import android.view.View;

class CustomEndIconDelegate extends EndIconDelegate {
    public CustomEndIconDelegate(EndCompoundLayout endCompoundLayout) {
        super(endCompoundLayout);
    }

    public void setUp() {
        this.endLayout.setEndIconOnLongClickListener((View.OnLongClickListener) null);
    }
}
