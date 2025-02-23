package cris.org.in.ima.activities;

import cris.org.in.prs.ima.R;
import rx.Subscriber;

/* compiled from: RegistrationActivity */
public final class G extends Subscriber<C0726Vq> {
    public final /* synthetic */ RegistrationActivity a;

    public G(RegistrationActivity registrationActivity) {
        this.a = registrationActivity;
    }

    public final void onCompleted() {
        int i = RegistrationActivity.d;
        this.a.m();
    }

    public final void onError(Throwable th) {
        int i = RegistrationActivity.d;
        th.getClass();
        th.getMessage();
        this.a.finish();
        Lt.a(false, th);
    }

    public final void onNext(Object obj) {
        C0726Vq vq = (C0726Vq) obj;
        int i = RegistrationActivity.d;
        RegistrationActivity registrationActivity = this.a;
        if (vq != null) {
            if (vq.getErrorMsg() == null) {
                vq.getLevelDetail().toString();
                registrationActivity.f4313d.clear();
                for (int i2 = 0; i2 < vq.getLevelDetail().size(); i2++) {
                    registrationActivity.f4313d.put(vq.getLevelDetail().get(i2).getLevelName(), vq.getLevelDetail().get(i2).getLevelId().toString());
                    registrationActivity.f4308c.add(vq.getLevelDetail().get(i2).getLevelName());
                }
                registrationActivity.occupation.setText(registrationActivity.getString(R.string.occupation));
            } else {
                C0535I5.m(this.a, false, vq.getErrorMsg(), registrationActivity.getString(R.string.error), registrationActivity.getString(R.string.OK), new Ws(this)).show();
            }
            registrationActivity.m();
            return;
        }
        C0535I5.m(registrationActivity, false, registrationActivity.getString(R.string.unable_process), registrationActivity.getString(R.string.error), registrationActivity.getString(R.string.OK), new Xs(this)).show();
    }
}
