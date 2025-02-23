package cris.org.in.ima.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import cris.org.in.ima.activities.LoginActivity;
import cris.org.in.ima.fragment.ChangePasswordFragment;

/* compiled from: ChangePasswordFragment */
public final class E implements DialogInterface.OnClickListener {
    public final /* synthetic */ ChangePasswordFragment.a.b a;

    public E(ChangePasswordFragment.a.b bVar) {
        this.a = bVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ChangePasswordFragment.a.b bVar = this.a;
        Intent intent = new Intent(ChangePasswordFragment.this.getActivity(), LoginActivity.class);
        intent.putExtra("backchangepass", true);
        ChangePasswordFragment.this.startActivity(intent);
    }
}
