package defpackage;

import android.app.Notification;
import android.os.Build;
import androidx.work.impl.foreground.SystemForegroundService;

/* renamed from: Wy  reason: default package */
/* compiled from: SystemForegroundService */
public final class Wy implements Runnable {
    public final /* synthetic */ Notification a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ SystemForegroundService f671a;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    public Wy(SystemForegroundService systemForegroundService, int i, Notification notification, int i2) {
        this.f671a = systemForegroundService;
        this.c = i;
        this.a = notification;
        this.d = i2;
    }

    public final void run() {
        int i = Build.VERSION.SDK_INT;
        Notification notification = this.a;
        int i2 = this.c;
        SystemForegroundService systemForegroundService = this.f671a;
        if (i >= 29) {
            systemForegroundService.startForeground(i2, notification, this.d);
        } else {
            systemForegroundService.startForeground(i2, notification);
        }
    }
}
