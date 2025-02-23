package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class RescheduleReceiver extends BroadcastReceiver {
    static {
        zi.e("RescheduleReceiver");
    }

    public final void onReceive(Context context, Intent intent) {
        zi c = zi.c();
        String.format("Received intent %s", new Object[]{intent});
        c.a(new Throwable[0]);
        try {
            VD e = VD.e(context);
            BroadcastReceiver.PendingResult goAsync = goAsync();
            e.getClass();
            synchronized (VD.f590a) {
                e.f591a = goAsync;
                if (e.f599a) {
                    goAsync.finish();
                    e.f591a = null;
                }
            }
        } catch (IllegalStateException e2) {
            zi.c().b(e2);
        }
    }
}
