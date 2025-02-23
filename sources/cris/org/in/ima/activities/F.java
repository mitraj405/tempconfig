package cris.org.in.ima.activities;

import cris.org.in.prs.ima.R;
import rx.Subscriber;

/* compiled from: RegistrationActivity */
public final class F extends Subscriber<C0726Vq> {
    public final /* synthetic */ RegistrationActivity a;

    public F(RegistrationActivity registrationActivity) {
        this.a = registrationActivity;
    }

    public final void onCompleted() {
        int i = RegistrationActivity.d;
    }

    public final void onError(Throwable th) {
        RegistrationActivity registrationActivity = this.a;
        registrationActivity.m();
        int i = RegistrationActivity.d;
        th.getClass();
        th.getMessage();
        registrationActivity.finish();
        Lt.a(false, th);
    }

    public final void onNext(Object obj) {
        C0726Vq vq = (C0726Vq) obj;
        int i = RegistrationActivity.d;
        RegistrationActivity registrationActivity = this.a;
        if (vq != null) {
            if (vq.getErrorMsg() == null) {
                vq.getLevelDetail().toString();
                registrationActivity.e.clear();
                for (int i2 = 0; i2 < vq.getLevelDetail().size(); i2++) {
                    registrationActivity.e.put(vq.getLevelDetail().get(i2).getLevelName(), vq.getLevelDetail().get(i2).getLevelId().toString());
                    registrationActivity.f4312d.add(vq.getLevelDetail().get(i2).getLevelName());
                }
                registrationActivity.secQuestion.setText(registrationActivity.getString(R.string.security_question));
            } else {
                C0535I5.m(this.a, false, vq.getErrorMsg(), registrationActivity.getString(R.string.error), registrationActivity.getString(R.string.OK), new Us(this)).show();
            }
            registrationActivity.m();
            return;
        }
        C0535I5.m(registrationActivity, false, registrationActivity.getString(R.string.unble_to_request_try_sometime), registrationActivity.getString(R.string.error), registrationActivity.getString(R.string.OK), new C0727Vs(this)).show();
    }
}
