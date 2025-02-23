package cris.org.in.ima.fragment;

import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import cris.org.in.ima.utils.TicketHistoryUtil;
import cris.org.in.ima.view_holder.TicketViewHolder;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import java.util.ArrayList;
import rx.Subscriber;

/* renamed from: cris.org.in.ima.fragment.y  reason: case insensitive filesystem */
/* compiled from: BookingHistoryFragment */
public final class C1053y extends Subscriber<C0707Ue> {
    public final /* synthetic */ BookingHistoryFragment a;

    public C1053y(BookingHistoryFragment bookingHistoryFragment) {
        this.a = bookingHistoryFragment;
    }

    public final void onCompleted() {
        FragmentActivity fragmentActivity = BookingHistoryFragment.a;
        this.a.h();
    }

    public final void onError(Throwable th) {
        FragmentActivity fragmentActivity = BookingHistoryFragment.a;
        th.getClass();
        th.getMessage();
        this.a.h();
        Lt.a(true, th);
    }

    public final void onNext(Object obj) {
        C0707Ue ue = (C0707Ue) obj;
        BookingHistoryFragment bookingHistoryFragment = this.a;
        if (ue != null) {
            try {
                if (ue.getErrorMsg() == null || ue.getErrorMsg().equalsIgnoreCase("no transaction found.")) {
                    TicketHistoryUtil.b = ue;
                    TicketHistoryUtil.a(ue.getBookingResponseList(), TicketHistoryUtil.SortFor.BOOKINGS);
                    ArrayList<BookingResponseDTO> upcomingJourney = TicketHistoryUtil.f5369a.getUpcomingJourney();
                    bookingHistoryFragment.f4473a = upcomingJourney;
                    if (upcomingJourney.isEmpty()) {
                        C0535I5.t0(bookingHistoryFragment.getActivity(), bookingHistoryFragment.getString(R.string.no_booking));
                    }
                    TicketViewHolder ticketViewHolder = new TicketViewHolder(bookingHistoryFragment.f4470a, bookingHistoryFragment.f4473a, bookingHistoryFragment.f4471a);
                    bookingHistoryFragment.f4472a = ticketViewHolder;
                    bookingHistoryFragment.bookingItems.setAdapter(ticketViewHolder);
                    bookingHistoryFragment.bookingItems.setLayoutManager(new LinearLayoutManager(bookingHistoryFragment.getContext()));
                    bookingHistoryFragment.lastUpdatedTime.setText(C0535I5.X(ue.getTimeStamp()));
                    bookingHistoryFragment.k(1);
                    return;
                }
                C0535I5.m(bookingHistoryFragment.getActivity(), false, ue.getErrorMsg(), bookingHistoryFragment.getString(R.string.error), bookingHistoryFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            } catch (Exception e) {
                FragmentActivity fragmentActivity = BookingHistoryFragment.a;
                e.getMessage();
                bookingHistoryFragment.h();
                C0535I5.t0(bookingHistoryFragment.getActivity(), bookingHistoryFragment.getResources().getString(R.string.unable_process_message));
            }
        } else {
            FragmentActivity fragmentActivity2 = BookingHistoryFragment.a;
            bookingHistoryFragment.h();
            C0535I5.m(bookingHistoryFragment.getActivity(), false, bookingHistoryFragment.getString(R.string.Unable_perform_transaction), bookingHistoryFragment.getString(R.string.error), bookingHistoryFragment.getString(R.string.OK), new C1125g3()).show();
        }
    }
}
