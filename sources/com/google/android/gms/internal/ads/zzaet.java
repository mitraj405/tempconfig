package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
abstract class zzaet {
    protected final zzadp zza;

    public zzaet(zzadp zzadp) {
        this.zza = zzadp;
    }

    public abstract boolean zza(zzek zzek) throws zzbo;

    public abstract boolean zzb(zzek zzek, long j) throws zzbo;

    public final boolean zzf(zzek zzek, long j) throws zzbo {
        if (!zza(zzek) || !zzb(zzek, j)) {
            return false;
        }
        return true;
    }
}
