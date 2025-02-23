package cris.org.in.ima.fragment;

import android.content.DialogInterface;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.fragment.VikalpTrainListFragment;
import cris.org.in.ima.utils.TicketHistoryUtil;

/* compiled from: VikalpTrainListFragment */
public final class R0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ VikalpTrainListFragment.i a;

    public R0(VikalpTrainListFragment.i iVar) {
        this.a = iVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        TicketHistoryUtil.c();
        HomeActivity.B(VikalpTrainListFragment.this.f5206a);
    }
}
