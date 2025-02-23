package defpackage;

import android.content.DialogInterface;
import android.content.Intent;
import cris.org.in.ima.activities.LoginActivity;

/* renamed from: lb  reason: default package and case insensitive filesystem */
/* compiled from: EwalletRegisterFragment */
public final class C1238lb implements DialogInterface.OnClickListener {
    public final /* synthetic */ C1257mb a;

    public C1238lb(C1257mb mbVar) {
        this.a = mbVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        C1257mb mbVar = this.a;
        mbVar.f5596a.startActivity(new Intent(mbVar.f5596a.getActivity(), LoginActivity.class));
    }
}
