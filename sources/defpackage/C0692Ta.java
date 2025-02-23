package defpackage;

import android.content.DialogInterface;
import androidx.appcompat.app.AppCompatActivity;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.fragment.BookingHistoryFragment;

/* renamed from: Ta  reason: default package and case insensitive filesystem */
/* compiled from: ErsDisplayFragment */
public final class C0692Ta implements DialogInterface.OnClickListener {
    public final /* synthetic */ C0705Ua a;

    public C0692Ta(C0705Ua ua) {
        this.a = ua;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        C0705Ua ua = this.a;
        HomeActivity.B(ua.f3807a.getActivity());
        HomeActivity.n((AppCompatActivity) ua.f3807a.getActivity(), new BookingHistoryFragment(), C1218kf.MY_BOOKING.a(), Boolean.TRUE, Boolean.FALSE);
        ua.f3807a.f4571a.close();
    }
}
