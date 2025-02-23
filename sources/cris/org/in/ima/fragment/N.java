package cris.org.in.ima.fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import cris.org.in.ima.view_holder.EwalletDepositHistoryViewHolder;
import cris.org.in.prs.ima.R;
import rx.Subscriber;

/* compiled from: EwalletDepositHistoryFragment */
public final class N extends Subscriber<C1109fb> {
    public final /* synthetic */ EwalletDepositHistoryFragment a;

    public N(EwalletDepositHistoryFragment ewalletDepositHistoryFragment) {
        this.a = ewalletDepositHistoryFragment;
    }

    public final void onCompleted() {
        int i = EwalletDepositHistoryFragment.c;
        this.a.a.dismiss();
    }

    public final void onError(Throwable th) {
        int i = EwalletDepositHistoryFragment.c;
        th.getMessage();
        this.a.a.dismiss();
        Lt.a(false, th);
    }

    public final void onNext(Object obj) {
        C1109fb fbVar = (C1109fb) obj;
        EwalletDepositHistoryFragment ewalletDepositHistoryFragment = this.a;
        if (fbVar != null) {
            int i = EwalletDepositHistoryFragment.c;
            ewalletDepositHistoryFragment.getClass();
            if (fbVar.getDepositList() != null) {
                ewalletDepositHistoryFragment.txnList.setAdapter(new EwalletDepositHistoryViewHolder(ewalletDepositHistoryFragment.f4606a, fbVar.getDepositList()));
                ewalletDepositHistoryFragment.txnList.setLayoutManager(new LinearLayoutManager(ewalletDepositHistoryFragment.f4606a));
                ewalletDepositHistoryFragment.emptyList.setVisibility(8);
            } else {
                ewalletDepositHistoryFragment.emptyList.setVisibility(0);
                C0535I5.g(ewalletDepositHistoryFragment.getActivity(), ewalletDepositHistoryFragment.getString(R.string.ew_empty_dep_list), ewalletDepositHistoryFragment.emptyList);
            }
            ewalletDepositHistoryFragment.a.dismiss();
            return;
        }
        int i2 = EwalletDepositHistoryFragment.c;
        ewalletDepositHistoryFragment.a.dismiss();
        C0535I5.m(ewalletDepositHistoryFragment.getActivity(), false, ewalletDepositHistoryFragment.getString(R.string.unable_to_perform_transaction), ewalletDepositHistoryFragment.getString(R.string.error), ewalletDepositHistoryFragment.getString(R.string.OK), new C1132gb()).show();
    }
}
