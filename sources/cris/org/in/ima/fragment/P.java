package cris.org.in.ima.fragment;

import android.content.DialogInterface;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.fragment.ForgotTxnPasswordFragment;

/* compiled from: ForgotTxnPasswordFragment */
public final class P implements DialogInterface.OnClickListener {
    public final /* synthetic */ ForgotTxnPasswordFragment.a.d a;

    public P(ForgotTxnPasswordFragment.a.d dVar) {
        this.a = dVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        HomeActivity.B(ForgotTxnPasswordFragment.this.getActivity());
    }
}
