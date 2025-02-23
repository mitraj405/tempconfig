package cris.org.in.ima.activities;

import android.content.DialogInterface;

/* compiled from: LoginActivity */
public final class r implements DialogInterface.OnClickListener {
    public final /* synthetic */ s a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C1223kn f4376a;

    public r(s sVar, C1223kn knVar) {
        this.a = sVar;
        this.f4376a = knVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        boolean contains = this.f4376a.getError_description().contains("Access denied");
        s sVar = this.a;
        if (contains) {
            sVar.a.finish();
        } else if (!sVar.a.bookingWithOtp.isChecked()) {
            sVar.a.loginCaptchaRefresh();
        }
    }
}
