package cris.org.in.ima.fragment;

import android.widget.Toast;
import cris.org.in.ima.fragment.TrainDashboardFragment;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.RecentTransactionsDTO;

/* compiled from: TrainDashboardFragment */
public final class B0 implements Runnable {
    public final /* synthetic */ TrainDashboardFragment.d a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ RecentTransactionsDTO f4460a;

    public B0(TrainDashboardFragment.d dVar, RecentTransactionsDTO recentTransactionsDTO) {
        this.a = dVar;
        this.f4460a = recentTransactionsDTO;
    }

    public final void run() {
        TrainDashboardFragment.d dVar = this.a;
        RecentTransactionsDTO recentTransactionsDTO = this.f4460a;
        try {
            TrainDashboardFragment.this.f(recentTransactionsDTO.getPnrNumber(), String.valueOf(recentTransactionsDTO.getReservationId()), C0535I5.y(recentTransactionsDTO.getArrivalDate()), recentTransactionsDTO.getToStation());
        } catch (Exception e) {
            int i = TrainDashboardFragment.c;
            e.getMessage();
            Toast.makeText(TrainDashboardFragment.this.getContext(), TrainDashboardFragment.this.getResources().getString(R.string.unble_toconnect_server), 1);
        }
    }
}
