package cris.org.in.ima.fragment;

import android.view.View;

/* renamed from: cris.org.in.ima.fragment.g  reason: case insensitive filesystem */
/* compiled from: AllTrainListFragment */
public final class C1023g implements View.OnClickListener {
    public final /* synthetic */ AllTrainListFragment a;

    public C1023g(AllTrainListFragment allTrainListFragment) {
        this.a = allTrainListFragment;
    }

    public final void onClick(View view) {
        AllTrainListFragment allTrainListFragment = this.a;
        if (allTrainListFragment.ch_shatabdi.isChecked()) {
            allTrainListFragment.ch_shatabdi.setChecked(false);
        } else {
            allTrainListFragment.ch_shatabdi.setChecked(true);
        }
    }
}
