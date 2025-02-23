package cris.org.in.ima.fragment;

import android.view.View;

/* renamed from: cris.org.in.ima.fragment.o  reason: case insensitive filesystem */
/* compiled from: AllTrainListFragment */
public final class C1039o implements View.OnClickListener {
    public final /* synthetic */ AllTrainListFragment a;

    public C1039o(AllTrainListFragment allTrainListFragment) {
        this.a = allTrainListFragment;
    }

    public final void onClick(View view) {
        AllTrainListFragment allTrainListFragment = this.a;
        if (allTrainListFragment.ch_others.isChecked()) {
            allTrainListFragment.ch_others.setChecked(false);
        } else {
            allTrainListFragment.ch_others.setChecked(true);
        }
    }
}
