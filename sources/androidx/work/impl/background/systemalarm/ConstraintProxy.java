package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public abstract class ConstraintProxy extends BroadcastReceiver {
    public static final /* synthetic */ int a = 0;

    public static class BatteryChargingProxy extends ConstraintProxy {
    }

    public static class BatteryNotLowProxy extends ConstraintProxy {
    }

    public static class NetworkStateProxy extends ConstraintProxy {
    }

    public static class StorageNotLowProxy extends ConstraintProxy {
    }

    static {
        zi.e("ConstraintProxy");
    }

    public final void onReceive(Context context, Intent intent) {
        zi c = zi.c();
        String.format("onReceive : %s", new Object[]{intent});
        c.a(new Throwable[0]);
        int i = a.c;
        Intent intent2 = new Intent(context, SystemAlarmService.class);
        intent2.setAction("ACTION_CONSTRAINTS_CHANGED");
        context.startService(intent2);
    }
}
