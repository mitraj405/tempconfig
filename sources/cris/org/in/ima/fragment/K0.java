package cris.org.in.ima.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.a;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.fragment.UpdateProfileFragment;

/* compiled from: UpdateProfileFragment */
public final class K0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ UpdateProfileFragment.a a;

    public K0(UpdateProfileFragment.a aVar) {
        this.a = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        UpdateProfileFragment.a aVar = this.a;
        UpdateProfileFragment.this.f5194e = true;
        HomeActivity.o();
        AadhaarKYCFragment aadhaarKYCFragment = new AadhaarKYCFragment();
        Bundle bundle = new Bundle();
        bundle.putString("type", "ewallet");
        bundle.putBoolean("isUpdateProfileFlow", true);
        UpdateProfileFragment updateProfileFragment = UpdateProfileFragment.this;
        bundle.putString("updateProfileDob", updateProfileFragment.dob.getText().toString());
        aadhaarKYCFragment.setArguments(bundle);
        HomeActivity.n((AppCompatActivity) updateProfileFragment.getActivity(), aadhaarKYCFragment, C1218kf.AADHAARPANKYC.a(), Boolean.TRUE, Boolean.FALSE);
        FragmentManager fragmentManager = updateProfileFragment.getFragmentManager();
        fragmentManager.getClass();
        a aVar2 = new a(fragmentManager);
        aVar2.n(updateProfileFragment);
        aVar2.c();
    }
}
