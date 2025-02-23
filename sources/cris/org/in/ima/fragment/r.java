package cris.org.in.ima.fragment;

import android.view.View;

/* compiled from: AllTrainListFragment */
public final class r implements View.OnClickListener {
    public final /* synthetic */ AllTrainListFragment a;

    public r(AllTrainListFragment allTrainListFragment) {
        this.a = allTrainListFragment;
    }

    public final void onClick(View view) {
        AllTrainListFragment allTrainListFragment = this.a;
        if (allTrainListFragment.ch_midDay.isChecked()) {
            allTrainListFragment.ch_midDay.setChecked(false);
        } else {
            allTrainListFragment.ch_midDay.setChecked(true);
        }
    }
}
