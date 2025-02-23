package defpackage;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import cris.org.in.ima.fragment.TrainDashboardFragment;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.EwalletProfileDTO;
import rx.Subscriber;

/* renamed from: BA  reason: default package and case insensitive filesystem */
/* compiled from: TrainDashboardFragment */
public final class C0458BA extends Subscriber<EwalletProfileDTO> {
    public final /* synthetic */ ProgressDialog a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ TrainDashboardFragment f3529a;

    public C0458BA(TrainDashboardFragment trainDashboardFragment, ProgressDialog progressDialog) {
        this.f3529a = trainDashboardFragment;
        this.a = progressDialog;
    }

    public final void onCompleted() {
        int i = TrainDashboardFragment.c;
        this.a.dismiss();
    }

    public final void onError(Throwable th) {
        int i = TrainDashboardFragment.c;
        th.getClass();
        th.getMessage();
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        Lt.a(false, th);
    }

    public final void onNext(Object obj) {
        EwalletProfileDTO ewalletProfileDTO = (EwalletProfileDTO) obj;
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        TrainDashboardFragment trainDashboardFragment = this.f3529a;
        if (ewalletProfileDTO == null) {
            Context context = trainDashboardFragment.f5164a;
            C0535I5.m(context, false, context.getResources().getString(R.string.unable_process_message), trainDashboardFragment.f5164a.getString(R.string.error), trainDashboardFragment.f5164a.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        } else if (ewalletProfileDTO.getErrorMessage() != null) {
            trainDashboardFragment.f5170a = ewalletProfileDTO;
        } else {
            C0535I5.m(trainDashboardFragment.f5164a, false, ewalletProfileDTO.getErrorMessage(), trainDashboardFragment.f5164a.getString(R.string.error), trainDashboardFragment.f5164a.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
    }
}
