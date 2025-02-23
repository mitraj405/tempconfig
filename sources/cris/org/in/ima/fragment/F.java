package cris.org.in.ima.fragment;

import android.content.DialogInterface;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.fragment.ChangeTxnPasswordFragment;

/* compiled from: ChangeTxnPasswordFragment */
public final class F implements DialogInterface.OnClickListener {
    public final /* synthetic */ ChangeTxnPasswordFragment.a.b a;

    public F(ChangeTxnPasswordFragment.a.b bVar) {
        this.a = bVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ChangeTxnPasswordFragment.a.b bVar = this.a;
        ChangeTxnPasswordFragment.this.oldPassword.setText("");
        ChangeTxnPasswordFragment.this.oldPassword.requestFocus();
        ChangeTxnPasswordFragment.this.newPassword.setText("");
        ChangeTxnPasswordFragment.this.confirmPassword.setText("");
        C0535I5.I(ChangeTxnPasswordFragment.this.getActivity());
        HomeActivity.B(ChangeTxnPasswordFragment.this.getActivity());
    }
}
