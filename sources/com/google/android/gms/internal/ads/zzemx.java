package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbh;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzemx {
    private final zzdjm zza;
    private final zzemk zzb;
    private final zzcwt zzc;

    public zzemx(zzdjm zzdjm, zzdsk zzdsk) {
        this.zza = zzdjm;
        zzemk zzemk = new zzemk(zzdsk);
        this.zzb = zzemk;
        this.zzc = new zzemw(zzemk, zzdjm.zzg());
    }

    public final zzcwt zza() {
        return this.zzc;
    }

    public final zzcye zzb() {
        return this.zzb;
    }

    public final zzdhg zzc() {
        return new zzdhg(this.zza, this.zzb.zzg());
    }

    public final zzemk zzd() {
        return this.zzb;
    }

    public final void zze(zzbh zzbh) {
        this.zzb.zzj(zzbh);
    }
}
