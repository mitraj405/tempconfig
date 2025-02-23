package in.juspay.hypersmshandler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

abstract class SmsConsentHandler extends BroadcastReceiver {
    public static final ExecutorService e = Executors.newSingleThreadExecutor();
    public Intent a;
    public final SmsComponents b;
    public final Context c;
    public Runnable d;

    public SmsConsentHandler(SmsComponents smsComponents) {
        this.b = smsComponents;
        this.c = smsComponents.getContext();
        e.execute(new c(this));
    }

    public abstract void c();

    public final void d() {
        Tracker tracker = this.b.getTracker();
        Task<Void> startSmsUserConsent = SmsRetriever.getClient(this.c).startSmsUserConsent((String) null);
        startSmsUserConsent.addOnSuccessListener(new a(tracker));
        startSmsUserConsent.addOnFailureListener(new b(tracker));
    }

    public final void e() {
        e.execute(new d(this));
    }

    public final void onReceive(Context context, Intent intent) {
        Bundle extras;
        int i;
        if (SmsRetriever.SMS_RETRIEVED_ACTION.equals(intent.getAction()) && (extras = intent.getExtras()) != null) {
            Status status = (Status) extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS");
            if (status != null) {
                i = status.getStatusCode();
            } else {
                i = 16;
            }
            if (i == 0) {
                this.a = (Intent) extras.getParcelable(SmsRetriever.EXTRA_CONSENT_INTENT);
                Runnable runnable = this.d;
                if (runnable != null) {
                    runnable.run();
                }
            } else if (i == 15) {
                c();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a() {
        d();
        IntentFilter intentFilter = new IntentFilter(SmsRetriever.SMS_RETRIEVED_ACTION);
        if (Build.VERSION.SDK_INT >= 33) {
            this.c.registerReceiver(this, intentFilter, 2);
        } else {
            this.c.registerReceiver(this, intentFilter);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b() {
        try {
            this.c.unregisterReceiver(this);
        } catch (Exception unused) {
        }
    }
}
