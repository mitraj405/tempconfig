package cris.org.in.ima.fragment;

import android.view.View;

/* renamed from: cris.org.in.ima.fragment.k  reason: case insensitive filesystem */
/* compiled from: AllTrainListFragment */
public final class C1031k implements View.OnClickListener {
    public final /* synthetic */ AllTrainListFragment a;

    public C1031k(AllTrainListFragment allTrainListFragment) {
        this.a = allTrainListFragment;
    }

    public final void onClick(View view) {
        AllTrainListFragment allTrainListFragment = this.a;
        if (allTrainListFragment.ch_garibrath.isChecked()) {
            allTrainListFragment.ch_garibrath.setChecked(false);
        } else {
            allTrainListFragment.ch_garibrath.setChecked(true);
        }
    }
}
