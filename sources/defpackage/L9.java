package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.google.gson.Gson;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.fragment.DelhiMetroFragment;
import cris.org.in.ima.fragment.ERSFragment;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import defpackage.C0614Nv;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import rx.Subscriber;

/* renamed from: L9  reason: default package */
/* compiled from: ERSFragment */
public final class L9 extends Subscriber<U7> {
    public final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ BookingResponseDTO f3692a;
    public final /* synthetic */ String c;

    public L9(Context context, BookingResponseDTO bookingResponseDTO, String str) {
        this.a = context;
        this.f3692a = bookingResponseDTO;
        this.c = str;
    }

    public final void onCompleted() {
        int i = ERSFragment.c;
    }

    public final void onError(Throwable th) {
        int i = ERSFragment.c;
        th.getMessage();
    }

    public final void onNext(Object obj) {
        U7 u7 = (U7) obj;
        BookingResponseDTO bookingResponseDTO = this.f3692a;
        int i = ERSFragment.c;
        Context context = this.a;
        if (u7 != null) {
            try {
                Bundle bundle = new Bundle();
                List<C1322p9> dmrcIrStations = u7.getDmrcIrStations();
                Bw e = Bw.e(context);
                Gson gson = new Gson();
                String json = gson.toJson((Object) (ArrayList) u7.getDmrcStations());
                String json2 = gson.toJson((Object) dmrcIrStations);
                C0614Nv.a c2 = e.f3534a.edit();
                c2.putString("DMRCStationList", json);
                c2.commit();
                C0614Nv.a c3 = e.f3534a.edit();
                c3.putString("DMRCIrStationList", json2);
                c3.commit();
                bundle.putString("pnr", bookingResponseDTO.getPnrNumber());
                bundle.putString("dmrcIrStationList", json2);
                bundle.putSerializable("jsonStnScorinList", (Serializable) u7.getDmrcStations());
                bundle.putString("postBookingService", bookingResponseDTO.getInsuranceOpted());
                bundle.putSerializable("deptDate", bookingResponseDTO.getBoardingDate());
                bundle.putSerializable("arvDate", bookingResponseDTO.getDestArrvDate());
                if (bookingResponseDTO.getNoOfBkdPsgn() != null) {
                    if (bookingResponseDTO.getTransactionId() != null) {
                        bundle.putString("noOfBkdPsgn", bookingResponseDTO.getNoOfBkdPsgn());
                        bundle.putString("noOfBkdChild", bookingResponseDTO.getNoOfBkdChild());
                        bundle.putString("transactionId", bookingResponseDTO.getTransactionId());
                        bundle.putString("toStnCode", bookingResponseDTO.getDestStn());
                        bundle.putString("fromStnCode", bookingResponseDTO.getFromStn());
                        DelhiMetroFragment delhiMetroFragment = new DelhiMetroFragment();
                        delhiMetroFragment.setArguments(bundle);
                        HomeActivity.n(context, delhiMetroFragment, C1218kf.SEARCH_METRO.a(), Boolean.TRUE, Boolean.FALSE);
                    }
                }
                bundle.putString("noOfBkdPsgn", String.valueOf(bookingResponseDTO.getNumberOfpassenger()));
                bundle.putString("noOfBkdChild", String.valueOf(bookingResponseDTO.getNumberOfChilds()));
                bundle.putString("transactionId", this.c);
                bundle.putString("toStnCode", bookingResponseDTO.getDestStn());
                bundle.putString("fromStnCode", bookingResponseDTO.getFromStn());
                DelhiMetroFragment delhiMetroFragment2 = new DelhiMetroFragment();
                delhiMetroFragment2.setArguments(bundle);
                HomeActivity.n(context, delhiMetroFragment2, C1218kf.SEARCH_METRO.a(), Boolean.TRUE, Boolean.FALSE);
            } catch (Exception e2) {
                int i2 = ERSFragment.c;
                e2.getMessage();
            }
        } else {
            C0535I5.m(context, false, context.getResources().getString(R.string.unable_process_message), context.getString(R.string.error), context.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
    }
}
