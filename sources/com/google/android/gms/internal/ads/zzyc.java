package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzyc {
    public final int zza;
    public final zzli[] zzb;
    public final zzxv[] zzc;
    public final zzck zzd;
    public final Object zze;

    public zzyc(zzli[] zzliArr, zzxv[] zzxvArr, zzck zzck, Object obj) {
        this.zzb = zzliArr;
        this.zzc = (zzxv[]) zzxvArr.clone();
        this.zzd = zzck;
        this.zze = obj;
        this.zza = zzliArr.length;
    }

    public final boolean zza(zzyc zzyc, int i) {
        if (zzyc != null && zzet.zzG(this.zzb[i], zzyc.zzb[i]) && zzet.zzG(this.zzc[i], zzyc.zzc[i])) {
            return true;
        }
        return false;
    }

    public final boolean zzb(int i) {
        if (this.zzb[i] != null) {
            return true;
        }
        return false;
    }
}
