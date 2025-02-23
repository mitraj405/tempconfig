package cris.org.in.ima.fragment;

import android.view.View;

/* renamed from: cris.org.in.ima.fragment.m  reason: case insensitive filesystem */
/* compiled from: AllTrainListFragment */
public final class C1035m implements View.OnClickListener {
    public final /* synthetic */ AllTrainListFragment a;

    public C1035m(AllTrainListFragment allTrainListFragment) {
        this.a = allTrainListFragment;
    }

    public final void onClick(View view) {
        AllTrainListFragment allTrainListFragment = this.a;
        if (allTrainListFragment.ch_janshatabdi.isChecked()) {
            allTrainListFragment.ch_janshatabdi.setChecked(false);
        } else {
            allTrainListFragment.ch_janshatabdi.setChecked(true);
        }
    }
}
