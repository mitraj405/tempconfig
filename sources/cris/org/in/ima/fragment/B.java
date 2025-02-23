package cris.org.in.ima.fragment;

import android.content.DialogInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import cris.org.in.ima.adaptors.CancelTicketItemAdapter;
import cris.org.in.ima.utils.TicketHistoryUtil;
import cris.org.in.prs.ima.R;
import rx.Subscriber;

/* compiled from: CancelTicketHistoryFragment */
public final class B extends Subscriber<C0707Ue> {
    public final /* synthetic */ CancelTicketHistoryFragment a;

    public B(CancelTicketHistoryFragment cancelTicketHistoryFragment) {
        this.a = cancelTicketHistoryFragment;
    }

    public final void onCompleted() {
        int i = CancelTicketHistoryFragment.c;
    }

    public final void onError(Throwable th) {
        this.a.a.dismiss();
        int i = CancelTicketHistoryFragment.c;
        xx.S(th, true, th);
    }

    public final void onNext(Object obj) {
        C0707Ue ue = (C0707Ue) obj;
        CancelTicketHistoryFragment cancelTicketHistoryFragment = this.a;
        if (ue != null) {
            try {
                if (ue.getErrorMsg() != null) {
                    C0535I5.m(cancelTicketHistoryFragment.f4492a, true, ue.getErrorMsg().split("-")[0], cancelTicketHistoryFragment.getString(R.string.info), cancelTicketHistoryFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                }
                TicketHistoryUtil.a(ue.getBookingResponseList(), TicketHistoryUtil.SortFor.CANCELLATION_HISTORY);
                cancelTicketHistoryFragment.f4495a = TicketHistoryUtil.e.getAllJourney();
                cancelTicketHistoryFragment.f4494a = new CancelTicketItemAdapter(cancelTicketHistoryFragment.f4492a, new C1126g4(this), cancelTicketHistoryFragment.f4495a);
                cancelTicketHistoryFragment.bookingItems.setLayoutManager(new LinearLayoutManager(cancelTicketHistoryFragment.f4493a));
                cancelTicketHistoryFragment.bookingItems.setAdapter(cancelTicketHistoryFragment.f4494a);
            } catch (Exception e) {
                int i = CancelTicketHistoryFragment.c;
                e.getMessage();
            } catch (Throwable th) {
                cancelTicketHistoryFragment.a.dismiss();
                throw th;
            }
            cancelTicketHistoryFragment.a.dismiss();
            return;
        }
        cancelTicketHistoryFragment.a.dismiss();
        C0535I5.m(cancelTicketHistoryFragment.getActivity(), false, "Unable to process your request. Please try after sometime", cancelTicketHistoryFragment.getString(R.string.error), cancelTicketHistoryFragment.getString(R.string.OK), new C1147h4()).show();
    }
}
