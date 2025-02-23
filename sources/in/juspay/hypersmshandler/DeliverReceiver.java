package in.juspay.hypersmshandler;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.widget.Toast;
import org.json.JSONObject;

class DeliverReceiver extends BroadcastReceiver implements JuspayDuiHook {
    public final void attach(Activity activity) {
        if (Build.VERSION.SDK_INT >= 33) {
            activity.registerReceiver(this, new IntentFilter("SMS_DELIVERED"), 2);
        } else {
            activity.registerReceiver(this, new IntentFilter("SMS_DELIVERED"));
        }
    }

    public final void detach(Activity activity) {
        activity.unregisterReceiver(this);
    }

    public final String execute(Activity activity, String str, JSONObject jSONObject) {
        return null;
    }

    public final void onReceive(Context context, Intent intent) {
        String str;
        int resultCode = getResultCode();
        if (resultCode == -1) {
            str = "SMS DELIVERED";
        } else if (resultCode == 0) {
            str = "SMS NOT DELIVERED";
        } else {
            return;
        }
        Toast.makeText(context, str, 0).show();
    }
}
