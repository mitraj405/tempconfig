package defpackage;

import android.content.DialogInterface;
import cris.org.in.ima.fragment.AadhaarKYCFragment;
import cris.org.in.ima.fragment.C1011a;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.EwalletProfileDTO;
import rx.Subscriber;

/* renamed from: e  reason: default package and case insensitive filesystem */
/* compiled from: AadhaarKYCFragment */
public final class C1079e extends Subscriber<EwalletProfileDTO> {
    public final /* synthetic */ AadhaarKYCFragment a;

    public C1079e(AadhaarKYCFragment aadhaarKYCFragment) {
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
        EwalletProfileDTO ewalletProfileDTO = (EwalletProfileDTO) obj;
        if (ewalletProfileDTO != null) {
            boolean equals = ewalletProfileDTO.getErrorMessage().equals("");
            AadhaarKYCFragment aadhaarKYCFragment = this.a;
            if (!equals) {
                C0535I5.m(aadhaarKYCFragment.getActivity(), false, ewalletProfileDTO.getErrorMessage(), aadhaarKYCFragment.getString(R.string.error), aadhaarKYCFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            } else if (ewalletProfileDTO.getPancardStatusString() != null) {
                C0535I5.I(aadhaarKYCFragment.getActivity());
                C0535I5.p(aadhaarKYCFragment.getActivity(), false, ewalletProfileDTO.getPancardStatusString(), aadhaarKYCFragment.getString(R.string.Info), aadhaarKYCFragment.getString(R.string.OK), new C1011a(this), (String) null, (DialogInterface.OnClickListener) null).show();
            } else {
                C0535I5.m(aadhaarKYCFragment.getActivity(), false, aadhaarKYCFragment.getString(R.string.unble_to_request_try_sometime), aadhaarKYCFragment.getString(R.string.error), aadhaarKYCFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            }
        }
    }
}
