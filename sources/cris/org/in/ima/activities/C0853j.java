package cris.org.in.ima.activities;

import android.content.DialogInterface;
import cris.org.in.ima.activities.LoginActivity;

/* renamed from: cris.org.in.ima.activities.j  reason: case insensitive filesystem */
/* compiled from: LoginActivity */
public final class C0853j implements DialogInterface.OnClickListener {
    public final /* synthetic */ LoginActivity.g a;

    public C0853j(LoginActivity.g gVar) {
        this.a = gVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        LoginActivity.g gVar = this.a;
        LoginActivity.this.etCaptcha.setText("");
        LoginActivity.this.p();
        dialogInterface.dismiss();
    }
}
