package defpackage;

import android.app.Notification;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: Xm  reason: default package */
/* compiled from: NotificationCompat */
public final class Xm extends Ym {
    public final ArrayList<CharSequence> a = new ArrayList<>();

    public final void b(Zm zm) {
        Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(zm.a).setBigContentTitle(this.f713a);
        if (this.f714a) {
            bigContentTitle.setSummaryText(this.b);
        }
        Iterator<CharSequence> it = this.a.iterator();
        while (it.hasNext()) {
            bigContentTitle.addLine(it.next());
        }
    }

    public final String c() {
        return "androidx.core.app.NotificationCompat$InboxStyle";
    }
}
