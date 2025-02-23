package defpackage;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import com.fasterxml.jackson.databind.ObjectMapper;
import cris.org.in.ima.fragment.ErsDisplayFragment;
import cris.org.in.ima.utils.TicketHistoryUtil;
import cris.org.in.prs.ima.R;
import java.text.SimpleDateFormat;
import rx.Subscriber;

/* renamed from: Ua  reason: default package and case insensitive filesystem */
/* compiled from: ErsDisplayFragment */
public final class C0705Ua extends Subscriber<Y2> {
    public final /* synthetic */ ProgressDialog a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ErsDisplayFragment f3807a;

    public C0705Ua(ErsDisplayFragment ersDisplayFragment, ProgressDialog progressDialog) {
        this.f3807a = ersDisplayFragment;
        this.a = progressDialog;
    }

    public final void onCompleted() {
        SimpleDateFormat simpleDateFormat = ErsDisplayFragment.d;
    }

    public final void onError(Throwable th) {
        this.a.dismiss();
        SimpleDateFormat simpleDateFormat = ErsDisplayFragment.d;
        xx.S(th, true, th);
    }

    public final void onNext(Object obj) {
        Y2 y2 = (Y2) obj;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, MMM dd, yyyy 'at' HH:mm a");
        ProgressDialog progressDialog = this.a;
        ErsDisplayFragment ersDisplayFragment = this.f3807a;
        if (y2 != null) {
            ObjectMapper h = C0657Qt.h();
            try {
                if (y2.getError() == null) {
                    C0813c3 c3Var = TicketHistoryUtil.f5369a;
                    if (c3Var != null) {
                        c3Var.getAllJourney().clear();
                        TicketHistoryUtil.f5369a.getPastJourney().clear();
                        TicketHistoryUtil.f5369a.getUpcomingJourney().clear();
                    } else {
                        TicketHistoryUtil.f5369a = new C0813c3();
                    }
                    h.writeValueAsString(y2.toString());
                    progressDialog.dismiss();
                    FragmentActivity activity = ersDisplayFragment.getActivity();
                    C0535I5.p(activity, false, "Old Boarding Point: " + ersDisplayFragment.f4571a.m(y2.getOldBoardingPoint()) + "\nNew Boarding Point: " + ersDisplayFragment.f4571a.m(y2.getNewBoardingPoint()) + "\nNew Boarding Date: " + simpleDateFormat.format(y2.getNewBoardingDate()), xx.d(4), ersDisplayFragment.getString(R.string.OK), new C0692Ta(this), (String) null, (DialogInterface.OnClickListener) null).show();
                    return;
                }
                progressDialog.dismiss();
                C0535I5.m(ersDisplayFragment.getActivity(), false, y2.getError().split("-")[0], ersDisplayFragment.getString(R.string.error), ersDisplayFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            } catch (Exception e) {
                progressDialog.dismiss();
                SimpleDateFormat simpleDateFormat2 = ErsDisplayFragment.d;
                e.getMessage();
            }
        } else {
            progressDialog.dismiss();
            C0535I5.m(ersDisplayFragment.getActivity(), false, ersDisplayFragment.getResources().getString(R.string.unable_process_message), ersDisplayFragment.getString(R.string.error), ersDisplayFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
    }
}
