package defpackage;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import cris.org.in.ima.fragment.LapAllTrainListFragment;
import cris.org.in.ima.model.TrainBtwnStnsModel;
import cris.org.in.prs.ima.R;
import java.util.Iterator;
import java.util.Objects;
import rx.Subscriber;

/* renamed from: Qh  reason: default package and case insensitive filesystem */
/* compiled from: LapAllTrainListFragment */
public final class C0654Qh extends Subscriber<C1100f2> {
    public final /* synthetic */ ProgressDialog a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ LapAllTrainListFragment f3768a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f3769a = true;

    public C0654Qh(LapAllTrainListFragment lapAllTrainListFragment, ProgressDialog progressDialog) {
        this.f3768a = lapAllTrainListFragment;
        this.a = progressDialog;
    }

    public final void onCompleted() {
        FragmentActivity fragmentActivity = LapAllTrainListFragment.f4691a;
        this.a.dismiss();
        AlertDialog alertDialog = C0535I5.f3619a;
    }

    public final void onError(Throwable th) {
        FragmentActivity fragmentActivity = LapAllTrainListFragment.f4691a;
        th.getMessage();
        this.a.dismiss();
        Lt.a(true, th);
    }

    public final void onNext(Object obj) {
        C1100f2 f2Var = (C1100f2) obj;
        FragmentActivity fragmentActivity = LapAllTrainListFragment.f4691a;
        Objects.toString(f2Var);
        ProgressDialog progressDialog = this.a;
        LapAllTrainListFragment lapAllTrainListFragment = this.f3768a;
        if (f2Var != null) {
            C0657Qt.h();
            try {
                if (f2Var.getErrorMessage() != null) {
                    C0535I5.m(lapAllTrainListFragment.f4697a, false, f2Var.getErrorMessage(), lapAllTrainListFragment.getString(R.string.error), lapAllTrainListFragment.getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                    progressDialog.dismiss();
                    return;
                }
                if (f2Var.getAvlFareResponseDTO() != null) {
                    Iterator<TrainBtwnStnsModel> it = lapAllTrainListFragment.f4714d.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        int i2 = i + 1;
                        it.next().a = f2Var.getAvlFareResponseDTO().get(i);
                        i = i2;
                    }
                    if (this.f3769a) {
                        lapAllTrainListFragment.g(f2Var);
                    }
                }
                progressDialog.dismiss();
            } catch (Exception e) {
                FragmentActivity fragmentActivity2 = LapAllTrainListFragment.f4691a;
                e.getMessage();
                progressDialog.dismiss();
                Context context = lapAllTrainListFragment.f4697a;
                C0535I5.m(context, false, context.getResources().getString(R.string.Unable_process_request), lapAllTrainListFragment.f4697a.getResources().getString(R.string.error), lapAllTrainListFragment.f4697a.getResources().getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
            }
        } else {
            progressDialog.dismiss();
            Context context2 = lapAllTrainListFragment.f4697a;
            C0535I5.m(context2, false, context2.getResources().getString(R.string.Unable_process_request), lapAllTrainListFragment.f4697a.getResources().getString(R.string.error), lapAllTrainListFragment.f4697a.getResources().getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
        }
    }
}
