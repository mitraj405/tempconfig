package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcvn implements zzcwq, zzddv, zzdbl, zzcxg, zzaxw {
    /* access modifiers changed from: private */
    public final zzcxi zza;
    private final zzfel zzb;
    private final ScheduledExecutorService zzc;
    private final Executor zzd;
    private final zzgdc zze = zzgdc.zze();
    private ScheduledFuture zzf;
    private final AtomicBoolean zzg = new AtomicBoolean();
    private final String zzh;

    public zzcvn(zzcxi zzcxi, zzfel zzfel, ScheduledExecutorService scheduledExecutorService, Executor executor, String str) {
        this.zza = zzcxi;
        this.zzb = zzfel;
        this.zzc = scheduledExecutorService;
        this.zzd = executor;
        this.zzh = str;
    }

    private final boolean zzm() {
        if (this.zzh.equals("com.google.ads.mediation.admob.AdMobAdapter")) {
            return true;
        }
        return false;
    }

    public final void zzc() {
        zzfel zzfel = this.zzb;
        if (zzfel.zze != 3) {
            int i = zzfel.zzY;
            if (i == 0 || i == 1) {
                if (!((Boolean) zzba.zzc().zza(zzbbw.zzkB)).booleanValue() || !zzm()) {
                    this.zza.zza();
                }
            }
        }
    }

    public final void zzdp(zzaxv zzaxv) {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzkB)).booleanValue() && zzm() && zzaxv.zzj && this.zzg.compareAndSet(false, true) && this.zzb.zze != 3) {
            zze.zza("Full screen 1px impression occurred");
            this.zza.zza();
        }
    }

    public final /* synthetic */ void zzh() {
        synchronized (this) {
            if (!this.zze.isDone()) {
                this.zze.zzc(Boolean.TRUE);
            }
        }
    }

    public final synchronized void zzj() {
        if (!this.zze.isDone()) {
            ScheduledFuture scheduledFuture = this.zzf;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            this.zze.zzc(Boolean.TRUE);
        }
    }

    public final void zzk() {
        if (this.zzb.zze != 3) {
            if (((Boolean) zzba.zzc().zza(zzbbw.zzbm)).booleanValue()) {
                zzfel zzfel = this.zzb;
                if (zzfel.zzY != 2) {
                    return;
                }
                if (zzfel.zzq == 0) {
                    this.zza.zza();
                    return;
                }
                zzgcj.zzr(this.zze, new zzcvm(this), this.zzd);
                this.zzf = this.zzc.schedule(new zzcvl(this), (long) this.zzb.zzq, TimeUnit.MILLISECONDS);
            }
        }
    }

    public final synchronized void zzq(com.google.android.gms.ads.internal.client.zze zze2) {
        if (!this.zze.isDone()) {
            ScheduledFuture scheduledFuture = this.zzf;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            this.zze.zzd(new Exception());
        }
    }

    public final void zza() {
    }

    public final void zzb() {
    }

    public final void zze() {
    }

    public final void zzf() {
    }

    public final void zzi() {
    }

    public final void zzl() {
    }

    public final void zzds(zzbvn zzbvn, String str, String str2) {
    }
}
