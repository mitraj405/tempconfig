package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzepz implements zzevo {
    private final zzgcu zza;
    private final Context zzb;

    public zzepz(zzgcu zzgcu, Context context) {
        this.zza = zzgcu;
        this.zzb = context;
    }

    @SuppressLint({"UnprotectedReceiver"})
    private final Intent zzd() {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzkb)).booleanValue() || Build.VERSION.SDK_INT < 33) {
            return this.zzb.registerReceiver((BroadcastReceiver) null, intentFilter);
        }
        return this.zzb.registerReceiver((BroadcastReceiver) null, intentFilter, 4);
    }

    private static final boolean zze(Intent intent) {
        if (intent == null) {
            return false;
        }
        int intExtra = intent.getIntExtra("status", -1);
        if (intExtra == 2 || intExtra == 5) {
            return true;
        }
        return false;
    }

    public final int zza() {
        return 14;
    }

    @SuppressLint({"UnprotectedReceiver"})
    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzepy(this));
    }

    public final /* synthetic */ zzeqa zzc() throws Exception {
        boolean z;
        double d = -1.0d;
        if (((Boolean) zzba.zzc().zza(zzbbw.zzlb)).booleanValue()) {
            BatteryManager batteryManager = (BatteryManager) this.zzb.getSystemService("batterymanager");
            if (batteryManager != null) {
                d = ((double) batteryManager.getIntProperty(4)) / 100.0d;
            }
            if (batteryManager != null) {
                z = batteryManager.isCharging();
            } else {
                z = zze(zzd());
            }
        } else {
            Intent zzd = zzd();
            boolean zze = zze(zzd);
            if (zzd != null) {
                d = ((double) zzd.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1)) / ((double) zzd.getIntExtra("scale", -1));
            }
            z = zze;
        }
        return new zzeqa(d, z);
    }
}
