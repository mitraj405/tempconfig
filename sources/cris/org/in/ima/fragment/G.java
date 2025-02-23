package cris.org.in.ima.fragment;

import android.content.Context;
import android.content.DialogInterface;
import cris.org.in.ima.fragment.ERSFragment;
import cris.org.in.prs.ima.R;

/* compiled from: ERSFragment */
public final class G implements DialogInterface.OnClickListener {
    public final /* synthetic */ ERSFragment.t a;

    public G(ERSFragment.t tVar) {
        this.a = tVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Context context = this.a.a;
        int i2 = ERSFragment.c;
        C1223kn knVar = C0793b1.a.f3912a;
        if (knVar != null) {
            String j = C0657Qt.j();
            ((Om) C0657Qt.c(knVar)).E0(j + "retryDMRCBooking").c(C1181iv.a()).a(E0.a()).b(new C0662R9(context));
            return;
        }
        C0535I5.m(context, false, context.getResources().getString(R.string.data_connection_error_message), context.getString(R.string.error), context.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
    }
}
