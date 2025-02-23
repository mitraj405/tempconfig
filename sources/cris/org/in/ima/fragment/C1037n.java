package cris.org.in.ima.fragment;

import android.view.View;

/* renamed from: cris.org.in.ima.fragment.n  reason: case insensitive filesystem */
/* compiled from: AllTrainListFragment */
public final class C1037n implements View.OnClickListener {
    public final /* synthetic */ AllTrainListFragment a;

    public C1037n(AllTrainListFragment allTrainListFragment) {
        this.a = allTrainListFragment;
    }

    public final void onClick(View view) {
        AllTrainListFragment allTrainListFragment = this.a;
        if (allTrainListFragment.ch_yuva_express.isChecked()) {
            allTrainListFragment.ch_yuva_express.setChecked(false);
        } else {
            allTrainListFragment.ch_yuva_express.setChecked(true);
        }
    }
}
