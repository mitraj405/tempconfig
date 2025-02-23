package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzla {
    private final zzkz zza;
    private final zzky zzb;
    private final zzcc zzc;
    private int zzd;
    private Object zze;
    private final Looper zzf;
    private final int zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;

    public zzla(zzky zzky, zzkz zzkz, zzcc zzcc, int i, zzdj zzdj, Looper looper) {
        this.zzb = zzky;
        this.zza = zzkz;
        this.zzc = zzcc;
        this.zzf = looper;
        this.zzg = i;
    }

    public final int zza() {
        return this.zzd;
    }

    public final Looper zzb() {
        return this.zzf;
    }

    public final zzkz zzc() {
        return this.zza;
    }

    public final zzla zzd() {
        zzdi.zzf(!this.zzh);
        this.zzh = true;
        this.zzb.zzl(this);
        return this;
    }

    public final zzla zze(Object obj) {
        zzdi.zzf(!this.zzh);
        this.zze = obj;
        return this;
    }

    public final zzla zzf(int i) {
        zzdi.zzf(!this.zzh);
        this.zzd = i;
        return this;
    }

    public final Object zzg() {
        return this.zze;
    }

    public final synchronized void zzh(boolean z) {
        this.zzi = z | this.zzi;
        this.zzj = true;
        notifyAll();
    }

    public final synchronized boolean zzi(long j) throws InterruptedException, TimeoutException {
        boolean z;
        zzdi.zzf(this.zzh);
        if (this.zzf.getThread() != Thread.currentThread()) {
            z = true;
        } else {
            z = false;
        }
        zzdi.zzf(z);
        long elapsedRealtime = SystemClock.elapsedRealtime() + j;
        while (!this.zzj) {
            if (j > 0) {
                wait(j);
                j = elapsedRealtime - SystemClock.elapsedRealtime();
            } else {
                throw new TimeoutException("Message delivery timed out.");
            }
        }
        return this.zzi;
    }

    public final synchronized boolean zzj() {
        return false;
    }
}
