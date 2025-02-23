package defpackage;

import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import cris.org.in.ima.fragment.TDRTicketFragment;
import cris.org.in.ima.utils.TicketHistoryUtil;
import cris.org.in.prs.ima.R;
import rx.Subscriber;

/* renamed from: mz  reason: default package and case insensitive filesystem */
/* compiled from: TDRTicketFragment */
public final class C1269mz extends Subscriber<C0707Ue> {
    public final /* synthetic */ TDRTicketFragment a;

    public C1269mz(TDRTicketFragment tDRTicketFragment) {
        this.a = tDRTicketFragment;
    }

    public final void onCompleted() {
        FragmentActivity fragmentActivity = TDRTicketFragment.a;
    }

    public final void onError(Throwable th) {
        FragmentActivity fragmentActivity = TDRTicketFragment.a;
        th.getClass();
        th.getMessage();
        this.a.f5139a.dismiss();
        Lt.a(true, th);
    }

    public final void onNext(Object obj) {
        C0707Ue ue = (C0707Ue) obj;
        FragmentActivity fragmentActivity = TDRTicketFragment.a;
        TDRTicketFragment tDRTicketFragment = this.a;
        if (ue == null) {
            tDRTicketFragment.f5139a.dismiss();
            C0535I5.m(TDRTicketFragment.a, false, tDRTicketFragment.getString(R.string.unble_to_request_try_sometime), tDRTicketFragment.getString(R.string.error), tDRTicketFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        } else if (ue.getErrorMsg() == null) {
            TicketHistoryUtil.f5368a = ue;
            tDRTicketFragment.f(ue);
        } else {
            tDRTicketFragment.f5139a.dismiss();
            C0535I5.m(TDRTicketFragment.a, false, ue.getErrorMsg(), tDRTicketFragment.getString(R.string.info), tDRTicketFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
    }
}
