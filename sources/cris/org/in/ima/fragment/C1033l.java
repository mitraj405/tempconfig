package cris.org.in.ima.fragment;

import android.view.View;

/* renamed from: cris.org.in.ima.fragment.l  reason: case insensitive filesystem */
/* compiled from: AllTrainListFragment */
public final class C1033l implements View.OnClickListener {
    public final /* synthetic */ AllTrainListFragment a;

    public C1033l(AllTrainListFragment allTrainListFragment) {
        this.a = allTrainListFragment;
    }

    public final void onClick(View view) {
        AllTrainListFragment allTrainListFragment = this.a;
        if (allTrainListFragment.ch_suvidha_train.isChecked()) {
            allTrainListFragment.ch_suvidha_train.setChecked(false);
        } else {
            allTrainListFragment.ch_suvidha_train.setChecked(true);
        }
    }
}
