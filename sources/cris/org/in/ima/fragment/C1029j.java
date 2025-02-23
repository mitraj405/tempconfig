package cris.org.in.ima.fragment;

import android.view.View;

/* renamed from: cris.org.in.ima.fragment.j  reason: case insensitive filesystem */
/* compiled from: AllTrainListFragment */
public final class C1029j implements View.OnClickListener {
    public final /* synthetic */ AllTrainListFragment a;

    public C1029j(AllTrainListFragment allTrainListFragment) {
        this.a = allTrainListFragment;
    }

    public final void onClick(View view) {
        AllTrainListFragment allTrainListFragment = this.a;
        if (allTrainListFragment.ch_special_tatkal.isChecked()) {
            allTrainListFragment.ch_special_tatkal.setChecked(false);
        } else {
            allTrainListFragment.ch_special_tatkal.setChecked(true);
        }
    }
}
