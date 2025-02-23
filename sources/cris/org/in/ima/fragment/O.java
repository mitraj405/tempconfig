package cris.org.in.ima.fragment;

import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import cris.org.in.ima.utils.TicketHistoryUtil;
import cris.org.in.ima.view_holder.FailedItemHolder;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import java.util.ArrayList;
import rx.Subscriber;

/* compiled from: FailedTxnHistoryFragment */
public final class O extends Subscriber<C0707Ue> {
    public final /* synthetic */ FailedTxnHistoryFragment a;

    public O(FailedTxnHistoryFragment failedTxnHistoryFragment) {
        this.a = failedTxnHistoryFragment;
    }

    public final void onCompleted() {
        FragmentActivity fragmentActivity = FailedTxnHistoryFragment.a;
        this.a.f4628a.dismiss();
    }

    public final void onError(Throwable th) {
        FragmentActivity fragmentActivity = FailedTxnHistoryFragment.a;
        th.getClass();
        th.getMessage();
        this.a.f4628a.dismiss();
        Lt.a(true, th);
    }

    public final void onNext(Object obj) {
        C0707Ue ue = (C0707Ue) obj;
        FailedTxnHistoryFragment failedTxnHistoryFragment = this.a;
        if (ue != null) {
            try {
                if (ue.getErrorMsg() == null || ue.getErrorMsg().equalsIgnoreCase("no transaction found.")) {
                    TicketHistoryUtil.a(ue.getBookingResponseList(), TicketHistoryUtil.SortFor.FAILED_TICKETS);
                    ArrayList<BookingResponseDTO> allJourney = TicketHistoryUtil.d.getAllJourney();
                    failedTxnHistoryFragment.f4632a = allJourney;
                    if (allJourney.isEmpty()) {
                        C0535I5.t0(failedTxnHistoryFragment.getActivity(), failedTxnHistoryFragment.getString(R.string.No_Failed_Transactions));
                    }
                    FailedItemHolder failedItemHolder = new FailedItemHolder(failedTxnHistoryFragment.f4630a, failedTxnHistoryFragment.f4632a);
                    failedTxnHistoryFragment.f4631a = failedItemHolder;
                    failedTxnHistoryFragment.bookingItems.setAdapter(failedItemHolder);
                    failedTxnHistoryFragment.bookingItems.setLayoutManager(new LinearLayoutManager(failedTxnHistoryFragment.getContext()));
                    failedTxnHistoryFragment.h(2);
                    return;
                }
                C0535I5.m(failedTxnHistoryFragment.getActivity(), false, ue.getErrorMsg(), failedTxnHistoryFragment.getString(R.string.error), failedTxnHistoryFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            } catch (Exception e) {
                FragmentActivity fragmentActivity = FailedTxnHistoryFragment.a;
                e.getMessage();
                failedTxnHistoryFragment.f4628a.dismiss();
                C0535I5.t0(failedTxnHistoryFragment.getActivity(), failedTxnHistoryFragment.getResources().getString(R.string.unable_process_message));
            }
        } else {
            FragmentActivity fragmentActivity2 = FailedTxnHistoryFragment.a;
            failedTxnHistoryFragment.f4628a.dismiss();
            C0535I5.m(failedTxnHistoryFragment.getActivity(), false, failedTxnHistoryFragment.getString(R.string.unable_process), failedTxnHistoryFragment.getString(R.string.error), failedTxnHistoryFragment.getString(R.string.OK), new C0635Pb()).show();
        }
    }
}
