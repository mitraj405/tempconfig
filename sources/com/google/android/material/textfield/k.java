package com.google.android.material.textfield;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class k implements View.OnTouchListener {
    public final /* synthetic */ DropdownMenuEndIconDelegate a;

    public /* synthetic */ k(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate) {
        this.a = dropdownMenuEndIconDelegate;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.a.lambda$setUpDropdownShowHideBehavior$4(view, motionEvent);
    }
}
