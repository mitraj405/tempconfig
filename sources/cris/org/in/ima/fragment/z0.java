package cris.org.in.ima.fragment;

import cris.org.in.ima.fragment.TrainDashboardFragment;
import cris.prs.webservices.dto.RecentTransactionsDTO;

/* compiled from: TrainDashboardFragment */
public final class z0 implements Runnable {
    public final /* synthetic */ TrainDashboardFragment.d a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ RecentTransactionsDTO f5244a;

    public z0(TrainDashboardFragment.d dVar, RecentTransactionsDTO recentTransactionsDTO) {
        this.a = dVar;
        this.f5244a = recentTransactionsDTO;
    }

    public final void run() {
        RecentTransactionsDTO recentTransactionsDTO = this.f5244a;
        try {
            TrainDashboardFragment.this.h("RR", recentTransactionsDTO.getPnrNumber(), String.valueOf(recentTransactionsDTO.getReservationId()), C0535I5.y(recentTransactionsDTO.getArrivalDate()), recentTransactionsDTO.getToStation());
        } catch (Exception e) {
            int i = TrainDashboardFragment.c;
            e.getMessage();
        }
    }
}
