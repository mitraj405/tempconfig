package defpackage;

import android.content.DialogInterface;
import android.os.Bundle;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.fragment.AadhaarKYCFragment;
import cris.org.in.ima.fragment.AdhaarKYCUpdateFragment;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.StatusDTO;
import rx.Subscriber;

/* renamed from: f  reason: default package and case insensitive filesystem */
/* compiled from: AadhaarKYCFragment */
public final class C1098f extends Subscriber<StatusDTO> {
    public final /* synthetic */ AadhaarKYCFragment a;

    public C1098f(AadhaarKYCFragment aadhaarKYCFragment) {
        this.a = aadhaarKYCFragment;
    }

    public final void onCompleted() {
        this.a.f4383a.dismiss();
        int i = AadhaarKYCFragment.c;
    }

    public final void onError(Throwable th) {
        int i = AadhaarKYCFragment.c;
        xx.S(th, true, th);
    }

    public final void onNext(Object obj) {
        StatusDTO statusDTO = (StatusDTO) obj;
        AadhaarKYCFragment aadhaarKYCFragment = this.a;
        if (statusDTO == null) {
            C0535I5.m(aadhaarKYCFragment.getActivity(), false, aadhaarKYCFragment.getString(R.string.unble_to_request_try_sometime), aadhaarKYCFragment.getString(R.string.error), aadhaarKYCFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        } else if (statusDTO.getStatus() == null || statusDTO.getStatus().equals("")) {
            C0535I5.m(aadhaarKYCFragment.getActivity(), false, statusDTO.getError(), aadhaarKYCFragment.getString(R.string.error), aadhaarKYCFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        } else {
            C0535I5.I(aadhaarKYCFragment.getActivity());
            Bundle bundle = new Bundle();
            AdhaarKYCUpdateFragment adhaarKYCUpdateFragment = new AdhaarKYCUpdateFragment();
            bundle.putSerializable("kycOtpDTO", aadhaarKYCFragment.a);
            bundle.putSerializable("successMsgForPanKyc", statusDTO.getStatus());
            bundle.putSerializable("successMsgForPanKyc1", statusDTO.getStatus1());
            bundle.putSerializable("successMsgForPanKyc2", statusDTO.getStatus2());
            adhaarKYCUpdateFragment.setArguments(bundle);
            HomeActivity.n(aadhaarKYCFragment.getActivity(), adhaarKYCUpdateFragment, aadhaarKYCFragment.getResources().getString(R.string.update_panKyc), Boolean.TRUE, Boolean.FALSE);
        }
    }
}
