package defpackage;

import androidx.work.impl.foreground.SystemForegroundService;

/* renamed from: Yy  reason: default package */
/* compiled from: SystemForegroundService */
public final class Yy implements Runnable {
    public final /* synthetic */ SystemForegroundService a;
    public final /* synthetic */ int c;

    public Yy(SystemForegroundService systemForegroundService, int i) {
        this.a = systemForegroundService;
        this.c = i;
    }

    public final void run() {
        this.a.a.cancel(this.c);
    }
}
