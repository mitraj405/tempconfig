package cris.org.in.ima.fragment;

import android.content.DialogInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import cris.org.in.ima.adaptors.CancelTicketItemAdapter;
import cris.org.in.ima.utils.TicketHistoryUtil;
import cris.org.in.prs.ima.R;
import rx.Subscriber;

/* compiled from: CancelTktFragment */
public final class C extends Subscriber<C0707Ue> {
    public final /* synthetic */ CancelTktFragment a;

    public C(CancelTktFragment cancelTktFragment) {
        this.a = cancelTktFragment;
    }

    public final void onCompleted() {
        int i = CancelTktFragment.c;
    }

    public final void onError(Throwable th) {
        this.a.a.dismiss();
        int i = CancelTktFragment.c;
        xx.S(th, true, th);
    }

    public final void onNext(Object obj) {
        C0707Ue ue = (C0707Ue) obj;
        CancelTktFragment cancelTktFragment = this.a;
        if (ue != null) {
            try {
                if (ue.getErrorMsg() != null) {
                    C0535I5.m(cancelTktFragment.f4498a, true, ue.getErrorMsg().split("-")[0], cancelTktFragment.getString(R.string.info), cancelTktFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                }
                TicketHistoryUtil.a(ue.getBookingResponseList(), TicketHistoryUtil.SortFor.CANCELLATION);
                cancelTktFragment.f4501a = TicketHistoryUtil.f5372b.getAllJourney();
                cancelTktFragment.f4500a = new CancelTicketItemAdapter(cancelTktFragment.f4498a, new C1253m4(this), cancelTktFragment.f4501a);
                cancelTktFragment.bookingItems.setLayoutManager(new LinearLayoutManager(cancelTktFragment.f4499a));
                cancelTktFragment.bookingItems.setAdapter(cancelTktFragment.f4500a);
            } catch (Exception e) {
                int i = CancelTktFragment.c;
                e.getMessage();
            } catch (Throwable th) {
                cancelTktFragment.a.dismiss();
                throw th;
            }
            cancelTktFragment.a.dismiss();
            return;
        }
        cancelTktFragment.a.dismiss();
        C0535I5.m(cancelTktFragment.getActivity(), false, cancelTktFragment.getString(R.string.unble_to_request_try_sometime), cancelTktFragment.getString(R.string.error), cancelTktFragment.getString(R.string.OK), new C1273n4()).show();
    }
}
