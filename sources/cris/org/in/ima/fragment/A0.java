package cris.org.in.ima.fragment;

import android.widget.Toast;
import cris.org.in.ima.fragment.TrainDashboardFragment;
import cris.prs.webservices.dto.RecentTransactionsDTO;

/* compiled from: TrainDashboardFragment */
public final class A0 implements Runnable {
    public final /* synthetic */ Toast a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ TrainDashboardFragment.d f4381a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ RecentTransactionsDTO f4382a;

    public A0(TrainDashboardFragment.d dVar, RecentTransactionsDTO recentTransactionsDTO, Toast toast) {
        this.f4381a = dVar;
        this.f4382a = recentTransactionsDTO;
        this.a = toast;
    }

    public final void run() {
        Toast toast = this.a;
        TrainDashboardFragment.d dVar = this.f4381a;
        RecentTransactionsDTO recentTransactionsDTO = this.f4382a;
        try {
            TrainDashboardFragment.this.h("HB", recentTransactionsDTO.getPnrNumber(), String.valueOf(recentTransactionsDTO.getReservationId()), C0535I5.y(recentTransactionsDTO.getArrivalDate()), recentTransactionsDTO.getToStation());
        } catch (Exception e) {
            int i = TrainDashboardFragment.c;
            e.getMessage();
            if (TrainDashboardFragment.this.f5173a) {
                try {
                    Thread.sleep(100);
                    toast.show();
                    Thread.sleep(100);
                } catch (Exception e2) {
                    int i2 = TrainDashboardFragment.c;
                    e2.getMessage();
                }
            }
        }
        if (TrainDashboardFragment.this.f5173a) {
            try {
                Thread.sleep(100);
                toast.show();
                Thread.sleep(100);
            } catch (Exception e3) {
                int i3 = TrainDashboardFragment.c;
                e3.getMessage();
            }
        }
    }
}
