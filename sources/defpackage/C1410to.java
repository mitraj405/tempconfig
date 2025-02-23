package defpackage;

import defpackage.C1306oo;
import java.util.TimerTask;

/* renamed from: to  reason: default package and case insensitive filesystem */
/* compiled from: OtpHelper */
public final class C1410to extends TimerTask {
    public final /* synthetic */ C1306oo a;

    /* renamed from: to$a */
    /* compiled from: OtpHelper */
    public class a implements Runnable {
        public a() {
        }

        public final void run() {
            C1410to.this.a.b(Boolean.FALSE);
        }
    }

    public C1410to(C1306oo ooVar) {
        this.a = ooVar;
    }

    public final void run() {
        C1306oo.c cVar;
        C1306oo ooVar = this.a;
        ooVar.a.runOnUiThread(new a());
        try {
            if (ooVar.f5643a.booleanValue() && (cVar = ooVar.f5647a) != null) {
                ooVar.a.unregisterReceiver(cVar);
                ooVar.f5643a = Boolean.FALSE;
            }
        } catch (Exception unused) {
        }
    }
}
