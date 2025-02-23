package in.juspay.hypersmshandler;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import org.json.JSONObject;

class SentReceiver extends BroadcastReceiver implements JuspayDuiHook {
    public final SmsComponents a;

    public SentReceiver(SmsComponents smsComponents) {
        this.a = smsComponents;
    }

    public final void attach(Activity activity) {
        if (Build.VERSION.SDK_INT >= 33) {
            activity.registerReceiver(this, new IntentFilter("SMS_SENT"), 2);
        } else {
            activity.registerReceiver(this, new IntentFilter("SMS_SENT"));
        }
    }

    public final void detach(Activity activity) {
        activity.unregisterReceiver(this);
    }

    public final String execute(Activity activity, String str, JSONObject jSONObject) {
        return null;
    }

    public final void onReceive(Context context, Intent intent) {
        this.a.getSmsEventInterface().onSentReceiverEvent(getResultCode());
    }
}
