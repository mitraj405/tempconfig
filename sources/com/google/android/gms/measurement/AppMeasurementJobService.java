package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.measurement.internal.zzme;
import com.google.android.gms.measurement.internal.zzmi;

@TargetApi(24)
/* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
public final class AppMeasurementJobService extends JobService implements zzmi {
    private zzme<AppMeasurementJobService> zza;

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

    public final boolean onStartJob(JobParameters jobParameters) {
        return zza().zza(jobParameters);
    }

    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    public final boolean onUnbind(Intent intent) {
        return zza().zzc(intent);
    }

    public final void zza(Intent intent) {
    }

    private final zzme<AppMeasurementJobService> zza() {
        if (this.zza == null) {
            this.zza = new zzme<>(this);
        }
        return this.zza;
    }

    @TargetApi(24)
    public final void zza(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }

    public final boolean zza(int i) {
        throw new UnsupportedOperationException();
    }
}
