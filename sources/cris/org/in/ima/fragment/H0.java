package cris.org.in.ima.fragment;

import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import cris.org.in.ima.activities.HomeActivity;

/* compiled from: UpdateProfileFragment */
public final class H0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ I0 a;

    public H0(I0 i0) {
        this.a = i0;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        I0 i0 = this.a;
        boolean equals = i0.c.equals("M");
        UpdateProfileFragment updateProfileFragment = i0.f4658a;
        if (equals) {
            updateProfileFragment.mobile.setText(i0.d);
        } else {
            updateProfileFragment.email.setText(i0.e);
        }
        HomeActivity.B(updateProfileFragment.f5185a);
        FragmentActivity fragmentActivity = updateProfileFragment.f5185a;
        MyAccountFragment myAccountFragment = new MyAccountFragment();
        String a2 = C1218kf.MY_ACCOUNT.a();
        Boolean bool = Boolean.TRUE;
        HomeActivity.n(fragmentActivity, myAccountFragment, a2, bool, bool);
        C0535I5.o = true;
    }
}
