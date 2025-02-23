package defpackage;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.widget.TextView;
import cris.org.in.ima.fragment.VikalpSystemFragment;
import cris.org.in.prs.ima.R;
import rx.Subscriber;

/* renamed from: dD  reason: default package and case insensitive filesystem */
/* compiled from: VikalpSystemFragment */
public final class C1065dD extends Subscriber<C0750Xx> {
    public final /* synthetic */ ProgressDialog a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Context f5433a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ TextView f5434a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ VikalpSystemFragment f5435a;

    public C1065dD(VikalpSystemFragment vikalpSystemFragment, ProgressDialog progressDialog, TextView textView, Context context) {
        this.f5435a = vikalpSystemFragment;
        this.a = progressDialog;
        this.f5434a = textView;
        this.f5433a = context;
    }

    public final void onCompleted() {
        int i = VikalpSystemFragment.c;
        this.a.dismiss();
    }

    public final void onError(Throwable th) {
        this.a.dismiss();
        int i = VikalpSystemFragment.c;
        th.getClass();
        th.getMessage();
        int color = this.f5435a.f5199a.getResources().getColor(R.color.PrimaryColor);
        TextView textView = this.f5434a;
        textView.setTextColor(color);
        textView.setClickable(true);
        Mt.a(th);
    }

    public final void onNext(Object obj) {
        C0750Xx xx = (C0750Xx) obj;
        ProgressDialog progressDialog = this.a;
        progressDialog.dismiss();
        TextView textView = this.f5434a;
        VikalpSystemFragment vikalpSystemFragment = this.f5435a;
        if (xx == null) {
            int i = VikalpSystemFragment.c;
            C0535I5.m(this.f5433a, false, vikalpSystemFragment.getString(R.string.unble_to_request_try_sometime), vikalpSystemFragment.getString(R.string.error), vikalpSystemFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            textView.setTextColor(vikalpSystemFragment.f5199a.getResources().getColor(R.color.PrimaryColor));
            textView.setClickable(true);
        } else if (!xx.isErrorFlag()) {
            int i2 = VikalpSystemFragment.c;
            C0535I5.o(this.f5433a, vikalpSystemFragment.getString(R.string.msg_otp_sent), "OK", (DialogInterface.OnClickListener) null).show();
            new Handler().postDelayed(new C0797bD(this), 5000);
        } else {
            progressDialog.dismiss();
            textView.setClickable(false);
            C1058d.H(vikalpSystemFragment.f5199a, R.color.black_50_opa, textView);
            C0535I5.m(vikalpSystemFragment.f5199a, false, xx.getErrorMsg(), vikalpSystemFragment.getString(R.string.error), vikalpSystemFragment.getString(R.string.OK), new C0817cD()).show();
        }
    }
}
