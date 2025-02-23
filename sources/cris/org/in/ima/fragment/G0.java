package cris.org.in.ima.fragment;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.widget.TextView;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.StatusDTO;
import java.util.Iterator;
import rx.Subscriber;

/* compiled from: UpdateProfileFragment */
public final class G0 extends Subscriber<StatusDTO> {
    public final /* synthetic */ ProgressDialog a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ TextView f4647a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ UpdateProfileFragment f4648a;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    public G0(UpdateProfileFragment updateProfileFragment, ProgressDialog progressDialog, TextView textView, String str, String str2, String str3) {
        this.f4648a = updateProfileFragment;
        this.a = progressDialog;
        this.f4647a = textView;
        this.c = str;
        this.d = str2;
        this.e = str3;
    }

    public final void onCompleted() {
        int i = UpdateProfileFragment.c;
        this.a.dismiss();
    }

    public final void onError(Throwable th) {
        this.a.dismiss();
        int i = UpdateProfileFragment.c;
        th.getClass();
        th.getMessage();
        int color = this.f4648a.f5185a.getResources().getColor(R.color.light_grey);
        TextView textView = this.f4647a;
        textView.setTextColor(color);
        textView.setClickable(true);
        Lt.a(true, th);
    }

    public final void onNext(Object obj) {
        String next;
        StringBuilder sb;
        StatusDTO statusDTO = (StatusDTO) obj;
        int i = UpdateProfileFragment.c;
        this.a.dismiss();
        UpdateProfileFragment updateProfileFragment = this.f4648a;
        if (statusDTO == null) {
            C0535I5.m(updateProfileFragment.f5185a, false, "Error occurred while processing request. Please try after some time.", updateProfileFragment.getString(R.string.error), updateProfileFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        } else if (statusDTO.getError() == null && (statusDTO.getErrorList() == null || statusDTO.getErrorList().size() == 0)) {
            statusDTO.getUserId();
            updateProfileFragment.otpLayout.setVisibility(0);
            updateProfileFragment.f5193d = true;
            if (this.c.equals("E")) {
                TextView textView = updateProfileFragment.otpInputLabel;
                textView.setText(updateProfileFragment.getString(R.string.email_otp) + " " + C0535I5.d0(this.d));
                return;
            }
            TextView textView2 = updateProfileFragment.otpInputLabel;
            textView2.setText(updateProfileFragment.getString(R.string.mobile_otp) + " " + C0535I5.e0(this.e));
        } else if (statusDTO.getErrorList() != null && statusDTO.getErrorList().size() > 0) {
            Iterator<String> it = statusDTO.getErrorList().iterator();
            String str = "";
            while (it.hasNext() && (next = it.next()) != null) {
                if (!next.equals("")) {
                    if (str.equals("")) {
                        sb = new StringBuilder();
                    } else {
                        sb = xx.J(str);
                        str = "* ";
                    }
                    str = C1058d.B(sb, str, next, "\n");
                }
            }
            int i2 = UpdateProfileFragment.c;
            C0535I5.m(updateProfileFragment.f5185a, false, str, updateProfileFragment.getString(R.string.error), updateProfileFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        } else if (statusDTO.getError() != null) {
            C0535I5.m(updateProfileFragment.f5185a, false, statusDTO.getError(), updateProfileFragment.getString(R.string.error), updateProfileFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        } else {
            C0535I5.m(updateProfileFragment.f5185a, false, "Error occurred while processing request. Please try after some time.", updateProfileFragment.getString(R.string.error), updateProfileFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
    }
}
