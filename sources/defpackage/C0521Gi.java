package defpackage;

import android.content.DialogInterface;
import cris.org.in.ima.activities.LoginActivity;
import cris.org.in.prs.ima.R;
import rx.Subscriber;

/* renamed from: Gi  reason: default package and case insensitive filesystem */
/* compiled from: LoginActivity */
public final class C0521Gi extends Subscriber<Xo> {
    public final /* synthetic */ LoginActivity a;

    public C0521Gi(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    public final void onCompleted() {
        int i = LoginActivity.e;
        this.a.a.dismiss();
    }

    public final void onError(Throwable th) {
        int i = LoginActivity.e;
        th.getClass();
        th.getMessage();
        this.a.a.dismiss();
        Lt.a(false, th);
    }

    public final void onNext(Object obj) {
        Xo xo = (Xo) obj;
        LoginActivity loginActivity = this.a;
        if (xo == null) {
            loginActivity.a.dismiss();
            C0535I5.m(loginActivity, false, loginActivity.getResources().getString(R.string.unable_process_message), loginActivity.getString(R.string.error), loginActivity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        } else if (xo.getErrorList() == null) {
            loginActivity.a.dismiss();
            C0535I5.o(loginActivity, xo.getStatus(), loginActivity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        } else {
            loginActivity.a.dismiss();
            C0535I5.m(this.a, false, xo.getErrorList().get(0), loginActivity.getString(R.string.error), loginActivity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
    }
}
