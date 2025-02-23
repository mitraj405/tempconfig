package cris.org.in.ima.fragment;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.EwalletProfileDTO;
import rx.Subscriber;

/* compiled from: MyAccountFragment */
public final class W extends Subscriber<EwalletProfileDTO> {
    public final /* synthetic */ ProgressDialog a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ MyAccountFragment f5232a;

    public W(MyAccountFragment myAccountFragment, ProgressDialog progressDialog) {
        this.f5232a = myAccountFragment;
        this.a = progressDialog;
    }

    public final void onCompleted() {
        int i = MyAccountFragment.c;
        this.a.dismiss();
    }

    public final void onError(Throwable th) {
        int i = MyAccountFragment.c;
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
        int i = MyAccountFragment.c;
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        MyAccountFragment myAccountFragment = this.f5232a;
        if (ewalletProfileDTO == null) {
            FragmentActivity fragmentActivity = myAccountFragment.f4824a;
            C0535I5.m(fragmentActivity, false, fragmentActivity.getResources().getString(R.string.unable_process_message), myAccountFragment.f4824a.getString(R.string.error), myAccountFragment.f4824a.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        } else if (ewalletProfileDTO.getErrorMessage() != null) {
            myAccountFragment.f4826a = ewalletProfileDTO;
            C0494EB eb = C1450w1.f7006a;
            eb.f3576a = true;
            int i2 = eb.a;
            if (i2 == 0 || i2 == 1) {
                myAccountFragment.ewallet_acc_register_rl.setVisibility(0);
            } else {
                myAccountFragment.ewallet_acc_register_rl.setVisibility(8);
            }
        } else {
            C0535I5.m(myAccountFragment.f4824a, false, ewalletProfileDTO.getErrorMessage(), myAccountFragment.f4824a.getString(R.string.error), myAccountFragment.f4824a.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
    }
}
