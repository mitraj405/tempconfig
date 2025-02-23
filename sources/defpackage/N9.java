package defpackage;

import android.content.DialogInterface;
import cris.org.in.ima.fragment.ERSFragment;

/* renamed from: N9  reason: default package */
/* compiled from: ERSFragment */
public final class N9 implements DialogInterface.OnClickListener {
    public final /* synthetic */ ERSFragment a;

    public N9(ERSFragment eRSFragment) {
        this.a = eRSFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        ERSFragment eRSFragment = this.a;
        if (eRSFragment.f4548a.getAvlForVikalp().booleanValue()) {
            eRSFragment.i(eRSFragment.f4548a);
        }
    }
}
