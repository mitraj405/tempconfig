package defpackage;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.a;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.fragment.BookingHistoryFragment;
import cris.org.in.ima.fragment.FailedTxnHistoryFragment;
import cris.org.in.ima.fragment.MyTransactionFragment;
import cris.org.in.ima.utils.TicketHistoryUtil;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import java.util.Iterator;
import rx.Subscriber;

/* renamed from: pm  reason: default package and case insensitive filesystem */
/* compiled from: MyTransactionFragment */
public final class C1329pm extends Subscriber<C0707Ue> {
    public final /* synthetic */ MyTransactionFragment a;

    public C1329pm(MyTransactionFragment myTransactionFragment) {
        this.a = myTransactionFragment;
    }

    public final void onCompleted() {
        int i = MyTransactionFragment.c;
    }

    public final void onError(Throwable th) {
        this.a.a.dismiss();
        int i = MyTransactionFragment.c;
        xx.S(th, true, th);
    }

    public final void onNext(Object obj) {
        Fragment fragment;
        C0707Ue ue = (C0707Ue) obj;
        MyTransactionFragment myTransactionFragment = this.a;
        if (ue != null) {
            C0657Qt.h();
            try {
                if (ue.getErrorMsg() != null) {
                    C0535I5.m(myTransactionFragment.getActivity(), false, ue.getErrorMsg().split("-")[0], myTransactionFragment.getString(R.string.error), myTransactionFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("ticket", ue.getBookingResponseList());
                    if (!C0535I5.f3616a.f3654a.equalsIgnoreCase("Booked")) {
                        if (!C0535I5.f3616a.f3654a.equalsIgnoreCase("Multi Lap Part Book")) {
                            Iterator<BookingResponseDTO> it = ue.getBookingResponseList().iterator();
                            while (it.hasNext()) {
                                BookingResponseDTO next = it.next();
                                next.setReservationId(next.getResvDetails().get(0).getReservationId());
                                next.setTransactionAmt(next.getTotalCollectibleAmount());
                                next.setTransactionDate(next.getBookingDate());
                                next.setRetryBooking(Boolean.TRUE);
                            }
                            fragment = new FailedTxnHistoryFragment();
                            TicketHistoryUtil.f5370a = TicketHistoryUtil.SortFor.LAST_TXN;
                            fragment.setArguments(bundle);
                            HomeActivity.n(myTransactionFragment.getActivity(), fragment, C1218kf.LAST_TXN.a(), Boolean.TRUE, Boolean.FALSE);
                            FragmentManager fragmentManager = myTransactionFragment.f4841a;
                            fragmentManager.getClass();
                            a aVar = new a(fragmentManager);
                            aVar.n(myTransactionFragment);
                            aVar.c();
                        }
                    }
                    fragment = new BookingHistoryFragment();
                    C0535I5.f3652m = true;
                    C0535I5.f3650k = false;
                    C0535I5.f3647h = false;
                    TicketHistoryUtil.f5370a = TicketHistoryUtil.SortFor.LAST_TXN;
                    fragment.setArguments(bundle);
                    HomeActivity.n(myTransactionFragment.getActivity(), fragment, C1218kf.LAST_TXN.a(), Boolean.TRUE, Boolean.FALSE);
                    FragmentManager fragmentManager2 = myTransactionFragment.f4841a;
                    fragmentManager2.getClass();
                    a aVar2 = new a(fragmentManager2);
                    aVar2.n(myTransactionFragment);
                    aVar2.c();
                }
            } catch (Exception e) {
                int i = MyTransactionFragment.c;
                e.getMessage();
                C0535I5.t0(myTransactionFragment.getActivity(), myTransactionFragment.getResources().getString(R.string.unable_process_message));
            } catch (Throwable th) {
                myTransactionFragment.a.dismiss();
                throw th;
            }
            myTransactionFragment.a.dismiss();
            return;
        }
        myTransactionFragment.a.dismiss();
        C0535I5.t0(myTransactionFragment.getActivity(), myTransactionFragment.getResources().getString(R.string.unable_process_message));
    }
}
