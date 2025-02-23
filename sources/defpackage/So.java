package defpackage;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import cris.org.in.ima.fragment.PassengerDetailFragment;
import cris.org.in.prs.ima.R;
import rx.Subscriber;

/* renamed from: So  reason: default package */
/* compiled from: PassengerDetailFragment */
public final class So extends Subscriber<C1100f2> {
    public final /* synthetic */ ProgressDialog a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ PassengerDetailFragment f3790a;

    public So(PassengerDetailFragment passengerDetailFragment, ProgressDialog progressDialog) {
        this.f3790a = passengerDetailFragment;
        this.a = progressDialog;
    }

    public final void onCompleted() {
        TextView textView = PassengerDetailFragment.a;
        AlertDialog alertDialog = C0535I5.f3619a;
        this.a.dismiss();
    }

    public final void onError(Throwable th) {
        TextView textView = PassengerDetailFragment.a;
        th.getClass();
        th.getMessage();
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        Lt.a(true, th);
    }

    public final void onNext(Object obj) {
        String str;
        C1100f2 f2Var = (C1100f2) obj;
        ProgressDialog progressDialog = this.a;
        PassengerDetailFragment passengerDetailFragment = this.f3790a;
        if (f2Var != null) {
            C0657Qt.h();
            try {
                if (f2Var.getErrorMessage() != null) {
                    String replace = f2Var.getErrorMessage().replace("coachId", "coach Id");
                    if (progressDialog != null && progressDialog.isShowing()) {
                        progressDialog.dismiss();
                    }
                    if (replace.contains("50035")) {
                        if (C1450w1.f7013a == 3) {
                            str = passengerDetailFragment.getString(R.string.your_account_has_been_suspended);
                        } else {
                            str = replace.split("-")[0];
                        }
                        C0535I5.m(passengerDetailFragment.getActivity(), false, str, passengerDetailFragment.getString(R.string.error), passengerDetailFragment.getString(R.string.OK), new Ro(this)).show();
                        return;
                    }
                    if (!replace.contains("55002")) {
                        if (!replace.contains("55001")) {
                            C0535I5.m(passengerDetailFragment.getActivity(), false, replace, passengerDetailFragment.getString(R.string.error), passengerDetailFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                            return;
                        }
                    }
                    FragmentActivity activity = passengerDetailFragment.getActivity();
                    String str2 = replace.split("-")[0];
                    C0535I5.m(activity, false, str2, passengerDetailFragment.getString(R.string.error), passengerDetailFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                } else if (f2Var.getConfirmation() != null) {
                    progressDialog.dismiss();
                    C0535I5.p(passengerDetailFragment.f4904a, false, f2Var.getConfirmation(), passengerDetailFragment.getString(R.string.retry_confirmation), passengerDetailFragment.getString(R.string.yes), new Po(this, f2Var), passengerDetailFragment.getString(R.string.no), new Qo(this)).show();
                } else {
                    passengerDetailFragment.D0(f2Var);
                }
            } catch (Exception e) {
                TextView textView = PassengerDetailFragment.a;
                e.getMessage();
                progressDialog.dismiss();
                C0535I5.t0(passengerDetailFragment.getActivity(), passengerDetailFragment.getResources().getString(R.string.unable_process_message));
            }
        } else {
            progressDialog.dismiss();
            C0535I5.m(passengerDetailFragment.getActivity(), false, passengerDetailFragment.getResources().getString(R.string.unable_process_message), passengerDetailFragment.getString(R.string.error), passengerDetailFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
    }
}
