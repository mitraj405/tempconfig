package com.momagic;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.momagic.B;
import java.util.HashMap;
import org.json.JSONObject;

public class NotificationDismissedReceiver extends BroadcastReceiver {
    public static void a(Context context, Bundle bundle) {
        if (context != null) {
            C1139gq c = C1139gq.c(context);
            try {
                if (!c.b().isEmpty() && !c.e("deviceToken").isEmpty()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("pid", c.b());
                    hashMap.put("ver", "2.4.0");
                    hashMap.put("cid", bundle.getString("cid"));
                    hashMap.put("bKey", H.g(context));
                    hashMap.put("rid", bundle.getString("rid"));
                    hashMap.put("push_type", bundle.getString("push_type"));
                    hashMap.put("type", c.e("type"));
                    hashMap.put("op", "dismiss");
                    B.c("https://dsp.izooto.com/dsp", hashMap, (JSONObject) null, new a());
                    C1104f8.b(context, hashMap.toString(), "Notification dismiss listener is not working");
                }
            } catch (Exception e) {
                H.r(context, e.toString(), "NotificationDismissedReceiver", "Notification dismiss listener is not working");
            }
        }
    }

    public final void onReceive(Context context, Intent intent) {
        if (context != null) {
            try {
                context.sendBroadcast(new Intent("15"));
                Bundle extras = intent.getExtras();
                ((NotificationManager) context.getSystemService("notification")).cancel(extras.getInt("keyNotificationId"));
                a(context, extras);
            } catch (Exception e) {
                H.r(context, e.toString(), "NotificationDismissedReceiver", "Notification dismiss listener is not working");
            }
        }
    }

    public class a extends B.b {
        public final void b(String str) {
        }

        public final void a(int i, String str) {
        }
    }
}
