package defpackage;

import android.content.Intent;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.activities.LoginWaitActivity;

/* renamed from: Qi  reason: default package */
/* compiled from: LoginWaitActivity */
public final class Qi implements Runnable {
    public final /* synthetic */ JB a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Si f3770a;

    public Qi(Si si, JB jb) {
        this.f3770a = si;
        this.a = jb;
    }

    public final void run() {
        Si si = this.f3770a;
        Intent intent = new Intent(si.a, HomeActivity.class);
        intent.putExtra("isDashBoardLanding", si.a.c);
        C0582Li li = C0793b1.a.f3909a;
        JB jb = this.a;
        String a2 = li.a(jb.getUserName());
        if (a2 != null && a2.length() > 0) {
            C0535I5.f3635d = a2;
        }
        C0535I5.f3616a.a = jb.getShowLastTxn();
        C0535I5.f3616a.f3653a = jb.getLastTxnId();
        C0535I5.f3616a.f3654a = jb.getLastTxnStatus();
        C0535I5.f3616a.f3655a = jb.getLastTxnTimeStamp();
        li.b(jb.getUserName(), jb.getTimeStamp());
        si.a.finish();
        LoginWaitActivity loginWaitActivity = si.a;
        if (loginWaitActivity.c == 0) {
            loginWaitActivity.startActivity(intent);
        }
    }
}
