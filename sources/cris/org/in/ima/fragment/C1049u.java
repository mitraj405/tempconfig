package cris.org.in.ima.fragment;

import android.content.DialogInterface;
import cris.org.in.ima.fragment.AllTrainListFragment;

/* renamed from: cris.org.in.ima.fragment.u  reason: case insensitive filesystem */
/* compiled from: AllTrainListFragment */
public final class C1049u implements DialogInterface.OnClickListener {
    public final /* synthetic */ AllTrainListFragment.i a;

    public C1049u(AllTrainListFragment.i iVar) {
        this.a = iVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        AllTrainListFragment.this.f4420a.dismiss();
        dialogInterface.dismiss();
    }
}
