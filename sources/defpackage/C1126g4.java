package defpackage;

import android.os.Bundle;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.fragment.B;
import cris.org.in.ima.fragment.CancelTicketDetailsFragment;
import cris.org.in.ima.listener.CancelTicketListener;
import cris.prs.webservices.dto.BookingResponseDTO;

/* renamed from: g4  reason: default package and case insensitive filesystem */
/* compiled from: CancelTicketHistoryFragment */
public final class C1126g4 implements CancelTicketListener {
    public final /* synthetic */ B a;

    public C1126g4(B b) {
        this.a = b;
    }

    public final void a(BookingResponseDTO bookingResponseDTO) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("tkt", bookingResponseDTO);
        CancelTicketDetailsFragment cancelTicketDetailsFragment = new CancelTicketDetailsFragment();
        cancelTicketDetailsFragment.setArguments(bundle);
        HomeActivity.n(this.a.a.f4492a, cancelTicketDetailsFragment, xx.d(2), Boolean.TRUE, Boolean.FALSE);
    }
}
