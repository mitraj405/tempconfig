package cris.org.in.ima.activities;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.widget.Toast;
import cris.org.in.ima.activities.MoreDrawerActivity;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.StatusDTO;
import rx.Subscriber;

/* compiled from: MoreDrawerActivity */
public final class A extends Subscriber<StatusDTO> {
    public final /* synthetic */ ProgressDialog a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ MoreDrawerActivity.a f4147a;

    public A(MoreDrawerActivity.a aVar, ProgressDialog progressDialog) {
        this.f4147a = aVar;
        this.a = progressDialog;
    }

    public final void onCompleted() {
        int i = MoreDrawerActivity.c;
        this.a.dismiss();
    }

    public final void onError(Throwable th) {
        int i = MoreDrawerActivity.c;
        th.getMessage();
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        MoreDrawerActivity.a aVar = this.f4147a;
        aVar.a.w("OFF");
        MoreDrawerActivity.this.fingerAuthSwitch.setChecked(false);
        Lt.a(false, th);
    }

    public final void onNext(Object obj) {
        StatusDTO statusDTO = (StatusDTO) obj;
        int i = MoreDrawerActivity.c;
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        String message = statusDTO.getMessage();
        MoreDrawerActivity.a aVar = this.f4147a;
        if (message == null) {
            aVar.a.w("OFF");
            MoreDrawerActivity moreDrawerActivity = MoreDrawerActivity.this;
            moreDrawerActivity.fingerAuthSwitch.setChecked(false);
            if (statusDTO.getError() != null) {
                C0535I5.m(moreDrawerActivity.getContext(), false, statusDTO.getError(), moreDrawerActivity.getContext().getString(R.string.error), moreDrawerActivity.getContext().getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                return;
            }
            C0535I5.m(moreDrawerActivity.getContext(), false, moreDrawerActivity.getContext().getResources().getString(R.string.unable_process_message), moreDrawerActivity.getContext().getString(R.string.error), moreDrawerActivity.getContext().getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            return;
        }
        Toast.makeText(MoreDrawerActivity.this.getContext(), MoreDrawerActivity.this.getResources().getString(R.string.finger_print_success_msg3), 0).show();
    }
}
