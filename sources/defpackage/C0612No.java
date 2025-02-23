package defpackage;

import cris.org.in.ima.fragment.CustomDialogFragment;
import cris.org.in.ima.fragment.PassengerDetailFragment;
import cris.org.in.ima.listener.OnSelectionListener;

/* renamed from: No  reason: default package and case insensitive filesystem */
/* compiled from: PassengerDetailFragment */
public final class C0612No implements OnSelectionListener {
    public final /* synthetic */ CustomDialogFragment a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ PassengerDetailFragment f3720a;

    public C0612No(PassengerDetailFragment passengerDetailFragment, CustomDialogFragment customDialogFragment) {
        this.f3720a = passengerDetailFragment;
        this.a = customDialogFragment;
    }

    public final void onClick(String str) {
        this.a.dismiss();
        this.f3720a.g0(str);
    }
}
