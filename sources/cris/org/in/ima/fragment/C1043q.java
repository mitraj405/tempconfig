package cris.org.in.ima.fragment;

import android.view.View;

/* renamed from: cris.org.in.ima.fragment.q  reason: case insensitive filesystem */
/* compiled from: AllTrainListFragment */
public final class C1043q implements View.OnClickListener {
    public final /* synthetic */ AllTrainListFragment a;

    public C1043q(AllTrainListFragment allTrainListFragment) {
        this.a = allTrainListFragment;
    }

    public final void onClick(View view) {
        AllTrainListFragment allTrainListFragment = this.a;
        if (allTrainListFragment.ch_morning.isChecked()) {
            allTrainListFragment.ch_morning.setChecked(false);
        } else {
            allTrainListFragment.ch_morning.setChecked(true);
        }
    }
}
