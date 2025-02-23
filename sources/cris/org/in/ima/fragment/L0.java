package cris.org.in.ima.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import cris.org.in.ima.activities.LoginActivity;
import cris.org.in.ima.fragment.UpdateProfileFragment;

/* compiled from: UpdateProfileFragment */
public final class L0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ UpdateProfileFragment.a a;

    public L0(UpdateProfileFragment.a aVar) {
        this.a = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        UpdateProfileFragment.a aVar = this.a;
        UpdateProfileFragment.this.startActivity(new Intent(UpdateProfileFragment.this.f5185a, LoginActivity.class));
    }
}
