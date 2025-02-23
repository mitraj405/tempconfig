package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.background.systemalarm.ConstraintProxy;

public class ConstraintProxyUpdateReceiver extends BroadcastReceiver {
    public static final /* synthetic */ int a = 0;

    public class a implements Runnable {
        public final /* synthetic */ BroadcastReceiver.PendingResult a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ Context f2665a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ Intent f2666a;

        public a(Intent intent, Context context, BroadcastReceiver.PendingResult pendingResult) {
            this.f2666a = intent;
            this.f2665a = context;
            this.a = pendingResult;
        }

        public final void run() {
            BroadcastReceiver.PendingResult pendingResult = this.a;
            Context context = this.f2665a;
            Intent intent = this.f2666a;
            try {
                boolean booleanExtra = intent.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
                boolean booleanExtra2 = intent.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
                boolean booleanExtra3 = intent.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
                boolean booleanExtra4 = intent.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
                zi c = zi.c();
                int i = ConstraintProxyUpdateReceiver.a;
                String.format("Updating proxies: BatteryNotLowProxy enabled (%s), BatteryChargingProxy enabled (%s), StorageNotLowProxy (%s), NetworkStateProxy enabled (%s)", new Object[]{Boolean.valueOf(booleanExtra), Boolean.valueOf(booleanExtra2), Boolean.valueOf(booleanExtra3), Boolean.valueOf(booleanExtra4)});
                c.a(new Throwable[0]);
                wo.a(context, ConstraintProxy.BatteryNotLowProxy.class, booleanExtra);
                wo.a(context, ConstraintProxy.BatteryChargingProxy.class, booleanExtra2);
                wo.a(context, ConstraintProxy.StorageNotLowProxy.class, booleanExtra3);
                wo.a(context, ConstraintProxy.NetworkStateProxy.class, booleanExtra4);
            } finally {
                pendingResult.finish();
            }
        }
    }

    static {
        zi.e("ConstrntProxyUpdtRecvr");
    }

    public final void onReceive(Context context, Intent intent) {
        String str;
        if (intent != null) {
            str = intent.getAction();
        } else {
            str = null;
        }
        if (!"androidx.work.impl.background.systemalarm.UpdateProxies".equals(str)) {
            zi c = zi.c();
            String.format("Ignoring unknown action %s", new Object[]{str});
            c.a(new Throwable[0]);
            return;
        }
        VD.e(context).f595a.c(new a(intent, context, goAsync()));
    }
}
