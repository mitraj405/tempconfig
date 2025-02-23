package cris.org.in.ima.fragment;

import android.view.View;

/* renamed from: cris.org.in.ima.fragment.h  reason: case insensitive filesystem */
/* compiled from: AllTrainListFragment */
public final class C1025h implements View.OnClickListener {
    public final /* synthetic */ AllTrainListFragment a;

    public C1025h(AllTrainListFragment allTrainListFragment) {
        this.a = allTrainListFragment;
    }

    public final void onClick(View view) {
        AllTrainListFragment allTrainListFragment = this.a;
        if (allTrainListFragment.ch_duranto.isChecked()) {
            allTrainListFragment.ch_duranto.setChecked(false);
        } else {
            allTrainListFragment.ch_duranto.setChecked(true);
        }
    }
}
