package defpackage;

import cris.org.in.ima.fragment.EwalletRefundStatusFragment;
import cris.org.in.prs.ima.R;
import java.util.ArrayList;
import rx.Subscriber;

/* renamed from: ib  reason: default package and case insensitive filesystem */
/* compiled from: EwalletRefundStatusFragment */
public final class C1175ib extends Subscriber<S9> {
    public final /* synthetic */ EwalletRefundStatusFragment a;

    public C1175ib(EwalletRefundStatusFragment ewalletRefundStatusFragment) {
        this.a = ewalletRefundStatusFragment;
    }

    public final void onCompleted() {
        int i = EwalletRefundStatusFragment.c;
        this.a.f4607a.dismiss();
    }

    public final void onError(Throwable th) {
        int i = EwalletRefundStatusFragment.c;
        th.getMessage();
        this.a.f4607a.dismiss();
        Lt.a(false, th);
    }

    public final void onNext(Object obj) {
        S9 s9 = (S9) obj;
        EwalletRefundStatusFragment ewalletRefundStatusFragment = this.a;
        if (s9 != null) {
            if (s9.getRefundList() != null && !s9.getRefundList().isEmpty()) {
                ewalletRefundStatusFragment.a.setRefundList((ArrayList) s9.getRefundList().clone());
            }
            ewalletRefundStatusFragment.f(ewalletRefundStatusFragment.a);
            return;
        }
        int i = EwalletRefundStatusFragment.c;
        ewalletRefundStatusFragment.getString(R.string.rs_unable_perform_transaction);
        ewalletRefundStatusFragment.f4607a.dismiss();
        C0535I5.m(ewalletRefundStatusFragment.getActivity(), false, ewalletRefundStatusFragment.getString(R.string.rs_unable_perform_transaction), ewalletRefundStatusFragment.getString(R.string.error), ewalletRefundStatusFragment.getString(R.string.OK), new C1154hb()).show();
    }
}
