package defpackage;

import android.content.DialogInterface;
import android.os.Bundle;
import com.google.gson.Gson;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.fragment.DelhiMetroFragment;
import cris.org.in.ima.fragment.TrainDashboardFragment;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.RecentTransactionsDTO;
import defpackage.C0614Nv;
import java.util.ArrayList;
import rx.Subscriber;

/* renamed from: zA  reason: default package and case insensitive filesystem */
/* compiled from: TrainDashboardFragment */
public final class C1511zA extends Subscriber<U7> {
    public final /* synthetic */ TrainDashboardFragment a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ RecentTransactionsDTO f7091a;

    public C1511zA(TrainDashboardFragment trainDashboardFragment, RecentTransactionsDTO recentTransactionsDTO) {
        this.a = trainDashboardFragment;
        this.f7091a = recentTransactionsDTO;
    }

    public final void onCompleted() {
        this.a.a.dismiss();
        int i = TrainDashboardFragment.c;
    }

    public final void onError(Throwable th) {
        int i = TrainDashboardFragment.c;
        th.getMessage();
    }

    public final void onNext(Object obj) {
        U7 u7 = (U7) obj;
        RecentTransactionsDTO recentTransactionsDTO = this.f7091a;
        int i = TrainDashboardFragment.c;
        TrainDashboardFragment trainDashboardFragment = this.a;
        if (u7 != null) {
            try {
                trainDashboardFragment.a.dismiss();
                Bundle bundle = new Bundle();
                Bw e = Bw.e(trainDashboardFragment.f5164a);
                String json = new Gson().toJson((Object) (ArrayList) u7.getDmrcStations());
                C0614Nv.a c = e.f3534a.edit();
                c.putString("DMRCStationList", json);
                c.commit();
                C0614Nv.a c2 = e.f3534a.edit();
                c2.putString("DMRCIrStationList", json);
                c2.commit();
                bundle.putString("transactionId", String.valueOf(recentTransactionsDTO.getTransactionId()));
                bundle.putString("pnr", recentTransactionsDTO.getPnrNumber());
                bundle.putString("fromStnCode", recentTransactionsDTO.getFromStation());
                bundle.putString("toStnCode", recentTransactionsDTO.getToStation());
                bundle.putSerializable("deptDate", recentTransactionsDTO.getBoardingDate());
                bundle.putSerializable("arvDate", recentTransactionsDTO.getArrivalDate());
                DelhiMetroFragment delhiMetroFragment = new DelhiMetroFragment();
                delhiMetroFragment.setArguments(bundle);
                HomeActivity.n(trainDashboardFragment.f5164a, delhiMetroFragment, C1218kf.SEARCH_METRO.a(), Boolean.TRUE, Boolean.FALSE);
            } catch (Exception e2) {
                trainDashboardFragment.a.dismiss();
                int i2 = TrainDashboardFragment.c;
                e2.getMessage();
            }
        } else {
            trainDashboardFragment.a.dismiss();
            C0535I5.m(trainDashboardFragment.getActivity(), false, trainDashboardFragment.getResources().getString(R.string.data_connection_error_message), trainDashboardFragment.getString(R.string.error), trainDashboardFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
    }
}
