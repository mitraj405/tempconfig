package cris.org.in.ima.activities;

import android.content.DialogInterface;

/* renamed from: cris.org.in.ima.activities.p  reason: case insensitive filesystem */
/* compiled from: LoginActivity */
public final class C0859p implements DialogInterface.OnClickListener {
    public final /* synthetic */ C0860q a;
    public final /* synthetic */ String c;

    public C0859p(C0860q qVar, String str) {
        this.a = qVar;
        this.c = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        boolean contains = this.c.contains("OTP");
        C0860q qVar = this.a;
        if (contains) {
            qVar.a.et_otp.setText("");
            qVar.a.CnfCaptchaEnter.setText("");
        } else {
            qVar.a.CnfCaptchaEnter.setText("");
        }
        dialogInterface.dismiss();
    }
}
