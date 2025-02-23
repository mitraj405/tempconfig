package defpackage;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import in.juspay.hypersdk.core.JBridge;

/* renamed from: wg  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C1459wg implements DatePickerDialog.OnDateSetListener {
    public final /* synthetic */ JBridge a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f7033a;

    public /* synthetic */ C1459wg(JBridge jBridge, String str) {
        this.a = jBridge;
        this.f7033a = str;
    }

    public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.a.lambda$newDialogWithoutDateField$3(this.f7033a, datePicker, i, i2, i3);
    }
}
