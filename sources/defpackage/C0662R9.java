package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.fragment.ERSFragment;
import cris.org.in.ima.fragment.MetroTicketDetailsFragment;
import cris.org.in.ima.utils.TicketHistoryUtil;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import rx.Subscriber;

/* renamed from: R9  reason: default package and case insensitive filesystem */
/* compiled from: ERSFragment */
public final class C0662R9 extends Subscriber<BookingResponseDTO> {
    public final /* synthetic */ Context a;

    public C0662R9(Context context) {
        this.a = context;
    }

    public final void onError(Throwable th) {
        int i = ERSFragment.c;
        th.getMessage();
    }

    public final void onNext(Object obj) {
        BookingResponseDTO bookingResponseDTO = (BookingResponseDTO) obj;
        try {
            String errorMessage = bookingResponseDTO.getErrorMessage();
            Context context = this.a;
            if (errorMessage != null) {
                if (bookingResponseDTO.getErrorMessage().length() > 0) {
                    C0535I5.m(this.a, false, bookingResponseDTO.getErrorMessage(), context.getString(R.string.error), context.getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                    return;
                }
            }
            TicketHistoryUtil.c();
            Bundle bundle = new Bundle();
            MetroTicketDetailsFragment metroTicketDetailsFragment = new MetroTicketDetailsFragment();
            bundle.putSerializable("FinalBookingSummary", bookingResponseDTO);
            metroTicketDetailsFragment.setArguments(bundle);
            HomeActivity.n(context, metroTicketDetailsFragment, C1218kf.Metro_booking_Details.a(), Boolean.TRUE, Boolean.FALSE);
        } catch (Exception e) {
            int i = ERSFragment.c;
            e.getMessage();
        }
    }

    public final void onCompleted() {
    }
}
