package cris.org.in.ima.fragment;

import android.content.DialogInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import cris.org.in.ima.utils.TicketHistoryUtil;
import cris.org.in.ima.view_holder.CancellationItemHolder;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import java.util.ArrayList;
import rx.Subscriber;

/* compiled from: CancellationHistoryFragment */
public final class D extends Subscriber<C0707Ue> {
    public final /* synthetic */ CancellationHistoryFragment a;

    public D(CancellationHistoryFragment cancellationHistoryFragment) {
        this.a = cancellationHistoryFragment;
    }

    public final void onCompleted() {
        int i = CancellationHistoryFragment.c;
        this.a.a.dismiss();
    }

    public final void onError(Throwable th) {
        int i = CancellationHistoryFragment.c;
        th.getClass();
        th.getMessage();
        this.a.a.dismiss();
        Lt.a(true, th);
    }

    public final void onNext(Object obj) {
        C0707Ue ue = (C0707Ue) obj;
        CancellationHistoryFragment cancellationHistoryFragment = this.a;
        if (ue != null) {
            try {
                if (ue.getErrorMsg() == null || ue.getErrorMsg().equalsIgnoreCase("no transaction found.")) {
                    TicketHistoryUtil.a(ue.getBookingResponseList(), TicketHistoryUtil.SortFor.CANCELLATION);
                    ArrayList<BookingResponseDTO> allJourney = TicketHistoryUtil.f5372b.getAllJourney();
                    cancellationHistoryFragment.f4507a = allJourney;
                    if (allJourney.isEmpty()) {
                        C0535I5.t0(cancellationHistoryFragment.getActivity(), cancellationHistoryFragment.getString(R.string.No_Cancelled_Tickets));
                    }
                    CancellationItemHolder cancellationItemHolder = new CancellationItemHolder(cancellationHistoryFragment.f4505a, cancellationHistoryFragment.f4507a);
                    cancellationHistoryFragment.f4506a = cancellationItemHolder;
                    cancellationHistoryFragment.bookingItems.setAdapter(cancellationItemHolder);
                    cancellationHistoryFragment.bookingItems.setLayoutManager(new LinearLayoutManager(cancellationHistoryFragment.getContext()));
                    return;
                }
                C0535I5.m(cancellationHistoryFragment.getActivity(), false, ue.getErrorMsg(), cancellationHistoryFragment.getString(R.string.information), cancellationHistoryFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            } catch (Exception e) {
                int i = CancellationHistoryFragment.c;
                e.getMessage();
                cancellationHistoryFragment.a.dismiss();
                C0535I5.t0(cancellationHistoryFragment.getActivity(), cancellationHistoryFragment.getResources().getString(R.string.unable_process_message));
            }
        } else {
            int i2 = CancellationHistoryFragment.c;
            cancellationHistoryFragment.a.dismiss();
            C0535I5.m(cancellationHistoryFragment.getActivity(), false, cancellationHistoryFragment.getString(R.string.unable_process), cancellationHistoryFragment.getString(R.string.error), cancellationHistoryFragment.getString(R.string.OK), new C1494y4()).show();
        }
    }
}
