package com.google.zxing.client.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

public final class InactivityTimer {
    private static final long INACTIVITY_DELAY_MS = 300000;
    private static final String TAG = "InactivityTimer";
    private Runnable callback;
    private final Context context;
    /* access modifiers changed from: private */
    public Handler handler;
    private boolean onBattery;
    private final BroadcastReceiver powerStatusReceiver;
    private boolean registered = false;

    public final class PowerStatusReceiver extends BroadcastReceiver {
        private PowerStatusReceiver() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceive$0(boolean z) {
            InactivityTimer.this.onBattery(z);
        }

        public void onReceive(Context context, Intent intent) {
            boolean z;
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                if (intent.getIntExtra("plugged", -1) <= 0) {
                    z = true;
                } else {
                    z = false;
                }
                InactivityTimer.this.handler.post(new a(this, z));
            }
        }
    }

    public InactivityTimer(Context context2, Runnable runnable) {
        this.context = context2;
        this.callback = runnable;
        this.powerStatusReceiver = new PowerStatusReceiver();
        this.handler = new Handler();
    }

    private void cancelCallback() {
        this.handler.removeCallbacksAndMessages((Object) null);
    }

    /* access modifiers changed from: private */
    public void onBattery(boolean z) {
        this.onBattery = z;
        if (this.registered) {
            activity();
        }
    }

    private void registerReceiver() {
        if (!this.registered) {
            this.context.registerReceiver(this.powerStatusReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            this.registered = true;
        }
    }

    private void unregisterReceiver() {
        if (this.registered) {
            this.context.unregisterReceiver(this.powerStatusReceiver);
            this.registered = false;
        }
    }

    public void activity() {
        cancelCallback();
        if (this.onBattery) {
            this.handler.postDelayed(this.callback, INACTIVITY_DELAY_MS);
        }
    }

    public void cancel() {
        cancelCallback();
        unregisterReceiver();
    }

    public void start() {
        registerReceiver();
        activity();
    }
}
