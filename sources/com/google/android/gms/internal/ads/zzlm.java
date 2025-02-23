package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzlm implements zzkg {
    private boolean zza;
    private long zzb;
    private long zzc;
    private zzbq zzd = zzbq.zza;

    public zzlm(zzdj zzdj) {
    }

    public final long zza() {
        long j;
        long j2 = this.zzb;
        if (!this.zza) {
            return j2;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzc;
        zzbq zzbq = this.zzd;
        if (zzbq.zzb == 1.0f) {
            j = zzet.zzr(elapsedRealtime);
        } else {
            j = zzbq.zza(elapsedRealtime);
        }
        return j2 + j;
    }

    public final void zzb(long j) {
        this.zzb = j;
        if (this.zza) {
            this.zzc = SystemClock.elapsedRealtime();
        }
    }

    public final zzbq zzc() {
        return this.zzd;
    }

    public final void zzd() {
        if (!this.zza) {
            this.zzc = SystemClock.elapsedRealtime();
            this.zza = true;
        }
    }

    public final void zze() {
        if (this.zza) {
            zzb(zza());
            this.zza = false;
        }
    }

    public final void zzg(zzbq zzbq) {
        if (this.zza) {
            zzb(zza());
        }
        this.zzd = zzbq;
    }

    public final /* synthetic */ boolean zzj() {
        throw null;
    }
}
