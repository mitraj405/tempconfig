package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Tasks;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzexl implements zzevo {
    private final zzbze zza;
    private final ScheduledExecutorService zzb;
    private final zzgcu zzc;

    public zzexl(String str, zzazy zzazy, zzbze zzbze, ScheduledExecutorService scheduledExecutorService, zzgcu zzgcu) {
        this.zza = zzbze;
        this.zzb = scheduledExecutorService;
        this.zzc = zzgcu;
    }

    public final int zza() {
        return 43;
    }

    public final ListenableFuture zzb() {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzcw)).booleanValue()) {
            if (((Boolean) zzba.zzc().zza(zzbbw.zzcB)).booleanValue()) {
                ListenableFuture zzn = zzgcj.zzn(zzfsf.zza(Tasks.forResult(null), (CancellationTokenSource) null), new zzexj(), this.zzc);
                if (((Boolean) zzbdf.zza.zze()).booleanValue()) {
                    zzn = zzgcj.zzo(zzn, ((Long) zzbdf.zzb.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzb);
                }
                return zzgcj.zze(zzn, Exception.class, new zzexk(this), this.zzc);
            }
        }
        return zzgcj.zzh(new zzexm((String) null, -1));
    }

    public final /* synthetic */ zzexm zzc(Exception exc) {
        this.zza.zzw(exc, "AppSetIdInfoGmscoreSignal");
        return new zzexm((String) null, -1);
    }
}
