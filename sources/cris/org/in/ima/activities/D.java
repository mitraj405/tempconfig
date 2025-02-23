package cris.org.in.ima.activities;

import android.content.DialogInterface;
import cris.org.in.ima.activities.PinValidationActivity;

/* compiled from: PinValidationActivity */
public final class D implements DialogInterface.OnClickListener {
    public final /* synthetic */ PinValidationActivity.c a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C1223kn f4155a;

    public D(PinValidationActivity.c cVar, C1223kn knVar) {
        this.a = cVar;
        this.f4155a = knVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        boolean contains = this.f4155a.getError_description().contains("Access denied");
        PinValidationActivity.c cVar = this.a;
        if (contains) {
            PinValidationActivity.this.finish();
        } else {
            PinValidationActivity.this.loginCaptchaRefresh();
        }
    }
}
