package defpackage;

import android.content.Intent;
import com.google.android.gms.common.Scopes;
import com.paytm.pgsdk.sdknative.LoginActivity;
import cris.org.in.ima.activities.UserVerificationActivity;

/* renamed from: Oi  reason: default package */
/* compiled from: LoginWaitActivity */
public final class Oi implements Runnable {
    public final /* synthetic */ JB a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Si f3740a;

    public Oi(Si si, JB jb) {
        this.f3740a = si;
        this.a = jb;
    }

    public final void run() {
        Si si = this.f3740a;
        si.a.finish();
        Intent intent = new Intent(si.a, UserVerificationActivity.class);
        JB jb = this.a;
        intent.putExtra(Scopes.EMAIL, jb.getEmail());
        intent.putExtra("isd", jb.getIsdCode());
        intent.putExtra(LoginActivity.MOBILE_KEY, jb.getMobile());
        intent.putExtra("userName", jb.getUserName());
        intent.putExtra("emailVerified", jb.getEmailVerified());
        intent.putExtra("mobileVerified", jb.getMobileVerified());
        intent.putExtra("gender", jb.getGender());
        intent.putExtra("age", jb.getDob());
        intent.putExtra("isDashBoardLanding", si.a.c);
        intent.putExtra("nationalityid", jb.getNationalityId());
        si.a.startActivity(intent);
    }
}
