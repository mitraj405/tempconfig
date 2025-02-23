package cris.org.in.ima.fragment;

import cris.org.in.prs.ima.R;
import rx.Subscriber;

/* renamed from: cris.org.in.ima.fragment.h0  reason: case insensitive filesystem */
/* compiled from: ReleasePanAadhaarFragment */
public final class C1026h0 extends Subscriber<C1215kb> {
    public final /* synthetic */ ReleasePanAadhaarFragment a;

    public C1026h0(ReleasePanAadhaarFragment releasePanAadhaarFragment) {
        this.a = releasePanAadhaarFragment;
    }

    public final void onCompleted() {
        int i = ReleasePanAadhaarFragment.c;
    }

    public final void onError(Throwable th) {
        this.a.a.dismiss();
        int i = ReleasePanAadhaarFragment.c;
        xx.S(th, true, th);
    }

    public final void onNext(Object obj) {
        C1215kb kbVar = (C1215kb) obj;
        int i = ReleasePanAadhaarFragment.c;
        ReleasePanAadhaarFragment releasePanAadhaarFragment = this.a;
        if (kbVar != null) {
            try {
                releasePanAadhaarFragment.f5071a = kbVar;
                if (kbVar.getUserName() != null) {
                    releasePanAadhaarFragment.user_name_tv.setText(kbVar.getUserName());
                }
                if (kbVar.getIdCardNumber() != null) {
                    releasePanAadhaarFragment.aadhaar_tv.setText(kbVar.getIdCardNumber());
                }
                if (kbVar.getPancardNumber() != null) {
                    releasePanAadhaarFragment.pan_tv.setText(kbVar.getPancardNumber());
                }
                releasePanAadhaarFragment.balance_tv.setText(Double.toString(kbVar.getClosingBalanceDeactivate()));
            } catch (Exception e) {
                int i2 = ReleasePanAadhaarFragment.c;
                e.getMessage();
            } catch (Throwable th) {
                releasePanAadhaarFragment.a.dismiss();
                throw th;
            }
            releasePanAadhaarFragment.a.dismiss();
            return;
        }
        releasePanAadhaarFragment.a.dismiss();
        C0535I5.m(releasePanAadhaarFragment.getActivity(), false, releasePanAadhaarFragment.getString(R.string.unble_to_request_try_sometime), releasePanAadhaarFragment.getString(R.string.error), releasePanAadhaarFragment.getString(R.string.OK), new C1204jt()).show();
    }
}
