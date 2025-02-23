package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzehx {
    private final Executor zza;
    private final ScheduledExecutorService zzb;
    private final zzcrx zzc;
    private final zzein zzd;
    private final zzflh zze;
    private final zzgdc zzf = zzgdc.zze();
    private final AtomicBoolean zzg = new AtomicBoolean();
    /* access modifiers changed from: private */
    public zzehy zzh;
    private zzfex zzi;

    public zzehx(Executor executor, ScheduledExecutorService scheduledExecutorService, zzcrx zzcrx, zzein zzein, zzflh zzflh) {
        this.zza = executor;
        this.zzb = scheduledExecutorService;
        this.zzc = zzcrx;
        this.zzd = zzein;
        this.zze = zzflh;
    }

    private final synchronized ListenableFuture zzd(zzfel zzfel) {
        for (String zza2 : zzfel.zza) {
            zzeet zza3 = this.zzc.zza(zzfel.zzb, zza2);
            if (zza3 != null && zza3.zzb(this.zzi, zzfel)) {
                ListenableFuture zza4 = zza3.zza(this.zzi, zzfel);
                int i = zzfel.zzR;
                return zzgcj.zzo(zza4, (long) i, TimeUnit.MILLISECONDS, this.zzb);
            }
        }
        return zzgcj.zzg(new zzdwl(3));
    }

    /* access modifiers changed from: private */
    public final void zze(zzfel zzfel) {
        ListenableFuture zzd2 = zzd(zzfel);
        this.zzd.zzf(this.zzi, zzfel, zzd2, this.zze);
        zzgcj.zzr(zzd2, new zzehw(this, zzfel), this.zza);
    }

    public final synchronized ListenableFuture zzb(zzfex zzfex) {
        if (!this.zzg.getAndSet(true)) {
            if (zzfex.zzb.zza.isEmpty()) {
                this.zzf.zzd(new zzeir(3, zzeiu.zzc(zzfex)));
            } else {
                this.zzi = zzfex;
                this.zzh = new zzehy(zzfex, this.zzd, this.zzf);
                this.zzd.zzk(zzfex.zzb.zza);
                zzfel zza2 = this.zzh.zza();
                while (zza2 != null) {
                    zze(zza2);
                    zza2 = this.zzh.zza();
                }
            }
        }
        return this.zzf;
    }
}
