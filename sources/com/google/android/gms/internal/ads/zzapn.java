package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzapn {
    public final Object zza;
    public final zzaoq zzb;
    public final zzapq zzc;
    public boolean zzd;

    private zzapn(zzapq zzapq) {
        this.zzd = false;
        this.zza = null;
        this.zzb = null;
        this.zzc = zzapq;
    }

    public static zzapn zza(zzapq zzapq) {
        return new zzapn(zzapq);
    }

    public static zzapn zzb(Object obj, zzaoq zzaoq) {
        return new zzapn(obj, zzaoq);
    }

    public final boolean zzc() {
        if (this.zzc == null) {
            return true;
        }
        return false;
    }

    private zzapn(Object obj, zzaoq zzaoq) {
        this.zzd = false;
        this.zza = obj;
        this.zzb = zzaoq;
        this.zzc = null;
    }
}
