package defpackage;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import cris.org.in.ima.activities.LoginWaitActivity;

/* renamed from: cB  reason: default package and case insensitive filesystem */
/* compiled from: UIUpdater */
public final class C0816cB {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final Handler f3931a;

    /* renamed from: a  reason: collision with other field name */
    public final Runnable f3932a;
    public int b;

    /* renamed from: cB$a */
    /* compiled from: UIUpdater */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ Runnable f3933a;

        public a(LoginWaitActivity.b bVar) {
            this.f3933a = bVar;
        }

        public final void run() {
            this.f3933a.run();
            C0816cB cBVar = C0816cB.this;
            cBVar.f3931a.postDelayed(this, (long) cBVar.a);
        }
    }

    public C0816cB(LoginWaitActivity.b bVar) {
        this.f3931a = new Handler(Looper.getMainLooper());
        this.a = 6000;
        this.b = 0;
        this.a = ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;
        this.f3932a = new a(bVar);
    }

    public final synchronized void a() {
        this.f3932a.run();
    }

    public C0816cB(Runnable runnable, int i) {
        this.f3931a = new Handler(Looper.getMainLooper());
        this.a = 6000;
        this.a = i;
        this.b = 0;
        this.f3932a = new C1064dB(this, runnable);
    }
}
