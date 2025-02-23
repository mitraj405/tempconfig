package defpackage;

import android.app.Notification;
import android.os.Bundle;

/* renamed from: Vm  reason: default package */
/* compiled from: NotificationCompat */
public final class Vm extends Ym {
    public CharSequence c;

    public final void a(Bundle bundle) {
        super.a(bundle);
    }

    public final void b(Zm zm) {
        Notification.BigTextStyle bigText = new Notification.BigTextStyle(zm.a).setBigContentTitle(this.f713a).bigText(this.c);
        if (this.f714a) {
            bigText.setSummaryText(this.b);
        }
    }

    public final String c() {
        return "androidx.core.app.NotificationCompat$BigTextStyle";
    }
}
