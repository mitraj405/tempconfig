package cris.org.in.ima.fragment;

import android.view.View;
import androidx.fragment.app.Fragment;

/* renamed from: cris.org.in.ima.fragment.e  reason: case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C1019e implements View.OnClickListener {
    public final /* synthetic */ Fragment a;
    public final /* synthetic */ int c;

    public /* synthetic */ C1019e(Fragment fragment, int i) {
        this.c = i;
        this.a = fragment;
    }

    public final void onClick(View view) {
        int i = this.c;
        Fragment fragment = this.a;
        switch (i) {
            case 0:
                AllTrainListFragment allTrainListFragment = (AllTrainListFragment) fragment;
                if (allTrainListFragment.lastTransationDtail.getVisibility() == 0) {
                    allTrainListFragment.lastTransationDtail.setVisibility(8);
                    return;
                }
                return;
            default:
                TrainDashboardFragment trainDashboardFragment = (TrainDashboardFragment) fragment;
                if (trainDashboardFragment.lastTransationDtail.getVisibility() == 0) {
                    trainDashboardFragment.lastTransationDtail.setVisibility(8);
                    return;
                }
                return;
        }
    }
}
