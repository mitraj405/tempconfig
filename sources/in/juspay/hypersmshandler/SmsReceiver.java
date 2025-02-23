package in.juspay.hypersmshandler;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.firebase.messaging.Constants;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogCategory;
import in.juspay.hyper.constants.LogLevel;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hypersmshandler.SmsServices;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class SmsReceiver extends BroadcastReceiver implements JuspayDuiHook, OnResultHook {
    public IntentFilter a;
    public final SmsServices b;
    public final Tracker c;

    public SmsReceiver(SmsServices smsServices) {
        this.b = smsServices;
        this.c = smsServices.a().getTracker();
    }

    public final void attach(Activity activity) {
        if (this.a == null) {
            SmsServices smsServices = this.b;
            SmsConsentHandler smsConsentHandler = smsServices.a;
            if (smsConsentHandler == null) {
                this.c.trackAction(LogSubCategory.Action.SYSTEM, "error", "sms_receiver", "missing", "SmsConsentHandler");
                return;
            }
            Intent intent = smsConsentHandler.a;
            if (intent != null) {
                smsServices.b.getSmsEventInterface().onSmsConsentEvent(intent, 11, (Bundle) null);
            }
            smsConsentHandler.d = new e(this, smsConsentHandler);
        } else if (Build.VERSION.SDK_INT >= 33) {
            this.b.b.getContext().registerReceiver(this, this.a, 2);
        } else {
            this.b.b.getContext().registerReceiver(this, this.a);
        }
    }

    public final void detach(Activity activity) {
        try {
            if (this.a == null) {
                SmsConsentHandler smsConsentHandler = this.b.a;
                if (smsConsentHandler != null) {
                    smsConsentHandler.d = null;
                    return;
                }
                return;
            }
            this.b.b.getContext().unregisterReceiver(this);
        } catch (Exception unused) {
        }
    }

    public final String execute(Activity activity, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.has("smsReadStartTime")) {
                    return this.b.a((String) null, jSONObject.getString("smsReadStartTime"), (String) null);
                }
            } catch (JSONException e) {
                this.c.trackAndLogException("SmsReceiver", LogCategory.ACTION, LogSubCategory.Action.SYSTEM, "broadcast_receiver", "Exception while trying to read sms from Inbox: ", e);
                return "[]";
            }
        }
        return this.b.a((String) null, String.valueOf(System.currentTimeMillis() - 60000), (String) null);
    }

    public final boolean onActivityResult(int i, int i2, Intent intent) {
        if (i != 11) {
            return false;
        }
        SmsServices smsServices = this.b;
        SmsConsentHandler smsConsentHandler = smsServices.a;
        if (smsConsentHandler != null) {
            smsConsentHandler.e();
        }
        SmsServices.AnonymousClass2 r0 = new SmsConsentHandler(smsServices.b) {
            public final void c() {
                SmsServices smsServices = SmsServices.this;
                SmsConsentHandler smsConsentHandler = smsServices.a;
                if (smsConsentHandler != null) {
                    smsConsentHandler.e();
                }
                AnonymousClass2 r1 = new AnonymousClass2(smsServices.b);
                smsServices.a = r1;
                r1.d = null;
            }
        };
        smsServices.a = r0;
        r0.d = null;
        if (intent == null) {
            this.b.b.getSmsEventInterface().onActivityResultEvent("DENIED");
            return true;
        }
        if (i2 == -1) {
            String stringExtra = intent.getStringExtra(SmsRetriever.EXTRA_SMS_MESSAGE);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Constants.MessagePayloadKeys.FROM, "UNKNOWN_BANK");
                jSONObject.put("body", stringExtra);
                jSONObject.put("time", String.valueOf(System.currentTimeMillis()));
                this.b.b.getSmsEventInterface().onActivityResultEvent(jSONObject.toString());
                this.c.trackAction(LogSubCategory.Action.SYSTEM, LogLevel.DEBUG, "broadcast_receiver", Labels.Android.ON_ACTIVITY_RESULT, "Response sent back to microapp");
            } catch (JSONException e) {
                this.b.b.getSmsEventInterface().onActivityResultEvent("DENIED");
                this.c.trackAndLogException("SmsReceiver", LogCategory.API_CALL, LogSubCategory.ApiCall.SDK, "sms_consent", "JSON Exception", e);
            }
        } else if (i2 == 0) {
            this.c.trackAction(LogSubCategory.Action.SYSTEM, LogLevel.DEBUG, "broadcast_receiver", Labels.Android.ON_ACTIVITY_RESULT, "User denied SMS consent");
            this.b.b.getSmsEventInterface().onActivityResultEvent("DENIED");
        }
        return true;
    }

    public final void onReceive(Context context, Intent intent) {
        try {
            if ("android.provider.Telephony.SMS_RECEIVED".equals(intent.getAction())) {
                a(intent);
            }
        } catch (Exception e) {
            this.c.trackAndLogException("SmsReceiver", LogCategory.ACTION, LogSubCategory.Action.SYSTEM, "broadcast_receiver", "Failed to receive sms", e);
        }
    }

    /* access modifiers changed from: private */
    public void a(SmsConsentHandler smsConsentHandler) {
        Intent intent = smsConsentHandler.a;
        if (intent != null) {
            this.b.b.getSmsEventInterface().onSmsConsentEvent(intent, 11, (Bundle) null);
        }
    }

    public final void a(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            Object[] objArr = (Object[]) extras.get("pdus");
            int length = objArr != null ? objArr.length : 0;
            SmsMessage[] smsMessageArr = new SmsMessage[length];
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < length; i++) {
                SmsMessage createFromPdu = SmsMessage.createFromPdu((byte[]) objArr[i]);
                smsMessageArr[i] = createFromPdu;
                String originatingAddress = createFromPdu.getOriginatingAddress();
                String upperCase = originatingAddress != null ? originatingAddress.toUpperCase() : "";
                String upperCase2 = smsMessageArr[i].getMessageBody().toUpperCase();
                String valueOf = String.valueOf(smsMessageArr[i].getTimestampMillis());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Constants.MessagePayloadKeys.FROM, upperCase);
                jSONObject.put("body", upperCase2);
                jSONObject.put("time", valueOf);
                jSONArray.put(jSONObject);
            }
            if (jSONArray.length() > 0) {
                this.b.b.getSmsEventInterface().onSmsReceiverEvent(jSONArray.toString());
            }
        }
    }
}
