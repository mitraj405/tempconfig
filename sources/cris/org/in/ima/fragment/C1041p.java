package cris.org.in.ima.fragment;

import android.view.View;

/* renamed from: cris.org.in.ima.fragment.p  reason: case insensitive filesystem */
/* compiled from: AllTrainListFragment */
public final class C1041p implements View.OnClickListener {
    public final /* synthetic */ AllTrainListFragment a;

    public C1041p(AllTrainListFragment allTrainListFragment) {
        this.a = allTrainListFragment;
    }

    public final void onClick(View view) {
        AllTrainListFragment allTrainListFragment = this.a;
        if (allTrainListFragment.ch_earlyMorning.isChecked()) {
            allTrainListFragment.ch_earlyMorning.setChecked(false);
        } else {
            allTrainListFragment.ch_earlyMorning.setChecked(true);
        }
    }
}
