package com.google.android.material.timepicker;

import com.google.android.material.button.MaterialButtonToggleGroup;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class c implements MaterialButtonToggleGroup.OnButtonCheckedListener {
    public final /* synthetic */ TimePickerTextInputPresenter a;

    public /* synthetic */ c(TimePickerTextInputPresenter timePickerTextInputPresenter) {
        this.a = timePickerTextInputPresenter;
    }

    public final void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z) {
        this.a.lambda$setupPeriodToggle$0(materialButtonToggleGroup, i, z);
    }
}
