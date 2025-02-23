package defpackage;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.fragment.CancelTicketDetailsFragment;
import cris.org.in.ima.fragment.TicketStatusFragment;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.RecentTransactionsDTO;
import java.util.ArrayList;
import rx.Subscriber;

/* renamed from: Z3  reason: default package */
/* compiled from: CancelTicketDetailsFragment */
public final class Z3 extends Subscriber<C0707Ue> {
    public final /* synthetic */ CancelTicketDetailsFragment a;

    public Z3(CancelTicketDetailsFragment cancelTicketDetailsFragment) {
        this.a = cancelTicketDetailsFragment;
    }

    public final void onCompleted() {
        C0535I5.f3615a = null;
        ArrayList<RecentTransactionsDTO> arrayList = C0535I5.f3642f;
        if (arrayList != null) {
            arrayList.clear();
        }
        ArrayList<RecentTransactionsDTO> arrayList2 = C0535I5.f3644g;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        this.a.f4478a.dismiss();
        int i = CancelTicketDetailsFragment.f;
    }

    public final void onError(Throwable th) {
        int i = CancelTicketDetailsFragment.f;
        xx.S(th, true, th);
    }

    public final void onNext(Object obj) {
        C0707Ue ue = (C0707Ue) obj;
        int i = CancelTicketDetailsFragment.f;
        CancelTicketDetailsFragment cancelTicketDetailsFragment = this.a;
        if (ue == null || ue.getErrorMsg() != null) {
            if (ue != null) {
                ue.getErrorMsg();
                C0535I5.m(cancelTicketDetailsFragment.getActivity(), false, ue.getErrorMsg().split("- ")[0], cancelTicketDetailsFragment.getString(R.string.error), cancelTicketDetailsFragment.getString(R.string.OK), new C0744X3()).show();
                return;
            }
            cancelTicketDetailsFragment.f4478a.dismiss();
            C0535I5.m(cancelTicketDetailsFragment.getActivity(), false, cancelTicketDetailsFragment.getString(R.string.Unable_perform_transaction), cancelTicketDetailsFragment.getString(R.string.error), cancelTicketDetailsFragment.getString(R.string.OK), new C0752Y3()).show();
        } else if (ue.getBookingResponseList().get(0).getCancellationDetails().get(0).isSuccess()) {
            C0535I5.f3615a = null;
            ArrayList<RecentTransactionsDTO> arrayList = C0535I5.f3642f;
            if (arrayList != null) {
                arrayList.clear();
            }
            ArrayList<RecentTransactionsDTO> arrayList2 = C0535I5.f3644g;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            cancelTicketDetailsFragment.f4487c = ue.getBookingResponseList().get(0);
            TicketStatusFragment ticketStatusFragment = new TicketStatusFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("cantkt", cancelTicketDetailsFragment.f4487c);
            bundle.putSerializable("dmrcFromStn", cancelTicketDetailsFragment.f4488c);
            bundle.putSerializable("dmrcToStn", cancelTicketDetailsFragment.f4489d);
            bundle.putSerializable("arrDepDate", cancelTicketDetailsFragment.f4483a);
            bundle.putSerializable("pnrNumber", cancelTicketDetailsFragment.b.getPnrNumber());
            bundle.putInt("dmrcPsgn", cancelTicketDetailsFragment.d);
            ticketStatusFragment.setArguments(bundle);
            FragmentActivity activity = cancelTicketDetailsFragment.getActivity();
            String string = cancelTicketDetailsFragment.getString(R.string.Ticket_Status);
            Boolean bool = Boolean.TRUE;
            HomeActivity.n(activity, ticketStatusFragment, string, bool, bool);
        } else {
            FragmentActivity activity2 = cancelTicketDetailsFragment.getActivity();
            C0535I5.m(activity2, false, ue.getBookingResponseList().get(0).getCancellationDetails().get(0).getMessage().split("-")[0], cancelTicketDetailsFragment.getString(R.string.error), cancelTicketDetailsFragment.getString(R.string.OK), new C0731W3()).show();
        }
    }
}
