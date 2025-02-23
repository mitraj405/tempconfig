package cris.org.in.ima.fragment;

import android.os.Bundle;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.prs.ima.R;
import rx.Subscriber;

/* compiled from: VikalpSystemFragment */
public final class P0 extends Subscriber<C0750Xx> {
    public final /* synthetic */ C0674S1 a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ VikalpSystemFragment f4883a;

    public P0(VikalpSystemFragment vikalpSystemFragment, C0674S1 s1) {
        this.f4883a = vikalpSystemFragment;
        this.a = s1;
    }

    public final void onCompleted() {
        int i = VikalpSystemFragment.c;
    }

    public final void onError(Throwable th) {
        int i = VikalpSystemFragment.c;
        th.getClass();
        th.getMessage();
        this.f4883a.f5198a.dismiss();
        Mt.a(th);
    }

    public final void onNext(Object obj) {
        C0750Xx xx = (C0750Xx) obj;
        VikalpSystemFragment vikalpSystemFragment = this.f4883a;
        if (xx != null) {
            try {
                if (!xx.isErrorFlag()) {
                    int i = C0535I5.c;
                    C0674S1 s1 = this.a;
                    if (i == 2) {
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("pnr", s1.getPnrNumber());
                        bundle.putSerializable("JDate", xx.getJourneyDate());
                        SplTrainFragment splTrainFragment = new SplTrainFragment();
                        splTrainFragment.setArguments(bundle);
                        HomeActivity.n(vikalpSystemFragment.getActivity(), splTrainFragment, C1218kf.SPL_TRN_BKG.a(), Boolean.TRUE, Boolean.FALSE);
                    } else {
                        vikalpSystemFragment.f5198a.dismiss();
                        s1.getPnrNumber();
                        vikalpSystemFragment.pnrNumber.setEnabled(false);
                        vikalpSystemFragment.pnrNumber.setClickable(false);
                        vikalpSystemFragment.trainNumber.setClickable(false);
                        vikalpSystemFragment.trainNumber.setEnabled(false);
                        vikalpSystemFragment.otpLayout.setVisibility(0);
                    }
                    vikalpSystemFragment.f5198a.dismiss();
                    return;
                }
                vikalpSystemFragment.f5198a.dismiss();
                C0535I5.m(vikalpSystemFragment.f5199a, false, xx.getErrorMsg(), vikalpSystemFragment.getString(R.string.error), vikalpSystemFragment.getString(R.string.OK), new C1152hD(this)).show();
            } catch (Exception e) {
                vikalpSystemFragment.f5198a.dismiss();
                vikalpSystemFragment.f();
                int i2 = VikalpSystemFragment.c;
                e.getMessage();
            }
        } else {
            vikalpSystemFragment.f5198a.dismiss();
            vikalpSystemFragment.f();
            C0535I5.m(vikalpSystemFragment.f5199a, false, vikalpSystemFragment.getResources().getString(R.string.unable_process_message), vikalpSystemFragment.getString(R.string.error), vikalpSystemFragment.getString(R.string.OK), vikalpSystemFragment.f5202a).show();
        }
    }
}
