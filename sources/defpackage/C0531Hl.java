package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.fragment.MetroTicketDetailsFragment;
import cris.org.in.ima.utils.TicketHistoryUtil;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import rx.Subscriber;

/* renamed from: Hl  reason: default package and case insensitive filesystem */
/* compiled from: MobilePayment */
public final class C0531Hl implements Runnable {
    public final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Fragment f3613a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C1480xl f3614a;

    /* renamed from: Hl$a */
    /* compiled from: MobilePayment */
    public class a extends Subscriber<BookingResponseDTO> {
        public a() {
        }

        public final void onCompleted() {
            Boolean bool = C1480xl.a;
            C0531Hl.this.f3614a.f7040a.dismiss();
        }

        public final void onError(Throwable th) {
            Boolean bool = C1480xl.a;
            th.getClass();
            th.getMessage();
            C0531Hl.this.f3614a.f7040a.dismiss();
            Lt.a(true, th);
        }

        public final void onNext(Object obj) {
            BookingResponseDTO bookingResponseDTO = (BookingResponseDTO) obj;
            C0531Hl hl = C0531Hl.this;
            if (bookingResponseDTO != null) {
                C0657Qt.h();
                try {
                    if (bookingResponseDTO.getErrorMessage() == null || bookingResponseDTO.getErrorMessage().length() <= 0) {
                        TicketHistoryUtil.c();
                        Bundle bundle = new Bundle();
                        MetroTicketDetailsFragment metroTicketDetailsFragment = new MetroTicketDetailsFragment();
                        bundle.putSerializable("FinalBookingSummary", bookingResponseDTO);
                        metroTicketDetailsFragment.setArguments(bundle);
                        HomeActivity.n(hl.a, metroTicketDetailsFragment, hl.f3613a.getActivity().getResources().getString(R.string.Metro_booking_Details), Boolean.TRUE, Boolean.FALSE);
                    } else {
                        Fragment fragment = hl.f3613a;
                        Fragment fragment2 = hl.f3613a;
                        C0535I5.m(fragment.getContext(), false, bookingResponseDTO.getErrorMessage(), fragment2.getContext().getString(R.string.error), fragment2.getContext().getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                    }
                    hl.f3614a.f7040a.dismiss();
                } catch (Exception e) {
                    hl.f3614a.f7040a.dismiss();
                    Boolean bool = C1480xl.a;
                    e.getMessage();
                }
                Boolean bool2 = C1480xl.a;
                bookingResponseDTO.toString();
            }
            hl.f3614a.f7040a.dismiss();
        }
    }

    public C0531Hl(FragmentActivity fragmentActivity, Fragment fragment, C1480xl xlVar) {
        this.f3614a = xlVar;
        this.f3613a = fragment;
        this.a = fragmentActivity;
    }

    public final void run() {
        C1507z0.b();
        Om om = (Om) C0657Qt.c(C0793b1.a.f3912a);
        String f = C0657Qt.f();
        if (C1450w1.f7032f) {
            f = C0657Qt.k();
        }
        C1480xl xlVar = this.f3614a;
        om.r0(xx.D(f, "verifyPayment", String.format("/%s", new Object[]{xlVar.f7041a})), xlVar.f7042a).c(C1181iv.a()).a(E0.a()).b(new a());
    }
}
