package cris.org.in.ima.fragment;

import android.view.View;

/* renamed from: cris.org.in.ima.fragment.f  reason: case insensitive filesystem */
/* compiled from: AllTrainListFragment */
public final class C1021f implements View.OnClickListener {
    public final /* synthetic */ AllTrainListFragment a;

    public C1021f(AllTrainListFragment allTrainListFragment) {
        this.a = allTrainListFragment;
    }

    public final void onClick(View view) {
        AllTrainListFragment allTrainListFragment = this.a;
        if (allTrainListFragment.ch_rajdhani.isChecked()) {
            allTrainListFragment.ch_rajdhani.setChecked(false);
        } else {
            allTrainListFragment.ch_rajdhani.setChecked(true);
        }
    }
}
