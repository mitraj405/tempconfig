package defpackage;

import android.app.Notification;
import androidx.work.impl.foreground.SystemForegroundService;

/* renamed from: Xy  reason: default package */
/* compiled from: SystemForegroundService */
public final class Xy implements Runnable {
    public final /* synthetic */ Notification a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ SystemForegroundService f689a;
    public final /* synthetic */ int c;

    public Xy(SystemForegroundService systemForegroundService, int i, Notification notification) {
        this.f689a = systemForegroundService;
        this.c = i;
        this.a = notification;
    }

    public final void run() {
        this.f689a.a.notify(this.c, this.a);
    }
}
