package defpackage;

import android.os.Bundle;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.fragment.CancelTicketDetailsFragment;
import cris.org.in.ima.fragment.CancelTicketHistoryFragment;
import cris.org.in.ima.listener.CancelTicketListener;
import cris.prs.webservices.dto.BookingResponseDTO;

/* renamed from: f4  reason: default package and case insensitive filesystem */
/* compiled from: CancelTicketHistoryFragment */
public final class C1102f4 implements CancelTicketListener {
    public final /* synthetic */ CancelTicketHistoryFragment a;

    public C1102f4(CancelTicketHistoryFragment cancelTicketHistoryFragment) {
        this.a = cancelTicketHistoryFragment;
    }

    public final void a(BookingResponseDTO bookingResponseDTO) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("tkt", bookingResponseDTO);
        CancelTicketDetailsFragment cancelTicketDetailsFragment = new CancelTicketDetailsFragment();
        cancelTicketDetailsFragment.setArguments(bundle);
        HomeActivity.n(this.a.getActivity(), cancelTicketDetailsFragment, xx.d(2), Boolean.TRUE, Boolean.FALSE);
    }
}
