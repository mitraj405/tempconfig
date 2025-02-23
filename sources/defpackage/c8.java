package defpackage;

import android.view.View;
import android.widget.EditText;
import com.google.android.material.datepicker.DateSelector;

/* renamed from: c8  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class c8 implements View.OnFocusChangeListener {
    public final /* synthetic */ EditText[] a;

    public /* synthetic */ c8(EditText[] editTextArr) {
        this.a = editTextArr;
    }

    public final void onFocusChange(View view, boolean z) {
        DateSelector.lambda$showKeyboardWithAutoHideBehavior$0(this.a, view, z);
    }
}
