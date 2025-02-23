package defpackage;

import android.content.DialogInterface;
import cris.org.in.ima.fragment.ErsDisplayFragment;
import cris.org.in.ima.utils.TicketHistoryUtil;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import java.text.SimpleDateFormat;
import rx.Subscriber;

/* renamed from: Wa  reason: default package and case insensitive filesystem */
/* compiled from: ErsDisplayFragment */
public final class C0734Wa extends Subscriber<C0707Ue> {
    public final /* synthetic */ ErsDisplayFragment a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ BookingResponseDTO f3825a;

    public C0734Wa(ErsDisplayFragment ersDisplayFragment, BookingResponseDTO bookingResponseDTO) {
        this.a = ersDisplayFragment;
        this.f3825a = bookingResponseDTO;
    }

    public final void onCompleted() {
        SimpleDateFormat simpleDateFormat = ErsDisplayFragment.d;
    }

    public final void onError(Throwable th) {
        SimpleDateFormat simpleDateFormat = ErsDisplayFragment.d;
        this.a.j();
        SimpleDateFormat simpleDateFormat2 = ErsDisplayFragment.d;
        xx.S(th, true, th);
    }

    public final void onNext(Object obj) {
        C0707Ue ue = (C0707Ue) obj;
        BookingResponseDTO bookingResponseDTO = this.f3825a;
        ErsDisplayFragment ersDisplayFragment = this.a;
        if (ue != null) {
            C0657Qt.h();
            try {
                if (ue.getErrorMsg() != null) {
                    C0535I5.m(ersDisplayFragment.getActivity(), false, ue.getErrorMsg().split("-")[0], ersDisplayFragment.getString(R.string.error), ersDisplayFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                } else {
                    SimpleDateFormat simpleDateFormat = ErsDisplayFragment.d;
                    ue.toString();
                    ue.getTimeStamp().toString();
                    ErsDisplayFragment.h(ersDisplayFragment, bookingResponseDTO, ue.getBookingResponseList().get(0), ue.getTimeStamp());
                    if (bookingResponseDTO.getConnectingPnrNumber() != null && !bookingResponseDTO.getConnectingPnrNumber().isEmpty()) {
                        ersDisplayFragment.f = ersDisplayFragment.l(bookingResponseDTO.getConnectingPnrNumber(), TicketHistoryUtil.b);
                    }
                    SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSS");
                    ersDisplayFragment.q(bookingResponseDTO, ersDisplayFragment.f);
                    ersDisplayFragment.f = null;
                    if (bookingResponseDTO.getVikalpStatus() != null && !bookingResponseDTO.getVikalpStatus().toString().equalsIgnoreCase("NO") && bookingResponseDTO.getBoardingDate().after(simpleDateFormat2.parse(bookingResponseDTO.getDispatchDate())) && (bookingResponseDTO.getReservationStatus().compareToIgnoreCase("Booked") == 0 || bookingResponseDTO.getReservationStatus().compareToIgnoreCase("Partial Cancelled") == 0)) {
                        C0535I5.p(ersDisplayFragment.getActivity(), false, ersDisplayFragment.getResources().getString(R.string.vikalp_info_msg), ersDisplayFragment.getString(R.string.info), ersDisplayFragment.getString(R.string.ok), (DialogInterface.OnClickListener) null, (String) null, (DialogInterface.OnClickListener) null).show();
                    }
                }
                SimpleDateFormat simpleDateFormat3 = ErsDisplayFragment.d;
            } catch (Exception e) {
                SimpleDateFormat simpleDateFormat4 = ErsDisplayFragment.d;
                e.getMessage();
                C0535I5.t0(ersDisplayFragment.getActivity(), ersDisplayFragment.getResources().getString(R.string.unable_process_message));
            } catch (Throwable th) {
                SimpleDateFormat simpleDateFormat5 = ErsDisplayFragment.d;
                ersDisplayFragment.j();
                throw th;
            }
            ersDisplayFragment.j();
            return;
        }
        SimpleDateFormat simpleDateFormat6 = ErsDisplayFragment.d;
        ersDisplayFragment.j();
        C0535I5.t0(ersDisplayFragment.getActivity(), ersDisplayFragment.getResources().getString(R.string.unable_process_message));
    }
}
