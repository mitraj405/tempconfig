package cris.org.in.ima.fragment;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.StatusDTO;
import java.util.Iterator;
import rx.Subscriber;

/* compiled from: UpdateProfileFragment */
public final class I0 extends Subscriber<StatusDTO> {
    public final /* synthetic */ ProgressDialog a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ DialogInterface f4657a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ UpdateProfileFragment f4658a;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    public I0(UpdateProfileFragment updateProfileFragment, ProgressDialog progressDialog, ProgressDialog progressDialog2, String str, String str2, String str3) {
        this.f4658a = updateProfileFragment;
        this.a = progressDialog;
        this.f4657a = progressDialog2;
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
        xx.S(th, true, th);
    }

    public final void onNext(Object obj) {
        String next;
        StringBuilder sb;
        StatusDTO statusDTO = (StatusDTO) obj;
        int i = UpdateProfileFragment.c;
        this.a.dismiss();
        UpdateProfileFragment updateProfileFragment = this.f4658a;
        if (statusDTO == null) {
            C0535I5.m(updateProfileFragment.f5185a, false, "Error occurred while processing request. Please try after some time.", updateProfileFragment.getString(R.string.error), updateProfileFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        } else if (statusDTO.getError() == null && (statusDTO.getErrorList() == null || statusDTO.getErrorList().size() == 0)) {
            statusDTO.getUserId();
            this.f4657a.dismiss();
            C0535I5.p(updateProfileFragment.f5185a, true, statusDTO.getStatus(), updateProfileFragment.getString(R.string.Congratulation), updateProfileFragment.getString(R.string.ok), new H0(this), (String) null, (DialogInterface.OnClickListener) null).show();
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
            updateProfileFragment.userInput.setText("");
        } else if (statusDTO.getError() != null) {
            C0535I5.m(updateProfileFragment.f5185a, false, statusDTO.getError(), updateProfileFragment.getString(R.string.error), updateProfileFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        } else {
            C0535I5.m(updateProfileFragment.f5185a, false, "Error occurred while processing request. Please try after some time.", updateProfileFragment.getString(R.string.error), updateProfileFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
    }
}
