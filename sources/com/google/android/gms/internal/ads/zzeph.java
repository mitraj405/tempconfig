package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeph implements zzevo {
    final zzbze zza;
    AppSetIdClient zzb;
    private final ScheduledExecutorService zzc;
    private final zzgcu zzd;
    private final Context zze;

    public zzeph(Context context, zzbze zzbze, ScheduledExecutorService scheduledExecutorService, zzgcu zzgcu) {
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzcA)).booleanValue()) {
            this.zzb = AppSet.getClient(context);
        }
        this.zze = context;
        this.zza = zzbze;
        this.zzc = scheduledExecutorService;
        this.zzd = zzgcu;
    }

    public final int zza() {
        return 11;
    }

    public final ListenableFuture zzb() {
        Task<AppSetIdInfo> task;
        if (((Boolean) zzba.zzc().zza(zzbbw.zzcw)).booleanValue()) {
            if (!((Boolean) zzba.zzc().zza(zzbbw.zzcB)).booleanValue()) {
                if (!((Boolean) zzba.zzc().zza(zzbbw.zzcx)).booleanValue()) {
                    return zzgcj.zzm(zzfsf.zza(this.zzb.getAppSetIdInfo(), (CancellationTokenSource) null), new zzepe(), zzbzo.zzf);
                }
                if (((Boolean) zzba.zzc().zza(zzbbw.zzcA)).booleanValue()) {
                    task = zzfgl.zza(this.zze);
                } else {
                    task = this.zzb.getAppSetIdInfo();
                }
                if (task == null) {
                    return zzgcj.zzh(new zzepi((String) null, -1));
                }
                ListenableFuture zzn = zzgcj.zzn(zzfsf.zza(task, (CancellationTokenSource) null), new zzepf(), zzbzo.zzf);
                if (((Boolean) zzba.zzc().zza(zzbbw.zzcy)).booleanValue()) {
                    zzn = zzgcj.zzo(zzn, ((Long) zzba.zzc().zza(zzbbw.zzcz)).longValue(), TimeUnit.MILLISECONDS, this.zzc);
                }
                return zzgcj.zze(zzn, Exception.class, new zzepg(this), this.zzd);
            }
        }
        return zzgcj.zzh(new zzepi((String) null, -1));
    }
}
