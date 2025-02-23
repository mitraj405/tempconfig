package defpackage;

import android.os.Handler;

/* renamed from: Zo  reason: default package and case insensitive filesystem */
/* compiled from: PasswordHelper */
public final class C0771Zo implements Runnable {
    public final /* synthetic */ C0760Yo a;

    public C0771Zo(C0760Yo yo) {
        this.a = yo;
    }

    public final void run() {
        C0760Yo yo = this.a;
        yo.f3872a.e(C0501Er.passwordHelper, Boolean.TRUE);
        yo.f3869a.findViewById(C0501Er.autoFillerHelperButton).setVisibility(8);
        yo.getClass();
        new Handler().postDelayed(new C0808bp(yo), 200);
    }
}
