package cris.org.in.ima.fragment;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.utils.TicketHistoryUtil;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.StatusDTO;
import rx.Subscriber;

/* renamed from: cris.org.in.ima.fragment.q0  reason: case insensitive filesystem */
/* compiled from: TDRTicketDetailsFragment */
public final class C1044q0 extends Subscriber<StatusDTO> {
    public final /* synthetic */ TDRTicketDetailsFragment a;

    public C1044q0(TDRTicketDetailsFragment tDRTicketDetailsFragment) {
        this.a = tDRTicketDetailsFragment;
    }

    public final void onCompleted() {
        int i = TDRTicketDetailsFragment.e;
    }

    public final void onError(Throwable th) {
        int i = TDRTicketDetailsFragment.e;
        th.getClass();
        th.getMessage();
        TDRTicketDetailsFragment tDRTicketDetailsFragment = this.a;
        tDRTicketDetailsFragment.a.dismiss();
        HomeActivity.B(tDRTicketDetailsFragment.getActivity());
        HomeActivity.n((AppCompatActivity) tDRTicketDetailsFragment.getActivity(), new TDRTicketFragment(), C1218kf.TDR_TICKET.a(), Boolean.TRUE, Boolean.FALSE);
        Lt.a(true, th);
    }

    public final void onNext(Object obj) {
        StatusDTO statusDTO = (StatusDTO) obj;
        int i = TDRTicketDetailsFragment.e;
        TDRTicketDetailsFragment tDRTicketDetailsFragment = this.a;
        if (statusDTO == null) {
            tDRTicketDetailsFragment.a.dismiss();
            C0535I5.m(tDRTicketDetailsFragment.getActivity(), false, tDRTicketDetailsFragment.getString(R.string.Unable_process_request), tDRTicketDetailsFragment.getString(R.string.error), tDRTicketDetailsFragment.getString(R.string.OK), new C1184iz(this)).show();
        } else if (statusDTO.getError() == null) {
            TicketHistoryUtil.c();
            tDRTicketDetailsFragment.a.dismiss();
            tDRTicketDetailsFragment.filledLl.setVisibility(0);
            TextView textView = tDRTicketDetailsFragment.fileTdrSuccessMsg;
            textView.setText(tDRTicketDetailsFragment.getString(R.string.TDR_No) + statusDTO.getStatus());
        } else {
            tDRTicketDetailsFragment.a.dismiss();
            C0535I5.m(tDRTicketDetailsFragment.getActivity(), false, statusDTO.getError(), tDRTicketDetailsFragment.getString(R.string.error), tDRTicketDetailsFragment.getString(R.string.OK), new C1165hz(this)).show();
        }
    }
}
