package defpackage;

import cris.org.in.ima.fragment.EwalletStatementFragment;
import cris.org.in.prs.ima.R;
import java.util.ArrayList;
import rx.Subscriber;

/* renamed from: qb  reason: default package and case insensitive filesystem */
/* compiled from: EwalletStatementFragment */
public final class C1347qb extends Subscriber<C1279nb> {
    public final /* synthetic */ EwalletStatementFragment a;

    public C1347qb(EwalletStatementFragment ewalletStatementFragment) {
        this.a = ewalletStatementFragment;
    }

    public final void onCompleted() {
        int i = EwalletStatementFragment.c;
        this.a.a.dismiss();
    }

    public final void onError(Throwable th) {
        int i = EwalletStatementFragment.c;
        th.getMessage();
        this.a.a.dismiss();
        Lt.a(true, th);
    }

    public final void onNext(Object obj) {
        C1279nb nbVar = (C1279nb) obj;
        EwalletStatementFragment ewalletStatementFragment = this.a;
        if (nbVar != null) {
            ewalletStatementFragment.a.dismiss();
            C1450w1.f7006a.f3574a = nbVar.getAccountDetail().geteWalletClosingBalance();
            C1066db accountDetail = nbVar.getAccountDetail();
            C1279nb nbVar2 = ewalletStatementFragment.f4621a;
            if (accountDetail != null) {
                nbVar2.setAccountDetail(nbVar.getAccountDetail());
                ewalletStatementFragment.f4623b.setAccountDetail(nbVar.getAccountDetail());
            }
            if (nbVar.getTransactionList() != null && !nbVar.getTransactionList().isEmpty()) {
                nbVar2.setTransactionList((ArrayList) nbVar.getTransactionList().clone());
            }
            ewalletStatementFragment.f(nbVar2);
            return;
        }
        int i = EwalletStatementFragment.c;
        ewalletStatementFragment.getString(R.string.as_unable_perform_transaction);
        ewalletStatementFragment.a.dismiss();
        C0535I5.m(ewalletStatementFragment.getActivity(), false, ewalletStatementFragment.getString(R.string.as_unable_perform_transaction), ewalletStatementFragment.getString(R.string.error), ewalletStatementFragment.getString(R.string.OK), new C1325pb()).show();
    }
}
