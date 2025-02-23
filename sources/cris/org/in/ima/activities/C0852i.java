package cris.org.in.ima.activities;

import android.content.DialogInterface;
import android.content.Intent;
import cris.org.in.ima.activities.LoginActivity;

/* renamed from: cris.org.in.ima.activities.i  reason: case insensitive filesystem */
/* compiled from: LoginActivity */
public final class C0852i implements DialogInterface.OnClickListener {
    public final /* synthetic */ LoginActivity.g a;

    public C0852i(LoginActivity.g gVar) {
        this.a = gVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        LoginActivity.g gVar = this.a;
        LoginActivity.this.startActivity(new Intent(LoginActivity.this.getApplicationContext(), LoginActivity.class));
    }
}
