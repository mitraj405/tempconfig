package defpackage;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import cris.org.in.ima.fragment.EwalletRegisterFragment;
import cris.org.in.prs.ima.R;
import rx.Subscriber;

/* renamed from: mb  reason: default package and case insensitive filesystem */
/* compiled from: EwalletRegisterFragment */
public final class C1257mb extends Subscriber<C1215kb> {
    public final /* synthetic */ ProgressDialog a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ EwalletRegisterFragment f5596a;

    public C1257mb(EwalletRegisterFragment ewalletRegisterFragment, ProgressDialog progressDialog) {
        this.f5596a = ewalletRegisterFragment;
        this.a = progressDialog;
    }

    public final void onCompleted() {
        int i = EwalletRegisterFragment.c;
        this.a.dismiss();
    }

    public final void onError(Throwable th) {
        int i = EwalletRegisterFragment.c;
        th.getClass();
        th.getMessage();
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        Lt.a(false, th);
    }

    public final void onNext(Object obj) {
        C1215kb kbVar = (C1215kb) obj;
        int i = EwalletRegisterFragment.c;
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        EwalletRegisterFragment ewalletRegisterFragment = this.f5596a;
        if (kbVar == null) {
            Context context = ewalletRegisterFragment.a;
            C0535I5.m(context, false, context.getResources().getString(R.string.unable_process_message), ewalletRegisterFragment.a.getString(R.string.error), ewalletRegisterFragment.a.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        } else if (kbVar.getPaymentDetailDTO() != null) {
            C0535I5.p(ewalletRegisterFragment.getActivity(), false, ewalletRegisterFragment.getString(R.string.ewallet_account_created_successfully), ewalletRegisterFragment.getString(R.string.Info), ewalletRegisterFragment.getString(R.string.OK), new C1238lb(this), (String) null, (DialogInterface.OnClickListener) null).show();
        } else {
            Context context2 = ewalletRegisterFragment.a;
            C0535I5.m(context2, false, context2.getResources().getString(R.string.unable_process_message), ewalletRegisterFragment.a.getString(R.string.error), ewalletRegisterFragment.a.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
    }
}
