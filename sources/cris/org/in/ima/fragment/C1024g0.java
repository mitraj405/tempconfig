package cris.org.in.ima.fragment;

import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import cris.org.in.ima.utils.TicketHistoryUtil;
import cris.org.in.ima.view_holder.RefundItemHolder;
import cris.org.in.prs.ima.R;
import defpackage.C0613Ns;
import java.util.ArrayList;
import rx.Subscriber;

/* renamed from: cris.org.in.ima.fragment.g0  reason: case insensitive filesystem */
/* compiled from: RefundTxnHistoryFragment */
public final class C1024g0 extends Subscriber<C0613Ns> {
    public final /* synthetic */ RefundTxnHistoryFragment a;

    public C1024g0(RefundTxnHistoryFragment refundTxnHistoryFragment) {
        this.a = refundTxnHistoryFragment;
    }

    public final void onCompleted() {
        FragmentActivity fragmentActivity = RefundTxnHistoryFragment.a;
        this.a.f5062a.dismiss();
    }

    public final void onError(Throwable th) {
        FragmentActivity fragmentActivity = RefundTxnHistoryFragment.a;
        th.getClass();
        th.getMessage();
        this.a.f5062a.dismiss();
        Lt.a(true, th);
    }

    public final void onNext(Object obj) {
        C0613Ns ns = (C0613Ns) obj;
        RefundTxnHistoryFragment refundTxnHistoryFragment = this.a;
        if (ns != null) {
            try {
                if (ns.getErrorMsg() != null && !ns.getErrorMsg().equalsIgnoreCase(refundTxnHistoryFragment.getString(R.string.no_transaction_found))) {
                    C0535I5.m(refundTxnHistoryFragment.getActivity(), false, ns.getErrorMsg(), refundTxnHistoryFragment.getString(R.string.info), refundTxnHistoryFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                }
                TicketHistoryUtil.b(ns.getRefundDetail());
                ArrayList<C0613Ns.a> allJourney = TicketHistoryUtil.a.getAllJourney();
                refundTxnHistoryFragment.f5066a = allJourney;
                if (allJourney.isEmpty()) {
                    C0535I5.t0(refundTxnHistoryFragment.getActivity(), refundTxnHistoryFragment.getString(R.string.No_Refund_Transactions));
                }
                RefundItemHolder refundItemHolder = new RefundItemHolder(refundTxnHistoryFragment.f5066a, refundTxnHistoryFragment.f5064a);
                refundTxnHistoryFragment.f5065a = refundItemHolder;
                refundTxnHistoryFragment.bookingItems.setAdapter(refundItemHolder);
                refundTxnHistoryFragment.bookingItems.setLayoutManager(new LinearLayoutManager(refundTxnHistoryFragment.getContext()));
            } catch (Exception e) {
                FragmentActivity fragmentActivity = RefundTxnHistoryFragment.a;
                e.getMessage();
                refundTxnHistoryFragment.f5062a.dismiss();
                C0535I5.t0(refundTxnHistoryFragment.getActivity(), refundTxnHistoryFragment.getResources().getString(R.string.unable_process_message));
            }
        } else {
            FragmentActivity fragmentActivity2 = RefundTxnHistoryFragment.a;
            refundTxnHistoryFragment.f5062a.dismiss();
            C0535I5.m(refundTxnHistoryFragment.getActivity(), false, refundTxnHistoryFragment.getString(R.string.Unable_perform_transaction), refundTxnHistoryFragment.getString(R.string.information), refundTxnHistoryFragment.getString(R.string.OK), new Ss()).show();
        }
    }
}
