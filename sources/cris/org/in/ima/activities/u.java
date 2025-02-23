package cris.org.in.ima.activities;

import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.StatusDTO;
import rx.Subscriber;

/* compiled from: LoginActivity */
public final class u extends Subscriber<StatusDTO> {
    public final /* synthetic */ LoginActivity a;

    public u(LoginActivity loginActivity) {
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
        Lt.a(true, th);
    }

    public final void onNext(Object obj) {
        StatusDTO statusDTO = (StatusDTO) obj;
        LoginActivity loginActivity = this.a;
        if (statusDTO != null) {
            try {
                if (statusDTO.getError() == null) {
                    C1450w1.f7025d = System.currentTimeMillis();
                    Bw.e(loginActivity.getApplication());
                    int i = LoginActivity.e;
                    statusDTO.toString();
                    loginActivity.otp_message.setText(statusDTO.getStatus());
                    loginActivity.otp_message.setVisibility(0);
                    loginActivity.password.setFocusableInTouchMode(true);
                    new t(this).start();
                    loginActivity.a.dismiss();
                } else {
                    C0535I5.m(this.a, false, statusDTO.getError(), loginActivity.getString(R.string.error), loginActivity.getString(R.string.cancel), new C0542Ii()).show();
                }
            } catch (Exception e) {
                int i2 = LoginActivity.e;
                e.getMessage();
                C0535I5.m(this.a, false, e.getMessage(), loginActivity.getString(R.string.error), loginActivity.getString(R.string.OK), new C0555Ji()).show();
            }
        } else {
            C0535I5.m(loginActivity, false, loginActivity.getResources().getString(R.string.unable_process_message), loginActivity.getString(R.string.error), loginActivity.getString(R.string.OK), new C0568Ki()).show();
        }
        loginActivity.a.dismiss();
    }
}
