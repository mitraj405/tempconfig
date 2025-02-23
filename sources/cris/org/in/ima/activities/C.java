package cris.org.in.ima.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;
import cris.org.in.ima.activities.PinGenerationActivity;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.StatusDTO;
import rx.Subscriber;

/* compiled from: PinGenerationActivity */
public final class C extends Subscriber<StatusDTO> {
    public final /* synthetic */ ProgressDialog a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ PinGenerationActivity.d f4154a;

    public C(PinGenerationActivity.d dVar, ProgressDialog progressDialog) {
        this.f4154a = dVar;
        this.a = progressDialog;
    }

    public final void onCompleted() {
        int i = PinGenerationActivity.e;
        this.a.dismiss();
    }

    public final void onError(Throwable th) {
        int i = PinGenerationActivity.e;
        th.getMessage();
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        PinGenerationActivity.d dVar = this.f4154a;
        dVar.a.w("OFF");
        PinGenerationActivity.this.fingerAuthSwitch.setChecked(false);
        Lt.a(false, th);
    }

    public final void onNext(Object obj) {
        StatusDTO statusDTO = (StatusDTO) obj;
        int i = PinGenerationActivity.e;
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        String message = statusDTO.getMessage();
        PinGenerationActivity.d dVar = this.f4154a;
        if (message == null) {
            dVar.a.w("OFF");
            PinGenerationActivity pinGenerationActivity = PinGenerationActivity.this;
            pinGenerationActivity.fingerAuthSwitch.setChecked(false);
            if (statusDTO.getError() != null) {
                C0535I5.m(pinGenerationActivity.getBaseContext(), false, statusDTO.getError(), pinGenerationActivity.getBaseContext().getString(R.string.error), pinGenerationActivity.getBaseContext().getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                return;
            }
            C0535I5.m(pinGenerationActivity.getBaseContext(), false, pinGenerationActivity.getBaseContext().getResources().getString(R.string.unable_process_message), pinGenerationActivity.getBaseContext().getString(R.string.error), pinGenerationActivity.getBaseContext().getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            return;
        }
        Context baseContext = PinGenerationActivity.this.getBaseContext();
        PinGenerationActivity pinGenerationActivity2 = PinGenerationActivity.this;
        Toast.makeText(baseContext, pinGenerationActivity2.getResources().getString(R.string.finger_print_success_msg3), 0).show();
        pinGenerationActivity2.onSubmitClick(pinGenerationActivity2.findViewById(R.id.tv_submit));
    }
}
