package cris.org.in.ima.activities;

import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.util.Base64;
import cris.org.in.prs.ima.R;
import java.util.Iterator;
import rx.Subscriber;

/* renamed from: cris.org.in.ima.activities.q  reason: case insensitive filesystem */
/* compiled from: LoginActivity */
public final class C0860q extends Subscriber<Xo> {
    public final /* synthetic */ LoginActivity a;

    public C0860q(LoginActivity loginActivity) {
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
        String next;
        String str;
        Xo xo = (Xo) obj;
        LoginActivity loginActivity = this.a;
        if (xo != null) {
            if (!(xo.getCaptchaDto() == null || xo.getCaptchaDto().getCaptchaQuestion() == null)) {
                byte[] decode = Base64.decode(xo.getCaptchaDto().getCaptchaQuestion().getBytes(), 0);
                loginActivity.captchaCnfPwd.setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
                loginActivity.captchaCnfPwd.setVisibility(0);
                loginActivity.loadingCaptchaCnfPwd.setVisibility(8);
            }
            if (xo.getErrorList() == null) {
                loginActivity.a.dismiss();
                C0535I5.p(this.a, false, xo.getStatus(), loginActivity.getString(R.string.Congratulation), loginActivity.getString(R.string.OK), new Fi(this), (String) null, (DialogInterface.OnClickListener) null).show();
            } else {
                loginActivity.a.dismiss();
                Iterator<String> it = xo.getErrorList().iterator();
                String str2 = "";
                while (it.hasNext() && (next = it.next()) != null) {
                    if (!next.equals("")) {
                        StringBuilder sb = new StringBuilder();
                        String str3 = "* ";
                        if (str2.length() <= 1 || str2.charAt(0) == '*') {
                            str = "";
                        } else {
                            str = str3;
                        }
                        sb.append(str);
                        sb.append(str2);
                        if (str2.length() <= 1) {
                            str3 = "";
                        }
                        str2 = C1058d.B(sb, str3, next, "\n");
                    }
                }
                C0535I5.m(loginActivity, false, str2, loginActivity.getString(R.string.error), loginActivity.getString(R.string.OK), new C0859p(this, str2)).show();
            }
        } else {
            loginActivity.a.dismiss();
            C0535I5.m(loginActivity, false, loginActivity.getResources().getString(R.string.unable_process_message), loginActivity.getString(R.string.error), loginActivity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
        loginActivity.a.dismiss();
    }
}
