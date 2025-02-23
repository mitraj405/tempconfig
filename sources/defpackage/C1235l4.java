package defpackage;

import android.os.Bundle;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.fragment.CancelTicketDetailsFragment;
import cris.org.in.ima.fragment.CancelTktFragment;
import cris.org.in.ima.listener.CancelTicketListener;
import cris.prs.webservices.dto.BookingResponseDTO;

/* renamed from: l4  reason: default package and case insensitive filesystem */
/* compiled from: CancelTktFragment */
public final class C1235l4 implements CancelTicketListener {
    public final /* synthetic */ CancelTktFragment a;

    public C1235l4(CancelTktFragment cancelTktFragment) {
        this.a = cancelTktFragment;
    }

    public final void a(BookingResponseDTO bookingResponseDTO) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("tkt", bookingResponseDTO);
        CancelTicketDetailsFragment cancelTicketDetailsFragment = new CancelTicketDetailsFragment();
        cancelTicketDetailsFragment.setArguments(bundle);
        HomeActivity.n(this.a.getActivity(), cancelTicketDetailsFragment, xx.d(2), Boolean.TRUE, Boolean.FALSE);
    }
}
