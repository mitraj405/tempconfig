package cris.org.in.ima.fragment;

import android.content.DialogInterface;
import cris.org.in.prs.ima.R;

/* renamed from: cris.org.in.ima.fragment.a  reason: case insensitive filesystem */
/* compiled from: AadhaarKYCFragment */
public final class C1011a implements DialogInterface.OnClickListener {
    public final /* synthetic */ C1079e a;

    public C1011a(C1079e eVar) {
        this.a = eVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        C1079e eVar = this.a;
        AadhaarKYCFragment aadhaarKYCFragment = eVar.a;
        aadhaarKYCFragment.updation_title_tv.setText(aadhaarKYCFragment.getString(R.string.pan_updation_otp));
        eVar.a.otpLayout.setVisibility(0);
    }
}
