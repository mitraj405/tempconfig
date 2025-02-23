package defpackage;

import android.content.DialogInterface;
import android.content.Intent;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.activities.LoginActivity;

/* renamed from: Y  reason: default package and case insensitive filesystem */
/* compiled from: AddLoyaltyFragment */
public final class C0751Y implements DialogInterface.OnClickListener {
    public final /* synthetic */ C0774a0 a;

    public C0751Y(C0774a0 a0Var) {
        this.a = a0Var;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        C0774a0 a0Var = this.a;
        HomeActivity.B(a0Var.f3891a);
        a0Var.f3892a.startActivity(new Intent(a0Var.f3891a, LoginActivity.class));
    }
}
