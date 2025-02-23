package in.juspay.hypersmshandler;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.Constants;
import com.google.zxing.client.android.Intents;
import in.juspay.hypersmshandler.SmsEventInterface;
import org.json.JSONArray;
import org.json.JSONObject;

class SmsRetriever extends BroadcastReceiver implements JuspayDuiHook {
    public final SmsComponents a;
    public JSONArray b = new JSONArray();
    public boolean c = false;

    public SmsRetriever(SmsComponents smsComponents) {
        this.a = smsComponents;
    }

    public final void attach(Activity activity) {
        Task<Void> startSmsRetriever = com.google.android.gms.auth.api.phone.SmsRetriever.getClient(this.a.getContext()).startSmsRetriever();
        startSmsRetriever.addOnSuccessListener(new f(this, activity));
        startSmsRetriever.addOnFailureListener(new g(this));
    }

    public final void detach(Activity activity) {
        activity.unregisterReceiver(this);
    }

    public final String execute(Activity activity, String str, JSONObject jSONObject) {
        if (str == null) {
            return "FAILURE";
        }
        if (!str.equals("cancel")) {
            if (!str.equals("getOtp")) {
                return "FAILURE";
            }
            JSONArray jSONArray = this.b;
            if (jSONArray != null) {
                if (jSONArray.length() != 0) {
                    this.a.getSmsEventInterface().onSmsRetrieverEvent(SmsEventInterface.RetrieverEvents.ON_EXECUTE, this.b.toString());
                    this.b = new JSONArray();
                    return "SUCCESS";
                } else if (this.c) {
                    this.a.getSmsEventInterface().onSmsRetrieverEvent(SmsEventInterface.RetrieverEvents.ON_EXECUTE, Intents.Scan.TIMEOUT);
                }
            }
        }
        return "SUCCESS";
    }

    public final void onReceive(Context context, Intent intent) {
        Bundle extras;
        int i;
        if (com.google.android.gms.auth.api.phone.SmsRetriever.SMS_RETRIEVED_ACTION.equals(intent.getAction()) && (extras = intent.getExtras()) != null) {
            Status status = (Status) extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS");
            if (status != null) {
                i = status.getStatusCode();
            } else {
                i = 16;
            }
            if (i == 0) {
                String str = (String) extras.get(com.google.android.gms.auth.api.phone.SmsRetriever.EXTRA_SMS_MESSAGE);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(Constants.MessagePayloadKeys.FROM, "UNKNOWN_BANK");
                    jSONObject.put("body", str);
                    jSONObject.put("time", String.valueOf(System.currentTimeMillis()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                JSONArray jSONArray = this.b;
                if (jSONArray != null) {
                    jSONArray.put(jSONObject);
                }
                this.a.getSmsEventInterface().onSmsRetrieverEvent(SmsEventInterface.RetrieverEvents.ON_RECEIVE, this.b.toString());
                this.b = new JSONArray();
            } else if (i == 15) {
                this.c = true;
                this.a.getSmsEventInterface().onSmsRetrieverEvent(SmsEventInterface.RetrieverEvents.ON_RECEIVE, Intents.Scan.TIMEOUT);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Activity activity, Void voidR) {
        IntentFilter intentFilter = new IntentFilter(com.google.android.gms.auth.api.phone.SmsRetriever.SMS_RETRIEVED_ACTION);
        intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
        if (Build.VERSION.SDK_INT >= 33) {
            activity.registerReceiver(this, intentFilter, 2);
        } else {
            activity.registerReceiver(this, intentFilter);
        }
        this.a.getSmsEventInterface().onSmsRetrieverEvent(SmsEventInterface.RetrieverEvents.ON_ATTACH, "SUCCESS");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Exception exc) {
        this.a.getSmsEventInterface().onSmsRetrieverEvent(SmsEventInterface.RetrieverEvents.ON_ATTACH, "FAILURE");
    }
}
