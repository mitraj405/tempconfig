package cris.org.in.ima.activities;

import android.content.DialogInterface;
import cris.org.in.ima.activities.LoginActivity;

/* renamed from: cris.org.in.ima.activities.n  reason: case insensitive filesystem */
/* compiled from: LoginActivity */
public final class C0857n implements DialogInterface.OnClickListener {
    public final /* synthetic */ LoginActivity.i a;

    public C0857n(LoginActivity.i iVar) {
        this.a = iVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        LoginActivity.i iVar = this.a;
        LoginActivity.this.ChangePwdetCaptcha.setText("");
        LoginActivity.this.p();
        dialogInterface.dismiss();
    }
}
