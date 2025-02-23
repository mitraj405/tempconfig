package defpackage;

import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.fragment.NewBookingFragment;
import cris.org.in.prs.ima.R;

/* renamed from: wl  reason: default package and case insensitive filesystem */
/* compiled from: MobilePayment */
public final class C1462wl implements DialogInterface.OnClickListener {
    public final /* synthetic */ C0474Cl a;
    public final /* synthetic */ String c;

    public C1462wl(C0474Cl cl, String str) {
        this.a = cl;
        this.c = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        C0474Cl cl = this.a;
        String string = cl.f3551a.a().getResources().getString(R.string.captcha_bypass_msg);
        String str = this.c;
        if (str.contains(string)) {
            Boolean bool = C1480xl.a;
            HomeActivity.B(cl.f3551a.a().getActivity());
        } else if (str.contains("55002") || str.contains("55001")) {
            HomeActivity.B(cl.f3551a.a().getActivity());
            FragmentActivity activity = cl.f3551a.a().getActivity();
            NewBookingFragment newBookingFragment = new NewBookingFragment();
            String a2 = C1218kf.NEW_BOOKING.a();
            Boolean bool2 = Boolean.TRUE;
            HomeActivity.n(activity, newBookingFragment, a2, bool2, bool2);
        }
        C1480xl xlVar = cl.f3552a;
        if (xlVar.f7046c == null) {
            return;
        }
        if (xlVar.f7042a.getJuspayLoadDTO() != null) {
            C0535I5.W("PG_ISSUE", false, new C0822cf(cl.f3551a.a().getActivity()), (String) null, (String) null);
        } else {
            C0535I5.W(str.split("-")[0], true, new C0822cf(cl.f3551a.a().getActivity()), (String) null, (String) null);
        }
    }
}
