package cris.org.in.ima.fragment;

import android.view.View;

/* renamed from: cris.org.in.ima.fragment.s  reason: case insensitive filesystem */
/* compiled from: AllTrainListFragment */
public final class C1046s implements View.OnClickListener {
    public final /* synthetic */ AllTrainListFragment a;

    public C1046s(AllTrainListFragment allTrainListFragment) {
        this.a = allTrainListFragment;
    }

    public final void onClick(View view) {
        AllTrainListFragment allTrainListFragment = this.a;
        if (allTrainListFragment.ch_night.isChecked()) {
            allTrainListFragment.ch_night.setChecked(false);
        } else {
            allTrainListFragment.ch_night.setChecked(true);
        }
    }
}
