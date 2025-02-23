package defpackage;

import android.widget.EditText;
import java.util.TimerTask;

/* renamed from: so  reason: default package and case insensitive filesystem */
/* compiled from: OtpHelper */
public final class C1392so extends TimerTask {
    public final /* synthetic */ EditText a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C1306oo f6953a;

    /* renamed from: so$a */
    /* compiled from: OtpHelper */
    public class a implements Runnable {
        public a() {
        }

        public final void run() {
            C1392so soVar = C1392so.this;
            soVar.a.setHint("Enter OTP");
            soVar.f6953a.f5641a.setText("Message not detected, please enter OTP (One Time Password)");
        }
    }

    public C1392so(C1306oo ooVar, EditText editText) {
        this.f6953a = ooVar;
        this.a = editText;
    }

    public final void run() {
        this.f6953a.a.runOnUiThread(new a());
    }
}
