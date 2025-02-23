package defpackage;

import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.fragment.NewBookingFragment;
import cris.org.in.prs.ima.R;

/* renamed from: El  reason: default package and case insensitive filesystem */
/* compiled from: MobilePayment */
public final class C0498El implements DialogInterface.OnClickListener {
    public final /* synthetic */ C0506Fl a;
    public final /* synthetic */ String c;

    public C0498El(C0506Fl fl, String str) {
        this.a = fl;
        this.c = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        C0506Fl fl = this.a;
        String string = fl.a.a().getResources().getString(R.string.captcha_bypass_msg);
        String str = this.c;
        if (str.contains(string)) {
            Boolean bool = C1480xl.a;
            HomeActivity.B(fl.a.a().getActivity());
        } else if (str.contains("55002") || str.contains("55001")) {
            HomeActivity.B(fl.a.a().getActivity());
            FragmentActivity activity = fl.a.a().getActivity();
            NewBookingFragment newBookingFragment = new NewBookingFragment();
            String a2 = C1218kf.NEW_BOOKING.a();
            Boolean bool2 = Boolean.TRUE;
            HomeActivity.n(activity, newBookingFragment, a2, bool2, bool2);
        }
    }
}
