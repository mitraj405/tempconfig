package defpackage;

import android.content.Intent;
import cris.org.in.ima.activities.PinGenerationActivity;

/* renamed from: Pi  reason: default package */
/* compiled from: LoginWaitActivity */
public final class Pi implements Runnable {
    public final /* synthetic */ JB a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Si f3756a;

    public Pi(Si si, JB jb) {
        this.f3756a = si;
        this.a = jb;
    }

    public final void run() {
        C0582Li li = C0793b1.a.f3909a;
        JB jb = this.a;
        li.b(jb.getUserName(), jb.getTimeStamp());
        Si si = this.f3756a;
        si.a.finish();
        Intent intent = new Intent(si.a, PinGenerationActivity.class);
        intent.putExtra("isDashBoardLanding", si.a.c);
        si.a.startActivity(intent);
    }
}
