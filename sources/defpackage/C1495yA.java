package defpackage;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.fragment.DelhiMetroFragment;
import cris.org.in.ima.fragment.TrainDashboardFragment;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.RecentTransactionsDTO;
import rx.Subscriber;

/* renamed from: yA  reason: default package and case insensitive filesystem */
/* compiled from: TrainDashboardFragment */
public final class C1495yA extends Subscriber<Wp> {
    public final /* synthetic */ TrainDashboardFragment a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ RecentTransactionsDTO f7072a;

    public C1495yA(TrainDashboardFragment trainDashboardFragment, RecentTransactionsDTO recentTransactionsDTO) {
        this.a = trainDashboardFragment;
        this.f7072a = recentTransactionsDTO;
    }

    public final void onCompleted() {
        this.a.a.dismiss();
        int i = TrainDashboardFragment.c;
    }

    public final void onError(Throwable th) {
        this.a.a.dismiss();
        int i = TrainDashboardFragment.c;
        th.getMessage();
    }

    public final void onNext(Object obj) {
        Wp wp = (Wp) obj;
        int i = TrainDashboardFragment.c;
        TrainDashboardFragment trainDashboardFragment = this.a;
        if (wp != null) {
            Bw e = Bw.e(trainDashboardFragment.getContext());
            if (wp.getError() == null) {
                boolean isEmpty = e.b().isEmpty();
                RecentTransactionsDTO recentTransactionsDTO = this.f7072a;
                if (isEmpty || e.b() == null || e.a().isEmpty() || e.a() == null) {
                    C1223kn knVar = C0793b1.a.f3912a;
                    trainDashboardFragment.f5172a = knVar;
                    if (knVar != null) {
                        Context context = trainDashboardFragment.f5164a;
                        trainDashboardFragment.a = ProgressDialog.show(context, context.getResources().getString(R.string.fetching_details_dashboard), trainDashboardFragment.f5164a.getResources().getString(R.string.please_wait_text));
                        String j = C0657Qt.j();
                        ((Om) C0657Qt.c(trainDashboardFragment.f5172a)).l0(j + "dmrcStations").c(C1181iv.a()).a(E0.a()).b(new C1511zA(trainDashboardFragment, recentTransactionsDTO));
                        return;
                    }
                    C0535I5.m(trainDashboardFragment.getActivity(), false, trainDashboardFragment.getResources().getString(R.string.data_connection_error_message), trainDashboardFragment.getString(R.string.error), trainDashboardFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                    return;
                }
                try {
                    trainDashboardFragment.a.dismiss();
                    Bundle bundle = new Bundle();
                    bundle.putString("transactionId", String.valueOf(recentTransactionsDTO.getTransactionId()));
                    bundle.putString("pnr", recentTransactionsDTO.getPnrNumber());
                    bundle.putString("fromStnCode", recentTransactionsDTO.getFromStation());
                    bundle.putString("toStnCode", recentTransactionsDTO.getToStation());
                    bundle.putSerializable("deptDate", recentTransactionsDTO.getBoardingDate());
                    bundle.putSerializable("arvDate", recentTransactionsDTO.getArrivalDate());
                    DelhiMetroFragment delhiMetroFragment = new DelhiMetroFragment();
                    delhiMetroFragment.setArguments(bundle);
                    HomeActivity.n(trainDashboardFragment.getActivity(), delhiMetroFragment, C1218kf.SEARCH_METRO.a(), Boolean.TRUE, Boolean.FALSE);
                } catch (Exception e2) {
                    trainDashboardFragment.a.dismiss();
                    int i2 = TrainDashboardFragment.c;
                    e2.getMessage();
                }
            } else {
                C0535I5.m(trainDashboardFragment.getActivity(), false, wp.getError(), trainDashboardFragment.getString(R.string.information), trainDashboardFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            }
        } else {
            trainDashboardFragment.a.dismiss();
            C0535I5.m(trainDashboardFragment.getActivity(), false, trainDashboardFragment.getResources().getString(R.string.data_connection_error_message), trainDashboardFragment.getString(R.string.error), trainDashboardFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
    }
}
