package cris.org.in.ima.fragment;

import android.view.View;

/* renamed from: cris.org.in.ima.fragment.i  reason: case insensitive filesystem */
/* compiled from: AllTrainListFragment */
public final class C1027i implements View.OnClickListener {
    public final /* synthetic */ AllTrainListFragment a;

    public C1027i(AllTrainListFragment allTrainListFragment) {
        this.a = allTrainListFragment;
    }

    public final void onClick(View view) {
        AllTrainListFragment allTrainListFragment = this.a;
        if (allTrainListFragment.ch_special_train.isChecked()) {
            allTrainListFragment.ch_special_train.setChecked(false);
        } else {
            allTrainListFragment.ch_special_train.setChecked(true);
        }
    }
}
