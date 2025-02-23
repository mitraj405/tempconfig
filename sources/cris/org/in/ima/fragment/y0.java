package cris.org.in.ima.fragment;

import android.content.DialogInterface;
import cris.org.in.ima.fragment.TdrHistoryFragment;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import rx.Subscriber;

/* compiled from: TdrHistoryFragment */
public final class y0 extends Subscriber<C0707Ue> {
    public final /* synthetic */ TdrHistoryFragment.d a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ BookingResponseDTO f5243a;

    public y0(TdrHistoryFragment.d dVar, BookingResponseDTO bookingResponseDTO) {
        this.a = dVar;
        this.f5243a = bookingResponseDTO;
    }

    public final void onCompleted() {
        int i = TdrHistoryFragment.c;
        TdrHistoryFragment.this.a.dismiss();
    }

    public final void onError(Throwable th) {
        TdrHistoryFragment.this.a.dismiss();
        int i = TdrHistoryFragment.c;
        xx.S(th, true, th);
    }

    public final void onNext(Object obj) {
        TdrHistoryFragment tdrHistoryFragment;
        C0707Ue ue = (C0707Ue) obj;
        BookingResponseDTO bookingResponseDTO = this.f5243a;
        TdrHistoryFragment.d dVar = this.a;
        if (ue != null) {
            C0657Qt.h();
            try {
                if (ue.getErrorMsg() != null) {
                    TdrHistoryFragment tdrHistoryFragment2 = TdrHistoryFragment.this;
                    TdrHistoryFragment tdrHistoryFragment3 = TdrHistoryFragment.this;
                    C0535I5.m(tdrHistoryFragment2.getActivity(), false, ue.getErrorMsg().split("-")[0], tdrHistoryFragment3.getString(R.string.error), tdrHistoryFragment3.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                } else {
                    int i = TdrHistoryFragment.c;
                    ue.getTimeStamp().toString();
                    TdrHistoryFragment.f(TdrHistoryFragment.this, bookingResponseDTO, ue.getBookingResponseList().get(0), ue.getTimeStamp());
                    TdrHistoryFragment.this.j(bookingResponseDTO);
                }
                tdrHistoryFragment = TdrHistoryFragment.this;
            } catch (Exception e) {
                int i2 = TdrHistoryFragment.c;
                e.getMessage();
                TdrHistoryFragment tdrHistoryFragment4 = TdrHistoryFragment.this;
                TdrHistoryFragment tdrHistoryFragment5 = TdrHistoryFragment.this;
                C0535I5.t0(tdrHistoryFragment4.getActivity(), tdrHistoryFragment5.getResources().getString(R.string.unable_process_message));
                tdrHistoryFragment = tdrHistoryFragment5;
            } catch (Throwable th) {
                TdrHistoryFragment.this.a.dismiss();
                throw th;
            }
            tdrHistoryFragment.a.dismiss();
            return;
        }
        TdrHistoryFragment.this.a.dismiss();
        TdrHistoryFragment tdrHistoryFragment6 = TdrHistoryFragment.this;
        C0535I5.t0(tdrHistoryFragment6.getActivity(), tdrHistoryFragment6.getResources().getString(R.string.unable_process_message));
    }
}
