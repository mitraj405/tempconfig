package cris.org.in.ima.fragment;

import android.content.DialogInterface;
import cris.org.in.ima.fragment.AddLoyaltyFragment;

/* renamed from: cris.org.in.ima.fragment.d  reason: case insensitive filesystem */
/* compiled from: AddLoyaltyFragment */
public final class C1017d implements DialogInterface.OnClickListener {
    public final /* synthetic */ AddLoyaltyFragment.d a;

    public C1017d(AddLoyaltyFragment.d dVar) {
        this.a = dVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        AddLoyaltyFragment.this.otpLayout.setVisibility(0);
    }
}
