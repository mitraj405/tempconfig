package cris.org.in.ima.fragment;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.os.Handler;
import cris.org.in.ima.fragment.NewBookingFragment;
import cris.org.in.prs.ima.R;

/* compiled from: NewBookingFragment */
public final class Y implements DialogInterface.OnClickListener {
    public final /* synthetic */ NewBookingFragment.p a;

    public Y(NewBookingFragment.p pVar) {
        this.a = pVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Om om;
        NewBookingFragment.p pVar = this.a;
        NewBookingFragment.this.f4844a.dismiss();
        dialogInterface.dismiss();
        boolean z = NewBookingFragment.k;
        NewBookingFragment newBookingFragment = NewBookingFragment.this;
        if (z) {
            C0535I5.o(newBookingFragment.getActivity(), newBookingFragment.getString(R.string.connecting_not_allow), newBookingFragment.getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
        } else if (newBookingFragment.f4863c) {
            C0535I5.o(newBookingFragment.getActivity(), newBookingFragment.getString(R.string.journalist_not_allow), newBookingFragment.getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
        } else if (NewBookingFragment.l) {
            C0535I5.o(newBookingFragment.getActivity(), newBookingFragment.getString(R.string.railpass_not_allow), newBookingFragment.getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
        } else if (!C0535I5.O((ConnectivityManager) newBookingFragment.getActivity().getSystemService("connectivity"), newBookingFragment.getActivity())) {
            new Handler().postDelayed(new Hm(), 5000);
        } else {
            ProgressDialog show = ProgressDialog.show(newBookingFragment.getActivity(), newBookingFragment.getString(R.string.train_Search), newBookingFragment.getString(R.string.please_wait_text));
            newBookingFragment.f4844a = show;
            show.show();
            C1469x0 x0Var = new C1469x0();
            x0Var.setDestStn(newBookingFragment.f);
            x0Var.setSrcStn(newBookingFragment.f4867e);
            x0Var.setJrnyDate(newBookingFragment.f4861c);
            x0Var.setFlexiFlag(newBookingFragment.flexiableDate.isChecked());
            x0Var.setFlexiJrnyDate(newBookingFragment.f4861c);
            if (C0535I5.R()) {
                om = (Om) C0657Qt.c(C0793b1.a.f3912a);
            } else {
                om = (Om) C0657Qt.b();
            }
            String f = C0657Qt.f();
            om.G0(f + "indirectTBIS", x0Var).c(C1181iv.a()).a(E0.a()).b(new C1014b0(newBookingFragment, x0Var));
        }
    }
}
