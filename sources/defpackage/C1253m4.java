package defpackage;

import android.os.Bundle;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.fragment.C;
import cris.org.in.ima.fragment.CancelTicketDetailsFragment;
import cris.org.in.ima.listener.CancelTicketListener;
import cris.prs.webservices.dto.BookingResponseDTO;

/* renamed from: m4  reason: default package and case insensitive filesystem */
/* compiled from: CancelTktFragment */
public final class C1253m4 implements CancelTicketListener {
    public final /* synthetic */ C a;

    public C1253m4(C c) {
        this.a = c;
    }

    public final void a(BookingResponseDTO bookingResponseDTO) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("tkt", bookingResponseDTO);
        CancelTicketDetailsFragment cancelTicketDetailsFragment = new CancelTicketDetailsFragment();
        cancelTicketDetailsFragment.setArguments(bundle);
        HomeActivity.n(this.a.a.f4498a, cancelTicketDetailsFragment, xx.d(2), Boolean.TRUE, Boolean.FALSE);
    }
}
