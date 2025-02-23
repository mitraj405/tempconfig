package cris.org.in.ima.fragment;

import android.content.DialogInterface;
import android.text.Html;
import cris.org.in.prs.ima.R;
import java.text.SimpleDateFormat;
import java.util.Locale;
import rx.Subscriber;

/* renamed from: cris.org.in.ima.fragment.c  reason: case insensitive filesystem */
/* compiled from: AadharRegistraionFragment */
public final class C1015c extends Subscriber<C1122g> {
    public final /* synthetic */ AadharRegistraionFragment a;

    public C1015c(AadharRegistraionFragment aadharRegistraionFragment) {
        this.a = aadharRegistraionFragment;
    }

    public final void onCompleted() {
        this.a.a.dismiss();
        int i = AadharRegistraionFragment.c;
    }

    public final void onError(Throwable th) {
        int i = AadharRegistraionFragment.c;
        xx.S(th, true, th);
    }

    public final void onNext(Object obj) {
        C1122g gVar = (C1122g) obj;
        if (gVar != null) {
            String errorMessage = gVar.getErrorMessage();
            AadharRegistraionFragment aadharRegistraionFragment = this.a;
            if (errorMessage == null) {
                short s = (short) (aadharRegistraionFragment.f4395a + 1);
                aadharRegistraionFragment.f4395a = s;
                if (s == 1) {
                    aadharRegistraionFragment.otpLayout.setVisibility(0);
                    aadharRegistraionFragment.detailsLayout.setVisibility(8);
                    aadharRegistraionFragment.tAndckycLayout.setVisibility(8);
                    aadharRegistraionFragment.sendOTP.setText(aadharRegistraionFragment.getString(R.string.Verify_OTP));
                    aadharRegistraionFragment.status.setText(gVar.getStatus());
                    aadharRegistraionFragment.f4394a.setOtpTransactionId(gVar.getOtpTransactionId());
                    aadharRegistraionFragment.botAdLayout.setVisibility(0);
                    aadharRegistraionFragment.botAdLayout.removeAllViews();
                } else if (s == 2) {
                    aadharRegistraionFragment.otpLayout.setVisibility(8);
                    aadharRegistraionFragment.detailsLayout.setVisibility(0);
                    aadharRegistraionFragment.uidDisplay.setVisibility(0);
                    aadharRegistraionFragment.aadharLayout.setVisibility(8);
                    aadharRegistraionFragment.tAndckycLayout.setVisibility(8);
                    aadharRegistraionFragment.uidNumber.setText(gVar.getAadhaarNumber());
                    aadharRegistraionFragment.sendOTP.setText("Update KYC");
                    aadharRegistraionFragment.addressUid.setText(gVar.getAddress());
                    aadharRegistraionFragment.colonyUid.setText(gVar.getColony());
                    aadharRegistraionFragment.districtUid.setText(gVar.getDistrict());
                    aadharRegistraionFragment.genderUid.setText(gVar.getGender());
                    aadharRegistraionFragment.pinUid.setText(gVar.getPincode());
                    aadharRegistraionFragment.stateUid.setText(gVar.getState());
                    aadharRegistraionFragment.botAdLayout.setVisibility(8);
                    aadharRegistraionFragment.botAdLayout.removeAllViews();
                    try {
                        aadharRegistraionFragment.dobUid.setText(new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).format(gVar.getDateOfBirth()));
                    } catch (Exception e) {
                        int i = AadharRegistraionFragment.c;
                        e.getMessage();
                    }
                    aadharRegistraionFragment.status.setText(gVar.getStatus());
                } else {
                    aadharRegistraionFragment.botAdLayout.setVisibility(8);
                    aadharRegistraionFragment.f4394a = new C1122g();
                    aadharRegistraionFragment.otpLayout.setVisibility(8);
                    aadharRegistraionFragment.detailsLayout.setVisibility(8);
                    aadharRegistraionFragment.tAndckycLayout.setVisibility(8);
                    aadharRegistraionFragment.botAdLayout.removeAllViews();
                    C0535I5.n(aadharRegistraionFragment.getActivity(), Html.fromHtml(gVar.getStatus()), aadharRegistraionFragment.getString(R.string.update_aadhaarkyc), aadharRegistraionFragment.getString(R.string.OK), new C1166i(this), (String) null, (DialogInterface.OnClickListener) null).show();
                }
            } else {
                C0535I5.m(aadharRegistraionFragment.getActivity(), false, gVar.getErrorMessage(), aadharRegistraionFragment.getString(R.string.error), "OK", (DialogInterface.OnClickListener) null).show();
            }
        }
    }
}
