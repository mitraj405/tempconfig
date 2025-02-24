package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzme;
import com.google.android.gms.measurement.internal.zzmi;

/* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
public final class AppMeasurementService extends Service implements zzmi {
    private zzme<AppMeasurementService> zza;

    private final zzme<AppMeasurementService> zza() {
        if (this.zza == null) {
            this.zza = new zzme<>(this);
        }
        return this.zza;
    }

    public final IBinder onBind(Intent intent) {
        return zza().zza(intent);
    }

    public final void onCreate() {
        super.onCreate();
        zza().zza();
    }

    public final void onDestroy() {
        zza().zzb();
        super.onDestroy();
    }

    public final void onRebind(Intent intent) {
        zza().zzb(intent);
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        return zza().zza(intent, i, i2);
    }

    public final boolean onUnbind(Intent intent) {
        return zza().zzc(intent);
    }

    public final void zza(Intent intent) {
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }

    public final void zza(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    public final boolean zza(int i) {
        return stopSelfResult(i);
    }
}
