package cris.org.in.ima.fragment;

import android.content.DialogInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import cris.org.in.ima.utils.TicketHistoryUtil;
import cris.org.in.ima.view_holder.TicketViewHolder;
import cris.org.in.prs.ima.R;
import rx.Subscriber;

/* compiled from: MyBookingFragment */
public final class X extends Subscriber<C0707Ue> {
    public final /* synthetic */ MyBookingFragment a;

    public X(MyBookingFragment myBookingFragment) {
        this.a = myBookingFragment;
    }

    public final void onCompleted() {
        int i = MyBookingFragment.c;
        this.a.a.dismiss();
    }

    public final void onError(Throwable th) {
        int i = MyBookingFragment.c;
        th.getClass();
        th.getMessage();
        this.a.a.dismiss();
        Lt.a(true, th);
    }

    public final void onNext(Object obj) {
        C0707Ue ue = (C0707Ue) obj;
        MyBookingFragment myBookingFragment = this.a;
        if (ue != null) {
            try {
                if (ue.getErrorMsg() != null) {
                    C0535I5.m(myBookingFragment.getActivity(), false, ue.getErrorMsg(), myBookingFragment.getString(R.string.error), myBookingFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                    return;
                }
                TicketHistoryUtil.a(ue.getBookingResponseList(), myBookingFragment.f4833a);
                if (myBookingFragment.f4833a.equals(TicketHistoryUtil.SortFor.BOOKINGS)) {
                    myBookingFragment.f4835a = TicketHistoryUtil.f5369a.getAllJourney();
                } else if (myBookingFragment.f4833a.equals(TicketHistoryUtil.SortFor.CANCELLATION)) {
                    myBookingFragment.f4835a = TicketHistoryUtil.f5372b.getAllJourney();
                } else if (myBookingFragment.f4833a.equals(TicketHistoryUtil.SortFor.EWALLET_TXN)) {
                    myBookingFragment.f4835a = TicketHistoryUtil.c.getAllJourney();
                }
                TicketViewHolder ticketViewHolder = new TicketViewHolder(myBookingFragment.f4831a, myBookingFragment.f4835a, myBookingFragment.f4832a);
                myBookingFragment.f4834a = ticketViewHolder;
                myBookingFragment.bookingItems.setAdapter(ticketViewHolder);
                myBookingFragment.bookingItems.setLayoutManager(new LinearLayoutManager(myBookingFragment.getContext()));
                myBookingFragment.lastUpdatedTime.setText(C0535I5.X(ue.getTimeStamp()));
            } catch (Exception e) {
                int i = MyBookingFragment.c;
                e.getMessage();
                myBookingFragment.a.dismiss();
                C0535I5.t0(myBookingFragment.getActivity(), myBookingFragment.getResources().getString(R.string.unable_process_message));
            }
        } else {
            int i2 = MyBookingFragment.c;
            myBookingFragment.a.dismiss();
            C0535I5.m(myBookingFragment.getActivity(), false, myBookingFragment.getString(R.string.Unable_perform_transaction), myBookingFragment.getString(R.string.error), myBookingFragment.getString(R.string.OK), new C1284nm()).show();
        }
    }
}
